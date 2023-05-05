package org.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("dingdan")
public class dingdan {
    @TableId(type = IdType.AUTO)
    private long id;//订单id
    private long uid;//用户id
    private long gid;//物品id
    private String goodsName;//商品名称
    private String imgurl;//图片
    private int goodsNum;//数量
    private double totalPrice;//总价
    private String userAddress;//地址

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

    public long getGid() {
        return gid;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
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

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "dingdan{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
                ", goodsName='" + goodsName + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", goodsNum=" + goodsNum +
                ", totalPrice=" + totalPrice +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
