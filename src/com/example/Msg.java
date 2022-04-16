package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.io.File;



public class Msg {
    public String dMsg;

    public void createMsg() {
        Scanner scanner = new Scanner(System.in);
        String newMsg = scanner.nextLine();
        dMsg = newMsg;
        System.out.println("You've already created new message: " + dMsg);
    }

    public static String loadMsg() throws IOException {
        Path fileName = Path.of("C:\\Users\\rafal\\Documents\\STUDIA\\SEM4\\PAMSI\\Projekt1\\src\\com\\example\\doneBefore.txt");
        Msg str = new Msg();
        str.dMsg = Files.readString(fileName);

        // Printing the string
        System.out.println("You've already loaded new message: " + str.dMsg);
        return str.dMsg;
    }


    public void CreatePcg(String newMsg) {
        DoublyLinkedList dl_List = new DoublyLinkedList();
        double counter = 0;
        int temp = 1;
        String oneMore = "";

        String toBePrinted = newMsg;
//
        for (int i = 0; i < toBePrinted.length(); i++) {
            counter++;
        }

        double pcgNum = counter / 10;
        pcgNum = (int) Math.ceil(pcgNum);

        for (int i = 0; i < toBePrinted.length(); i++) {
            if (i % 10 == 0 && i!=0) {
                dl_List.addNode(temp, oneMore);
                oneMore = "";
                temp++;
            }
            oneMore += toBePrinted.charAt(i);
        }

        dl_List.addNode((int) pcgNum, oneMore);
        dl_List.printNodes();
        dl_List = dl_List.shuffleIt((int) pcgNum);
        dl_List.printNodes();
        System.out.println("posortowane w create msg");
        dl_List = dl_List.sort();
        dl_List.printNodes();

    }
}