SELECT * FROM ggp_micro_route;

SELECT * FROM ggp_state_micro_route;

SELECT * FROM ggp_route;

SELECT * FROM ggp_truck;

SELECT * FROM ggp_client;

SELECT * FROM ggp_micro_route_client;

SELECT * FROM ggp_aforo_type;

SELECT * FROM ggp_aforo;

SELECT * FROM ggp_crew;

SELECT * FROM ggp_user;

SELECT mr.micro_route_id ,r.route_name ,r.description_route,mr.micro_route_name,t.plate
FROM ggp_micro_route mr
INNER JOIN ggp_route r ON mr.route_id = r.route_id
INNER JOIN ggp_truck t ON mr.truck_id = mr.truck_id
INNER JOIN ggp_state_micro_route smr ON mr.state_micro_route_id = smr.state_micro_route_id
WHERE mr.user_id = 1
AND smr.state = 'CREADA';


SELECT c.client_id , c.company_name, c.address , c.aforo_type_id, mrc.micro_route_id, mrc.client_id, mrc.micro_route_id, c.aforo_type_id
FROM  ggp_client c
INNER JOIN ggp_micro_route_client mrc ON mrc.client_id = c.client_id
INNER JOIN ggp_aforo_type aft ON c.aforo_type_id = aft.aforo_type_id

/
SELECT c.client_id , c.company_name, c.address , a.aforo_id, aft.name
FROM ggp_micro_route mr
INNER JOIN ggp_route r ON mr.route_id = r.route_id
INNER JOIN ggp_truck t ON mr.truck_id = mr.truck_id
INNER JOIN ggp_state_micro_route smr ON mr.state_micro_route_id = smr.state_micro_route_id
INNER JOIN ggp_micro_route_client mrc ON mrc.micro_route_id = mr.micro_route_id
INNER JOIN ggp_client c ON mrc.client_id = c.client_id
INNER JOIN ggp_aforo_type aft ON c.aforo_type_id = aft.aforo_type_id
INNER JOIN ggp_aforo a ON c.client_id = a.client_id
WHERE mr.user_id = 1
AND smr.state = 'CREADA';

/

SELECT density FROM ggp_micro_route;

UPDATE ggp_micro_route
SET density = 2.1234
WHERE micro_route_id = 1;

ALTER TABLE ggp_micro_route
MODIFY density NUMBER(6,2);



