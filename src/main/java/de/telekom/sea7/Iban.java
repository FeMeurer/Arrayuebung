package de.telekom.sea7;

import java.util.Objects;

public class Iban {

	private long id;
	private String iban;
	private String bic;

	public long getId() {
		return id;
	}

	public String getIban() {
		return iban;
	}

	public String getBic() {
		return bic;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (obj instanceof Iban) {
			if (((Iban) obj).getIban().equals(getIban())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getIban());
	}
}
