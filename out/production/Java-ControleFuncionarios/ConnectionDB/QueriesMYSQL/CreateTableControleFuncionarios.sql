
CREATE DATABASE controlefuncionarios;
use controlefuncionarios;

-- DROP DATABASE controlefuncionarios;
CREATE TABLE TB_Enderecos(
	id int primary key auto_increment,
	rua varchar(150),
    numero varchar(5),
    cidade varchar(150),
    estado varchar(150),
    cep varchar(8)
);

CREATE TABLE TB_Empresa(
	id int primary key auto_increment,
    nome varchar(150),
    cnpj varchar(14),
    id_endereco int,
    foreign key (id_endereco) references TB_Enderecos(id)
);

CREATE TABLE TB_Funcionario (
	id int primary key auto_increment,
    nome VARCHAR(150),
    idade int(3),
    id_empresa int,
    cpf CHAR(11) UNIQUE,
    foreign key (id_empresa) references TB_Empresa(id)
    
);
CREATE TABLE TB_Projetos(
	id int primary key auto_increment,
	nome varchar(150),
    descricao varchar(200),
    codeStatus varchar(200)
);

CREATE TABLE TB_CEO(
	id int primary key auto_increment,
    nome VARCHAR(150),
    idade int(3),
    cpf CHAR(11) UNIQUE,
    senha CHAR(16),
    id_empresa int,
    foreign key (id_empresa) references TB_Empresa(id)
    
);


CREATE TABLE TB_Cliente(
	id int primary key auto_increment,
    nome VARCHAR(150),
    idade int(3),
    cpf CHAR(11) UNIQUE,
    id_empresa int,
    foreign key (id_empresa) references TB_Empresa(id)
);


    