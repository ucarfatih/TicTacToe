package com.fatih;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[][] gameBoard = {{"0","1","2"},
                            {"3","4","5"},
                            {"6","7","8"}};
        String[] players = {"X" , "O"};
        List<Integer> positions = new ArrayList<>();
        Arrays.stream(gameBoard).forEach(strings -> {
            Arrays.stream(strings).forEach(s -> {positions.add(Integer.valueOf(s));});
        });

        boolean gamePlaying = false;
        int player = 0;
        int counter = 0;
        int playerWins = 0;

        System.out.println("Player 1 plays with X, player 2 plays O");
        System.out.println("Game started!");
        print(gameBoard);

        while (!gamePlaying){
            player = (counter % 2 == 0) ? 1 : 2;
            System.out.println("player " + player + "  please set your position");
            Scanner input = new Scanner(System.in);
            int position = input.nextInt();
            boolean isPositionAvailable = false;

            do {
                if(checkPosition(positions, position))
                    isPositionAvailable = true;
                else {
                    System.out.println("This position " + position + "is not available, set another");
                    Scanner newInput = new Scanner(System.in);
                    position = newInput.nextInt();
                }
            }
            while(!isPositionAvailable);

            setPosition(gameBoard, position, players[player - 1]);
            Object removeObject = position;
            positions.remove(removeObject);
            counter++;

            if (counter == 9){
                System.out.println("tie!");
                break;
            }

            if (counter > 4){
               if(isWinnable(gameBoard)){
                   gamePlaying = true;
                   System.out.println("Player " + player + " won the game!");
               }
            }
        }
    }

    public static boolean checkPosition(List<Integer> positions, int position){
        return positions.contains(position);
    }

    public static void setPosition(String[][] array, int position, String playerValue){
        switch (position){
            case 0 :
                array[0][0] = playerValue;
                print(array);
                break;
            case 1 :
                array[0][1] = playerValue;
                print(array);
                break;
            case 2 :
                array[0][2] = playerValue;
                print(array);
                break;
            case 3 :
                array[1][0] = playerValue;
                print(array);
                break;
            case 4 :
                array[1][1] = playerValue;
                print(array);
                break;
            case 5 :
                array[1][2] = playerValue;
                print(array);
                break;
            case 6 :
                array[2][0] = playerValue;
                print(array);
                break;
            case 7 :
                array[2][1] = playerValue;
                print(array);
                break;
            case 8 :
                array[2][2] = playerValue;
                print(array);
                break;
        }
    }

    public static void print(String[][] array){
        System.out.println("Game Board:");
        Arrays.stream(array).forEach(strings -> System.out.println(Arrays.toString(strings)));
        System.out.println();
    }

    public static boolean isWinnable(String[][] array) {
        return array[0][0].equals(array[1][0]) && array[0][0].equals(array[2][0])
                || array[0][0].equals(array[0][1]) && array[0][0].equals(array[0][2])
                || array[0][0].equals(array[1][1]) && array[0][0].equals(array[2][2])
                || array[0][2].equals(array[1][1]) && array[0][2].equals(array[2][0])
                || array[0][2].equals(array[1][2]) && array[0][2].equals(array[2][2])
                || array[1][0].equals(array[1][1]) && array[1][0].equals(array[1][2])
                || array[2][0].equals(array[2][1]) && array[2][0].equals(array[2][2]);
    }

}
