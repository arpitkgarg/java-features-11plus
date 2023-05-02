package feature.instanceOf;

import org.junit.jupiter.api.Test;

import static feature.instanceOf.InstanceOfInJava14.predictOffersFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InstanceOfInJava14Test {
    @Test
    void shouldPredictOfferForRegularCustomer() {
        InstanceOfInJava14.Customer customer = new InstanceOfInJava14.RegularCustomer();

        String actualOffer = predictOffersFor(customer);

        assertEquals(customer.offer(), actualOffer);
    }

    @Test
    void shouldPredictOfferForVIPCustomer() {
        InstanceOfInJava14.Customer customer = new InstanceOfInJava14.VIPCustomer();

        String actualOffer = predictOffersFor(customer);

        assertEquals(customer.offer(), actualOffer);
    }
}