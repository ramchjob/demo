package org.ram.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "status")
public class Status {
    
    @Id
    private Integer id;
    
    @Column(name = "status_name")
    private String statusName;

}
