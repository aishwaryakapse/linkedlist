package linkedlist;

public class RotateLinkedList {
	public static Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public void rotate(int k){
		// k cannot be 0
		if(k == 0){
			return;
		}
		
		Node current = head;
		
		int count = 0;
		
		while(count < k-1 && current != null){
			current = current.next;
			count++;
		}
		
		//if current is null, k > no of nodes in the list
		if(current ==  null){
			return;
		}
		
		Node kthNode = current;
		
		while(current.next != null){
			current = current.next;
		}
		
		current.next = head;
		head = kthNode.next;
		kthNode.next = null;
	}
	
	public void printList(Node head){
		while(head != null){
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		RotateLinkedList rll = new RotateLinkedList();
		RotateLinkedList.head = new Node(7);
		RotateLinkedList.head.next = new Node(8);
		RotateLinkedList.head.next.next = new Node(9);
		RotateLinkedList.head.next.next.next = new Node(4);
		
		System.out.println("Given Linked list is ");
		rll.printList(head);
		int k = 3;
		System.out.println("Linked List After Rotating by "+k);
		rll.rotate(k);
		rll.printList(head);

	}

}
