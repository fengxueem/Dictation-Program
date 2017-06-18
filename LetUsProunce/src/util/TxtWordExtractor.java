package util;

import java.io.*;
import java.util.*;

public class TxtWordExtractor implements WordExtractor{
  public List<Word> read(String filePath) {
  	List<Word> wordList = new ArrayList<Word>();
  	String line = null;
    try {
      BufferedReader bufferReader = new BufferedReader(new FileReader(
          new File(filePath)));
      try {
        String[] wordsString;
        while((line = bufferReader.readLine()) != null) {
          wordsString = line.split("\\W+");
          for (String w : wordsString) {
          	wordList.add(new Word(w.toLowerCase()));
          }
        }
      } finally {
        bufferReader.close();
      }
    } catch(FileNotFoundException ex) {
      System.out.println("Cannot find: " + filePath);
    } catch(IOException ex) {               
      ex.printStackTrace();
    }
    if (wordList.get(0).getName().equals("")) {
      wordList.remove(0);
    }
    return wordList;
  }

  // test read()
  public static void main(String[] args) {
  	TxtWordExtractor txt = new TxtWordExtractor();
  	for (Word w: txt.read("../text.txt")) {
	    System.out.print(w.getName() + " ");  		
  	}
  }  
}