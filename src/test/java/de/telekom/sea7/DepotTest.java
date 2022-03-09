package de.telekom.sea7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DepotTest {
	
	private Depot cut;
	private Depot depot2;
	private Iban iban;
	private Iban iban2;

	@BeforeEach
	void setup() {
		cut = new DepotImpl();
		depot2 = new DepotImpl();
		
		iban = new Iban();
		iban.setIban("DE9292929");
		iban.setBic("BANK01");
		
		iban2 = new Iban();
		iban2.setIban("DE232323");
		iban2.setBic("BANK02");
	}
	

	
	@Test 
	void add_test() throws ArrayFullException {
		cut.add(iban);
		
		var result = cut.get(0);
		
		assertSame(iban, result);
	} 
	
	@Test 
	void add_test_Full() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		assertThrows(ArrayFullException.class, () -> { cut.add(iban); });
	} 
	
	@Test
	void get_test() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban2);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.get(1);
		
		assertSame(iban2, result);
	}
	
	@Test
	void get_test_null() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban2);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.get(5);
		
		assertNull(result);
	}
	
	@Test
	void get_test_oob() throws ArrayFullException {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> { cut.get(10); });
	}
	
	@Test
	void get_test_negativeoob() throws ArrayFullException {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> { cut.get(-1); });
	}
	
	@Test 
	void size_test_4() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.size();
		
		assertEquals(4, result);
	}
	
	@Test 
	void size_test_empty() throws ArrayFullException {
		var result = cut.size();
		
		assertEquals(0, result);
	}
	
	@Test 
	void size_test_full() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.size();
		
		assertEquals(9, result);
	}
	
	@Test
	@Disabled
	void getCapacity_test() {
		var result = cut.getCapacity();
		assertEquals(9, result);
	}
	
	@Test 
	@Disabled
	void clear_test() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.clear();
		
		var result = cut.size();
		
		assertEquals(0, result);
	}
	
	@Test
	@Disabled
	void isFull_test_full() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.isFull();
		
		assertTrue(result);
	}
	
	@Test 
	@Disabled
	void isFull_test_notFull() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.isFull();
		
		assertFalse(result);
	}
	
	@Test 
	@Disabled
	void isFull_test_empty() throws ArrayFullException {
		var result = cut.isFull();
		
		assertFalse(result);
	}
	
	@Test 
	@Disabled
	void isEmpty_test_full() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.isEmpty();
		
		assertFalse(result);
	}
	
	@Test 
	@Disabled
	void isEmpty_test_notFull() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.isEmpty();
		
		assertFalse(result);
	}
	
	@Test 
	@Disabled
	void isEmpty_test_empty() throws ArrayFullException {
		var result = cut.isEmpty();
		
		assertTrue(result);
	}
	
	@Test 
	@Disabled
	void contains_test_true() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban2);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.contains(iban2);
		
		assertTrue(result);
	}
	
	@Test 
	@Disabled
	void contains_test_multipleTrue() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban2);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban2);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban2);
		
		var result = cut.contains(iban2);
		
		assertTrue(result);
	}
	
	@Test 
	@Disabled
	void contains_test_false() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.contains(iban2);
		
		assertFalse(result);
	}
	
	@Test 
	@Disabled
	void contains_test_empty() throws ArrayFullException {
		var result = cut.contains(iban2);
		
		assertFalse(result);
	}
	
	@Test
	@Disabled
	void indexOf_test_true() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban2);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.indexOf(iban2);
		
		assertEquals(5,result);
	}
	
	@Test
	@Disabled
	void indexOf_test_multipleTrue() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban2);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban2);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban2);
		
		var result = cut.indexOf(iban2);
		
		assertEquals(1, result);
	}
	
	@Test
	@Disabled
	void indexOf_test_false() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.indexOf(iban2);
		
		assertEquals(-1, result);
	}
	
	@Test
	@Disabled
	void indexOf_test_empty() {
		var result = cut.indexOf(iban2);
		
		assertEquals(-1, result);
	}
	
	@Test
	@Disabled
	void remove_test_objectExists() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban2);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		cut.remove(iban2);
		
		var result = cut.contains(iban2);
		var result2 = cut.size();
		
		assertFalse(result);
		assertEquals(6, result2);
	}
	
	@Test
	@Disabled
	void remove_test_multipleObjectsExists() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban2);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban2);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban2);
		
		cut.remove(iban2);
		
		var result = cut.contains(iban2);
		var result2 = cut.size();
		
		assertFalse(result);
		assertEquals(6, result2);
	}
	
	@Test
	void remove_test_noObjectExists() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		cut.remove(iban2);
		
		var result = cut.contains(iban2);
		var result2 = cut.size();
		
		assertFalse(result);
		assertEquals(9, result2);
	}
	
	@Test
	@Disabled
	void remove_test_empty() throws ArrayFullException {
		var result = cut.remove(iban2);
		
		assertFalse(result);
	}
	
	@Test
	@Disabled
	void remove_test_indexExists() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban2);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		cut.remove(5);
		
		var result = cut.size();
		
		assertEquals(8, result);
	}
	
	@Test
	@Disabled
	void remove_test_noIndexExists() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.remove(5);

		assertTrue(result);
	}
	
	@Test
	@Disabled
	void remove_test_emptyIndex() throws ArrayFullException {
		var result = cut.remove(5);
		
		assertTrue(result);
	}
	
	@Test
	@Disabled
	void remove_test_OOB() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.remove(10);

		assertFalse(result);
	}
	
	@Test
	@Disabled
	void iterator_test() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		int counter = 0;
		
		for (Object object : cut) {
			counter++;
		}
		
		assertEquals(9, counter);
	}
	
	@Test
	@Disabled
	void equals_test_empty() {
		var result = cut.equals(depot2);
		
		assertTrue(result);
	}
	
	@Test
	@Disabled
	void equals_test_sameLength() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		depot2.add(iban);
		depot2.add(iban);
		depot2.add(iban);
		depot2.add(iban);
		
		var result = cut.equals(depot2);
		
		assertTrue(result);
	}
	
	@Test
	@Disabled
	void equals_test_notSameLength() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		depot2.add(iban);
		depot2.add(iban);
		
		var result = cut.equals(depot2);
		
		assertFalse(result);
	}
	
	@Test
	@Disabled
	void equals_test_compareWithNonDepot() throws ArrayFullException {
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		cut.add(iban);
		
		var result = cut.equals(iban2);
		
		assertFalse(result);
	}
	
	@AfterEach 
	void teardown() {
		cut = null;
	}
}
