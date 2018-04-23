package tasktracker.service;

import org.springframework.stereotype.Component;
import tasktracker.domain.Task;
import tasktracker.domain.TaskStatus;
import tasktracker.exception.InvalidTaskStateException;

@Component
public class TaskLifeCircleServiceImpl implements TaskLifeCircleService{

    @Override
    public void setToInProgress(Task task) {
        TaskStatus status = task.getStatus();
        if(status == TaskStatus.NEW || status == TaskStatus.IMPLEMENTED){
            task.setStatus(TaskStatus.IN_PROGRESS);
        } else
            throw new InvalidTaskStateException(TaskStatus.IN_PROGRESS);
    }

    @Override
    public void implement(Task task) {
        if(task.getStatus() == TaskStatus.IN_PROGRESS){
            task.setStatus(TaskStatus.IMPLEMENTED);
        } else
            throw new InvalidTaskStateException(TaskStatus.IMPLEMENTED);
    }

    @Override
    public void close(Task task) {
        if(task.getStatus() == TaskStatus.IMPLEMENTED){
            task.setStatus(TaskStatus.CLOSED);
        } else
            throw new InvalidTaskStateException(TaskStatus.CLOSED);
    }

}
