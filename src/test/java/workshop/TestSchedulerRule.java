package workshop;

import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.TestScheduler;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class TestSchedulerRule implements TestRule {

    final TestScheduler testScheduler = new TestScheduler();

    @Override
    public Statement apply(final Statement base, Description d) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                RxJavaPlugins.setIoSchedulerHandler(
                        scheduler -> testScheduler);
                RxJavaPlugins.setComputationSchedulerHandler(
                        scheduler -> testScheduler);
                RxJavaPlugins.setNewThreadSchedulerHandler(
                        scheduler -> testScheduler);
                try {
                    base.evaluate();
                } finally {
                    RxJavaPlugins.reset();
                }
            }
        };
    }
}
