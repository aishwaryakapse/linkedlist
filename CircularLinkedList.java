package linkedlist;

public class CircularLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Traversing the circular linked list */
	public void printList(Node first) {
		Node temp = first;
		// if only one node
		if (temp == temp.next) {
			// System.out.println("Hie");
			System.out.println(temp.data);
			return;
		}
		// more than one nodes
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while (temp != first);
	}

	/* Inserting data at the start of the Circular Linked List */
	public Node insertInto(Node head, int new_data) {
		Node temp = head;
		Node new_node = new Node(new_data);
		if (temp == null) {
			new_node.next = new_node;
		}
		new_node.next = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = new_node;
		head = new_node;
		return head;
	}

	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		Node head = new Node(36);
		head.next = new Node(64);
		head.next.next = new Node(36);
		head.next.next.next = head;
		Node result = cll.insertInto(head, 65);
		cll.printList(result);
	}
}
