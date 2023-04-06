package learn.features.java14;

import static learn.features.java14.SwitchExpression.CaseWithMultipleConstants.VehicleType.Bike;
import static learn.features.java14.SwitchExpression.CaseWithMultipleConstants.VehicleType.Gear_less_Bike;
import static learn.features.java14.SwitchExpression.CaseWithMultipleConstants.VehicleType.Mini_Truck;

public class SwitchExpression {

     static class CaseWithMultipleConstants {

        public static void main(String[] args) {
            System.out.println("\n Toll Fee for Bike: " + collectTollFee(Bike));
            System.out.println("\n Toll Fee for Mini_Truck: " + collectTollFee(Mini_Truck));
            System.out.println("\n Toll Fee for Gear_less_Bike: " + collectTollFee(Gear_less_Bike));
        }

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
}
