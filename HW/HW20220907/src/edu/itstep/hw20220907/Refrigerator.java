package edu.itstep.hw20220907;

public class Refrigerator extends Product {
    private double refrigeratorHeight;
    private double refrigeratorWidth;
    private double refrigeratorDepth;
    private double refrigeratorVolume;
    private int refrigeratorNumberOfChambers;
    private boolean refrigeratorIsNoFrost;

    public Refrigerator(String productBrand,
                        String productModel,
                        String productColor,
                        String productInfo,
                        int productPowerCons,
                        int productPrice,
                        double refrigeratorHeight,
                        double refrigeratorWidth,
                        double refrigeratorDepth,
                        double refrigeratorVolume,
                        int refrigeratorNumberOfChambers,
                        boolean refrigeratorIsNoFrost) {
        super("Холодильник", productBrand, productModel, productColor, productInfo, productPowerCons, productPrice);
        this.refrigeratorHeight = refrigeratorHeight;
        this.refrigeratorWidth = refrigeratorWidth;
        this.refrigeratorDepth = refrigeratorDepth;
        this.refrigeratorVolume = refrigeratorVolume;
        this.refrigeratorNumberOfChambers = refrigeratorNumberOfChambers;
        this.refrigeratorIsNoFrost = refrigeratorIsNoFrost;
    }

    @Override
    public String toString() {
        return this.getProductType() + "\n" +
                "бренд : " + productBrand +
                "; модель : " + productModel +
                "; колір : " + productColor + "\n" +
                "висота, см : " + refrigeratorHeight +
                "; ширина, см : " + refrigeratorWidth +
                "; глибина, см : " + refrigeratorDepth +
                "; об'єм, л : " + refrigeratorVolume + "\n" +
                "кількість камер : " + refrigeratorNumberOfChambers +
                "; технологія \"No Frost\" : " + (refrigeratorIsNoFrost? "Так" : "Ні") +
                "; потужність, Вт : " + productPowerCons + "\n" +
                "вартість, грн : " + productPrice + "\n" +
                "опис : " + productInfo
                ;
    }

/*
    public double getRefrigeratorHeight() { return refrigeratorHeight; }

    public void setRefrigeratorHeight(double refrigeratorHeight) {
        this.refrigeratorHeight = refrigeratorHeight;
    }

    public double getRefrigeratorWidth() {
        return refrigeratorWidth;
    }

    public void setRefrigeratorWidth(double refrigeratorWidth) {
        this.refrigeratorWidth = refrigeratorWidth;
    }

    public double getRefrigeratorDepth() {
        return refrigeratorDepth;
    }

    public void setRefrigeratorDepth(double refrigeratorDepth) {
        this.refrigeratorDepth = refrigeratorDepth;
    }

    public double getRefrigeratorVolume() {
        return refrigeratorVolume;
    }

    public void setRefrigeratorVolume(double refrigeratorVolume) {
        this.refrigeratorVolume = refrigeratorVolume;
    }

    public int getRefrigeratorNumberOfChambers() {
        return refrigeratorNumberOfChambers;
    }

    public void setRefrigeratorNumberOfChambers(int refrigeratorNumberOfChambers) {
        this.refrigeratorNumberOfChambers = refrigeratorNumberOfChambers;
    }

    public boolean isRefrigeratorIsNoFrost() { return refrigeratorIsNoFrost; }

    public void setRefrigeratorIsNoFrost(boolean refrigeratorIsNoFrost) { this.refrigeratorIsNoFrost = refrigeratorIsNoFrost; }
*/

}
