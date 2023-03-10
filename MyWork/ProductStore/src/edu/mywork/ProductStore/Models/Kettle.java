package edu.mywork.ProductStore.Models;

public class Kettle extends Product{
    private double kettleHeight;
    private double kettleDiameter;
    private double kettleVolume;

    public Kettle(String productBrand,
                  String productModel,
                  Color productColor,
                  String productInfo,
                  int productPowerCons,
                  int productPrice,
                  double kettleHeight,
                  double kettleDiameter,
                  double kettleVolume) {
        super(ProductType.KETTLE, productBrand, productModel, productColor, productInfo, productPowerCons, productPrice);
        this.kettleHeight = kettleHeight;
        this.kettleDiameter = kettleDiameter;
        this.kettleVolume = kettleVolume;
    }

    @Override
    public String toString() {
        return this.getProductType().getProductTypeNameUa() + "\n" +
                "бренд : " + this.getProductBrand() +
                "; модель : " + this.getProductModel() +
                "; колір : " + this.getProductColor() + "\n" +
                "висота, см : =" + kettleHeight +
                "; діаметр, см : " + kettleDiameter +
                "; об'єм, л : " + kettleVolume +
                "; потужність, Вт : " + this.getProductPowerCons() + "\n" +
                "вартість, грн : " + this.getProductPrice() + "\n" +
                "опис : " + this.getProductInfo();
    }
}
