import { Entity, PrimaryColumn, PrimaryGeneratedColumn, Column, BeforeInsert } from "typeorm";
import {hash} from 'bcrypt';
//Creando la tabla user (Created user's table)
@Entity({name: 'users'})
export class User{
    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    name: String;

    @Column()
    lastname: string;

    @Column({unique: true})
    email: string;

    @Column({unique: true})
    phone: string;

    @Column()
    password: String;

    @Column({nullable:true})
    notification_token: String;

    @Column({nullable: true})
    image: String;

    @Column({type: 'datetime', default:() => 'CURRENT_TIMESTAMP'})
    created_at: Date;

    @Column({type: 'datetime', default:() => 'CURRENT_TIMESTAMP'})
    update_at: Date;
    //Encriptar la contraseña
    @BeforeInsert() 
    async encryptPassword(){
        this.password = await hash(this.password,Number(process.env.HASH_SALT));
    }
}