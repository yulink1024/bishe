package org.example.pojo;


import com.baomidou.mybatisplus.annotation.TableName;

@TableName("goodsinfo")
public class goodsInfo {
    private long id;//商品id
    private String imgurl;//图片
    private String shopName;//商店名字
    private String goodsName;//商品名
    private double goodsPrice;//价格
    private double hotpoint;//热度
    private String goodstips1;//商品标签 1
    private String goodstips2;//商品标签 2
    private String goodstips3;//商品标签 3

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public double getHotpoint() {
        return hotpoint;
    }

    public void setHotpoint(double hotpoint) {
        this.hotpoint = hotpoint;
    }

    public String getGoodstips1() {
        return goodstips1;
    }

    public void setGoodstips1(String goodstips1) {
        this.goodstips1 = goodstips1;
    }

    public String getGoodstips2() {
        return goodstips2;
    }

    public void setGoodstips2(String goodstips2) {
        this.goodstips2 = goodstips2;
    }

    public String getGoodstips3() {
        return goodstips3;
    }

    public void setGoodstips3(String goodstips3) {
        this.goodstips3 = goodstips3;
    }

    @Override
    public String toString() {
        return "goodsInfo{" +
                "id=" + id +
                ", imgurl='" + imgurl + '\'' +
                ", shopName='" + shopName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", hotpoint=" + hotpoint +
                ", goodstips1='" + goodstips1 + '\'' +
                ", goodstips2='" + goodstips2 + '\'' +
                ", goodstips3='" + goodstips3 + '\'' +
                '}';
    }
}
