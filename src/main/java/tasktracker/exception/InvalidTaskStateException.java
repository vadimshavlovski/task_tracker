package tasktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import tasktracker.domain.TaskStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InvalidTaskStateException extends RuntimeException {

    public InvalidTaskStateException(String message) {
        super(message);
    }

    public InvalidTaskStateException(TaskStatus status) {
        super(String.format("Cannot set task to %s", status));
    }
}
