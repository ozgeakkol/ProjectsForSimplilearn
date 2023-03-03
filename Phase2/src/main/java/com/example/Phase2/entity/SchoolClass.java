package com.example.Phase2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "school_class")
public class SchoolClass implements Serializable {

    @Id
    @Column(name = "class_id")
    private int classId;

    @Column(name = "class_name")
    private String className;

}
