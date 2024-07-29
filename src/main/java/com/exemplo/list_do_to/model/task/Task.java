package com.exemplo.list_do_to.model.task;

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

    private String initial_date;

    private String final_date;

    private String description;

    private String status;

    private Integer user_id;

//    public Task(String name, String initial_date, String final_date, String description, String status) {
//        this.name = name;
//        this.initial_date = initial_date;
//        this.final_date = final_date;
//        this.description = description;
//        this.status = status;
//    }

    public Task(TaskDTO taskDTO, Integer user_id) {
        this.name = taskDTO.getName();
        this.initial_date = taskDTO.getInitialDate();
        this.final_date = taskDTO.getFinalDate();
        this.description = taskDTO.getDescription();
        this.status = taskDTO.getStatus();
        this.user_id = user_id;
    }


}
