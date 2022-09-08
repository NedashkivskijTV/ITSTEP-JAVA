package edu.itstep.hw20220907;

public class Kettle extends Product{
    private double kettleHeight;
    private double kettleDiameter;
    private double kettleVolume;

    public Kettle(String productBrand,
                  String productModel,
                  String productColor,
                  String productInfo,
                  int productPowerCons,
                  int productPrice,
                  double kettleHeight,
                  double kettleDiameter,
                  double kettleVolume) {
        super("Чайник", productBrand, productModel, productColor, productInfo, productPowerCons, productPrice);
        this.kettleHeight = kettleHeight;
        this.kettleDiameter = kettleDiameter;
        this.kettleVolume = kettleVolume;
    }

    @Override
    public String toString() {
        return this.getProductType() + "\n" +
                "бренд : " + productBrand +
                "; модель : " + productModel +
                "; колір : " + productColor + "\n" +
                "висота, см : =" + kettleHeight +
                "; діаметр, см : " + kettleDiameter +
                "; об'єм, л : " + kettleVolume +
                "; потужність, Вт : " + productPowerCons + "\n" +
                "вартість, грн : " + productPrice + "\n" +
                "опис : " + productInfo
                ;
    }

/*
    public double getKettleHeight() {
        return kettleHeight;
    }

    public void setKettleHeight(double kettleHeight) {
        this.kettleHeight = kettleHeight;
    }

    public double getKettleDiameter() {
        return kettleDiameter;
    }

    public void setKettleDiameter(double kettleDiameter) {
        this.kettleDiameter = kettleDiameter;
    }

    public double getKettleVolume() {
        return kettleVolume;
    }

    public void setKettleVolume(double kettleVolume) {
        this.kettleVolume = kettleVolume;
    }
*/

}
