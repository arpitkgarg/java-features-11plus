package feature.nullpointerGuidance;

import feature.nullPointerGuidance.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {
    @Test
    void shouldThrowExceptionWithFieldName() {
        User john = new User();

        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            john.userDetail.address.firstLine = "ABC Apartment";
        });

        assertEquals(exception.getMessage(), "Cannot read field \"address\" because \"john.userDetail\" is null");


        // Before Java 17

            /*
                Exception in thread "main" java.lang.NullPointerException
                    at learn.features.nullPointerGuidance.User.main(User.java:10)
             */

        // After Java 17

            /*
            Exception in thread "main" java.lang.NullPointerException: Cannot read field "address" because "<local1>.userDetail" is null
                at learn.features.nullPointerGuidance.User.main(User.java:10)
             */
    }
}