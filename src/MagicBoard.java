import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class MagicBoard {
    static Random rand = new Random();

    public MagicBoard() {
    }

    public static int[][] generateMagicBoard(int d) {
        int[][] magicBoardConfig = new int[d][d];

        for(int i = 0; i < d; ++i) {
            for(int n = 0; n < d; ++n) {
                magicBoardConfig[i][n] = rand.nextInt(d - 1) + 1;
            }
        }

        magicBoardConfig[d - 1][d - 1] = 0;
        return magicBoardConfig;
    }

    static boolean canGoRight(int square, int width, int length) {
        return square + 1 <= length - width;
    }

    static boolean canGoLeft(int square, int width, int length) {
        return square <= width;
    }

    static boolean canGoUp(int square, int height, int length) {
        return square <= height;
    }

    static boolean canGoSouth(int square, int height, int length) {
        return square + 1 <= length - height;
    }

    static boolean recursiveMagicBoard(int[][] arr, int h, int w) {
        Scanner sc = new Scanner(System.in);
        int square = arr[h][w];
        int length = arr.length;
        System.out.println("You are on square [" + h + "][" + w + "], the value of this position is " + square + ".");
        if (canGoLeft(square, w, length)) {
            System.out.println("You can move left, to do that press 1");
        }

        if (canGoRight(square, w, length)) {
            System.out.println("You can move right, to do that press 2");
        }

        if (canGoUp(square, h, length)) {
            System.out.println("You can move up, to do that press 3");
        }

        if (canGoSouth(square, h, length)) {
            System.out.println("You can move down, to do that press 4");
        }

        if (!canGoSouth(square, h, length) && !canGoRight(square, w, length) && !canGoLeft(square, w, length) && !canGoUp(square, h, length)) {
            System.out.println("No moves possible");
            return false;
        } else {
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    w -= square;
                    System.out.println("You moved left for " + square + " spaces");
                    break;
                case 2:
                    w += square;
                    System.out.println("You moved right for " + square + " spaces");
                    break;
                case 3:
                    h -= square;
                    System.out.println("You moved up for " + square + " spaces");
                    break;
                case 4:
                    h += square;
                    System.out.println("You moved down for " + square + " spaces");
            }

            System.out.println("Your new position is [" + h + "][" + w + "].");

            for(int m = 0; m < arr.length; ++m) {
                for(int z = 0; z < arr.length; ++z) {
                    System.out.print(arr[m][z] + "\t");
                }

                System.out.println();
            }

            if (w == arr.length && h == arr.length) {
                System.out.println("You have completed the magic board, congratulations !");
                return true;
            } else {
                recursiveMagicBoard(arr, h, w);
                return false;
            }
        }
    }

    static boolean iterativeMagicBoard(int[][] arr) {
        ArrayList<Integer> height = new ArrayList();
        ArrayList<Integer> width = new ArrayList();

        int i;
        for(i = 0; i < arr.length; ++i) {
            height.add(i);
        }

        for(i = 0; i < arr.length; ++i) {
            width.add(i);
        }

        Iterator<Integer> heightIterator = height.iterator();
        Iterator<Integer> widthIterator = width.iterator();
        int w = 0;
        int h = 0;

        while(heightIterator.hasNext() && widthIterator.hasNext()) {
            int square = arr[(Integer)height.get(h)][(Integer)width.get(w)];
            PrintStream var10000 = System.out;
            Object var10001 = height.get(h);
            var10000.println("You are on square [" + var10001 + "][" + width.get(w) + "], the value of this position is " + square + ".");
            if (canGoLeft(square, (Integer)width.get(w), arr.length)) {
                System.out.println("You can move left, to do that press 1");
            }

            if (canGoRight(square, w, arr.length)) {
                System.out.println("You can move right, to do that press 2");
            }

            if (canGoUp(square, h, arr.length)) {
                System.out.println("You can move up, to do that press 3");
            }

            if (canGoSouth(square, h, arr.length)) {
                System.out.println("You can move down, to do that press 4");
            }

            if (!canGoSouth(square, h, arr.length) && !canGoRight(square, w, arr.length) && !canGoLeft(square, w, arr.length) && !canGoUp(square, h, arr.length)) {
                System.out.println("No moves possible");
                return false;
            }

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    w -= square;
                    System.out.println("You moved left for " + square + " spaces");
                    break;
                case 2:
                    w += square;
                    System.out.println("You moved right for " + square + " spaces");
                    break;
                case 3:
                    h -= square;
                    System.out.println("You moved up for " + square + " spaces");
                    break;
                case 4:
                    h += square;
                    System.out.println("You moved down for " + square + " spaces");
            }

            System.out.println("Your new position is [" + h + "][" + w + "].");

            for(int m = 0; m < arr.length; ++m) {
                for(int z = 0; z < arr.length; ++z) {
                    System.out.print(arr[m][z] + "\t");
                }

                System.out.println();
            }

            if (w == arr.length && h == arr.length) {
                System.out.println("You have completed the magic board, congratulations !");
                return true;
            }
        }

        return true;
    }
}
