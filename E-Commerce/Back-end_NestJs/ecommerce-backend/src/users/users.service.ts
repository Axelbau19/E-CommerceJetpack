import { HttpException, HttpStatus, Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from './user.entity';
import { Repository } from 'typeorm';
import { CreateUserDTO } from './dto/create-user.dto';
import { UpdateUserDto } from 'src/auth/dto/update-user.dto';
import { Http2ServerRequest } from 'http2';
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
        return this.usersRepository.find()
    }

    //Update (Actualizar la información)

    async update(id: number, userUpdate: UpdateUserDto){
         const userGet = await this.usersRepository.findOneBy({id:id})
         if(!userGet){
            //Error 404 (Información no encontrada o ruta no encontrada)
            return new HttpException('No existe el usuario', HttpStatus.NOT_FOUND);
         }
         const updateUser = Object.assign(userGet,userUpdate);
         return this.usersRepository.save(updateUser)

    }

<<<<<<< HEAD
    //Upload a image by the user

    async updateImageUser(image: Express.Multer.File){
        
    }

=======
>>>>>>> main
}
