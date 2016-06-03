package cucumber.runtime.arquillian.container;

import cucumber.runtime.arquillian.lifecycle.CucumberLifecycle;
import cucumber.runtime.arquillian.shared.EventHelper;
import cucumber.runtime.arquillian.shared.PersistenceExtensionIntegration;
import org.jboss.arquillian.container.test.spi.RemoteLoadableExtension;

public class CucumberContainerExtension implements RemoteLoadableExtension {
    @Override
    public void register(final ExtensionBuilder builder) {
        builder.observer(CucumberLifecycle.class)
                .observer(EventHelper.class);
        if (PersistenceExtensionIntegration.isOn()) {
            builder.observer(PersistenceExtensionIntegration.Observer.class);
        }
    }
}
