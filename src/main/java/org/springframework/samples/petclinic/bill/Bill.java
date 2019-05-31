package org.springframework.samples.petclinic.bill;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.visit.Visit;

/*
 * 1. Crear una nueva entidad Bill que se mapeará a la tabla facturas. 
 * Cada owner puede tener 0..N facturas, cada visita estará relacionada con 0..1 factura.
 * Los campos de factura serán un número de identificación (representado como un long de 10 dígitos),
 * una fecha de pago y una cuantía
 * */
/*
@Entity
@Table(name="facturas")
public class Bill extends BaseEntity{
	
	@Column(name="id_number")
	@Digits(fraction = 0, integer = 10)
	private long idNumber;
	
	@Column(name="payment_day")
	@Temporal(TemporalType.Type)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date fechaPago;
	
	@Column(name="money")
	@NotEmpty
	private double cuantia;
	
	// 1 Factura tiene 0..1 Visita
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "bill")
    private Visit visita;
	
	// 1..N Factura es de 1 Owner
	@ManyToOne(cascade = CascadeType.ALL, mappedBy = "bill")
	private Owner cliente;
		
}
*/

/*
 * 1. Crear una nueva entidad Bill que se mapeará a la tabla facturas. 
 * Cada owner puede tener 0..N facturas, cada visita estará relacionada con 0..1 factura.
 * Los campos de factura serán un número de identificación (representado como un long de 10 dígitos),
 * una fecha de pago y una cuantía
 * */
//.pptx
@Entity
@Table(name="facturas")
public class Bill extends BaseEntity {
	// .pptx
	@Digits(integer=10, fraction=0)
	private long idNumber;
	// .pptx
	@Temporal(TemporalType.DATE)
    	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date paymentDate;
	// .pptx
	@Digits(integer=5, fraction=2)
	@DecimalMin("0.0")
	private double money;
	// .pptx
	@ManyToOne
    	@JoinColumn(name = "owner")
	private Owner owner;
	// .pptx
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bill", cascade = CascadeType.ALL)
	private Visit visit;
	// .pptx
	public Bill () { }
}

