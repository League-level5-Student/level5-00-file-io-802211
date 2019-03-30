package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	
	public static void main(String[] args) {
		
	
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/FileEncryptDecrypt.txt"));
			String file = br.readLine();
			String decrypted = decryptor(file);
		JOptionPane.showMessageDialog(null, "" + decrypted);
		br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	
	static String decryptor(String s) {
	
	String string = s.toLowerCase();
		return string;
	}
	
}
