public class LinkedList {
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
	
	/*
	public void move(Integer indexPrev, Integer indexNext) {
		Node temp01 = new Node(get(indexPrev));
		if(get(indexNext) != null) {
			Node temp02 = new Node (get(indexPrev));
		}
		add(temp01, indexNext);
	}
	*/
	
	Node sortedMerge(Node a, Node b) {
		Node result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		
		if((a.getData().name).compareTo(b.getData().name) <= 0) {
			result = a;
			result.next = sortedMerge(a.next, b);
		}
		
		return result;
	}
	
	Node mergeSort(Node h)
	{
		if (h == null || h.next ==null)
		{
			return h;
		}
		
		Node middle = getMiddle(h);
		Node nextofmiddle = middle.next;
		
		middle.next = null;
		
		Node left = mergeSort(h);
		Node right = mergeSort(nextofmiddle);
		
		Node sortedList = sortedMerge(left, right);
		
		return sortedList;
	}
	
	Node getMiddle(Node h) {
		if(h == null) return h;
		
		Node fastptr = h.next;		
		Node slowptr = h;
		
		while(fastptr != null) {
			if(fastptr != null)
			{
				slowptr = slowptr.next;
				fastptr = fastptr.next;
			}
		}
		return slowptr;
	}
	
	public void push(Item newData) {
		Node newNode = new Node(newData);
		
		newNode.next = head;
		
		head = newNode;
	}
	
	private class Node {
				
		Item data;
	    
		private Node next;
		
	    //constructor
	    public Node(Item dataValue) {
	    	next = null;
	    	data = dataValue;
	    }
	    
	    @SuppressWarnings("unused")
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
	    
	    @SuppressWarnings("unused")
		public void setData(Item dataValue) {
	    	data = dataValue;
	    }
        	    
	    public void setNext(Node nextValue) {
	    	next = nextValue;
	    }
	}
}

