package Main_Chess_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Windows();

    }

    public static void Windows(){
        ImageIcon icon = new ImageIcon("C:\\Users\\User\\OneDrive\\Pictures\\NanoWar Icon.png");

        JFrame logo_window = new JFrame();

        logo_window.setIconImage(icon.getImage());
        logo_window.setTitle("NanoWar");
        logo_window.getContentPane().setBackground(new Color(1, 31, 52));
        logo_window.setMinimumSize(new Dimension(700, 700));
        logo_window.setLocationRelativeTo(null);

        ImageIcon image_icon = new ImageIcon("C:\\Users\\User\\OneDrive\\Pictures\\NanoWar Wallpaper.png");
        JLabel image_label = new JLabel(image_icon);
        logo_window.getContentPane().add(image_label, BorderLayout.CENTER);

        logo_window.setVisible(true);

        /*
        JFrame main_window = new JFrame();

        main_window.setIconImage(icon.getImage());
        main_window.setTitle("NanoWar");

        // Set the background color (behind the chess board)
        main_window.getContentPane().setBackground(new Color(45, 45, 45));
        main_window.setLayout(new GridBagLayout());
        main_window.setMinimumSize(new Dimension(700, 700));
        main_window.setLocationRelativeTo(null);

        Chess_Board chess_board = new Chess_Board();

        // Add the chess board layout in the main_window_frame
        main_window.add(chess_board);

        main_window.setVisible(true);
         */
    }
}
