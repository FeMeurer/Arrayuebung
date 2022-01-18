package de.telekom.sea7;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntList intList = new IntList(5);
		IntList intList3 = new IntList(5);
		
		intList.setValueOnPos(0, 5);
		intList.setValueOnPos(2, 7);
		intList.setValueOnPos(3, 4);
		intList.setValueOnPos(4, 0);
		
		intList3.setValueOnPos(0, 5);
		intList3.setValueOnPos(2, 7);
		intList3.setValueOnPos(3, 4);
		intList3.setValueOnPos(4, 0);
		
		System.out.println("All values of Array 1: " + intList.toString());
		System.out.println("Are array 1 and 3 identical: " + intList.equals(intList3));
		System.out.println("Number on position 2 in array 1 is even: " + intList.posEven(2));
		System.out.println("Number on position 4 in array 1 is even: " + intList.posEven(3));
		System.out.println("Number of positions used in array 1: " + intList.countUsed());
		System.out.println("Length of array 1: " + intList.getLength());
		System.out.println("Sum of all integer values in array 1: " + intList.sum());
		System.out.println("Product of all integer values in array 1: " + intList.product());
		System.out.println("Value of postion 0 in array 1: " + intList.getValueOfPos(0));
		System.out.println();
		System.out.println("Array 1 will be sorted");
		intList.sort();
		
		IntList intList2 = new IntList(6);
		intList2.fillRandom();
		System.out.println();
		System.out.println("All values of Array 2: " + intList2.toString());
		System.out.println("Number of positions used in array 2: " + intList2.countUsed());
		System.out.println("Are array 2 and 3 identical: " + intList2.equals(intList3));
		
		intList2.setLength(7);
		System.out.println();
		System.out.println("Length of array 2: " + intList2.getLength());
		System.out.println("All values of Array 2: " + intList2.toString());
		System.out.println("Number of positions used in array 2: " + intList2.countUsed());
		
		intList2.setLength(3);
		System.out.println();
		System.out.println("Length of array 2: " + intList2.getLength());
		System.out.println("All values of Array 2: " + intList2.toString());
		System.out.println("Number of positions used in array 2: " + intList2.countUsed());
		
		intList2.clear();
		System.out.println();
		System.out.println("All values of Array 2: " + intList2.toString());
		System.out.println("Number of positions used in array 2: " + intList2.countUsed());
		
	    
	}

}
