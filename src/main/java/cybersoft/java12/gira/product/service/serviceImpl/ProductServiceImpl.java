package cybersoft.java12.gira.product.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.java12.gira.product.dto.CreateProductDto;
import cybersoft.java12.gira.product.dto.ProductDto;
import cybersoft.java12.gira.product.dto.UpdateProductDto;
import cybersoft.java12.gira.product.entity.Product;
import cybersoft.java12.gira.product.repository.ProductRepository;
import cybersoft.java12.gira.product.service.itf.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepo;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		productRepo=productRepository;
	}
	
	@Transactional
	@Override
	public Product createProduct(CreateProductDto dto) {
		Product product=new Product();
		
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		product.setDescription(dto.getDescription());
		product.setQuantity(dto.getQuantity());
		
		return productRepo.save(product); 
	}

	@Transactional
	@Override
	public List<ProductDto> findAllProductDto() {
		return productRepo.findAllProductDto();
	}
	


	@Override
	public Product updateProduct(UpdateProductDto dto) {
		Product product=productRepo.getById(dto.getId());
		
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		product.setQuantity(dto.getQuantity());
		product.setDescription(dto.getDescription());
		
		return productRepo.save(product);
	}

	@Override
	public void deleteProductById(Long id) {
		productRepo.deleteById(id);
	}
	
}
