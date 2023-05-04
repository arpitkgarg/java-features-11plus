package feature.switchExpression;

import org.junit.jupiter.api.Test;

import static feature.switchExpression.SwitchExpressionInJava20.*;
import static feature.switchExpression.SwitchExpressionInJava20.collectEntryFee;
import static org.junit.jupiter.api.Assertions.*;

class SwitchExpressionInJava20Test {

    @Test
    void shouldCalculateEntryFeeForSUVCars(){
        Car suv = new Car(1400, 4);
        double entryFee = collectEntryFee(suv);

        assertEquals(160.0, entryFee);
    }

    @Test
    void shouldCalculateEntryFeeForHatchBackCars(){
        Car hatchBack = new Car(1000, 4);
        double entryFee = collectEntryFee(hatchBack);

        assertEquals(120.0, entryFee);
    }

    @Test
    void shouldCalculateEntryFeeForMiniTruck(){
        Truck miniTruck = new Truck(2000, 4);
        double entryFee = collectEntryFee(miniTruck);

        assertEquals(200.0, entryFee);
    }

    @Test
    void shouldCalculateEntryFeeForLargeTruck(){
        Truck miniTruck = new Truck(2400, 8);
        double entryFee = collectEntryFee(miniTruck);

        assertEquals(250.0, entryFee);
    }

    @Test
    void shouldReturn100AsEntryFeeForNonVehicle(){
        double entryFee = collectEntryFee(null);
        assertEquals(100.0, entryFee);
    }

    @Test
    void shouldReturnUnsupportedExceptionWhenVehicleTypeIsUnknown(){
        Bike bike = new Bike(150, 2);

        assertThrows(UnsupportedOperationException.class, ()-> collectEntryFee(bike));
    }
}
