package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DictatePane extends JPanel {
	
	public JTextField wordField;
	public JButton btnYes, btnNo;
	/**
	 * Create the panel.
	 */
	public DictatePane() {
		// use BoxLayout for this panel
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(450, 300);
		// create a horizontal box for text field
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		horizontalBox.setBorder(null);
		add(horizontalBox);
		
		wordField = new JTextField();
		wordField.setFont(new Font("SansSerif", Font.BOLD, 30));
		wordField.setHorizontalAlignment(SwingConstants.CENTER);
		wordField.setForeground(Color.GRAY);
		wordField.setEnabled(false);
		wordField.setEditable(false);
		horizontalBox.add(wordField);
		wordField.setColumns(10);
		
		// create a vertical box for two yes and no buttons
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		btnYes = new JButton("YES");
		btnYes.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnYes);
		
		Component verticalStrut_2 = Box.createVerticalStrut(40);
		verticalBox.add(verticalStrut_2);
		
		btnNo = new JButton("NO");
		btnNo.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnNo);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);
	}

}
