package com.ryryanb.shopupspot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ryryanb.shopupspot.model.Product;
import com.ryryanb.shopupspot.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;



@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}



	// Request Mapping

	// which displays the list of products to the productList page

	/* Product List using Angular
	* @RequestMapping("/getAllProducts")
	* public ModelAndView getAllProducts() {
	*	List<Product> products = productService.getAllProducts();
	*	return new ModelAndView("productListAngular", "products", products);
	*}
	*/
	//		Normal ProductList view 
	  @RequestMapping("/getAllProducts") public ModelAndView getAllProducts() {
	  List<Product> products = productService.getAllProducts(); return new
	  ModelAndView("productList", "products", products); }
	 
	
	// this is used for getting the product by productId

	@RequestMapping("getProductById/{productId}")
	public ModelAndView getProductById(@PathVariable(value = "productId") Long productId) {
		Product product = productService.getProductById(productId);
		return new ModelAndView("productPage", "productObj", product);
	}

	@RequestMapping("/admin/delete/{productId}")
	public String deleteProduct(@PathVariable(value = "productId") Long productId, HttpServletRequest request) {

	    // Get the application's context path
	    String contextPath = request.getServletContext().getRealPath("/");

	    // Define a relative path to the product images directory
	    String relativePath = "static/resource/images/" + productId + ".jpg";

	    // Create a Path object using the relative path and context path
	    Path path = Paths.get(contextPath, relativePath);

	    if (Files.exists(path)) {
	        try {
	            Files.delete(path);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    productService.deleteProduct(productId);

	    // Redirect to the appropriate URL
	    return "redirect:/getAllProducts";
	}


	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.GET)
	public String getProductForm(Model model) {
		Product product = new Product();

		model.addAttribute("productFormObj", product);
		return "addProduct";

	}
	
	

	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.POST)
	public String addProduct(
	    @Valid @ModelAttribute("productFormObj") Product product,
	    BindingResult result
	) {
	    // Check for form validation errors
	    if (result.hasErrors()) {
	        return "addProduct";
	    }

	    // Add the product to the database
	    productService.addProduct(product);

	    // Handle product image upload
	    handleProductImageUpload(product);

	    return "redirect:/getAllProducts";
	}

	private void handleProductImageUpload(Product product) {
	    MultipartFile image = product.getProductImage();

	    // Check if an image file is provided
	    if (image != null && !image.isEmpty()) {
	        // Define the directory where images will be stored (adjust the path as needed)
	        String imageDirectory = "static/resource/images/";

	        // Generate the file path based on the product ID
	        String imagePath = imageDirectory + product.getProductId() + ".jpg";

	        try {
	            // Create a Path object for the destination file
	            Path path = Paths.get(imagePath);

	            // Transfer the uploaded image to the destination file
	            image.transferTo(path.toFile());
	        } catch (IllegalStateException | IOException e) {
	            // Handle exceptions if necessary (e.g., logging or error messages)
	            e.printStackTrace();
	        }
	    }
	}

	@RequestMapping(value = "/admin/product/editProduct/{productId}")
	public ModelAndView getEditForm(@PathVariable(value = "productId") Long productId) {
		Product product = productService.getProductById(productId);
		return new ModelAndView("editProduct", "editProductObj", product);
	}

	@RequestMapping(value = "/admin/product/editProduct", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute(value = "editProductObj") Product product) {
		productService.editProduct(product);
		return "redirect:/getAllProducts";
	}

	@RequestMapping("/getProductsList")
	public @ResponseBody List<Product> getProductsListInJson() {
		return productService.getAllProducts();
	}

	@RequestMapping("/productsListAngular")
	public String getProducts() {
		return "productListAngular";
	}

}
