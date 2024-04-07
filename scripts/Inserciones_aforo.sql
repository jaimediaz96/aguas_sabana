SELECT * FROM ggp_aforo_type

/
SELECT * FROM ggp_aforo
 /

 DELETE FROM ggp_aforo WHERE aforo_id = 1

 SELECT * FROM ggp_aforo

 INSERT INTO ggp_aforo (aforo_id, aforo_type_id, total_aforo, is_collected, aforo_sign, aforo_date, latleitude, longitude, micro_route_id, client_id, not_collected_id)
VALUES (1, 1, 100.5, 1, 'example sign', TO_DATE('2024-04-06', 'YYYY-MM-DD'), 1, 1, 1, 1, 1);
/

SELECT * FROM ggp_micro_route

SELECT * FROM ggp_not_collected

SELECT * FROM ggp_client

SELECT * FROM ggp_frequency

/
INSERT INTO ggp_client(client_id, company_name, address , frequency_id, aforo_type_id)
VALUES  (1,'dummyCompany','calle 123', 1,1);

SELECT * FROM ggp_frequency

INSERT INTO ggp_aforo_type (aforo_type_id , aforo_type_extern_id , name)
VALUES (1, 1, 'aforoTypePrueba')


INSERT INTO ggp_frequency(frequency_id , frequency_extern)
VALUES (1, 1)


INSERT INTO ggp_micro_route (micro_route_id, micro_route_name, micro_route_date_start, micro_route_date_finish, milage, micro_route_aforo_time, micro_route_trip_home_time, total_aforo, density, micro_route_sign, description_abandon, route_id, user_id, truck_id, state_micro_route_id)
VALUES (1, 'Nombre de la ruta', TO_DATE('2024-04-06', 'YYYY-MM-DD'), NULL, 100, NULL, NULL, NULL, NULL, 'Firma de la ruta', NULL, 1, 1, 1, 1);

SELECT * FROM ggp_route

SELECT * FROM ggp_user

SELECT * FROM ggp_truck

SELECT * FROM ggp_truck_capacity

SELECT * FROM ggp_truck


INSERT INTO ggp_truck(truck_id, plate, papers, maintenance, mileage,tire, pressure, fuel, light,honk,brake,oil, observation,truck_type_id,truck_capacity_id)
VALUES (1, '5r44', 1, TO_DATE('2024-04-06', 'YYYY-MM-DD'),1,'tire', 'pressure', 'fuel','light', 'honk','brake', 'oil','observation', 1,1)

INSERT INTO ggp_truck_capacity(truck_capacity_id, capacity)
VALUES (1, 5)


INSERT INTO ggp_route (route_id, route_name, description_route)
VALUES (1,'Nombre de la ruta', 'Descripcion')


INSERT INTO ggp_user(user_id, name, rol,username,password,email)
VALUES (1,'Nombre user', 'rol', 'username', 'contraseña', 'email')


SELECT * FROM ggp_fill_percentage

INSERT INTO ggp_fill_percentage(fill_percentage_id, percent)
VALUES (1, 5)

SELECT * FROM ggp_recipient_type


INSERT INTO ggp_recipient_type(recipient_type_id, name, recipient_value,aforo_type_id)
VALUES (1,'Nombre user', 1, 1)

SELECT * FROM ggp_fill_percentage
SELECT * FROM ggp_recipient

INSERT INTO ggp_recipient(recipient_id, quantity, fill_percentage_id,total,recipient_type_id,aforo_id)
VALUES (1,12, 1, 1 ,1,1)

DELETE FROM ggp_recipient WHERE recipient_id = 1
