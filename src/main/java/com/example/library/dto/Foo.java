package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
    public class Foo implements Serializable {
        private long id;

        private String name;
        // standard getters and setters
    }
