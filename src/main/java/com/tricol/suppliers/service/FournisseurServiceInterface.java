package com.tricol.suppliers.service;

import com.tricol.suppliers.domain.Fournisseur;

import java.util.List;
import java.util.Optional;


public interface FournisseurServiceInterface {
    List<Fournisseur> listAll(String sortBy);
    Optional<Fournisseur> findById(Long id);
    Fournisseur create(Fournisseur fournisseur);
    Optional<Fournisseur> update(Long id, Fournisseur changes);
    void delete(Long id);
    List<Fournisseur> searchBySociete(String q);
    List<Fournisseur> findByEmailDomain(String domain);
}
