package de.telekom.sea7;

public class DepotMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Depot depot = new Depot();
		Integer integer = 1;
		Integer integer2 = 2;
		Integer integer3 = 3;
		Integer integer4 = 4;
		Integer integer5 = 5;
		Integer integer6 = 6;
		Integer integer7 = 7;
		Integer integer8 = 8;
		Integer integer9 = 9;
		
		depot.add(integer);
		depot.add(integer2);
		//depot.add(integer3);
		depot.add(integer4);
		depot.add(integer5);
		depot.add(integer6);
		//depot.add(integer7);
		depot.add(integer8);
		//depot.add(integer9);
		
		for (int i = 0; i < depot.getCapacity(); i++) {
			System.out.println(depot.get(i));
		}
		
		System.out.println(depot.isFull());
		System.out.println(depot.size());
		System.out.println();
		System.out.println(depot.contains(integer8));
		System.out.println(depot.contains(integer9));
		System.out.println();
		System.out.println(depot.indexOf(integer8));
		System.out.println();
		
		System.out.println(depot.isEmpty());
	}

}
