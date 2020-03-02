package project;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControl extends JFrame implements ActionListener {
    private ChessModel game;
    private int size;
    private Square[][] board;
    private JLabel mess = new JLabel("Welcome to The Game!", SwingConstants.CENTER);

    public ViewControl (ChessModel cm) {
        super();
        size = 8;
        game = cm;
        board = new Square[size][size];
        setSize(70 * size,70 * size + 80);
        setTitle("The Game");

        JPanel buttonPanel = new JPanel();
        JPanel textPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(size, size, 2, 2));
        buttonPanel.setSize(100 * size,100 * size);
        textPanel.setLayout(new GridLayout(1,1));
        textPanel.setSize(100 * size, 100);
        textPanel.setFont(new Font("Arial", Font.PLAIN, 80));
        textPanel.add(mess);
        textPanel.setForeground(Color.BLACK);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Color color = ((i+j) % 2 == 0) ? new Color(157, 87, 27) : new Color(230, 204, 171);
                board[i][j] = new Square(i, j, color);
                board[i][j].addActionListener(this);
                board[i][j].setIcon(new ImageIcon(game.getStatus(i, j)));
                buttonPanel.add(board[i][j]);
            }
        }

        add(buttonPanel);
        add(textPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int iPress = ((Square) ae.getSource()).i();
        int jPress = ((Square) ae.getSource()).j();

        if (game.move(iPress, jPress)) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    board[i][j].setIcon(new ImageIcon(game.getStatus(i, j)));
                }
            }
        }
        mess.setText(game.getMessage());
    }
}

class Square extends JButton {
    private int i;
    private int j;

    Square(int i, int j, Color color) {
        super();
        this.i = i;
        this.j = j;
        setSize(70, 70);
        setBackground(color);
        //setForeground(Color.white);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        setBorder(emptyBorder);
        setFont(new Font("Arial", Font.PLAIN, 30));
    }

    int i() { return i; }
    int j() { return j; }
}