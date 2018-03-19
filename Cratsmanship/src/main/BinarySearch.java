package main;

public class BinarySearch {

	public static int search(int[] collection, int value) 
			throws EmptyArrayException {
		// TODO Auto-generated method stub
		if(collection.length == 0){
			throw new EmptyArrayException();
		}
		if(null != collection && collection.length >= 1){

			int low = 0;
			int high = collection.length - 1;
			int middle;
			while(high >= low) {
				middle = (low + high) / 2;
				if(collection[middle] == value) {
					return middle;
				}
				if(collection[middle] < value) {
					low = middle +1;
				}
				if(collection[middle] > value) {
					high = middle -1;
				}
			}
		}

		return -1;
	}

	/*public static void main(String args[]){
		System.out.println(search(new int[]{},11));
	}*/
}

