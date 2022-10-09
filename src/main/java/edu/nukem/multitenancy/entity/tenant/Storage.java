package edu.nukem.multitenancy.entity.tenant;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @JsonManagedReference
    @OneToMany(mappedBy = "storage")
    private List<StorageItem> storageItems;
}
