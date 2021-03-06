package model;

import java.util.Iterator;
import java.util.List;
import controller.DictatePaneController;
import util.Word;
import util.WordExtractor;
import util.WordRepo;
import util.mvc.controller.MessageHandler;

public class DictationManager implements MessageHandler {
	private WordRepo repo;
	private WordExtractor wordExtractor;
	private Iterator<Word> iterator;
	private DictatePaneController dictatePaneController;

	public DictationManager(WordRepo repo, WordExtractor wordExtractor) {
		this.setWordExtractor(wordExtractor);
		this.setRepo(repo);
		iterator = repo.getIterator();
	}
	
	public WordExtractor getWordExtractor() {
		return wordExtractor;
	}

	public void setWordExtractor(WordExtractor wordExtractor) {
		this.wordExtractor = wordExtractor;
	}

	public WordRepo getRepo() {
		return repo;
	}

	public void setRepo(WordRepo repo) {
		this.repo = repo;
	}

	public void setDictatePaneController(DictatePaneController controller) {
		this.dictatePaneController = controller;
	}
	
	public void addWords(List<Word> words) {
		for (Word w: words) {
			repo.put(w);
		}
	}
	
	public void addWordsFromFiles(Object[] filePaths) {
		for (Object filePath : filePaths) {
			addWords(wordExtractor.read((String)filePath));
		}
		// renew iterator after word repo is changed
		iterator = repo.getIterator();
	}
	
	private Word getNext() {
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			// if this iterator reaches the end,
			// then continue with a new one
			iterator = repo.getIterator();
			if (iterator.hasNext()) {
				return getNext();
			} else {
				// if the new iterator has no words,
				// then dictation is over!
				return new Word("Congrats!");
			}
		}
	}
	
	private Word getFirst() {
		return repo.getFirst();
	}
	
	public void removeWord() {
		// remove the last word provided by iterator
		try {
			iterator.remove();
		} catch (IllegalStateException e) {
			// next() should be called first!
		}
	}
	
	@Override
	public boolean achieveMessage(String source, String command) {
		switch (source + command) {
			case "btnYesremove_word_and_next":
				removeWord();
			case "btnNokeep_word_and_next":
				dictatePaneController.setWordField(getNext());
				dictatePaneController.setWordNum(repo.getSize());
				return true;
			case "btnGostart_dictate":
				dictatePaneController.setWordField(getFirst());
				dictatePaneController.setWordNum(repo.getSize());
				return true;
			default:
				break;
		}
		return false;
	}
}
