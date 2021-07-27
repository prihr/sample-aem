package entity;

public class City {
	private int cityId;
	private String cityName;
	private int rating;

	public City(int cityId) {
		super();
		this.cityId = cityId;
	}

	public City() {
		super();
	}

	public City(int cityId, String cityName, int rating) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.rating = rating;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
