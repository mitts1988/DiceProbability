package com.jmcolles.diceprobability;

public class DiceProbability {
	private static final int[] DICE = { 4, 6, 8, 10, 12, 20 };
	public int[] result;
	private Dice[] dice;
	public int totalPossibilities, min, max, modifiedCheck, total;
	public double percentage;

	public DiceProbability() {
		int plus = 2, minus = 0, check = 20;
		this.modifiedCheck = check - plus + minus;

		int[] diceUsed = { 0, 2, 0, 0, 1, 0 };
		this.totalPossibilities = possibilities(diceUsed);
		this.max = maximum(diceUsed);
		this.min = minimum(diceUsed);
		this.result = new int[this.max - this.min + 1];
		this.dice = new Dice[this.min];
		setupDice(diceUsed);

		// runs the calculate method on the first di
//		calculate(0);
//		displayAllResults();
//		checkResults();
	}

	public DiceProbability(int[] diceUsed, int modifier, int check){
		this.modifiedCheck = check - modifier;
		this.totalPossibilities = possibilities(diceUsed);
		this.max = maximum(diceUsed);
		this.min = minimum(diceUsed);
		this.result = new int[this.max - this.min + 1];
		this.dice = new Dice[min];
		setupDice(diceUsed);
	}

	private void setupDice(int[] diceUsed) {
		int pos = 0;
		for (int di = 0; di < diceUsed.length; di++) {
			for (int i = 0; i < diceUsed[di]; i++) {
				dice[pos] = (new Dice(DICE[di]));
				pos++;
			}
		}
	}

	public void checkResults() {
		this.total = 0;
		for (int i = this.modifiedCheck - this.min; i < this.result.length; i++) {
			this.total += result[i];
		}
		this.percentage = Math.round((double) this.total
				/ (double) this.totalPossibilities * 100000);
		this.percentage = this.percentage / 1000;
//		System.out.println("There are " + total + " combinations out of "
//				+ totalPossibilities + " that beat " + modifiedCheck);
//		System.out.println("You have a " + percentage + "% of beating "
//				+ modifiedCheck);
	}

	public void displayAllResults() {
		for (int i = 0; i < result.length; i++) {
			double percentage = Math.round((double) result[i]
					/ (double) totalPossibilities * 100000);
			percentage = percentage / 1000;
//			System.out.println(i + min + " has a " + percentage
//					+ "% of being rolled");
		}
	}

	public void calculate(int di) {
		if (di >= this.dice.length) {
			return;
		}
		for (int i = 0; i < this.dice[di].getSides(); i++) {
			calculate(di + 1);
			if (di == this.dice.length - 1) {
				this.result[pipCount() - this.min]++;
			}
			this.dice[di].incrementPip();
		}
	}

	private int pipCount() {
		int currentSum = 0;
		for (int j = 0; j < this.dice.length; j++) {
			currentSum += this.dice[j].getCurrentPip();
		}
		return currentSum;
	}

	private int possibilities(int[] diceUsed) {
		int totalPossibilities = 1;
		for (int di = 0; di < diceUsed.length; di++) {
			for (int rolls = diceUsed[di]; rolls > 0; rolls--) {
				totalPossibilities = totalPossibilities * DICE[di];
			}
		}
		return totalPossibilities;
	}

	private int minimum(int[] diceUsed) {
		int min = (diceUsed[0] + diceUsed[1] + diceUsed[2] + diceUsed[3]
				+ diceUsed[4] + diceUsed[5]);
		return min;
	}

	private int maximum(int[] diceUsed) {
		int max = (diceUsed[0] * DICE[0] + diceUsed[1] * DICE[1] + diceUsed[2]
				* DICE[2] + diceUsed[3] * DICE[3] + diceUsed[4] * DICE[4] + diceUsed[5]
				* DICE[5]);
		return max;
	}
}