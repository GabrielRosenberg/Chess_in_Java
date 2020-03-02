package project.chessPieces;

public class Knight extends ChessPiece {

    public Knight(int y, int x, char color) {
        super(y, x, color);
    }

    @Override
    public boolean checkMove(int newY, int newX, ChessPiece[][] board) {
        int[] distX = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] distY = { 1, 2, 2, 1, -1, -2, -2, -1 };

        for (int i = 0; i < 8; i++) {
            if(newX == x + distX[i] && newY == y + distY[i]) {
                if (board[newY][newX] == null) {
                    return true;
                }
                else if (board[newY][newX].white != this.white) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return (white ? "knight_w.png" : "knight_b.png");
    }
}
