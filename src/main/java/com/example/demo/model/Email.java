package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMAIL")
public class Email {
    @Id
    @GeneratedValue
    Long id;
    @Column
    private String fromm;
    @Column
    private String too;
    @Column
    private String subject;
    @Column
    private String body;
}
