package tasktracker.service;

import tasktracker.domain.Task;

public interface TaskLifeCircleService {

    void setToInProgress(Task task);

    void implement(Task task);

    void close(Task task);
}
