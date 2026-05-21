package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertVehiculo {

	private static final Logger log = LogManager.getLogger(InsertVehiculo.class);

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = """
				insert into vehiculos (placa,marca,modelo,anio,precio,color,disponible,kilometraje)
				values (?,?,?,?,?,?,?,?)
				""";
		try {
			con = Conexion.getConnection();
			
			ps = con.prepareStatement(sql);

			ps.setString(1, "PDF7236");
			ps.setString(2, "Chevrolet");
			ps.setString(3, "Aveo");
			ps.setInt(4, 2020);
			ps.setDouble(5, 10000);
			ps.setString(6, "Verde");
			ps.setBoolean(7, true);
			ps.setInt(8, 55789);
			
			int filas = ps.executeUpdate(); // Ejecuta la sentencia SQL y se guarda el valor representando el valor de
											// filas afectadas

			log.info("Sentencia ejecutada correctamente, # de vehiculo(s) registrado: " + filas);

		} catch (SQLException e) {
			log.error("Error SQL" + e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
					log.info("PreparedStatement cerrado");
				}
			} catch (SQLException e) {
				log.error("Error al cerrar PreparedStatement: " + e.getMessage());
			}
			try {
				if (con != null) {
					con.close();
					log.info("Conexion cerrada");
				}
			} catch (SQLException e) {
				log.error("Error al cerrar Connection: " + e.getMessage());

			}
		}

	}

}
