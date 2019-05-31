/**
 * 
 */
package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.vet.Vet;



/**
 * @author Javi Atoche
 *
 */

public interface VetRepositoryJPA extends JpaRepository<Vet,Integer> {
	
	List<Vet> findByFirstnameAndLastname(String firstName, String lastName);
}
