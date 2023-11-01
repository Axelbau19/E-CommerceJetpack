export class CreateUserDTO {
    name: string;
    lastname: string;
    email: string;
    phone: string;
    password: string;
    image?:string;
    notification_token?:string;
}