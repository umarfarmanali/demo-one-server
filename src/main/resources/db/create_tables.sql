CREATE TABLE student
(
  registration_number character varying(6) NOT NULL,
  name character varying(25) NOT NULL,
  age integer NOT NULL,
  CONSTRAINT pk_student PRIMARY KEY (registration_number)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE student
  OWNER TO demo_one;