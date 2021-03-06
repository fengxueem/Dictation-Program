package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class DictatePane extends JPanel {
	
	public JTextField wordField;
	public JButton btnYes, btnNo, btnGo;
	public JLabel lblRepoNumber;
	private JScrollPane scrollPane;
	/**
	 * Create the panel.
	 */
	public DictatePane() {
		// use BoxLayout for this panel
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		// create a horizontal box for text field
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(null);
		add(horizontalBox);
		
		wordField = new JTextField();
		wordField.setFont(new Font("SansSerif", Font.BOLD, 37));
		wordField.setHorizontalAlignment(SwingConstants.CENTER);
		wordField.setForeground(Color.GRAY);
		wordField.setEnabled(false);
		wordField.setEditable(false);
		
		scrollPane = new JScrollPane(wordField);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		horizontalBox.add(scrollPane);
		
		// create a vertical box for two yes and no buttons
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);
		
		lblRepoNumber = new JLabel("");
		lblRepoNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(lblRepoNumber);
		
		btnGo = new JButton("Go!");
		btnGo.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnGo);
		
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
