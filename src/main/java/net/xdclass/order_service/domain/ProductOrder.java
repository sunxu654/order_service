package net.xdclass.order_service.domain;

import java.util.Date;

public class ProductOrder {
    private  int id;
    private String productName;
    private String tadeNo;
    private  int price;
    private Date createTime;
    private int userId;
    private String userName;

    public ProductOrder() {
    }

    public ProductOrder(int id, String productName, String tadeNo, int price, Date createTime) {
        this.id = id;
        this.productName = productName;
        this.tadeNo = tadeNo;
        this.price = price;
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTadeNo() {
        return tadeNo;
    }

    public void setTadeNo(String tadeNo) {
        this.tadeNo = tadeNo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
