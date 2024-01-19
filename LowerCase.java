/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
}
   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String str) {
        String ans = " " ;

        // #feedback: bad indentations!
        // #feedback: better to use here for loop
        for (int i= 0; i < str.length(); i++ )
        {   
            char ch = str.charAt(i);
            // #feedback: your condition is too complicated, lets simplify it
            if ((ch >= 'A') && (ch <= 'Z'))
            {
                // #feedback: x = x + n equivalent to x += n
                ch += 32;
            }
            
            ans += ch;
        }
        
        return ans;
      }

}
