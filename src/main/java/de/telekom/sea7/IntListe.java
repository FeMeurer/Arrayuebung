package de.telekom.sea7;

class IntList {

	private int[] list;
	private boolean[] posUsed;

	public IntList(int length) {
		list = new int[length];
		posUsed = new boolean[length];
	}

	public void setValueOnPos(int position, int value) {
		list[position] = value;
		posUsed[position] = true;
	}

	public int getValueOfPos(int position) {
		if ((position < 0) | (list.length <= position)) {
			System.out.println("Invalid input " + position);
			return 0;
		} else {
			return list[position];
		}
	}
	
	public void sort() {
		int counter = 0;
		System.out.println("Start: " + this.toString());
		for (int i = 0; i < (list.length - 1); i++ ) {
			for (int j = (i + 1); j < list.length ; j++) {
				if (list[i] > list[j]) {
					int temp = list[i];
					list[i] = list[j];
					list[j] = temp;
					counter++;
					System.out.println("Step " + counter + ": " + this.toString());
				}
			}
		}
	}
	
	public String toString() {
		String temp = "";
		for (int i = 0; i < list.length; i++) {
			temp = temp + Integer.toString(list[i]) + ", ";
		}
		return temp;
	}
	
	public int sum() {
		int temp = 0;
		for (int i = 0; i < list.length; i++) {
			temp = temp + list[i];
		}
		return temp;
	}
	
	public int product() {
		int temp = 1;
		for (int i = 0; i < list.length; i++) {
			temp = temp * list[i];
		}
		return temp;
	}
	
	public void clear() {
		for (int i = 0; i < list.length; i++) {
			list[i] = 0;
			posUsed[i] = false;
		}
	}
	
	public int getLength() {
		return list.length;
	}
	
	public boolean equals(IntList list2) {
		if (list.length == list2.getLength()) {
			for (int i = 0; i < list.length; i++) {
				if (list[i] != list2.getValueOfPos(i)) {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setLength(int length) {
		int[] temp = new int[length];
		boolean[] tempPosUsed = new boolean[length];
		if (list.length < temp.length) {
			for (int i = 0; i < list.length; i++) {
				temp[i] = list[i];
				tempPosUsed[i] = posUsed[i]; 
			}
		}
		else {
			if (list.length > temp.length) {
				for (int i = 0; i < temp.length; i++) {
					temp[i] = list[i];
					tempPosUsed[i] = posUsed[i]; 
				}
			}
			else {
				System.out.println(length + " is already the length of list.");
			}
		}	
		list = temp;
		posUsed = tempPosUsed;
	}
	
	public boolean posEven(int position) {
		if ((list[position] % 2) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void fillRandom() {
		for(int i = 0; i < list.length; i++) {
			list[i] = (int)(Math.random() * 100);
			posUsed[i] = true;
		}
	}
	
	public int countUsed() {
		int counter = 0;
		for (int i = 0; i < posUsed.length; i++) {
			if (posUsed[i] == true) {
				counter++;
			}
		}
		return counter;
	}
}
