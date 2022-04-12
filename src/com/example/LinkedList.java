package com.example;

public class LinkedList {
    List head;

    public void insert(String data){
        List list = new List();
        list.data = data;
        list.next = null;


        if(head==null){
            head=list;
        }
        else{
            List n = head;
            while(n.next!=null){
                n = n.next;
            }
            n.next = list;
        }
    }
    public void show(){
        List list = head;

        while(list.next!=null){
            System.out.println(list.data);
            list = list.next;
        }
//        list.next = list;
        System.out.println(list.data);
    }
}

