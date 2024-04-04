CREATE TABLE GGP_Users (
    user_id NUMBER NOT NULL,
    name VARCHAR2(255) NOT NULL,
    rol VARCHAR2(50) NOT NULL,
    username VARCHAR2(150) NOT NULL,
    password VARCHAR2(150) NOT NULL,
    email VARCHAR2(255) NOT NULL
);

ALTER TABLE GGP_Users
ADD CONSTRAINT GGP_Users_pk PRIMARY KEY (user_id);


CREATE TABLE GGP_Truck_Type (
    truck_type_id NUMBER NOT NULL,
    type VARCHAR2(255) NOT NULL
);

ALTER TABLE GGP_Truck_Type
ADD CONSTRAINT GGP_Truck_Type_pk PRIMARY KEY (truck_type_id);


CREATE TABLE GGP_Truck (
    truck_id NUMBER NOT NULL,
    plate VARCHAR2(20) NOT NULL,
    papers CHAR(1) NOT NULL,
    maintenance DATE NOT NULL,
    mileage NUMBER NOT NULL,
    tire VARCHAR2(50) NOT NULL,
    pressure VARCHAR2(50) NOT NULL,
    fuel VARCHAR2(50) NOT NULL,
    light VARCHAR2(50) NOT NULL,
    honk VARCHAR2(50) NOT NULL,
    brake VARCHAR2(50) NOT NULL,
    oil VARCHAR2(50) NOT NULL,
    observation VARCHAR2(255) NOT NULL,
    truck_type_id NUMBER NOT NULL,
    truck_capacity_id NUMBER NOT NULL
);

ALTER TABLE GGP_Truck
ADD CONSTRAINT GGP_Truck_pk PRIMARY KEY (truck_id);

ALTER TABLE GGP_Truck
ADD CONSTRAINT GGP_Truck_Type_fk FOREIGN KEY (truck_type_id)
REFERENCES ggp_truck_type (truck_type_id);

ALTER TABLE GGP_Truck
ADD CONSTRAINT GGP_Truck_Capacity_fk FOREIGN KEY (truck_capacity_id)
REFERENCES GGP_Truck_Capacity (truck_capacity_id);


CREATE TABLE GGP_Photo(
    photo_id NUMBER NOT NULL,
    path VARCHAR2(4000) NOT NULL,
    external_id NUMBER NOT NULL,
    source_type VARCHAR2(250) NOT NULL
);

ALTER TABLE GGP_Photo
ADD CONSTRAINT GGP_Photo_pk PRIMARY KEY (photo_id);


CREATE TABLE GGP_Refuel (
    refuel_id NUMBER NOT NULL,
    place VARCHAR2(250) NOT NULL,
    quantity FLOAT NOT NULL,
    cost FLOAT NOT NULL,
    refuel_date DATE NOT NULL,
    refuel_time NUMBER NOT NULL,
    photo_id NUMBER NOT NULL
);

ALTER TABLE GGP_Refuel
ADD CONSTRAINT GGP_Refuel_pk PRIMARY KEY (refuel_id);


CREATE TABLE GGP_Provision_Type (
    provision_type_id NUMBER NOT NULL,
    name VARCHAR2(250) NOT NULL
);

ALTER TABLE GGP_Provision_Type
ADD CONSTRAINT GGP_Provision_Type_pk PRIMARY KEY (provision_type_id);


CREATE TABLE GGP_Provision_Place (
    provision_place_id NUMBER NOT NULL,
    name VARCHAR2(250) NOT NULL
);

ALTER TABLE GGP_Provision_Place
ADD CONSTRAINT GGP_Provision_Place_pk PRIMARY KEY (provision_place_id);


CREATE TABLE GGP_Toll (
    toll_id NUMBER NOT NULL,
    name VARCHAR2(250) NOT NULL
);

ALTER TABLE GGP_Toll
ADD CONSTRAINT GGP_Toll_pk PRIMARY KEY (toll_id);


