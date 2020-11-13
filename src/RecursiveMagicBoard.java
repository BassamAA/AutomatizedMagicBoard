import java.util.Scanner;

public class RecursiveMagicBoard extends MagicBoard {

    public static void main(String[] args) {

        int[][] board1 = {{4,4,4,1,1},{2,4,1,4,3},{0,2,1,3,2},{3,2,3,2,3},{3,4,2,2,1}};
        int[][] mBoard = generateMagicBoard(9);

        for(int m = 0; m < mBoard.length; ++m) {
            for(int z = 0; z < mBoard.length; ++z) {
                System.out.print(mBoard[m][z] + "\t");
            }

            System.out.println();
        }
        System.out.println("\nRecursive version of the game\n");


        recursiveMagicBoard(mBoard, 0, 0, 0,0);
    }

    static boolean recursiveMagicBoard(int[][] arr, int h, int w, int heightDirectionCount, int widthDirectionCount)  {

        int square = arr[h][w];
        int length = arr.length;
        int counter = 0;



        if (canGoRight(square, w, length) && counter != 1) {
            w += square;
            widthDirectionCount++;
            heightDirectionCount = 0;
            counter = 1;
        }

        if (canGoSouth(square, h, length) && counter != 1) {
            h += square;
            counter = 1;
            heightDirectionCount++;
            widthDirectionCount = 0;
        }

        if (canGoLeft(square, w, length ) && counter != 1) {
            w -= square;
            counter = 1;
            widthDirectionCount++;
            heightDirectionCount = 0;
        }

        if (canGoUp(square, h, length) && counter != 1) {
            h -= square;
            counter = 1;
            heightDirectionCount++;
            widthDirectionCount = 0;
        }


        if (w == arr.length -1 && h == arr.length-1) {
            System.out.println("Board configuration possible ! Game completed");
            return true;
        }

        if (counter == 0) {
            System.out.println("No moves possible, board configuration impossible");
            return false;
        }

        if (heightDirectionCount > 3 || widthDirectionCount > 3){
            System.out.println("Infinite board, we are stuck");
            return false;

        }

        else {
                System.out.println("You are on square [" + h + "][" + w + "], the value of this position is " + square + ".");
                recursiveMagicBoard(arr, h, w, heightDirectionCount,widthDirectionCount);
            }
        return false;

        }

    }

