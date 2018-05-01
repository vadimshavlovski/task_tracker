package tasktracker.domain;

import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TaskValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Task.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@Nullable Object target, Errors errors) {
        Task task = (Task) target;
        if (task.getStatus() != TaskStatus.NEW){
            errors.rejectValue("status", "task.status.invalid", "The new task must have NEW status");
        }
    }
}
