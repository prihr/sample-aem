package service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import dao.HospitalDao;
import dao.HospitalDaoImpl;
import entity.Hospital;
import exception.HospitalDaoException;
import exception.HospitalServiceException;
import exception.NoHospitalFoundException;

public class HospitalServiceImpl implements HospitalService {
	public HospitalDao hospitalDao = new HospitalDaoImpl();

	public String addHospital(Hospital hospital) throws HospitalServiceException {
		try {
			String msg = hospitalDao.addHospital(hospital);
			return msg;
		} catch (HospitalDaoException e) {
			throw new HospitalServiceException(e.getMessage());
		}
	}

	public Set<Hospital> getHospitalByCityName(String cityName) throws HospitalServiceException {
		try {
			Set<Hospital> hospital = hospitalDao.getHospitalByCityName(cityName);
			if (hospital.isEmpty()) {
				throw new NoHospitalFoundException("NO HOSPITAL FOUND");
			} else
				return hospital;
		} catch (HospitalDaoException e) {
			throw new HospitalServiceException(e.getMessage());
		}
	}

	public int countHospital(String cityName) throws HospitalServiceException {
		try {
			int count = hospitalDao.countHospital(cityName);
			if (count == 0) {
				throw new NoHospitalFoundException("NO HOSPITAL FOUND");

			} else
				return count;
		} catch (HospitalDaoException e) {
			throw new HospitalServiceException(e.getMessage());
		}
	}

	public List<Hospital> showHospitalAsPerBedCount(String cityName) throws HospitalServiceException {
		try {
			Set<Hospital> hospital = hospitalDao.showHospitalAsPerBedCount(cityName);
			List<Hospital> hospitals = new LinkedList<Hospital>(hospital);
			Collections.sort(hospitals);
			if (hospital.isEmpty()) {
				throw new NoHospitalFoundException("NO HOSPITAL FOUND");
			} else
				return hospitals;
		} catch (HospitalDaoException e) {
			throw new HospitalServiceException(e.getMessage());
		}
	}

}
