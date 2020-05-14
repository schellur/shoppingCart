/**
 * 
 */
package com.mindtree.shoppingCart.cart.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.shoppingCart.user.entity.User;
import com.mindtree.shoppingCart.product.entity.Product;

/**
 * @author M1053969
 * Cart entity class
 */
@Entity
@Table(name = "CART")
public class Cart implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;

	@Column(name="CARD_ID", unique = true, nullable = false)
	private Long cartId;

	@Column(name = "QUANTITY", nullable = false, length = 100)
	private int quantity;

	@OneToOne
	@JoinColumn(name = "USER_ID_FK", referencedColumnName = "ID", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "PRODUCT_ID"), name = "PRODUCT_ID_FK")
	private Product product;

	/**
	 * @return the cartId
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the cartId
	 */
	public Long getCartId() {
		return cartId;
	}

	/**
	 * set the cart id
	 * @param cartId
	 */
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Cart cart = (Cart) o;

		if (id != cart.id) return false;
		if (quantity != cart.quantity) return false;
		if (cartId != null ? !cartId.equals(cart.cartId) : cart.cartId != null) return false;
		if (user != null ? !user.equals(cart.user) : cart.user != null) return false;
		return product != null ? product.equals(cart.product) : cart.product == null;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = id;
		result = prime * result + (cartId != null ? cartId.hashCode() : 0);
		result = prime * result + quantity;
		result = prime * result + (user != null ? user.hashCode() : 0);
		result = prime * result + (product != null ? product.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"id=" + id +
				", cartId=" + cartId +
				", quantity=" + quantity +
				", user=" + user +
				", product=" + product +
				'}';
	}
}
