package learn.features.switchExpression;

import org.junit.jupiter.api.Test;

import static learn.features.switchExpression.SwitchExpressionInJava11.VehicleType.Bike;
import static learn.features.switchExpression.SwitchExpressionInJava11.VehicleType.Gear_less_Bike;
import static learn.features.switchExpression.SwitchExpressionInJava11.VehicleType.Mini_Truck;
import static learn.features.switchExpression.SwitchExpressionInJava11.collectTollFee;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SwitchExpressionInJava11Test {

    @Test
    void shouldCollectTollFeeForBike() {
        double tollFee = collectTollFee(Bike);

        assertEquals(80, tollFee);
    }

    @Test
    void shouldCollectTollFeeForMiniTruck() {
        double tollFee = collectTollFee(Mini_Truck);

        assertEquals(120, tollFee);
    }

    @Test
    void shouldCollectTollFeeForGearLessBike() {
        double tollFee = collectTollFee(Gear_less_Bike);

        assertEquals(60, tollFee);
    }

}