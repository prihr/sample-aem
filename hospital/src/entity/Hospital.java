package entity;

public class Hospital implements Comparable<Hospital>{
	private int hospitalId;
	private String hospitalName;
	private int bedCount;
	private int DoctorsCount;
	private City city;

	public Hospital(int hospitalId, String hospitalName, int bedCount, int doctorsCount) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.bedCount = bedCount;
		this.DoctorsCount = doctorsCount;
	}

	public Hospital(int hospitalId, String hospitalName, int bedCount, int doctorsCount, City city) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.bedCount = bedCount;
		this.DoctorsCount = doctorsCount;
		this.city = city;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getBedCount() {
		return bedCount;
	}

	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}

	public int getDoctorsCount() {
		return DoctorsCount;
	}

	public void setDoctorsCount(int doctorsCount) {
		DoctorsCount = doctorsCount;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public int compareTo(Hospital o) {
		// TODO Auto-generated method stub
		return o.getBedCount()-this.getBedCount();
	}

}
