package com.amira.etudiants.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amira.etudiants.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
