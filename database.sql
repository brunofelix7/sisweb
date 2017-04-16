INSERT INTO endereco(id, bairro, cep, cidade, estado, numero, rua) 
VALUES (1, 'Funcionarios', '58079370', 'Bayeux', 'PB', '55', 'R. Teresinha de Oliveira Justa');

INSERT INTO endereco(id, bairro, cep, cidade, estado, numero, rua) 
VALUES (2, 'Intermares', '58000320', 'Cabedelo', 'PB', '47', 'R. Aderbal Piragibe');

INSERT INTO endereco(id, bairro, cep, cidade, estado, numero, rua) 
VALUES (3, 'Bessa', '58777530', 'Intermares', 'PB', '177', 'R. Francisco Leocádio Ribeiro Coutinho');

INSERT INTO pessoa(dtype, cpf, email, nome, sexo, telefone, data_nascimento, endereco_id) 
VALUES ('Cliente', '49131765874', 'joao@hotmail.com', 'João Herculano', 'MASCULINO', '08332654879', '1990-01-06', 1);

INSERT INTO pessoa(dtype, cpf, email, nome, sexo, telefone, data_nascimento, endereco_id) 
VALUES ('Cliente', '38408873997', 'maria@hotmail.com', 'Maria Felix', 'FEMININO', '08388167942', '1960-03-20', 2);

INSERT INTO pessoa(dtype, cpf, email, nome, sexo, telefone, data_nascimento, endereco_id) 
VALUES ('Cliente', '77376665080', 'emerson@hotmail.com', 'Emerson Silva', 'MASCULINO', '083988551242', '1995-04-08', 3);
