create database corenuvudb;

CREATE TABLE public.client (
	id integer NOT NULL,
	name character varying(200) NOT NULL,
	document character varying(200) NOT NULL,
	phone character varying(50),
	email character varying(100),
	active boolean NOT NULL
);

ALTER TABLE public.client OWNER TO postgres;


CREATE SEQUENCE public.client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
	
	
ALTER TABLE public.client_id_seq OWNER TO postgres;	

ALTER SEQUENCE public.client_id_seq OWNED BY public.client.id;
ALTER TABLE ONLY public.client ALTER COLUMN id SET DEFAULT nextval('public.client_id_seq'::regclass);