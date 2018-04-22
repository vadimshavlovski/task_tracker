package tasktracker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import tasktracker.domain.Task;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    //Method - GET, url - /tasks/search/in-progress
    @Query("select task from Task task where task.status = 'IN_PROGRESS'")
    @RestResource(path = "/in-progress")
    Page<Task> findInProgress(Pageable pageable);
}
