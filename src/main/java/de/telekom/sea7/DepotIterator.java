package de.telekom.sea7;

import java.util.Iterator;

public class DepotIterator implements Iterator {
	private Depot depot;
	int i = 0;
	
	public DepotIterator(Depot depot) {
		this.depot = depot;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return i < depot.size();
	}

	@Override
	public Object next() {
		return depot.get(i++);
	}

}
