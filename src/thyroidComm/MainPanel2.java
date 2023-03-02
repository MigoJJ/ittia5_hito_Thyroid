package thyroidComm;

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

/** @see https://stackoverflow.com/questions/7059278 */
class MainPanel2 extends JPanel {

    private static final String title = "Registration Panel";
    private JFrame frame = new JFrame(title);
    private JPanel registration = new JPanel();
    private Font font;

    public MainPanel2() {

        font = new Font("Verdana", Font.PLAIN, 24); 
    	
    	this.setLayout(new BorderLayout());
        registration.setBorder(BorderFactory.createTitledBorder(title));
        registration.add(PanelType.USER_AGREEMENT.panel);
        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Button Panel"));
        
//        registration.setPreferredSize(new Dimension(650, 350));// hardCoded sizing

        
        add(registration, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void display() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 1000);
        frame.add(new MainPanel2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainPanel2().display();
            }
        });
    }

    private class ButtonPanel extends JPanel {

        public ButtonPanel() {
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

        USER_AGREEMENT("User Agreement", 2),
        USER_INFO("User Information", 4),
        ENROLLMENT("Enrollment Form", 6);
        private String name;
        private int count;
        private JButton button;
        private JPanel panel;

        private PanelType(String name, int count) {
            this.name = name;
            this.count= count;
            this.button = new JButton(name);
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