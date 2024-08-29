import java.util.StringTokenizer;

public class Task1 {
    public static void main(String[] args) {
        String s = "I love pizza !";

        StringTokenizer tokenizer = new StringTokenizer(s);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println(token);
        }
    }
}
