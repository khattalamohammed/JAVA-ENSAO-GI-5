package com.ensao.java.advanced.exercices.product;

public class Product extends AbstractProduct {

	@Override
	public Product clone() throws CloneNotSupportedException {
		Object object = super.clone();
		Product product = (Product) object;
		return product;
	}

}