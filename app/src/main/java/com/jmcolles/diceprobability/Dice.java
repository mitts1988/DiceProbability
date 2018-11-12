package com.jmcolles.diceprobability;

public class Dice {
	private int sides, currentPip;

	Dice() {
		this.setCurrentPip(1);
		this.setSides(4);
	}

	Dice(int sides) {
		this.setCurrentPip(1);
		this.setSides(sides);
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public int getCurrentPip() {
		return currentPip;
	}

	public void setCurrentPip(int currentPip) {
		this.currentPip = currentPip;
	}

	public void incrementPip() {
		this.currentPip++;
		if (this.currentPip > this.sides) {
			this.currentPip = 1;
		}
	}
}
