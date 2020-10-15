package main.java.list;

/**
 * @author lijiangtao
 * @description 单项连表反转
 * @date 2020/10/15
 */
public class ReverseLinkedList {

	public static void main(String[] args) {

		ReverseLinkedList demo = new ReverseLinkedList();
		demo.test();
	}

	public void test(){

		Node head = initLinkedList(10);

		printLinkedList(head);

		System.out.println("**************");

		//反转链表
		Node node = reverse(head);
		printLinkedList(node);
	}

	public Node reverse(Node head){
		if(head == null || head.next == null){
			return head;
		}

		Node prev = null;
		Node next = null;
		while (head.next != null){
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		head.next = prev;
		return head;
	}


	/**初始化链表**/
	private Node initLinkedList(int num) {
		Node head = new Node(0, null);
		Node cur = head;
		for(int i=1; i<num;i++){
			cur.next = new Node(i, null);
			cur = cur.next;
		}
		return head;
	}


	/**打印链表**/
	private void printLinkedList(Node head) {
		Node node = head;
		while(node != null){
			System.out.println(node.value);
			node = node.next;
		}
	}

	class Node<T>{
		private T value;    //节点值
		private Node<T> next;   //后继节点

		public Node() {
		}
		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}

	}

}