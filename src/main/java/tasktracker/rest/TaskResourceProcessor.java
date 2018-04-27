package tasktracker.rest;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;
import tasktracker.domain.Task;
import tasktracker.domain.TaskStatus;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@AllArgsConstructor
@Component
public class TaskResourceProcessor implements ResourceProcessor<Resource<Task>>{

    private RepositoryEntityLinks entityLinks;

    @Override
    public Resource<Task> process(Resource<Task> resource) {
        Task task = resource.getContent();

        //update
        //delete
        if(task.getStatus() == TaskStatus.NEW){
            resource.add(entityLinks.linkToSingleResource(task).withRel("update"));
            resource.add(entityLinks.linkToSingleResource(task).withRel("delete"));
        }
        
        //to-in-progress
        if(task.getStatus() == TaskStatus.NEW || task.getStatus() == TaskStatus.IMPLEMENTED){
            resource.add(linkTo(methodOn(TaskController.class)
                    .setToInProgress(task.getId(), null)).withRel("set-to-in_progress"));
        }

        //implement
        if(task.getStatus() == TaskStatus.IN_PROGRESS){
            resource.add(linkTo(methodOn(TaskController.class)
                    .implement(task.getId(), null)).withRel("implement"));
        }

        //close
        if(task.getStatus() == TaskStatus.IMPLEMENTED){
            resource.add(linkTo(methodOn(TaskController.class)
                    .close(task.getId(), null)).withRel("close"));
        }

        return resource;
    }

}
