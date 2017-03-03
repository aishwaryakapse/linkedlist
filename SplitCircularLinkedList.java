package linkedlist;

public class SplitCircularLinkedList {
static Node head, head1, head2; // head of the list
	
	/* Linked list Node. This inner class 
	is made static so that main() can access it.*/
	static class Node{
		int data;
		Node next;
		//next is by default initialized as null
		Node(int d){
			data = d;
			next=null;
		}
	}
	
	public void splitList(){
		Node slow = head;
		Node fast = head;
		
		//if list is empty
		if(head == null){
			return;
		}
		
		while(fast.next != head && fast.next.next != head){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//If even no of nodes adjust the fast pointer
		if(fast.next.next == head){
			fast = fast.next;
		}
		
		//set heads for both parts
		head1 = head;
		head2 = slow.next;
		
		//make both lists circular
		slow.next = head1;
		fast.next = head2;
		
	}
	
	public void printList(Node first){
		Node temp =first;
		if(temp != null){
			do{
				System.out.println(temp.data + " ");
				temp = temp.next;
			}while(temp != first);
		}
	}
	
	public static void main(String[] args) {
		SplitCircularLinkedList list = new SplitCircularLinkedList();
		
		SplitCircularLinkedList.head = new Node(12);
        SplitCircularLinkedList.head.next = new Node(56);
        SplitCircularLinkedList.head.next.next = new Node(2);
        SplitCircularLinkedList.head.next.next.next = new Node(11);
        SplitCircularLinkedList.head.next.next.next.next = SplitCircularLinkedList.head; //make circular
		
        System.out.println("Original Linked List: ");
        list.printList(head);
        
        //Split the List
        list.splitList();
        System.out.println();
        System.out.println("First Circular List");
        list.printList(head1);
        System.out.println();
        System.out.println("Second Circular List");
        list.printList(head2);
        
	}

}
