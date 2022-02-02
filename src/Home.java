import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private JPanel mainPanel;
    private JButton button1;
    private JTextField textField1;

    public Home(String title) {
        super(title);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                if (input.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a number");
                } else {
                    int num = Integer.parseInt(input);
                    if (num < 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a positive number");
                    } else {
                        int sum = 0;
                        for (int i = 1; i <= num; i++) {
                            sum += i;
                        }
                        JOptionPane.showMessageDialog(null, "The sum of the numbers from 1 to " + num + " is " + sum);
                    }
                }
            }
        });
    }
}
