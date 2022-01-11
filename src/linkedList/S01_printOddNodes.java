package linkedList;

import org.junit.Test;

public class S01_printOddNodes {

	public class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	public Node addNode(int data) {
		return new Node(data);
	}
	
	@Test
	public void printNodes() {
		Node head = addNode(1);
		head.next = addNode(2);
		head.next.next = addNode(3);
		head.next.next.next = addNode(4);
		head.next.next.next.next = addNode(5);
		printAllNodes(head);
		System.out.println("*****");
		printOddNodesMethod(head);
		System.out.println("*****");
		printOddValues(head);
	}
	
	public void printOddNodesMethod(Node node) {
		while(node != null) {
			System.out.println(node.data);
			node = node.next.next;
		}
	}
	
	public void printAllNodes(Node node) {
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	public void printOddValues(Node node) {
		while(node!=null) {
			if(node.data%2==1) System.out.println(node.data);
			node = node.next;
		}
	}
}
