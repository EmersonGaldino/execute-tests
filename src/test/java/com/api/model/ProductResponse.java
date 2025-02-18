package com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.lang.reflect.Array;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {

    private List<Product> products;

    // Getters and Setters
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static class Product {
        private int id;
        private String title;
        private String description;
        private String category;
        private double price;
        private double discountPercentage;
        private double rating;
        private int stock;
        private List<String> tags;
        private String brand;
        private String sku;
        private double weight;
        private Dimensions dimensions;
        private String warrantyInformation;
        private String shippingInformation;
        private String availabilityStatus;
        private List<Review> reviews;
        private String returnPolicy;
        private int minimumOrderQuantity;
        private Meta meta;
        private List<String> images;
        private String thumbnail;

        // Getters and Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getDiscountPercentage() {
            return discountPercentage;
        }

        public void setDiscountPercentage(double discountPercentage) {
            this.discountPercentage = discountPercentage;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public Dimensions getDimensions() {
            return dimensions;
        }

        public void setDimensions(Dimensions dimensions) {
            this.dimensions = dimensions;
        }

        public String getWarrantyInformation() {
            return warrantyInformation;
        }

        public void setWarrantyInformation(String warrantyInformation) {
            this.warrantyInformation = warrantyInformation;
        }

        public String getShippingInformation() {
            return shippingInformation;
        }

        public void setShippingInformation(String shippingInformation) {
            this.shippingInformation = shippingInformation;
        }

        public String getAvailabilityStatus() {
            return availabilityStatus;
        }

        public void setAvailabilityStatus(String availabilityStatus) {
            this.availabilityStatus = availabilityStatus;
        }

        public List<Review> getReviews() {
            return reviews;
        }

        public void setReviews(List<Review> reviews) {
            this.reviews = reviews;
        }

        public String getReturnPolicy() {
            return returnPolicy;
        }

        public void setReturnPolicy(String returnPolicy) {
            this.returnPolicy = returnPolicy;
        }

        public int getMinimumOrderQuantity() {
            return minimumOrderQuantity;
        }

        public void setMinimumOrderQuantity(int minimumOrderQuantity) {
            this.minimumOrderQuantity = minimumOrderQuantity;
        }

        public Meta getMeta() {
            return meta;
        }

        public void setMeta(Meta meta) {
            this.meta = meta;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
    }

    public static class Review {
        private int rating;
        private String comment;
        private String date;
        private String reviewerName;
        private String reviewerEmail;

        // Getters and Setters
        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getReviewerName() {
            return reviewerName;
        }

        public void setReviewerName(String reviewerName) {
            this.reviewerName = reviewerName;
        }

        public String getReviewerEmail() {
            return reviewerEmail;
        }

        public void setReviewerEmail(String reviewerEmail) {
            this.reviewerEmail = reviewerEmail;
        }
    }

    public static class Dimensions {
        private double width;
        private double height;
        private double depth;

        // Getters and Setters
        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getDepth() {
            return depth;
        }

        public void setDepth(double depth) {
            this.depth = depth;
        }
    }

    public static class Meta {
        private String createdAt;
        private String updatedAt;
        private String barcode;
        private String qrCode;

        // Getters and Setters
        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }
    }
}

