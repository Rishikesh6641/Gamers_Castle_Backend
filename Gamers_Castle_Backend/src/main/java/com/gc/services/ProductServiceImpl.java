package com.gc.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.dto.ApiResponse;
import com.gc.dto.ProductDto;
import com.gc.entity.Product;
import com.gc.respository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ApiResponse addProduct(ProductDto dto) {
		
		Product product=mapper.map(dto,Product.class);
		productRepository.save(product);
		return new ApiResponse("Added Product successfully "+product.getId());
	}

	@Override
	public ApiResponse deleteProduct(Long id) {
		
		if(productRepository.existsById(id))
		{
			
		}
		productRepository.delete(null);
		return null;
	}
	 
}
