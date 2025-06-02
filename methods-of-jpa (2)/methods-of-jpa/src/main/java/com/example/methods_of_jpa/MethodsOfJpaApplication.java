package com.example.methods_of_jpa;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class MethodsOfJpaApplication implements CommandLineRunner {

    private final ProductRepository productRepository;

    MethodsOfJpaApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(MethodsOfJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = Product.builder()
				.productId("101")
				.productName("I Phone 16 Pro Max")
				.productBrand("Apple")
				.productPrice(150000.99)
				.build();
		//SAVE
		productRepository.save(product);
		//SAVEAL
		List<Product>products = getProducts();
		productRepository.saveAll(getProducts());
		//COUNT
		System.out.println("Table Product avalable inthe table" + productRepository.count());
		//Exists
		System.out.println("Is apple product"  + productRepository.existsById("62495640-b85b-4919-84fe-c73c164842a3"));
		//delet
		productRepository.deleteById("62495640-b85b-4919-84fe-c73c164842a3");
		//find all
		List<Product> products2 = productRepository.findAll();


		final List<Product> products3 = productRepository.findAll(Sort.by(Direction.ASC,"productPrice"));
		// products3.forEach(System.out::println(null));

		//pagination

		// Page<Product> products4 = productRepository.findAll(PageRequest.of(0, 3, Sort.by(Direction.DESC,"productPrice")));
		// products4.forEach(System.out::println);

		//Find By id
		// Optional<Product> optProduct = productRepository.findById("19cb7c42-42a2-453c-9347-de0ea5b7a4a2");
		// Product existingProduct = optProduct.orElseThrow(() -> new NoSuchElementException("Product Not Found"));
		// System.out.println("Find By id " + existingProduct);

		//Save or Update -> if the id is already exist in the table then update the obj
		//otherwise insert the obj
		// Optional<Product> optProduct = productRepository.findById("f0c11354-5c26-404d-96cf-769b89571355");
		// Product existingProduct = optProduct.orElseThrow(() -> new NoSuchElementException("Product not found"));

		// System.out.println("before update " + existingProduct);

		// existingProduct.setProductName("Iphone 17 pro max");
		// existingProduct.setProductPrice(149000.99);

		// Product savedProduct = productRepository.save(existingProduct);
		// System.out.println("after update " + savedProduct);


		// finy by Product name
		// Optional<Product> optProductByName = productRepository.findByProductName("Iphone 18");
		// Product productByName = optProductByName.orElseThrow();
		// System.out.println(""+ productByName);

		// FIND ALL BY PRODUCT PRICE BETWEEN
		// List<Product> listProductByPriceBetween = productRepository.findAllByProductPriceBetween(6000.00, 9000.00);
		// listProductByPriceBetween.forEach(System.out::println);

		// List<Product> productGreaterThanPrice = productRepository.findAllByProductPriceGreaterThan(10000.00, Sort.by(Direction.ASC, "productPrice"));
		// productGreaterThanPrice.forEach(System.out::println);

		// System.out.println("				");
		// System.out.println("				");

		// Optional<Product> productByPriceAndBrand = productRepository.findByProductPriceAndProductBrand(149000.99, "Apple");
		// System.out.println("product by price and brand " + productByPriceAndBrand.orElseThrow());


		// Optional<Product> productByPriceAndBrand = productRepository.getProduct(150000.99, "Apple");
		// System.out.println("product by brand and name " + productByPriceAndBrand );

		Optional<Product> productByPriceAndBrand = productRepository.getProduct1("Apple", 150000.99);
		System.out.println("product by brand and name " + productByPriceAndBrand );

		Optional<Product> productByPriceAndBrand1 = productRepository.getProduct2( 150000.99,"Apple");
		System.out.println("product by brand and name " + productByPriceAndBrand1 );

		
	}
	@Transactional
	public void transactionConcept(){
		int affectedRow = productRepository.updatePrice(170000, "Brand - 9");
		System.out.println("No. of rows affected " + affectedRow);
	}

	private List<Product> getProducts() {
		List<Integer> numbers = List.of(1, 2, 3,4,5,6,7,8,9,10);
		return numbers.stream()
				.map(number -> Product.builder()
						.productName("product " + number)
						.productBrand("brand " + number)
						.productPrice(number * 1000.50)
						.build())
				.toList();
	}		

}
