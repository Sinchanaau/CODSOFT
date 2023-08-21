import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.*;

public class NUMBER_GAME_GUI extends JFrame {
	JTextField guess,totalguess;
	ButtonListener buttonListener;
	ButtonListener2 buttonListener2;
	JLabel inputlabel,totalguesslabel,outputlabel,titlelabel;
	Random rd=new Random();
	int guessnumber=rd.nextInt(100)+1;
	int count=0;
	
	public NUMBER_GAME_GUI() {
		Container c=getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		titlelabel=new JLabel("NUMBER GUESSING GAME");
        titlelabel.setFont(new Font("times new roman",Font.BOLD,24));
        titlelabel.setForeground(Color.BLACK);
        titlelabel.setSize(350,20);
        titlelabel.setLocation(75,25);
		
		inputlabel=new JLabel("Enter a number between 1-100");
        inputlabel.setFont(new Font("times new roman",Font.PLAIN,14));
        inputlabel.setForeground(Color.BLUE);
        inputlabel.setSize(270,20);
        inputlabel.setLocation(70,90);
        
        outputlabel=new JLabel("Can you guess the number? Try it!");
        outputlabel.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        outputlabel.setSize(350,20);
        outputlabel.setLocation(70,160);
		
        guess = new JTextField(10);
        guess.setSize(50,30);
        guess.setLocation(140,120);
        
        totalguesslabel = new JLabel("Number of Guesses");
        totalguesslabel .setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        totalguesslabel.setSize(270,20);
        totalguesslabel.setLocation(125,200);
        
        totalguess = new JTextField(10);
        totalguess.setSize(30,20);
        totalguess.setLocation(80,200);
		
        JButton guessbutton =new JButton("Guess");
        guessbutton.setSize(100,30);
        guessbutton.setLocation(50,240);
        guessbutton.setBackground(Color.LIGHT_GRAY);
        buttonListener = new ButtonListener();
        guessbutton.addActionListener(buttonListener);
        
        JButton playagainbutton = new JButton("Play Again!");
        playagainbutton.setSize(100,30);
        playagainbutton.setLocation(170,240);
        playagainbutton.setBackground(Color.LIGHT_GRAY);
        buttonListener2 = new ButtonListener2();
        playagainbutton.addActionListener(buttonListener2);
        
        c.add(totalguesslabel);
        c.add(inputlabel);
        c.add(guess);
        c.add(outputlabel);
        c.add(guessbutton);
        c.add(playagainbutton);
        c.add(totalguess);
        c.add(titlelabel);

        totalguess.setEditable(false);
        setTitle("GUESS THE NUMBER");
        setSize(450,350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int i=Integer.parseInt(guess.getText());
			count=count+1;
			if(i<guessnumber) {
				outputlabel.setText(i+" is low");
			}
			else if(i>guessnumber) {
				outputlabel.setText(i+" is high");
			}
			else {
				outputlabel.setText("Congratulations! Your guess is correct, You won!");
			}
			guess.requestFocus();
			guess.selectAll();
			totalguess.setText(count+"");
		}
	}
	
	private class ButtonListener2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			    guessnumber=(int) (Math.random()*100);
	            guess.setText("");
	            totalguess.setText("");
	            outputlabel.setText("Can you guess the number? Try it!");
	            totalguess.setText("");
	            count=0;
	            guess.setEditable(true);
	            guess.requestFocus();
		}
	}

	public static void main(String[] args) {
		new NUMBER_GAME_GUI();

	}

}
