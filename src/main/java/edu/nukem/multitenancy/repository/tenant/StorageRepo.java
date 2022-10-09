package edu.nukem.multitenancy.repository.tenant;

import edu.nukem.multitenancy.entity.tenant.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepo extends JpaRepository<Storage, Long> {
}
