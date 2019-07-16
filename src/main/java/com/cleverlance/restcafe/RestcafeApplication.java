package com.cleverlance.restcafe;

import com.cleverlance.restcafe.entities.Product;
import com.cleverlance.restcafe.entities.ProductCategoryEnum;
import com.cleverlance.restcafe.repositories.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestcafeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RestcafeApplication.class, args);

		ProductRepository repo = ctx.getBean(ProductRepository.class);
		repo.addProduct(new Product("Espresso", 55, ProductCategoryEnum.Coffee));
		repo.addProduct(new Product("Latte", 65, ProductCategoryEnum.Coffee));
		repo.addProduct(new Product("Batch Brew", 50, ProductCategoryEnum.Coffee));
		repo.addProduct(new Product("English breakfast", 45, ProductCategoryEnum.Tea));
		repo.addProduct(new Product("Babiččina zahrádka", 30, ProductCategoryEnum.Tea));
		repo.addProduct(new Product("Veltlínské zelené", 70, ProductCategoryEnum.Alcohol));
		repo.addProduct(new Product("Absinth", 95, ProductCategoryEnum.Alcohol));
		repo.addProduct(new Product("Matuška 12", 45, ProductCategoryEnum.Alcohol));
	}

}
