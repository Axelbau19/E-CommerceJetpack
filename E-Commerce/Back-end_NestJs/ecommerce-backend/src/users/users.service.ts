import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from './user.entity';
import { Repository } from 'typeorm';
import { CreateUserDTO } from './dto/create-user.dto';
//Comentario
@Injectable()
export class UsersService {
    constructor(@InjectRepository(User) private usersRepository: Repository<User>){}

    
    create(user: CreateUserDTO){
        const newUser = this.usersRepository.create(user);
        return this.usersRepository.save(newUser);
    }
}
