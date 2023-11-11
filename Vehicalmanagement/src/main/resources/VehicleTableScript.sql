DROP SCHEMA IF EXISTS vehicle_management_db;
	
	CREATE SCHEMA vehicle_management_db;
	USE vehicle_management_db;
    
    CREATE TABLE vehicle (
    id INT PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(30) NOT NULL,
    year INT NOT NULL,
    model_name VARCHAR(30) NOT NULL,
    status VARCHAR(30) NOT NULL,
    sold_date DATE 
);

INSERT INTO vehicle VALUES(1001,'BMW',2002,'a6','UNSOLD',NULL);
INSERT INTO vehicle VALUES(1002,'AUDI',2002,'R8','SOLD','2015-09-12');
INSERT INTO vehicle VALUES(1003,'MARUTI',2002,'SWIFT','SOLD','2015-09-12');
INSERT INTO vehicle VALUES(1004,'MARUTI',2002,'EARTIGA','UNSOLD',NULL);


SELECT * FROM vehicle;