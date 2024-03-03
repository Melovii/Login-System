import javax.swing.*;
import java.awt.*;

public class LoggedIn extends JFrame
{
    JLabel gg = new JLabel();

    LoggedIn()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(690, 420);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(41,109,156,255));
        this.setResizable(false);

        gg.setText("You logged in successfully, GG!");
        gg.setFont(new Font("Calibri", Font.BOLD, 31));
        gg.setForeground(Color.WHITE);
        gg.setHorizontalAlignment(SwingConstants.CENTER);
        gg.setVerticalAlignment(SwingConstants.CENTER);

        this.add(gg, BorderLayout.CENTER);
        this.setVisible(true);
    }

}
