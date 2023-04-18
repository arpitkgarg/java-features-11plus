package learn.features.switchExpression;

import learn.features.switchExpression.SwitchExpressionInJava20.Bike;
import learn.features.switchExpression.SwitchExpressionInJava20.Car;
import learn.features.switchExpression.SwitchExpressionInJava20.Truck;
import org.junit.jupiter.api.Test;

import static learn.features.switchExpression.SwitchExpressionInJava20.collectEntryFee;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SwitchExpressionInJava20Test {

    @Test
    void shouldCollectEntryFeeForHatchBackCar() {
        Car hatchBackCar = new Car(1000, 4);
        double entryFee = collectEntryFee(hatchBackCar);

        assertEquals(120.0, entryFee);
    }

    @Test
    void shouldCollectEntryFeeForSUVCar() {
        Car suvCar = new Car(1400, 4);
        double entryFee = collectEntryFee(suvCar);

        assertEquals(160.0, entryFee);
    }

    @Test
    void shouldCollectEntryFeeForMiniTruck() {
        Truck miniTruck = new Truck(4500, 4);
        double entryFee = collectEntryFee(miniTruck);

        assertEquals(200.0, entryFee);
    }

    @Test
    void shouldCollectEntryFeeForTruck() {
        Truck truck = new Truck(5660, 8);
        double entryFee = collectEntryFee(truck);

        assertEquals(250.0, entryFee);
    }

    @Test
    void shouldReturn100AsEntryFeeIfVehicleTypeIsNull() {
        double entryFee = collectEntryFee(null);

        assertEquals(100.0, entryFee);
    }

    @Test
    void shouldThrowUnsupportedExceptionIfVehicleIsOtherThanCarOrTruck() {
        Bike bike = new Bike(200, 2);
        assertThrows(UnsupportedOperationException.class, () -> collectEntryFee(bike));
    }
}