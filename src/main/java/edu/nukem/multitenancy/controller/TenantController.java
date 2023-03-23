package edu.nukem.multitenancy.controller;

import edu.nukem.multitenancy.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @PostMapping("/tenant")
    public ResponseEntity<HttpStatus> createTenant(@RequestBody String name) {
        tenantService.createTenant(name);
        return ResponseEntity.ok().build();
    }
}
