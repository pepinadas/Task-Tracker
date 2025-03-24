package org.example.model;

import java.util.Objects;

public class TaskDTO {
    private String name;
    private String description;
    private Boolean status;

    public TaskDTO() {
    }

    public TaskDTO(String name, String description, Boolean status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return Objects.equals(name, taskDTO.name) && Objects.equals(description, taskDTO.description) && Objects.equals(status, taskDTO.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, status);
    }
}
