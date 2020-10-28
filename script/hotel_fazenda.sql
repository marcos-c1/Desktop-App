create table cliente(
	cod_cli char(7) not null primary key,
    nome varchar(50) not null,
    rg char(7) not null,
    bairro varchar(20),
    cidade varchar(20),
    estado char(2),
    cep char(8),
    dataNascimento date
);

create table chale(
	cod_chale char (7) not null primary key,
    localizacao varchar(30),
    capacidade int, 
    valorAltaEstacao decimal (8,2),
    valorBaixaEstacao decimal (8,2)
);

create table hospedagem(
	cod_hosp char(7) not null primary key,
    codChale char(7) not null,
    estado char(2),
    dataInicio date,
    dataFim date,
    qtdPessoas int,
    desconto decimal(6,2),
    valorFinal decimal(8,2),
    constraint fk_hospedagem_chale foreign key (codChale) references chale(cod_chale)
);


