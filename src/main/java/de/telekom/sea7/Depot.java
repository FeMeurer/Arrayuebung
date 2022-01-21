package de.telekom.sea7;

import java.util.Iterator;

public interface Depot extends Iterable {

	// Fügt eine Objektinstanz an die nächste freie Stelle des Arrays
	boolean add(Object object);

	// Setzt alle Stellen des Arrays auf null
	void clear();

	// Gibt das Objekt von der angegebenen Stelle (index) zurück
	Object get(int index);

	// Prüft, ob das Array voll belegt ist
	boolean isFull();

	// Gibt die Gesamtlänge des Arrays zurück
	int getCapacity();

	// Gibt die Anzahl der belegten Stellen des Arrays zurück
	int size();

	// Prüft, ob das Array leer ist. Keine Stelle ist belegt.
	boolean isEmpty();

	// Prüft, ob die Objektinstanz gleich einer anderen Objektinstanz ist. 
	// Nutzt die equals-Methoden der jeweiligen Objektinstanz nicht die von Depot!
	boolean contains(Object object);

	// Wie contains, gibt die Position zurück, an der sich das angegebenen Objekt im Array befindet.
	int indexOf(Object object);

	// Wie contains, entfernt das Objekt aus dem Array, wenn dies gleich dem angegebenen Objekt ist.
	boolean remove(Object object);

	// Entfernt das Objekt von der angegebenen Arrayposition
	boolean remove(int index);

	// Entfernt das Objekt von der letzten genutzten Arrayposition
	boolean remove();

	// Vergleich zwei Objekte miteinander
	// Ist das angegebene Objekt kein "Depot", wird false ausgegeben
	// Ist das angegebene Objekt ein "Depot", wird die Länge des enthaltenen Arrays verglichen.
	boolean equals(Object object);
	
	Iterator iterator();

}