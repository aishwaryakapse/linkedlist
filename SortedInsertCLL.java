package linkedlist;

public class SortedInsertCLL {
	static Node head;
		
	public static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next=null;
		}
	}
	public void sortedInsert(int new_data){
		if(head == null){
			System.out.println("head is null");
			head = new Node(new_data);
			head.next = head;
		} else if(head.data > new_data){
			Node temp = head;
			Node new_node = new Node(new_data);
			while(temp.next != head){
				temp = temp.next;
			}
			temp.next = new_node;
			new_node.next = head;
			head = new_node;
		}else{
			Node temp = head;
			if (head.next == head) {
				if(head.data < new_data) {
					Node new_node = new Node(new_data);
					temp.next = new_node;
					new_node.next = head;
				}
			}
			while(!(temp.data < new_data && temp.next.data > new_data) && temp.next != head) {
				temp = temp.next;
			}
			Node new_node = new Node(new_data);
			new_node.next = temp.next;
			temp.next = new_node;
		}
	}
	
	public void printList(){
		System.out.println("Inside printList");
		Node temp = head;
		if(head != null){
			System.out.println("Head is not null");
			do {
	            System.out.print(temp.data + " ");
	            temp = temp.next;
	         } while (temp != head && temp != null);
	        }		
	}
	
	public static void main(String[] args) {
		SortedInsertCLL sll = new SortedInsertCLL();
		sll.sortedInsert(5);
		sll.sortedInsert(3);
		sll.sortedInsert(7);
		sll.printList();
	}

}
