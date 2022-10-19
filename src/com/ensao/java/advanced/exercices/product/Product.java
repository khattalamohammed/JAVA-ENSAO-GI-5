package com.ensao.java.advanced.exercices.product;

public class Product extends AbstractProduct {
	
	@Override
	public Product clone() throws CloneNotSupportedException {
		throw new ToBeCompletedException("Clone a product");
	}
	
	
}