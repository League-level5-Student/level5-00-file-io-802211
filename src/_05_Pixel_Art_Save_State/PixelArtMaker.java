package _05_Pixel_Art_Save_State;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PixelArtMaker implements MouseListener, ActionListener{
	private JFrame window;
	private GridInputPanel gip;
	private GridPanel gp;
	ColorSelectionPanel csp;
	private JButton saveButton;
	private JButton loadButton;
	
	
	public void start() {
		gip = new GridInputPanel(this);	
		window = new JFrame("Pixel Art");
		
		window.setLayout(new FlowLayout());
		window.setResizable(false);
		window.add(gip);
		
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		saveButton = new JButton();
		saveButton.setText("Save");
		saveButton.addActionListener(this);
		window.add(saveButton);
		loadButton = new JButton("Load");
		window.add(loadButton);
//		loadButton.addActionListener((e)->{
//			System.out.println("load");
//			window.remove(gp);
//			
//			window.add(gp);
//			window.pack();
//		});
		
		
	}
	
	
	private static GridPanel load() {
		System.out.println("loading");
		try (FileInputStream fis = new FileInputStream(new File("src/_05_Pixel_Art_Save_State/Pixel.txt")); ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (GridPanel) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
 
	}
	
	public void submitGridData(int w, int h, int r, int c) {
		gp = load();
		if(gp==null) {
		gp = new GridPanel(w, h, r, c);
		}
		
		csp = new ColorSelectionPanel();
		window.remove(gip);
		window.add(gp);
		window.add(csp);
		gp.repaint();
		gp.addMouseListener(this);
		window.pack();
	}
	
	public Pixel[][] getArray() {
	return gp.pixel;
	}
	
	
	public static void main(String[] args) {
		new PixelArtMaker().start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		gp.setColor(csp.getSelectedColor());
		System.out.println(csp.getSelectedColor());
		gp.clickPixel(e.getX(), e.getY());
		gp.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	private static void save(GridPanel gp) {
		try (FileOutputStream fos = new FileOutputStream(new File("src/_05_Pixel_Art_Save_State/Pixel.txt")); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(gp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(saveButton)) {
			save(gp);
			
		}
	}
}
