package com.tricol.suppliers.repository;

import com.tricol.suppliers.domain.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    List<Fournisseur> findBySocieteContainingIgnoreCaseOrderBySocieteAsc(String societe);
    List<Fournisseur> findByEmail(String domain);
    boolean existsByIce(String ice);
}


