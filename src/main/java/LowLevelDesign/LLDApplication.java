package LowLevelDesign;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class LLDApplication extends Application<LLDConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LLDApplication().run(args);
    }

    @Override
    public String getName() {
        return "LLD";
    }

    @Override
    public void initialize(final Bootstrap<LLDConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final LLDConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
