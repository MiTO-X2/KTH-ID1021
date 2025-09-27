import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class T9 {
    private Node root;

    // Constructor initializes the root of the trie
    public T9() {
        root = new Node();
    }

    // Node class representing each node in the trie
    private class Node {
        public Node[] next;
        public boolean valid;

        public Node() {
            next = new Node[27];  // One branch for each letter ('a' to 'ö', excluding 'q' and 'w')
            valid = false;
        }
    }

    private String normalize(String word) {
    return word.replaceAll("[^a-zA-Zåäö]", "");  // Remove any unwanted characters
    }


    public void add(String word) {
        word = normalize(word);  // Normalize the word before processing
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = code(word.charAt(i));  // Convert character to its respective index
            if (index == -1) {
                System.out.println("Invalid character in word: " + word);
                return;  // Skip adding this word if it contains invalid characters
            }
            if (current.next[index] == null) {
                current.next[index] = new Node();
            }
            current = current.next[index];
        }
        current.valid = true;  // Mark the last node as a valid word
    }


    // Method to load words from a file and add them to the trie
    public void loadWords(String fileName) {
        // try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"))) {
            String word;
            while ((word = br.readLine()) != null) {
                add(word.trim().toLowerCase());  // Add each word to the trie (trim any extra spaces)
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to encode a word to a T9 key sequence
    public String encode(String word) {
        StringBuilder sequence = new StringBuilder();

        // Iterate over each character and convert it to the corresponding key
        for (char c : word.toCharArray()) {
            sequence.append(charToKey(c));  // Use charToKey to map char to T9 key
        }

        return sequence.toString();
    }

    // Method to decode a key sequence into a list of possible words
    public List<String> decode(String sequence) {
        List<String> words = new ArrayList<>();
        collect(root, sequence, 0, "", words);  // Start collecting from the root
        return words;
    }

    private void collect(Node node, String sequence, int depth, String currentWord, List<String> words) {
        if (depth == sequence.length()) {
            if (node.valid) {
                words.add(currentWord);  // Add valid word to the list
            }
            return;
        }

        char key = sequence.charAt(depth);
        int keyIndex = keyToIndex(key);  // Convert the key to an index (0-8)

        if (keyIndex == -1) {
            // If key is invalid, return early
            System.out.println("Invalid key: " + key);
            return;
        }

        int startCharIndex = keyIndex * 3;  // Each key corresponds to 3 characters
        int endCharIndex = (key == '7' || key == '9') ? startCharIndex + 4 : startCharIndex + 3;

        for (int i = startCharIndex; i < endCharIndex; i++) {
            if (node.next[i] != null) {
                collect(node.next[i], sequence, depth + 1, currentWord + character(i), words);
            }
        }
    }


    // Method to map a key (e.g., '2', '3') to an index (0..8)
    private int keyToIndex(char key) {
        switch (key) {
            case '2': return 1;  // '2' maps to indices for 'a', 'b', 'c'
            case '3': return 2;  // '3' maps to 'd', 'e', 'f'
            case '4': return 3;  // '4' maps to 'g', 'h', 'i'
            case '5': return 4;  // '5' maps to 'j', 'k', 'l'
            case '6': return 5;  // '6' maps to 'm', 'n', 'o'
            case '7': return 6;  // '7' maps to 'p', 'r', 's'
            case '8': return 7;  // '8' maps to 't', 'u', 'v'
            case '9': return 8;  // '9' maps to 'x', 'y', 'z'
            default: return -1;  // Invalid key
        }
    }

    // Method to map a character index to a character (used in the trie traversal)
    private char character(int code) {
        switch (code) {
            case 0: return 'a';
            case 1: return 'b';
            case 2: return 'c';
            case 3: return 'd';
            case 4: return 'e';
            case 5: return 'f';
            case 6: return 'g';
            case 7: return 'h';
            case 8: return 'i';
            case 9: return 'j';
            case 10: return 'k';
            case 11: return 'l';
            case 12: return 'm';
            case 13: return 'n';
            case 14: return 'o';
            case 15: return 'p';
            case 16: return 'r';
            case 17: return 's';
            case 18: return 't';
            case 19: return 'u';
            case 20: return 'v';
            case 21: return 'x';
            case 22: return 'y';
            case 23: return 'z';
            case 24: return '\u00E5';
            case 25: return '\u00E4';
            case 26: return '\u00F6';
            default: return '?';  // Invalid character \u00E5, \u00E4, and \u00F6
        }
    }

    // Method to map a character to its respective code (used for trie traversal)
    private int code(char w) {
        switch (w) {
            case 'a': return 0;
            case 'b': return 1;
            case 'c': return 2;
            case 'd': return 3;
            case 'e': return 4;
            case 'f': return 5;
            case 'g': return 6;
            case 'h': return 7;
            case 'i': return 8;
            case 'j': return 9;
            case 'k': return 10;
            case 'l': return 11;
            case 'm': return 12;
            case 'n': return 13;
            case 'o': return 14;
            case 'p': return 15;
            case 'r': return 16;
            case 's': return 17;
            case 't': return 18;
            case 'u': return 19;
            case 'v': return 20;
            case 'x': return 21;
            case 'y': return 22;
            case 'z': return 23;
            case '\u00E5': return 24;
            case '\u00E4': return 25;
            case '\u00F6': return 26;
            // default: return -1;
            default:
            System.out.println("Invalid character: " + w + " (Unicode: " + (int) w + ")");
            return -1;  // Invalid character
        }
    }

    // Method to map a character to its corresponding T9 key
    private char charToKey(char c) {
        switch (c) {
            case 'a': case 'b': case 'c': return '2';
            case 'd': case 'e': case 'f': return '3';
            case 'g': case 'h': case 'i': return '4';
            case 'j': case 'k': case 'l': return '5';
            case 'm': case 'n': case 'o': return '6';
            case 'p': case 'r': case 's': return '7';
            case 't': case 'u': case 'v': return '8';
            case 'x': case 'y': case 'z': return '9';
            case '\u00E5': case '\u00E4': case '\u00F6': return '9';
            default: return '?';  // Invalid character
        }
    }

    // Method to test decoding for all words in the trie
public void testDecoding() {
    // try (BufferedReader br = new BufferedReader(new FileReader("kelly.txt"))) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("kelly.txt"),"UTF-8"))) {
        String word;
        while ((word = br.readLine()) != null) {
            word = word.trim().toLowerCase();
            String encoded = encode(word);  // Encode the word to a T9 sequence
            List<String> decodedWords = decode(encoded);  // Decode the sequence back to possible words
            
            System.out.println("Original word: " + word);
            System.out.println("Encoded sequence: " + encoded);
            System.out.println("Decoded words: " + decodedWords);
            System.out.println("-------------------");
        }
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
    }
}

    // Main testing method for the T9 implementation
    public static void main(String[] args) {
        T9 t9 = new T9();

        // Load words into the trie from the Kelly list
        t9.loadWords("kelly.txt");

        // Example encoding and decoding test
        String testWord = "svenska";
        String encodedWord = t9.encode(testWord);
        System.out.println("Encoded word '" + testWord + "': " + encodedWord);

        List<String> decodedWords = t9.decode(encodedWord);
        System.out.println("Decoded words for sequence '" + encodedWord + "': " + decodedWords);
    }
    
}
