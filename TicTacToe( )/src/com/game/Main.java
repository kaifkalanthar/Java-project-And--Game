package com.game;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static ArrayList<Integer> playerPosition=new ArrayList<>();
    public static ArrayList<Integer> AIPosition =new ArrayList<>();
    public static  void PrintGameBoard(char[][] gameBoard){
        for (char[]row: gameBoard){
            for (char c:row){ System.out.print(c);
            }
            System.out.println();
        }

    }
    public static void PlacePiece(char gameBoard[][],int pos,String user){
        char symbol=' ';
        if (user.equals("player")){
            symbol='X';
            playerPosition.add(pos);
        }
        else if (user.equals("AI")){
            symbol='O';
            AIPosition.add(pos);
        }
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }

    }
    public static String CheckWinner(){
        List topRow=Arrays.asList(1,2,3);
        List midRow=Arrays.asList(4,5,6);
        List botRow=Arrays.asList(7,8,9);
        List firCol=Arrays.asList(1,4,7);
        List secCol=Arrays.asList(2,5,8);
        List thiCol=Arrays.asList(3,6,9);
        List rigDia=Arrays.asList(1,5,9);
        List lefDia=Arrays.asList(3,5,7);

        List<List> Winner =new ArrayList<>();
        Winner.add(topRow);
        Winner.add(midRow);
        Winner.add(botRow);
        Winner.add(firCol);
        Winner.add(secCol);
        Winner.add(thiCol);
        Winner.add(rigDia);
        Winner.add(lefDia);

        for (List l:Winner){
            if (playerPosition.containsAll(l)){
                return"You Win! ";
            }
            else if (AIPosition.containsAll(l)){
               return "You Lost";
            }
            else if (AIPosition.size()+playerPosition.size()==9){
               return  "Match Drawn";
            }

        }
return "";
    }
    public static void main(String[] args) {
         char gameBoard [][]=new char[][]{
                 {' ','|',' ','|',' '},{'-','+','-','+','-'},
                 {' ','|',' ','|',' '},{'-','+','-','+','-'},
                 {' ','|',' ','|',' '}
         };
        PrintGameBoard(gameBoard);

        while (true) {

             Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number 1-9");
             int pos = sc.nextInt();
             while (playerPosition.contains(pos)|| AIPosition.contains(playerPosition)){
                 System.out.println("this place is already occupied So, try other Number");
                 pos =sc.nextInt();
             }
             PlacePiece(gameBoard, pos, "player");
              String result=CheckWinner();
            if (result.length()>0) {
                System.out.println(result);
                break;
            }
             Random rand = new Random();
             int AiPos = rand.nextInt(9) + 1;
             while (playerPosition.contains(AiPos)||AIPosition.contains(AiPos)){
                 AiPos = rand.nextInt(9) + 1;
             }
             PlacePiece(gameBoard, AiPos, "AI");

             PrintGameBoard(gameBoard);
             result =CheckWinner();
             if (result.length()>0) {
                 System.out.println(result);
                 break;
             }
         }
    }
}