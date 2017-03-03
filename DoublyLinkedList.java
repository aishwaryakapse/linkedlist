package linkedlist;
public class DoublyLinkedList {
	
static Node head;
	static class Node{
		int data;
		Node next;
		Node prev;
		Node(int d){
			data = d;
			next = null;
			prev = null;
		}
	}
	//Insert node at the head
	public void push(Node head, int new_data){
		Node new_node = new Node(new_data);
		new_node.next = head;
		new_node.prev = null;
		
		if(head != null){
			head.prev = new_node;
		}
		
		head = new_node;
	}

	public void insertAfter(Node prev_node, int new_data){
		if(prev_node == null){
			System.out.println("Previous Node cannot be NULL");
			return;
		}
		System.out.println("Hie I am in insertAfter");
		Node new_node = new Node(new_data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
		new_node.prev = prev_node;
		if(new_node.next != null){
			new_node.next.prev = new_node;
		}
	}
	
	public void append(Node head, int new_data){
		Node temp = head;
		
		// if the list is empty
		if(temp == null){
			Node new_node = new Node(new_data);
			head = new_node;
			
			return;
		}
		
		while(temp.next != null){
			temp = temp.next;
		}
		Node new_node = new Node(new_data);
		temp.next = new_node;
		new_node.prev = temp;
		new_node.next = null;
		return;
	}
	
	public void printList(Node head){
		Node temp = head;
		if(temp == null){
			return;
		}
		if(temp != null){
			System.out.println(temp.data +" ");
			
		}
	}
	/*Delete a node in doubly linked list*/
	
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		head = new Node(7);
		//dll.append(head, 70);
		dll.push(head, 10);
		dll.push(head, 15);
		//dll.append(head, 75);
		dll.push(head, 20);
		dll.printList(head);
		//dll.insertAfter(head.next.next, 15);
	}
}
