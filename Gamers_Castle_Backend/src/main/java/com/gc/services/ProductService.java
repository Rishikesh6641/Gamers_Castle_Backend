package com.gc.services;

import com.gc.dto.ApiResponse;
import com.gc.dto.ProductDto;

public interface ProductService {
	
	ApiResponse addProduct(ProductDto dto);
	ApiResponse deleteProduct(Long id);
}
