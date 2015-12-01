CREATE TABLE report.dim_phc (ID SERIAL, phcIdentifier VARCHAR NOT NULL, name VARCHAR NOT NULL,
  CONSTRAINT pk_dim_phc PRIMARY KEY (ID),
  CONSTRAINT U_DP_PI UNIQUE (phcIdentifier));

CREATE TABLE report.dim_anm (ID SERIAL, anmIdentifier VARCHAR NOT NULL, phc INTEGER NOT NULL,
  CONSTRAINT pk_dim_anm PRIMARY KEY (ID),
  CONSTRAINT FK_DA_DP_ID FOREIGN KEY (phc) REFERENCES report.dim_phc (ID),
  CONSTRAINT U_DA_AN UNIQUE (anmIdentifier));

CREATE TABLE report.dim_indicator (ID SERIAL, indicator VARCHAR NOT NULL,
  CONSTRAINT pk_dim_indicator PRIMARY KEY (ID),
  CONSTRAINT U_DI_IN UNIQUE (indicator));

CREATE TABLE report.dim_date (ID SERIAL, date_ DATE NOT NULL,
  CONSTRAINT pk_dim_date PRIMARY KEY (ID),
  CONSTRAINT U_DD_DT UNIQUE (date_));

CREATE TABLE report.dim_location (ID SERIAL, village VARCHAR NOT NULL, subCenter VARCHAR NOT NULL, phc INTEGER NOT NULL, taluka VARCHAR NOT NULL, district VARCHAR NOT NULL, state VARCHAR NOT NULL,
  CONSTRAINT pk_dim_location PRIMARY KEY (ID),
  CONSTRAINT FK_DL_DP_ID FOREIGN KEY (phc) REFERENCES report.dim_phc (ID),
  CONSTRAINT U_DL_VI_SU_PH UNIQUE (village, subCenter, phc),
  CONSTRAINT U_DL_VI_SU_PH_TK_DT_ST UNIQUE (village, subCenter, phc, taluka, district, state));

CREATE TABLE report.dim_service_provider_type (ID SERIAL, type VARCHAR NOT NULL,
  CONSTRAINT pk_dim_service_provider_type PRIMARY KEY (ID),
  CONSTRAINT U_DSPT_TY UNIQUE (type),
  CONSTRAINT CK_SPT CHECK (type = 'ANM' OR type = 'PHC'));

CREATE TABLE report.dim_service_provider (ID SERIAL, service_provider INTEGER NOT NULL, type INTEGER NOT NULL,
  CONSTRAINT pk_dim_service_provider PRIMARY KEY (ID),
  CONSTRAINT FK_DSP_DST_ID FOREIGN KEY (type) REFERENCES report.dim_service_provider_type (ID),
  CONSTRAINT U_SP_TY UNIQUE (service_provider, type));

CREATE TABLE report.annual_target (ID SERIAL, service_provider INTEGER NOT NULL, indicator INTEGER NOT NULL, target VARCHAR NOT NULL, start_date DATE NOT NULL, end_date DATE NOT NULL,
  CONSTRAINT pk_annual_target PRIMARY KEY (ID),
  CONSTRAINT FK_AT_DSP_ID FOREIGN KEY (service_provider) REFERENCES report.dim_service_provider (ID),
  CONSTRAINT FK_AT_DI_ID FOREIGN KEY (indicator) REFERENCES report.dim_indicator (ID),
  CONSTRAINT U_AT_SP_IN_TA_SD_ED UNIQUE (service_provider, indicator, start_date, end_date));

CREATE TABLE report.service_provided (ID SERIAL, service_provider INTEGER NOT NULL, externalId VARCHAR NOT NULL, indicator INTEGER NOT NULL, date_ INTEGER NOT NULL, location INTEGER NOT NULL,
  CONSTRAINT pk_service_provided PRIMARY KEY (ID),
  CONSTRAINT FK_SP_DSP_ID FOREIGN KEY (service_provider) REFERENCES report.dim_service_provider (ID),
  CONSTRAINT FK_SP_DI_ID FOREIGN KEY (indicator) REFERENCES report.dim_indicator (ID),
  CONSTRAINT FK_SP_DD_ID FOREIGN KEY (date_) REFERENCES report.dim_date (ID),
  CONSTRAINT FK_SP_DL_ID FOREIGN KEY (location) REFERENCES report.dim_location (ID));

