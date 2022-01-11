package linkedList;

import org.junit.Test;

import linkedList.S02_mergeTwoLinkedLists.Node;
import linkedList.S03_RemoveDuplicatesFrmLL.ListNode;

public class P02_RemoveDuplicate {

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
		head.next.next = addNode(3);
		head.next.next.next = addNode(3);
		head.next.next.next.next = addNode(4);
		head.next.next.next.next.next = addNode(4);
		head.next.next.next.next.next.next = addNode(5);
		Node output = removeTargetElement(head);
		printAllValues(output);
	}
	
	@Test
	public void example2() {
		Node head = addNode(1);
		head.next = addNode(1);
		head.next.next = addNode(1);
		head.next.next.next = addNode(2);
		head.next.next.next.next = addNode(3);
		Node output = removeTargetElement(head);
		printAllValues(output);
	}
	
	private Node removeTargetElement(Node node) {
		Node current = null;
		int dup = -101;
		if(node==null) return node;
		while(node!=null) {
			if(node.next==null && node.data !=dup) {
				current = node;
				System.out.println(current.data);
			} else if (node.data != node.next.data && node.data !=dup) {
						current = node;
						current = current.next;
						System.out.println(node.data);
					} else dup = node.data;
				node = node.next;
				}	
		System.out.println(node.data);

		return node;
		}	
	
	public void printAllValues(Node node) {
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
		
	}
}
