package learn.features.switchExpression;

public class SwitchExpressionInJava14 {

    static double collectTollFee(VehicleType vehicleType) {
        double tollFee = switch (vehicleType) {
            case Bus, Truck -> 150.0;
            case Tractor, Mini_Truck, Car -> 120.0;
            case Bike -> {
                yield 80;
            }
            case Gear_less_Bike -> 60;
        };

        return tollFee;
    }

    enum VehicleType {
        Bike, Gear_less_Bike, Car, Truck, Bus, Tractor, Mini_Truck
    }
}
