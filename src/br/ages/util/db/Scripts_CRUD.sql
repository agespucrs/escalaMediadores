/***
* Scripts para criacao e insersao de dados
* Base Dados Escala de Mediadores
* Casssio Trindade, 
* 02/2016
***/


-- alter table ages_e.tb_usuario
-- add constraint U_username unique(usuario);

USE escala_e;

-- DROP TABLE TB_TIPO_USUARIO;
-- DROP TABLE TB_USUARIO;

-- Tabela Usuario
CREATE TABLE tb_usuario (
  ID_USUARIO int(11) NOT NULL AUTO_INCREMENT,
  USUARIO varchar(45) NOT NULL,
  SENHA varchar(45) NOT NULL,
  PERFIL_ACESSO varchar(20) NOT NULL,
  STATUS_USUARIO varchar(20) NOT NULL,
  ID_TIPO_USUARIO int(11) NOT NULL,
  MATRICULA varchar(45) NOT NULL,
  NOME varchar(120) DEFAULT NULL,
  EMAIL varchar(120) DEFAULT NULL,
  DATA_INCLUSAO datetime DEFAULT NULL,
  PRIMARY KEY (ID_USUARIO,MATRICULA),
  UNIQUE KEY MATRICULA_UNIQUE (MATRICULA),
  CONSTRAINT U_USERNAME UNIQUE (USUARIO)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Tabela Tipo Usuario
CREATE TABLE tb_tipo_usuario (
  ID_TIPO_USUARIO int(11) NOT NULL AUTO_INCREMENT,
  NOME varchar(20) NOT NULL,
  DESCRICAO varchar(120) DEFAULT NULL,
  DATA_INCLUSAO datetime DEFAULT NULL,
  PRIMARY KEY (ID_TIPO_USUARIO)
);

-- Inserts
INSERT INTO tb_tipo_usuario VALUES
('1', 'Arquiteto', 'Responsavel pela parte tecnica', '2015-10-01 00:00:00');
INSERT INTO tb_tipo_usuario VALUES
('2', 'Aluno', '', '2015-10-01 00:00:00');
INSERT INTO tb_tipo_usuario VALUES
('3', 'Professor', '', '2015-10-01 00:00:00');
INSERT INTO tb_tipo_usuario VALUES
('4', 'Secretaria', '', '2015-10-01 00:00:00');

INSERT INTO tb_usuario
(ID_USUARIO,USUARIO,SENHA,PERFIL_ACESSO,STATUS_USUARIO,ID_TIPO_USUARIO,MATRICULA,NOME,EMAIL,DATA_INCLUSAO)
VALUES
('10', 'admin', 'admin', 'ADMINISTRADOR', 'ATIVO', '1', '00000', 'Cassio Trindade', 'cassio.trindade@pucrs.br', '2015-10-01 00:00:00');

select * from tb_usuario;

/*Table tb_mediador*/
CREATE TABLE `tb_mediador` (
  `id_mediador` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) DEFAULT NULL,
  `matricula` varchar(9) DEFAULT NULL,
  `nome` varchar(120) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `tipo_mediador` varchar(10) DEFAULT NULL,
  `status_mediador` varchar(45) DEFAULT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  PRIMARY KEY (`id_mediador`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`)
);

/*Table tb_escala_mes`*/

CREATE TABLE `escala_e`.`tb_escala_mes` (
  `id_escala_mes` INT(11) NOT NULL AUTO_INCREMENT,
  `id_mediador` INT(11) NOT NULL,
  `dia` VARCHAR(2) NOT NULL ,
  `mes` VARCHAR(2) NOT NULL  ,
  `ano` VARCHAR(4) NOT NULL  ,
  `tipo_folga` VARCHAR(45) NOT NULL  ,
  PRIMARY KEY (`id_escala_mes`)   ,
  FOREIGN KEY (id_mediador) REFERENCES tb_mediador(id_mediador), 
  UNIQUE INDEX `id_escala_mes_UNIQUE` (`id_escala_mes` ASC));
  
/*Table tb_area_conhecimento*/
CREATE TABLE `escala_e`.`tb_area_conhecimento` (
  `id_area_conecimento` INT(11) NOT NULL AUTO_INCREMENT  ,
  `numero` INT(5) NOT NULL,
  `nome` VARCHAR(120) NOT NULL,
  `pavimento` VARCHAR(20) NOT NULL,
  `turno` VARCHAR(60) NOT NULL,
  `tipo_area` VARCHAR(20) NOT NULL,
  `status_area` VARCHAR(20) NOT NULL,
  `numero_mediadores` INT(5) NOT NULL,
  `observacao` VARCHAR(255) NOT NULL,
  `data_cadastro` DATETIME NOT NULL,
  PRIMARY KEY (`id_area_conecimento`),
  UNIQUE INDEX `id_escala_dia_UNIQUE` (`id_area_conecimento` ASC),
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC));

/*Table tb_escala_dia*/
  CREATE TABLE `escala_e`.`tb_escala_dia` (
  `id_escala_dia` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `id_mediador` INT NOT NULL COMMENT '',
  `id_area_conhecimento` INT NOT NULL COMMENT '',
  `data_escala_dia` DATE NOT NULL COMMENT '',
  `turno` VARCHAR(1) NULL COMMENT '',
  PRIMARY KEY (`id_escala_dia`)  COMMENT '',
  UNIQUE INDEX `id_escala_dia_UNIQUE` (`id_escala_dia` ASC)  COMMENT '',
  UNIQUE INDEX `id_mediador_UNIQUE` (`id_mediador` ASC)  COMMENT '',
  UNIQUE INDEX `id_area_conhecimento_UNIQUE` (`id_area_conhecimento` ASC)  COMMENT '',
  CONSTRAINT `id_mediador`
    FOREIGN KEY (`id_mediador`)
    REFERENCES `escala_e`.`tb_mediador` (`id_mediador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_area_conhecimento`
    FOREIGN KEY (`id_area_conhecimento`)
    REFERENCES `escala_e`.`tb_area_conhecimento` (`id_area_conecimento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

  
  