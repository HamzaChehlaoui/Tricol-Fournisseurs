package com.tricol.suppliers.web;

import com.tricol.suppliers.domain.Fournisseur;
import com.tricol.suppliers.service.FournisseurServiceInterface;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fournisseurs")
public class FournisseurController {

    private final FournisseurServiceInterface fournisseurService;

    public FournisseurController(FournisseurServiceInterface fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping
    public List<Fournisseur> getAll(@RequestParam(value = "sort", required = false) String sortBy,
                                    @RequestParam(value = "q", required = false) String query) {
        if (query != null && !query.isBlank()) {
            return fournisseurService.searchBySociete(query);
        }
        return fournisseurService.listAll(sortBy);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getOne(@PathVariable("id") Long id) {
        return fournisseurService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Fournisseur> create(@Valid @RequestBody Fournisseur fournisseur) {
        Fournisseur created = fournisseurService.create(fournisseur);
        return ResponseEntity.created(URI.create("/api/v1/fournisseurs/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> update(@PathVariable Long id, @Valid @RequestBody Fournisseur fournisseur) {
        return fournisseurService.update(id, fournisseur)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fournisseurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


