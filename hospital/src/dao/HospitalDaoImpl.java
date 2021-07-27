package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import entity.Hospital;
import exception.HospitalDaoException;
import utility.JdbcConnection;

public class HospitalDaoImpl implements HospitalDao {

	public String addHospital(Hospital hospital) throws HospitalDaoException {
		try {
			int flag = 0;
			PreparedStatement stmnt = null;
			Connection conn = JdbcConnection.getConnection();
			String sqlquery = "INSERT INTO hospitals values(?,?,?,?,?)";
			stmnt = conn.prepareStatement(sqlquery);
			stmnt.setInt(1, (hospital.getHospitalId()));
			stmnt.setString(2, hospital.getHospitalName());
			stmnt.setInt(3, (hospital.getBedCount()));
			stmnt.setInt(4, (hospital.getDoctorsCount()));
			stmnt.setInt(5, (hospital.getCity().getCityId()));
			int rowCount = stmnt.executeUpdate();
			if (rowCount > 0)
				flag = 1;
			stmnt.close();
			JdbcConnection.closeConnection(conn);
			if (flag == 1)
				return "City Inserted Successfully";
			else
				return "Sorry!! Data cannot be inserted";
		} catch (SQLException e) {
			throw new HospitalDaoException(e.getMessage());
		}
	}

	public Set<Hospital> getHospitalByCityName(String cityName) throws HospitalDaoException {
		try {

			PreparedStatement stmnt = null;
			Connection conn = JdbcConnection.getConnection();
			Set<Hospital> hospitals = new LinkedHashSet<Hospital>();
			String sqlquery = "select h.hospital_id,h.hospital_name,h.bedCount,h.doctorsCount from hospitals h inner join city c on h.city_id=c.city_id where c.city_name = ?";
			stmnt = conn.prepareStatement(sqlquery);
			stmnt.setString(1, cityName);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				hospitals.add(new Hospital(rs.getInt("hospital_id"), rs.getString("hospital_name"),
						rs.getInt("bedCount"), rs.getInt("doctorsCount")));
			}
			stmnt.close();
			JdbcConnection.closeConnection(conn);
			return hospitals;
		} catch (SQLException e) {
			throw new HospitalDaoException(e.getMessage());
		}
	}

	public int countHospital(String cityName) throws HospitalDaoException {
		try {

			PreparedStatement stmnt = null;
			Connection conn = JdbcConnection.getConnection();
			int count = 0;
			String sqlquery = "select count(*) from hospitals h inner join\r\n"
					+ " city c on h.city_id=c.city_id where h.city_id=c.city_id and c.city_name=?";
			stmnt = conn.prepareStatement(sqlquery);
			stmnt.setString(1, cityName);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count(*)");
			}
			stmnt.close();
			JdbcConnection.closeConnection(conn);
			return count;
		} catch (SQLException e) {
			throw new HospitalDaoException(e.getMessage());
		}
	}

	public Set<Hospital> showHospitalAsPerBedCount(String cityName) throws HospitalDaoException {
		try {

			PreparedStatement stmnt = null;
			Connection conn = JdbcConnection.getConnection();
			Set<Hospital> hospitals = new LinkedHashSet<Hospital>();
			String sqlquery = "select h.hospital_id,h.hospital_name,h.bedCount,h.doctorsCount from hospitals h inner join\r\n"
					+ " city c on h.city_id=c.city_id where c.city_name=?";
			stmnt = conn.prepareStatement(sqlquery);
			stmnt.setString(1, cityName);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				hospitals.add(new Hospital(rs.getInt("hospital_id"), rs.getString("hospital_name"),
						rs.getInt("bedCount"), rs.getInt("doctorsCount")));
			}
			stmnt.close();
			JdbcConnection.closeConnection(conn);
			return hospitals;
		} catch (SQLException e) {
			throw new HospitalDaoException(e.getMessage());
		}
	}

}
