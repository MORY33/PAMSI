package com.example;

class DoublyLinkedList {
    //A node class for doubly linked list
     class Node{
        String data;
        int key;
        Node previous;
        Node next;

        public Node(int key, String data) {
            this.key = key;
            this.data = data;
            next = null;
            previous = null;
        }

    }
    //Initially, heade and tail is set to null
    Node head, tail = null;
//        Node head = new Node();
//        Node tail = new Node();
    //add a node to the list
    public void addNode(int key, String data) {
        //Create a new node
        Node newNode = new Node(key, data);

        //if list is empty, head and tail points to newNode
        if(head == null) {
            head = tail = newNode;
            //head's previous will be null
            head.previous = null;
            //tail's next will be null
            tail.next = null;
        }
        else {
            //add newNode to the end of list. tail->next set to newNode
            tail.next = newNode;
            //newNode->previous set to tail
            newNode.previous = tail;
            //newNode becomes new tail
            tail = newNode;
            //tail's next point to null
            tail.next = null;
        }
    }



    void deleteAt(int position)
    {
        //usuwa po pozycji w liście, nie po indeksie
        // If linked list is empty
        if (head == null) {
            return;
        }

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (position == 0) {
            head = temp.next; // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1;
             i++)
            temp = temp.next;

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        temp.next
                = next; // Unlink the deleted node from list
//        printNodes();
    }


    //print all the nodes of doubly linked list
    public void printNodes() {
        //Node current will point to head
        Node current = head;
        if(head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null) {
            //Print each node and then go to next.
            System.out.print(current.key + " - " + current.data + " ");
            System.out.println();
            current = current.next;
        }


    }

    public String searchNode(int value) {
        int i = 1;
        int newKey = 0;
        String newData = "";
        boolean flag = false;



        //Node current will point to head
        Node current = head;


        //Checks whether the list is empty
        if (head == null) {
            System.out.println("List is empty");
            return newData;
        }

        while (current != null) {
            //Compare value to be searched with each node in the list
            if (current.key == value) {
                newData = current.data;
                newKey = current.key;
                flag = true;
                break;
            }
            current = current.next;
//            current.key = i;
//
            i++;
        }

        if (flag) {
            deleteAt(i-1);
        }
        else
            System.out.println("Node is not present in the list");

        return newData;
    }


    public DoublyLinkedList shuffleIt(int pcgNum) {

        DoublyLinkedList tempList = new DoublyLinkedList();
        String helpful = "";
//        pcg/2 do pcgnum
//        int rando = (int)(Math.random());

        int dontRepeat[] = new int[pcgNum];

        for (int i = 0; i<pcgNum; i++)
             {
//                 int rando2 = ThreadLocalRandom.current().nextInt(1, pcgNum);;
                 int rando2 = (int)(Math.random()*(pcgNum) + 1);

                 for(int k = 0; k < pcgNum; k++){
                     if(rando2 == dontRepeat[k]){
                         rando2 = (int)(Math.random()*(pcgNum) + 1);
                         k = -1;
                     }

                 }
                 dontRepeat[i] = rando2;

                 for (int j = 0; j<=pcgNum ; j++) {

                     if (j == rando2) {
                         helpful = searchNode(rando2);
                         tempList.addNode(rando2, helpful);
                     }
                 }

        }

        System.out.println("final nodes  I guess");
        return tempList;
    }

    public boolean isEmpty(){
        return(head == null);
    }


    public Node popTail (){
        if(!isEmpty()){
            if(tail.previous!=null){
                int key = tail.key;
                String data = tail.data;
                Node tempNode = new Node(key, data);
//                tail.previous.next = null;
                tail = tail.previous;
                return tempNode;
            }
            else{
                int key = tail.key;
                String value = tail.data;
                Node tempNode = new Node(key, value);
                head = null;
                tail = null;
                return tempNode;
            }
        }
        return null;
    }


    public DoublyLinkedList sort(){
//        Node tempPcg = head;
        DoublyLinkedList tempList = new DoublyLinkedList();

        while(!isEmpty()) {
            Node temp2 = popTail();
            while (!tempList.isEmpty() && tempList.tail.key > temp2.key){
                Node current = tempList.popTail();
                addNode(current.key, current.data);
            }
            tempList.addNode(temp2.key, temp2.data);

        }
        return tempList;
    }




}
