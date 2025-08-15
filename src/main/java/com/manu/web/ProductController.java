package com.manu.web;

import com.manu.model.Product;
import com.manu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Use @Controller for MVC views
import org.springframework.ui.Model; // To pass data to JSP
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; // For flash attributes (optional, but good for messages)

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/") // Changed base mapping to root for simpler URL structure
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // --- Home Page ---
    // GET /
    @GetMapping // Maps to http://localhost:8686/
    public String home() {
        return "cart"; // 
    }

    // --- GET All Products (List View) ---
    // GET /products
    @GetMapping("/products") // Maps to http://localhost:8686/products
    public String showAllProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products); // Add the list to the model
        return "product-list"; // Renders src/main/webapp/WEB-INF/jsp/product-list.jsp
    }

    // --- Show Add New Product Form ---
    // GET /products/new
    @GetMapping("/products/new") // Maps to http://localhost:8686/products/new
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product()); // Provide an empty Product object for the form
        return "product-form"; // Renders src/main/webapp/WEB-INF/jsp/product-form.jsp
    }

    // --- Show Edit Product Form ---
    // GET /products/edit/{s_no}
    @GetMapping("/products/edit/{s_no}") // Maps to http://localhost:8686/products/edit/{s_no}
    public String showEditForm(@PathVariable("s_no") Integer s_no, Model model, RedirectAttributes redirectAttributes) {
        Optional<Product> productData = productService.findById(s_no);

        if (productData.isPresent()) {
            model.addAttribute("product", productData.get()); // Add existing product to the model
            return "product-form"; // Renders src/main/webapp/WEB-INF/jsp/product-form.jsp
        } else {
            // If product not found, redirect to list with an error message (optional)
            redirectAttributes.addFlashAttribute("errorMessage", "Product with ID " + s_no + " not found.");
            return "redirect:/products"; // Redirect back to the product list
        }
    }

    // --- Save Product (Create or Update) ---
    // POST /products/save
    @PostMapping("/products/save") // Maps to POST request to http://localhost:8686/products/save
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        try {
            productService.save(product);
            redirectAttributes.addFlashAttribute("successMessage", "Product saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving product: " + e.getMessage());
            // Log the exception for debugging
            e.printStackTrace();
        }
        return "redirect:/products"; // Redirect to the product list after save
    }

    // --- Delete Product ---
    // POST /products/delete/{s_no} with hidden _method=DELETE
    @PostMapping("/products/delete/{s_no}") // Maps to DELETE request (handled via HiddenHttpMethodFilter)
    public String deleteProduct(@PathVariable("s_no") Integer s_no, RedirectAttributes redirectAttributes) {
        try {
            productService.deleteById(s_no);
            redirectAttributes.addFlashAttribute("successMessage", "Product deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting product: " + e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/products"; // Redirect to the product list after delete
    }
}