drop table if exists vehiculos;

CREATE TABLE vehiculos( 
	placa VARCHAR(10) PRIMARY KEY, 
	marca VARCHAR(50) NOT NULL, 
	modelo VARCHAR(50) NOT NULL, 
	anio INT NOT NULL, 
	precio DOUBLE PRECISION NOT NULL, 
	color VARCHAR(30), 
	disponible BOOLEAN NOT NULL 
	);

insert into vehiculos (placa,marca,modelo,anio,precio,color,disponible)
values ('PDF1025','Chevrolet','Sail',2025,10000,'Blanco',TRUE);

INSERT INTO vehiculos
(placa, marca, modelo, anio, precio, color, disponible)
VALUES
('PBC1234', 'Toyota', 'Corolla', 2020, 18500.50, 'Rojo', true),
('GBD4567', 'Chevrolet', 'Spark GT', 2019, 12500.00, 'Blanco', true),
('PCE7891', 'Hyundai', 'Tucson', 2022, 32000.75, 'Negro', false),
('GDF3218', 'Kia', 'Sportage', 2021, 28990.99, 'Azul', true),
('PEG6542', 'Mazda', 'CX-5', 2023, 41000.00, 'Gris', true),
('GHI9876', 'Nissan', 'Sentra', 2018, 14999.90, 'Plateado', false),
('PJK7415', 'Ford', 'Escape', 2020, 26750.45, 'Verde', true),
('GLM8529', 'Volkswagen', 'Jetta', 2021, 23999.99, 'Blanco', false);


select * from vehiculos;