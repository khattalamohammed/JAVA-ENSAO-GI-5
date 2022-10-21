package com.ensao.java.advanced.exercices.product;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stock extends TreeSet<Product> {
	private static final ProductComparator COMPARATOR = new ProductComparator();

	public Stock filter(Predicate<Product> predicate) {
		Stock stock = new Stock();
		Stock productsPredicated = (Stock) stock.stream().filter(predicate).collect(Collectors.toSet());
		return productsPredicated;
	}

	public void discount(Discount discount) {
		discount = (product, discountAmount) -> {
			if (discountAmount > 1 || discountAmount < 0)
				return product;
			product.setPrice(product.getPrice() - discountAmount);
			return product;
		};
	}

	public <R> Collection<R> map(Function<Product, R> mapper) {
		Stock products = new Stock();
		Collection<R> collection =  products.stream().map(mapper).collect(Collectors.toList());
		return collection;
	}

	public void print(ProductPrinter printer) {
		Stock products = new Stock();
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			printer.print(iterator.next());
		}
	}

	public Map<String, Stock> groupByCategory() {
		Set<String> categorySet = new HashSet<String>();
		Map<String, Stock> stockMap = new HashMap<String, Stock>();
		Stock products = new Stock();
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			String category = product.getCategory();
			if (!categorySet.contains(category)) {
				Stock mainStock = (Stock) products.stream().filter(p -> p.getCategory() == category).collect(Collectors.toSet());
				stockMap.put(category, mainStock);
				categorySet.add(category);
			}
		}
		return stockMap;
	}

	public Object findProduct(String name) {
		Stock products = new Stock();
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (name.equals(product.getName())) {
				return product;
			}
		}
		return null;
	}

	public Stock moreExpensiveThan(Product product) {
		Stock products = new Stock();
		Stock moreExpensiveProducts = (Stock) products.stream().filter(p -> p.getPrice() > product.getPrice()).collect(Collectors.toSet());
		return moreExpensiveProducts;
	}

	public Collection<Product> sorted() {
		return stream().sorted(COMPARATOR).collect(Collectors.toList());
	}
}
