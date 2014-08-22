package com.rahul.uberapi.android.demo.model;

import java.util.List;

/**
 * Used by the product endpoint and lists the products in the proper display order.
 */
public class ProductList extends UberModel {

    /**
     * List of the products in the proper display order.
     */
    List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

}
