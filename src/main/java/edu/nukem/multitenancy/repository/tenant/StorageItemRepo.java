package edu.nukem.multitenancy.repository.tenant;

import edu.nukem.multitenancy.entity.tenant.StorageItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StorageItemRepo extends JpaRepository<StorageItem, Long> {

    List<StorageItem> findAllByStorageId(Long id);
}
