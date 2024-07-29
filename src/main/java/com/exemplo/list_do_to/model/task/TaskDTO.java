package com.exemplo.list_do_to.model.task;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;

public class TaskDTO {

        private Long id;
        @NotBlank
        private String name;

        private String initial_date;

        private String final_date;

        private String description;

        private String status;

        private String token;


        public Long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getInitialDate() {
                return initial_date;
        }

        public void setInitialDate(String initialDate) {
                this.initial_date = initial_date;
        }

        public String getFinalDate() {
                return final_date;
        }

        public void setFinalDate(String finalDate) {
                this.final_date = final_date;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getToken() {
                return token;
        }

        public String getInitial_date() {
                return initial_date;
        }

        public String getFinal_date() {
                return final_date;
        }
}
