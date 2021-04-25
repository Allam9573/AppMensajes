drop database if exists db_mensajes;
create database db_mensajes;
use db_mensajes;

create table mensajes(
		id_mensaje int(7) primary key auto_increment not null,
        mensaje varchar(280),
        autor_mensaje varchar(50),
        fecha_mensaje timestamp
        );