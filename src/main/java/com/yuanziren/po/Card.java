package com.yuanziren.po;

import java.io.Serializable;

/**
 * Created by xlf on 2019/4/11.
 */
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer cardNum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardNum() {
        return cardNum;
    }

    public void setCardNum(Integer cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNum=" + cardNum +
                '}';
    }
}
