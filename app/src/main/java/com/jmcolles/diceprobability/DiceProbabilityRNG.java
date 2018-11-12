package com.jmcolles.diceprobability;

import java.util.Random;

public class DiceProbabilityRNG {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		int plus = 2, minus = 1, check = 13;
		int modifiedCheck = check - plus + minus;

		int[] diceUsed = { 0, 0, 1, 0, 1, 0 };
		int[] dice = { 4, 6, 8, 10, 12, 20 };
		int[] result = new int[1000000];
		// loop for each di (d4, d6, d8, 10, d12, d20)
		for (int di = 0; di < diceUsed.length; di++) {
			// loop for each roll of di
			for (int diRolls = 0; diRolls < diceUsed[di]; diRolls++) {
				for (int i = 0; i < result.length; i++) {
					result[i] += rollDice(dice[di]);
				}
			}
		}
		int max = (diceUsed[0] * dice[0] + diceUsed[1] * dice[1] + diceUsed[2]
				* dice[2] + diceUsed[3] * dice[3] + diceUsed[4] * dice[4] + diceUsed[5]
				* dice[5]);
		int min = (diceUsed[0] + diceUsed[1] + diceUsed[2] + diceUsed[3]
				+ diceUsed[4] + diceUsed[5]);
		int[] resultsRange = new int[max - min + 1];
		for (int i = 0; i < result.length; i++) {
			resultsRange[(result[i] - min)]++;
		}
		double[] percentages = new double[resultsRange.length];
		double percentageOfPassing = 0.0;
		int[] range = new int[resultsRange.length];
		for (int i = 0; i < resultsRange.length; i++) {
			percentages[i] = (resultsRange[i] * 10000) / result.length;
			percentages[i] = percentages[i] / 100;
			range[i] = (i + min);
			// System.out.println(range[i] + " was rolled " + resultsRange[i]
			// + " times resulting in " + percentages[i] + "%");
			if (range[i] >= modifiedCheck) {
				percentageOfPassing += percentages[i];
			}
		}
		percentageOfPassing = Math.round(percentageOfPassing * 100);
		percentageOfPassing = percentageOfPassing / 100;

		System.out.print("You're rolling ");
		for (int i = 0; i < diceUsed.length; i++) {
			if (diceUsed[i] > 0) {
				System.out.print(diceUsed[i] + "d" + dice[i] + " ");
			}
		}
		System.out.println("+" + plus);
		System.out.println("to beat " + check + " plus " + minus);
		System.out.println("You have about a " + percentageOfPassing
				+ "% to beat " + check + " + " + minus);
	}

	private static int rollDice(int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - 1) + 1) + 1;
		return randomNum;
	}
}
