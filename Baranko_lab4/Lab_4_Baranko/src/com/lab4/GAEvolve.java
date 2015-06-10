package com.lab4;

public class GAEvolve { 
	public float[] best_fitness; //є найкращим значенням для і-го покоління даної еволюції
	public GAIndividual best_ind; //найкращий індивідум даної еволюції
	public GAEvolve(int generations, int pop_size, int genome_size, int xrate,int mrate, float[] min_range, float[] max_range){ 
		
		best_fitness = new float[generations];  
		GAPopulation gap = new GAPopulation(pop_size,genome_size,min_range,max_range); 
		best_fitness[0] = gap.ind[gap.best_index].fitness; 

		for(int i=1; i < generations; i++){ 
			gap = gap.generate(gap,xrate,mrate,min_range,max_range); 
			best_fitness[i] = gap.ind[gap.best_index].fitness; 

			System.out.println("Найкраще значення покоління " + best_fitness[i]);
			} 
		best_ind = gap.ind[gap.best_index];
		} 
	
	public static void main(String[] args) {
			//Min
			 //float[] min = new float[]{20f}; 
			 //float[] max = new float[]{30f};
			 //Max
			 float[] min = new float[]{5f}; 
			 float[] max = new float[]{15f};
			// GAEvolve.evolveAndMakeMFile("ga.m",1,300,400,2,70,20,min,max); 
			 GAEvolve gae = new GAEvolve(1,300,1,70,20,min,max);
			 System.out.println("Результат:");
			 System.out.println(gae.best_ind);
			
			} 
		}
	

