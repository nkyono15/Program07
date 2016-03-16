import java.math.BigInteger;
import java.util.Random;
import java.util.Date;
public class AsymmetricEncryption
{
    private BigInteger pubKey;
    private BigInteger priKey;
    private BigInteger e;
    
    /**
     * Constructs a new object of this class and calls the generateKeys method which creates a private, public 
     * and e key and assigns those variables to the global variables.
     */
    public AsymmetricEncryption()
    {
        generateKeys();
    }
    
    /**
     * Creates a private and public key and an exponent value which will be later used to encrypt the receiving
     * message. This method uses the BigInteger and Random class to create the keys which will create new
     * keys each time a new object of AsymmetricEncryption is created.
     */
    private void generateKeys ()
    {
        int bitLength = 1024;
        Random rand = new Random();
        
        BigInteger p = BigInteger.probablePrime(bitLength, rand);
        BigInteger q = BigInteger.probablePrime(bitLength, rand);
        pubKey = p.multiply(q);
        
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime((bitLength / 2), rand);
        
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
        {
            e.add(BigInteger.ONE);
        }
        priKey = e.modInverse(phi);
    }
    
    /**
     * This method encrypts the message that is inputted by the user by using the e value and the public key.
     * @param text that will be encrypted using this method.
     * @return A string message that is encrypted.
     * @throws IllegalArgumentException This is thrown when the user inputs an empty string.
     */
    private String encrypt (String text) throws IllegalArgumentException
    {
        if (text.length() == 0)
        {
            throw new IllegalArgumentException("Your input is empty.");
        }
        BigInteger plainText = new BigInteger(text.getBytes());
        BigInteger encrypted = plainText.modPow(e, pubKey);
        return encrypted.toString();
    }
    
    /**
     * Calls the encrypt method to create an encrypted message so user does not have direct access
     * to the encrypt method.
     * @param text String variable that users want encrypted.
     * @return String text of their encrypted message.
     */
    public String getEncryptedMessage(String text)
    {
        return new String(encrypt(text));
    }
    
    /**
     * This method decrypts the message that is inputted by the user by using the private and public key.
     * @param text that will be decrypted using this method.
     * @return A string message that is decrypted.
     * @throws IllegalArgumentException This is thrown when the user inputs an empty string.
     */
    private String decrypt (String text) throws IllegalArgumentException
    { 
        if(text.length() == 0)
        {
            throw new IllegalArgumentException("Your input is empty");
        }
        BigInteger message = new BigInteger(text);
        BigInteger original = message.modPow(priKey, pubKey);
        String decry = new String(original.toByteArray());
        return decry;
    }
    
    /**
     * Calls the decrypt method to create an decrypted message so user does not have direct access
     * to the decrypt method.
     * @param text String variable that users want decrypted.
     * @return String text of their decrypted message.
     */
    public String getDecryptedMessage(String text)
    {
        return new String(decrypt(text));
    }
    
    /**
     * Getter method that returns a String version of the user's public key.
     * @return String format of the public key.
     */
    public String getPublicKey()
    {
        return new String(pubKey.toString());
    }
    
    /**
     * Getter method that returns a String version of the user's private key.
     * @return String format of the private key.
     */
    private String getPrivateKey()
    {
        return new String(priKey.toString());
    }
    
    /**
     * This method allows the user to check if they have the same public key as the object.
     * @return boolean if user has same public key, false otherwise.
     */
    public boolean matchPublicKey(String key)
    {
        return (getPublicKey().equals(key));
    }
    
    /**
     * This method allows the user to check if they have the same private key as the object.
     * @return boolean if user has same private key, false otherwise.
     */
    public boolean matchPrivateKey(String key)
    {
        return (getPrivateKey().equals(key));
    }
}
