import com.police.security.DESedeEncryption;

import java.util.*;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TestBed
 */
public class TestBed {

    public static void main(String[] args) throws Exception{
        DESedeEncryption myEncryptor = new DESedeEncryption();
        String stringToEncrypt = "13:04";
        String encrypted = myEncryptor.encrypt(stringToEncrypt);
        System.out.println("Encrypted Value :" + encrypted);
    }

}
