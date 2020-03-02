package project.chessPieces;

public class King extends ChessPiece {

    public King(int y, int x, char color) {
        super(y, x, color);
    }

    @Override
    public boolean checkMove(int newY, int newX, ChessPiece[][] board) {
        if (Math.abs(newX - x) == 1 || Math.abs(newY - y) == 1) {
            if (board[newY][newX] == null) {
                return true;
            }
            else if (board[newY][newX].white != this.white) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return (white ? "king_w.png" : "king_b.png");
    }
}
