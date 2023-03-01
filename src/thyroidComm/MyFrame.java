package thyroidComm;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements MouseListener {
    private JPanel panel1, panel2;
    private JButton button1, button2;
    private JTextField textField1, textField2;

    public MyFrame() {
        super("My Frame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.addMouseListener(this);

        panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.addMouseListener(this);

        button1 = new JButton("Button 1");
        button1.addMouseListener(this);

        button2 = new JButton("Button 2");
        button2.addMouseListener(this);

        textField1 = new JTextField(20);
        textField1.addMouseListener(this);

        textField2 = new JTextField(20);
        textField2.addMouseListener(this);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(panel1, BorderLayout.NORTH);
        contentPane.add(panel2, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        JPanel textFieldPanel = new JPanel();
        textFieldPanel.add(textField1);
        textFieldPanel.add(textField2);
        contentPane.add(textFieldPanel, BorderLayout.EAST);

        setContentPane(contentPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == button1) {
            System.out.println("Button 1 clicked");
        } else if (e.getSource() == button2) {
            System.out.println("Button 2 clicked");
        } else if (e.getSource() == textField1) {
            System.out.println("Text field 1 clicked");
        } else if (e.getSource() == textField2) {
            System.out.println("Text field 2 clicked");
        } else if (e.getSource() == panel1) {
            System.out.println("Panel 1 clicked");
        } else if (e.getSource() == panel2) {
            System.out.println("Panel 2 clicked");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
