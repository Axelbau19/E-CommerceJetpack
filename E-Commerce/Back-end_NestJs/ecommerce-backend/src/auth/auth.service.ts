import { HttpException, HttpStatus, Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from 'src/users/user.entity';
import { In, Repository } from 'typeorm';
import { RegisterUserDTO } from './dto/register-user.dto';
import { LoginAuthDto } from './dto/login-auth.dto';
import {compare} from 'bcrypt';
import { JwtService } from '@nestjs/jwt';
import { Rol } from 'src/roles/rol.entity';

//Function about client (Funciones para el cliente, como iniciar sesion o registrarse)
@Injectable()
export class AuthService {
    constructor(@InjectRepository(User) private usersRepository: Repository<User>,
    @InjectRepository(Rol) private rolRepository: Repository<Rol>,
    private jwtService: JwtService){}

    async register(user: RegisterUserDTO){
        const {email,phone} = user;
        const emailExist = await this.usersRepository.findOneBy({email: email});
        if(emailExist){
            //409 Duplicated email (Email duplicado)
            return new HttpException('Email duplicado',HttpStatus.CONFLICT);
        }
            //Duplicate Number Phone (Numero telefono duplicado)
        const phoneNumberExist = await this.usersRepository.findOneBy({phone: phone})
        if(phoneNumberExist){
            return new HttpException('Número de telefono duplicado',HttpStatus.CONFLICT)
        }
        const newUser = this.usersRepository.create(user);
        const rolesIds = user.rolesIds;
        const roles = await this.rolRepository.findBy({id: In(rolesIds)})
        newUser.roles = roles;
        const userSave = await this.usersRepository.save(newUser)
        const rolesString = userSave.roles.map(rol => rol.id )
                //create a token (Creación de Token)
                const payloadData= {
                    id: userSave.id,
                    name: userSave.name,
                    roles: rolesString
                }
        
                const token = this.jwtService.sign(payloadData)
        
                const data = {
                    user:userSave,
                    token: 'Bearer ' + token
                }
                
                delete data.user.password;
        
                return data;
    }

    async login(loginData: LoginAuthDto){
        //Get properties(obtener propiedades)
        const {email, password} = loginData
        const userGet = await this.usersRepository.findOne({
            where: {email: email},
            relations : ['roles']
        })
        if(!userGet){
            return new HttpException('El email no esta registrado',HttpStatus.NOT_FOUND) 
        }
        //403 the password is invalid (La contraseña es invalida)
        const validPassword = await compare(password, userGet.password);
        if(!validPassword){
            return new HttpException('La contraseña no es la correcta',HttpStatus.FORBIDDEN)
        }
        //Protect the user's route with him rol (Protegiendo la ruta del usuario de acuerdo con su rol).

        const rolesId = userGet.roles.map(rol => rol.id) // this has created an array what has roles by user (Crea un arreglo donde se almacena los roles del usuario)



        //create a token (Creación de Token)
        const payloadData= {
            id: userGet.id,
            name: userGet.name,
            roles: rolesId
        }

        const token = this.jwtService.sign(payloadData)

        const data = {
            user:userGet,
            token: 'Bearer ' + token
        }
        
        delete data.user.password;

        return data;
    }
}
