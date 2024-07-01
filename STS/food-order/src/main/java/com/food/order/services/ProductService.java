package com.food.order.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.food.order.models.Area;
import com.food.order.models.Product;
import com.food.order.repo.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private UserService userService;
	
	public String uploadImage(String path, MultipartFile file) throws IOException {
		String name = "";
		if(path != null && file != null) {
			Random random = new Random();
			name = (random.nextInt(900)+100) + file.getOriginalFilename();
			String filePath = path + File.separator + name;
			File f = new File(path);
			if(!f.exists() ) {
				f.mkdir();
			}
			Files.copy(file.getInputStream(), Paths.get(filePath));
			return name;
		}
		return name;
	}
	
	public void addProduct(Product product) {
		repo.save(product);
	}
	
	public List<Product> getProducts(String email) {
		return repo.findByUser(userService.getUserByEmail(email).getId());
	}
	
	public Product getProduct(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Product with id `"+id+"` not found"));
	}

	public void updateProduct(Product product) {
		repo.save(product);
	}
	
	public void deleteProduct(Long id) {
		repo.deleteById(id);
	}
}
