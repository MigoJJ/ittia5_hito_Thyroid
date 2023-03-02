package thyroidComm;

import java.awt.BorderLayout;
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
class MainPanel extends JPanel {

    private static final String title = "Thyroid Patient Management";
    private JFrame frame = new JFrame(title);
    private JPanel registration = new JPanel();
    private Font f;

    public MainPanel() {

    	this.setLayout(new BorderLayout());
        registration.setBorder(BorderFactory.createTitledBorder(title));
        registration.add(PanelType.ThyroidSx.panel);
        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Button Panel"));
        add(registration, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void display() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MainPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainPanel().display();
            }
        });
    }

    private class ButtonPanel extends JPanel {
    	private JTextField textField;
        public ButtonPanel() {
        	
            this.textField = new JTextField(20);
          
            f  = new Font("Lucida Console", Font.ITALIC,20);
            this.textField.setFont(f);
            
            this.add(textField);
        	
            for (final PanelType panel : PanelType.values()) {
                final JButton button = panel.button;
                this.add(button);
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        registration.removeAll();
                        registration.add(panel.create());
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                    }
                });
            }
        }
    }

    private enum PanelType {
    	ThyroidSx("Thyroid symptomes", 2),
        USER_INFO("User Information", 4),
        ENROLLMENT("Enrollment Form", 6),
    	 NEW_PANEL("New Panel", 8);
        private String name;
        private int count;
        private JButton button;
        private JPanel panel;

        private PanelType(String name, int count) {
            this.name = name;
            this.count= count;
            this.button = new JButton(name);
            this.button.setFont(new Font("Arial", Font.BOLD, 14));
            this.panel = create();
        }

        private JPanel create() {
            this.panel = new JPanel(new GridLayout(0, 1));
            this.panel.add(new JLabel(name));
            this.panel.add(new JLabel(" "));
            for (int i = 0; i < count; i++) {
                this.panel.add(new JLabel("Label " + String.valueOf(i + 1)));
                            }
            return panel;
        }
    }
}