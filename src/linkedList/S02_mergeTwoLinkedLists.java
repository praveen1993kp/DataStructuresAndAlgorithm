package linkedList;

import org.junit.Test;

public class S02_mergeTwoLinkedLists {

	public class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
		
		Node(){
			next = null;
		}
	}
	
	public Node addNode(int data) {
		return new Node(data);
	}
	
	@Test
	public void printNodes() {
		Node head1 = addNode(1);
		head1.next = addNode(3);
		head1.next.next = addNode(5);
		head1.next.next.next = addNode(7);
		
		Node head2 = addNode(2);
		head2.next = addNode(4);
		head2.next.next = addNode(6);
		head2.next.next.next = addNode(8);
		head2.next.next.next.next = addNode(10);
		
		mergeLinkedList(head1, head2);
		
	}
	
	public void mergeLinkedList(Node node1,Node node2) {
		Node merged = new Node();
		Node curr = merged;
		while(node1!=null && node2!=null) {	
			if(node1.data < node2.data ) {
				curr.next = node1;
				node1 = node1.next;	
			} else {
				curr.next = node2;
				node2 = node2.next;
			}
			curr = curr.next;
		} 
		printNodes(merged.next);
	}
	
	public void printNodes(Node node) {
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
}
