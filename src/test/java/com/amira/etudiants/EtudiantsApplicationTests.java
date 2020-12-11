package com.amira.etudiants;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amira.etudiants.entities.Etudiant;
import com.amira.etudiants.repos.EtudiantRepository;

@SpringBootTest
class EtudiantsApplicationTests {

	 @Autowired 
	 private EtudiantRepository etudiantRepository; 
	 
	 @Test   
	 public void testCreateEtudiant() { 
		 Etudiant etud = new Etudiant("Amira","Habibi","09929364",new Date());  
	     etudiantRepository.save(etud);  
	     }  
	 @Test  public void testFindEtudiant() 
	 {
		 Etudiant e = etudiantRepository.findById(1L).get(); 
	     System.out.println(e);
	     }
	 @Test  
	 public void testUpdateEtudiant() 
	 {    Etudiant e = etudiantRepository.findById(1L).get(); 
	      e.setCinEtudiant("09588940");  
	      etudiantRepository.save(e);  
	      System.out.println(e);
	 }
	 
	 @Test 
	 public void testDeleteEtudiant() {
		 
		 etudiantRepository.deleteById(1L);
		 
	 }
	 
	 @Test 
	 public void testFindAllEtudiants()  
	 {  
		 List<Etudiant>  etuds = etudiantRepository.findAll();    
	 for (Etudiant e : etuds)
	 {     System.out.println(e);    }     
	 } 
	 
	 }

