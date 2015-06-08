package com.lab5;

import java.util.Date;
import java.util.Random;

public class TSP_GA {
	private TourManager tourManager = new TourManager();
	private GA ga = new GA(tourManager);

	public TSP_GA(int x[], int y[], int populationSize) {
		// Створення і додавання міста
		for (int i = 0; i < x.length; i++) {
			tourManager.add(new City(x[i], y[i]));
		}

		// Ініціалізація популяції
		Population pop = new Population(populationSize, true, tourManager);
		System.out.println("Initial distance: " + pop.getFittest().getDistance());
		
		Date currentTimeBefore = new Date();
		long timeBefore = currentTimeBefore.getTime();
		// System.out.println("Time: " + timeBefore);
		// Розвинення населеня на 100 поколінь
		
		pop = ga.evolvePopulation(pop);
		for (int i = 0; i < 100; i++) {
			pop = ga.evolvePopulation(pop);
		}
		Date currentTimeAfter = new Date();
		long timeAfter = currentTimeAfter.getTime();
		
		// System.out.println("Time: " + timeAfter);
		long time = timeAfter - timeBefore;

		// Вивід результатів
		System.out.println("Finished");
		System.out.println("Final distance: " + pop.getFittest().getDistance());
		System.out.println("Time: " + time );
		System.out.println("Solution:");
		System.out.println(pop.getFittest());
	}

	public static void main(String[] args) {
		int citySize = 10;
		
		int[] x = {17, 2, 13, 5, 20, 3, 20, 16, 8, 16};//new int[citySize];
		int[] y =  {19, 19, 2, 11, 20, 20, 10, 2, 19, 20};//new int[citySize];
		
		Random random = new Random();
		
		System.out.println("/* ----------------------- */");
		System.out.println("City size: " + citySize);
		System.out.print("[");
		/*
		for (int i = 0; i < citySize; i++) {
			x[i] = random.nextInt(citySize);
			y[i] = random.nextInt(citySize);
			
			System.out.print(x[i] + "," + y[i] + ";");
		}
		*/

		System.out.println("]");

		System.out.println("/* ----------------------- */");
		new TSP_GA(x, y, 20);
		System.out.println("/* ----------------------- */");
		new TSP_GA(x, y, 100);
		System.out.println("/* ----------------------- */");
		new TSP_GA(x, y, 200);
		
		citySize = 20;
		
		//x = new int[citySize];
		//y = new int[citySize];
		
		int[] x1 = {4 , 1, 19, 14, 18, 8, 9, 6, 15, 13, 13, 18, 15, 8, 11, 2, 14, 17, 14, 13} ;//new int[citySize];
		int[] y1 =  {5, 14, 3, 16, 10, 15, 11, 5, 0, 4, 5, 8, 5, 5, 7, 3, 5, 3, 5, 7};//new int[citySize];
		
		System.out.println("/* ----------------------- */");
		System.out.println("City size: " + citySize);
		System.out.print("[");
		/*
		for (int i = 0; i < citySize; i++) {
			x[i] = random.nextInt(citySize);
			y[i] = random.nextInt(citySize);
			
			System.out.print(x[i] + "," + y[i] + ";");
		}
		*/
		System.out.println("]");

		System.out.println("/* ----------------------- */");
		new TSP_GA(x1, y1, 20);
		System.out.println("/* ----------------------- */");
		new TSP_GA(x1, y1, 100);
		System.out.println("/* ----------------------- */");
		new TSP_GA(x1, y1, 200);
		System.out.println("/* ----------------------- */");
		
		int[] x2 = {1, 12, 13, 4, 6, 12, 5, 20, 10, 17, 2, 13, 13, 17, 20, 19, 10, 19, 20,  8,  6, 17, 8, 2, 12, 18, 2, 13, 0, 15};
		int[] y2 = {7, 7,  11, 5, 12, 9, 5, 13, 13,  5, 6,  4,  8, 16, 17, 10,  7,  1,  8, 12, 13, 19, 8, 9, 10,  8, 4, 0, 20, 17};
		citySize = 30;
		System.out.println("/* ----------------------- */");
		System.out.println("City size: " + citySize);
		System.out.print("[");
		System.out.println("]");

		System.out.println("/* ----------------------- */");
		new TSP_GA(x2, y2, 20);
		System.out.println("/* ----------------------- */");
		new TSP_GA(x2, y2, 100);
		System.out.println("/* ----------------------- */");
		new TSP_GA(x2, y2, 200);
		System.out.println("/* ----------------------- */");
	}
}