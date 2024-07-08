package com.exemplo.list_do_to.model;

import com.exemplo.list_do_to.dto.TaskDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name="tasks")
@Entity(name="tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String initialDate;

    private String finalDate;

    private String description;

    private String status;

    public Task(String name, String initialDate, String finalDate, String description, String status) {
        this.name = name;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.description = description;
        this.status = status;
    }

    public Task(TaskDTO taskDTO) {
        this.name = taskDTO.getName();
        this.initialDate = taskDTO.getInitialDate();
        this.finalDate = taskDTO.getFinalDate();
        this.description = taskDTO.getDescription();
        this.status = taskDTO.getStatus();
    }


}
