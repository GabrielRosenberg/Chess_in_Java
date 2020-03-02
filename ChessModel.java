package project;

import project.chessPieces.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class ChessModel implements Boardgame {

    private String currentMessage = "No message yet";
    private ChessPiece[][] board = new ChessPiece[8][8];
    private boolean white = true;
    private ChessPiece activePiece;


    public ChessModel() {
        char color = 'b';
        for (int y = 0; y < 8; y+=7) {
            board[y][0] = new Rook(y, 0, color);
            board[y][1] = new Knight(y, 1, color);
            board[y][2] = new Bishop(y, 2, color);
            board[y][3] = new Queen(y, 3, color);
            board[y][4] = new King(y, 4, color);
            board[y][5] = new Bishop(y, 5, color);
            board[y][6] = new Knight(y, 6, color);
            board[y][7] = new Rook(y, 7, color);
            for (int x = 0; x < 8; x++) {
                int pawnY = y + (color == 'b' ? 1 : -1);
                board[pawnY][x] = new Pawn(pawnY, x, color);
            }
            color = 'w';
        }
    }

    @Override
    public boolean move(int y, int x) {
        if (!(0 <= y && y < 8) || !(0 <= x && x < 8)) {
            currentMessage = "Please choose a position within the board!";
            return false;
        }

        if (board[y][x] != null) {                      // Om rutan har en pjäs
            if (board[y][x].getWhite() == white) {      // Om pjäsen är samma färg som spelaren
                activePiece = board[y][x];
                /* Här kollar vi alla tillgängliga platser om vi vill det */
                currentMessage = "Piece selected!";
                return true;
            }
            else if (activePiece == null) {             // Om vi inte har valt en pjäs att flytta
                currentMessage = "Please choose a piece of your color!";
                return false;
            }
            else {                                      // Om det är en motsatt pjäs och vi har valt en aktiv pjäs
                if (activePiece.checkMove(y, x, board)) {
                    makeMove(y, x);
                    currentMessage = "No message yet";
                    return true;
                }

            }
        }
        else if (activePiece == null) {                 // Om det är en tom ruta och vi inte valt en aktiv pjäs
            currentMessage = "Please choose a piece!";
            return false;
        }
        else {                                          // Om rutan är tom och vi har en aktiv pjäs
            if (activePiece.checkMove(y, x, board)) {
                makeMove(y, x);
                currentMessage = "No message yet";
                return true;
            }
        }
        currentMessage = "Select a correct position!";
        return false;
    }

    private void makeMove(int y, int x) {       // Utför draget.
        board[activePiece.y][activePiece.x] = null;     // Tömmer rutan som blev "dödad".
        board[y][x] = activePiece;      // Flyttar pjäsen i matrisen.
        board[y][x].x = x;      // Uppdaterar pjäsens x-kord.
        board[y][x].y = y;      // Uppdaterar pjäsens y-kord.
        activePiece = null;     // Markerar pjäsen som ej aktiv.
        white = !white;     // Ändrar till motståndarens tur.
    }

    @Override
    public Image getStatus(int i, int j) {
        try {
            if (board[i][j] != null) {
                return ImageIO.read(getClass().getResource("chessPieces\\images\\" + board[i][j].toString()));
            }
            else {
                return ImageIO.read(getClass().getResource("chessPieces\\images\\empty.png"));
            }
        }
        catch (Exception ex) {
            System.out.println(ex + "Nu blev det fel!");
            return null;
        }
    }

    @Override
    public String getMessage() {
        return currentMessage;
    }


}
