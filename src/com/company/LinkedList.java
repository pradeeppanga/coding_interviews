package com.company;

import java.util.HashSet;

public class LinkedList {
    Node head;
    static class Node {
        Node next;
        int data;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if(list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while(last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static LinkedList remove(LinkedList list, int data) {
        Node currNode = list.head;
        Node prev = null;

        if(currNode.next == null && currNode.data == data) {
            list.head = currNode.next;
            System.out.println(data + " found and deleted");
            return list;
        }

        while(currNode != null && currNode.data != data) {
            prev = currNode;
            currNode = currNode.next;
        }

        if(currNode != null) {
            prev.next = currNode.next;
            System.out.println(data + " found and deleted");
        }

        if(currNode == null) {
            System.out.println(data + " not found");
        }
        return list;
    }

    public static LinkedList deleteAtPosition(LinkedList list, int index) {
        Node currNode = list.head;
        Node prev = null;

        if(index == 0 && currNode != null) {
            list.head = currNode.next;
            System.out.println(index + " position element deleted");
            return list;
        }

        int counter = 0;

        while(currNode != null) {
            if(index == counter) {
                prev.next = currNode.next;
                System.out.println(index + " position element deleted");
                break;
            } else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if(currNode == null) {
            System.out.println(index + " position element not found");
        }

        return list;
    }

    public static LinkedList removeDuplicates(LinkedList list) {
        HashSet<Integer> set1 = new HashSet<>();
        Node currNode = list.head;
        Node prev = null;

        while(currNode != null) {
            if(set1.contains(currNode.data)) {
                prev.next = currNode.next;
            } else {
                set1.add(currNode.data);
                prev = currNode;
            }
            currNode = currNode.next;
        }
        return list;
    }

    public static void kthToLast(LinkedList list, int k) {
        Node currNode = list.head;
        int index = 0;
        while(currNode != null) {
            if(index >= k) {
                System.out.print(currNode.data);
            }
            currNode = currNode.next;
            index++;
            if(currNode != null && index > k) {
                System.out.print(" -> ");
            }
        }
    }

    public static LinkedList addTwoLinkedLists(LinkedList list1, LinkedList list2) {
        int length1 = getLength(list1);
        int length2 = getLength(list2);
        if(length1 < length2) {
            int diff = length2 - length1;
            while(diff > 0) {
                insert(list1, 0);
                diff--;
            }
        }
        if(length1 > length2) {
            int diff = length1 - length2;
            while(diff > 0) {
                insert(list2, 0);
                diff--;
            }
        }
        Node currNode1 = list1.head;
        Node currNode2 = list2.head;
        LinkedList list = new LinkedList();

        int carry = 0;
        int value = 0;

        while(currNode1 != null && currNode2 != null) {
            if(currNode1.data + currNode2.data + carry > 10) {
                value = carry + (currNode1.data + currNode2.data) - 10;
                carry = 1;
            } else {
                value = carry + (currNode1.data + currNode2.data);
                carry = 0;
            }

            insert(list, value);
            currNode1 = currNode1.next;
            currNode2 = currNode2.next;
        }
        return list;
    }

    public static int getLength(LinkedList list) {
        Node currNode = list.head;
        int length = 0;
        while(currNode != null) {
            length++;
            currNode = currNode.next;
        }
        return length;
    }

    public static LinkedList reverse(LinkedList list) {
        Node prev = null;
        Node curr = list.head;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head = prev;
        return list;
    }

    public static boolean isPalindrome(LinkedList list){
        LinkedList reverseList = reverse(list);
        Node currNode1 = list.head;
        Node currNode2 = reverseList.head;
        while(currNode1 != null && currNode2 != null) {
            if(currNode1.data != currNode2.data) {
                return false;
            }
            currNode1 = currNode1.next;
            currNode2 = currNode2.next;
        }
        return true;
    }

    public static void printList(LinkedList  list) {
        Node currentNode = list.head;
        System.out.print("Linked List: ");
        while(currentNode != null) {
            System.out.print(currentNode.data);
            currentNode = currentNode.next;
            if(currentNode != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        //printList(list);

        //list = deleteAtPosition(list, 5);

        //list = removeDuplicates(list);

        printList(list);

        //kthToLast(list, 5);

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1 = insert(list1, 5);
        list1 = insert(list1, 6);
        list1 = insert(list1, 3);
        list1 = insert(list1, 4);
        list2 = insert(list2, 8);
        list2 = insert(list2, 4);
        list2 = insert(list2, 2);

        printList(list1);
        printList(list2);

        LinkedList list3 = addTwoLinkedLists(list1, list2);

        printList(list3);

        reverse(list1);
        printList(list1);
    }
}
