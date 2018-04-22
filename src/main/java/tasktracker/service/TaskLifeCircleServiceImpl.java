package tasktracker.service;

import org.springframework.stereotype.Component;
import tasktracker.domain.Task;
import tasktracker.domain.TaskStatus;

@Component
public class TaskLifeCircleServiceImpl implements TaskLifeCircleService{

    @Override
    public void setToInProgress(Task task) {
        TaskStatus status = task.getStatus();
        if(status == TaskStatus.NEW || status == TaskStatus.IMPLEMENTED){
            task.setStatus(TaskStatus.IN_PROGRESS);
        } else
            throw new RuntimeException("cannot set task to IN PROGRESS");
    }

    @Override
    public void implement(Task task) {
        if(task.getStatus() == TaskStatus.IN_PROGRESS){
            task.setStatus(TaskStatus.IMPLEMENTED);
        } else
            throw new RuntimeException("cannot set task to IMPLEMENTED");
    }

    @Override
    public void close(Task task) {
        if(task.getStatus() == TaskStatus.IMPLEMENTED){
            task.setStatus(TaskStatus.CLOSED);
        } else
            throw new RuntimeException("cannot set task to CLOSED");
    }

}
