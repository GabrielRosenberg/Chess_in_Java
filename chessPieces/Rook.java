package project.chessPieces;

public class Rook extends ChessPiece {

    public Rook(int y, int x, char color) {
        super(y, x, color);
    }

    @Override
    public boolean checkMove(int newY, int newX, ChessPiece[][] board) {

        if (newX == x) {                            // Om x-cooridinaterna är samma
            int diff = newY - y;                    // avståndet
            diff = diff > 0 ? --diff : ++diff;      // ta bort ett stag så att vi bara kollar fram till dit vi vill flytta

            while (diff != 0) {                     // Så länge vi inte
                if (board[y+diff][x] != null) {
                    return false;
                }

                diff = diff > 0 ? --diff : ++diff;
            }
        }
        else if (newY == y) {
            int diff = newX - x;                    // avståndet
            diff = diff > 0 ? --diff : ++diff;      // ta bort ett stag så att vi bara kollar fram till dit vi vill flytta

            while (diff != 0) {                     // Så länge vi inte
                if (board[y][x+diff] != null) {
                    return false;
                }

                diff = diff > 0 ? --diff : ++diff;
            }
        }
        else {
            return false;
        }


        if (board[newY][newX] == null) {
            return true;
        }
        else if (board[newY][newX].white != this.white) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return (white ? "rook_w.png" : "rook_b.png");
    }
}
