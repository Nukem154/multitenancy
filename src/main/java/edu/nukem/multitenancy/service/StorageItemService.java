package edu.nukem.multitenancy.service;

import edu.nukem.multitenancy.entity.tenant.StorageItem;
import edu.nukem.multitenancy.repository.tenant.StorageItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StorageItemService {

    private final StorageItemRepo storageItemRepo;

    @Transactional
    public void addItem(final StorageItem item) {
        storageItemRepo.save(item);
    }
}
