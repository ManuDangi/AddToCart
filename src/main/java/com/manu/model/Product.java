package com.manu.model;

import jakarta.persistence.Column; // Import Column annotation
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_data") // This is correct, it maps to your table
public class Product {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells Hibernate it's auto-incremented by the DB
    @Column(name = "s_no") // Explicitly map this field to the 's_no' column in the DB
    private Integer s_no; // Changed to Integer to match DB 'int' type.

    @Column(name = "brand_name") // Map to 'brand_name' in DB
    private String brandName;

    // You have 'dicreption' and 'description' columns in your DB.
    // Let's assume the entity's 'description' field should map to the 'description' column in DB.
    // If 'dicreption' is truly a separate column you need, you'll need another field.
    // For now, I'll map your existing 'description' field to the 'description' column.
    @Column(name = "description") // Map to 'description' in DB
    private String description;

    // IMPORTANT: If 'dicreption' (spelled this way) is meant to be a separate field, add it:
    // @Column(name = "dicreption")
    // private String misspelledDescription; // Or whatever you want to call it

    @Column(name = "type_of") // Map to 'type_of' in DB
    private String typeOf;

    @Column(name = "price") // Map to 'price' in DB
    private Integer price;

    // A no-argument constructor is required by JPA
    public Product() {
    }

    // --- Standard Getters and Setters ---

    // Change getId/setId to getS_no/setS_no
    public Integer getS_no() {
        return s_no;
    }

    public void setS_no(Integer s_no) {
        this.s_no = s_no;
    }

    // Existing getters/setters for other fields are mostly fine, but I added @Column for clarity
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // Update constructor to use s_no
    public Product(Integer s_no, String brandName, String description, String typeOf, Integer price) {
        super();
        this.s_no = s_no;
        this.brandName = brandName;
        this.description = description;
        this.typeOf = typeOf;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [s_no=" + s_no + ", brandName=" + brandName + ", description=" + description + ", typeOf=" + typeOf
                + ", price=" + price + "]";
    }
}