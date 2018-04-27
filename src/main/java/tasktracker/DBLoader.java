package tasktracker;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tasktracker.domain.Task;
import tasktracker.domain.TaskStatus;
import tasktracker.repository.TaskRepository;

@AllArgsConstructor
@Component
public class DBLoader implements CommandLineRunner {

    private final TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        taskRepository.save(new Task("Create Enum", "Create enum for marital status with the ability to find an instance of id", TaskStatus.NEW));
        taskRepository.save(new Task("Strategy pattern", "Implement Strategy pattern", TaskStatus.NEW));
        taskRepository.save(new Task("Observer pattern", "Implement Observer pattern: Blogger, Subscriber, VasyaBlogger", TaskStatus.NEW));
        taskRepository.save(new Task("Adapter pattern", "Create adapter implements Costable (calcCost) for Priceble (getPrice)", TaskStatus.NEW));
        taskRepository.save(new Task("Builder pattern", "Create immutable object (Builder pattern)", TaskStatus.NEW));
        taskRepository.save(new Task("Template method pattern", "Implement Template method", TaskStatus.NEW));
        taskRepository.save(new Task("Composite pattern", "Implement Composite pattern", TaskStatus.NEW));

    }
}
