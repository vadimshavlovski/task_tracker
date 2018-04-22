package tasktracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tasktracker.domain.Task;
import tasktracker.repository.TaskRepository;
import tasktracker.domain.TaskStatus;

@Configuration
public class AppConfig{

    @Autowired
    private TaskRepository taskRepository;

    @Bean
    CommandLineRunner commandLineRunner(AppConfig dataLoader) {
        return (o) -> dataLoader.load();
    }

    private void load(){
        taskRepository.save(new Task("Create Enum", "Create enum for marital status with the ability to find an instance of id", TaskStatus.NEW));
        taskRepository.save(new Task("Strategy pattern", "Implement Strategy pattern", TaskStatus.NEW));
        taskRepository.save(new Task("Observer pattern", "Implement Observer pattern: Blogger, Subscriber, VasyaBlogger", TaskStatus.NEW));
        taskRepository.save(new Task("Adapter pattern", "Create adapter implements Costable (calcCost) for Priceble (getPrice)", TaskStatus.NEW));
        taskRepository.save(new Task("Builder pattern", "Create immutable object (Builder pattern)", TaskStatus.NEW));
        taskRepository.save(new Task("Template method pattern", "Implement Template method", TaskStatus.NEW));
        taskRepository.save(new Task("Composite pattern", "Implement Composite pattern", TaskStatus.NEW));
    }
}
