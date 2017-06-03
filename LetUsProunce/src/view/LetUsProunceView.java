package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class LetUsProunceView extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	public JMenu mnFile, mnWordRepo, mnDictate;
	public JMenuItem mntmFile;

	/**
	 * Launch the view.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					LetUsProunceView frame = new LetUsProunceView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LetUsProunceView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// create menu bar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmFile = new JMenuItem("Open File...");
		mnFile.add(mntmFile);
		
		mnWordRepo = new JMenu("Word Repo");
		menuBar.add(mnWordRepo);
		
		mnDictate = new JMenu("Dictate");
		menuBar.add(mnDictate);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		
	}

}
