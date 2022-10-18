package com.ensao.java.advanced.exercices.product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
	public final boolean byPrice;
	
	public ProductComparator() {
		this.byPrice = false;
	}
	
	public ProductComparator(boolean byPrice) {
		this.byPrice = byPrice;
	}
	
	@Override
	public int compare(Product productA, Product productB) {
		throw new ToBeCompletedException("if 'byPrice' is false compare products using their names," +
				" use the price otherwise");
	}
}
