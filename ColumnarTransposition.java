public class ColumnarTransposition
{
   private String key;
   private String plainText;
   private String encrypted;
   private String decrypted;
   private String[][] matrix;
   private int numRows;
   private boolean encrypt;
   private int[] ascii;
   private String[] filler = {"a","b","c","d","e","f","g","h","i","j","k",
   "l","m","n","o","p","q","r","s","t","u","v","w","x","y"};
   
   public ColumnarTransposition(String key, String plainText, boolean encrypt)
   {
      this.key = new String(key);
      this.plainText = new String(plainText);
      this.encrypt = encrypt;
      encrypted = "";
      decrypted = "";
      //System.out.println(key);
      //System.out.println(plainText);
      caller();
      /*Scanner scanIn;
      try{
         scanIn = new Scanner(f);
      }catch(java.io.FileNotFoundException ex){
         throw new DictionaryException();
      }
      
      String plainText = "";
      while(scanIn.hasNext())
      {
         String n = new String(scanIn.next());
         plainText = plainText + n;
      }*/
   }
   private void caller()
   {
      if(encrypt)
      {
         setMatrix();
         getAscii();
         switcher();
         sortAndSet();
         //System.out.println(key);
         //System.out.println(plainText);
      }
      else
      {
         getAscii();
         orderAndSet();
         unMatrix();
      }

   }
   private void setMatrix()
   {
      int addOnTo = 0;
      if(plainText.length()%key.length() != 0)
      {
         addOnTo = (key.length() - (plainText.length()%key.length()));
      }
      numRows = (plainText.length() + addOnTo)/key.length();

      
      matrix = new String[key.length()][numRows];
      
      int plainTextCounter = 0;
      for(int i = 0; i < numRows; i++)
      {
         for(int k = 0; k < key.length(); k++)
         {
            if(plainTextCounter >= plainText.length())
            {
               matrix[k][i] = filler[(int)(25*Math.random())];
            }else
            {
               matrix[k][i] = plainText.substring(plainTextCounter, plainTextCounter+1);
            }
            plainTextCounter++;
         }
      }
   
      /*for(int i = 0; i < numRows; i++)
      {
         for(int k = 0; k < key.length(); k++)
         {
            System.out.print(matrix[k][i]);;
         }
         System.out.println();
      }
      System.out.println();*/
   }
   private void switcher()
   {
      int plainTextCounter = 0;
      for(int k = 0; k < key.length(); k++)
      {
         for(int i = 0; i < numRows; i++)
         {
            if(plainTextCounter < plainText.length())
            {
               encrypted = encrypted + matrix[k][i];
            }
         }
      }
      //System.out.println(encrypted);
   }
   private void getAscii()
   {
      ascii = new int[key.length()];
      for(int i = 0; i < key.length(); i++)
      {
         ascii[i] = (int)(key.charAt(i));
      }
   }
   private void sortAndSet()
   {
      int[] order = new int[ascii.length];
      for(int i = 0; i < ascii.length; i++)
      {
         order[i] = i;
      }
      
      for(int i = 0; i < ascii.length-1; i++)
      {
         int holder = ascii[i];
         int holderPlace = i;
         int orderHolder = order[i];
         
         for(int k = i+1; k < ascii.length; k++)
         {
            if(holder > ascii[k])
            {
               holder = ascii[k];
               orderHolder = order[k];
               holderPlace = k;
            }
         }
         if(ascii[i] != holder)
         {
            ascii[holderPlace] = ascii[i];
            order[holderPlace] = order[i];
            order[i] = orderHolder;
            ascii[i] = holder;
         }
      }
      
      /*for(int i = 0; i < ascii.length; i++)
      {
         //System.out.println(ascii[i]);
         System.out.print(order[i]);
      }
      System.out.println();*/
      
      String holder = "";
      for(int i = 0; i < order.length; i++)
      {
         holder = holder + encrypted.substring(order[i]*numRows,
                                               (order[i]*numRows)+(numRows));
      }
      //System.out.println(holder);
      
      encrypted = holder;
   }
   
   public String getEncrypted()
   {
      return new String(encrypted);
   }
   
   private void orderAndSet()
   {
      int[] order = new int[ascii.length];
      for(int i = 0; i < ascii.length; i++)
      {
         order[i] = i;
      }
      
      for(int i = 0; i < ascii.length-1; i++)
      {
         int holder = ascii[i];
         int holderPlace = i;
         int orderHolder = order[i];
         
         for(int k = i+1; k < ascii.length; k++)
         {
            if(holder > ascii[k])
            {
               holder = ascii[k];
               orderHolder = order[k];
               holderPlace = k;
            }
         }
         if(ascii[i] != holder)
         {
            ascii[holderPlace] = ascii[i];
            order[holderPlace] = order[i];
            order[i] = orderHolder;
            ascii[i] = holder;
         }
      }
      
      int[] unOrder = new int[order.length];
      for(int i = 0; i < unOrder.length; i++)
      {
         unOrder[i] = i;
      }
      for(int i = 0; i < ascii.length-1; i++)
      {
         int holder = order[i];
         int holderPlace = i;
         int orderHolder = unOrder[i];
         
         for(int k = i+1; k < order.length; k++)
         {
            if(holder > order[k])
            {
               holder = order[k];
               orderHolder = unOrder[k];
               holderPlace = k;
            }
         }
         if(order[i] != holder)
         {
            order[holderPlace] = order[i];
            unOrder[holderPlace] = unOrder[i];
            unOrder[i] = orderHolder;
            order[i] = holder;
         }
      }

      numRows = plainText.length()/key.length();
      matrix = new String[key.length()][numRows];
      
      
      for(int i = 0; i < order.length; i++)
      {
         deHelper(i, plainText.substring(unOrder[i]*numRows, ((unOrder[i]*numRows) + numRows)));
      }
   }
   private void deHelper(int column, String inMatrix)
   {
      
      for(int i =0; i < numRows; i++)
      {
         matrix[column][i] = inMatrix.substring(i, i+1);
      }
   }
   private void unMatrix()
   {
      for(int i = 0; i < numRows; i++)
      {
         for(int k = 0; k < key.length(); k++)
         {
            decrypted = decrypted + matrix[k][i];
            //System.out.println(decrypted);
         }
      }
   }
   public String getDecrypted()
   {
      return new String(decrypted);
   }
}