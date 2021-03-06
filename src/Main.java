import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String substring = in.nextLine();
        String wholeString = in.nextLine();
        if (substring.length() > wholeString.length()) {
            throw new IllegalArgumentException("First string cannot be longer than second string");
        } else {
            findSequenceInString(substring, wholeString);
        }
    }

    private static void findSequenceInString(String substring, String wholeString) {
        ArrayList<Integer> occurences = new ArrayList<>();
        int substrLength = substring.length();
        int strLength = wholeString.length();

        for (int i = 0; i < strLength - substrLength + 1; i++) {
            if (wholeString.regionMatches(false, i, substring, 0, substrLength)) {
                occurences.add(i);
            }
        }
        displayResult(substrLength, occurences);
    }

    private static void displayResult(int substrLength, ArrayList<Integer> occurences) {
        for (int i = 0; i < occurences.size(); i++) {
            int startPosition = occurences.get(i);
            int endPosition = occurences.get(i) + substrLength - 1;
            System.out.println(startPosition + " " + endPosition);
        }
    }
}
