package model;

import java.util.Iterator;
import java.util.List;
import controller.DictatePaneController;
import util.Word;
import util.WordExtractor;
import util.WordRepo;

public class DictationManager {
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
	
	public Word getNext() {
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
}
