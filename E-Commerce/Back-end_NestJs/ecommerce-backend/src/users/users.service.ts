import { HttpException, HttpStatus, Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from './user.entity';
import { Repository } from 'typeorm';
import { CreateUserDTO } from './dto/create-user.dto';
import { UpdateUserDto } from 'src/auth/dto/update-user.dto';
import storage = require ('../utils/cloud_storage');

//Comentario
@Injectable()
export class UsersService {
    constructor(@InjectRepository(User) private usersRepository: Repository<User>){}

    
    create(user: CreateUserDTO){
        const newUser = this.usersRepository.create(user);
        return this.usersRepository.save(newUser);
    }
    //Func to get users 
    getAllUsers(){
        return this.usersRepository.find({relations:['roles']})
    }

    //Update (Actualizar la información)

    async update(id: number, userUpdate: UpdateUserDto){
         const userGet = await this.usersRepository.findOneBy({id:id})
         if(!userGet){
            //Error 404 (Información no encontrada o ruta no encontrada)
            throw new HttpException('No existe el usuario', HttpStatus.NOT_FOUND);
         }
         const updateUser = Object.assign(userGet,userUpdate);
         return this.usersRepository.save(updateUser)

    }

    //Upload a image by the user with firebase google (Subir imagenes a un servicio de google)

    async updateImageUser(image: Express.Multer.File, idUser:number, userUpdate: UpdateUserDto){
        //
        const urlImage = await storage(image,image.originalname);
        console.log('url ' + urlImage);
        if(urlImage === undefined && urlImage === null){
            // Error 500 server error 
            throw new HttpException ('No existe la imagén  o no se encuentra',HttpStatus.INTERNAL_SERVER_ERROR)
        }
        const userGet = await this.usersRepository.findOneBy({id:idUser})
        if(!userGet){
           //Error 404 (Información no encontrada o ruta no encontrada)
           throw new HttpException('No existe el usuario', HttpStatus.NOT_FOUND);
        }
        userUpdate.image = urlImage;
        const updateUser = Object.assign(userGet,userUpdate);
        return this.usersRepository.save(updateUser)
    }
}
