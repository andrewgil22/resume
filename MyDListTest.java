
public class MyDListTest {

	public static void main(String[] args) {
		DList dlist = new DList();
		//testing addFirst addLast and making sure get methods work
		dlist.addFirst("hello");
		dlist.addFirst("hi");
		dlist.addLast("maybe?");
		dlist.addFirst("good morning");
		System.out.println(dlist.get(0));
		System.out.println(dlist.getFirst());
		System.out.println(dlist.get(1));
		System.out.println(dlist.get(2));
		System.out.println(dlist.getLast());
		System.out.println(dlist.get(3));
		
		// testing remove methods
		dlist.removeFirst();
		System.out.println("\n"+dlist.get(0));
		dlist.removeLast();
		System.out.println(dlist.getLast());
		
		//set method being tested
		dlist.set(0,"no longer hi");
		System.out.println("\n");
		System.out.println(dlist.getFirst());
		
		//creating a new list with objects in it to test if indexOf and contains methods work
		DList dlist2 = new DList();
		dlist2.addFirst("no longer hi");
		dlist2.addLast("not in there");
		System.out.println(dlist.indexOf(dlist2.get(0)));
		System.out.println(dlist.indexOf(dlist2.get(1)));
		System.out.println(dlist.contains("blah"));
	}

}
