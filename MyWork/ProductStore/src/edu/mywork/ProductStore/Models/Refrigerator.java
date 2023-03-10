package edu.mywork.ProductStore.Models;

public class Refrigerator extends Product {
    private double refrigeratorHeight;
    private double refrigeratorWidth;
    private double refrigeratorDepth;
    private double refrigeratorVolume;
    private int refrigeratorNumberOfChambers;
    private boolean refrigeratorIsNoFrost;

    public Refrigerator(String productBrand,
                        String productModel,
                        Color productColor,
                        String productInfo,
                        int productPowerCons,
                        int productPrice,
                        double refrigeratorHeight,
                        double refrigeratorWidth,
                        double refrigeratorDepth,
                        double refrigeratorVolume,
                        int refrigeratorNumberOfChambers,
                        boolean refrigeratorIsNoFrost) {
        super(ProductType.REFRIGERATOR, productBrand, productModel, productColor, productInfo, productPowerCons, productPrice);
        this.refrigeratorHeight = refrigeratorHeight;
        this.refrigeratorWidth = refrigeratorWidth;
        this.refrigeratorDepth = refrigeratorDepth;
        this.refrigeratorVolume = refrigeratorVolume;
        this.refrigeratorNumberOfChambers = refrigeratorNumberOfChambers;
        this.refrigeratorIsNoFrost = refrigeratorIsNoFrost;
    }

    @Override
    public String toString() {
        return this.getProductType().getProductTypeNameUa() + "\n" +
                "бренд : " + this.getProductBrand() +
                "; модель : " + this.getProductModel() +
                "; колір : " + this.getProductColor() + "\n" +
                "висота, см : " + refrigeratorHeight +
                "; ширина, см : " + refrigeratorWidth +
                "; глибина, см : " + refrigeratorDepth +
                "; об'єм, л : " + refrigeratorVolume + "\n" +
                "кількість камер : " + refrigeratorNumberOfChambers +
                "; технологія \"No Frost\" : " + (refrigeratorIsNoFrost? "Так" : "Ні") +
                "; потужність, Вт : " + this.getProductPowerCons() + "\n" +
                "вартість, грн : " + this.getProductPrice() + "\n" +
                "опис : " + this.getProductInfo();
    }
}
