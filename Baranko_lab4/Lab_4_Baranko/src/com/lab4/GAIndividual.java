package com.lab4;

import java.util.Random;

public class GAIndividual {
	private static Random randg = new Random(); // 
	public int genome_size;
	public float[] genome;
	public float fitness;

	public GAIndividual(int gsize, float[] min_range, float[] max_range) {
		// створити випадкового індивідума довжиною gsize
		// і-й ген повине бути в діапазоні між min_range[i] Ві max_range[i]
		genome_size = gsize;
		genome = new float[genome_size];
		for (int i = 0; i < genome_size; i++) {
			genome[i] = randg.nextFloat() * (max_range[i] - min_range[i])
					+ min_range[i];
		}
		///////////
		evalFitness();// оцінити придатність цього нового індивідума
	}

	public GAIndividual(float d[]) {
		// Створити індивідума, що його ген є таки же як d []
		// min_range[i] <= d[i] <= max_range[i]
		genome_size = d.length;
		genome = new float[genome_size];
		for (int i = 0; i < genome_size; i++) {
			genome[i] = d[i];
		}
		evalFitness();// оцінити придатність цієї нового індивідума
	}

	public GAIndividual mutate(float[] min_range, float[] max_range) {
		
		float rate = 1.0f / (float) genome_size;
		float[] result = new float[genome_size];
		for (int i = 0; i < genome_size; i++)
			result[i] = genome[i];
		
		for (int i = 0; i < genome_size; i++)
			if ((float) Math.random() < rate)
				result[i] = randg.nextFloat() * (max_range[i] - min_range[i])
						+ min_range[i];

		return new GAIndividual(result);
	}

	public static GAIndividual uniform(GAIndividual f, GAIndividual m) {

		float[] child = new float[f.genome_size];
		Random random = new Random();
		
		for (int k = 0; k < f.genome_size; k++) {
		String fs = floatToBinary(f.genome[k]);
		String ms = floatToBinary(m.genome[k]);

		
		int[] maska = new int[fs.length()];
		
		for(int i = 0; i < fs.length(); i++){
			maska[i] = random.nextInt(2);
		}
		
		String childs = "";

		for (int i = 0; i < fs.length(); i++) {
			if(maska[i] == 0) childs += fs.charAt(i);
			else childs += ms.charAt(i);
		}
		child[0] = binaryToFloat(childs);
		}
		return new GAIndividual(child);
	}

	public String toString() {
		String s = "[";
		s += genome[0] + "]";
		s += " fitness = " + fitness;
		return s;
	}

	private void evalFitness() {

		fitness = (20 + 3 * genome[0] - 40 * genome[0] * genome[0] + 1 * genome[0]
						* genome[0] * genome[0]);

	}

	public static String floatToBinary(float n){
		String str = ""; 
		int b;
		float n1 = n;
		 while(n1 !=0){  
			    b = (int)n1 % 2;  
			    str = b + str;  
			    n1 = (int)n1/2; 
		 }

		 while(str.length() != 8)
			 str ="0" + str;
		 
		 str += ".";
		 float drob = n - (int)n;
		 for(int i = 0; i < 25; i++){  
			 b = (int)(drob * 2);
			 str += "" + b;
			 drob = (drob * 2) - (int)(drob * 2);
		 }
		 
		return str;
	}
	
	public static float binaryToFloat(String string){
		float number = 0f;
		int npoint = string.indexOf(".");

		String string1 = string.substring(0, npoint);
				

		for(int i = string1.length()-1, step = 0; i>=0; i--,step++){
			if(string1.charAt(i) == '1') number += Math.pow(2, step);
		}
		
		String string2 = string.substring(npoint+1, string.length());
		for(int i = 0; i < string2.length()-1; i++){
			if(string2.charAt(i) == '1') number += Math.pow(2, -(i+1));
		}
				
		return number;
	}
}
