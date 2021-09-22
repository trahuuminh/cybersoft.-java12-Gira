package cybersoft.java12.gira.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.java12.gira.common.ResponseHandler;
import cybersoft.java12.gira.product.dto.CreateProductDto;
import cybersoft.java12.gira.product.dto.ProductDto;
import cybersoft.java12.gira.product.dto.UpdateProductDto;
import cybersoft.java12.gira.product.entity.Product;
import cybersoft.java12.gira.product.service.itf.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService pService) {
		productService=pService;
	}
	
	@GetMapping("/findall-product")
	public Object findAllProduct() {
		List<ProductDto>products=productService.findAllProductDto();
		
		return ResponseHandler.getResponse(products,HttpStatus.OK);
	}
	
	@PostMapping("/create-product")
	public Object createNewProduct(@Valid @RequestBody CreateProductDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors,HttpStatus.BAD_REQUEST);
		
		Product newProduct=productService.createProduct(dto);
		
		return ResponseHandler.getResponse(newProduct,HttpStatus.OK);
	}
	
	
	
	@PutMapping("/update-product")
	public Object updateProduct(@Valid @RequestBody UpdateProductDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors,HttpStatus.BAD_REQUEST);
		
		Product product=productService.updateProduct(dto);
		
		return ResponseHandler.getResponse(product, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{product-id}")
	public Object deleteProduct(@PathVariable("product-id") Long id) {
		productService.deleteProductById(id);
		
		return ResponseHandler.getResponse(HttpStatus.OK);
	}
}
