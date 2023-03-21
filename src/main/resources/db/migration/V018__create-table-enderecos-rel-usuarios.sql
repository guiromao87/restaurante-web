create table enderecos (
  id int not null auto_increment primary key,
  cep varchar(255),
  rua varchar(255),
  usuario_id int,
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);