import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Register extends JFrame
{
    JLabel usernameL;
    JLabel passwordL;
    JLabel passwordCheckL;
    JButton loggedB;
    JButton registerB;
    JTextField usernameIN;
    JTextField passwordIN;
    JTextField passwordCheck;
    JPanel conditionP;

    JLabel conditionL;

    Register()
    {
        // ---------------- WINDOW ----------------
        this.setSize(690, 420);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Registration");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(25,27,28,255));
        // ---------------- WINDOW ----------------

        // ---------------- LABELS ----------------
        usernameL = new JLabel();
        passwordL = new JLabel();
        passwordCheckL = new JLabel();
        usernameL.setText("Username");
        passwordL.setText("Password");
        passwordCheckL.setText("Confirm Password");
        usernameL.setBounds(231, 35, 220, 35);
        passwordL.setBounds(231, 115, 220, 35);
        passwordCheckL.setBounds(231, 195, 220, 35);
        usernameL.setForeground(Color.WHITE);
        passwordL.setForeground(Color.WHITE);
        passwordCheckL.setForeground(Color.WHITE);
        this.add(usernameL);
        this.add(passwordL);
        this.add(passwordCheckL);
        // ---------------- LABELS ----------------

        // ---------------- PANELS ----------------
        conditionP = new JPanel(new BorderLayout());
        conditionL = new JLabel();

        conditionL.setBounds(225, 262, 220, 35);
        conditionL.setForeground(Color.RED);
        conditionL.setFont(new Font("Calibri", Font.BOLD, 21));
        conditionL.setHorizontalAlignment(SwingConstants.CENTER);

        conditionP.setBackground(new Color(25,27,28,255));
        conditionP.add(conditionL, BorderLayout.CENTER);
        conditionP.setBounds(162, 262, 345, 35);
        this.add(conditionP);
        // ---------------- PANELS ----------------

        // ---------------- TEXTFIELD ----------------
        usernameIN = new JTextField();
        passwordIN = new JTextField();
        passwordCheck = new JTextField();
        usernameIN.setBorder(new LineBorder(new Color(37, 150, 190), 3));
        passwordIN.setBorder(new LineBorder(new Color(37, 150, 190), 3));
        passwordCheck.setBorder(new LineBorder(new Color(37, 150, 190), 3));
        usernameIN.setBounds(225, 65, 220, 35);
        passwordIN.setBounds(225, 145, 220, 35);
        passwordCheck.setBounds(225, 225, 220, 35);
        this.add(usernameIN);
        this.add(passwordIN);
        this.add(passwordCheck);
        // ---------------- TEXTFIELD ----------------

        // ---------------- BUTTON ----------------
        loggedB = new JButton("Login Page");
        registerB = new JButton("Register");

        loggedB.setBackground(Color.WHITE); //Foreground = text
        registerB.setBackground(Color.WHITE);
        loggedB.setFocusable(false);
        registerB.setFocusable(false);
        loggedB.setBounds(225, 300, 100, 40);
        registerB.setBounds(345, 300, 100, 40);

        // open Login page if clicked on already registered
        loggedB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });

        // open Login page if clicked on, to confirm
        registerB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // first check if password conditions met:
                // username must be unique.

                String username = usernameIN.getText();
                String password = passwordIN.getText();
                String password2 = passwordCheck.getText();

                if (password.equals(password2))
                {
                    if (password.length() < 8)
                    {
                        conditionL.setText("Password is too short!");
                    }
                    else
                    {
                        Main.data.save(username, password);
                        dispose();
                        new Login();
                    }
                }
                else
                {
                    conditionL.setText("Passwords do not match!");
                }
            }
        });

        this.add(registerB);
        this.add(loggedB);
        // ---------------- BUTTON ----------------

        this.setVisible(true);
    }
}
