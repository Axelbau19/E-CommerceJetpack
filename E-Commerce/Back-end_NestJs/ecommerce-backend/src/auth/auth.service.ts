import { HttpException, HttpStatus, Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from 'src/users/user.entity';
import { Repository } from 'typeorm';
import { RegisterUserDTO } from './dto/register-user.dto';
import { LoginAuthDto } from './dto/login-auth.dto';
import {compare} from 'bcrypt';

//Function about client (Funciones para el cliente, como iniciar sesion o registrarse)
@Injectable()
export class AuthService {
    constructor(@InjectRepository(User) private usersRepository: Repository<User>){}

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
        return this.usersRepository.save(newUser)
    }

    async login(loginData: LoginAuthDto){
        //Get properties(obtener propiedades)
        const {email, password} = loginData
        const userGet = await this.usersRepository.findOneBy({email:email})
        if(!userGet){
            return new HttpException('El email no esta registrado',HttpStatus.NOT_FOUND) 
        }
        //403 the password is invalid 
        const validPassword = await compare(password, userGet.password);
        if(!validPassword){
            return new HttpException('La contraseña no es la correcta',HttpStatus.FORBIDDEN)
        } 
        return userGet;
    }
}
