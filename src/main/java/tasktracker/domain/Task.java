package tasktracker.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Identifiable;
import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Task implements Identifiable<Long>{

    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String description;

    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public Task(String name, String description, TaskStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }
}
