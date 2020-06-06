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
        ArrayList<Integer> occurrenceArr = new ArrayList<>();
        int substrLength = substring.length();
        int strLength = wholeString.length();

        for (int i = 0; i < strLength - substrLength + 1; i++) {
            if (wholeString.regionMatches(false, i, substring, 0, substrLength)) {
                occurrenceArr.add(i);
            }
        }
        displayResult(substrLength, occurrenceArr);
    }

    private static void displayResult(int substrLength, ArrayList<Integer> occurrenceArr) {
        for (int i = 0; i < occurrenceArr.size(); i++) {
            int startPosition = occurrenceArr.get(i);
            int endPosition = occurrenceArr.get(i) + substrLength - 1;
            System.out.println(startPosition + " " + endPosition);
        }
    }
}
