package   包 com.todonow.controller;

import com.todonow.model.Task;进口com.todonow.model.Task;
import com.todonow.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;进口org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;   进口并不知道;
import java.util.Optional;进口java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired   @ autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}

