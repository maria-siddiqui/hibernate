
public class SinglyLinkedList {
private Node head;


private int size=0;

public SinglyLinkedList() {
head=null;
}

public void add(int data) {
	if(head==null) {
		head=new Node(data);
	}
	else {
	Node temp= head;
		while(temp!=null) {
			if(temp.getNext()==null) {
				temp.setNext(new Node(data));
				break;
			}
			
			temp=temp.getNext();
			
		}
		
	}
	size++;
}


public void remove(int data) {
	Node temp= head;
if(head.getData()==(data)) {
	head=head.getNext();
	size--;
}
else {
	while(temp.getNext()!=null) {
		System.out.println("trying to remove "+temp.getNext().getData());
		if(temp.getNext().getData()==(data))
		{
			temp.setNext(temp.getNext().getNext());
			System.out.println("Value Match to remove "+data);
		size--;
		break;
		}
		temp=temp.getNext();
	
	}
}
		

}
public int size() {
	return size;
}
public String toString() {
	StringBuilder sb= new StringBuilder();
	Node temp= head;
	while(temp!=null) {
		if(temp.getNext()!=null)
		sb.append(temp.toString()+"->");
		else
		sb.append(temp.toString());
		temp=temp.getNext();
	
	}
	return sb.toString();
}

public int get(int i) {
	Node temp= head;
	int index=0;
	while(temp!=null) {
		if(index==i)
			return temp.getData();
		else temp=temp.getNext();
		index++;
	}
	return 0;
}
public static void main(String[] args) {
	SinglyLinkedList s= new SinglyLinkedList();
	s.add(1);
	System.out.println(s.head);
	s.add(2);
	System.out.println(s.head);
	s.add(3);
	System.out.println(s.head);
	s.add(4);
	System.out.println(s.head);
	s.add(5);
	System.out.println(s.head);
	s.add(6);
	System.out.println(s.head);
	s.add(7);
	System.out.println(s.head);
	s.add(8);
	System.out.println(s.head);
	s.add(9);
	System.out.println(s.head);
	s.add(10);
	System.out.println(s.head);
	s.add(11);
	System.out.println(s.head);
	s.add(12);
	System.out.println(s.head);

	System.out.println(s.toString());
	s.remove(7);
	
	System.out.println(s.toString());
	s.remove(4);
	
	System.out.println(s.toString());
	s.remove(11);
	
	System.out.println(s.toString());
	
	
}



}
class Node{
	private int data;
	private Node next;
	
	
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	public Node(int data) {
		this.data = data;
		this.next=null;
	}
	public Node() {
	data=0;
	next=null;
	}
	public int getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}
	public void setData(int data) {
		this.data = data;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return ""+data;
	}
}