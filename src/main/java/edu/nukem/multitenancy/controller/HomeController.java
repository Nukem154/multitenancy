package edu.nukem.multitenancy.controller;

import edu.nukem.multitenancy.entity.tenant.Storage;
import edu.nukem.multitenancy.entity.tenant.StorageItem;
import edu.nukem.multitenancy.repository.tenant.StorageItemRepo;
import edu.nukem.multitenancy.repository.tenant.StorageRepo;
import edu.nukem.multitenancy.service.StorageItemService;
import edu.nukem.multitenancy.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final TenantService tenantService;
    private final StorageItemService itemService;
    private final StorageRepo storageRepo;
    private final StorageItemRepo storageItemRepo;

    @GetMapping
    public String home() {
        return "Welcome HOME";
    }

    @PostMapping("/create")
    public void createTenant(@RequestBody String name) {
        tenantService.createTenant(name);
    }

    @PostMapping("/item")
    public void addItem(@RequestBody StorageItem item) {
        itemService.addItem(item);
    }

    @GetMapping("/item")
    public Storage getItem() {
        return storageRepo.findById(1L).get();
    }

    @GetMapping("/item2")
    public List<StorageItem> getItem2() {
        return storageItemRepo.findAllByStorageId(1L);
    }
}
