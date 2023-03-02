package thyroidJFrame;

	import java.awt.BorderLayout;
	import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
import javax.swing.JTextField;

	/** @see https://stackoverflow.com/questions/7059278 */
public class ThyroidMain extends JPanel {
	    private static final String title = "Thyroid manangenent Panel";
	    private JFrame frame = new JFrame(title);
	    private JPanel registration = new JPanel();

	    public ThyroidMain() {
	        this.setLayout(new BorderLayout());
	        registration.setBorder(BorderFactory.createTitledBorder(title));
	        registration.add(PanelType.USER_AGREEMENT.panel);
	        add(registration,BorderLayout.CENTER);
	        
	        ButtonPanel buttonPanel = new ButtonPanel();
	        buttonPanel.setBorder(BorderFactory.createTitledBorder("Choice and type the number !!"));
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
	        ENROLLMENT("Enrollment Form", 6),
	        ENROLLMENT1("Enrollment Form1", 9);
    	
	    	 private String name;
	        private int count;
	        private JButton button;
	        private JPanel panel;

	        private PanelType(String name, int count) {
				this.name = name;
				this.count= count;
				this.button = new JButton(name);
				this.panel = create();
				
				System.out.println("this.name = name;:  " + this.name);
				System.out.println("name = name;:  " + name);
	        }

	        private JPanel create() {
	        		this.panel = new JPanel(new GridLayout(0, 1));
	        		
	        		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
	        		this.panel = ThyroidReturnList.thyroidReturnList("Thyroid Enter");
//	    	       add(this.panel,BorderLayout.CENTER);
	        		
	        		this.panel.add(new JLabel(" "));
					this.panel.add(new JLabel("--------" +name+"--------"));
	            return panel;
        	}
	    }
	}

