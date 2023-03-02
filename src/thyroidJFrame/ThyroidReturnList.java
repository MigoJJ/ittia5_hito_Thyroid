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
    public static JPanel thyroidReturnList(String itemtitle) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        String[] result = thyroidEnter(itemtitle);
       
        for (int i = 0; i < result.length; i++) {
            panel.add(new JLabel(result[i]));
        }
        return panel;
    }

    public static String[] thyroidEnter(String item) {
        String[] strs = null;

        switch (item) {
            case "Thyroid Enter":
                strs = new String[] {
                        "1....New Patient",
                        "        " + "11....Hyperthryoridism",
                        "        " + "12....Hypothyroidism",
                        "        " + "13....Non-thyroidal illness : NTI",
                        "        " + "14....TFT abnormality in routine check",
                        "   ",
                        "2	Hyperthryoridism F/U",
                        "3	Hypothyroidism F/U",
                        "	31	Hypothyroidism F/U c/w Hashimotoo' thyroiditis",
                        "	32	Hypothyroidism F/U post PTC op[+]",
                        "   ",
                        "1	Pregnancy Patient",
                        "	11	Hyperthryoridism with pregnancy",
                        "	12	Hypothyroidism with pregnancy",
                        "	13 	NTI with pregnancy",
                        "	14 TFT abnormality in routine check with pregnancy",
                };
                break;
            case "User Information":
                strs = new String[] {
                        "Label ThyroidEnter1Hyperthryoridism",
                        "Label ThyroidEnter1Hyperthryoridism1",
                        "Label ThyroidEnter1Hyperthryoridism2",
                        "Label Hyperthryoridism",
                        "Label Hyperthryoridism1",
                        "Label Hyperthryoridism2",
                        "Label Hyperthryoridism",
                        "Label Hyperthryoridism1",
                        "Label ThyroidEnter1Hyperthryoridism1",
                        "Label ThyroidEnter1Hyperthryoridism2",
                        "Label Hyperthryoridism",
                        "Label Hyperthryoridism1",
                        "Label Hyperthryoridism2",
                        "Label Hyperthryoridism",
                        "Label ThyroidEnter1Hyperthryoridism2"
                };
                break;
        }
        return strs;
    }
}
