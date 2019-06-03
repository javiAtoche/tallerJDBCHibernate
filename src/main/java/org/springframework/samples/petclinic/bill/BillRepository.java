/**
 * 
 */
package org.springframework.samples.petclinic.bill;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Javi Atoche
 *
 */
public interface BillRepository extends JpaRepository<Bill, Integer> {

}
