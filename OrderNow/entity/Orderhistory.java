package com.meitong.onlineorder.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "orderhistory")
public class Orderhistory implements Serializable {
    @Id
    @Column(name = "Timestamp")
    private LocalDateTime publishedTimestamp;

    @Column(name = "Cart_id")
    private int cartId;

    @Column(name = "MenuItem_id")
    private int menuitemId;

    @Column(name = "MenuItem_name")
    private String menuItemName;

    public void setMenuItemName( String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public String getMenuItemName() {
        return menuItemName;
    }


    private static final long serialVersionUID = 2455760938054036111L;

    public LocalDateTime getPublishedTimestamp() {
        return publishedTimestamp;
    }

    public void setPublishedTimestamp(LocalDateTime publishedTimestamp) {
        this.publishedTimestamp = publishedTimestamp;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getMenuitemId() {
        return menuitemId;
    }

    public void setMenuitemId(int menuitemId) {
        this.menuitemId = menuitemId;
    }

}
