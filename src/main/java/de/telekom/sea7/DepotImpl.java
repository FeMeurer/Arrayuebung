package de.telekom.sea7;

import java.util.Iterator;

public class DepotImpl implements Depot, Iterable {
	
	private Object[] depotArray = new Object[9];
	
	public DepotImpl() {}
	
	
	// Fügt eine Objektinstanz an die nächste freie Stelle des Arrays
	@Override
	public void add(Object object) throws ArrayFullException {
		for (int i = 0; i < depotArray.length; i++) {
			if (depotArray[i] == null) {
				depotArray[i] = object;
				return;
			}
		}
		throw new ArrayFullException("Das Array ist voll.");
	}
	
	// Setzt alle Stellen des Arrays auf null
	@Override
	public void clear() {
		for (int i = 0; i < depotArray.length; i++) {
			depotArray[i] = null;
		}
	}
	
	// Gibt das Objekt von der angegebenen Stelle (index) zurück
	@Override
	public Object get(int index) {
		if ((index < 0) || (depotArray.length <= index)) {
			throw new IndexOutOfRangeException("");
		} else {
			return depotArray[index];
		}
	}
	
	// Prüft, ob das Array voll belegt ist
	@Override
	public boolean isFull() {
		for (int i = 0; i < depotArray.length; i++) {
			if (depotArray[i] == null) {
				return false;
			}
		}
		return true;
	}
	
	// Gibt die Gesamtlänge des Arrays zurück
	@Override
	public int getCapacity() {
		return depotArray.length;
	}
	
	// Gibt die Anzahl der belegten Stellen des Arrays zurück
	@Override
	public int size() {
		int counter = 0;
		for (int i = 0; i < depotArray.length; i++) {
			if (depotArray[i] != null) {
				counter++;
			}
		}
		return counter;
	}
	
	// Prüft, ob das Array leer ist. Keine Stelle ist belegt.
	@Override
	public boolean isEmpty() {
		for (int i = 0; i < depotArray.length; i++) {
			if (depotArray[i] != null) {
				return false;
			}
		}
		return true;
	}
	
	// Prüft, ob die Objektinstanz gleich einer anderen Objektinstanz ist. 
	// Nutzt die equals-Methoden der jeweiligen Objektinstanz nicht die von Depot!
	@Override
	public boolean contains(Object object) {
		for (int i = 0; i < depotArray.length; i++) {
			if (depotArray[i].equals(object)) {
				return true;
			}
		}
		return false;
	}
	
	// Wie contains, gibt die Position zurück, an der sich das angegebenen Objekt im Array befindet.
	@Override
	public int indexOf(Object object) {
		for (int i = 0; i < depotArray.length; i++) {
			var element = depotArray[i];             // Zeile 78 und 79 ist die Langversion Zeile 88
			if (element.equals(object)) {
				return i;
			}
		}
		return -1;
	}
	
	// Wie contains, entfernt das Objekt aus dem Array, wenn dies gleich dem angegebenen Objekt ist.
	@Override
	public boolean remove(Object object) {
		for (int i = 0; i < depotArray.length; i++) {
			if (depotArray[i].equals(object)) {
				depotArray[i] = null;
				return true;
			}
		}
		return false;
	}
	
	// Entfernt das Objekt von der angegebenen Arrayposition
	@Override
	public boolean remove(int index) {
		if ((index < 0) | (depotArray.length <= index)) {
			System.out.println("Out of bounce " + index);
			return false;
		} else {
			depotArray[index] = null;
			return true;
		}
	}
	
	// Entfernt das Objekt von der letzten genutzten Arrayposition
	@Override
	public boolean remove() {
		for (int i = (depotArray.length - 1); i >= 0; i--) {
			if (depotArray[i] != null) {
				depotArray[i] = null;
				return true;
			}
		}
		return false;
	}
	
	// Vergleich zwei Objekte miteinander
	// Ist das angegebene Objekt kein "Depot", wird false ausgegeben
	// Ist das angegebene Objekt ein "Depot", wird die Länge des enthaltenen Arrays verglichen.
	@Override
	public boolean equals(Object object) {
		if (object instanceof DepotImpl) {
			DepotImpl depot = (DepotImpl)object;
			if (depotArray.length == depot.depotArray.length) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			System.out.println("This object is not a Depot. You can't compare it with another Depot.");
			return false;
		}
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new DepotIterator(this);
	}
}
