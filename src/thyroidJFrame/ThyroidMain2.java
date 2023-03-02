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
public class ThyroidMain2 extends JPanel {
	    public static String title = "Thyroid managenent Panel";
	    public static JFrame frame = new JFrame(title);
	    public static JPanel registration = new JPanel();

	    public ThyroidMain2() {
	        this.setLayout(new BorderLayout());
	        registration =(ThyroidReturnList.thyroidReturnList("Patientvisitfor"));
	        registration.setBorder(BorderFactory.createTitledBorder(title));
	        registration.add(PanelType.THYROIDENTER.panel);
	        
	        ButtonPanel buttonPanel = new ButtonPanel();
	        buttonPanel.setBorder(BorderFactory.createTitledBorder("Choice and type the number !!"));
	        add(buttonPanel, BorderLayout.SOUTH);	        
	    }

	    private void display() {
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.add(new ThyroidMain2());
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {

	            @Override
	            public void run() {
	                new ThyroidMain2().display();
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
	        THYROIDENTER("Patient visit for", 2),
	        SYMPTOMES("Symptome", 4),
	        PE_THYROID("P/E thyroid", 6),
	        PREGNANSY("Pregnancy", 9),
	        TFT("TFT", 9),
	        PLANTOFU("Plan to F/U", 9);
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

	        		this.panel.add(new JLabel(" "));
					this.panel.add(new JLabel("--------" +name+"--------"));
	            return panel;
        	}
	    }

	}

