package thyroidJFrame;

import java.awt.Component;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThyroidReturnList extends ThyroidMain {
	
    private static final String ThyroidEnter = null;

	public static JPanel ThyroidReturnList () {
    	JPanel panel = new JPanel();
    	
    	
    	String[] result = ThyroidReturnList.ThyroidEnter();
    	for (int i = 0; i < ( result.length); i++) {
    		
    		String labelText = result[i];
          panel.add(new JLabel("Label " +labelText));
          panel.add(new JLabel("<html>...<br></html>"));
          
    	   	
                  }
		return panel;
    }
    
    public static String[] ThyroidEnter () {
    	
    	String[] strs = {"Label Hyperthryoridism",
//    	            "Label Hyperthryoridism1",
//    	            "Label Hyperthryoridism2",
//    	            "Label Hyperthryoridism",
//    	            "Label Hyperthryoridism1",
//    	            "Label Hyperthryoridism2",
    	            "Label Hyperthryoridism",
    	            "Label Hyperthryoridism1",
    	            "Label Hyperthryoridism2"};
    	
    	return strs;
		  
    }
    
}



