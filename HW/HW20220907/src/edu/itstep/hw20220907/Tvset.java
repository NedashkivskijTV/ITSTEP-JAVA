package edu.itstep.hw20220907;

public class Tvset extends Product{
    private double tvHeight;
    private double tvWidth;
    private int tvScreenDiagonal;
    private String tvResolution;
    private boolean tvIsSmart;

    public Tvset(String productBrand,
                 String productModel,
                 String productColor,
                 String productInfo,
                 int productPowerCons,
                 int productPrice,
                 double tvHeight,
                 double tvWidth,
                 int tvScreenDiagonal,
                 String tvResolution,
                 boolean tvIsSmart) {
        super("Телевізор", productBrand, productModel, productColor, productInfo, productPowerCons, productPrice);
        this.tvHeight = tvHeight;
        this.tvWidth = tvWidth;
        this.tvScreenDiagonal = tvScreenDiagonal;
        this.tvResolution = tvResolution;
        this.tvIsSmart = tvIsSmart;
    }

    @Override
    public String toString() {
        return this.getProductType() + "\n" +
                "бренд : " + productBrand +
                "; модель : " + productModel +
                "; колір : " + productColor + "\n" +
                "висота, см : " + tvHeight +
                "; ширина, см : " + tvWidth +
                "; діагональ, дюйм : " + tvScreenDiagonal +
                "; роздільна здатність : " + tvResolution + "\n" +
                "технологія \"Smart TV\" : " + (tvIsSmart? "Так" : "Ні") +
                "; потужність, Вт : " + productPowerCons + "\n" +
                "вартість, грн : " + productPrice + "\n" +
                "опис : " + productInfo
                ;
    }

/*
    public double getTvHeight() {
        return tvHeight;
    }

    public void setTvHeight(double tvHeight) {
        this.tvHeight = tvHeight;
    }

    public double getTvWidth() {
        return tvWidth;
    }

    public void setTvWidth(double tvWidth) {
        this.tvWidth = tvWidth;
    }

    public int getTvScreenDiagonal() {
        return tvScreenDiagonal;
    }

    public void setTvScreenDiagonal(int tvScreenDiagonal) {
        this.tvScreenDiagonal = tvScreenDiagonal;
    }

    public String getTvResolution() {
        return tvResolution;
    }

    public void setTvResolution(String tvResolution) {
        this.tvResolution = tvResolution;
    }

    public boolean isTvIsSmart() { return tvIsSmart; }

    public void setTvIsSmart(boolean tvIsSmart) { this.tvIsSmart = tvIsSmart; }
*/

}