CREATE TABLE report.country_tb (id SERIAL,country_name character varying(100) NOT NULL,country_code character varying(10) NOT NULL,active boolean,
CONSTRAINT country_tb_a PRIMARY KEY (id));

CREATE TABLE report.county_tb (id SERIAL,country_name integer NOT NULL,county_name character varying(100),active boolean NOT NULL,
CONSTRAINT county_tb_key UNIQUE (county_name),
CONSTRAINT county_tb_pkey PRIMARY KEY (id),
CONSTRAINT county_tb_fkey FOREIGN KEY (country_name) REFERENCES report.country_tb(id));

CREATE TABLE report.district_new (id SERIAL,country_name integer NOT NULL,county_name integer NOT NULL,district_name character varying(100) NOT NULL,   active boolean NOT NULL,
CONSTRAINT district_new_key UNIQUE (district_name),
CONSTRAINT district_new_pkey PRIMARY KEY (id),
CONSTRAINT district_new_fkey FOREIGN KEY (country_name) REFERENCES report.country_tb(id),
CONSTRAINT district_new_fkey1 FOREIGN KEY (county_name) REFERENCES report.county_tb(id));

CREATE TABLE report.subdistrict_new (id SERIAL,subdistrict character varying(100),active boolean NOT NULL,country integer NOT NULL,county integer NOT NULL,district integer NOT NULL,
CONSTRAINT subdistrict_new_pkey PRIMARY KEY (id),
CONSTRAINT subdistrict_new_key UNIQUE (subdistrict),
CONSTRAINT subdistrict_new_fkey FOREIGN KEY (country) REFERENCES report.country_tb(id),
CONSTRAINT subdistrict_new_fkey1 FOREIGN KEY (county) REFERENCES report.county_tb(id),
CONSTRAINT subdistrict_new_fkey2 FOREIGN KEY (district) REFERENCES report.district_new(id));

CREATE TABLE report.location_new (id SERIAL,location character varying(100),active boolean NOT NULL,country integer NOT NULL,county integer NOT NULL,district integer NOT NULL,subdistrict integer NOT NULL,
CONSTRAINT location_new_pkey PRIMARY KEY (id),
CONSTRAINT location_new_fkey1 FOREIGN KEY (country) REFERENCES report.country_tb(id),
CONSTRAINT location_new_fkey2 FOREIGN KEY (county) REFERENCES report.county_tb(id),
CONSTRAINT location_new_fkey3 FOREIGN KEY (district) REFERENCES report.district_new(id),
CONSTRAINT location_new_fkey4 FOREIGN KEY (subdistrict) REFERENCES report.subdistrict_new(id));

CREATE TABLE report.health_centers_new (id SERIAL,hospital_name character varying(200) DEFAULT NULL::character varying NOT NULL,hospital_type character varying(200) DEFAULT NULL::character varying NOT NULL,hospital_address character varying(200) NOT NULL,parent_hospital character varying(200) DEFAULT ' '::character varying,villages character varying(200),active boolean NOT NULL,country_name integer,county_name integer,district_name integer,subdistrict_name integer,
CONSTRAINT health_centers_new_key UNIQUE (hospital_name),
CONSTRAINT health_centers_new_key1 UNIQUE (id),
CONSTRAINT health_centers_new_fkey1 FOREIGN KEY (country_name) REFERENCES report.country_tb(id),
CONSTRAINT health_centers_new_fkey2 FOREIGN KEY (county_name) REFERENCES report.county_tb(id),
CONSTRAINT health_centers_new_fkey3 FOREIGN KEY (district_name) REFERENCES report.district_new(id),
CONSTRAINT health_centers_new_fkey4 FOREIGN KEY (subdistrict_name) REFERENCES report.subdistrict_new(id));

