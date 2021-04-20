create table tb_categoria (id bigserial not null, nome varchar(20) not null, primary key (id));

INSERT INTO tb_categoria (nome) VALUES ('Lazer');
INSERT INTO tb_categoria (nome) VALUES ('Alimentação');
INSERT INTO tb_categoria (nome) VALUES ('Supermercado');
INSERT INTO tb_categoria (nome) VALUES ('Fármacia');
INSERT INTO tb_categoria (nome) VALUES ('Outros');