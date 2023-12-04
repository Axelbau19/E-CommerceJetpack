import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { TypeOrmModule } from '@nestjs/typeorm';
import { UsersModule } from './users/users.module';
import { AuthModule } from './auth/auth.module';
import { JwtModule } from '@nestjs/jwt';
import { jtwConstants } from './auth/jwt/jwt.constants';
import { RolesModule } from './roles/roles.module';




@Module({
  imports: [
      TypeOrmModule.forRoot({
        type: 'mysql',
        host: 'localhost',
        port: 3306,
        username: 'root',
        password: 'root',
        database: 'ecommerce_db',
        entities: [__dirname+'/**/*.entity{.ts,.js}'],
        synchronize: false
      }),
      UsersModule,
      AuthModule,
      RolesModule
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
