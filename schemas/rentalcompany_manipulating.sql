USE keith_denysiuk;

-- Join All Tables

SELECT *
FROM worker
JOIN building ON building_id_building = building.id_building
-- JOIN vehicles_has_order ON vehicles.id_vehicles = vehicles_id_vehicles
JOIN work_shift ON work_shift.id_work_shitf = worker.work_shift_id_work_shitf
JOIN job_position ON job_position.id_position = worker.position_idposition
-- JOIN location ON location.id_location = building.location_id_location
-- JOIN category ON category.id_category = model.category_id_category;
-- JOIN model ON model.id_model = vechicles.model_id_model;
-- JOIN licence ON licence.id_licence = user.licence_id_licence
-- JOIN user ON user.id_user = orders.user_id_user
-- JOIN insurance ON insurance.id_insurance = orders.insurance_id_insurance
;

-- Join (inner and outer)

SELECT user.id_user, licence.num, user.email
FROM user
INNER JOIN licence ON user.id_user=licence.id_licence;

SELECT user.id_user, licence.num, user.email
FROM user
RIGHT JOIN licence ON user.id_user=licence.id_licence;

SELECT user.id_user, licence.num, user.email
FROM user
LEFT JOIN licence ON user.id_user=licence.id_licence;

SELECT building.id_building, worker.w_name, building.b_name
FROM building
JOIN worker ON building.id_building=worker.building_id_building;

SELECT building.b_name, w_name
FROM worker
FULL JOIN building ON building.id_building=building_id_building;

-- Aggregate functions and group by and without having

SELECT COUNT(u_name) FROM keith_denysiuk.user WHERE u_name LIKE 'K%';
SELECT AVG(price_per_day) FROM keith_denysiuk.model WHERE id_model IN (1,3,5);
SELECT MAX(pay_per_hour) FROM keith_denysiuk.job_position;
SELECT MIN(pay_per_hour) FROM keith_denysiuk.job_position WHERE pay_per_hour LIKE (35);
SELECT SUM(price) FROM keith_denysiuk.insurance WHERE price IS NOT NULL;
SELECT expiration_date, COUNT(*) AS count FROM keith_denysiuk.licence GROUP BY expiration_date;
SELECT m_name, price_per_day FROM keith_denysiuk.model GROUP BY m_name, price_per_day;

-- Aggregate functions and group by and with having

SELECT id_model, m_name, AVG(price_per_day) FROM keith_denysiuk.model GROUP BY id_model, m_name HAVING (id_model < 3);
SELECT name_of_position, MIN(pay_per_hour) AS MinPrice FROM keith_denysiuk.job_position GROUP BY name_of_position HAVING MinPrice <60;
SELECT m_name, MAX(price_per_day) AS MaxPrice FROM keith_denysiuk.model GROUP BY m_name HAVING MaxPrice >20;

-- Updating tables

UPDATE user SET u_name = 'Martin Perez' WHERE id_user = 3;

UPDATE licence SET num = '11111111' WHERE id_licence = 1;

UPDATE insurance SET i_name = 'La tercera', price = 199 WHERE id_insurance = 2;

UPDATE location SET city = 'Santa Fe' WHERE id_location = 4;

UPDATE building SET b_name = 'Santa Fe Branch Office', address = '1150 Boggio Street' WHERE id_building = 5;

UPDATE model SET m_name = 'Ford Focus' WHERE id_model = 1;

UPDATE vehicles SET licence_plate = 'AF 898 KZ' WHERE id_vehicles = 1;

UPDATE work_shift SET time_range = '7:30 - 13:30' WHERE id_work_shitf = 1;

UPDATE worker SET w_name = 'Marcos Banderas' WHERE id_worker = 1;

UPDATE job_position SET pay_per_hour = 55 WHERE id_position = 1;

-- Deleting tables
    
DELETE FROM user WHERE id_user = 3;

DELETE FROM licence WHERE num = '11111111';

DELETE FROM insurance WHERE price = 199;

DELETE FROM location WHERE city = 'Santa Fe';

DELETE FROM building WHERE id_building = 5;

DELETE FROM model WHERE id_model = 1;

DELETE FROM vehicles WHERE id_vehicles = 1;

DELETE FROM work_shift WHERE time_range = '7:30 - 13:30';

DELETE FROM worker WHERE id_worker = 3;

DELETE FROM job_position WHERE pay_per_hour = 55;

-- Altering tables

ALTER TABLE user ADD sex VARCHAR(8);

ALTER TABLE model ADD year INT;

ALTER TABLE worker DROP COLUMN telephone;

ALTER TABLE user DROP COLUMN email;

ALTER TABLE user MODIFY sex VARCHAR(10);
