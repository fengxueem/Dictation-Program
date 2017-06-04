package util;

import java.util.*;

interface WordExtractor {
  List<Word> read(String filePath);
}