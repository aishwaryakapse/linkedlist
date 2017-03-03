package linkedlist;

import java.util.Hashtable;

public class removeDuplicates {
static Node head;
	public static class Node{
		int data;
		Node next;
		
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	public static void deleteDuplicates(Node head){
		
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		Node n = head;
		Node previous = null; // initially previous is pointing to null
		while(n != null){
			if(table.containsKey(n.data)){
				previous.next = n.next; // delete that node
			}else{
				table.put(n.data, true);
				previous = n; // change the previous to current node
			}
			n = n.next;
		}
		
	}
	
	public void display(Node head){
		Node start = head;
		while(start != null){
			System.out.print(start.data + " ");
			start = start.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		removeDuplicates rd = new removeDuplicates();
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		head.next.next.next.next = new Node(2);
		head.next.next.next.next.next = new Node(4);
		head.next.next.next.next.next.next = new Node(0);
		rd.display(head);
		removeDuplicates.deleteDuplicates(head);
		rd.display(head);
		
	}

}
