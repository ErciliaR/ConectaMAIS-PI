CREATE DATABASE db_conecta_mais;
USE db_conecta_mais;
CREATE TABLE  tb_tema  (
	 id  bigint NOT NULL AUTO_INCREMENT,
	 processo_seletivo  BOOLEAN NOT NULL,
	 evento  BOOLEAN NOT NULL,
	 noticia  BOOLEAN NOT NULL,
	PRIMARY KEY ( id )
);

CREATE TABLE  tb_instituicao  (
	 id  bigint NOT NULL AUTO_INCREMENT,
	 nome  varchar(255) NOT NULL,
	 email  varchar(255) NOT NULL,
	 senha  varchar(255) NOT NULL,
	 descricao  varchar(500) NOT NULL,
	 cidade  varchar(255) NOT NULL,
	 hackaton  BOOLEAN NOT NULL,
	 idade_min  int NOT NULL,
	 idade_max  int NOT NULL,
	 genero  varchar(255) NOT NULL,
	 escolaridade  varchar(255) NOT NULL,
	 presencial  BOOLEAN NOT NULL,
	 ead  BOOLEAN NOT NULL,
	PRIMARY KEY ( id )
);

CREATE TABLE tb_postagem (
	 id bigint NOT NULL AUTO_INCREMENT,
	 id_instituicao  bigint NOT NULL,
	 id_tema bigint NOT NULL,
	 conteudo  varchar(1500) NOT NULL,
	 enviar  BOOLEAN NOT NULL,
	 editar  BOOLEAN NOT NULL,
	 deletar  BOOLEAN NOT NULL,
	 PRIMARY KEY ( id ),
     FOREIGN KEY ( id_instituicao ) REFERENCES  tb_instituicao ( id ),
     FOREIGN KEY ( id_tema ) REFERENCES  tb_tema ( id )
);

