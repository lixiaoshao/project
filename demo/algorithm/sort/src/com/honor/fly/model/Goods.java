package com.honor.fly.model;

/**
 * com.honor.fly.model
 *
 * @author honor-ljp
 * 2023/1/26 15:35
 */
public class Goods {
    private double price;
    private String goodsName;
    private int saleNum;

    @Override
    public String toString() {
        return "Goods{" +
                "price=" + price +
                ", goodsName='" + goodsName + '\'' +
                ", saleNum=" + saleNum +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public Goods(double price, String goodsName, int saleNum) {
        this.price = price;
        this.goodsName = goodsName;
        this.saleNum = saleNum;
    }
}
