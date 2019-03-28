package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	 
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Write a message :)");
		String e = encryptor(message);
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/FileEncryptDecrypt.txt");
			fw.write(e);
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	static String encryptor(String s) {
	
	String str = "";
		
	if(s.length()%2 != 0) {
		for(int i = 0; i<s.length(); i++) {
			if(i%2==0) {
				String letter = s.substring(i, i+1);
				str = str + letter.toUpperCase();
			}
			else {
				String letter = s.substring(i, i+1);
				str = str + letter.toLowerCase();
			}
		}
	}
	else {
		for(int j = 0; j<s.length(); j++) {
			if(j%2==0) {
				String letter = s.substring(j, j+1);
				str = str + letter.toLowerCase();
			}
			else {
				String letter = s.substring(j, j+1);
				str = str + letter.toUpperCase();
			}
		}
	}
		return str;
	}
	
}
