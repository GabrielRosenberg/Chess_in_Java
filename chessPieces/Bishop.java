package project.chessPieces;

public class Bishop extends ChessPiece {

    public Bishop(int y, int x, char color) {
        super(y, x, color);
    }

    @Override
    public boolean checkMove(int newY, int newX, ChessPiece[][] board) {
        int diffY = newY - y;
        int diffX = newX - x;

        if (Math.abs(diffY) == Math.abs(diffX)) {
            diffX = diffX > 0 ? --diffX : ++diffX;
            diffY = diffY > 0 ? --diffY : ++diffY;

            while (diffX != 0 || diffY != 0) {

                if (board[y+diffY][x+diffX] != null) {
                    return false;
                }

                diffX = diffX > 0 ? --diffX : ++diffX;
                diffY = diffY > 0 ? --diffY : ++diffY;
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
        return (white ? "bishop_w.png" : "bishop_b.png");
    }

}
