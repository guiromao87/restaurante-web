create table produtos (
    id int not null auto_increment primary key,
    nome varchar(255),
    descricao varchar(255),
    preco decimal(19,2),
    categoria varchar(255)
);