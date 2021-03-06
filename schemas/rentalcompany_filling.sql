USE keith_denysiuk;

INSERT INTO licence (num, expiration_date)
VALUES ("42189423", 2024),
("36755475", 2023),
("17489576", 2023),
("42222597", 2022),
("40176543", 2024);

INSERT INTO user (u_name, telephone, email, licence_id_licence)
VALUES ("Keith Denysiuk", "3735404649", "kmld1999@gmail.com", (SELECT id_licence FROM licence WHERE num ="42189423")),
("Silvia Gether", "3735444828", "silgrax3@gmail.com", (SELECT id_licence FROM licence WHERE num ="36755475")),
("Juan Lopez", "3624998765", "juanlop@gmail.com", (SELECT id_licence FROM licence WHERE num ="17489576")),
("Bruno Diaz", "3773508669", "kmld1999@gmail.com", (SELECT id_licence FROM licence WHERE num ="42222597")),
("Ana Roman", "3624674532", "kmld1999@gmail.com", (SELECT id_licence FROM licence WHERE num ="40176543"));

INSERT INTO insurance (i_name, price, insurance_type)
VALUES ("Galeno", 150, "Cars"),
("La Segunda", 200, "Full"),
("San Cristobal", 175, "Cars and Driver");

INSERT INTO location (city)
VALUES ("Resistencia"),
("Corrientes"),
("Rosario"),
("Parana");

INSERT INTO building (b_name, address, location_id_location)
VALUES ("Central Office", "1394 Sarmiento Avenue", (SELECT id_location FROM location WHERE city ="Resistencia")),
("Corrientes Branch Office", "145 2 de Abril Avenue", (SELECT id_location FROM location WHERE city ="Corrientes")),
("Rosario Branch Offiece A", "478 San Marin Avenue", (SELECT id_location FROM location WHERE city ="Rosario")),
("Rosario Branch Offiece B", "2378 Colon Street", (SELECT id_location FROM location WHERE city ="Rosario")),
("Parana Branch Offiece", "478 Mitre Street", (SELECT id_location FROM location WHERE city ="Parana"));

INSERT INTO job_position (name_of_position, pay_per_hour)
VALUES ("Manager", 60),
("Customer Assistant", 35);

INSERT INTO work_shift (time_range)
VALUES ("7:00-13:00"),
("13:00-19:00");

INSERT INTO worker (w_name, telephone, email, building_id_building, position_idposition, work_shift_id_work_shitf)
VALUES ("Pedro Martinez", "3624547634", "pedrimarti@gmail.com", 1, 1, 1),
("Maria Mercedez", "3624767689", "marimari@gmail.com", 1, 2, 1),
("Elian Juarez", "3624676755", "juarezelian@gmail.com", 1, 2, 2);

INSERT INTO orders (user_id_user, order_date, insurance_id_insurance, worker_id_worker)
VALUES (1, "05-15-2022 to 06-15-2022", 1, 3),
(1, "05-15-2022 to 06-15-2022", 1, 2),
(2, "04-20-2022 to 05-01-2022", 2, 3),
(3, "06-10-2022 to 06-25-2022", 2, 2),
(4, "05-31-2022 to 07-12-2022", 3, 3),
(5, "05-17-2022 to 06-05-2022", 1, 2);

INSERT INTO category (vehicle_type)
VALUES ("Car"),
("Van");

INSERT INTO model (m_name, price_per_day, category_id_category)
VALUES ("Ford Fiesta", 20, (SELECT id_category FROM category WHERE vehicle_type ="Car")),
("Ford Transit Passenger", 30, (SELECT id_category FROM category WHERE vehicle_type ="Van")),
("Volkswagen Bora", 17, (SELECT id_category FROM category WHERE vehicle_type ="Car")),
("Volkswagen Van T6", 25, (SELECT id_category FROM category WHERE vehicle_type ="Van")),
("Audi A5", 25, (SELECT id_category FROM category WHERE vehicle_type ="Car"));

INSERT INTO vehicles (licence_plate, model_id_model)
VALUES ("AB 234 FA", 3),
("AF 432 ED", 1),
("AF 563 DS", 2),
("AF 663 DD", 5),
("AF 112 FG", 4);

INSERT INTO vehicles_has_order (vehicles_id_vehicles, order_id_order, date_of_order)
VALUES (1, 1, "2022-05-10"),
(3, 2, "2022-05-11"),
(2, 3, "2022-05-03"),
(5, 4, "2022-05-05"),
(4, 5, "2022-05-02");

















