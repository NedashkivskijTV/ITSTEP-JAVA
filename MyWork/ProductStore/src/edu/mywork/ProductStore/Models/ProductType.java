package edu.mywork.ProductStore.Models;

public enum ProductType {
    REFRIGERATOR("Refrigerator", "Refrigerators", "Холодильник"),
    TV("TV", "TVs", "Телевізор"),
    KETTLE("Kettle", "Kettles", "Чайник");

    private final String productTypeNameEn;
    private final String productTypeNameEnPlural;
    private final String productTypeNameUa;

    ProductType(String productTypeNameEn, String productTypeNameEnPlural, String productTypeNameUa) {
        this.productTypeNameEn = productTypeNameEn;
        this.productTypeNameEnPlural = productTypeNameEnPlural;
        this.productTypeNameUa = productTypeNameUa;
    }

    public String getProductTypeNameEn() {
        return productTypeNameEn;
    }

    public String getProductTypeNameEnPlural() {
        return productTypeNameEnPlural;
    }

    public String getProductTypeNameUa() {
        return productTypeNameUa;
    }
}
