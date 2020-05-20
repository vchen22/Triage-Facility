package com.cse.ds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.cse.ds.heaps.Heap;
import com.cse.ds.heaps.HeapSortGeneric;
import com.cse.ds.heaps.Tuple;
import com.cse.ds.hospital.TriageFacility;
import com.cse.ds.sorting.HeapSortString;
import com.cse.ds.sorting.Sorting;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenericTest {
	
	static Heap heap = null;
	
	@Before
    public void setUpBefore() {
		heap = new Heap();
        
		heap.heappush(new Tuple<String>(1,"AANDY"));
		heap.heappush(new Tuple<String>(2,"BANDY"));
		heap.heappush(new Tuple<String>(3,"CANDY"));
		heap.heappush(new Tuple<String>(4,"DANDY"));
		heap.heappush(new Tuple<String>(5,"EANDY"));
		heap.heappush(new Tuple<String>(6,"FANDY"));
		heap.heappush(new Tuple<String>(7,"GANDY"));
		heap.heappush(new Tuple<String>(8,"HANDY"));
        

        //victor
        /*
        heap.heappush(new Tuple<String>(1,"AANDY"));
        heap.heappush(new Tuple<String>(22, "BANDY"));
		heap.heappush(new Tuple<String>(3,"CANDY"));
        heap.heappush(new Tuple<String>(34, "DANDY"));
		heap.heappush(new Tuple<String>(15,"EANDY"));
		heap.heappush(new Tuple<String>(6,"FANDY"));
		heap.heappush(new Tuple<String>(71,"GANDY"));
		heap.heappush(new Tuple<String>(8,"HANDY"));
        heap.heappush(new Tuple<String>(21,"AANDY"));
        heap.heappush(new Tuple<String>(52, "BANDY"));
		heap.heappush(new Tuple<String>(163,"CANDY"));
        heap.heappush(new Tuple<String>(219, "DANDYDANDY"));
		heap.heappush(new Tuple<String>(45,"EANDY"));
		heap.heappush(new Tuple<String>(76,"FANDY"));
		heap.heappush(new Tuple<String>(217,"GANDY"));
		heap.heappush(new Tuple<String>(8,"HANDY"));
        */
    }
    
	@Test
	public void test1() {
		Assert.assertEquals(8,heap.getSize());
	}
	
    
	@Test
	public void test2( ) {
		Assert.assertEquals("HANDY",heap.getMax().value);
	}
	
	@Test
	public void test3( ) {
		Assert.assertEquals("HANDY",heap.heappop().value);
		Assert.assertEquals("GANDY",heap.getMax().value);
	}
	
	@Test
	public void test4( ) {
		heap.increasePriority(5, 100);
		Assert.assertEquals("CANDY",heap.getMax().value);
	}

    @Test
    public void testPopPush()
    {
        heap.heappop();
        heap.heappop();
        heap.heappop();
        heap.heappush(new Tuple<String>(9, "VICKI"));
        Assert.assertEquals(6, heap.getSize());
        Assert.assertEquals("VICKI", heap.getMax().value);
    }

    @Test
    public void testBetween()
    {
        Heap heap = new Heap();
        heap.heappush(new Tuple<String>(1,"AANDY"));
		heap.heappush(new Tuple<String>(2,"BANDY"));
		heap.heappush(new Tuple<String>(3,"CANDY"));
		heap.heappush(new Tuple<String>(5,"EANDY"));
		heap.heappush(new Tuple<String>(6,"FANDY"));
		heap.heappush(new Tuple<String>(7,"GANDY"));
		heap.heappush(new Tuple<String>(8,"HANDY"));

        heap.heappush(new Tuple<String>(4, "VICKI"));
        heap.heappop();
        heap.heappop();
        heap.heappop();
        System.out.println(heap.toString());
        Assert.assertEquals("EANDY", heap.getMax().value);
    }

	
	@Test
	public void test5( ) {
		Tuple<Integer> arr[] = new Tuple[] {new Tuple(3,1), new Tuple(2,2), new Tuple(1,3), new Tuple(9,4), new Tuple(4,5), new Tuple(8,6)};
		heap = new Heap(arr);
		Assert.assertEquals("[null, (9,4), (4,5), (8,6), (2,2), (3,1), (1,3)]",heap.toString());
	}
        
	@Test
	public void test6( ) {
		String color[] = new String[] {"WHITE","RED","BLUE"};
		int priority[] = new int[] {1,2,0};
		HeapSortGeneric sorting = new HeapSortGeneric<>(color, priority);
		//Assert.assertArrayEquals(new String[] {"RED","WHITE","BLUE"},sorting.sort(false));
		Assert.assertArrayEquals(new String[] {"BLUE","WHITE","RED"},sorting.sort(true));
	}
	
    
	@Test
	public void test7( ) {
		String array[] = new String[] {"A","C","F","B","E","D"};
		Sorting sorting = new HeapSortString();
		sorting.sort(array, false);
		//Assert.assertArrayEquals(new String[] {"A","B","C", "D", "E", "F"},array);
        Assert.assertArrayEquals(new String[] {"F", "E", "D", "C", "B", "A"}, array);
		//Assert.assertArrayEquals(new String[] {"BLUE","WHITE","RED"},sorting.sort(true));
	}
	
	@Test
	public void test8( ) {
		String array[] = new String[] {"A","C","F","B","E","D"};
		Sorting sorting = new HeapSortString();
		sorting.sort(array, false);
		Assert.assertArrayEquals(new String[] {"F","E","D", "C", "B", "A"},array);
	}
	
    
	@Test
	public void test9( ) {
		String patients[] = new String[] {"A:1","C:3","F:6","B:2","E:5","D:4"};
		TriageFacility triage = new TriageFacility(patients);
		Assert.assertEquals("A",triage.serviceNextPatient());
	}
	
	@Test
	public void test10( ) {
		String patients[] = new String[] {"A:1","C:3","F:6","B:2","E:5","D:4"};
		TriageFacility triage = new TriageFacility(patients);
		triage.serviceNextPatient();
		triage.serviceNextPatient();
		triage.addNewPatient("CSE:12");
		Assert.assertEquals(5,triage.getTriageLength());
	}
    

        /*
    //victor
    @Test
    public void test11()
    {
        Assert.assertEquals("DANDYDANDY", heap.getMax().value);
        Assert.assertEquals(16, heap.getSize());
        Assert.assertEquals("DANDYDANDY", heap.heappop().value);
        Assert.assertEquals("GANDY", heap.heappop().value);
        Assert.assertEquals(14, heap.getSize());
        heap.heappush(new Tuple<String>(1234, "ABC"));
        Assert.assertEquals("ABC", heap.getMax().value);
        Assert.assertEquals("ABC", heap.heappop().value);
        Assert.assertEquals("CANDY", heap.heappop().value);
        Assert.assertEquals(13, heap.getSize());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test12()
    {
        heap.increasePriority(1, 100);
    }

    @Test
    public void testHeapConstructor()
    {
        Tuple[] arr = new Tuple[13];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = new Tuple(i, "i" + i);
        }

        Heap heap = new Heap(arr);
        heap.heappop();
        Assert.assertEquals(12, heap.getSize());
        System.out.println(heap.toString());
        heap.heappush(new Tuple<String>(13, "i14"));
        heap.heappush(new Tuple<String>(12, "i15"));
        System.out.println(heap.toString());
        //is the toString correct?
    }

    @Test
    public void popEmpty()
    {
        Heap heap = new Heap();
        heap.heappush(new Tuple<String>(1, "123"));
        Assert.assertEquals("123", heap.heappop().value);
        Assert.assertEquals(heap.getSize(), 0);
        Assert.assertNull(heap.heappop());
    }

    @Test
    public void testHeapSortGeneric()
    {
        String color[] = new String[] {"WHITE", "RED", "BLUE", "HI", "PINK", "ORANGE", "YELLOW", "BLACK", "GREEN", "CYAN", "BLACK", "BROWN"};
        int priority[]= new int[] {1, 2, 0, 4, 11, 7, 3, 5, 9, 6, 8, 10};
        HeapSortGeneric sorting = new HeapSortGeneric<>(color, priority);
        Assert.assertArrayEquals(new String[] {"BLUE", "WHITE", "RED", "YELLOW", "HI", "BLACK", "CYAN", "ORANGE", "BLACK", "GREEN", "BROWN", "PINK"}, sorting.sort(true));
    }
    */


    
    
}