CREATE TABLE GGP_Provision (
    provision_id NUMBER NOT NULL,
    km_strat NUMBER NOT NULL,
    km_finish NUMBER NOT NULL,
    provision_date DATE NOT NULL,
    provision_time_trip  NUMBER NOT NULL,
    provision_time_place NUMBER NOT NULL,
    weight FLOAT NOT NULL,
    provision_place_id NUMBER NOT NULL,
    provision_type_id NUMBER NOT NULL,
    toll_id NUMBER NOT NULL,
    photo_id NUMBER NOT NULL
);

ALTER TABLE GGP_Provision
ADD CONSTRAINT GGP_Provision_pk PRIMARY KEY (provision_id);

ALTER TABLE GGP_Provision
ADD CONSTRAINT GGP_Provision_Place_fk FOREIGN KEY (provision_place_id)
REFERENCES GGP_Provision_Place (provision_place_id);

ALTER TABLE GGP_Provision
ADD CONSTRAINT GGP_Provision_Type_fk FOREIGN KEY (provision_type_id)
REFERENCES GGP_Provision_Type (provision_type_id);


CREATE TABLE GGP_Provision_Toll (
    provision_id NUMBER NOT NULL,
    toll_id NUMBER NOT NULL
);

ALTER TABLE GGP_Provision_Toll
ADD CONSTRAINT GGP_Provision_fk FOREIGN KEY (provision_id)
REFERENCES GGP_Provision (provision_id);

ALTER TABLE GGP_Provision_Toll
ADD CONSTRAINT GGP_Toll_fk FOREIGN KEY (toll_id)
REFERENCES GGP_Toll (toll_id);


CREATE TABLE GGP_Incident_Type (
    incident_type_id NUMBER NOT NULL,
    name VARCHAR2(250) NOT NULL
);

ALTER TABLE GGP_Incident_Type
ADD CONSTRAINT GGP_Incident_Type_pk PRIMARY KEY (incident_type_id);


CREATE TABLE GGP_Incident (
    incident_id NUMBER NOT NULL,
    description VARCHAR2(250) NOT NULL,
    incident_date DATE NOT NULL,
    time NUMBER NOT NULL,
    incident_type_id NUMBER NOT NULL
);

ALTER TABLE GGP_Incident
ADD CONSTRAINT GGP_Incident_pk PRIMARY KEY (incident_id);

ALTER TABLE GGP_Incident
ADD CONSTRAINT GGP_Incident_Type_fk FOREIGN KEY (incident_type_id)
REFERENCES GGP_Incident_Type (incident_type_id);


CREATE TABLE GGP_Aforo (
    aforo_id NUMBER NOT NULL,
    type VARCHAR2(250) NOT NULL,
    totalAforo FLOAT NOT NULL,
    is_collected CHAR(1) NOT NULL,
    sign  VARCHAR2(250),
    aforo_date DATE NOT NULL,
    latleitude FLOAT NOT NULL,
    longitude FLOAT NOT NULL,
    client_id NUMBER NOT NULL,
    temp_client_id  NUMBER,
    not_collected_id NUMBER NOT NULL,
    recipient_id NUMBER NOT NULL,
    photo_id NUMBER NOT NULL
);

ALTER TABLE GGP_Aforo
ADD CONSTRAINT GGP_Aforo_pk PRIMARY KEY (aforo_id);

ALTER TABLE GGP_Aforo
ADD CONSTRAINT GGP_Aforo_Client_fk FOREIGN KEY (client_id)
REFERENCES GGP_Client(client_id);

ALTER TABLE GGP_Aforo
ADD CONSTRAINT GGP_Aforo_Temp_Client_fk FOREIGN KEY (temp_client_id)
REFERENCES GGP_Temp_Client(temp_client_id);

ALTER TABLE GGP_Aforo
ADD CONSTRAINT GGP_Aforo_Not_Collected_fk FOREIGN KEY (not_collected_id)
REFERENCES GGP_Not_Collected(not_collected_id);


DROP TABLE GGP_Provision;