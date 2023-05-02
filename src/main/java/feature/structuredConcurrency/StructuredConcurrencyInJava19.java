package feature.structuredConcurrency;


import jdk.incubator.concurrent.StructuredTaskScope;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

public class StructuredConcurrencyInJava19 {
    record AccountDetails(String name) { }

    record DemographicData(String name) { }

    record Response(AccountDetails accountDetails, List<DemographicData> userDetails) { }

    private AccountDetails getAccountDetails() {
        return new AccountDetails("AccountDetails");
    }

    private List<DemographicData> getDemographicData() {
        return List.of(new DemographicData("Buddy"), new DemographicData("Simba"));
    }

    public Response getReponse(){
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<AccountDetails> accountDetailsFuture = scope.fork(this::getAccountDetails);
            Future<List<DemographicData>> userDetailsFuture = scope.fork(this::getDemographicData);

            // Join all subtasks
            scope.join();
            scope.throwIfFailed(e -> new RuntimeException("ERROR_MESSAGE"));
            scope.joinUntil(Instant.now().plusSeconds(1));

            //The subtasks have completed by now so process the result
            return new Response(accountDetailsFuture.resultNow(), userDetailsFuture.resultNow());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
