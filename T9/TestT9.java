import java.util.List;

public class TestT9 {
    public static void main(String[] args) {
        T9 t9 = new T9();

        // Load the words from the Kelly-listan
        t9.loadWords("kelly.txt");

        // Test case 1: Encoding a specific word
        String word = "svenska";
        String encoded = t9.encode(word);
        System.out.println("Encoded word '" + word + "': " + encoded);

        // Test case 2: Decoding the encoded sequence
        List<String> decodedWords = t9.decode(encoded);
        System.out.println("Decoded words for sequence '" + encoded + "': " + decodedWords);

        // Test case 3: Testing multiple words
        String[] testWords = {"hej", "hejsan", "himmel", "ord", "vanlig"};
        for (String testWord : testWords) {
            String testEncoded = t9.encode(testWord);
            List<String> testDecodedWords = t9.decode(testEncoded);
            System.out.println("Original word: " + testWord);
            System.out.println("Encoded: " + testEncoded);
            System.out.println("Decoded: " + testDecodedWords);
            System.out.println("-------------------");
        }

        // Test case 4: Ensure all words in kelly.txt can be encoded and decoded
        t9.testDecoding();  // This method will iterate over all words and check encoding/decoding
    }
}
