/**
 * This class, WomboCombo is used to encrypt and decrypt a message using a symmetric cipher.
 */

public class WomboCombo
{
   private String key;
   private String plainText;
   private boolean encrypt;
   private String encrypted;
   private String decrypted;
   private int shift;
   
   /**
    * The WomboCombo constructor takes in a key (string), the plain text (string), and whether or
    * not the message is being encrypted or decrypted (boolean).
    * @param key Takes in the String value of the key that the user wants to use to encrypt or
    * decrypt the message.
    * @param plainText Takes in the String plain text of the message that will be encrypted or 
    * decrypted.
    * @param encrypt Takes in a boolean that represents whether or not the user wants to 
    * encrypt(true) or decrypt(false).
    */

   public WomboCombo(String key, String plainText, boolean encrypt)
   {
      this.key = key;
      this.plainText = plainText;
      this.encrypt = encrypt;
      setShift();
      
      System.out.println(key + "    " + plainText);
      if(encrypt)
      {
         decrypted = plainText;
         encrypt();

      }else{
         encrypted = plainText;
         decrypt();
      }
   }
   /**
    * The WomboCombo constructor takes in a key (string), the plain text (string), and whether or
    * not the message is being encrypted or decrypted (boolean).
    */
   private void encrypt()
   {
      shifterEncrypt();
      switchThem(encrypted);
      shuffle(encrypted);
   }
   /**
    * The WomboCombo constructor takes in a key (string), the plain text (string), and whether or
    * not the message is being encrypted or decrypted (boolean).
    */
   private void decrypt()
   {
      shifterDecrypt();
      unShuffle(decrypted);
      switchThem(decrypted);
   }
   /**
    * The WomboCombo constructor takes in a key (string), the plain text (string), and whether or
    * not the message is being encrypted or decrypted (boolean).
    */
   public String getEncrypted()
   {
      return new String(encrypted);
   }
   /**
    * The WomboCombo constructor takes in a key (string), the plain text (string), and whether or
    * not the message is being encrypted or decrypted (boolean).
    * @param key Takes in the String value of the key that the user wants to use to encrypt or
    * decrypt the message.
    */
   public String getDecrypted()
   {
      return new String(decrypted);
   }
   /**
    * The WomboCombo constructor takes in a key (string), the plain text (string), and whether or
    * not the message is being encrypted or decrypted (boolean).
    * @param key Takes in the String value of the key that the user wants to use to encrypt or
    * decrypt the message.
    * @param plainText Takes in the String plain text of the message that will be encrypted or
    * decrypted.
    * @param encrypt Takes in a boolean that represents whether or not the user wants to
    * encrypt(true) or decrypt(false).
    */
   private void setShift()
   {
      shift = getAscii()/key.length();
   }
   /**
    * The WomboCombo constructor takes in a key (string), the plain text (string), and whether or
    * not the message is being encrypted or decrypted (boolean).
    * @param key Takes in the String value of the key that the user wants to use to encrypt or
    * decrypt the message.
    * @param plainText Takes in the String plain text of the message that will be encrypted or
    * decrypted.
    * @param encrypt Takes in a boolean that represents whether or not the user wants to
    * encrypt(true) or decrypt(false).
    */
   private int getAscii()
   {
      int total = 0;
      for(int i = 0; i < key.length(); i++)
      {
         total = total + (int)(key.charAt(i));
      }
      
      return total;
   }
   /**
    * The WomboCombo constructor takes in a key (string), the plain text (string), and whether or
    * not the message is being encrypted or decrypted (boolean).
    * @param key Takes in the String value of the key that the user wants to use to encrypt or
    * decrypt the message.
    * @param plainText Takes in the String plain text of the message that will be encrypted or
    * decrypted.
    * @param encrypt Takes in a boolean that represents whether or not the user wants to
    * encrypt(true) or decrypt(false).
    */
   private void shifterEncrypt()
   {
      String toChange = "";
      for(int i = 0; i < plainText.length(); i++)
      {
         char newOne = (char)((plainText.charAt(i) + shift)%127);
         toChange = toChange + newOne;
      }
      encrypted = toChange;
   }
   
