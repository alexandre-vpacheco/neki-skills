 /* Criação das tabelas e constraints. (EXECUTAR NESTA ORDEM)*/
 
 /*
    CREATE TABLE public.user (
	id_user serial NOT NULL,
	username varchar(50) NOT NULL,
	senha varchar(12) NULL,
	CONSTRAINT users_key UNIQUE (username),
	CONSTRAINT users_pkey PRIMARY KEY (id_user)
);

    CREATE TABLE public.level (
	id_level serial NOT NULL,
	level int4 NOT NULL,
	id_user int4 NOT NULL,
	CONSTRAINT level_pkey PRIMARY KEY (id_level)
);

    ALTER TABLE public.level ADD FOREIGN KEY (id_user) REFERENCES public.user(id_user);

    CREATE TABLE public.skill (
	id_skill serial NOT NULL,
	nome_skill varchar(50) NOT NULL,
	imagem_url varchar(255) NOT NULL,
	imagem_nome varchar(255),
	imagem_filename varchar(255),
	descricao varchar(500) NOT NULL,
	id_user int4 NOT NULL,
    id_level int4 NOT NULL,
	CONSTRAINT skills_pkey PRIMARY KEY (id_skill)
);

    ALTER TABLE public.skill ADD FOREIGN KEY (id_user) REFERENCES public.user(id_user);
    
    ALTER TABLE public.skill ADD FOREIGN KEY (id_level) REFERENCES public.level(id_level);
    
*/    

/* Executar nesta ordem para apagar as tabelas. */

 --DROP TABLE public.skill;
 --DROP TABLE public.level;
 --DROP TABLE public.user;

/* Inserts */

--INSERT INTO public.user(username, senha)
--VALUES('alexandre', '123456') ON conflict(username) do nothing;

INSERT INTO public.user(username, senha)
VALUES('João', '123456') ON conflict(username) do nothing;

--INSERT INTO level(id_level, level, id_user)
--VALUES ('1', '8', '1') ON CONFLICT DO NOTHING;

--INSERT INTO level(id_level, level, id_user)
--VALUES ('2', '7', '1') ON CONFLICT DO NOTHING;

--INSERT INTO skill(id_skill, nome_skill, imagem_url, descricao, id_user, id_level)
--VALUES ('1', 'JavaScript', 'https://i.pinimg.com/736x/28/75/3d/28753ddf79d70042ba86564947e13bf5.jpg', 'Habilidade de desenvolvimento de aplicações web com JavaScript.', '1', '1' ) ON CONFLICT DO NOTHING;

--INSERT INTO skill(id_skill, nome_skill, imagem_url, descricao, id_user, id_level)
--VALUES ('2', 'Spring Boot', 'https://p92.hu/binaries/content/gallery/p92website/technologies/spring-overview.png', 'Habilidade de desenvolvimento de API REST com o Spring Boot.', '1', '2' ) ON CONFLICT DO NOTHING;


