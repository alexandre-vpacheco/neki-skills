 /* Criação das tabelas e constraints caso precise.*/
 
 /*
 
    CREATE TABLE public.user (
	id_user serial NOT NULL,
	username VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
	CONSTRAINT user_key UNIQUE (username),
	CONSTRAINT user_pkey PRIMARY KEY (id_user)
);

    CREATE TABLE public.skill (
	id_skill serial NOT NULL,
	imagem_url text NOT NULL,
	nome_skill varchar(255) NOT NULL,
	level varchar(50),
	descricao text NOT NULL,
	CONSTRAINT skill_pkey PRIMARY KEY (id_skill)
);

    CREATE TABLE public.user_skill (
	id_skill_user serial NOT NULL,
	id_user_fk int4 REFERENCES public.user(id_user)  NOT null,
	id_skill_fk int4 REFERENCES skill(id_skill) NOT NULL,
	level varchar(50) NOT NULL,
	CONSTRAINT skill_user_pkey PRIMARY KEY (id_skill_user)
);

*/
   
/* Inserts Users */

INSERT INTO public.user(username, senha)
VALUES('alexandre', '123456') ON conflict(username) do nothing;

INSERT INTO public.user(username, senha)
VALUES('joao', '123456') ON conflict(username) do nothing;

/* Inserts Skills */

INSERT INTO skill(id_skill, imagem_url, nome, descricao)
VALUES ('1', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Postgresql_elephant.svg/1200px-Postgresql_elephant.svg.png', 'PostgresSQL','Habilidade com PostgresSQL para gerenciamento de bancos de dados.') ON CONFLICT DO NOTHING;

INSERT INTO skill(id_skill, imagem_url, nome, descricao)
VALUES ('2', 'https://p92.hu/binaries/content/gallery/p92website/technologies/spring-overview.png', 'Spring Boot','Habilidade de desenvolvimento de API REST com o Spring Boot e Java.') ON CONFLICT DO NOTHING;

INSERT INTO skill(id_skill, imagem_url, nome, descricao)
VALUES ('3', 'https://cdn.freebiesupply.com/logos/large/2x/react-1-logo-png-transparent.png', 'React','Habilidade de desenvolvimento frontend web com React.') ON CONFLICT DO NOTHING;

INSERT INTO skill(id_skill, imagem_url, nome, descricao)
VALUES ('4', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/JavaScript-logo.png/768px-JavaScript-logo.png', 'JavaScript', 'Habilidade de desenvolvimento frontend web com a linguagem JavaScript.') ON CONFLICT DO NOTHING;

INSERT INTO skill(id_skill, imagem_url, nome, descricao)
VALUES ('5', 'https://cdn.pixabay.com/photo/2017/08/05/11/16/logo-2582747_1280.png', 'CSS','Linguagem de marcação para desenvolvimento web.') ON CONFLICT DO NOTHING;

INSERT INTO skill(id_skill, imagem_url, nome, descricao)
VALUES ('6', 'https://cdn.pixabay.com/photo/2017/08/05/11/16/logo-2582748_960_720.png', 'HTML','Linguagem de marcação para desenvolvimento web.') ON CONFLICT DO NOTHING;

INSERT INTO skill(id_skill, imagem_url, nome, descricao)
VALUES ('7', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/539px-React-icon.svg.png', 'React Native','Habilidade de desenvolvimento de aplicações mobile com React Native.') ON CONFLICT DO NOTHING;

/* Inserts Skills de Users */

INSERT INTO user_skill(id_user_fk, id_skill_fk,  level)
VALUES ('1', '1','Avançado') ON CONFLICT DO NOTHING;

INSERT INTO user_skill(id_user_fk, id_skill_fk,  level)
VALUES ('1', '2','Intermediário') ON CONFLICT DO NOTHING;

INSERT INTO user_skill(id_user_fk, id_skill_fk,  level)
VALUES ('1', '3','Intermediário') ON CONFLICT DO NOTHING;

INSERT INTO user_skill(id_user_fk, id_skill_fk,  level)
VALUES ('1', '7','Intermediário') ON CONFLICT DO NOTHING;

INSERT INTO user_skill(id_user_fk, id_skill_fk,  level)
VALUES ('2', '4','Iniciante') ON CONFLICT DO NOTHING;

INSERT INTO user_skill(id_user_fk, id_skill_fk,  level)
VALUES ('2', '5','Iniciante') ON CONFLICT DO NOTHING;

INSERT INTO user_skill(id_user_fk, id_skill_fk,  level)
VALUES ('2', '6','Iniciante') ON CONFLICT DO NOTHING;

/* Executar nesta ordem para apagar as tabelas. */

-- DROP TABLE public.skill_user;
-- DROP TABLE public.skill;
-- DROP TABLE public.user;