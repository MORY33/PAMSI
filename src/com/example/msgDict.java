package com.example;

public class msgDict {
   private String value;
   private int key;
   msgDict onePcg;


   public msgDict() {

   }

    public msgDict(String value, int key) {
        this.value = value;
        this.key = key;
        this.onePcg = null;
    }

    public msgDict(String value, int key, msgDict onePcg) {
        this.value = value;
        this.key = key;
        this.onePcg = onePcg;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public msgDict getOnePcg() {
        return onePcg;
    }

    public void setOnePcg(msgDict onePcg) {
        this.onePcg = onePcg;
    }

    public void addElement(String value, int key){
       msgDict newPcg = new msgDict(value, key);
       newPcg.onePcg = null;
       onePcg = newPcg;
    }
}
