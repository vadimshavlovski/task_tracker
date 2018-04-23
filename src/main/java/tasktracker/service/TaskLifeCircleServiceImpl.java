package tasktracker.service;

import org.springframework.stereotype.Component;
import tasktracker.domain.Task;
import tasktracker.domain.TaskStatus;
import tasktracker.exception.InvalidTaskStateException;

@Component
public class TaskLifeCircleServiceImpl implements TaskLifeCircleService{

    @Override
    public void setToInProgress(Task task) {
        setTaskStatus(task, TaskStatus.IN_PROGRESS, TaskStatus.NEW, TaskStatus.IMPLEMENTED);
    }

    @Override
    public void implement(Task task) {
        setTaskStatus(task, TaskStatus.IMPLEMENTED, TaskStatus.IN_PROGRESS);
    }

    @Override
    public void close(Task task) {
        setTaskStatus(task, TaskStatus.CLOSED, TaskStatus.IMPLEMENTED);
    }

    private void setTaskStatus(Task task, TaskStatus newStatus, TaskStatus ... allowedStatuses){
        boolean isStatusChanged = false;
        for (TaskStatus allowedStatus : allowedStatuses) {
            if (task.getStatus() == allowedStatus) {
                task.setStatus(newStatus);
                isStatusChanged = true;
            }
        }
        if(!isStatusChanged) {
            throw new InvalidTaskStateException(newStatus);
        }

    }
}
