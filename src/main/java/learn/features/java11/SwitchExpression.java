package learn.features.java11;


import static learn.features.java11.SwitchExpression.VehicleType.Bike;
import static learn.features.java11.SwitchExpression.VehicleType.Gear_less_Bike;
import static learn.features.java11.SwitchExpression.VehicleType.Mini_Truck;

public class SwitchExpression {
    public static void main(String[] args) {
        System.out.println("\n Toll Fee for Bike: " + collectTollFee(Bike));
        System.out.println("\n Toll Fee for Mini_Truck: " + collectTollFee(Mini_Truck));
        System.out.println("\n Toll Fee for Gear_less_Bike: " + collectTollFee(Gear_less_Bike));
    }

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
