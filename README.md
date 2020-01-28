# Java-OO-Project
OOP Genetic Algorithm 

How to Run this Project:

This Project is run from the Runner Package from the Demo class
This file will run all the other files. 

Brief explanation: 

Population is created from Individuals who are in turn creating from chromosomes created from binary genes
Strings. Population class implements the Singleton Pattern as I only want one instance of population that 
all classes are working from the same instance. Population fitness is assessed in the FitnessEvaluator class.

Package Info: Population: FitnessEvaluator class
						  Population Class
						  Replacer Class --A class to replace an individual in population
			  
			  Individual: Chromosome class
			  			  Gene Class
			  			  Individual Class
			  
Strategy Pattern is implemented from the Runner GAControl class. This is the context class for the 
Strategy Pattern. The GAContol class also runs the Genetic ALgorithm, based on strategy selected at 
runtime. The GAControl class runs the algorithm when called by the Client/Demo class.
The Strategy Interfaces to define my Strategy Pattern action are as follows: 

Package : Selection:  	Selection 			<<interface>>
						 RandomSelectionA 		--implements <<Selection>> 
						 RandomSelectionB 		--implements <<Selection>> 
						 EliteSelectionA 		--implements <<Selection>> 
						 EliteSelectionB 		--implements <<Selection>> 
	
Package : Reproduction:  Reproduction		<<interface>>
						 SinglePointCrossoverA --implements <<Reproduction>> 
						 SinglePointCrossoverB --implements <<Reproduction>> 
						 UniformCrossoverA	   --implements <<Reproduction>> 
						 UniformCrossoverB	   --implements <<Reproduction>> 
	
Package : Selection: 	 Mutationn	 		<<interface>>
						 BitFlipMutation		 --implements <<Mutation>> 
						 SwapMutation		 	 --implements <<Mutation>> 

Package : Runner		GAControl	STrategy Pattern Context and runs the Genetic ALgorithm, when called
						Demo		This the Client file. Calls the GAControl Class 

Abstract Factory is implemented in the GAFactory. This is the super factory that creates other factories. 
Abstract Factory Pattern: Client/Demo Class uses the FactoryProducer Class to create an abstract factory
at Runtime. The FactoryProducer, does this using enums obtained from the FactoryType enum class. The 
Abstract Factory Object created is in turn used to generate a concrete Factory object based on passed 
params. This can be FactoryA, FactoryB or Factory C. ALl three of these factories implement the factory 
pattern. Each Factory implements the pattern by generating object of a concrete class based on given 
information passed at runtime. 

My Factory Pattern's work based on the principle that different version of the same strategy can be 
used at a given time. For example:

Factory A: creates objects from the A stream of the STrategy Pattern i.e. only uses ELiteSelectionA when
'elite' is passed and only uses RandomSelectionA when 'random' is passed. Mutation can be selected by 
passing an int value: 1 = BitFlipMutation 2=SwapMutation

Factory B: creates objects from the B stream of the STrategy Pattern i.e. only uses ELiteSelectionB when
'elite' is passed and only uses RandomSelectionB when 'random' is passed. Mutation can be selected by 
passing an int value: 1 = BitFlipMutation 2=SwapMutation

Factory AB: creates objects from a mix of both A & B stream of the Strategy Pattern 
Mutation can be selected by passing an int value: 1 = BitFlipMutation 2=SwapMutation

The over all Genetic ALgorithm works by running for 10 generations to achieve best Population,
This is the termination criteria for the algorithm. 

                /**
                 * Genetic Algorithm 
                 * 1. Takes in a Male Parent & a Female Parent based on specific selection criteria
                 * 2. Uses these parents to reproduce a new individual
                 * 3. Mutation is added based on mutation rate
                 * 4. if the new child is fitter that the least fittest in the population replace them in population
                 * 5. Termination Criteria: top after 10 generations
                 */
The OUTPUT: 
TO highlight the Factory Pattern used the output will print the Selection/Reproduction/Mutation objects used
It will then run the algorithm as detailed above and print the new improved fitness as each generation
evolves.

For best results only one factory should operate at a time, however for demonstrative purposes I have all 
three printing out.

I have also included a basic UML class diagram to help with visualising the project structure.

I have used data hiding, data abstraction throughout, separation of behavior, class hierarchy and 
appropriate packaging. My code is extensible and substitutable and adheres to the principle of 
substitutability and the open-closed principle. 

I have also implemented the Singleton Pattern, Strategy Patter, Factory Pattern and the ABstract Factory 
Pattern.
