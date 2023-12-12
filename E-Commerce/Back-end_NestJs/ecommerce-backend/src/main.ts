import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import { ValidationPipe } from '@nestjs/common';

async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  app.useGlobalPipes(new ValidationPipe());
  //Ipaddress
  //Nota: Si se conecta a otra red, se debe que cambiar la ip
  await app.listen(3000,'192.168.100.113' ||'localhost');
}
bootstrap();
