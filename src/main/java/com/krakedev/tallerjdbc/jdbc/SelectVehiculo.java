package com.krakedev.tallerjdbc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.tallerjdbc.entidad.Vehiculo;

public class SelectVehiculo {

	private static final Logger log = LogManager.getLogger(InsertVehiculo.class);

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		

		String sql = """
				select * from vehiculos;
				""";

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String placa = rs.getString("placa");
				String marca = rs.getString("marca");
				String modelo = rs.getString("anio");
				int anio = rs.getInt("anio");
				double precio = rs.getDouble("precio");
				String color = rs.getString("color");
				boolean disponible = rs.getBoolean("disponible");
				
				Vehiculo vehiculo = new Vehiculo(placa,marca,modelo,anio,precio,color,disponible);
				
				log.info(vehiculo.toString());
			}

		} catch (SQLException e) {
			log.error("Error SQL" + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
					log.info("ResultSet cerrado");
				}
			} catch (SQLException e) {
				log.error("Error al cerrar ResultSet: " + e.getMessage());
			}
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
