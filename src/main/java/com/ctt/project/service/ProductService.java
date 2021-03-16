package com.ctt.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ctt.project.dto.request.ProductRequest;
import com.ctt.project.dto.response.ProductResponse;
import com.ctt.project.entity.Category;
import com.ctt.project.entity.Product;
import com.ctt.project.repository.CategoryRepository;
import com.ctt.project.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public ProductResponse create(ProductRequest productRequest) {
		Category category = this.categoryRepository.findById(productRequest.getIdCategory()).orElseThrow(RuntimeException::new);
		Product product = new Product(productRequest, category);
		Product productCreated = this.productRepository.save(product);
		return new ProductResponse(productCreated);
	}
	public List<Product> getAll(){
		return this.productRepository.findAll(Sort.by("name"));
	}
	
	public Product getById(Long id){
		 return this.productRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	public List<Product> getByCategory(Long id){
		Category category = this.categoryRepository.findById(id).orElseThrow(RuntimeException::new);
		return this.productRepository.findByCategory(category);
	}
	
	public List<Product> getAllByLowerPrice(){
		return this.productRepository.findAll(Sort.by(Sort.Direction.ASC,"price"));
		
	}
	
	public List<Product> getAllByHigherPrice(){
		return this.productRepository.findAll(Sort.by(Sort.Direction.DESC,"price"));
		
	}


	
	public ProductResponse edit(Long id, ProductRequest productRequest) {
		Product product = this.productRepository.findById(id).orElseThrow(RuntimeException::new);
		product.fillFromDto(productRequest);
		Product productCreated = this.productRepository.save(product);
		return new ProductResponse(productCreated);
	}
    public void delete(Long id) {
    	this.productRepository.deleteById(id);
    }
}
