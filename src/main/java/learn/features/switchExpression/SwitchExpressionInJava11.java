package learn.features.switchExpression;


public class SwitchExpressionInJava11 {

    static double collectTollFee(VehicleType vehicleType) {
        double tollFee;
        switch (vehicleType) {
            case Bus:
            case Truck: {
                tollFee = 150.0;
                break;
            }
            case Tractor:
            case Mini_Truck:
            case Car: {
                tollFee = 120.0;
                break;
            }
            case Bike: {
                tollFee = 80;
                break;
            }
            case Gear_less_Bike: {
                tollFee = 60;
                break;
            }
            default:
                tollFee = 50;
        }

        return tollFee;
    }

    enum VehicleType {
        Bike, Gear_less_Bike, Car, Truck, Bus, Tractor, Mini_Truck
    }
}