CREATE TABLE report.user_masters_new (id SERIAL,user_role character varying(200) NOT NULL,user_id character varying(200) NOT NULL,name character varying(200) NOT NULL,password character varying(200) NOT NULL,confirm_password character varying(200) NOT NULL,phone_number character varying(20) NOT NULL,email character varying(200) NOT NULL,subcenter integer DEFAULT 0,villages character varying(200) NOT NULL,lastname character varying(200) NOT NULL,active boolean NOT NULL,hospital integer DEFAULT 0,county integer,district integer,subdistrict integer,country integer,
CONSTRAINT user_masters_new_pkey PRIMARY KEY (id),
CONSTRAINT user_masters_new_key UNIQUE (user_id),
CONSTRAINT user_masters_new_fkey1 FOREIGN KEY (country) REFERENCES report.country_tb(id),
CONSTRAINT user_masters_new_fkey2 FOREIGN KEY (county) REFERENCES report.county_tb(id),
CONSTRAINT user_masters_new_fkey3 FOREIGN KEY (district) REFERENCES report.district_new(id),
CONSTRAINT user_masters_new_fkey4 FOREIGN KEY (hospital) REFERENCES report.health_centers_new(id),
CONSTRAINT user_masters_new_fkey5 FOREIGN KEY (subcenter) REFERENCES report.health_centers_new(id),
CONSTRAINT user_masters_new_fkey6 FOREIGN KEY (subdistrict) REFERENCES report.subdistrict_new(id));

CREATE TABLE report.app_configuration (id SERIAL,country_name integer NOT NULL,wife_age_min integer DEFAULT 0 NOT NULL,wife_age_max integer DEFAULT 0 NOT NULL,husband_age_min integer DEFAULT 0 NOT NULL,husband_age_max integer DEFAULT 0 NOT NULL,temperature_units character varying(20) NOT NULL,escalation_schedule integer NOT NULL,is_highrisk character varying(100),
CONSTRAINT app_configuration_key UNIQUE (country_name),
CONSTRAINT app_configuration_key UNIQUE (id),
CONSTRAINT app_configuration_pkey PRIMARY KEY (id),
CONSTRAINT app_configuration_fkey FOREIGN KEY (country_name) REFERENCES report.country_tb(id));

CREATE TABLE report.directions (id SERIAL,directions character varying(200) NOT NULL,active boolean NOT NULL,
CONSTRAINT directions_pkey PRIMARY KEY (id));

CREATE TABLE report.dosage (id SERIAL, dosage character varying(100) NOT NULL,active boolean NOT NULL,
CONSTRAINT dosage_pkey PRIMARY KEY (id));

CREATE TABLE report.frequency (id SERIAL,active boolean NOT NULL,number_of_times character varying(100) NOT NULL,
CONSTRAINT frequency_pkey PRIMARY KEY (id));

CREATE TABLE report.drug_info (id SERIAL,drug_name character varying(100) NOT NULL,frequency integer,dosage integer,direction integer,active boolean NOT NULL,anc_conditions character varying(200) DEFAULT NULL::character varying,pnc_conditions character varying(200) DEFAULT NULL::character varying,child_illness character varying(200) DEFAULT NULL::character varying,
CONSTRAINT drug_info_key UNIQUE (drug_name),
CONSTRAINT drug_info_pkey PRIMARY KEY (id),
CONSTRAINT drug_info_fkey FOREIGN KEY (direction) REFERENCES report.directions(id),
CONSTRAINT drug_info_fkey1 FOREIGN KEY (dosage) REFERENCES report.dosage(id),
CONSTRAINT drug_info_fkey2 FOREIGN KEY (frequency) REFERENCES report.frequency(id));

CREATE TABLE report.form_fields (id SERIAL,form_name character varying(50),field1 character varying(50),field2 character varying(50),field3 character varying(50),field4 character varying(50),field5 character varying(50),country integer,
CONSTRAINT form_fields_pkey PRIMARY KEY (id),
CONSTRAINT form_fields_fkey FOREIGN KEY (country) REFERENCES report.country_tb(id));

CREATE TABLE report.anc_due (id SERIAL,entityid character varying(200) NOT NULL,patientnum character varying(200),anmnum character varying(200),visittype character varying(200),visitno integer,lmpdate character varying(200),womenname character varying(200),visitdate character varying(200),anmid character varying(200),
CONSTRAINT anc_due_id_key UNIQUE (id),
CONSTRAINT anc_due_pkey PRIMARY KEY (entityid));

CREATE TABLE report.icd10 (id SERIAL, ICD10_Chapter character varying(200) NOT NULL, ICD10_Code character varying(100) NOT NULL,ICD10_Name character varying(100) NOT NULL,can_select boolean NOT NULL,status boolean NOT NULL,
CONSTRAINT icd10_pkey PRIMARY KEY (id));
