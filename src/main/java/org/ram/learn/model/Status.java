package org.ram.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "status")
public class Status {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "status_name")
    private String statusName;

}
