-- SEE PK
SELECT cols.table_name, cols.column_name
FROM user_constraints cons, user_cons_columns cols
WHERE cons.constraint_type = 'P'
AND cons.constraint_name = cols.constraint_name
AND cons.owner = cols.owner
AND cols.table_name = 'ggp_micro_route_client';

-- SEE FK
SELECT cols.table_name, cols.column_name, cons.r_constraint_name
FROM user_constraints cons, user_cons_columns cols
WHERE cons.constraint_type = 'R'
AND cons.constraint_name = cols.constraint_name
AND cons.owner = cols.owner
AND cols.table_name = 'ggp_micro_route_crew';

SELECT * FROM ggp_micro_route_crew;
--------------- INSERTS ---------------

INSERT INTO ggp_state_micro_route VALUES (1, 'CREADA');
INSERT INTO ggp_state_micro_route VALUES (2, 'INICIADA');
INSERT INTO ggp_state_micro_route VALUES (3, 'FINALIZADA');
INSERT INTO ggp_state_micro_route VALUES (4, 'FINALIZADA CON PENDIENTES');
INSERT INTO ggp_state_micro_route VALUES (5, 'REPOSTAJE');
INSERT INTO ggp_state_micro_route VALUES (6, 'INCIDENTE');
INSERT INTO ggp_state_micro_route VALUES (7, 'DISPOSICIÓN');

SELECT * FROM ggp_state_micro_route;

INSERT INTO ggp_truck_type VALUES (1, 'Camiones de carga trasera');
INSERT INTO ggp_truck_type VALUES (2, 'Camiones de carga frontal');
INSERT INTO ggp_truck_type VALUES (3, 'Camiones de carga lateral');
INSERT INTO ggp_truck_type VALUES (4, 'Compactadores');
INSERT INTO ggp_truck_type VALUES (5, 'Camiones para residuos peligrosos');
INSERT INTO ggp_truck_type VALUES (6, 'Camiones de reciclaje');
INSERT INTO ggp_truck_type VALUES (7, 'Camiones de basura eléctricos');
INSERT INTO ggp_truck_type VALUES (8, 'Camiones de vacío');
INSERT INTO ggp_truck_type VALUES (9, 'Camiones de volteo o dumper');
INSERT INTO ggp_truck_type VALUES (10, 'Camiones con grúa de carga');
INSERT INTO ggp_truck_type VALUES (11, 'Excavadoras');
INSERT INTO ggp_truck_type VALUES (12, 'Cargadoras frontales');
INSERT INTO ggp_truck_type VALUES (13, 'Camiones contenedor o contenedores de escombros');
INSERT INTO ggp_truck_type VALUES (14, 'Camiones de caja abierta');
INSERT INTO ggp_truck_type VALUES (15, 'Retroexcavadoras');
INSERT INTO ggp_truck_type VALUES (16, 'Bulldozers');
INSERT INTO ggp_truck_type VALUES (17, 'Volquetas');

SELECT * FROM ggp_truck_type;

INSERT INTO ggp_truck_capacity VALUES (1, 5);
INSERT INTO ggp_truck_capacity VALUES (2, 6);
INSERT INTO ggp_truck_capacity VALUES (3, 7);
INSERT INTO ggp_truck_capacity VALUES (4, 8);
INSERT INTO ggp_truck_capacity VALUES (5, 9);
INSERT INTO ggp_truck_capacity VALUES (6, 10);
INSERT INTO ggp_truck_capacity VALUES (7, 11);
INSERT INTO ggp_truck_capacity VALUES (8, 12);
INSERT INTO ggp_truck_capacity VALUES (9, 13);
INSERT INTO ggp_truck_capacity VALUES (10, 14);
INSERT INTO ggp_truck_capacity VALUES (11, 15);

SELECT * FROM ggp_truck_capacity;

INSERT INTO ggp_provision_type VALUES (1, 'ORGÁNICOS');
INSERT INTO ggp_provision_type VALUES (2, 'RECICLABLES');
INSERT INTO ggp_provision_type VALUES (3, 'ESPECIALES');
INSERT INTO ggp_provision_type VALUES (4, 'PELIGROSOS');

SELECT * FROM ggp_provision_type;

INSERT INTO ggp_provision_place VALUES (1, 'MONDOÑEDO');

SELECT * FROM ggp_provision_place;

