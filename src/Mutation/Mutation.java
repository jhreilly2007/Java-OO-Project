/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mutation;

import Individual.Individual;
// TODO: Auto-generated Javadoc

/**
 * The Interface Mutation.
 *
 * @author Janice
 * 
 * Strategy Interface to define my Strategy Pattern action
 */
public interface Mutation {
    
    /**
     * abstract Method to mutate Individual.
     *
     * @param child1 the child 1
     * @param mutationRate the mutation rate
     * @return mutated Individual
     */
    abstract Individual mutate(Individual child1, double mutationRate);
}
