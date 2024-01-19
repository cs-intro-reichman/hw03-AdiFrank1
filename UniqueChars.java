/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        // Replace the following statement with your code
        String z = " " ;

        // #feedback: why do you need to store a condition result then conditionaly behave according to it value? do it within the condition

        for (int i=0;i< s.length(); i++)
        {
            String newString= s.substring (0,i);
            char n = s.charAt(i);
            // #feedback: use always {} to scope your condition content
            if (newString.indexOf(n) == -1 || n == ' ') {
                z = z + s.charAt(i);
            }

        return z;
    }
}
