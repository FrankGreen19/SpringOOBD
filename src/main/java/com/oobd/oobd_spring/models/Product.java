package com.oobd.oobd_spring.models;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String productType;

    @Column
    private String productBrand;

    @Column
    private double productPrice;

//    @ManyToMany
//    @JoinTable (name="order_product",
//            joinColumns=@JoinColumn (name="product_id"),
//            inverseJoinColumns=@JoinColumn(name="order_id"))
//    private List<Order> orderList;

    public Product(String productType, String productBrand, double productPrice) {
        this.productType = productType;
        this.productBrand = productBrand;
        this.productPrice = productPrice;
    }

    public Product() {

    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product: \n" +
                "type:" + this.productType + "\n" +
                "brand:" + this.productBrand + "\n" +
                "price:" + this.productPrice + "\n";
    }

//    @Override
//    public int compareTo(Object obj) {
//        Product tmp = (Product) obj;
//        if(this.getProductPrice() < tmp.getProductPrice())
//        {
//            /* текущее меньше полученного */
//            return -1;
//        }
//        else if(this.productPrice > tmp.productPrice)
//        {
//            /* текущее больше полученного */
//            return 1;
//        }
//        /* текущее равно полученному */
//        return 0;
//    }

    public String getValue() {
        return "('" + productType + "','" + productBrand + "'," + productPrice +")";
    }
}
