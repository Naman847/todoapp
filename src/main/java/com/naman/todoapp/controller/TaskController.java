package com.naman.todoapp.controller;

import com.naman.todoapp.model.Task;
import com.naman.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping
    public String redirectToTasks() {
        // Redirect to /tasks/all whenever someone visits the root URL
        return "redirect:/tasks/all";
    }

    @GetMapping("/all")
    public String getTasks(Model model){
        List<Task> tasks=taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping("/create")
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/tasks/all";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/tasks/all";
    }

    @PostMapping("/{id}/toggle")
        public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/tasks/all";
    }





}
