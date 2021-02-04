package year2015.day4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {
  
  private static MessageDigest md;
  
  public long part1(String input, String startWith) {
    long additionNumber = 0;
    String hashtext = "";
    instantiateMD5Digest();
    
    while (!hashtext.startsWith(startWith)) {
    additionNumber++;
    byte[] bytesOfInput = md.digest((input + additionNumber).getBytes());
    BigInteger no = new BigInteger(1, bytesOfInput);
    hashtext = appendZeroesToFront(no.toString(16));
    }
    
    return additionNumber;
  }
  
  private void instantiateMD5Digest() {
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException nsae) {
    throw new IllegalStateException("Illegal operation, ", nsae);
    }
  }
  
  private String appendZeroesToFront(String str) {
    while (str.length() < 32) {
      str = "0" + str;
    }
    return str;
  }
}
