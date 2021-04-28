create table tb_categoria (id  bigserial not null, nome varchar(255), primary key (id));
create table tb_pessoa (id  bigserial not null, ativo boolean, bairro varchar(255), cep varchar(255), cidade varchar(255), complemento varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), nome varchar(255), primary key (id));
