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

  INSERT INTO tb_pessoa (nome, ativo, logradouro, bairro, cidade, estado, numero, complemento, cep) VALUES ('Marta da Costa', true, 'Rua Fernando de Morais', 'Jd. Luz', 'Bahia', 'Salvador', '30', null, '8965422');
  INSERT INTO tb_pessoa (nome, ativo, logradouro, bairro, cidade, estado, numero, complemento, cep) VALUES ('Bob da Silva', true, 'Rua Gomes da Costa', 'Santa Marta', 'São Paulo', 'São Paulo', '3001', 'Casa 2', '0987654');
  INSERT INTO tb_pessoa (nome, ativo, logradouro, bairro, cidade, estado, numero, complemento, cep) VALUES ('Fernando de Felix', false, 'Av. Tira Dentes', 'Centro', 'São Paulo', 'Campinas', '345', 'Em frente ao posto BR', '6712345');
  INSERT INTO tb_pessoa (nome, ativo, logradouro, bairro, cidade, estado, numero, complemento, cep) VALUES ('Marcia Tenner', true, 'Rua Tobias', 'Tabajara', 'Rio Grande do Norte', 'Natal', '987', '0181', '4467854');
  INSERT INTO tb_pessoa (nome, ativo, logradouro, bairro, cidade, estado, numero, complemento, cep) VALUES ('Jairo Cairos', false, 'Rua Elencar', 'Niterói', 'Rio de Janeiro', 'Estado Homônimo', '3001', 'Casa 2', '0987654');
  INSERT INTO tb_pessoa (nome, ativo, logradouro, bairro, cidade, estado, numero, complemento, cep) VALUES ('Maria Fernandes', false, 'Rua Vaguinho', 'Santa Marta', 'São Paulo', 'São Paulo', '555', null,'9834567');
  INSERT INTO tb_pessoa (nome, ativo, logradouro, bairro, cidade, estado, numero, complemento, cep) VALUES ('Lucas Monteiro', true, 'Rua Santa Maria', 'Vila do Fundo', 'Campina Grande', 'Paraiba', '332', 'Em frente a escola da Motta', '3456721');
  INSERT INTO tb_pessoa (nome, ativo, logradouro, bairro, cidade, estado, numero, complemento, cep) VALUES ('João Batiston', true, 'Rua Armando mas Leite', 'Jd. Ypê', 'São Paulo', 'Jacarei', '437', null, '9835333');
  INSERT INTO tb_pessoa (nome, ativo, logradouro, bairro, cidade, estado, numero, complemento, cep) VALUES ('Jonas oNiel', true, 'Av. das Comadres', 'Tulio Rezende', 'Amazonas', 'Sul', '564', 'Casa de baixo', '1234567');
  INSERT INTO tb_pessoa (nome, ativo, logradouro, bairro, cidade, estado, numero, complemento, cep) VALUES ('Thiago Fernandes Fernando', false, 'Rua Tomás Tomas', 'Marta Homes', 'Pernambuco', 'Caruaru', '4564', 'Sitio', '3263256');
