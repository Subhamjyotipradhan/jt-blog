package com.example.methods_of_jpa;

import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByProductId(String productId);

    List<Product> findAllByProductPriceBetween(double price1, double price2);

    List<Product> findAllByProductPriceGreaterThan(double price, Sort sort);

    Optional<Product> findAllByProductPriceAndProductBrand(double price, String brandName);

    //JPQL -> Positional parameters, named parameters
    @Query("SELECT p FROM Product p WHERE  p.productPrice=? AND p.productBrand=?1")
    Optional<Product> getProduct(double price, String brandName);

    @Query("SELECT p FROM Product p WHERE  p.productPrice=:price AND p.productBrand=:brandName")
    Optional<Product> getProduct1(@Param("brandName")String brandName1, @Param("price") double price1);

    //
    @Query(nativeQuery = true, value = "SELECT * FROM product Where product_price=? AND product_brand=?")
    Optional<Product> getProduct2(double price , String name); 
    
    // @Modifying
    // @Transactional
    // @Query(nativeQuery = true, value = "UPDATE Product SET product_price=? WHERE product_brand=?")
    // int updatePrice(double price, String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Product p SET p.productPrice=:price WHERE productBrand=:brand")
    int updatePrice(double price, String name);
}