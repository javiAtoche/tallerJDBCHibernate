/**
 * 
 */
package org.springframework.samples.petclinic.services;

import java.util.List;

import org.springframework.samples.petclinic.repository.VetRepositoryJPA;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;

/**
 * @author Javi Atoche
 *
 */
public class PetServices {
	
	@Autowired
	VetRepositoryJPA vetRepoJPA;
	
	@Autowired
	
	
	public Vet createVet(String firstName,String lastName, int idSpecialty) {
		
		Vet v1 = new Vet();
		v1.setFirstName(firstName);
		v1.setLastName(lastName);
//		for(Specialty sp: especialidades) {
//			v1.addSpecialty(sp);
//		}
		
		
		
		
		
		
		return v1;
	}
}
