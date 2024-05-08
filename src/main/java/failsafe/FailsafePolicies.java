package failsafe;


import net.jodah.failsafe.RetryPolicy;

import java.time.Duration;

public class FailsafePolicies {
    private final FailsafeListeners failsafeListeners = new FailsafeListeners();

    public RetryPolicy<Object> getAssertionRetryPolicy() {
        return new RetryPolicy<>()
                .handle(AssertionError.class)
                .withDelay(Duration.ofSeconds(1))
                .withMaxRetries(5)
                .onFailedAttempt(failsafeListeners.getOnFailedAttemptListener())
                .onRetry(failsafeListeners.getOnRetryListener());
    }
}
