package linkedlist;

public class RemoveLoop {
	static Node head;
	class Node {
		int data;
		Node next;
		
		Node(int d) {
			d = data;
			next = null;
		}
	}
	public void detectLoop() {
		Node slow, fast;
		slow = head;
		fast = head;
		
		while(slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		
	}
	public static void main(String[] args) {

	}

}
