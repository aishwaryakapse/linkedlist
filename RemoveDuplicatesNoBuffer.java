package linkedlist;

public class RemoveDuplicatesNoBuffer {

	static Node head;
	public static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public void deleteDuplicates(Node head){
		
		//Check if Linked List is empty
		if(head == null){
			return;
		}
		//Traverse using a runner pointer
		Node current = head;
		while(current != null){
			Node runner = current;
			while(runner.next != null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	
	public void display(Node head){
		Node start = head;
		while(start != null){
			System.out.print(start.data+" ");
			start = start.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		RemoveDuplicatesNoBuffer rd = new RemoveDuplicatesNoBuffer();
		rd.display(head);
		rd.deleteDuplicates(head);
		rd.display(head);
	}
}
