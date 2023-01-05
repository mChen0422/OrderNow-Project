package com.meitong.onlineorder.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "comments")
public class Comments implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    public LocalDateTime getPublishedTimestamp() {
        return publishedTimestamp;
    }

    public void setPublishedTimestamp(LocalDateTime publishedTimestamp) {
        this.publishedTimestamp = publishedTimestamp;
    }

    @Column(name = "Timestamp")
    private LocalDateTime publishedTimestamp;
    @Column(name = "Cart_id")
    private int cartId;

    @Column(name = "Customer_name")
    private String custormerName;

    @Column(name = "MenuItem_id")
    private int menuitemId;

    @Column(name = "MenuItem_name")
    private String menuItemName;

    @Column(name = "Comments")
    private  String yourComment;

    public String getYourComment() {
        return yourComment;
    }

    public void setYourComment(String yourComment) {
        this.yourComment = yourComment;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCustormerName() {
        return custormerName;
    }

    public void setCustormerName(String custormerName) {
        this.custormerName = custormerName;
    }

    public int getMenuitemId() {
        return menuitemId;
    }

    public void setMenuitemId(int menuitemId) {
        this.menuitemId = menuitemId;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }


}