package comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class SortCars {
	
	@Test
	public void SortingCars() {
		List<ZoomCars> al = new ArrayList<ZoomCars>();
		
		al.add(new ZoomCars("Tata Altroz","Premium Hatchback", "1200","600"));
		al.add(new ZoomCars("Hyundai i20","Premium Hatchback", "2400","1000"));
		al.add(new ZoomCars("Tata Nios","Compact Hatchback", "3000","1000"));
		al.add(new ZoomCars("Honda City","Sedan", "5000","2000"));
		al.add(new ZoomCars("Hyundai Verna","Premium Sedan", "2400","1000"));
		
		List<ZoomCars> distinctHatchback = al.stream().sorted(Comparator.comparing(ZoomCars::getCarName))
											.sorted(Comparator.comparing(ZoomCars::getCarPrice))
											.collect(Collectors.toList());
		
		for(int i=0;i<distinctHatchback.size();i++) {
			System.out.println(distinctHatchback.get(i).getCarName());
		}
		
	}

}
