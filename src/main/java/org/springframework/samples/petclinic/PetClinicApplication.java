/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.samples.petclinic.repository.SpecialtyRepositoryJPA;
import org.springframework.samples.petclinic.repository.VetRepositoryJPA;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;

/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class PetClinicApplication implements CommandLineRunner{

	@Autowired
    VetRepositoryJPA vetRepoJPA;
	
	@Autowired
	SpecialtyRepositoryJPA SpecRepoJPA;
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(PetClinicApplication.class, args);
        
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Vet v1;
		List<Vet> lV1 = vetRepoJPA.findByFirstnameAndLastname("Javi", "Atoche");
		if(lV1.isEmpty()) {
			// genero un nuevo Vet
			v1 = new Vet();
			/* relleno los datos del Vet menos el Id que será autogenerado,
			 * y se le dara al objeto cuando se utilice el método "save()"
			 * para guardar o modificar los datos en la base de datos
			 */
			v1.setFirstName("Javi");
			v1.setLastName("Atoche");
			/* cuando use el método "save()", si no hay problemas, se 
			 * guardará el objeto v1 en la bbdd y me devolverá el objeto
			 * con el id ya generado
			 */
			v1 = vetRepoJPA.save(lV1);
		}
		
		//Ver por pantalla los datos
		for() {
			
		}
		System.out.println(" Id: "+lV1.getId()+", Nombre: "+lV1.getFirstName()+", Apellido: "+lV1.getLastName());
		
		// Me traigo una de las especialidades que existen en la tabla Specialty
		Specialty sp1 = SpecRepoJPA.findOne(1);
		System.out.println("Id: "+sp1.getId()+", Nombre: "+sp1.getName());
		if(sp1 != null) {
			lV1.addSpecialty(sp1);
		}else {
			System.out.println("Error al traer un Specialty");
		}
		System.out.println(" Id: "+lV1.getId()+", Nombre: "+lV1.getFirstName()+", Apellido: "+lV1.getLastName()+", Lista Especialidades: "+lV1.getSpecialties());
		
		
		/*
		 * Creo una lista y recupero todos los vet 
		 * */
		List<Vet> listVet1 = vetRepoJPA.findAll();
		System.out.println("Lista de Veterinarios: "+listVet1.toString());
		
	}
    
    

}
