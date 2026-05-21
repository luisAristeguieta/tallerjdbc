package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {

	private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = """
				update vehiculos set marca =?,modelo=?,anio=?,precio=?,color=?,disponible=? where placa = ?
				""";
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, "Toyota");
			ps.setString(2, "Camry");
			ps.setInt(3, 2020);
			ps.setDouble(4, 16000);
			ps.setString(5, "Azul");
			ps.setBoolean(6, true);
			ps.setString(7, "GRX7233");

			int filas = ps.executeUpdate(); // Ejecuta la sentencia SQL y se guarda el valor representando el valor de
											// filas afectadas

			log.info("Sentencia ejecutada correctamente, # de vehiculos actualizados: " + filas);

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
