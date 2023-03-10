package edu.mywork.ProductStore.Models;

public class DataBase {

    public static Refrigerator[] getRefrigeratorDB() {
        return new Refrigerator[]{
                new Refrigerator("LG", "GA-B509LQYL", Color.WHITE, "Холодильник LG GA-B509LQYL", 323, 25555, 203, 59.5, 68.2, 365.0, 2, true),
                new Refrigerator("Indesit", "LI7SN1EW", Color.WHITE, "Холодильник Indesit LI7SN1EW", 300, 16999, 199, 60.0, 61.0, 300.0, 2, true),
                new Refrigerator("Siemens", "KG39NXI326", Color.SILVER, "Холодильник Siemens KG39NXI326", 273, 22222, 203, 60.0, 66, 366, 2, false),
                new Refrigerator("Vestfrost", "CMR085W", Color.RED, "Холодильник Vestfrost CMR085W", 300, 6888, 82.1, 48, 50, 88, 1, false),
        };
    }

    public static TV[] getTvDB() {
        return new TV[]{
                new TV("Samsung", "UE43AU7100UXUA", Color.BLACK, "Телевізор Samsung 43AU7100 (UE43AU7100UXUA)", 130, 17899, 558.9, 963.9, 43, "3840x2160", true),
                new TV("Kivi", "32H740LW", Color.STEEL, "Телевізор Kivi 32H740LW", 40, 9999, 465, 720, 32, "1366х768", true),
                new TV("LG", "32LM637BPLA", Color.GREY, "Телевізор LG 32LM637BPLA", 10, 11499, 464, 736, 32, "1366х768", false),
                new TV("Samsung", "40T5300", Color.BLACK, "Телевизор Samsung 40T5300 (UE40T5300AUXUA)", 20, 13999, 552.4, 917.1, 40, "1920х1080", true),
                new TV("Sony", "50X85J", Color.BLACK, "Телевизор Sony 50X85J (KD50X85TJR)", 95, 39999, 715, 1119, 50, "3840x2160", true),
                new TV("HISENS", "50A7100F", Color.GREY, "Телевизор HISENSE 50A7100F (50A7100F)", 130, 16999, 709, 1116, 50, "3840x2160", true),
                new TV("Kivi", "32H740LW", Color.WHITE, "Телевизор Kivi 32H740LW", 40, 8699, 465, 720, 32, "1366х768", true),

        };
    }

    public static Kettle[] getKettleDB() {
        return new Kettle[]{
                new Kettle("Philips", "HD9318/20", Color.BLACK, "Електрочайник Philips HD9318/20", 2200, 1299, 25.5, 20.0, 1.7),
                new Kettle("Gorenje", "KE7096", Color.STEEL, "Електрочайник Gorenje K 17 G (KE7096) 1.9 л/2200 Вт/скло (K17G)", 2200, 1999, 21.8, 24.2, 1.9),
                new Kettle("Tefal", "KO260830", Color.WHITE, "Електрочайник Tefal KO260830", 2150, 1499, 22.2, 27.8, 1.5),

        };
    }

    public static Product[][] getProductDB(){
        return new Product[][]{
                getRefrigeratorDB(),
                getTvDB(),
                getKettleDB()
        };
    }
}
