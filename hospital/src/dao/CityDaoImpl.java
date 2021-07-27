package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import entity.City;
import exception.CityDaoException;
import utility.JdbcConnection;

public class CityDaoImpl implements CityDao {

	public String addCity(City city) throws CityDaoException {
		try {
			int flag = 0;
			PreparedStatement stmnt = null;
			Connection conn = JdbcConnection.getConnection();
			String sqlquery = "INSERT INTO City values(?,?,?)";
			stmnt = conn.prepareStatement(sqlquery);
			stmnt.setInt(1, (city.getCityId()));
			stmnt.setString(2, city.getCityName());
			stmnt.setInt(3, (city.getRating()));
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
			throw new CityDaoException("SQL EXCEPTION");
		}

	}

	public List<City> getCitiesId() throws CityDaoException {
		try {
			Statement stmnt = null;
			Connection conn = JdbcConnection.getConnection();
			List<City> city = new LinkedList<City>();
			String sqlquery = "Select * from City";
			//stmnt = conn.prepareStatement(sqlquery);
			ResultSet rs = stmnt.executeQuery(sqlquery);
			while (rs.next()) {
				city.add(new City(rs.getInt("city_id"), rs.getString("city_name"), rs.getInt("city_rating")));
			}
			stmnt.close();
			JdbcConnection.closeConnection(conn);
			return city;
		} catch (SQLException e) {
			throw new CityDaoException("SQL EXCEPTION");
		}

	}

	public List<City> getCitiesByName() throws CityDaoException {
		try {
			PreparedStatement stmnt = null;
			Connection conn = JdbcConnection.getConnection();
			List<City> city = new LinkedList<City>();
			String sqlquery = "Select * from City";
			stmnt = conn.prepareStatement(sqlquery);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				city.add(new City(rs.getInt("city_id"), rs.getString("city_name"), rs.getInt("city_rating")));
			}
			stmnt.close();
			JdbcConnection.closeConnection(conn);
			return city;
		} catch (SQLException e) {
			throw new CityDaoException("SQL EXCEPTION");
		}
	}

}
