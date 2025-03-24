package org.example;

import org.example.controller.JsonHandler;
import org.example.model.TaskDTO;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        JsonHandler.createJson();

        for(TaskDTO task : JsonHandler.readTasks()) {
            System.out.println(task.getName());
            System.out.println(task.getDescription());
        }

        JsonHandler.deleteTask("Terminar Task-Tracker-CLI");
    }
}