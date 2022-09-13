package edu.itstep.hw20220912;

public class ForwardListInteger implements MyListInt {
    private Node head;

    public ForwardListInteger() {
        this.head = null;
    }

    public ForwardListInteger(int... values) {
        for (int val : values) {
            addToHead(val);
        }
    }

    @Override
    public void addToHead(int val) {
        this.head = new Node(val, this.head);
    }

    @Override
    public void addToTail(int val) {
        if (this.head == null) {
            addToHead(val);
        } else {
            Node newTail = new Node(val);
            Node temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newTail);
        }
    }

    @Override
    public void deleteFromHead() {
        if (this.head != null) {
            this.head = this.head.getNext();
        }
    }

    @Override
    public void deleteFromTail() {
        if (this.head == null) {
            return;
        }
        if (this.head.getNext() == null) {
            this.head = null;
        } else {
            Node temp = this.head;
            Node newTail = null;
            while (temp.getNext() != null) {
                newTail = temp;
                temp = temp.getNext();
            }
            newTail.setNext(null);
        }
    }

    @Override
    public void showList() {
        if (this.head != null) {
            Node temp = this.head;
            while (temp != null) {
                temp.showNode();
                //System.out.println();
                temp = temp.getNext();
            }
            System.out.println();
        }
    }

    private class Node { // внутрішній клас
        private int value;
        private Node next;

        public Node() {
            this(0, null);
        }

        public Node(int value) {
            this(value, null);
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void showNode() {
            System.out.print(this.value + " ");
        }
    }

}
