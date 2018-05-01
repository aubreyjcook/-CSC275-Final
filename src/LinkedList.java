import java.util.ListIterator;


public class LinkedList{
	public Node head;
	public static int size;
	
	public LinkedList() {
		head = new Node(null);
		size = 0;
	}
	
	public void add(Object dataValue) {
		
		if (head == null) {
			head = new Node(dataValue);
		}
		
		Node temporary = new Node(dataValue);
		Node current = head;
		
		if(current != null) {
			while (current.getNext() != null) {
				current = current.getNext();
			}
			
			current.setNext(temporary);
		}
		
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public boolean add(Object dataValue, int index) {
		Node end = new Node(dataValue);
		Node current = head;
		int jump;
		
		if(index > size || index < 1){
			return false;
		}
		else {
			jump = 0;
			while(jump < index - 1) {
				current = current.next;
				jump++;
			}
			end.next = current.next;
			current.next = end;
			size++;
			return true;
		}
	}
				
	public Object get(Integer index) {
		if (index < 0) return null;
		
		Node current = null;
		
		if (head != null) {
			current = head.getNext();
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null) return null;
				
				current = current.getNext();
			}
			return current.getData();
		}
		return current;
	}
	
	public boolean remove(Integer index) {
		if (index < 1 || index > size()) return false;
		
		Node current = head;
		if(head != null) {
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null) return false;
				
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());
			
			size--;
			return true;
		}
		return false;
	}
	
	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	private class Node {
		
		Object data;
	    
		private Node next;
		
	    //constructor
	    public Node(Object dataValue) {
	    	next = null;
	    	data = dataValue;
	    }
	    
	    public Node(Object dataValue, Node nextValue) {
	    	next = nextValue;
	    	data = dataValue;
	    }
	    
	    public Object getData() {
	    	return data;
	    }
	    
	    public Node getNext() {
	    	return next;
	    }
	    
	    public void setData(Object dataValue) {
	    	data = dataValue;
	    }
        	    
	    public void setNext(Node nextValue) {
	    	next = nextValue;
	    }
	}
}

