package linkedList;

import org.junit.Test;

import linkedList.S02_mergeTwoLinkedLists.Node;
import linkedList.S03_RemoveDuplicatesFrmLL.ListNode;

public class P01_RemoveLinkedListTargetElement {

	public class Node{
		int data;
		Node next;
		
		Node(int key){
			this.data = key;
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
	public void example1() {
		Node head = addNode(1);
		head.next = addNode(2);
		head.next.next = addNode(6);
		head.next.next.next = addNode(3);
		head.next.next.next.next = addNode(4);
		head.next.next.next.next.next = addNode(5);
		head.next.next.next.next.next.next = addNode(6);
		Node output = removeTargetElement(head,6);
		printAllValues(output);
	}
	
	@Test
	public void example2() {
		Node head = addNode(7);
		head.next = addNode(7);
		head.next.next = addNode(7);
		head.next.next.next = addNode(7);
		Node output = removeTargetElement(head,7);
		printAllValues(output);
	}
	
	private Node removeTargetElement(Node node, int target) {
		Node current = null;
		if(node==null) return node;
		while(node!=null) {
			if(node.data != target) {
				current = node;
				current = current.next;
				System.out.println(node.data);
			}
			node = node.next;
		}
		return node;
	}
	
	public void printAllValues(Node node) {
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
		
	}
}
