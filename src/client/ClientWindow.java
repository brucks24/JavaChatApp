package client;
import jdk.jfr.Event;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ClientWindow {
    private JFrame frame;
    private JPanel panel;
    private static JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane;
    private JButton sendButton;
    private JTextField messageField;
    private Client client;


    public static void main(String [] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    ClientWindow window = new ClientWindow();
                    window.frame.setVisible(true);
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public ClientWindow() {
        initialize();
        String name = JOptionPane.showInputDialog("Enter name");
        client = new Client(name,"localhost", 52684);
    }
    private void initialize() {
        frame = new JFrame("Chat Window");
        frame.setResizable(false);
        frame.setBounds(100, 100, 800, 472);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));


        textArea.setEditable(false);

        scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        messageField = new JTextField();
        panel.add(messageField);
        messageField.setColumns(50);
        sendButton = new JButton("Send");
        sendButton.addActionListener(e -> {

        });
        panel.add(sendButton);

        frame.setLocationRelativeTo(null);
    }
    public static void printToConsole(String message) {
        textArea.setText(textArea.getText() + message + "\n");
    }
}
