import { Body,Controller, Post } from '@nestjs/common';
import { AuthService } from './auth.service';
import { RegisterUserDTO } from './dto/register-user.dto';
import { LoginAuthDto } from './dto/login-auth.dto';

@Controller('auth')
export class AuthController {
    constructor(private authService:AuthService){}

    //Post link -> http://localhost:3000/auth/register
    @Post('register')
    register(@Body() user:RegisterUserDTO){
        return this.authService.register(user);
    }
    //Post Link -> http://localhost:3000/auth/login
    @Post('login') 
    login(@Body() userData:LoginAuthDto){
        return this.authService.login(userData);
    }
}
