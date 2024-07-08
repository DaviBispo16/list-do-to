package com.exemplo.list_do_to.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;

public class TaskDTO {

        private Long id;
        @NotBlank
        private String name;

        private String initialDate;

        private String finalDate;

        private String description;

        private String status;

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
                return initialDate;
        }

        public void setInitialDate(String initialDate) {
                this.initialDate = initialDate;
        }

        public String getFinalDate() {
                return finalDate;
        }

        public void setFinalDate(String finalDate) {
                this.finalDate = finalDate;
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
}
