package com.techlab.articulo.model;

public class ElectronicArticle extends Article {
    private int warrantyMonths;

    public ElectronicArticle(
            int code, String name, double price, Category category, int warrantyMonths) {
        super(code, name, price, category);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public String helpDeskForComplains() {
        return "0800-123-4567";
    }

    @Override
    public String getArticleType() {
        return "Electrónico";
    }

    @Override
    public String getSpecificDetail() {
        return "Meses de garantía: " + warrantyMonths;
    }

    @Override
    public String toString() {
        return super.toString() + "[Subtipo  Electrónico]";
    }
}
