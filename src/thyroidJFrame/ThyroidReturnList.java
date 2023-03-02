package thyroidJFrame;

import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThyroidReturnList extends ThyroidMain {
	
    private static final String ThyroidEnter = null;

	public static JPanel ThyroidReturnList () {
    	JPanel panel = new JPanel();

    	panel.setLayout((LayoutManager) new BoxLayout(panel, BoxLayout.Y_AXIS));
//    	panel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
    	
    	String[] result = ThyroidReturnList.ThyroidEnter();
    	for (int i = 0; i < ( result.length); i++) {
    		String labelText = result[i];

          panel.add(new JLabel(labelText));
                  }

		return panel;
    }
    
    public static String[] ThyroidEnter () {
    	String[] strs = {"Label Hyperthryoridism",
    	            "Label Hyperthryoridism1",
    	            "Label Hyperthryoridism2",
    	            "Label Hyperthryoridism",
    	            "Label Hyperthryoridism1",
    	            "Label Hyperthryoridism2",
    	            "Label Hyperthryoridism",
    	            "Label Hyperthryoridism1",
    	            "Label Hyperthryoridism2"};
    	return strs;
    }
}



