package com.unchk.unchk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unchk.unchk.models.Effectuer;
import com.unchk.unchk.models.Groupe;

public interface EffectuerRepository extends JpaRepository<Effectuer, String> {

    List<Effectuer> findByGroupe(Groupe groupe);
//            
}
