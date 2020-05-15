--EFETUE A CRIACAO DOS SCRIPTS QUE IRAO FAZER A CARGA DOS DADOS

 -- para criação da tabela --
CREATE TABLE estudante(
id int(255) unsigned NOT NULL AUTO_INCREMENT,
nome varchar(255) NOT NULL,
email varchar(255) NOT NULL,
telefone int(10) DEFAULT NULL,
matricula varchar(255) NOT NULL,
curso varchar(255) DEFAULT NULL,
PRIMARY KEY (Id))
 -- carga dos dados --
INSERT INTO `sys`.`estudante` (`nome`, `email`, `telefone`, `matricula`, `curso`) VALUES ('Xawoy', 'xawoy@tms.com.br', '7777', '123456' ,'Engenharia da Computação');
INSERT INTO `sys`.`estudante` (`nome`, `email`, `telefone`, `matricula`, `curso`) VALUES ('Furae', 'furae@tms.com.br', '7778', '678912', 'Ciência da Computação');
INSERT INTO `sys`.`estudante` (`nome`, `email`, `telefone`, `matricula`, `curso`) VALUES ('Fupuy', 'fupuy@tms.com.br', '7779', '321654', 'Engenharia da Computação');
INSERT INTO `sys`.`estudante` (`nome`, `email`, `telefone`, `matricula`, `curso`) VALUES ('Kuer', 'kuer@tms.com.br', '7780', '654987', 'Análise de Dados');
INSERT INTO `sys`.`estudante` (`nome`, `email`, `telefone`, `matricula`, `curso`) VALUES ('Blias', 'blias@tms.com.br', '7781', '666131', 'Ciência da Computação');




