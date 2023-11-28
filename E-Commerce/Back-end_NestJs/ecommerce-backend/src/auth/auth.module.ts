import { Module } from '@nestjs/common';
import { AuthService } from './auth.service';
import { AuthController } from './auth.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { User } from 'src/users/user.entity';
import { JwtModule } from '@nestjs/jwt';
import { jtwConstants } from './jwt.constants';
import { JwtStrategy } from './jwt.strategy';
import { RolesService } from 'src/roles/roles.service';
import { Rol } from 'src/roles/rol.entity';

@Module({
  imports : [
    TypeOrmModule.forFeature([User,Rol]),
        //Agregar el JWT (Add JWT)
        JwtModule.register({
          secret: jtwConstants.secret,
          //Token Timer(Tiempo de expiracion del token)
          signOptions: { expiresIn: '6h' },
        }),],
  providers: [AuthService, RolesService, JwtStrategy],
  controllers: [AuthController]
})
export class AuthModule {}
