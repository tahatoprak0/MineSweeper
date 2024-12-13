import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int row;
    int column;
    int size;
    int board[][];
    int map[][];
    boolean isGameActivate = true;
    boolean isMine = false;
    int succes;
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    public MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
        this.board = new int[row][column];
        this.map = new int[row][column];
        this.size = row * column;
        this.succes = 0;


    }

    public void run() {
        createMap();
        //printMap(map);
        System.out.println("===========================");

        while (isGameActivate) {
            int row, column;
            printBoard(board);
            System.out.print("Satır Girin: ");
            row = input.nextInt();
            System.out.print("Sütun Girin: ");
            column = input.nextInt();
            if (row < this.row && column < this.column) {
                if (map[row][column] == -1) {
                    printMap(map);
                    System.out.println("Game Over !");
                    isGameActivate = false;
                }
                if (map[row][column] != -1) {
                    check(row, column);
                    succes++;
                    if (succes == (size - (size) / 4)) {
                        System.out.println("Başardınız! Hiçbir mayına basmadınız");
                        break;
                    }
                }
            } else System.out.println("Yanlış İndex Değerleri Girdiniz. Tekrar Deneyin");


        }

    }

    public void check(int row, int column) {
        boolean isMine = false;
        if (map[row][column] == 0) {
            if ((column < this.column - 1) && map[row][column + 1] == -1) {
                board[row][column]++;
                isMine = true;
            }
            if ((column > 0) && map[row][column - 1] == -1) {
                board[row][column]++;
                isMine = true;
            }
            if ((row > 0) && map[row - 1][column] == -1) {
                board[row][column]++;
                isMine = true;
            }
            if ((row < this.row - 1) && map[row + 1][column] == -1) {
                board[row][column]++;
                isMine = true;
            }
            if ((row > 0 && column > 0) && map[row - 1][column - 1] == -1) {
                board[row][column]++;
                isMine = true;
            }
            if (((row < this.row - 1) && (column < this.column - 1)) && map[row + 1][column + 1] == -1) {
                board[row][column]++;
                isMine = true;
            }
            if (((row > 0) && (column < this.column - 1)) && map[row - 1][column + 1] == -1) {
                board[row][column]++;
                isMine = true;
            }
            if (((row < this.row - 1) && (column > 0)) && map[row + 1][column - 1] == -1) {
                board[row][column]++;
                isMine = true;
            }


        }


    }

    public void createMap() {
        int randomCoulmn, randomRow, count = 1;
        while (count <= (size / 4)) {
            randomRow = random.nextInt(row);
            randomCoulmn = random.nextInt(column);
            if (map[randomRow][randomCoulmn] != -1) {
                map[randomRow][randomCoulmn] = -1;
                count++;
            }
        }

    }

    public void printMap(int map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == -1) {
                    System.out.print("*  ");
                } else System.out.print("-  ");

            }
            System.out.println();
        }
    }

    public void printBoard(int board[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (board[i][j] == 0) {
                    System.out.print("-  ");

                } else System.out.print(board[i][j] + "  ");

            }
            System.out.println();
        }

    }


}

