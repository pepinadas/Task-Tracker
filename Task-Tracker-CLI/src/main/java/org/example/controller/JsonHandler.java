package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.TaskDTO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {
    //Aqui va el codigo para manejar achivos JSON
    private static final String FILE_PATH = "tasks.json";
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void createJson() {
        List<TaskDTO> tasks = new ArrayList<>();
        TaskDTO task = new TaskDTO("Terminar Task-Tracker-CLI", "Esta tarea es la primera que agregare, y va basicamente de terminar esta app", false);
        tasks.add(task);

        try {
            objectMapper.writeValue(new File(FILE_PATH), tasks);
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addTask(TaskDTO task) {
        try {
            List<TaskDTO> tasks = readTasks();
            tasks.add(task);
            objectMapper.writeValue(new File(FILE_PATH), tasks);
            System.out.println("Task added to JSON file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<TaskDTO> readTasks() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, TaskDTO.class));
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void deleteTask(String taskName) {
        try {
            List<TaskDTO> tasks = readTasks();
            tasks.removeIf(task -> task.getName().equals(taskName));
            objectMapper.writeValue(new File(FILE_PATH), tasks);
            System.out.println("Task deleted from JSON file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateTask(String taskName, TaskDTO updatedTask) {
        try {
            List<TaskDTO> tasks = readTasks();
            for (TaskDTO task : tasks) {
                if (task.getName().equals(taskName)) {
                    task.setName(updatedTask.getName());
                    task.setDescription(updatedTask.getDescription());
                    task.setStatus(updatedTask.getStatus());
                    break;
                }
            }
            objectMapper.writeValue(new File(FILE_PATH), tasks);
            System.out.println("Task updated in JSON file successfully.");
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}