package com.techlab.articulo.model;

public class FoodArticle extends Article {
    int daysForExpiration;

    public FoodArticle(
            int code, String Name, double price, Category category, int daysForExpiration) {
        super(code, Name, price, category);
        this.daysForExpiration = daysForExpiration;
    }

    public int getDaysForExpiration() {
        return daysForExpiration;
    }

    public void setDaysForExpiration(int daysForExpiration) {
        this.daysForExpiration = daysForExpiration;
    }

    @Override
    public String getArticleType() {
        return "Alimenticio";
    }

    @Override
    public String getSpecificDetail() {
        return "Dias restantes para vencimiento" + daysForExpiration;
    }

    @Override
    public String toString() {
        return super.toString() + ", [Subtipo Alimenticio]";
    }

}
