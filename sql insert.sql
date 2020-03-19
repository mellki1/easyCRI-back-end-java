CREATE SCHEMA `easycri` DEFAULT CHARACTER SET utf8 ;
SET @@global.time_zone = '+3:00';

create table cliente(
cliente_id int(10) not null primary key
);

create table requerimento(
id_requerimento int(10) not null primary key,
cliente_id int(10) not null,
constraint fk_cliente_id_cliente foreign key(cliente_id) references cliente(cliente_id)
);


select * from cliente;
select * from requerimento;


insert into cliente values(null, '13754410601', 'melki2011@gmail.com', 'Avenida Sao Paulo, nº.537, Centro, Santa Vitória-MG','solteiro', 'PE','9413624', 'brasileira', 'Melquisedeque Marcolino da Silva', 'Angela Valentim da Silva', 'Wellington Marcolino da Silva', 'SDS', 'escrevente autorizado', '34998856554');

insert into requerimento values (2, 0, 0, 1);

DELETE FROM requerimento WHERE id=2;
