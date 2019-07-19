drop database farmacia;
create database farmacia;
use farmacia;

create table categorias(
idCategoria int not null primary key auto_increment,
nombreCat varchar(200),
porcentaje varchar(10)
);

create table proveedores(
idProveedor int not null primary key auto_increment,
nombreProve varchar(200),
telefono varchar(15),
direccion varchar(200)
);

create table productos(
idProducto int not null primary key auto_increment,
nombrePro varchar(200),
precio double,
precioEspecial double,
fechaVencimiento date,
idCategoria int,
cantidad int,
idProveedor int,

foreign key (idCategoria) references categorias(idCategoria)
on delete cascade on update cascade,
foreign key (idProveedor) references proveedores(idProveedor)
on delete cascade on update cascade
);

insert into proveedores values(0, 'Laboratorios Lopez', '2222-2222', 'Bulevar del ejercito');

insert into categorias values(0, 'Antibióticos', '1%');
insert into categorias values(0, 'Antihistamínico', '3%');
insert into categorias values(0, 'Fármacos ', '1.5%');
insert into categorias values(0, 'Camilofina', '7%');

select * from productos;
select * from categorias;
select * from proveedores;
