package com.techlab.articulo.model;

import java.util.ArrayList;

public class ProductServices {
    private ArrayList<Product> products = new ArrayList<>();

    public void create(Product product) {
        products.add(product);
    }

    public ArrayList<Product> findAll() {
        return products;
    };

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public boolean update(int id, double newPrice) {
        Product result = findById(id);
        if (result == null) {
            return false;
        } else {
            result.changePrice(newPrice);
            return true;
        }
    }

    public boolean delete(int id) {
        Product result = findById(id);
        if (result == null) {
            return false;
        } else {
            products.removeIf(products -> products.getId() == id);
            return true;
        }
    }
}
