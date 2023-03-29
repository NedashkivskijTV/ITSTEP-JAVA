package edu.mywork;

/**
 * Однозв'язний кільцьовий список
 */
public class CircularLinkedList {
    private Node last; // посилання на останній елемент (дозволяє миттєво отримати доступ без ітерірування)
    private int size; // кількість елементів колекції

    public void add(String value) {
        if (last == null) {
            setFirst(value);
        } else {
            addNew(value);
        }
        size++;
    }

    /**
     * Додавання найпершого елемента - голова вказує на себе
     *
     * @param value
     */
    private void setFirst(String value) {
        Node firstNode = new Node(value);
        last = firstNode;
        last.head = firstNode;
    }

    /**
     * Додавання наступного елемента (окрім найпершого)
     *
     * @param value
     */
    private void addNew(String value) {
        Node newNode = new Node(value);
        last.next = newNode;
        newNode.head = last.head;
        last.head = null;
        last = newNode;
    }

    /**
     * Видалення елемента
     *
     * @param value
     * @return
     */
    public boolean remove(String value) {
        if (last == null) {
            return false;
        }
        if (tryRemoveFirst(value)) {
            return true;
        }
        return remove(last.head, last.head.next, value);
    }

    /**
     * видалення першого елемента
     *
     * @param value
     * @return
     */
    private boolean tryRemoveFirst(String value) {
        if (last.head.value.equals(value)) {
            if (last.head.next == null) {
                last = null;
            } else {
                last.head = last.head.next;
            }
            size--;
            return true;
        }
        return false;
    }

    /**
     * Видалення елемента за значенням поля value
     *
     * @param prev
     * @param curr
     * @param value
     * @return
     */
    private boolean remove(Node prev, Node curr, String value) {
        if (curr == null) {
            return false;
        }

        if (curr.value.equals(value)) {
            if (curr.head == null) {
                prev.next = curr.next;
            } else {
                prev.next = null;
                prev.head = curr.head;
            }
            size--;
            return true;
        }
        return remove(curr, curr.next, value);
    }

    /**
     * Кількість елементів колекції
     *
     * @return
     */
    public int size() {
        return size;
    }


    /**
     * Перевизначений метод для виведення колекції у консоль
     *
     * @return
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        return printNodes(last.head);
    }

    /**
     * Формування рядка з вмісту (value) вузлів колекції -
     * використовує рекурсивний виклик
     *
     * @param node
     * @return
     */
    private String printNodes(Node node) {
        if (node.head != null) {
            return node.value;
        }
        String nodesStr = node.value + " " + printNodes(node.next);
        return nodesStr;
    }


    /**
     * Внутрішній допоміжний/службовий клас - вузол
     */
    private static class Node {
        Node next;
        String value;
        Node head;

        public Node(String value) {
            this.value = value;
        }

        public Node(Node next, Node head) {
            this.next = next;
            this.head = head;
        }
    }

}
