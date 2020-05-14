package com.mindtree.shoppingCart.apparel.entity;
import com.mindtree.shoppingCart.product.entity.Product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author M1053969
 * Apparel entity class
 */
@Entity
@Table(name="Apparel")
@DiscriminatorValue(value = "Apparel")
public class Apparel extends Product implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private String brand;
	
	@Column(nullable = false)
	private String design;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the design
	 */
	public String getDesign() {
		return design;
	}

	/**
	 * @param design the design to set
	 */
	public void setDesign(String design) {
		this.design = design;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((design == null) ? 0 : design.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Apparel apparel = (Apparel) o;

		if (type != null ? !type.equals(apparel.type) : apparel.type != null) return false;
		if (brand != null ? !brand.equals(apparel.brand) : apparel.brand != null) return false;
		return design != null ? design.equals(apparel.design) : apparel.design == null;
	}
}
