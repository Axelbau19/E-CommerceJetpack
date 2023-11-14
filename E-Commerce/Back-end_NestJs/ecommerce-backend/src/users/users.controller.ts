import { Body, Controller, Get, Param, ParseIntPipe, Post, Put, UseGuards } from '@nestjs/common';
import { CreateUserDTO } from './dto/create-user.dto';
import { UsersService } from './users.service';
import { JwtAuthGuard } from 'src/auth/jwt-auth.guard';
import { UpdateUserDto } from 'src/auth/dto/update-user.dto';

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

    @Put(':id')
    update(@Param('id',ParseIntPipe) id: number, @Body() user:UpdateUserDto){
        return this.UsersService.update(id,user);
    }


}
