package service;

import entity.City;
import exception.CityServiceException;

public interface CityService {
	/**
	 * @param city
	 * @return String
	 * @throws CityServiceException
	 */
	public String addCity(City city) throws CityServiceException;

	/**
	 * @param cityId
	 * @return City
	 * @throws CityServiceException
	 */
	public City getCitiesId(int cityId) throws CityServiceException;

	/**
	 * @param cityName
	 * @return Boolean
	 * @throws CityServiceException
	 */
	public Boolean getCitiesbyName(String cityName) throws CityServiceException;

}
