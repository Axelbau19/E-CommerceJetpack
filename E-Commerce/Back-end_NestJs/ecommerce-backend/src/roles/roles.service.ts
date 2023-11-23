import { Injectable } from '@nestjs/common';
import { Rol } from './rol.entity';
import { Repository } from 'typeorm';
import { InjectRepository } from '@nestjs/typeorm';
import { create } from 'domain';
import { CreateRolDto } from './dto/create-rol-dto';

@Injectable()
export class RolesService {
    constructor(@InjectRepository(Rol) private rolesRepository: Repository<Rol>){}
    create(rol:CreateRolDto){
        const newRol = this.rolesRepository.create(rol);
        return this.rolesRepository.save(newRol);
    }
}
