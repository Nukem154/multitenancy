package edu.nukem.multitenancy.entity.tenant;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "item")
    private List<StorageItem> storageItems;
}
