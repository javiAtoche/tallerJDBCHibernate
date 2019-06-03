/**
 * 
 */
package org.springframework.samples.petclinic.bill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Javi Atoche
 *
 */
@Controller
@RequestMapping(value = "/bills")
public class BillController {

	@Autowired
	private BillService bService;
	
	@RequestMapping(value="/bills", method = RequestMethod.GET, produces="application/json")
    public List<Bill> findAll() {
		return this.bService.findAll();
	}
    
	@RequestMapping(value="/bills/{idBill}", method=RequestMethod.POST)
	public Bill findById(@PathVariable("idBill") Integer id) {
		Bill b = this.bService.findById(id);
		return b;
	}
	
//	@RequestMapping(value="/bills", method=RequestMethod.POST)
//	public Bill findById(@RequestBody Bill bill) {
//		Bill b = this.bService.findById(Bill.getIdNumber()));
//		return b;
//	}
}
