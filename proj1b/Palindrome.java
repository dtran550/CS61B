public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> charList = new ArrayDeque<>();
        int stringLength = word.length();
        for (int i = 0; i < stringLength; i += 1) {
            charList.addLast(word.charAt(i));
        }
        return charList;
    }

    private boolean palindromeHelper(Deque<Character> word) {
        if (word.size() == 0 || word.size() == 1) {
            return true;
        }
        if (word.removeFirst().equals(word.removeLast())) {
            return (palindromeHelper(word));
        }
        return false;
    }

    public boolean isPalindrome(String word) {
        /*int wordLength = word.length();
        if (wordLength == 0 || wordLength == 1) {
            return true;
        }
        Deque d = wordToDeque(word);
        String word2 = "";
        while (d.size() != 0) {
            word2 += d.removeLast();
        }
        return word.equals(word2);
        */
        Deque d = wordToDeque(word);

        return palindromeHelper(d);
    }

    private boolean palindromeHelper(Deque<Character> word, CharacterComparator cc) {
        if (word.size() == 0 || word.size() == 1) {
            return true;
        }
        if (cc.equalChars(word.removeFirst(), word.removeLast())) {
            return (palindromeHelper(word, cc));
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque d = wordToDeque(word);
        return palindromeHelper(d, cc);
    }
}
