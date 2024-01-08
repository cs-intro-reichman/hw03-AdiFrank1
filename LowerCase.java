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

        int i=0;
        while ( i < str.length())

          {   char ch = str.charAt(i);

              if ((ch == ' ') || (ch > 31 ) && (ch < 59) || (ch == 64) ||(ch >=97) && (ch<=122))
              {
               ans = ans + ch;}
               
            else
                { ans = ans + (char) (str.charAt(i)+32);}


            i++;

        }
               return ans;
  }

}