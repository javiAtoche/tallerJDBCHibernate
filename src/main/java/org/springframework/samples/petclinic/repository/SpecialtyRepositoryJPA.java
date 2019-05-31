/**
 * 
 */
package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.vet.Specialty;

/**
 * @author Javi Atoche
 *
 */
public interface SpecialtyRepositoryJPA extends JpaRepository<Specialty, Integer> {

}
