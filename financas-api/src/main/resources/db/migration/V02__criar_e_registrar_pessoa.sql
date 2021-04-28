create table tb_pessoa (
  id  bigserial not null, 
  ativo boolean, 
  bairro varchar(255), 
  cep varchar(255), 
  cidade varchar(255), 
  complemento varchar(255), 
  estado varchar(255), 
  logradouro varchar(255), 
  numero varchar(255), 
  nome varchar(255), 
  primary key (id));

  INSERT INTO tb_pessoa (nome, ativo, logradouro, bairro, cidade, estado, numero, complemento, cep) VALUES ('Bob da Silva', true, 'Rua Gomes da Costa', 'Santa Marta', 'São Paulo', 'São Paulo', '3001', 'Casa 2', '0987654');
