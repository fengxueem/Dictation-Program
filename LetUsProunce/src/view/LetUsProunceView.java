package view;

// What's commented below is the command line version (0.1)
// import java.util.*;

// public class LetUsProunce {
//   private WordExtractor wordExtractor = new TxtWordExtractor(); 
//   private WordRepo wordRepo = new SortedWordRepo();
  
//   public void collectWords(String... filePaths) {
//   	for (String filePath : filePaths) {
//   	  System.out.println("Start reading " + filePath);
//   	  for (Word w: wordExtractor.read(filePath)) {
//       	wordRepo.put(w);
//   	  }
//   	}
//   }

//   public void dictate() {
//   	Iterator<Word> it = wordRepo.getIterator();
//   	while (it.hasNext()){
//   	  System.out.println(it.next());
//   	  try {
//   	    System.in.read();
//   	  } catch(Exception e) {
//   	  	e.printStackTrace();
//   	  }
//   	}
//   }

//   public static void main(String[] args) {
//   	LetUsProunce let = new LetUsProunce();
//   	let.collectWords(args);
//   	System.out.println("Please type enter when you need to prounce a new word");
//   	let.dictate();
//   	System.out.println("Congrats!");
//   }
// }
import java.awt.*;
import javax.swing.*;

public class LetUsProunceView {
  private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("Let Us Prounce");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create the menu bar.  Make it have a green background.
    JMenuBar menuBar = new JMenuBar();
    menuBar.setOpaque(true);
    menuBar.setPreferredSize(new Dimension(200, 20));

    //Create a yellow label to put in the content pane.
    JLabel label = new JLabel();
    label.setOpaque(true);
    label.setPreferredSize(new Dimension(200, 180));
 
    //Set the menu bar and add the label to the content pane.
    frame.setJMenuBar(menuBar);
    frame.getContentPane().add(label, BorderLayout.CENTER);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }
  public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          createAndShowGUI();
        }
    });
  }  
}