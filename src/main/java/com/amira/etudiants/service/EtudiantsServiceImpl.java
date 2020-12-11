package com.amira.etudiants.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amira.etudiants.entities.Etudiant;
import com.amira.etudiants.repos.EtudiantRepository;


@Service
public class EtudiantsServiceImpl implements EtudiantService{
	@Autowired 
	EtudiantRepository etudiantRepository;
	@Override
	public Etudiant saveEtudiant(Etudiant e) {

		return etudiantRepository.save(e);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
	}

	@Override
	public void deleteEtudiant(Etudiant e) {
		 etudiantRepository.delete(e);
		
	}

	@Override
	public void deleteEtudiantById(Long id) {
		etudiantRepository.deleteById(id);
		
	}

	@Override
	public Etudiant getEtudiant(Long id) {
		return etudiantRepository.findById(id).get();
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}


	

}
