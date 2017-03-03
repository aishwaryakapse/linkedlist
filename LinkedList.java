package linkedlist;

public class LinkedList {
static Node head; // head of the list
	
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
	/*Traversal through the linked list*/
	public void printList(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data+" ");
			n=n.next;
		}
		System.out.println();
	}
	
	/*Inserting a new node at the front of the linked list */
	public void push(int new_data){
		/*+1 and 2: allocate the node and put in the data*/
		
		Node new_node = new Node(new_data);
		
		/*3: make next of new Node as head */
		new_node.next = head;
		
		/*4: Move the head to point to the new Node */
		head = new_node;
	}
	
	/* Inserting a new node after the given prev_node. */
	public void insertAfter(Node prev_node, int new_data){
		/*1. Check if the given node is null */
		if(prev_node==null){
			System.out.println("The given previous node cannot be null");
			return;
		}
		/*2. Allocate the Node & 3. Put in the data*/
		Node new_node = new Node(new_data);
		/*4. Make next of new_node as the next of prev_node*/
		new_node.next = prev_node.next;
		/*5.Make the next of prev_node as new_node*/
		prev_node.next = new_node;
	}
	
	/* Appends a new node at the end */
	public void append(int new_data){
		/*1. allocate the Node & 2. Put in the data
		3. Set next as null */
		Node new_node = new Node(new_data);
		/*4. If the Linked List is empty, then make the new node as head*/
		if(head == null){
			head = new Node(new_data);
			return;
		}
		/*Make the next of new node as null as it is the last node*/
		new_node.next = null;
		/*5. Else traverse till the last node */
		Node last = head;
		while(last.next!=null){
			last=last.next;
		}
		/*6. Change the next of the last node*/
		last.next=new_node;
	}
	
	/*Given a key, deletes the first occurrence of the key in the linked list*/
	/*void deleteNode(int key){
		//Store head
		Node temp = head;
		prev = null;
		
		//If head node itself holds the key
		if(temp != null && temp.data == key){
			head=temp.next;
			return;
		}
		//Search for the key to be deleted
		while(temp != null && temp.data != key){
			prev = temp;
			temp = temp.next;
		}
		// If key was not present
		if(temp == null){
			System.out.println("key not found, hence no node deleted!!!");
			return;
		}
		//Key found. Unlink the node
		prev.next = temp.next;
	}*/
	
	/* Delete a node at the given position */
	void deleteNode(int position){
		//If the linked list is empty
		if(head == null){
			return;
		}
		
		//Store head node
		Node temp = head;
		
		//If the head needs to be removed
		if(position == 0){
			head = temp.next;
			return;
		}
		
		//Find previous node of the node to be deleted
		for(int i=0;temp!=null && i<position-1;i++){
			temp=temp.next;
		}
		//If position is more than the number of nodes*/
		if(temp == null || temp.next == null){
			return;
		}
		//Delete the node
		Node next = temp.next.next;
		temp.next=next;
	}
	
	/* To count the number of nodes in a linked list */
	public int count(){
		Node current = head;
		int count = 0;
		while(current!=null){
			current = current.next;
			count++;
		}
		return count;
	}
	
	/*To swap two nodes in a linked list without changing the data*/
	public void swapNodes(int x, int y){
		//if x and y are same
		if(x == y) return;
		
		//Search through the linked list for x and y
		Node prevX = null, currX = head, prevY = null, currY = head;
		while(currX != null && currX.data != x){
			prevX = currX;
			currX = currX.next;
		}
		while(currY != null && currY.data != x){
			prevY = currY;
			currY = currY.next;
		}
		
		// x or y is a head
	if(prevX == null){
		head = currY;
	}else{
			prevX.next = currY;
		}
		
		if(prevY == null){
			head = currX;
		}else{
			prevY.next = currX;
		}
		
		// Swap the next pointers
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}
	
	/* Reverse a linked list using iterative method */
	public Node reverseIterative(){
		Node prev = null, current = head, after = null;
		while(current != null){
			after = current.next;
			current.next = prev;
			prev = current;
			current = after;
		}
		Node head1 = prev;
		return head1;
		
	}
	
	/* Reverse a linked list in groups of given size */
	
	public static Node reverse(Node head, int k){
		Node current = head;
		Node next = null;
		Node prev = null;
		
		int count = 0;
		
		while(count < k && current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		/*now next points to (k+1)th node
		Recursively reverse the next k nodes and attach them to the previously
		reversed k nodes
		*/
		if(next != null){
			head.next = reverse(next, k);
		}
		/* prev is now the head of the list */
		return prev;
		
	}
	
	/*Detect and remove loop*/
	
	public static int detectAndRemove(Node head){
		
		Node slow_p = head, fast_p =head;
		while(slow_p != null && fast_p != null && fast_p.next != null){
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if(slow_p == fast_p){
				System.out.println("Found Loop");
				removeLoop(slow_p, head);
				return 1;
			}
		}
		System.out.println("No Loop Found");
		return 0;
	}
	
	public static void removeLoop(Node loop,Node curr){
		Node ptr1 = null, ptr2 = null;
		ptr1 = curr;
		while(true){
			ptr2 = loop;
			while(ptr2.next != loop && ptr2.next != ptr1){
				ptr2=ptr2.next;
			}
			if(ptr2.next == ptr1){
				break;
			}
			ptr1=ptr1.next;
		}
		ptr2.next = null; // last node
			
	}
	
	/* method to create a simple linked list*/

	public static void main(String[] args) {
		/*start with an empty list with 3 nodes*/
		LinkedList llist = new LinkedList(); // create object
		llist.append(6);
		llist.push(3);
		llist.push(7);
		llist.append(4);
		llist.insertAfter(LinkedList.head.next,8);
		
		System.out.println("Created Linked List is: ");		
		llist.printList();
		
		System.out.println("The length of the linked list is: "+llist.count());
		
		llist.deleteNode(4);
		System.out.println("Linked List after deletion at position 4: ");
		llist.printList();
		System.out.println("The length of the linked list is: "+llist.count());
		
		llist.swapNodes(3,7);
		System.out.println("The Linked List after swapping is: ");
		llist.printList();
		
		head = llist.reverseIterative();
		System.out.println("Linked List after reversing using iterative method: ");
		llist.printList();
		
		head = reverse(head, 2);
		System.out.println("Linked List after reversing in groups of given size: ");
		llist.printList();
		
		LinkedList.head = new Node(50);
        LinkedList.head.next = new Node(20);
        LinkedList.head.next.next = new Node(15);
        LinkedList.head.next.next.next = new Node(4);
        LinkedList.head.next.next.next.next = new Node(10);
 
        // Creating a loop for testing 
        head.next.next.next.next.next = head.next.next;
		
		int y = LinkedList.detectAndRemove(head);
		System.out.println("True i.e 1 for loop else 0: "+y);
		System.out.println("Linked List after removing the loop: ");
		llist.printList();

	}

}
