package controller;

import model.GameState;

import java.util.Arrays;

public class BoardController {
    private final int[][] board;
    private final int empty_cell = -1;
    private int current_player = 0;
    private int empty_cells_count = 3 * 3;

    public BoardController() {
        board = new int[3][3];
        for (int[] ints : board) {
            Arrays.fill(ints, -1);
        }
    }


    public String getCellValue(int x, int y) {
        return (board[x][y] == 1) ? "X" : "O";
    }

    private boolean isValidMove(int x, int y) {
        if (board[x][y] != empty_cell)
            return false;
        return x >= 0 && x <= 2 && y >= 0 && y <= 2;
    }

    private int checkLines() {
        for (int i = 0; i < board.length; i++)
                if (board[i][0] != empty_cell && board[i][0]==board[i][1] && board[i][1]==board[i][2]) return i;
        return -1;
    }

    private int checkColumns() {
        for (int i = 0; i < board.length; i++)
            if (board[0][i] != empty_cell && board[0][i]==board[1][i] && board[1][i]==board[2][i]) return i;
        return -1;
    }

    private int checkDiagonals() {
        if (board[0][0] != empty_cell && board[0][0]==board[1][1] && board[1][1]==board[2][2]) return 1;
        if (board[0][2] != empty_cell && board[0][2]==board[1][1] && board[1][1]==board[2][0]) return 2;
        return -1;
    }

    public GameState getGameState() {
        GameState gameState = GameState.WINNER;
        int checkLines = checkLines();
        if (checkLines != -1) {
            gameState.winner = getCellValue(checkLines, 0);
            return gameState;
            }
         else {
            int checkColumns = checkColumns();
            if (checkColumns != -1) {
                gameState.winner = getCellValue(0, checkColumns);
                return gameState;
            } else {
                int checkDiagonals = checkDiagonals();
                if (checkDiagonals != -1) {
                    gameState.winner = getCellValue(0, (checkDiagonals == 1) ? 0 : board.length - 1);
                    return gameState;
                }
            }
        }
        if (empty_cells_count == 0)
            return GameState.TIE;
        return GameState.IN_PROGRESS;
    }

    public boolean move(int x, int y) {
        if (isValidMove(x, y)) {
            empty_cells_count--;
            board[x][y] = current_player;
            current_player = (current_player == 0) ? 1 : 0;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int x : row) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}


