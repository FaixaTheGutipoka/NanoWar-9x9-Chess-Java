package Main_Chess_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        player_info_and_game_window();
    }

    public static void player_info_and_game_window(){
        // Create a JFrame for player 1 input
        JFrame input_frame_1 = new JFrame("Player 1 Information");
        input_frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input_frame_1.setLayout(new GridLayout(6, 2));

        // Create input fields and labels for Player 1
        JLabel handle_name_label_1 = new JLabel("Player 1 Handle Name:");
        JTextField handle_name_field_1 = new JTextField(20);
        JLabel name_label_1 = new JLabel("Player 1 Name:");
        JTextField name_field_1 = new JTextField(20);
        JLabel age_label_1 = new JLabel("Player 1 Age:");
        JTextField age_field_1 = new JTextField(20);
        JLabel email_label_1 = new JLabel("Player 1 Email:");
        JTextField email_field_1 = new JTextField(20);

        JButton submit_button_1 = new JButton("Submit");

        input_frame_1.add(handle_name_label_1);
        input_frame_1.add(handle_name_field_1);
        input_frame_1.add(name_label_1);
        input_frame_1.add(name_field_1);
        input_frame_1.add(age_label_1);
        input_frame_1.add(age_field_1);
        input_frame_1.add(email_label_1);
        input_frame_1.add(email_field_1);
        input_frame_1.add(new JLabel("")); // Empty label for spacing
        input_frame_1.add(submit_button_1);

        // Create a JFrame for player 2 input
        JFrame input_frame_2 = new JFrame("Player 2 Information");
        input_frame_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input_frame_2.setLayout(new GridLayout(6, 2));

        // Create input fields and labels for Player 2
        JLabel handle_name_label_2 = new JLabel("Player 2 Handle Name:");
        JTextField handle_name_field_2 = new JTextField(20);
        JLabel name_label_2 = new JLabel("Player 2 Name:");
        JTextField name_field_2 = new JTextField(20);
        JLabel age_label_2 = new JLabel("Player 2 Age:");
        JTextField age_field_2 = new JTextField(20);
        JLabel email_label_2 = new JLabel("Player 2 Email:");
        JTextField email_field_2 = new JTextField(20);

        JButton submit_button_2 = new JButton("Submit");

        input_frame_2.add(handle_name_label_2);
        input_frame_2.add(handle_name_field_2);
        input_frame_2.add(name_label_2);
        input_frame_2.add(name_field_2);
        input_frame_2.add(age_label_2);
        input_frame_2.add(age_field_2);
        input_frame_2.add(email_label_2);
        input_frame_2.add(email_field_2);
        input_frame_2.add(new JLabel("")); // Empty label for spacing
        input_frame_2.add(submit_button_2);

        // Create a listener for the submit button of Player 1
        submit_button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String handle_name_1 = handle_name_field_1.getText();
                String name_1 = name_field_1.getText();
                int age_1 = Integer.parseInt(age_field_1.getText());
                String email_1 = email_field_1.getText();

                String path = "C:\\Users\\User\\IdeaProjects\\Final Lab Project- 9x9 Chess (two queens)\\src\\Main_Chess_Game\\Players_info";
                // Store player 1 information in "Players_Info.txt" file
                try (FileWriter writer = new FileWriter(path, true)) {
                    String playerInfoString = handle_name_1 + "\t" + name_1 + "\t" + age_1 + "\t" + email_1;
                    writer.write(playerInfoString + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                // Close the input frame for Player 1
                input_frame_1.dispose();

                // Show the input frame for Player 2
                input_frame_2.pack();
                input_frame_2.setVisible(true);
            }
        });

        // Create a listener for the submit button of Player 2
        submit_button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String handle_name_2 = handle_name_field_2.getText();
                String name_2 = name_field_2.getText();
                int age_2 = Integer.parseInt(age_field_2.getText());
                String email_2 = email_field_2.getText();

                //Please, set the path in your pc accordingly, otherwise the infos can't be found
                String path = "C:\\Users\\User\\IdeaProjects\\Final Lab Project- 9x9 Chess (two queens)\\src\\Main_Chess_Game\\Players_info";
                // Store player 2 information in "Players_Info.txt" file
                try (FileWriter writer = new FileWriter(path, true)) {
                    String playerInfoString = handle_name_2 + "\t" + name_2 + "\t" + age_2 + "\t" + email_2;
                    writer.write(playerInfoString + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                input_frame_2.dispose();

                // Close the input frame for Player 2

                // Create the chess game window
                JFrame main_window = new JFrame();

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
        });

        // Set the size, visibility, and center the input frame for Player 1
        input_frame_1.pack();
        input_frame_1.setVisible(true);
        input_frame_1.setLocationRelativeTo(null);
    }
}
