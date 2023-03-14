--
-- PostgreSQL database dump
--

-- Dumped from database version 15.0 (Debian 15.0-1.pgdg110+1)
-- Dumped by pg_dump version 15.0 (Debian 15.0-1.pgdg110+1)

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
-- Name: meter_reading; Type: TABLE; Schema: public; Owner: soumen
--

CREATE TABLE public.meter_reading (
    id bigint NOT NULL,
    meter_reading_value integer,
    meter_type smallint,
    starting_reading boolean,
    submit_date timestamp(6) without time zone
);


ALTER TABLE public.meter_reading OWNER TO soumen;

--
-- Name: meter_reading_history; Type: TABLE; Schema: public; Owner: soumen
--

CREATE TABLE public.meter_reading_history (
    id bigint NOT NULL,
    meter_reading_value integer,
    meter_type smallint,
    starting_reading boolean,
    submit_date timestamp(6) without time zone
);


ALTER TABLE public.meter_reading_history OWNER TO soumen;

--
-- Name: meter_reading_history_seq; Type: SEQUENCE; Schema: public; Owner: soumen
--

CREATE SEQUENCE public.meter_reading_history_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.meter_reading_history_seq OWNER TO soumen;

--
-- Name: meter_reading_seq; Type: SEQUENCE; Schema: public; Owner: soumen
--

CREATE SEQUENCE public.meter_reading_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.meter_reading_seq OWNER TO soumen;

--
-- Name: payment; Type: TABLE; Schema: public; Owner: soumen
--

CREATE TABLE public.payment (
    id bigint NOT NULL,
    amount double precision,
    meter_type smallint,
    payment_date timestamp(6) without time zone
);


ALTER TABLE public.payment OWNER TO soumen;

--
-- Name: payment_seq; Type: SEQUENCE; Schema: public; Owner: soumen
--

CREATE SEQUENCE public.payment_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.payment_seq OWNER TO soumen;

--
-- Name: rates; Type: TABLE; Schema: public; Owner: soumen
--

CREATE TABLE public.rates (
    id bigint NOT NULL,
    meter_type smallint,
    rate double precision,
    standing_charge double precision
);


ALTER TABLE public.rates OWNER TO soumen;

--
-- Name: rates_seq; Type: SEQUENCE; Schema: public; Owner: soumen
--

CREATE SEQUENCE public.rates_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rates_seq OWNER TO soumen;

--
-- Data for Name: meter_reading; Type: TABLE DATA; Schema: public; Owner: soumen
--

COPY public.meter_reading (id, meter_reading_value, meter_type, starting_reading, submit_date) FROM stdin;
1	12156	1	t	2022-12-13 00:00:00
2	9429	0	t	2022-11-05 00:00:00
263	12433	1	f	2023-03-09 00:00:00
264	9492	0	f	2023-03-09 00:00:00
\.


--
-- Data for Name: meter_reading_history; Type: TABLE DATA; Schema: public; Owner: soumen
--

COPY public.meter_reading_history (id, meter_reading_value, meter_type, starting_reading, submit_date) FROM stdin;
1	9460	0	f	2023-01-05 00:00:00
2	12234	1	f	2023-01-05 00:00:00
3	12166	1	f	2023-01-06 00:00:00
52	12246	1	f	2023-01-09 00:00:00
53	9462	0	f	2023-01-09 00:00:00
54	12268	1	f	2023-01-16 00:00:00
55	9466	0	f	2023-01-16 00:00:00
102	12272	1	f	2023-01-17 00:00:00
103	9467	0	f	2023-01-17 00:00:00
104	9470	0	f	2023-01-23 00:00:00
105	12291	1	f	2023-01-23 00:00:00
106	12322	1	f	2023-02-03 00:00:00
107	9477	0	f	2023-02-03 00:00:00
108	12346	1	f	2023-02-12 00:00:00
109	9481	0	f	2023-02-12 00:00:00
110	12373	1	f	2023-02-20 00:00:00
111	9484	0	f	2023-02-20 00:00:00
112	12378	1	f	2023-02-22 00:00:00
113	12395	1	f	2023-02-27 00:00:00
114	9487	0	f	2023-02-27 00:00:00
\.


--
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: soumen
--

COPY public.payment (id, amount, meter_type, payment_date) FROM stdin;
1	38.91	0	2022-11-28 00:00:00
2	79.11	0	2022-11-28 00:00:00
52	79.11	0	2023-01-26 00:00:00
53	79.11	0	2023-02-27 00:00:00
\.


--
-- Data for Name: rates; Type: TABLE DATA; Schema: public; Owner: soumen
--

COPY public.rates (id, meter_type, rate, standing_charge) FROM stdin;
1	1	0.17	0.3
2	0	0.1045	0.2848
\.


--
-- Name: meter_reading_history_seq; Type: SEQUENCE SET; Schema: public; Owner: soumen
--

SELECT pg_catalog.setval('public.meter_reading_history_seq', 151, true);


--
-- Name: meter_reading_seq; Type: SEQUENCE SET; Schema: public; Owner: soumen
--

SELECT pg_catalog.setval('public.meter_reading_seq', 301, true);


--
-- Name: payment_seq; Type: SEQUENCE SET; Schema: public; Owner: soumen
--

SELECT pg_catalog.setval('public.payment_seq', 101, true);


--
-- Name: rates_seq; Type: SEQUENCE SET; Schema: public; Owner: soumen
--

SELECT pg_catalog.setval('public.rates_seq', 51, true);


--
-- Name: meter_reading_history meter_reading_history_pkey; Type: CONSTRAINT; Schema: public; Owner: soumen
--

ALTER TABLE ONLY public.meter_reading_history
    ADD CONSTRAINT meter_reading_history_pkey PRIMARY KEY (id);


--
-- Name: meter_reading meter_reading_pkey; Type: CONSTRAINT; Schema: public; Owner: soumen
--

ALTER TABLE ONLY public.meter_reading
    ADD CONSTRAINT meter_reading_pkey PRIMARY KEY (id);


--
-- Name: payment payment_pkey; Type: CONSTRAINT; Schema: public; Owner: soumen
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (id);


--
-- Name: rates rates_pkey; Type: CONSTRAINT; Schema: public; Owner: soumen
--

ALTER TABLE ONLY public.rates
    ADD CONSTRAINT rates_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

