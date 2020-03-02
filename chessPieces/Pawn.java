package project.chessPieces;

public class Pawn extends ChessPiece {
    private boolean hasMoved = false;

    public Pawn(int y, int x, char color) {
        super(y, x, color);
    }

    @Override
    public boolean checkMove(int newY, int newX, ChessPiece[][] board) {

        if (newY - y == (white ? -1 : 1))     // Om y är ett steg framför
            if (board[newY][newX] == null) {    // Om rutan man vill gå till är tom
                return newX == x;               // Returnera True om rutan är precis framför
            }
        else                                                // Om rutan inte är precis framför
            if (board[newY][newX].white != this.white)      // Om vi trycker på motståndarens pjäs
                return newX == x + 1 || newX == x - 1;      // True om

        if (!hasMoved) {
            if (newY - y == (white ? -2 : 2)) {
                if (board[newY][newX] == null && newX == x) {
                    hasMoved = true;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return (white ? "pawn_w.png" : "pawn_b.png");
    }
}
