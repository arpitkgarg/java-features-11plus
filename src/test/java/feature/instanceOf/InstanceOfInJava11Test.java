package feature.instanceOf;

import org.junit.jupiter.api.Test;

import static feature.instanceOf.InstanceOfInJava11.predictOffersFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InstanceOfInJava11Test {

    @Test
    void shouldPredictOfferForRegularCustomer() {
        InstanceOfInJava11.Customer customer = new InstanceOfInJava11.RegularCustomer();

        String actualOffer = predictOffersFor(customer);

        assertEquals(customer.offer(), actualOffer);
    }

    @Test
    void shouldPredictOfferForVIPCustomer() {
        InstanceOfInJava11.Customer customer = new InstanceOfInJava11.VIPCustomer();

        String actualOffer = predictOffersFor(customer);

        assertEquals(customer.offer(), actualOffer);
    }
}