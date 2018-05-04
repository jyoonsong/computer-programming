package lab5;

import java.util.Scanner;

public class Crypto {

    private static char [] arr = new char [61];

    public static void main(String[] args) {
        init();

        Scanner in = new Scanner(System.in);

        System.out.print("Encrypt (1) Decrypt(2) : ");
        int choice = in.nextInt();
        in.nextLine();

        System.out.print("Enter string : ");
        String str = in.nextLine();

        System.out.print("Enter key value : ");
        int key = in.nextInt();

        if (choice == 1)
            System.out.println( encrypt(str, key) );
        else
            System.out.println( decrypt(str, key) );


        in.close();
    }

    private static void init() {
        int i;
        for(i = 0; i < 26; i++)
            arr[i] = (char)(97 + i);
        for(i = 0; i < 26; i++)
            arr[i + 26] = (char)(65 + i);
        for(i = 0; i < 9; i++)
            arr[i + 52] = (char)(49 + i);
    }

    private static int indexOf(char c) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == c)
                return i;
        return -1;
    }

    public static String encrypt(String str, int key) {
        String encrypted = "";
        for (int i = 0; i < str.length(); i++) {
            int result = ( indexOf(str.charAt(i)) + key ) % 61;
            encrypted += arr[result];
        }
        return encrypted;
    }

    public static String decrypt(String str, int key) {
        String decrypted = "";
        for (int i = 0; i < str.length(); i++) {
            int result = ( indexOf(str.charAt(i)) - key + 61 ) % 61;
            decrypted += arr[result];
        }
        return decrypted;
    }
}
