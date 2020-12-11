package com.amira.etudiants.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amira.etudiants.entities.Etudiant;
import com.amira.etudiants.service.EtudiantService;



@Controller
public class EtudiantController {
	@Autowired
	EtudiantService etudiantService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "createEtudiant";
	}
	
	@RequestMapping("/saveEtudiant")
	public String saveEtudiant(@ModelAttribute("etudiant") Etudiant etudiant, 
							  @RequestParam("date") String date,
							  ModelMap modelMap) throws ParseException 
	{
		
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateInscrit = dateformat.parse(String.valueOf(date));
        etudiant.setDateInscrit(dateInscrit);
      
		 Etudiant saveEtudiant = etudiantService.saveEtudiant(etudiant);
		 String msg ="etudiant enregistré avec Id "+saveEtudiant.getIdEtudiant();
		 modelMap.addAttribute("msg", msg);
		return "createEtudiant";
	}

	@RequestMapping("/listeEtudiant")
	public String listeEtudiant(ModelMap modelMap)
	{
		List<Etudiant> etuds = etudiantService.getAllEtudiants();
		modelMap.addAttribute("etudiants", etuds);		
		return "listeEtudiant";	
	}
	
	@RequestMapping("/supprimerEtudiant")
	public String supprimerEtudiant(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Etudiant e= new Etudiant();
		e.setIdEtudiant(id);
		etudiantService.deleteEtudiant(e);
		List<Etudiant> etuds = etudiantService.getAllEtudiants();
		modelMap.addAttribute("etudiants", etuds);	
		return "listeEtudiant";	
	}
	
	@RequestMapping("/modifierEtudiant")
	public String editerEtudiant(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Etudiant e= 	etudiantService.getEtudiant(id);
		modelMap.addAttribute("etudiant", e);	
		return "editerEtudiant";	
	}

	@RequestMapping("/updateEtudiant")
	public String updateEtudiant(@ModelAttribute("etudiant") Etudiant etudiant,
								@RequestParam("date") String date,
			                    ModelMap modelMap) throws ParseException 
	{
		
		 
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateInscrit = dateformat.parse(String.valueOf(date));
        etudiant.setDateInscrit(dateInscrit);
        
		  etudiantService.updateEtudiant(etudiant);
		  List<Etudiant> etuds = etudiantService.getAllEtudiants();
		  modelMap.addAttribute("etudiant", etuds);	
		
		return "listeEtudiant";
	}



}

