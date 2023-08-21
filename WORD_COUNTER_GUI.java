import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WORD_COUNTER_GUI extends JFrame {
	private JLabel label,titlelabel;
	private JTextArea textarea;
	private JButton count;
	
	public WORD_COUNTER_GUI() {
		 setTitle("WORD COUNTER");
		    titlelabel=new JLabel("WORD COUNTER");
	        titlelabel.setFont(new Font("times new roman",Font.BOLD,24));
	        titlelabel.setForeground(Color.BLACK);
	        titlelabel.setSize(270,20);
	        titlelabel.setLocation(100,25);
	        
		 label=new JLabel("Total number of words: ");
		 label.setBounds(50,60,300,40);
		 
		 textarea=new JTextArea();
		 textarea.setBounds(50,110,300,200);
		 
		 count=new JButton("Count");
		 count.setBounds(50,320,80,30);
		 count.addActionListener(new ActionListener() {
				 @Override
				 public void actionPerformed(ActionEvent e) {
			 String text=textarea.getText();
			 int wordCount=countWords(text);
			 label.setText("Total number of words: "+wordCount);
		 }
		 });
		 add(label);
		  add(textarea);
		  add(count);
		  add(titlelabel);
		  setSize(400,400);
		  setLayout(null);
		  setDefaultCloseOperation(EXIT_ON_CLOSE);
		  setVisible(true);
		  
	}
	
		 private int countWords(String text) {
			 String words[]=text.split("\\s+");
			 return words.length;
		 }
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new WORD_COUNTER_GUI();
			}
		});
			
	}
}