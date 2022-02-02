package comparator;

public class ZoomCars {

	private String carName;
	private String carType;
	private String carPrice;
	private String carKms;
	
	public ZoomCars(String carName,String carType,String carPrice,String carKms) {
		this.carName = carName;
		this.carType = carType;
		this.carPrice = carPrice;
		this.carKms = carKms;
	}
	
	public String getCarName() {
		return carName;
	}
	
	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(String carPrice) {
		this.carPrice = carPrice;
	}

	public String getCarKms() {
		return carKms;
	}

	public void setCarKms(String carKms) {
		this.carKms = carKms;
	}
}