INSERT INTO ggp_incident_type VALUES (1, 'Accidentes de tráfico');
INSERT INTO ggp_incident_type VALUES (2, 'Averías mecánicas');
INSERT INTO ggp_incident_type VALUES (3, 'Incendios en la carga');
INSERT INTO ggp_incident_type VALUES (4, 'Derrames de residuos');
INSERT INTO ggp_incident_type VALUES (5, 'Retrasos por condiciones climáticas adversas');
INSERT INTO ggp_incident_type VALUES (6, 'Conflictos con la comunidad local');
INSERT INTO ggp_incident_type VALUES (7, 'Robos o vandalismo');
INSERT INTO ggp_incident_type VALUES (8, 'Problemas de salud para los trabajadores');
INSERT INTO ggp_incident_type VALUES (9, 'Infracciones de tránsito');
INSERT INTO ggp_incident_type VALUES (10, 'Incumplimiento de normativas ambientales');
INSERT INTO ggp_incident_type VALUES (11, 'Otro');

SELECT * FROM ggp_incident_type;

INSERT INTO ggp_toll VALUES (1, '5364');

SELECT * FROM ggp_toll;

INSERT INTO ggp_not_collected VALUES (1, 10001, 'Recolección sin inconveniente');
INSERT INTO ggp_not_collected VALUES (2, 10002, 'Cerrado');
INSERT INTO ggp_not_collected VALUES (3, 10003, 'No permite la recolección');
INSERT INTO ggp_not_collected VALUES (4, 10004, 'Imposibilidad de acceso');
INSERT INTO ggp_not_collected VALUES (5, 10005, 'Incidente técnico');
INSERT INTO ggp_not_collected VALUES (6, 10006, 'Otro');

SELECT * FROM ggp_not_collected;

INSERT INTO ggp_fill_percentage VALUES (1, 1);
INSERT INTO ggp_fill_percentage VALUES (2, 0.75);
INSERT INTO ggp_fill_percentage VALUES (3, 0.5);
INSERT INTO ggp_fill_percentage VALUES (4, 0.25);

SELECT * FROM ggp_fill_percentage;

INSERT INTO ggp_aforo_type VALUES (1, 1, 'VOLUMEN');
INSERT INTO ggp_aforo_type VALUES (2, 2, 'ESPECIAL');
INSERT INTO ggp_aforo_type VALUES (3, 3, 'PESO');

SELECT * FROM ggp_aforo_type;

INSERT INTO ggp_recipient_type VALUES (1, 'BOLSA DOMÉSTICAS (50X75cm)', 0.031, 1);
INSERT INTO ggp_recipient_type VALUES (2, 'BOLSA SEMI-INDUSTRIAL (60X86cm)', 0.050, 1);
INSERT INTO ggp_recipient_type VALUES (3, 'BOLSA INDUSTRIAL (70X120cm)', 0.111, 1);
INSERT INTO ggp_recipient_type VALUES (4, 'CANECA 20 gal', 0.08, 1);
INSERT INTO ggp_recipient_type VALUES (5, 'CANECA 25 gal', 0.10, 1);
INSERT INTO ggp_recipient_type VALUES (6, 'CANECA 35 gal', 0.13, 1);
INSERT INTO ggp_recipient_type VALUES (7, 'CANECA 55 gal', 0.21, 1);
INSERT INTO ggp_recipient_type VALUES (8, 'CAJA ESTACIONARIA 2 yd3', 1.53, 1);
INSERT INTO ggp_recipient_type VALUES (9, 'CAJA ESTACIONARIA 2.5 yd3', 1.91, 1);
INSERT INTO ggp_recipient_type VALUES (10, 'CAJA ESTACIONARIA 3 yd3', 2.29, 1);
INSERT INTO ggp_recipient_type VALUES (11, 'CAJA ESTACIONARIA 4 yd3', 3.06, 1);
INSERT INTO ggp_recipient_type VALUES (12, 'CAJA ESTACIONARIA 6 yd3', 4.59, 1);
INSERT INTO ggp_recipient_type VALUES (13, 'CAJA ESTACIONARIA 10 yd3', 7.64, 1);
INSERT INTO ggp_recipient_type VALUES (14, 'CAJA ESTACIONARIA 15 yd3', 11.47, 1);
INSERT INTO ggp_recipient_type VALUES (15, 'CAJA ESTACIONARIA 20 yd3', 15.30, 1);
INSERT INTO ggp_recipient_type VALUES (16, 'CAJA ESTACIONARIA 40 yd3', 30.6, 1);
INSERT INTO ggp_recipient_type VALUES (17, 'RECOLECCIÓN DE ESCOMBROS', 1, 2);
INSERT INTO ggp_recipient_type VALUES (18, 'RECOLECCIÓN DE PODA', 1, 2);
INSERT INTO ggp_recipient_type VALUES (19, 'RECOLECCIÓN RESIDUOS ESPECIALES', 1, 2);
INSERT INTO ggp_recipient_type VALUES (20, 'RECOLECCIÓN RESIDUOS PELIGROSOS', 1, 2);
INSERT INTO ggp_recipient_type VALUES (21, 'BASCULA', 1, 3);

