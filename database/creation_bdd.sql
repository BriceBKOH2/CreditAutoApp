--# ------------------------------------------------------------------

--# CREATION TABLES

--# ------------------------------------------------------------------

​--# Table ROLE----------------------------------------------

CREATE TABLE IF NOT EXISTS role_ (

    role_id SERIAL NOT NULL,
    role_name VARCHAR(75) NOT NULL,

    PRIMARY KEY (role_id)
);

--# Table USER----------------------------------------------

CREATE TABLE IF NOT EXISTS user_ (

    user_id SERIAL NOT NULL,
    user_firstname VARCHAR(75) NOT NULL,
    user_lastname VARCHAR(75) NOT NULL,
    user_login VARCHAR(75) NOT NULL,
    user_password VARCHAR(75) NOT NULL,
    user_mail VARCHAR(255) NOT NULL,
    user_role_id SERIAL NOT NULL,

    PRIMARY KEY (user_id),
    FOREIGN KEY (user_role_id) REFERENCES role_ (role_id)
);

​
--# Table RIGHT----------------------------------------------

CREATE TABLE IF NOT EXISTS right_ (

    right_id SERIAL NOT NULL,
    right_name VARCHAR(75) NOT NULL,

    PRIMARY KEY (right_id)
);

​
--# Table ROLE_RIGHT----------------------------------------------

CREATE TABLE IF NOT EXISTS role_right_ (

    role_fk SERIAL NOT NULL,
    right_fk SERIAL NOT NULL,

    FOREIGN KEY (role_fk) REFERENCES role_ (role_id),
    FOREIGN KEY (right_fk) REFERENCES right_ (right_id)
);

--# Table CLIENT----------------------------------------------

CREATE TABLE IF NOT EXISTS client_ (

    client_id SERIAL NOT NULL,
    client_firstname VARCHAR(75) NOT NULL,
    client_lasttname VARCHAR(75) NOT NULL,
    client_birth DATE NOT NULL,
    client_phone VARCHAR(75) NOT NULL,
    client_address TEXT NOT NULL,
    client_account_number BIGINT NOT NULL,

    PRIMARY KEY (client_id)
);

​
--# Table CAR CATEGORY----------------------------------------------

CREATE TABLE IF NOT EXISTS car_category_ (

    car_category_id SERIAL NOT NULL,
    car_category_name VARCHAR(75) NOT NULL,

    PRIMARY KEY (car_category_id)
);


--# Table CONTRACT----------------------------------------------

CREATE TABLE IF NOT EXISTS contract_ (

    contract_id SERIAL NOT NULL,
    contract_vehicle_price FLOAT NOT NULL,
    contract_amount FLOAT NOT NULL,
    contract_duration INT NOT NULL,
    contract_rate FLOAT NOT NULL,
    contract_rent_right BOOLEAN NOT NULL,
    contract_client_id SERIAL NOT NULL,
    contract_car_category_id SERIAL NOT NULL,

    PRIMARY KEY (contract_id),
    FOREIGN KEY (contract_client_id) REFERENCES client_ (client_id),
    FOREIGN KEY (contract_car_category_id) REFERENCES car_category_ (car_category_id)
);


--# Table RATE----------------------------------------------

CREATE TABLE IF NOT EXISTS rate_ (

    rate_id SERIAL NOT NULL,
    rate_name VARCHAR(75) NOT NULL,
    rate_amount FLOAT NOT NULL,

    PRIMARY KEY (rate_id)
);

​
--# Table DECISION----------------------------------------------

CREATE TABLE IF NOT EXISTS decision_ (

    decision_id SERIAL NOT NULL,
    decision_min_amount integer NOT NULL,
    decision_max_amount integer NOT NULL,
    decision_min_duration integer NOT NULL,
    decision_max_duration integer NOT NULL,
    decision_car_category_id SERIAL NOT NULL,
    decision_rate_id SERIAL NOT NULL,

    PRIMARY KEY (decision_id),
    FOREIGN KEY (decision_car_category_id) REFERENCES car_category_ (car_category_id),
    FOREIGN KEY (decision_rate_id) REFERENCES rate_ (rate_id)
);


--# Table CAR_COMPAGNY----------------------------------------------

CREATE TABLE IF NOT EXISTS car_company_ (

    car_company_id SERIAL NOT NULL,
    car_company_name VARCHAR(75) NOT NULL,

    PRIMARY KEY (car_company_id)
);


--# INSERTION --------------------------------------------------

INSERT INTO car_category_ (car_category_name) VALUES ('A'), ('B'), ('C'), ('D'), ('E'), ('F');

INSERT INTO rate_ (rate_name, rate_amount) VALUES ('T1', 0.65), 
                                                  ('T2', 0.34), 
                                                  ('T3', 0.45), 
                                                  ('T4', 0.21),
                                                  ('T5', 0.44), 
                                                  ('T6', 0.74);

INSERT INTO decision_ ( decision_min_amount,
                        decision_max_amount,
                        decision_min_duration,
                        decision_max_duration,
                        decision_car_category_id,
                        decision_rate_id ) 
                        VALUES 
                        (5000, 9999, 1, 30, 1, 1),
                        (5000, 9999, 31, 48, 1, 2),
                        (10000, 14999, 1, 24, 1, 2),
                        (10000, 14999, 25, 48, 1, 3),
                        (5000, 14999, 1, 18, 2, 3),
                        (5000, 14999, 19, 36, 2, 4),
                        (5000, 14999, 37, 48, 2, 5),
                        (15000, 25000, 1, 24, 2, 5),
                        (15000, 25000, 25, 48, 2, 6),
                        (25001, 50000, 25, 48, 2, 6);