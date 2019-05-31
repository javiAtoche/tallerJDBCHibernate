/**
 * 
 */
package org.springframework.samples.petclinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.SpecialtyRepositoryJPA;
import org.springframework.samples.petclinic.repository.VetRepositoryJPA;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.stereotype.Service;

/**
 * @author Javi Atoche
 *
 */
@Service
public class PetServices {
	
	@Autowired
	VetRepositoryJPA vetRepoJPA;
	
	@Autowired
	SpecialtyRepositoryJPA spRepoJPA;
	
	
	public Vet createVet(String firstName,String lastName, int idSpecialty) {
		
		Vet v1 = new Vet();
		v1.setFirstName(firstName);
		v1.setLastName(lastName);
//		for(Specialty sp: especialidades) {
//			v1.addSpecialty(sp);
//		}
		/*
		 * Creo una especialidad a traves del idSpecialty que me pasan por parametro
		 */
		Specialty sp1 = spRepoJPA.findOne(idSpecialty);
		
		v1.addSpecialty(sp1);
		
		v1 = vetRepoJPA.save(v1);
				
		return v1;
	}
}
