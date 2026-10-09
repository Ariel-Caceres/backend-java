package com.techlab.articulo.model;

public abstract class Article {
    private int code;
    private String name;
    private double price;
    private Category category;

    public Article(int code, String name, double price, Category category) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public abstract String getArticleType();

    public abstract String getSpecificDetail();

    @Override
    public String toString() {
        return "Código: " + code
                + ", Nombre: " + name
                + ", Precio: " + price
                + ", Categoría: " + category.getName()
                + ", Tipo: " + getArticleType()
                + ", Detalle: " + getSpecificDetail();
    }
}
