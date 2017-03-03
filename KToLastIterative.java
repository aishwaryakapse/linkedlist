package linkedlist;

public class KToLastIterative {
	
	static Node head;
	public static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public Node kToLast(Node head, int k){
		
		if(k <= 0) return null;
		
		Node p1 = head;
		Node p2 = head;
		
		//Move p2 forward k nodes
		for(int i=0; i<k; i++){
			if(p2 == null) return null;
			p2 = p2.next;
		}
		if(p2 == null) return null;
		
		//Now move p1 an p2 at the same speed
		//When p2 hits the end, p1 will be at the
		// right element
		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
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
		KToLastIterative ktli = new KToLastIterative();
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		ktli.display(head);
		int k = 1;
		Node p1 = ktli.kToLast(head, k);
		System.out.println(p1.data);
	}

}