SELECT * FROM ggp_recipient_type;

INSERT INTO ggp_route VALUES (1, 'AZUL', 'TENJO');
INSERT INTO ggp_route VALUES (2, 'ROSA', 'FUNZA');
INSERT INTO ggp_route VALUES (3, 'VERDE', 'COTA');

SELECT * FROM ggp_route;

INSERT INTO ggp_frequency VALUES (1, 1);

SELECT * FROM ggp_frequency;

INSERT INTO ggp_crew VALUES (1, 'Andrés Santiago Jiménez Ramírez');
INSERT INTO ggp_crew VALUES (2, 'Santiago Andrés Gómez González');
INSERT INTO ggp_crew VALUES (3, 'Laura Daniela Torres Moreno');
INSERT INTO ggp_crew VALUES (4, 'Felipe Carlos Ramírez Torres');
INSERT INTO ggp_crew VALUES (5, 'Carlos Andrés González Moreno');
INSERT INTO ggp_crew VALUES (6, 'Daniela Laura Moreno Jimínez');

SELECT * FROM ggp_crew;

INSERT INTO ggp_truck VALUES (1, 'ABC544', 1, TO_DATE('2024-04-06', 'YYYY-MM-DD'),1,'EXCELENTE', 'EXCELENTE', 'LLENO','EXCELENTE', 'BUENO', 'COMPLETO', 'COMPLETO', 'OK', 4, 7);

SELECT * FROM ggp_truck;

INSERT INTO ggp_user VALUES (1,'Felipe Carlos Ramírez Torres', 'TECNICO', 'felra', 'con123', 'felra@email.com');

SELECT * FROM ggp_user;

INSERT INTO ggp_client VALUES (1, 'METALURGIA INDUSTRIAL S.A.', 'AUT. MEDELLÍN KM 1.5, BODEGA 6, PARQUE EMPRESARIAL SAN FERNANDO', 1, 1);
INSERT INTO ggp_client VALUES (2, 'ENERGÍA INDUSTRIAL RENOVABLE LTDA.', 'AUT MEDELLIN KIM 1,5 BOD. 6 PARQ EMPRE SAN BERNANDO', 1, 1);
INSERT INTO ggp_client VALUES (3, 'INGENIERÍA Y PROCESOS INDUSTRIALES LTDA.', 'CARRERA 2 # 3-45, BODEGA 10, PARQUE INDUSTRIAL EL PROGRESO', 1, 1);
INSERT INTO ggp_client VALUES (4, 'TECNOLOGÍA INDUSTRIAL AVANZADA S.A.', 'AVE, SEC IND MEDELLÍN, BOD 12, PARQUE DE NEGOCIOS LA ESPERANZA', 1, 2);
INSERT INTO ggp_client VALUES (5, 'FABRICACIÓN INDUSTRIAL GLOBAL INC.', 'CALLE 5 # 9-87, OFICINA 3, PARQUE DE TECNOLOGÍA LOS PINOS', 1, 1);
INSERT INTO ggp_client VALUES (6, 'MECÁNICA INDUSTRIAL INNOVADORA S.A.', 'AUTOPISTA MEDELLÍN KM 1.5, BODEGA 6, PARQUE LOGÍSTICO EL ROSAL', 1, 3);

SELECT * FROM ggp_client;

INSERT INTO ggp_micro_route VALUES (1, '12345', TO_DATE('2024-04-06', 'YYYY-MM-DD'), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1);

INSERT INTO ggp_micro_route_client VALUES (1, 1);
INSERT INTO ggp_micro_route_client VALUES (1, 2);
INSERT INTO ggp_micro_route_client VALUES (1, 3);
INSERT INTO ggp_micro_route_client VALUES (1, 4);
INSERT INTO ggp_micro_route_client VALUES (1, 5);
INSERT INTO ggp_micro_route_client VALUES (1, 6);

SELECT * FROM ggp_micro_route_client;

commit;