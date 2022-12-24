package trie;

import java.util.*;

/**
 * @author: Ehis Edemakhiota
 *
 * @notes: This is an implementation of a trie that can store words made from only lowercase letters
 * */

public class Trie {
    private final List<Trie> children;
    private boolean endOfWord;

    /*creating a trie that can store words created from only lowercase letters
     * can be extended to accommodate uppercase letters, numbers and special characters*/
    public Trie(){
        children = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            children.add(null);
        }
    }

    public Trie (List<Trie> children, boolean endOfWord){
        this.children = children;
        this.endOfWord = endOfWord;
    }

    public List<Trie> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}

class Driver {

    /**
     * This operation inserts a new word into a trie
     *  @param trie- the trie into which a word is to be inserted
     * @param word- the word to be inserted into a trie
     * */
    public static void insertWord(Trie trie, String word){
        Trie current = trie;

        for (char character : word.toCharArray()) {
            int groupIndex = character - 'a';
            if (current.getChildren().get(groupIndex) == null){
                current.getChildren().set(groupIndex, new Trie());
            }
            current = current.getChildren().get(groupIndex);
        }

        // place end of word marker on trie
        current.setEndOfWord(true);
    }

    /**
     * This operation pretty prints a trie
     *
     * @param trie - the trie to be printed
     * @param depth- represents the distance of a letter from the start of a word.
     * */
    public static void prettyPrint(Trie trie, int depth){
        if (trie == null){
            System.out.println("Trie is null");
            return;
        }

        for (int i = 0; i < trie.getChildren().size(); i++) {
            Trie child = trie.getChildren().get(i);
            if ( child != null){

                System.out.print(" ".repeat(depth*4));
                System.out.print("-");
                System.out.print((char) ('a' + i));

                // if trie has an end of word marker
                if (child.isEndOfWord()){
                    System.out.println("(word)");
                }
                System.out.println();
                prettyPrint(child, depth+1);
            }
        }

    }

    /**
     * This operation return a Map with the following fields:
     *       containsWord: is set to true if the trie contains the word, set to false if the trie does not contain the word
     *       trie: if the trie contains the word, then this field is set to the child trie that marks the end of the word-
     *             if the trie does not contain the word, then this field is set to null
     *
     * @param trie- trie data structure to be searched
     * @param word - the word to be searched for in trie data structure
     * */
    public static Map<String, Object> trieContains(Trie trie, String word){
        if (trie == null){
            System.out.println("Trie is null");
            return null;
        }

        Trie current = trie;

        if (current.isEndOfWord() && word.length() == 0){
            Map<String, Object> result = new HashMap<>();
            result.put("containsWord", true);
            result.put("trie", current);
            return result;
        }

        // if the word exists as a prefix in the trie but not as word
        if (!current.isEndOfWord() && word.length() == 0){
            System.out.println("exists as a prefix but not as a word");
            Map<String, Object> result = new HashMap<>();
            result.put("containsWord", false);
            result.put("trie", null);
            return result;
        }


        char firstChar = word.charAt(0);

        int groupIndex = firstChar - 'a';
        if (current.getChildren().get(groupIndex) == null){
            Map<String, Object> result = new HashMap<>();
            result.put("containsWord", false);
            result.put("trie", null);
            return result;
        }
        current = current.getChildren().get(groupIndex);
        return trieContains(current, word.substring(1));
    }

    /**
     * This operation returns a Map with the following fields:
     *   'containsPrefix'- set to true, if the trie contains the prefix, set to false if the trie does not contain the prefix
     *   'trie' - if the trie contains the prefix then this field contains the child trie that marks the end of the prefix,-
     *               if the tries does not contain the prefix then this field is set to null
     *
     * @param trie- trie data structure to be searched
     * @param prefix - prefix to be searched for in trie data structure
     * */
    public static Map<String, Object> trieContainsPrefix(Trie trie, String prefix){
        Trie current = trie;

        if (prefix.length() == 0){
            Map<String, Object> result = new HashMap<>();
            result.put("containsPrefix", true);
            result.put("trie", current);
            return result;
        }

        char firstCharacter = prefix.charAt(0);
        int groupIndex = firstCharacter - 'a';

        if (current.getChildren().get(groupIndex) == null){
            Map<String, Object> result = new HashMap<>();
            result.put("containsPrefix", false);
            result.put("trie", null);
            return result;
        }
        current = current.getChildren().get(groupIndex);
        return trieContainsPrefix(current, prefix.substring(1));
    }

    /**
     * This operation finds all words in a trie that starts with a prefix
     *
     * @param trie - trie to be searched
     * @param prefix - prefix to be found
     * @param stringList- result container that holds all words in trie that start with prefix
     * */
    public static List<String> startsWithPrefix(Trie trie, String prefix, List<String> stringList){
        Map<String, Object> result = trieContainsPrefix(trie, prefix);

        // if prefix is found in trie
        if (!(Boolean) result.get("containsPrefix")){
            return null;
        }
        // find all words in trie that start with prefix
        Trie root = (Trie) result.get("trie");
        return getAllWordsThatStartWithPrefix(root, prefix, stringList);
    }

    private static List<String> getAllWordsThatStartWithPrefix(Trie trie, String prefix, List<String> stringList) {

        Trie current = trie;

        if (current.isEndOfWord()){
            stringList.add(prefix);
        }
        for (int i = 0; i < current.getChildren().size(); i++) {
            Trie child = current.getChildren().get(i);
            if (child != null){
                char character = (char) ('a' + i);
                getAllWordsThatStartWithPrefix(child, prefix+character, stringList);
            }
        }
        return stringList;

    }

    // test
    public static void main(String[] args) {
        Trie trie = new Trie();

        insertWord(trie, "bea");
        insertWord(trie, "beard");
        insertWord(trie, "bearing");
        insertWord(trie, "bearfruit");
        insertWord(trie, "boar");

        System.out.println(trieContains(trie, "bear"));
        prettyPrint(trie, 0);
        List<String> allWordsThatWithPrefix = new ArrayList<>();
        System.out.println(startsWithPrefix(trie, "bear", allWordsThatWithPrefix));
    }
}