package edu.mywork.ProductStore.Models;

public class TV extends Product{
    private double tvHeight;
    private double tvWidth;
    private int tvScreenDiagonal;
    private String tvResolution;
    private boolean tvIsSmart;

    public TV(String productBrand,
              String productModel,
              Color productColor, String productInfo,
              int productPowerCons,
              int productPrice,
              double tvHeight,
              double tvWidth,
              int tvScreenDiagonal,
              String tvResolution,
              boolean tvIsSmart) {
        super(ProductType.TV, productBrand, productModel, productColor, productInfo, productPowerCons, productPrice);
        this.tvHeight = tvHeight;
        this.tvWidth = tvWidth;
        this.tvScreenDiagonal = tvScreenDiagonal;
        this.tvResolution = tvResolution;
        this.tvIsSmart = tvIsSmart;
    }

    @Override
    public String toString() {
        return this.getProductType().getProductTypeNameUa() + "\n" +
                "бренд : " + this.getProductBrand() +
                "; модель : " + this.getProductModel() +
                "; колір : " + this.getProductColor() + "\n" +
                "висота, см : " + tvHeight +
                "; ширина, см : " + tvWidth +
                "; діагональ, дюйм : " + tvScreenDiagonal +
                "; роздільна здатність : " + tvResolution + "\n" +
                "технологія \"Smart TV\" : " + (tvIsSmart? "Так" : "Ні") +
                "; потужність, Вт : " + this.getProductPowerCons() + "\n" +
                "вартість, грн : " + this.getProductPrice() + "\n" +
                "опис : " + this.getProductInfo();
    }
}
