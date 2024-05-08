package failsafe;

import net.jodah.failsafe.event.ExecutionAttemptedEvent;
import net.jodah.failsafe.function.CheckedConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FailsafeListeners {

    private static final Logger LOGGER = LoggerFactory.getLogger(FailsafeListeners.class);

    public CheckedConsumer<ExecutionAttemptedEvent<Object>> getOnFailedAttemptListener() {
        return new CheckedConsumer<ExecutionAttemptedEvent<Object>>() {
            public void accept(ExecutionAttemptedEvent<Object> e) {
                LOGGER.info("Execution attempt failed : " + e.getLastFailure().getMessage());
            }
        };
    }

    public CheckedConsumer<ExecutionAttemptedEvent<Object>> getOnRetryListener() {
        return new CheckedConsumer<ExecutionAttemptedEvent<Object>>() {
            @Override
            public void accept(ExecutionAttemptedEvent<Object> e) throws Throwable {
                LOGGER.info("Failure #" + e.getAttemptCount());
            }
        };
    }
}
