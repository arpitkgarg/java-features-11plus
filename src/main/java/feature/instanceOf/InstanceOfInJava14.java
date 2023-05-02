package feature.instanceOf;

public class InstanceOfInJava14 {
    public static String predictOffersFor(Customer customer) {
        if (customer instanceof RegularCustomer regularCustomer) {
            // other customer operations
            return regularCustomer.offer();
        } else if (customer instanceof VIPCustomer vipCustomer) {
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
