package edu.nukem.multitenancy.entity.master;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<User> users;
}
