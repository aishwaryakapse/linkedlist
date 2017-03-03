package linkedlist;

public class removeArrayPosition {
	static Node firstNode;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public static Node Removal(Node firstNode, int[] removalRequests, int removalRequests_Length){
	    int count = 0;
	    Node curr = firstNode;
	    Node prev = null;
	    
	    for(int i=0; i< removalRequests_Length; i++){
	    	while(curr != null){
	    		if(count == removalRequests[i]){
	    			prev.next = curr.next;
	    			curr = curr.next;
	    		}else{
	    			prev = curr;
		    		curr = curr.next;
	    		}
	    		count++;
	    	}
	    }
	    return firstNode;
	}
	
	public static void displayList(Node firstNode){
		Node temp = firstNode;
		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		removeArrayPosition.firstNode = new Node(50);
        removeArrayPosition.firstNode.next = new Node(20);
        removeArrayPosition.firstNode.next.next = new Node(15);
        removeArrayPosition.firstNode.next.next.next = new Node(4);
        removeArrayPosition.firstNode.next.next.next.next = new Node(10);
        removeArrayPosition.displayList(firstNode);
        int[] removalRequests = {1,3};
        int removalRequests_Length = 2;
        Node temp = removeArrayPosition.Removal(firstNode, removalRequests, removalRequests_Length);
        removeArrayPosition.displayList(temp);
	}
}
