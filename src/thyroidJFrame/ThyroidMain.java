package thyroidJFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** @see https://stackoverflow.com/questions/7059278 */
class ThyroidMain extends JPanel {

    private static final String title = "Registration Panel";
    private JFrame frame = new JFrame(title);
    private JPanel registration = new JPanel();

    public ThyroidMain() {
    	this.setLayout(new BorderLayout());
        registration.setBorder(BorderFactory.createTitledBorder(title));
        registration.add(PanelType.USER_AGREEMENT.panel);

        registration.add(ThyroidReturnList.thyroidReturnList("Patientvisitfor"));
        
        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Button Panel"));
        // registration.setPreferredSize(new Dimension(650, 350));// hardCoded sizing
        add(registration, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void display() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ThyroidMain());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ThyroidMain().display();
            }
        });
    }

    private class ButtonPanel extends JPanel {
        private JTextField textField;
        public ButtonPanel() {
            this.textField = new JTextField(20);
            Font font = new Font("SansSerif", Font.ITALIC, 16);
            this.textField.setFont(font);
            this.add(textField);
        	
            for (final PanelType panel : PanelType.values()) {
                final JButton button = panel.button;
                this.add(button);
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        registration.removeAll();
                        registration.add(panel.create());

                        registration.add(ThyroidReturnList.thyroidReturnList("Symptome"));
                        
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                    }
                });
            }
        }
    }

    private enum PanelType {
        USER_AGREEMENT("TFT", 2),
        USER_INFO("User Information", 2),
        ENROLLMENT("Enrollment Form", 2),
        USER_INFO1("User Information", 2),
        ENROLLMENT1("Enrollment Form", 2);
        private String name;
        private JButton button;
        private JPanel panel;

        private PanelType(String name, int count) {
            this.name = name;
            this.button = new JButton(name);
            this.panel = create();
        }

        private JPanel create() {
            this.panel = new JPanel(new GridLayout(0, 1));
            return panel;
        }
    }
}