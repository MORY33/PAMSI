package com.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {

        Msg firstMess = new Msg();
        System.out.println("shit, eat a little bit");
        System.out.println("1 - Create a message");
        System.out.println("2 - Load previously created message");
        System.out.println("3 - Finish");
        System.out.println("Enter your choice: ");
        Scanner scan = new Scanner(System.in);

        int c = 0;
        while(true){
            c = scan.nextInt();
            if(c==1||c==2||c==3){
                break;
            }
            else{
                System.out.println("Ehh, enter valid number...");
                System.out.println("Your choice: ");
            }
        }

        switch (c) {
            case 1:
                System.out.println("You're about to create a message");
                System.out.println("Character limit for one package: 10");
//                System.out.println(firstMess.createMsg());
                Msg toprint = new Msg();
                DoublyLinkedList dl_List = new DoublyLinkedList();
                toprint.createMsg();
                System.out.println(toprint.dMsg);
                firstMess.CreatePcg(toprint.dMsg);
//                dl_List.sort();



                break;
            case 2:
                System.out.println("You lazy dumbass, go and load your message");
                firstMess.loadMsg();
                System.out.println(firstMess.dMsg);
                break;
            default:
                break;
        }
    }

        //lista jednokierunkowa
//    public static void main(String[] args){
//        LinkedList linked = new LinkedList();
//        linked.insert("Str");
//        linked.insert("Surr");
//        linked.insert("ender");
//
//        linked.show();

        //lista dwukierunkowa
//        DoublyLinkedList dl_List = new DoublyLinkedList();
//        //Add nodes to the list
//        dl_List.addNode("shee");
//        dl_List.addNode("shh");
//        dl_List.addNode("30it ");
//        dl_List.addNode("probably");
//        dl_List.addNode("works");
//
//        //print the nodes of DoublyLinkedList
//        dl_List.printNodes();
    }

    //wszystko czego tylko dotne to staje sie zlotem