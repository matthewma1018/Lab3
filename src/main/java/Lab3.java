import java.io.IOException;
    import java.net.URL;
    import java.util.Scanner;

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

    public static int wordCount(final String content) {
        int start = 0;
        while (!isLetter(content.charAt(start)))
            start += 1;
        int count = 1;
        for (int i = start; i < content.length() - 1; i++) {
            if (!isLetter(content.charAt(i)) && isLetter(content.charAt(i + 1)))
                count += 1;
        }
        return count;
    }

    /*public static int countOneWord(String content, final String word) {
        int count = 0;
        if (content.indexOf(word) == 0 && !isLetter(content.charAt(word.length()))) {
            count += 1;
            content = content.substring(word.length(), content.length());
        }
        while (content.indexOf(word) != -1 && !isLetter(content.charAt
                (content.indexOf(word) - 1))) {
            count += 1;
            content = content.substring(content.indexOf(word) + word.length(),
                    content.length());
        }
        return count;
    }*/

    public static void main(String[] args) {
        //String content = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String content = "baibai bai bai    bai  bai  fsjlbaiailala bai bai bai ebi oao bai";
        System.out.println(wordCount(content));
        //System.out.println(countOneWord(content, "bai"));
        //System.out.println(content.indexOf("bai"));

    }

}
