package Main_Chess_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //JFrame logo_window = new JFrame();

        JFrame main_window = new JFrame();

        // Set the application icon
        ImageIcon icon = new ImageIcon("C:\\Users\\User\\OneDrive\\Pictures\\NanoWar Icon.png"); // Replace with the path to your icon image
        main_window.setIconImage(icon.getImage());

        // Set the background color (behind the chess board)
        main_window.getContentPane().setBackground(new Color(45, 45, 45));
        main_window.setLayout(new GridBagLayout());
        main_window.setMinimumSize(new Dimension(700, 700));
        main_window.setLocationRelativeTo(null);

        Chess_Board chess_board = new Chess_Board();

        // Add the chess board layout in the main_window_frame
        main_window.add(chess_board);

        main_window.setVisible(true);
    }
}
