package garage0;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class GarageTest {

  public static  String MISSING_CAR = "Missing car!";
@Test public void testNewParkingIsEmpty() {
    assertTrue( newGarage3().isEmpty() );
  }

private Garage newGarage3() {
	return new Garage( 3 );
}

  @Test public void testNewParkingHasNoMoney() {
    assertEquals( 0, newGarage3().totalFees() );
  }

  @Test public void testParkOneCar() {
    assertFalse( garageWithRayoMacQueen().isEmpty());
  }

  @Test public void testOneCarFee() {
    assertEquals( Garage.basicFee, garageWithRayoMacQueen().totalFees() );
  }




  @Test public void testManyCarsFees() {
    Garage garage = newGarage3();

    Car car = rayoMacQueen();
    Car car2 = sally();
    garage.parkCar( car );
    garage.parkCar( car2 );
    assertEquals( 20, garage.totalFees() );
  }

private Car sally() {
	Car car2 = new Car( "DEF456" );
	return car2;
}

  @Test public void testInOutOneCar() {
    Garage garage = newGarage3();

    Car car = rayoMacQueen();
    garage.parkCar( car );
    assertFalse( garage.isEmpty() );
    garage.unparkCar( car );
    
    assertTrue( garage.isEmpty() );
  }

  @Test public void testInOutOneCarFees() {
    Garage garage = newGarage3();

    Car car = rayoMacQueen();
    garage.parkCar( car );
    assertFalse( garage.isEmpty() );
    garage.unparkCar( car );

    assertEquals( 10, garage.totalFees() );
  }

  @Test public void testUnparkAnEmptyLot() {
    try {
      newGarage3().unparkCar( new Car( "ABC123") );
    } catch ( Exception e ) {
      assertEquals(  MISSING_CAR, e.getMessage() );
    }
  }

  @Test public void testFullLot() {
    Garage garage = new Garage( 1 );
    Car car = rayoMacQueen();
    garage.parkCar( car );
 
    assertTrue( garage.cars.size() == garage.capacity );
  }

  @Test public void testOverFillLot() {
    Garage garage = new Garage( 1 );
    Car car = rayoMacQueen();
    garage.parkCar( car );
 
    try {
      garage.parkCar( new Car( "ABC123") );
    } catch ( Exception e ) {
      assertEquals( "No space available" , e.getMessage() );
    }

    assertEquals( 1, garage.getNumCars() );
  }
  
  @Test public void testRotateLot() {
    Garage garage = new Garage( 1 );
    Car car = rayoMacQueen();
    garage.parkCar( car );
    garage.unparkCar( car );
 
    garage.parkCar( new Car( "ABC123") );
    assertEquals( 1, garage.getNumCars() );

    assertEquals( 20, garage.totalFees() );
    
  }
  
  @Test public void testParkOneCarTwice() {
    Garage garage = newGarage3();

    Car car = rayoMacQueen();
    garage.parkCar( car );
    tryAndFailLike(garage, car);

    assertEquals( 1, garage.getNumCars() );
  }

private void tryAndFailLike(Garage garage, Car car) {
	try {
      garage.parkCar( car );
    } catch ( Exception e ) {
      assertEquals( "Twin Cars!", e.getMessage() );
    }
}
  @Test public void testManyCarsFeesOnMembers() {
	    Garage garage = newGarage3();

	    Car car = rayoMacQueen();
	    Car car2 = sally();
	    garage.associate( car );
	    garage.parkCar( car );
	    garage.parkCar( car2 );
	    assertEquals( 15, garage.totalFees() );
	  }
	 @Test public void testOneMemberCarFee() {
	    Garage garage = newGarage3();

	    Car car = rayoMacQueen();
	    garage.associate( car );
	    garage.parkCar( car );
	    assertEquals( 5, garage.totalFees() );
	  }	  
	 private Car rayoMacQueen() {
			Car car = new Car( "ABC123" );
			return car;
		}
	 private Garage garageWithRayoMacQueen() {
			Garage garage = newGarage3();
		    garage.parkCar( rayoMacQueen() );
			return garage;
		}


}
