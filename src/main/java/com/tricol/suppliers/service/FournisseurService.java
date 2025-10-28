package com.tricol.suppliers.service;

import com.tricol.suppliers.domain.Fournisseur;
import com.tricol.suppliers.repository.FournisseurRepository;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Service implementation for managing suppliers (fournisseurs).
 * Handles business logic for supplier operations.
 */
public class FournisseurService implements FournisseurServiceInterface {

    private final FournisseurRepository fournisseurRepository;

    public FournisseurService(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    public List<Fournisseur> listAll(String sortBy) {
        if (sortBy == null || sortBy.isBlank()) {
            sortBy = "societe";
        }
        return fournisseurRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));
    }

    public Optional<Fournisseur> findById(Long id) {
        return fournisseurRepository.findById(id);
    }

    public Fournisseur create(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    public Optional<Fournisseur> update(Long id, Fournisseur changes) {
        return fournisseurRepository.findById(id).map(existing -> {
            existing.setSociete(changes.getSociete());
            existing.setAdresse(changes.getAdresse());
            existing.setContact(changes.getContact());
            existing.setEmail(changes.getEmail());
            existing.setTelephone(changes.getTelephone());
            existing.setVille(changes.getVille());
            existing.setIce(changes.getIce());
            return fournisseurRepository.save(existing);
        });
    }

    public void delete(Long id) {
        fournisseurRepository.deleteById(id);
    }

    public List<Fournisseur> searchBySociete(String q) {
        return fournisseurRepository.findBySocieteContainingIgnoreCaseOrderBySocieteAsc(q);
    }

    public List<Fournisseur> findByEmailDomain(String domain) {
        return fournisseurRepository.findByEmail(domain);
    }


}


