package com.ensao.java.advanced.exercices.product;

import java.util.Collection;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;

public class Stock extends TreeSet<Product> {
	
	public Stock filter(Predicate<Product> predicate) {
		throw new ToBeCompletedException("Return a Stock instance containing products " +
				"to which is applied the predicate");
	}
	
	public void discount(Discount discount) {
		
		throw new ToBeCompletedException("apply a discount function " +
				" do not apply discount if discount amount is > 1 or < 0");
	}
	
	public <R> Collection<R> map(Function<Product, R> mapper) {
		throw new ToBeCompletedException("Retrun a collection of mapped property " +
				"of type 'R' of a product");
	}
	
	public void print(ProductPrinter printer) {
		throw new ToBeCompletedException("using the 'printer', print the products in this stock");
	}
	
	public Map<String, Product> groupByCategory() {
		throw new ToBeCompletedException("Retrun a map of a stock of products grouped by the category");
		
	}
	
	public Object findProduct(String name) {
		throw new ToBeCompletedException("Look for a product having the name 'name' if found");
	}
	
	public Stock moreExpensiveThan(Product product) {
		throw new ToBeCompletedException("return a new Stock of products" +
				" that are more expensive that a given product");
	}
	
}