   private void shifterDecrypt()
   {
      String toChange = "";
      for(int i = 0; i < plainText.length(); i++)
      {
         char newOne = (char)(127 - Math.abs(plainText.charAt(i) - shift));
         toChange = toChange + newOne;
      }
      decrypted = toChange;
   }
   private void switchThem(String theStuff)
   {
      if(theStuff.length()%2 == 0)
      {
         String one = theStuff.substring(0, theStuff.length()/2);
         String two = theStuff.substring(theStuff.length()/2, theStuff.length());
         
         if(encrypt)
         {
            encrypted = two + one;
         }else{
            decrypted = two + one;
         }
      }else
      {
         String holder = "";
         for(int i = theStuff.length(); i > 0; i--)
         {
            holder = holder + theStuff.substring(i-1, i);
         }
         if(encrypt)
         {
            encrypted = holder;
         }else{
            decrypted = holder;
         }
      }
   }
   private void shuffle(String theStuff)
   {
      String one = "";
      String two = "";
      for(int i = 0; i < theStuff.length(); i++)
      {
         
         if(i%2 == 0)
         {
            System.out.println(1);
            one = one + theStuff.substring(i,i+1);
         }else{
            System.out.println(2);
            two = two + theStuff.substring(i,i+1);
         }
      }
      
      encrypted = one + two;
   }
   private void unShuffle(String theStuff)
   {
      boolean even = (theStuff.length()%2 == 0);
      String one = "";
      String two = "";
      if(even)
      {
         one = theStuff.substring(0, (theStuff.length()/2));
         two = theStuff.substring(theStuff.length()/2, theStuff.length());
      }else{
         one = theStuff.substring(0, (theStuff.length()/2)+1);
         two = theStuff.substring(theStuff.length()/2+1, theStuff.length());
      }
      decrypted = "";
      for(int i = 0; i < theStuff.length()/2; i++)
      {
         decrypted = decrypted + one.substring(i,i+1) + two.substring(i, i+1);
      }
      if(!even)
      {
         decrypted = decrypted + one.substring(one.length()-1, one.length());
      }
   }
   
   /*private void encrypt()
   {
      //encrypted = new String(first(plainText));
      encrypted = new String(encrypt());
   }*/
   
   /*private void decrypt()
   {
      //decrypted = new String(first(plainText));
      decrypted = new String(decrypt());
   }*/
   
   /*private String encrypt()
   {
      String toReturn = "";
      plainText = plainText.toLowerCase();
      
      int keyChar = 0;
      for (int i = 0; i < plainText.length(); i++)
      {
         char place = plainText.charAt(i);
         if (place < 'A' || place > 'Z')
         {
            toReturn = toReturn + (char)((place + key.charAt(keyChar) - 2 * 'A') % 26 + 'A');
         }
         keyChar = (keyChar+1) % key.length();
      }
      return toReturn;
   }

   
   private String decrypt()
   {
      String toReturn = "";
      plainText = plainText.toLowerCase();
      
      int keyChar = 0;
      for (int i = 0; i < plainText.length(); i++)
      {
         char place = plainText.charAt(i);
         if (place < 'A' || place > 'Z')
         {
            toReturn = toReturn + (char)((place - key.charAt(keyChar) + 26) % 26 + 'A');
         }
         keyChar = (keyChar+1) % key.length();
      }
      return toReturn;
   }*/
   
   //private String shift(int num, String letter)
   //{
      /*if(letter.equals(" "))
      {
         return " ";
      }*/
      /*if((letter.charAt(0) < 'a' || letter.charAt(0) < 'z') && (letter.charAt(0) < 'A' 
       || letter.charAt(0) < 'Z'))
      {
         return letter;
      }
      int place = 0;
      String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
         "n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C",
       "D","E","F","G","H","I","J","K"
      ,"L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
      
      for(int i = 0; i < alpha.length; i++)
      {
         if(letter.equals(alpha[i]))
         {
            place = i;
            break;
         }
      }*/
      //int newOne = (place+num)%(alpha.length);
      //newOne = (Math.abs(place+newOne))%(alpha.length);
      /*System.out.println("place: " + place +  " num: " + num + " letter: " + letter);
      
      int newOne = (place+num)%(alpha.length);
      if((place+newOne) > alpha.length || (place+newOne) < 0)
      {
         newOne = (Math.abs(place+newOne))%(alpha.length);
      }
      
      System.out.println("place: " + place + " newOne: " + newOne + 
       " num: " + num + " letter: " + letter);

      if(encrypt)
      {
         return new String(alpha[newOne]);
      }else
      {
         return new String(alpha[Math.abs(newOne)]);
      }*/

      /*String toReturn = "";
      int len = msg.length();
      for(int x = 0; x < len; x++){
      char c = (char)(msg.charAt(x) + shift);
         if (c > 'z')
         {
            toReturn =  toReturn + (char)(msg.charAt(x) - (26 - shift));
         }
         else
         {
            toReturn = toReturn + (char)(msg.charAt(x) + shift);
         }
      }
         return s;
      
      
      return letter;
   }*/
   
   /*private String first(String text)
   {
      int[] ascii = new int[key.length()];
      for(int i = 0; i < key.length(); i++)
      {
         ascii[i] = (int)(key.charAt(i));
      }
      
      String toReturn = "";
      for(int i = 0; i < text.length(); i++)
      {
         if(encrypt)
         {
            toReturn = toReturn + shift(ascii[i%ascii.length], text.substring(i, i+1));
         }else
         {
            toReturn = toReturn + shift(-ascii[i%ascii.length], text.substring(i, i+1));
         }
      }
      return toReturn;
   }*/
   /*private String second(String text)
   {
      int total = 0;
      
      for(int i = 0; i < key.length(); i++)
      {
         total = (int)(key.charAt(i));
      }
      if(!encrypt)
      {
         total = -total;
      }
      
      String toReturn = "";
      for(int i = 0; i < text.length(); i++)
      {
         toReturn = toReturn + shift(total, text.substring(i, i+1));
      }
      return toReturn;
   }*/
}