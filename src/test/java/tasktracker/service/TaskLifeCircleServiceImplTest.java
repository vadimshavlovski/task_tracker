package tasktracker.service;

import org.junit.Test;
import tasktracker.domain.Task;
import tasktracker.domain.TaskStatus;
import tasktracker.exception.InvalidTaskStateException;

import static org.junit.Assert.*;

public class TaskLifeCircleServiceImplTest {

    private static TaskLifeCircleServiceImpl taskLifeCircleService = new TaskLifeCircleServiceImpl();
    private static Task task = new Task();

    @Test
    public void setNewTaskToInProgress() throws Exception {

        task.setStatus(TaskStatus.NEW);
        taskLifeCircleService.setToInProgress(task);

        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }

    @Test
    public void setImplementedTaskToInProgress() throws Exception {

        task.setStatus(TaskStatus.IMPLEMENTED);
        taskLifeCircleService.setToInProgress(task);

        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }

    @Test(expected = InvalidTaskStateException.class)
    public void getInvalidTaskState() throws InvalidTaskStateException{

        task.setStatus(TaskStatus.CLOSED);

        taskLifeCircleService.implement(task);
    }
}