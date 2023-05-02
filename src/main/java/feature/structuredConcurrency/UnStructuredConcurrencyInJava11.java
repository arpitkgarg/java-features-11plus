package feature.structuredConcurrency;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UnStructuredConcurrencyInJava11 {
    record AccountDetails(String name) {
    }

    record DemographicData(String name) {
    }

    record Response(AccountDetails accountDetails, List<DemographicData> userDetails) {
    }

    private AccountDetails getAccountDetails() {
        return new AccountDetails("AccountDetails");
    }

    private List<DemographicData> getDemographicData() {
        return List.of(new DemographicData("Buddy"), new DemographicData("Simba"));
    }

    public Response getResponse() {
        Future<AccountDetails> accountDetailsFuture;
        Future<List<DemographicData>> userDetailsFuture;
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
            accountDetailsFuture = executorService.submit(this::getAccountDetails);
            userDetailsFuture = executorService.submit(this::getDemographicData);

            AccountDetails accountDetails = accountDetailsFuture.get();   // Join the accountDetailsFuture
            List<DemographicData> userDetails = userDetailsFuture.get();  // Join the userDetailsFuture

            return new Response(accountDetails, userDetails);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // case 1: Error in getAccountDetails() -> error response returned but getDemographicDetails() still in progress
    // case 2: User cancels request -> response is interrupted but bth threads are still running in background
    // cancelling of subtasks is possible, we still cannot eliminate the chances of errors happening
}
