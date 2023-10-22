
package br.edu.ifnmg.passeiodocavalo;

public class PasseiodoCavalo {
    private static final int SIZE = 8; // Tamanho do tabuleiro
    private static final int[][] MOVES = { {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1} };
    private static int[][] board;
    private static int moveNumber = 1;

    public static void main(String[] args) {
        board = new int[SIZE][SIZE];
        int startRow = 0; // Linha inicial
        int startCol = 0; // Coluna inicial

        if (solveKnightTour(startRow, startCol)) {
            printBoard();
        } else {
            System.out.println("Nenhuma solução encontrada.");
        }

        System.out.println("O cavalo fez um total de " + (moveNumber - 1) + " movimentos.");
    }

    private static boolean solveKnightTour(int row, int col) {
        board[row][col] = moveNumber;

        if (moveNumber == SIZE * SIZE) {
            return true; // Todos os quadrados foram visitados
        }

        for (int i = 0; i < 8; i++) {
            int nextRow = row + MOVES[i][0];
            int nextCol = col + MOVES[i][1];

            if (isValidMove(nextRow, nextCol) && board[nextRow][nextCol] == 0) {
                moveNumber++;
                if (solveKnightTour(nextRow, nextCol)) {
                    return true;
                }
                moveNumber--;
                board[nextRow][nextCol] = 0;
            }
        }

        return false;
    }

    private static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < SIZE && col >= 0 && col < SIZE);
    }

    private static void printBoard() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.printf("%2d ", cell);
            }
            System.out.println();
        }
    }
}
