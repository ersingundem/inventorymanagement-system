--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2021-01-04 19:00:11

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 16397)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    id bigint NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    email character varying(100) NOT NULL,
    address character varying(100) NOT NULL,
    birth_date date NOT NULL,
    phone character varying(50) NOT NULL
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16395)
-- Name: customer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_id_seq OWNER TO postgres;

--
-- TOC entry 3027 (class 0 OID 0)
-- Dependencies: 200
-- Name: customer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customer_id_seq OWNED BY public.customer.id;


--
-- TOC entry 203 (class 1259 OID 16407)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id bigint NOT NULL,
    title character varying(30) NOT NULL,
    price numeric(10,2) NOT NULL,
    stock integer NOT NULL
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16405)
-- Name: product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.product_id_seq OWNER TO postgres;

--
-- TOC entry 3028 (class 0 OID 0)
-- Dependencies: 202
-- Name: product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_id_seq OWNED BY public.product.id;


--
-- TOC entry 205 (class 1259 OID 16415)
-- Name: sold_product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sold_product (
    id bigint NOT NULL,
    product_id bigint NOT NULL,
    customer_id bigint NOT NULL,
    sold_date date NOT NULL
);


ALTER TABLE public.sold_product OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16413)
-- Name: sold_product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sold_product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sold_product_id_seq OWNER TO postgres;

--
-- TOC entry 3029 (class 0 OID 0)
-- Dependencies: 204
-- Name: sold_product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sold_product_id_seq OWNED BY public.sold_product.id;


--
-- TOC entry 207 (class 1259 OID 16433)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    user_name character varying(50) NOT NULL,
    pasword character varying(50) NOT NULL,
    name_surname character varying(50) NOT NULL,
    phone character varying(50) NOT NULL,
    email character varying(100) NOT NULL,
    adress character varying(100) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16431)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 3030 (class 0 OID 0)
-- Dependencies: 206
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 2868 (class 2604 OID 16400)
-- Name: customer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer ALTER COLUMN id SET DEFAULT nextval('public.customer_id_seq'::regclass);


--
-- TOC entry 2869 (class 2604 OID 16410)
-- Name: product id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product ALTER COLUMN id SET DEFAULT nextval('public.product_id_seq'::regclass);


--
-- TOC entry 2870 (class 2604 OID 16418)
-- Name: sold_product id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sold_product ALTER COLUMN id SET DEFAULT nextval('public.sold_product_id_seq'::regclass);


--
-- TOC entry 2871 (class 2604 OID 16436)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3015 (class 0 OID 16397)
-- Dependencies: 201
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (id, first_name, last_name, email, address, birth_date, phone) FROM stdin;
1	Hasan	Kilit	hkilit@gmail.com	Yenimahalle	1999-04-15	54665632212
3	Fatma	Arslan	fatmaar@gmail.com	AKM	1986-06-15	532156484
4	Ali	Şahin	Aliş@gmail.com	İvedik	1964-08-07	53216568561
5	Aslan	Karaarslan	arsk@gmail.com	Demetevler	1996-04-15	54665632212
6	Selin	Sarıten	selin@gamil.com	Çayyolu	1987-04-23	532656894
7	Feyza	Alagöz	feyzal@gmail.com	Batıkent	19976-09-15	532156484
8	Yavuz	Ulusoy	yavuzulu@gmail.com	Yenimahalle	1963-08-07	53216568561
9	Kenan	Demir	kdemir@gmail.com	Kızılay	1998-09-29	548646513546
11	Mahmut Test0.37073371384874854	Tek0.7683523485632981	örek0.8638833000644385@gmail.com	Sincan	2021-01-03	5555556555
12	Mahmut Test0.5348631263756427	Tek0.39738736993705503	örek0.7202732968023808@gmail.com	Sincan	2021-01-03	5555556555
13	Mahmut Test0.3687184987362372	Tek0.07617382026213548	örek0.8017729585405573@gmail.com	Sincan	2021-01-03	5555556555
14	Mahmut Test0.30597385268934574	Tek0.5603858798578006	örek0.16092968808566022@gmail.com	Sincan	2021-01-03	5555556555
2	Tst0.752458360361493	Tst0.7202840694637094	test@gmail.com	Yenimahalle	2021-01-03	5368146753
\.


--
-- TOC entry 3017 (class 0 OID 16407)
-- Dependencies: 203
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, title, price, stock) FROM stdin;
1	Test120.3023400263760866	280.00	545
3	Test120.3023400263760866	280.00	545
4	Test120.3023400263760866	280.00	545
5	Test120.3023400263760866	280.00	545
6	Test120.3023400263760866	280.00	545
7	Test0.7885646542629424	200.00	345
2	Test120.023525919805936657	280.00	575
8	Test0.20404923467261005	200.00	345
\.


--
-- TOC entry 3019 (class 0 OID 16415)
-- Dependencies: 205
-- Data for Name: sold_product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sold_product (id, product_id, customer_id, sold_date) FROM stdin;
2	2	2	2020-10-19
3	3	3	2020-09-16
4	4	4	2020-11-07
5	5	5	2020-09-08
6	6	6	2020-10-09
7	1	5	2021-01-03
9	1	5	2021-01-03
1	3	7	2021-01-03
10	1	5	2021-01-03
\.


--
-- TOC entry 3021 (class 0 OID 16433)
-- Dependencies: 207
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, user_name, pasword, name_surname, phone, email, adress) FROM stdin;
1	Admin	1	Ersin Gündem	05364868456	egündem@gmail.com	ÇANKAYA
2	TestUser	2	Enes Yılmaz	05454868456	eyılmaz@gmail.com	ALTINPARK
\.


--
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 200
-- Name: customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_id_seq', 14, true);


--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 202
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_id_seq', 8, true);


--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 204
-- Name: sold_product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sold_product_id_seq', 10, true);


--
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 206
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 1, false);


--
-- TOC entry 2873 (class 2606 OID 16402)
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);


--
-- TOC entry 2877 (class 2606 OID 16412)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 2879 (class 2606 OID 16420)
-- Name: sold_product sold_product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sold_product
    ADD CONSTRAINT sold_product_pkey PRIMARY KEY (id);


--
-- TOC entry 2875 (class 2606 OID 16404)
-- Name: customer uk_email; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT uk_email UNIQUE (email);


--
-- TOC entry 2881 (class 2606 OID 16438)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2882 (class 2606 OID 16421)
-- Name: sold_product fk_sold_product_customer_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sold_product
    ADD CONSTRAINT fk_sold_product_customer_id FOREIGN KEY (customer_id) REFERENCES public.customer(id);


--
-- TOC entry 2883 (class 2606 OID 16426)
-- Name: sold_product fk_sold_product_product_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sold_product
    ADD CONSTRAINT fk_sold_product_product_id FOREIGN KEY (product_id) REFERENCES public.product(id);


-- Completed on 2021-01-04 19:00:11

--
-- PostgreSQL database dump complete
--

