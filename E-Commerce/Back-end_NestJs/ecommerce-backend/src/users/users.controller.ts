import { Body, Controller, Get, Post, UseGuards } from '@nestjs/common';
import { CreateUserDTO } from './dto/create-user.dto';
import { UsersService } from './users.service';
import { JwtAuthGuard } from 'src/auth/jwt-auth.guard';

@Controller('users')
export class UsersController {
    constructor(private UsersService: UsersService){

    }

    //GET -> Read
    //Post -> Create
    //Put -> Update
    //Delete -> Delete
    @UseGuards(JwtAuthGuard)
    //Read 
    @Get()
    getAllUsers(){
        return this.UsersService.getAllUsers();
    }
    //Register
    @Post()
    create(@Body() user:CreateUserDTO){
        return this.UsersService.create(user);
    }

}
