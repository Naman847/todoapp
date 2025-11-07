package com.naman.todoapp.service;

import com.naman.todoapp.model.Task;
import com.naman.todoapp.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void createTask(String title){
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);

    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    @Transactional
    public void toggleTask(Long id){
        Task task= taskRepository.getReferenceById(id);
        task.setCompleted(!task.isCompleted());
    }



}
