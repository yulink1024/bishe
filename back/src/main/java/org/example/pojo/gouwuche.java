package org.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("gouwuche")
public class gouwuche {
    @TableId(type = IdType.AUTO)
    private long id;//购物车信息id
    private long uid;//所属用户id
    @TableField("goodid")
    private long goodid;//物品id
    private String imgurl;//图片url
    private String goodsName;//商品名称
    private int goodsNum;//购买数量
    private double totalPrice;//总价
    private String goodstips1;
    private String goodstips2;
    private String goodstips3;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getGoodid() {
        return goodid;
    }

    public void setGoodid(long goodid) {
        this.goodid = goodid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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
        return "gouwuche{" +
                "id=" + id +
                ", uid=" + uid +
                ", goodid=" + goodid +
                ", imgurl='" + imgurl + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsNum=" + goodsNum +
                ", totalPrice=" + totalPrice +
                ", goodstips1='" + goodstips1 + '\'' +
                ", goodstips2='" + goodstips2 + '\'' +
                ", goodstips3='" + goodstips3 + '\'' +
                '}';
    }
}
