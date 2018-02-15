package com.afl.challenge.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Application for simulating a children's game.
 * Prompts the user for the number of children playing, and the number of children who should
 * be counted before a child is eliminated. Outputs the order of eliminated players, and
 * the winning child.
 */
public class ChildrensGames {

    /**
     * Main application entry point.
     * @param args  unused.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfChildren = promptForPositiveInteger(scanner, "children (n)");        
        int numberOfChildrenToCount = promptForPositiveInteger(scanner, "children to count (k)");
        scanner.close();
        
        List<Child> childrenInGame = new ArrayList<Child>(numberOfChildren);
        for (int i = 1; i <= numberOfChildren; i++) {
            childrenInGame.add(new Child(i));
        }
        
        StandInCircleGame game = new StandInCircleGame(childrenInGame, numberOfChildrenToCount);
        List<Child> ordering = game.playGame();
        
        String winningChild = new String("Winning child: " + ordering.get(numberOfChildren - 1).getId());
        StringBuilder eliminatedChildren = new StringBuilder("Eliminated children: ");
        
        for (int i = 0; i < numberOfChildren - 1; i++) {
            eliminatedChildren.append(ordering.get(i).getId());
            if (i < numberOfChildren - 2) {
                eliminatedChildren.append(", ");
            }
        }

        System.out.println(winningChild);
        System.out.println(eliminatedChildren);
    }
    
    /**
     * Prompts for a positive integer.
     * @param scanner  the scanner used to read an integer.
     * @param toPromptFor  the description of what to prompt for.
     * @return  the positive integer.
     */
    private static int promptForPositiveInteger(Scanner scanner, String toPromptFor) {
        boolean validInput = false;
        int positiveInteger = -1;
        while(!validInput) {
            System.out.println("Please specify number of " + toPromptFor + ": ");  
            String input = scanner.nextLine();
            
            try {
                positiveInteger = Integer.valueOf(input);
                
                if (positiveInteger <= 0) {
                    throw new IllegalArgumentException("Negative number provided " + positiveInteger);
                }
                
                validInput = true;
                
            } catch (IllegalArgumentException e) {
                validInput = false;
                System.err.println("Number of " + toPromptFor + " must be positive integer (was " + input + ")");
            }
        }
        return positiveInteger;
    }

}
