package edu.mywork.ProductStore.Models;

public class Product {
    //private final String productType;
    private ProductType productType;
    private String productBrand;
    private String productModel;
    private Color productColor;
    private String productInfo;
    private int productPowerCons;
    private int productPrice;

    public Product(ProductType productType,
                   String productBrand,
                   String productModel,
                   Color productColor,
                   String productInfo,
                   int productPowerCons,
                   int productPrice) {
        this.productType = productType;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.productColor = productColor;
        this.productInfo = productInfo;
        this.productPowerCons = productPowerCons;
        this.productPrice = productPrice;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getProductTypeName() {
        return productType.getProductTypeNameEn();
    }

    public String getProductBrand() {
        return productBrand;
    }

    public String getProductModel() {
        return productModel;
    }

    public Color getProductColor() {
        return productColor;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public int getProductPowerCons() {
        return productPowerCons;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void printShort() {
        System.out.print(productBrand + " " +
                productModel + " " +
                productPrice + " грн"
        );
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType=" + productType.getProductTypeNameUa() +
                ", productBrand='" + productBrand + '\'' +
                ", productModel='" + productModel + '\'' +
                ", productColor='" + productColor.getColorNameEn() + '\'' +
                ", productInfo='" + productInfo + '\'' +
                ", productPowerCons=" + productPowerCons +
                ", productPrice=" + productPrice +
                '}';
    }
}
