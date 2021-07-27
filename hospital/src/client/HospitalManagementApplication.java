package client;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import entity.City;
import entity.Hospital;
import exception.CityServiceException;
import exception.HospitalApplicationException;
import service.CityService;
import service.CityServiceImpl;
import service.HospitalService;
import service.HospitalServiceImpl;

public class HospitalManagementApplication {
	private static Scanner sc = new Scanner(System.in);
	private static CityService cityService = new CityServiceImpl();
	private static HospitalService hospitalService = new HospitalServiceImpl();

	public static void main(String[] args) throws HospitalApplicationException {
		int choice=0;
		String message="";
		try {
			do {
                menu();
				System.out.println("Enter your choice from above");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					message = addCity();
					System.out.println(message);
					break;
				case 2:
					message = addHospital();
					System.out.println(message);
					break;
				case 3:
					displayHospital();
					break;
				case 4:
					countHospital();
					break;
				case 5:
					showHospitalAsPerBedCount();
					break;
				default:
					System.out.println("Inavlid Input");
				}

			} while (choice != 6);
		} catch (HospitalApplicationException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void menu() {
		System.out.println("-----------------------------");
		System.out.println("ENTER 1 TO ADD CITY");
		System.out.println("ENTER 2 TO ADD HOSPITAL");
		System.out.println("ENTER 3 TO SHOW ALL HOSPITAL BY PARTICULAR CITY NAME");
		System.out.println("ENTER 4 TO COUNT THE NUMBER OF HOSPITAL IN PARTICULAR CITY");
		System.out.println("ENTER 5 TO SHOW ALL HOSPITAL OF A CITY AS PER BED COUNT");
		System.out.println("ENTER 6 TO EXIT");
		System.out.println("-----------------------------");
	}

	public static String addCity() throws HospitalApplicationException {
		try {
			System.out.println("Enter the city id");
			int cityId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the city Name");
			String cityName = sc.nextLine();
			System.out.println("Enter the city rating");
			int rating = sc.nextInt();
			sc.nextLine();
			City city = new City(cityId, cityName, rating);
			String msg = cityService.addCity(city);
			return msg;
		} catch (CityServiceException e) {
			throw new HospitalApplicationException(e.getMessage());
		}
	}

	public static String addHospital() throws HospitalApplicationException {
		try {
			City city = null;
			System.out.println("Enter the hospital id");
			int hospitalId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the hospital Name");
			String hospitalName = sc.nextLine();
			System.out.println("Enter the bed count");
			int bedCount = sc.nextInt();
			System.out.println("Enter the doctors count");
			int doctorsCount = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the city id");
			int cityId = sc.nextInt();
			city = cityService.getCitiesId(cityId);
			Hospital hospital = new Hospital(hospitalId, hospitalName, bedCount, doctorsCount,
					new City(city.getCityId()));
			System.out.println(hospital.getCity().getCityId());
			String msg = hospitalService.addHospital(hospital);
			return msg;

		} catch (CityServiceException e) {
			throw new HospitalApplicationException(e.getMessage());
		}
	}

	public static void displayHospital() throws HospitalApplicationException {
		try {
			Set<Hospital> hospital = new LinkedHashSet<Hospital>();
			sc.nextLine();
			System.out.println("Enter the city name");
			String cityName = sc.nextLine();
			Boolean res = cityService.getCitiesbyName(cityName);
			if (res == true) {
				hospital = hospitalService.getHospitalByCityName(cityName);
				System.out.println("CITY:" + " " + cityName);
				for (Hospital hospital2 : hospital) {
					System.out.println("Hospital ID :" + hospital2.getHospitalId() + " ," + " Hospital Name:"
							+ hospital2.getHospitalName() + ", " + "Total Beds Available:" + hospital2.getBedCount()
							+ " ," + " Total Doctors:" + hospital2.getDoctorsCount());
				}
			}

		} catch (CityServiceException e) {
			throw new HospitalApplicationException(e.getMessage());
		}
	}

	public static void countHospital() throws HospitalApplicationException {
		try {
			sc.nextLine();
			System.out.println("Enter the city name");
			String cityName = sc.nextLine();
			Boolean res = cityService.getCitiesbyName(cityName);
			if (res == true) {
				int count = hospitalService.countHospital(cityName);
				System.out.println("The number of hospitals in" + " " + cityName + " " + "is" + " " + count);
			}

		} catch (CityServiceException e) {
			throw new HospitalApplicationException(e.getMessage());
		}
	}

	public static void showHospitalAsPerBedCount() throws HospitalApplicationException {
		try {
			List<Hospital> hospital = new LinkedList<Hospital>();
			sc.nextLine();
			System.out.println("Enter the city name");
			String cityName = sc.nextLine();
			Boolean res = cityService.getCitiesbyName(cityName);
			if (res == true) {
				hospital = hospitalService.showHospitalAsPerBedCount(cityName);
				System.out.println("CITY:" + " " + cityName);
				for (Hospital hospital2 : hospital) {
					System.out.println("Hospital ID :" + hospital2.getHospitalId() + " ," + " Hospital Name:"
							+ hospital2.getHospitalName() + ", " + "Total Beds Available:" + hospital2.getBedCount()
							+ " ," + " Total Doctors:" + hospital2.getDoctorsCount());
				}
			}

		} catch (CityServiceException e) {
			throw new HospitalApplicationException(e.getMessage());
		}
	}

}
