import javax.swing.*;

public class SecondForm extends JFrame{
    private JButton btExpand;
    private JPanel secondPanel;
    private JTextField textFio;
    private String lastName;
    private String firstName;
    private String patronymic;

    private String newLastName;
    private String newFirstName;
    private String newPatronymic = "";
    private JFrame frame = new JFrame();
    private JFrame frame2;

    public SecondForm(JFrame secondFrame, String lastName, String firstName, String patronymic) {
        frame2 = secondFrame;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;

        textFio.setText(lastName + " " + firstName + " " + patronymic);

        btExpand.addActionListener(s -> {

            String newFio = textFio.getText();
            String[] text = newFio.split("\\s+");

            if (text.length == 2 || text.length == 3) {
                newLastName = text[0];
                newFirstName = text[1];
                if (text.length == 3) {
                    newPatronymic = text[2];
                }
                MainForm mainForm = new MainForm(frame, newLastName,
                        newFirstName, newPatronymic);
                frame.setSize(600, 400);
                frame.add(mainForm.getMainPanel());
                frame.setTitle("Collapse");

                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame2.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(
                        secondPanel,
                        "Заполните Ф.И.О",
                        "Ошибка!",
                        JOptionPane.PLAIN_MESSAGE
                );
            }
        });
    }

    public JPanel getSecondPanel() {
        return secondPanel;
    }
}