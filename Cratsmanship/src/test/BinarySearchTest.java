package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.BinarySearch;
import main.EmptyArrayException;

public class BinarySearchTest {

	@Test(timeout = 5000)
	public void testArraywithOddNumberOfElements() throws EmptyArrayException{
		int [] collection = new int[] {
				11,22,33,44,55,66,77
		};
		assertEquals(1,BinarySearch.search(collection, 22));
		assertEquals(0,BinarySearch.search(collection, 11));
		assertEquals(3,BinarySearch.search(collection, 44));
		assertEquals(4,BinarySearch.search(collection, 55));
		assertEquals(5,BinarySearch.search(collection, 66));
		assertEquals(6,BinarySearch.search(collection, 77));
		assertEquals(-1,BinarySearch.search(collection,88));
		assertEquals(-1,BinarySearch.search(collection, 9));
		assertEquals(-1,BinarySearch.search(collection, 100));
		//fail("Not yet implemented");
	}

	@Test(timeout = 5000)
	public void testArrayWithEvenNumberOfElements() 
			throws EmptyArrayException{
		int [] collection = new int[] {
				11,22,33,44,55,66,77,88
		};
		assertEquals(1,BinarySearch.search(collection, 22));
		assertEquals(0,BinarySearch.search(collection, 11));
		assertEquals(3,BinarySearch.search(collection, 44));
		assertEquals(4,BinarySearch.search(collection, 55));
		assertEquals(5,BinarySearch.search(collection, 66));
		assertEquals(6,BinarySearch.search(collection, 77));
		assertEquals(7,BinarySearch.search(collection,88));
		assertEquals(-1,BinarySearch.search(collection, 9));
		assertEquals(-1,BinarySearch.search(collection, 100));
		//fail("Not yet implemented");
	}


	@Test(timeout = 5000)
	public void testArrayWithOnlyOneElement() 
			throws EmptyArrayException{
		int [] collection = new int[] {
				11
		};
		
		assertEquals(0,BinarySearch.search(collection, 11));
		assertEquals(-1,BinarySearch.search(collection,88));
		assertEquals(-1,BinarySearch.search(collection, 9));
		//fail("Not yet implemented");
	}


	@Test(timeout = 5000, expected = EmptyArrayException.class)
	public void testEmptyArray() 
			throws EmptyArrayException{
		int [] collection = new int[]{};
		assertEquals(-1,BinarySearch.search(collection, 11));
		assertEquals(-1,BinarySearch.search(collection,88));
		assertEquals(-1,BinarySearch.search(collection, 9));
		//fail("Not yet implemented");
	}
}
