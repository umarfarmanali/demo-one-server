-- Table: public.user_info
-- DROP TABLE public.user_info;
CREATE TABLE public.user_info
(
    id bigint NOT NULL DEFAULT nextval('user_info_id_seq'::regclass),
    username character varying(25) COLLATE pg_catalog."default" NOT NULL,
    password character varying(25) COLLATE pg_catalog."default" NOT NULL,
    active integer NOT NULL,
    CONSTRAINT user_info_pkey PRIMARY KEY (id),
    CONSTRAINT user_info_ukey_username UNIQUE (username)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.user_info
    OWNER to demo_one;
    
-- Table: public.student
-- DROP TABLE public.student;
CREATE TABLE public.student
(
    registration_number character varying(6) COLLATE pg_catalog."default" NOT NULL,
    name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    age integer NOT NULL,
    CONSTRAINT student_pkey PRIMARY KEY (registration_number)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.student
    OWNER to demo_one;