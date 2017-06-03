package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class WordRepoPane extends JPanel {
	
	public JLabel wordRepoInfo;
	public JButton btnAdd, btnRemove;
	public JList<String> list;
	/**
	 * Create the panel.
	 */
	public WordRepoPane() {
		// use BoxLayout for this panel
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(450, 300);
		SpringLayout sl_contentPane = new SpringLayout();
		setLayout(sl_contentPane);
		
		wordRepoInfo = new JLabel("as");
		sl_contentPane.putConstraint(SpringLayout.NORTH, wordRepoInfo, 3, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, wordRepoInfo, 23, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, wordRepoInfo, 5, SpringLayout.WEST, this);
		wordRepoInfo.setHorizontalAlignment(SwingConstants.LEFT);
		add(wordRepoInfo);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 3, SpringLayout.SOUTH, wordRepoInfo);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 1, SpringLayout.WEST, wordRepoInfo);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -23, SpringLayout.SOUTH, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -3, SpringLayout.EAST, this);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		panel.add(verticalBox);
		
		JScrollPane scrollPane = new JScrollPane();
		verticalBox.add(scrollPane);
		
		list = new JList();
		verticalBox.add(list);
		
		Box verticalBox_1 = Box.createVerticalBox();
		panel.add(verticalBox_1);
		
		btnAdd = new JButton("Add");
		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(btnAdd);
		
		Component rigidArea = Box.createRigidArea(new Dimension(1, 80));
		verticalBox_1.add(rigidArea);
		
		btnRemove = new JButton("Remove");
		btnRemove.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(btnRemove);
	}

}
