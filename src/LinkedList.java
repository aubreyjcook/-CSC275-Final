import java.util.ListIterator;


public class LinkedList{
	public Node head;
	public static int size;
	
	public LinkedList() {
		head = new Node(null);
		size = 0;
	}
	
	public void add(Item dataValue) {
		
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
	
	public boolean add(Item dataValue, int index) {
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
				
	public Item get(Integer index) {
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
		//return current;
		return null;
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
	
	Node sortedMerge(Node a, Node b) {
		Node result = null;
		
		if(a == null) return b;
		if(b == null) return a;
		
		if(a.getData().equals(b.getData())) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else
		{
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		
		return result;
	}
	
	Node mergeSort(Node h) {
		if (h == null || h.next == null)
        {
            return h;
        }
		
		Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;
        
        middle.next = null;
        
        Node left = mergeSort(h);
        
        Node right = mergeSort(nextofmiddle);
        
        Node sortedlist = sortedMerge(left, right);
		return sortedlist;
	}
	
	Node getMiddle(Node h) {
		if(h == null) return h;
		Node fastptr = h.next;
		Node slowptr = h;
		
		while (fastptr != null) {
			fastptr = fastptr.next;
			if(fastptr != null) {
				slowptr = slowptr.next;
				fastptr = fastptr.next;
			}
		}
		return slowptr;
	}
	
	void push (Item newData) {
		Node newNode = new Node(newData);
		
		newNode.next = head;
		
		head = newNode;
	}
	
	/*
	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	private class Node {
		
		
		Item data;
	    
		private Node next;
		
	    //constructor
	    public Node(Item dataValue) {
	    	next = null;
	    	data = dataValue;
	    }
	    
	    public Node(Item dataValue, Node nextValue) {
	    	next = nextValue;
	    	data = dataValue;
	    }
	    
	    public Item getData() {
	    	return data;
	    }
	    
	    public Node getNext() {
	    	return next;
	    }
	    
	    public void setData(Item dataValue) {
	    	data = dataValue;
	    }
        	    
	    public void setNext(Node nextValue) {
	    	next = nextValue;
	    }
	}
}

