package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteVehiculo {

	private static final Logger log = LogManager.getLogger(DeleteVehiculo.class);

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = """
				delete from vehiculos where placa = ?
				""";
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, "GRX7233");

			int filas = ps.executeUpdate(); // Ejecuta la sentencia SQL y se guarda el valor representando el valor de
											// filas afectadas

			log.info("Sentencia ejecutada correctamente, # de vehiculos eliminados: " + filas);

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
