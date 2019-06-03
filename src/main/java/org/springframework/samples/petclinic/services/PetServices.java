/**
 * 
 */
package org.springframework.samples.petclinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.owner.PetType;
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
	private PetRepository petRepository;
	
	// metodo que almacena el 'pet' en la base de datos
	public void save(Pet pet) {
		this.petRepository.save(pet);
	}
	
	// metodo que te devuelve un 'pet' de la base de datos, dado un 'id'
	public Pet findById(Integer id) {
		return this.petRepository.findById(id);
		
	}
	
	public List<PetType> findPetTypes(){
		return this.findPetTypes();
	}
	
	
	

	
	
//	
//	@Autowired
//	VetRepositoryJPA vetRepoJPA;
//	
//	@Autowired
//	SpecialtyRepositoryJPA spRepoJPA;
//	
//	
//	public Vet createVet(String firstName,String lastName, int idSpecialty) {
//		
//		Vet v1 = new Vet();
//		v1.setFirstName(firstName);
//		v1.setLastName(lastName);
//		for(Specialty sp: especialidades) {
//			v1.addSpecialty(sp);
//		}
//		/*
//		 * Creo una especialidad a traves del idSpecialty que me pasan por parametro
//		 */
//		Specialty sp1 = spRepoJPA.findOne(idSpecialty);
//		
//		v1.addSpecialty(sp1);
//		
//		v1 = vetRepoJPA.save(v1);
//				
//		return v1;
//	}

}
