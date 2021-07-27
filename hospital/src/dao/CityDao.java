package dao;

import java.util.List;

import entity.City;
import exception.CityDaoException;

public interface CityDao {
	/**
	 * @param city
	 * @return String
	 * @throws CityDaoException
	 */
	public String addCity(City city) throws CityDaoException;

	/**
	 * @return List<City>
	 * @throws CityDaoException
	 */
	public List<City> getCitiesId() throws CityDaoException;

	/**
	 * @return List<City>
	 * @throws CityDaoException
	 */
	public List<City> getCitiesByName() throws CityDaoException;

	
}
