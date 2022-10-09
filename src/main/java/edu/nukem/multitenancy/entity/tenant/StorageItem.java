package edu.nukem.multitenancy.entity.tenant;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Table(name = "storage_item")
@Entity
@Getter
@Setter
@ToString
public class StorageItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    private Long quantity;
}
