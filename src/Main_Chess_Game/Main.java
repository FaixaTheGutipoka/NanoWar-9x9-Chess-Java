package Main_Chess_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Windows();
    }

    public static void Windows(){
        ImageIcon icon = new ImageIcon("C:\\Users\\User\\OneDrive\\Pictures\\NanoWar Icon.png");

        JFrame logo_window = new JFrame();

        logo_window.setIconImage(icon.getImage());
        logo_window.setTitle("NanoWar: 9x9 Chess");
        logo_window.getContentPane().setBackground(new Color(1, 31, 52));
        logo_window.setMinimumSize(new Dimension(700, 550));
        logo_window.setLocationRelativeTo(null);

        ImageIcon image_icon = new ImageIcon("C:\\Users\\User\\OneDrive\\Pictures\\NanoWar Wallpaper.png");
        JLabel image_label = new JLabel(image_icon);
        logo_window.getContentPane().add(image_label, BorderLayout.CENTER);

        JButton b=new JButton("Start Game");
        b.setFont(new Font("Verdana", Font.BOLD, 18));
        b.setPreferredSize(new Dimension(150, 50));

        // Set the layout manager to FlowLayout
        logo_window.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logo_window.dispose();
                JFrame loading_screen = createLoadingScreen(icon);
                loading_screen.setVisible(true);

                SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        // Simulate a 3-second loading time
                        for (int i = 0; i <= 100; i += 10) {
                            Thread.sleep(300);
                            publish(i);
                        }
                        return null;
                    }

                    @Override
                    protected void process(java.util.List<Integer> chunks) {
                        int progress = chunks.get(chunks.size() - 1);
                        loading_screen.setTitle("Loading... " + progress + "%");
                    }

                    @Override
                    protected void done() {
                        // Close loading screen
                        loading_screen.dispose();
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
                    }
                };

                worker.execute();
            }
        });
        logo_window.getContentPane().add(b, BorderLayout.CENTER);

        logo_window.setVisible(true);
    }
    private static JFrame createLoadingScreen(ImageIcon icon) {
        JFrame loadingScreen = new JFrame();
        loadingScreen.setIconImage(icon.getImage());
        loadingScreen.setTitle("Loading...");
        loadingScreen.setSize(300, 100);
        loadingScreen.setLocationRelativeTo(null);
        loadingScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(false); // Use a determinate progress bar
        progressBar.setStringPainted(true);
        panel.add(progressBar, BorderLayout.CENTER);

        loadingScreen.add(panel);
        return loadingScreen;
    }
}
