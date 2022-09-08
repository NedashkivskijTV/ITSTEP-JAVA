package edu.itstep.hw20220907;

public class Product {
    private final String productType;
    protected String productBrand;
    protected String productModel;
    protected String productColor;
    protected String productInfo;
    protected int productPowerCons;
    protected int productPrice;

    public Product(String productType, String productBrand, String productModel, String productColor, String productInfo, int productPowerCons, int productPrice) {
        this.productType = productType;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.productColor = productColor;
        this.productInfo = productInfo;
        this.productPowerCons = productPowerCons;
        this.productPrice = productPrice;
    }

    public String getProductType() { return productType; }

    public void printShort() {
        System.out.print(productBrand + " " +
                productModel + " " +
                productPrice + " грн"
        );
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + productType + " " +
                "productBrand='" + productBrand + '\'' +
                ", productModel='" + productModel + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productInfo='" + productInfo + '\'' +
                ", productPowerCons=" + productPowerCons +
                ", productPrice=" + productPrice +
                '}';
    }

/*
    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public int getProductPowerCons() {
        return productPowerCons;
    }

    public void setProductPowerCons(int productPowerCons) {
        this.productPowerCons = productPowerCons;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public void print() {
        System.out.println("Product: " + productType + " " +
                productBrand + " " +
                productModel + " " +
                productColor + " " +
                productPowerCons + " " +
                productInfo + " " +
                productPrice
        );
    }
*/

}
