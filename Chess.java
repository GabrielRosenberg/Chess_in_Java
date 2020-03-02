package project;

import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {
        ChessModel chessModel = new ChessModel();
        ViewControl vc = new ViewControl(chessModel);
        Scanner scan = new Scanner(System.in);

        while (true) {
            for (int i=0; i<8; i++) {
                for (int j=0; j<8; j++)
                    System.out.print("  " + chessModel.getStatus(i,j)); // getStatus
                System.out.println();
            }
            int y = scan.nextInt();  // get an int number from terminal window
            int x = scan.nextInt();
            chessModel.move(y,x);
            System.out.println(chessModel.getMessage());
        }
    }
}
