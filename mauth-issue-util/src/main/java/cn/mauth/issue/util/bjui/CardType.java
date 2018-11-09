package cn.mauth.issue.util.bjui;

import java.io.Serializable;

public class CardType implements Serializable{

    private static final long serialVersionUID = 1L;
    private int faceValue;
    private int amount;

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
