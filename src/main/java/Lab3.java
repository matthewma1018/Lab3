import java.io.IOException;
    import java.net.URL;
    import java.util.Scanner;
    import java.util.ArrayList;
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
public class Lab3 {

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static boolean isLetter(final char letter) {
        return (65 <= letter && letter <= 90) || (97 <= letter && letter <= 122);
    }

    public static ArrayList<String> wordArray(final String content) {
        ArrayList<String> wordArray = new ArrayList<String>();
        String temp = "";
        for (int i = 0; i < content.length(); i++) {
            if (isLetter(content.charAt(i))) {
                temp += content.charAt(i);
                if (i == content.length() - 1 || !isLetter(content.charAt(i + 1))) {
                    wordArray.add(temp);
                    temp = "";
                }
            }
        }
        return wordArray;
    }

    public static int wordCount(final String content) {
        return wordArray(content).size();
    }

    public static int oneWordCount(final String content, final String word) {
        int count = 0;
        for (int i = 0; i < wordArray(content).size(); i++)
            if (wordArray(content).get(i).equals(word))
                count += 1;
        return count;
    }

    public static int uniqueWordCount(final String content) {
        ArrayList<String> temp = wordArray(content);
        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                if (temp.get(i).equals(temp.get(j))) {
                        temp.remove(j);
                        j -= 1;
                }
            }
        }
        return temp.size();
    }

    public static void main(String[] args) {
        String content = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
        System.out.println(content);
        System.out.println(wordCount(content));
        System.out.println(oneWordCount(content, "the"));
        System.out.println(uniqueWordCount(content));
    }
}
