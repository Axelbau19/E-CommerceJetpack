import { IsEmail, IsNotEmpty, IsString,MinLength} from "class-validator";
//That's a DTO (Data transfers Objects)
//Note : Install validations dependency by https://docs.nestjs.com/techniques/validation
export class RegisterUserDTO {
    @IsNotEmpty()
    @IsString()
    name: string;


    @IsNotEmpty()
    @IsString()
    lastname: string;


    @IsNotEmpty()
    @IsString()
    @IsEmail({},{message: 'El email no es valido'})
    email: string;

    @IsNotEmpty()
    @IsString()
    phone: string;

    @IsNotEmpty()
    @IsString()
    @MinLength(6,{message: 'La contraseña debe tener minimo 6 caracteres'})
    password: string;

    rolesIds: string[];
    
}