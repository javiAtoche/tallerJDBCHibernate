/**
 * 
 */
package org.springframework.samples.petclinic.bill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;

/**
 * @author Javi Atoche
 *
 */
public class BillService {
	
	@Autowired
	private BillRepository bRepo;
	

	public Bill findById(Integer id) {
		return this.bRepo.findOne(id);
	}
	
	public List<Bill> findAll(){
		return this.bRepo.findAll();
	}
	
}
