package feature.instanceOf;

public class InstanceOfInJava11 {
    public static String predictOffersFor(Customer customer) {
        if (customer instanceof RegularCustomer) {
            RegularCustomer regularCustomer = (RegularCustomer) customer; // Redundant casting
            // other customer operations
            return regularCustomer.offer();
        } else if (customer instanceof VIPCustomer) {
            VIPCustomer vipCustomer = (VIPCustomer) customer; // Redundant casting
            // other customer operations
            return vipCustomer.offer();
        }
        return customer.offer();
    }

    interface Customer {
        String offer();
    }

    static class RegularCustomer implements Customer {
        @Override
        public String offer() {
            return "NOT AVAILABLE";
        }
    }

    static class VIPCustomer implements Customer {
        @Override
        public String offer() {
            return "AVAILABLE";
        }
    }
}
