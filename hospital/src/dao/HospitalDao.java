package dao;

import java.util.List;
import java.util.Set;

import entity.Hospital;
import exception.HospitalDaoException;

public interface HospitalDao {
	/**
	 * @param hospital
	 * @return String
	 * @throws HospitalDaoException
	 */
	public String addHospital(Hospital hospital) throws HospitalDaoException;

	/**
	 * @param cityName
	 * @return Set<Hospital>
	 * @throws HospitalDaoException
	 */
	public Set<Hospital> getHospitalByCityName(String cityName) throws HospitalDaoException;

	/**
	 * @param cityName
	 * @return Count
	 * @throws HospitalDaoException
	 */
	public int countHospital(String cityName) throws HospitalDaoException;

	/**
	 * @param cityName
	 * @return Set<Hospital>
	 * @throws HospitalDaoException
	 */
	public Set<Hospital> showHospitalAsPerBedCount(String cityName) throws HospitalDaoException;

}
