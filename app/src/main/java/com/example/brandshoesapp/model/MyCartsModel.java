package com.example.brandshoesapp.model;

public class MyCartsModel {
    String productName;
    String productPrice;
    String currentDate;
    String currentTime;
    String totalPrice;
    String totalQuantity;
    String documentId;

    public MyCartsModel() {
    }

    public MyCartsModel(String productName, String productPrice, String currentDate, String currentTime, String totalPrice, String totalQuantity, String documentId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.documentId = documentId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
}