package garage0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Garage {
	
  public static int basicFee = 10;
  public int capacity;
  public List<Car> cars = new ArrayList<>();
  private int fees = 0;
  public Set<Car> members = new HashSet<>();

  public Garage( int size ) {
    this.capacity = size;
  }

  public boolean isEmpty() { return cars.isEmpty(); }

  public int getNumCars() { return cars.size(); }

  public Garage parkCar( Car car ) {
    if (cars.size() == capacity) { 
      throw new RuntimeException( "No space available" ); 
    }

    for (int i = 0; i < cars.size(); i++) {
      if (cars.get( i ).getPlateNumber().equals( car.getPlateNumber() )) {
        throw new RuntimeException( "Twin Cars!" ); 
      }
    }

    fees += getFee( car );
    cars.add( car );
    return this;
  }

  public Garage unparkCar( Car car ) {

    for (int i = 0; i < cars.size(); i++) {
      if (cars.get( i ).getPlateNumber().equals( car.getPlateNumber() )) {
        cars.remove( i );
        return this;
      }
    }
    throw new RuntimeException( "Missing car!" );
  }

  public int getFee( Car car ) {
    if (members.contains(car)) {
    	return 5;
    }
    else {
    	return 10;
    }
  }
  public int totalFees() {
    return fees;
  }

public Garage associate(Car car) {
		members.add(car);
		return this;
	
}

}