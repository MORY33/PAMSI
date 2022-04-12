package com.example;
import com.sun.jdi.Value;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.io.File;

import static java.lang.Math.ceil;


public class Msg {
    public String dMsg;

    public void createMsg() {
        Scanner scanner = new Scanner(System.in);
        String newMsg = scanner.nextLine();
        dMsg = newMsg;
        System.out.println("You've already created new message: " + dMsg);
    }

    public static void loadMsg() throws IOException {
        File file = new File("C:\\Users\\rafal\\Documents\\STUDIA\\SEM4\\PAMSI\\Projekt1\\src\\com\\example\\doneBefore.txt");
        Scanner scan = new Scanner(file);
        String liner = "";
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
    // tu test drugiej wersji
        Path fileName = Path.of("C:\\Users\\rafal\\Documents\\STUDIA\\SEM4\\PAMSI\\Projekt1\\src\\com\\example\\doneBefore.txt");

        // Now calling Files.readString() method to
        // read the file
        Msg str = new Msg();
        str.dMsg = Files.readString(fileName);

        // Printing the string
        System.out.println(str);

    }


    public void CreatePcg(String newMsg) {
        DoublyLinkedList dl_List = new DoublyLinkedList();
        DoublyLinkedList sec_list = new DoublyLinkedList();
        double counter = 0;
        int temp = 1;
        String oneMore = "";

        String toBePrinted = newMsg;
//        System.out.println(toBePrinted);
        for (int i = 0; i < toBePrinted.length(); i++) {
            counter++;
        }

        double pcgNum = counter / 10;
        pcgNum = (int) Math.ceil(pcgNum);
//        System.out.println(pcgNum);
//        System.out.println(counter + " that's how many characters is");
        double strSize = toBePrinted.length();

        for (int i = 0; i < toBePrinted.length(); i++) {
            if (i % 10 == 0 && i!=0) {
                dl_List.addNode(temp, oneMore);
                oneMore = "";
                temp++;
            }
            oneMore += toBePrinted.charAt(i);
        }

        DoublyLinkedList.Node head = null;
//        System.out.println(pcgNum);
        dl_List.addNode((int) pcgNum, oneMore);
        dl_List.printNodes();
        dl_List = dl_List.shuffleIt((int) pcgNum);
        dl_List.printNodes();
        System.out.println("posortowane w create msg");
        dl_List = dl_List.sort();
        dl_List.printNodes();
//        dl_List.deleteNode(dl_List.head);
//        dl_List.printNodes();
//        dl_List.deleteNode(dl_List.tail);
//        dl_List.printNodes();



    }
}