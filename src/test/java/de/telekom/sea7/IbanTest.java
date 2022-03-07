package de.telekom.sea7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IbanTest {

	private Iban cut;
	private Iban same;
	private Iban notSame;
	private Object object;
	private Iban empty;
	
	@BeforeEach
	void setup() {
		cut = new Iban();
		
		same = new Iban();
		same.setIban("DE83838383838383");
		
		notSame = new Iban();
		notSame.setIban("DE838383");
		
		object = new Object();
	}
	
	@Test
	void setIban_test() {
		//Arrange
		cut.setIban("DE83838383838383");
		
		//Act
		var result = cut.getIban();
		
		//Assert
		assertEquals("DE83838383838383", result);
	}
	
	@Test
	void setBic_test() {
		//Arrange
		cut.setBic("BANK01");
		
		//Act
		var result = cut.getBic();
		
		//Assert
		assertEquals("BANK01", result);
	}
	
	@Test
	void equals_test_same() {
		cut.setIban("DE83838383838383");
		
		var result = cut.equals(same);
		
		assertTrue(result);
	}
	
	@Test
	void equals_test_notSame() {
		cut.setIban("DE83838383838383");
		
		var result = cut.equals(notSame);
		
		assertFalse(result);
	}
	
	@Test
	void equals_test_notSameClass() {
		cut.setIban("DE83838383838383");
		
		var result = cut.equals(object);
		
		assertFalse(result);
	}
	
	@Test
	void equals_test_null() {
		cut.setIban("DE83838383838383");
		
		var result = cut.equals(empty);
		
		assertFalse(result);
	}
	
	@Test 
	void hashCode_test_same() {
		cut.setIban("DE83838383838383");
		
		int h1 = cut.hashCode();
		int h2 = same.hashCode();
		
		assertEquals(h1, h2);
	}
	
	@Test 
	void hashCode_test_notSame() {
		cut.setIban("DE83838383838383");
		
		int h1 = cut.hashCode();
		int h2 = notSame.hashCode();
		
		assertNotEquals(h1, h2);
	}
	
	@AfterEach
	void teardown() {
		cut = null;
	}
	
}
