CREATE TABLE report.ec_reg (
    id integer NOT NULL,
    entityid character varying(200) NOT NULL,
    phonenumber character varying(200) NOT NULL
);


ALTER TABLE report.ec_reg OWNER TO dhanush;

--
-- Name: ec_reg_id_seq; Type: SEQUENCE; Schema: report; Owner: dhanush
--

CREATE SEQUENCE report.ec_reg_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE report.ec_reg_id_seq OWNER TO dhanush;

--
-- Name: ec_reg_id_seq; Type: SEQUENCE OWNED BY; Schema: report; Owner: dhanush
--

ALTER SEQUENCE report.ec_reg_id_seq OWNED BY report.ec_reg.id;


--
-- Name: id; Type: DEFAULT; Schema: report; Owner: dhanush
--

ALTER TABLE report.ONLY ec_reg ALTER COLUMN id SET DEFAULT nextval('report.ec_reg_id_seq'::regclass);


--
-- PostgreSQL database dump complete
--

