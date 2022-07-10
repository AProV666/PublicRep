import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private JPanel mainPanel;
    private JButton btCollapse;
    private JTextField textPatronymic;
    private JTextField textFirstName;
    private JTextField textLastName;
    private JFrame secondFrame = new JFrame();
    private JFrame mainFrame;


    public MainForm(JFrame jFrame) {

        mainFrame = jFrame;

        btCollapse.addActionListener(s -> {
            if (textLastName.getText().length()== 0 || textFirstName.getText().length() == 0) {
                JOptionPane.showMessageDialog(
                        mainPanel,
                        "Заполните Ф.И.О",
                        "Ошибка!",
                        JOptionPane.PLAIN_MESSAGE
                );
            } else {
                mainFrame.setVisible(false);
            SecondForm secondForm = new SecondForm(secondFrame, textLastName.getText(),
                        textFirstName.getText(), textPatronymic.getText());
                secondFrame.setSize(600, 400);
                secondFrame.add(secondForm.getSecondPanel());
                secondFrame.setTitle("Expand");
                secondFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                secondFrame.setLocationRelativeTo(null);
                secondFrame.setVisible(true);
            }
        });
    }

    public MainForm(JFrame jFrame, String newLastName, String newFirstName, String newPatronymic) {
        jFrame.setVisible(true);
        textLastName.setText(newLastName);
        textFirstName.setText(newFirstName);
        textPatronymic.setText(newPatronymic);

        btCollapse.addActionListener(s -> {
            if (textLastName.getText().length()== 0 || textFirstName.getText().length() == 0) {
                JOptionPane.showMessageDialog(
                        mainPanel,
                        "Заполните Ф.И.О",
                        "Ошибка!",
                        JOptionPane.PLAIN_MESSAGE
                );
            } else {
                mainFrame.setVisible(false);
                SecondForm secondForm = new SecondForm(secondFrame, textLastName.getText(),
                        textFirstName.getText(), textPatronymic.getText());
                secondFrame.setSize(600, 400);
                secondFrame.add(secondForm.getSecondPanel());
                secondFrame.setTitle("Expand");
                secondFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                secondFrame.setLocationRelativeTo(null);
                secondFrame.setVisible(true);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}