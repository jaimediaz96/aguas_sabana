CREATE TABLE ggp_route (
    route_id NUMBER,
    route_name VARCHAR2(255),
    description_route VARCHAR2(1000)
);

/

ALTER TABLE ggp_route
ADD CONSTRAINT routes_pk PRIMARY KEY (route_id);

/
/*
ALTER TABLE ggp_route
MODIFY (
    route_name VARCHAR2(255) NOT NULL,
    description_route VARCHAR2(1000) NOT NULL
);
*/

ALTER TABLE ggp_route
RENAME CONSTRAINT routes_pk TO ggp_routes_pk;



CREATE TABLE ggp_truck_capacity(
    truck_capacity_id NUMBER,
    capacity VARCHAR2(255)
);

ALTER TABLE ggp_truck_capacity
ADD CONSTRAINT ggp_truck_capacity_pk PRIMARY KEY (truck_capacity_id);

DROP TABLE ggp_truck_capacity;


ALTER TABLE ggp_truck_capacity
MODIFY (
    capacity VARCHAR2(255) NOT NULL
);


CREATE TABLE ggp_crew(
    crew_id NUMBER,
    name VARCHAR2(255) NOT NULL
);

ALTER TABLE ggp_crew
ADD CONSTRAINT ggp_crew_pk PRIMARY KEY (crew_id);


ALTER TABLE ggp_truck
ADD CONSTRAINT ggp_truck_fk FOREIGN KEY (truck_type_id)
REFERENCES ggp_truck_type (truck_type_id);


SELECT * FROM ggp_crew;

CREATE TABLE ggp_not_collected (
  not_collected_id NUMBER,
  code NUMBER NOT NULL,
  description VARCHAR2(255) NOT NULL
);

ALTER TABLE ggp_not_collected
ADD CONSTRAINT ggp_not_collected_pk PRIMARY KEY (not_collected_id);

CREATE TABLE ggp_recipient_type(
   recipient_type_id NUMBER,
   name VARCHAR2(255) NOT NULL,
   recipient_value FLOAT NOT NULL,
   recipient_type VARCHAR2(255) NOT NULL
);

ALTER TABLE ggp_recipient_type
ADD CONSTRAINT ggp_recipient_type_pk PRIMARY KEY (recipient_type_id);


CREATE TABLE ggp_recipient(
  recipient_id NUMBER,
  quantity INTEGER NOT NULL ,
  fill_percentage INTEGER NOT NULL,
  total FLOAT NOT NULL
  );

 ALTER TABLE ggp_recipient
ADD CONSTRAINT ggp_recipient_pk PRIMARY KEY (recipient_id);

ALTER TABLE ggp_recipient
ADD recipient_type_id INTEGER NOT NULL;


ALTER TABLE ggp_recipient
ADD CONSTRAINT ggp_recipient_fk FOREIGN KEY (recipient_type_id)
REFERENCES ggp_recipient_type (recipient_type_id);

SELECT * FROM ggp_type_aforo


CREATE TABLE ggp_frequency(
  frequency_id NUMBER,
  frequency_extern NUMBER NOT NULL
  );


 ALTER TABLE ggp_frequency
ADD CONSTRAINT ggp_frequency_pk PRIMARY KEY (frequency_id);



CREATE TABLE ggp_type_aforo(
  type_aforo_id NUMBER,
  type_aforo_extern_id NUMBER NOT NULL,
  aforo_type VARCHAR2(255) NOT NULL
  );


 ALTER TABLE ggp_type_aforo
ADD CONSTRAINT ggp_type_aforo_pk PRIMARY KEY (type_aforo_id);

/
CREATE TABLE ggp_client(
  client_id NUMBER,
  company_name VARCHAR2(255) NOT NULL,
  address VARCHAR2(255) NOT NULL,
  frequency_id NUMBER NOT NULL,
  type_aforo_id NUMBER NOT NULL
  );


 ALTER TABLE ggp_client
ADD CONSTRAINT ggp_client_pk PRIMARY KEY (client_id);


ALTER TABLE ggp_client
ADD CONSTRAINT ggp_client_frequency_fk FOREIGN KEY (frequency_id)
REFERENCES ggp_frequency (frequency_id);

ALTER TABLE ggp_client
ADD CONSTRAINT ggp_client_type_aforo_fk FOREIGN KEY (type_aforo_id)
REFERENCES ggp_type_aforo (type_aforo_id);

/


CREATE TABLE ggp_temp_client(
  temp_client_id NUMBER,
  company_name VARCHAR2(255) NOT NULL,
  nit VARCHAR2 (255) NOT NULL,
  phone VARCHAR2 (255) NOT NULL,
  address VARCHAR2(255) NOT NULL,
  email VARCHAR2 (255)NOT NULL,
  contact_name VARCHAR2 (255)NOT NULL,
  contact_phone VARCHAR2 (255)NOT NULL,
  photo_id INTEGER
  );

DROP TABLE ggp_not_collected

 ALTER TABLE ggp_temp_client
ADD CONSTRAINT ggp_temp_client_pk PRIMARY KEY (temp_client_id);


ALTER TABLE ggp_client
ADD CONSTRAINT ggp_client_frequency_fk FOREIGN KEY (frequency_id)
REFERENCES ggp_frequency (frequency_id);

ALTER TABLE ggp_client
ADD CONSTRAINT ggp_client_type_aforo_fk FOREIGN KEY (type_aforo_id)
REFERENCES ggp_type_aforo (type_aforo_id);

/

CREATE TABLE ggp_aforo_recipient (
  recipient_id NUMBER NOT NULL,
  aforo_id NUMBER NOT NULL
);

ALTER TABLE ggp_aforo_recipient
ADD CONSTRAINT ggp_aforo_recipient_fk FOREIGN KEY (frequency_id)
REFERENCES ggp_frequency (frequency_id);

ALTER TABLE ggp_client
ADD CONSTRAINT ggp_client_type_aforo_fk FOREIGN KEY (type_aforo_id)
REFERENCES ggp_type_aforo (type_aforo_id);

SELECT * FROM ggp_aforo_recipient
DROP TABLE ggp_temp_client