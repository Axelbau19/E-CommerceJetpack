import { Body, Controller, Post } from '@nestjs/common';
import { CreateUserDTO } from './dto/create-user.dto';
import { UsersService } from './users.service';

@Controller('users')
export class UsersController {
    constructor(private UsersService: UsersService){

    }

    //GET -> Read
    //Post -> Create
    //Put -> Update
    //Delete -> Delete

    //Register
    @Post('register')
    create(@Body() user:CreateUserDTO){
        return this.UsersService.create(user);
    }
}
