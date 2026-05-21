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

insert into nombreTabla (nombreColuma1,nombreColumaX...)
values (datoColumna1,datoColumna1,datoColumna1,...),


select * from vehiculos;