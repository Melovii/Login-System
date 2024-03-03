import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame
{
    JTextField usernameIN;
    JTextField passwordIN;
    JLabel usernameL;
    JLabel passwordL;
    JLabel conditionL;
    JLabel conditionL2;
    JButton loginB;
    JButton resetB;
    JPanel conditionP;

    Login()
    {
        // ---------------- WINDOW ----------------
        this.setSize(690, 420);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Account login");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(25,27,28,255));

        // ---------------- LABELS ----------------
        usernameL = new JLabel();
        passwordL = new JLabel();
        usernameL.setText("Username");
        passwordL.setText("Password");
        usernameL.setBounds(231, 70, 220, 35);
        passwordL.setBounds(231, 170, 220, 35);
        usernameL.setForeground(Color.WHITE);
        passwordL.setForeground(Color.WHITE);
        this.add(usernameL);
        this.add(passwordL);


        conditionL = new JLabel();
        conditionP = new JPanel(new BorderLayout());
        conditionL.setForeground(Color.RED);
        conditionL.setFont(new Font("Calibri", Font.BOLD, 21));
        conditionL.setHorizontalAlignment(SwingConstants.CENTER);
        conditionP.setBackground(new Color(25,27,28,255));
        conditionP.setBounds(162, 248, 345, 35);
        conditionP.add(conditionL, BorderLayout.CENTER);
        this.add(conditionP);
        // ---------------- LABELS ----------------

        // ---------------- TEXTFIELD ----------------
        usernameIN = new JTextField();
        passwordIN = new JTextField();
        usernameIN.setBorder(new LineBorder(new Color(37, 150, 190), 3));
        passwordIN.setBorder(new LineBorder(new Color(37, 150, 190), 3));
        usernameIN.setBounds(225, 100, 220, 35);
        passwordIN.setBounds(225, 200, 220, 35);
        this.add(usernameIN);
        this.add(passwordIN);
        // ---------------- TEXTFIELD ----------------

        // ---------------- BUTTON ----------------
        loginB = new JButton("Login");
        resetB = new JButton("Reset");
        loginB.setBackground(Color.WHITE); //Foreground = text
        resetB.setBackground(Color.WHITE);
        loginB.setFocusable(false);
        resetB.setFocusable(false);
        loginB.setBounds(225, 300, 100, 40);
        resetB.setBounds(345, 300, 100, 40);

        loginB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameIN.getText();
                String password = passwordIN.getText();
                String key = Main.data.getKey(username);

// note: x.containsKey("username") if false then there's no key and you must ask for password!
// note: x.containsValue(password) if false then there's no value and you must ask for username!
                if (Main.data.userData.containsKey(username))
                {
                    if (key.equals(password))
                    {
                        dispose();
                        new LoggedIn();
                    }
                    else
                    {
                        conditionL.setText("Password does not match!");
                    }
                }
                else if (!Main.data.userData.containsKey(username))
                {
                    conditionL.setText("Username not found!");
                }
            }
        });

        resetB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameIN.setText("");
                passwordIN.setText("");
            }
        });

        // TEST -------------------------------------------
        JButton displayB = new JButton("Display HashMap");
        displayB.setBounds(0, 0, 125, 25);
        displayB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.data.display();
            }
        });

        this.add(displayB);
        // TEST -------------------------------------------

        this.add(loginB);
        this.add(resetB);
        // ---------------- BUTTON ----------------

        this.setVisible(true);
    }
}
