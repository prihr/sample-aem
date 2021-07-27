package service;

import java.util.LinkedList;
import java.util.List;

import dao.CityDao;
import dao.CityDaoImpl;
import entity.City;
import exception.CityDaoException;
import exception.CityNotFoundException;
import exception.CityServiceException;

public class CityServiceImpl implements CityService {
	public CityDao cityDao = new CityDaoImpl();

	public String addCity(City city) throws CityServiceException {
		try {
			String msg = cityDao.addCity(city);
			return msg;
		} catch (CityDaoException e) {
			throw new CityServiceException(e.getMessage());
		}

	}

	public City getCitiesId(int cityId) throws CityServiceException{
		try {
			int flag = 0;
			List<City> cities = new LinkedList<City>();
			City city = null;
			cities = cityDao.getCitiesId();
			for (City city2 : cities) {
				if (city2.getCityId() == cityId) {
					city = new City(city2.getCityId(), city2.getCityName(), city2.getRating());
					flag = 1;
				}
			}
			if (flag == 0) {
				throw new CityNotFoundException("CITY NOT FOUND");
			} else
				return city;

		} catch (CityDaoException e) {
			throw new CityServiceException(e.getMessage());
		}

	}

	public Boolean getCitiesbyName(String cityName) throws CityServiceException {
		try {
			int flag = 0;
			List<City> cities = new LinkedList<City>();
			cities = cityDao.getCitiesByName();
			for (City city : cities) {
				if (city.getCityName().compareToIgnoreCase(cityName) == 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				throw new CityNotFoundException("CITY NOT FOUND");
			} else
				return true;

		} catch (CityDaoException e) {
			throw new CityServiceException(e.getMessage());
		}
	}

}
