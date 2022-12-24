import java.util.Iterator;
import java.util.NoSuchElementException;

public class DList implements Iterable<String> {

	private static class DListNode {
		public String data;
		public DListNode next;
		public DListNode previous;
	}

	private DListNode nil;
	private int size;

	public DList() {
		nil = new DListNode();
		nil.previous = nil;
		nil.next = nil;
		nil.data = null;
		size = 0;
	}

	public void addFirst(String elem) {
		DListNode newNode = new DListNode();
		newNode.data = elem;
		newNode.previous = nil;
		nil.next.previous = newNode;
		newNode.next = nil.next;
		nil.next = newNode;
		size++;
	}

	public void addLast(String elem) {
	    DListNode newNode = new DListNode();
        newNode.data = elem;

        newNode.previous = nil.previous;
        nil.previous.next = newNode;
        nil.previous = newNode;
        nil.previous.next=nil;
        size++;
	}

	public String getFirst() {
		return nil.next.data;
	}

	public String getLast() {
		if(nil.previous == nil) {
			 throw new NoSuchElementException();
		}
		return nil.previous.data;
	}

	public String removeFirst() {
		if (size > 0) {
			DListNode temp = new DListNode();
			temp.data = nil.next.data;
			nil.next = nil.next.next;
			if (size == 1) {
				nil.previous = nil;
			} else {
				nil.next.previous = nil;
			}
			size--;
			return temp.data;
		}

		return nil.data;
	}

	public String removeLast() {
		if (size > 0) {
			DListNode temp = new DListNode();
			temp.data = nil.previous.data;
			nil.previous = nil.previous.previous;
			if (size == 1) {
				nil.next = nil;
			} else {
				nil.previous.next = nil;
			}
			size--;
			return temp.data;
		}
		return nil.data;
	}

	public String get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Not in bounds!");
		} else {
			int count = 0;
			DListNode temp = nil.next;
			while (count < index) {
				count++;
				temp = temp.next;
			}
			return temp.data;
		}
	}

	public String set(int index, String value) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Not in bounds!");
		} else {
			int count = 0;
			DListNode temp = nil.next;

			while (count < index) {
				count++;
				temp = temp.next;
			}
			String old = temp.data;
			temp.data = value;
			return old;
		}
	}

	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	public int size() {
		return size;
	}

	public int indexOf(Object obj) {
		int index=0;
        DListNode iter = nil.next;
        
        while(iter!=nil) {
            if(iter.data.equals(obj))
                return index;
            index++;
            iter=iter.next;
        }
        return -1;
	}

	public Iterator<String> iterator() {
		return new DListIterator();
	}

	private class DListIterator implements Iterator<String> {
		private DListNode pointer;

		public DListIterator() {
			if (nil.next == nil)
				pointer = nil;
			else
				pointer = nil.next;
		}

		public String next() {
			String old = pointer.data;
			pointer = pointer.next;
			return old;
		}

		public boolean hasNext() {
			return pointer != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
