package com.packt.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {

	private static final long serialVersionUID = -6522002126143720342L;
	private String cartId;
	private Map<String, CartItem> cartItems;
	private BigDecimal grandTotal;

	public Cart() {
		cartItems = new HashMap<String, CartItem>();
		grandTotal = new BigDecimal(0);
	}

	public Cart(String cartId) {
		this();
		this.cartId = cartId;
	}

	public void addCartItem(CartItem item) {
		String productId = item.getProduct().getProductId();

		if (cartItems.containsKey(productId)) {
			CartItem existingCartItem = cartItems.get(productId);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			cartItems.put(productId, existingCartItem);
		} else {
			cartItems.put(productId, item);
		}
		updateGrandTotal();
	}

	private void updateGrandTotal() {
		grandTotal = new BigDecimal(0);
		for (CartItem item : cartItems.values()) {
			grandTotal = grandTotal.add(item.getTotalPrice());
		}

	}

	public void removeCartItem(CartItem item) {
		String productId = item.getProduct().getProductId();
		cartItems.remove(productId);
		updateGrandTotal();
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((cartItems == null) ? 0 : cartItems.hashCode());
		result = prime * result + ((grandTotal == null) ? 0 : grandTotal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Cart)) {
			return false;
		}
		Cart other = (Cart) obj;
		if (cartId == null) {
			if (other.cartId != null) {
				return false;
			}
		} else if (!cartId.equals(other.cartId)) {
			return false;
		}
		if (cartItems == null) {
			if (other.cartItems != null) {
				return false;
			}
		} else if (!cartItems.equals(other.cartItems)) {
			return false;
		}
		if (grandTotal == null) {
			if (other.grandTotal != null) {
				return false;
			}
		} else if (!grandTotal.equals(other.grandTotal)) {
			return false;
		}
		return true;
	}

}
