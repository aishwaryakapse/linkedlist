package linkedlist;

public class ktoLast {
static Node head;
	public static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public int kToLast(Node head, int k){
		
		if(head == null){
		return 0;
		}
		int i = kToLast(head.next, k) + 1;
		if(i == k){
			System.out.println(head.data);
		}
		return i;
	}
	
	public void display(Node head){
		Node start = head;
		while(start != null){
			System.out.print(start.data +" ");
			start = start.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ktoLast ktl = new ktoLast();
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		ktl.display(head);
		int k = 2;
		ktl.kToLast(head, k);
	}

}
