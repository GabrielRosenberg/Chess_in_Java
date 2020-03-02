package project.chessPieces;

public abstract class ChessPiece {
    boolean white;
    public int x;
    public int y;


    ChessPiece(int y, int x, char color) {
        this.x = x;
        this.y = y;
        if (color == 'w')
            white = true;
        else
            white = false;
    }

    public abstract boolean checkMove(int newY, int newX, ChessPiece[][] board);
    public boolean getWhite() {
        return white;
    }
    public abstract String toString();

}
