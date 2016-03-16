import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver
{
    /**
     * This is the main method which allows the user to pick which type of encryption method they want to use and using that particular encryption method it allows the user
     * to encrypt and decrypt whatever messages the user wants.
     * @param String [] args
     */
    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);
        String type = "";
        System.out.println("How do you want to encrypt your message?");
        System.out.println("Type A for asymmetric encryption");
        System.out.println("Type S for symmetric encryption");
        System.out.println("Type O for other");
        System.out.println("Type Q to quit.");
        boolean done = false;
        while (!done)
        {
            try
            {
                type = input.next();
            }
            catch (java.util.NoSuchElementException e)
            {
                System.out.println("Please don't do that");
            }
            catch (IllegalStateException e)
            {
                System.out.println("Please don't do that");
            }
            
            if(type.equals("A"))
            {
                AsymmetricEncryption as = new AsymmetricEncryption();
                String text = "";
                System.out.println("Enter the plain text:");
                try
                {
                    text = input.next();
                }
                catch (java.util.NoSuchElementException e)
                {
                    System.out.println("Please don't do that");
                }
                catch (IllegalStateException e)
                {
                    System.out.println("Please don't do that");
                }
                System.out.println("Would you like to see your encrypted message?");
                System.out.println("Type in yes or no.");
                String mess = "";
                String look = input.next();
                if (look.equals("yes"))
                {
                    mess = as.getEncryptedMessage(text);
                    System.out.println(mess);
                }
                System.out.println("Do you want to decrypt your message?");
                System.out.println("Type in yes or no.");
                String decry = input.next();
                if(decry.equals("yes"))
                {
                    System.out.println(as.getDecryptedMessage(mess));
                }
                System.out.println("Thanks for using our program! :)");
                done = true;
                return;
            }
            else if(type.equals("S"))
            {
                System.out.println("What is your key?");
                String key = input.next();
                while (key.length() == 0)
                {
                    System.out.println("Please enter a key.");
                    key = input.next();
                }
                System.out.println("What is your message?");
                String text = input.next();
                while(text.length() == 0)
                {
                    System.out.println("Please actually type something.");
                    text = input.next();
                }
                System.out.println("Do you want to encrypt your message?");
                System.out.println("Please enter either yes or no.");
                String encrypt = input.next();
                boolean encr = false;
                if (encrypt.equals("yes"))
                {
                     encr = true;
                }
                else if (encrypt.equals("no"))
                {
                    encr = false;
                }
                else
                {
                    while (!(encrypt.equals("yes") || encrypt.equals("no")))
                    {
                        System.out.println("Please pick one of the two options.");
                        encrypt = input.next();
                        if (encrypt.equals("yes"))
                        {
                              encr = true;
                        }
                        else if (encrypt.equals("no"))
                        {
                            encr = false;
                        }
                    }
                }
                ColumnarTransposition ct = new ColumnarTransposition(key,text,encr);
                if (encr == true)
                {
                    System.out.println("Do you want to see your encrypted message?");
                    System.out.println("Type in either yes or no");
                    String encrypted = input.next();
                    if (encrypted.equals("yes"))
                    {
                         System.out.println(ct.getEncrypted());
                    }
                    else
                    {
                        while (!(encrypt.equals("yes") || encrypt.equals("no")))
                        {
                            System.out.println("Please pick one of the two options.");
                            encrypt = input.next();
                            if (encrypt.equals("yes"))
                            {
                                  System.out.println(ct.getEncrypted());
                            }
                        }
                    }
                    
                    System.out.println("Do you want to decrypt your message?");
                    System.out.println("Type in either yes or no");
                    String decrypt = input.next();
                    if (decrypt.equals("yes"))
                    {
                         ColumnarTransposition ct1 = new ColumnarTransposition(key,ct.getEncrypted(),false);
                         System.out.println(ct1.getDecrypted());
                    }
                    else
                    {
                        while (!(decrypt.equals("yes") || decrypt.equals("no")))
                        {
                            System.out.println("Please pick one of the two options.");
                            encrypt = input.next();
                            if (encrypt.equals("yes"))
                            {
                                  ColumnarTransposition ct1 = new ColumnarTransposition(key,ct.getEncrypted(),false);
                                  System.out.println(ct1.getDecrypted());
                            }
                        }
                    }
                }
                else
                {
                    System.out.println("Do you want to decrypt your message?");
                    System.out.println("Type in either yes or no");
                    String decrypt = input.next();
                    if (decrypt.equals("yes"))
                    {
                         System.out.println(ct.getDecrypted());
                    }
                    else
                    {
                        while (!(decrypt.equals("yes") || decrypt.equals("no")))
                        {
                            System.out.println("Please pick one of the two options.");
                            encrypt = input.next();
                            if (encrypt.equals("yes"))
                            {
                                  System.out.println(ct.getDecrypted());
                            }
                        }
                    }
                }
                System.out.println("Thanks for using our program! :)");
                done = true;
                return;
            }
            else if (type.equals("O"))
            {
                System.out.println("What is your key?");
                String key = input.next();
                while (key.length() == 0)
                {
                    System.out.println("Please enter a key.");
                    key = input.next();
                }
                System.out.println("What is your message?");
                String text = input.next();
                while(text.length() == 0)
                {
                    System.out.println("Please actually type something.");
                    text = input.next();
                }
                System.out.println("Do you want to encrypt your message?");
                System.out.println("Please enter either yes or no.");
                String encrypt = input.next();
                boolean encr = false;
                if (encrypt.equals("yes"))
                {
                     encr = true;
                }
                else if (encrypt.equals("no"))
                {
                    encr = false;
                }
                else
                {
                    while (!(encrypt.equals("yes") || encrypt.equals("no")))
                    {
                        System.out.println("Please pick one of the two options.");
                        encrypt = input.next();
                        if (encrypt.equals("yes"))
                        {
                              encr = true;
                        }
                        else if (encrypt.equals("no"))
                        {
                            encr = false;
                        }
                    }
                }
                WomboCombo wc = new WomboCombo(key,text,encr);
                if (encr == true)
                {
                    System.out.println("Do you want to see your encrypted message?");
                    System.out.println("Type in either yes or no");
                    String encrypted = input.next();
                    if (encrypted.equals("yes"))
                    {
                         System.out.println(wc.getEncrypted());
                    }
                    else
                    {
                        while (!(encrypt.equals("yes") || encrypt.equals("no")))
                        {
                            System.out.println("Please pick one of the two options.");
                            encrypt = input.next();
                            if (encrypt.equals("yes"))
                            {
                                  System.out.println(wc.getEncrypted());
                            }
                        }
                    }
                    
                    System.out.println("Do you want to decrypt your message?");
                    System.out.println("Type in either yes or no");
                    String decrypt = input.next();
                    if (decrypt.equals("yes"))
                    {
                         WomboCombo wc1 = new WomboCombo(key,wc.getEncrypted(),false);
                         System.out.println(wc1.getDecrypted());
                    }
                    else
                    {
                        while (!(decrypt.equals("yes") || decrypt.equals("no")))
                        {
                            System.out.println("Please pick one of the two options.");
                            encrypt = input.next();
                            if (encrypt.equals("yes"))
                            {
                                  WomboCombo ct1 = new WomboCombo(key,wc.getEncrypted(),false);
                                  System.out.println(ct1.getDecrypted());
                            }
                        }
                    }
                }
                else
                {
                    System.out.println("Do you want to decrypt your message?");
                    System.out.println("Type in either yes or no");
                    String decrypt = input.next();
                    if (decrypt.equals("yes"))
                    {
                         System.out.println(wc.getDecrypted());
                    }
                    else
                    {
                        while (!(decrypt.equals("yes") || decrypt.equals("no")))
                        {
                            System.out.println("Please pick one of the two options.");
                            encrypt = input.next();
                            if (encrypt.equals("yes"))
                            {
                                  System.out.println(wc.getDecrypted());
                            }
                        }
                    }
                }
                System.out.println("Thanks for using our program! :)");
                done = true;
                return;
            }
            else if(type.equals("Q"))
            {
                done = true;
                return;
            }
            else
            {
                System.out.println("Please pick a type.");
                type = input.next();
            }
        }
    }
    
    public void asymmetricFileEncryptionAndDecryption(String fileName)
    {
        String text = "";
        try
        {
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            while(input.hasNext())
            {
                text += input.next();
            }
            input.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot find file.");
        }
        AsymmetricEncryption as = new AsymmetricEncryption();
        String encryted = as.getEncryptedMessage(text);
        try
        {
            PrintStream encryptedFile = new PrintStream("Encrypted File");
            encryptedFile.println(encryted);
        }
        catch (IOException ex)
        {
            System.out.println("Error found.");
        }
        
        String decryted = as.getDecryptedMessage(text);
        try
        {
            PrintStream decryptedFile = new PrintStream("Decrypted File");
            decryptedFile.println(decryted);
        }
        catch (IOException ex)
        {
            System.out.println("Error found.");
        }
    }
    
    public void symmetricEncryptFile(String fileName, String key)
    {
        String text = "";
        try
        {
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            while(input.hasNext())
            {
                text += input.next();
            }
            input.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot find file.");
        }
        ColumnarTransposition ct = new ColumnarTransposition(key, text, true);
        String encryted = ct.getEncrypted();
        try
        {
            PrintStream encryptedFile = new PrintStream("Encrypted File");
            encryptedFile.println(encryted);
        }
        catch (IOException ex)
        {
            System.out.println("Error found.");
        }
    }
    
    public void symmetricDecryptFile(String fileName, String key)
    {
        String text = "";
        try
        {
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            while(input.hasNext())
            {
                text += input.next();
            }
            input.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot find file.");
        }
        ColumnarTransposition ct = new ColumnarTransposition(key, text, false);
        String decryted = ct.getDecrypted();
        try
        {
            PrintStream encryptedFile = new PrintStream("Decrypted File");
            encryptedFile.println(decryted);
        }
        catch (IOException ex)
        {
            System.out.println("Error found.");
        }
    }
}

