package com.example.co2.Entite;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Userco2 user;
    @OneToMany(mappedBy = "activity")
    private List<Transport> transportList;
    @OneToMany(mappedBy = "activity")
    private List<Feed> feedList;
    @OneToMany(mappedBy = "activity")
    private List<Work> workList;
    @OneToMany(mappedBy = "activity")
    private List<Resources> resourcesList;



}
