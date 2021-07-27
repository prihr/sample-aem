package service;

import java.util.List;
import java.util.Set;

import entity.Hospital;
import exception.HospitalServiceException;

public interface HospitalService {
	/**
	 * @param hospital
	 * @return String
	 * @throws HospitalServiceException
	 */
	public String addHospital(Hospital hospital) throws HospitalServiceException;

	/**
	 * @param cityName
	 * @return Set<Hospital>
	 * @throws HospitalServiceException
	 */
	public Set<Hospital> getHospitalByCityName(String cityName) throws HospitalServiceException;

	/**
	 * @param cityName
	 * @return count
	 * @throws HospitalServiceException
	 */
	public int countHospital(String cityName) throws HospitalServiceException;

	/**
	 * @param cityName
	 * @return List<Hospital>
	 * @throws HospitalServiceException
	 */
	public List<Hospital> showHospitalAsPerBedCount(String cityName) throws HospitalServiceException;

}
