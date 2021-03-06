package tasktracker;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import tasktracker.domain.TaskValidator;


@Configuration
public class CustomRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", new TaskValidator());
    }
}
