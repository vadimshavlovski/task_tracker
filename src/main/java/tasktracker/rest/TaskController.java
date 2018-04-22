package tasktracker.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tasktracker.domain.Task;
import tasktracker.repository.TaskRepository;
import tasktracker.service.TaskLifeCircleService;

@RepositoryRestController
public class TaskController {

    private TaskRepository taskRepository;

    private TaskLifeCircleService lifeCircleService;

    @Autowired
    public TaskController(TaskRepository taskRepository, TaskLifeCircleService lifeCircleService) {
        this.taskRepository = taskRepository;
        this.lifeCircleService = lifeCircleService;
    }

    @RequestMapping(value = "/tasks/{id}/to-in-progress", method = RequestMethod.POST)
    @ResponseBody
    public PersistentEntityResource setToInProgress(@PathVariable("id") Long id, PersistentEntityResourceAssembler asm){
        Task task = taskRepository.findById(id).get();
        lifeCircleService.setToInProgress(task);
        return asm.toFullResource(taskRepository.save(task));
    }

    @RequestMapping(value = "/tasks/{id}/implement", method = RequestMethod.POST)
    @ResponseBody
    public PersistentEntityResource implement(@PathVariable("id") Long id, PersistentEntityResourceAssembler asm){
        Task task = taskRepository.findById(id).get();
        lifeCircleService.implement(task);
        return asm.toFullResource(taskRepository.save(task));
    }

    @RequestMapping(value = "/tasks/{id}/close", method = RequestMethod.POST)
    @ResponseBody
    public PersistentEntityResource close(@PathVariable("id") Long id, PersistentEntityResourceAssembler asm){
        Task task = taskRepository.findById(id).get();
        lifeCircleService.close(task);
        return asm.toFullResource(taskRepository.save(task));
    }

}
