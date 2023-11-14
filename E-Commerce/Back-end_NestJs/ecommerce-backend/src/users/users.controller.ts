<<<<<<< HEAD
import { Body, Controller, FileTypeValidator, Get, MaxFileSizeValidator, Param, ParseFilePipe, ParseIntPipe, Post, Put, UploadedFile, UseGuards, UseInterceptors } from '@nestjs/common';
=======
import { Body, Controller, Get, Param, ParseIntPipe, Post, Put, UseGuards } from '@nestjs/common';
>>>>>>> main
import { CreateUserDTO } from './dto/create-user.dto';
import { UsersService } from './users.service';
import { JwtAuthGuard } from 'src/auth/jwt-auth.guard';
import { UpdateUserDto } from 'src/auth/dto/update-user.dto';
<<<<<<< HEAD
import { FileInterceptor } from '@nestjs/platform-express';
=======
>>>>>>> main

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

<<<<<<< HEAD
    @UseGuards(JwtAuthGuard)
=======
>>>>>>> main
    @Put(':id')
    update(@Param('id',ParseIntPipe) id: number, @Body() user:UpdateUserDto){
        return this.UsersService.update(id,user);
    }

<<<<<<< HEAD
    @Post('upload')
    @UseInterceptors(FileInterceptor('file'))
    uploadFile(
        @UploadedFile(
            new ParseFilePipe({
                validators: [
                  new MaxFileSizeValidator({ maxSize: 1024 * 1024 * 4 }),
                  new FileTypeValidator({ fileType: '.(png|jpeg|jpg)'}),
                ],
              })
        ) file: Express.Multer.File
        ) {
        console.log(file);
    }

=======
>>>>>>> main

}
