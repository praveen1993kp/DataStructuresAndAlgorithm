package linkedList;

import org.junit.Test;

public class S03_RemoveDuplicatesFrmLL {

	public class ListNode {
        int data;
        ListNode next;
        ListNode() {
        	next = null;
        }
        ListNode(int val) 
        { this.data = val; }
        ListNode(int val, ListNode next) 
        { this.data = val; this.next = next; }
    }
	
	public ListNode addNode(int data) {
		return new ListNode(data);
	}
	
	@Test
	public void example1() {
		ListNode head = addNode(1);
		head.next = addNode(3);
		head.next.next = addNode(4);
		head.next.next.next = addNode(4);
		head.next.next.next.next = addNode(5);
		ListNode output = removeDuplicates3(head);
		printAllValues(output);
	}
	
	
	public void printAllValues(ListNode node) {
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
		
	}
	
	public void removeDuplicates(ListNode node) {
		
		while(node!=null) {
			ListNode p1 = node;
			ListNode p2 = node.next;
			if(p1==p2) p1.next = p2.next;
			else p1 = p2;
		}
		
	}
	
	public ListNode removeDuplicates2(ListNode node) {
		ListNode p1 = node;
		ListNode p2 = node.next;
		while(p2!=null) {
			if(p1.data == p2.data) p1.next = p2.next;
			else p1 = p2;
			p2 = p2.next;
		}
		return node;
	}
	
	public ListNode removeDuplicates3(ListNode node) {
		ListNode merged = new ListNode();
		ListNode curr = merged;
		while(node != null) {
			if(node.data != node.next.data) {
				curr.next = node;
				node = node.next;
				curr = curr.next;
			}
			
			
		}
		System.out.println(curr.next);
		return curr.next;
	}
}
