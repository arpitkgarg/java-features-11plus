package learn.features.switchExpression;


public class SwitchExpressionInJava20 {
    public static double collectEntryFee(Vehicle vehicle) {

        return switch (vehicle) {
            case Car car && car.cc > 1200 -> 160.0;
            case Car car -> 120.0;
            case Truck truck && truck.noOfWheels > 4 -> 250.0;
            case Truck truck -> 200.0;
            case null -> 100.0;
            default -> throw new UnsupportedOperationException("Vehicle not allowed");
        };

    }

    public static class Vehicle {
        Integer cc;
        Integer noOfWheels;

        public Vehicle(Integer cc, Integer noOfWheels) {
            this.cc = cc;
            this.noOfWheels = noOfWheels;
        }
    }

    public static class Bike extends Vehicle {
        public Bike(Integer cc, Integer noOfWheels) {
            super(cc, noOfWheels);
        }
    }

    public static class Car extends Vehicle {
        public Car(Integer cc, Integer noOfWheels) {
            super(cc, noOfWheels);
        }
    }

    public static class Truck extends Vehicle {
        public Truck(Integer cc, Integer noOfWheels) {
            super(cc, noOfWheels);
        }
    }
}
