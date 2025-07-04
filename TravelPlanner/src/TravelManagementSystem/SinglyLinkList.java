// SinglyLinkedList.java
package TravelManagementSystem;

class Node {
    Package data;
    Node next;

    Node(Package data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    // Constructor
    public SinglyLinkedList() {
        this.head = null;
    }

    // Method to add a Package to the end of the list
    public void addPackage(Package pkg) {
        Node newNode = new Node(pkg);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to fetch a Package at a specific index
    public Package fetchPackage(int index) {
        Node current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            current = current.next;
            count++;
        }

        return null; // Return null if index is out of bounds
    }

    // Method to print the list (for debugging purposes)
    public void printList() {
        Node current = head;
        if (current == null) {
            System.out.println("Empty List");
            return;
        }

        while (current != null) {
            System.out.print(current.data.getName());
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}