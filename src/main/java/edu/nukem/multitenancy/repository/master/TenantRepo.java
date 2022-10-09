package edu.nukem.multitenancy.repository.master;

import edu.nukem.multitenancy.entity.master.Tenant;
import org.springframework.data.repository.CrudRepository;

public interface TenantRepo extends CrudRepository<Tenant, Long> {
}
