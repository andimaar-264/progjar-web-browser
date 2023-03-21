// Java Program that creates the file with the method
// actionPerformed(ActionEvent o) of ActionListener

// Importing awt module and Swing class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.net.Socket;
import java.io.*;

// Class
// An action listener that prints a message
// 
public class actionperformclass
	extends main1 implements ActionListener {

	// Method
	// Will show a webpage
	public void actionPerformed(ActionEvent event)
	{
		String copystr = new String(" ");
		// String responses = new String();

		try {

        } catch (IOException ex) {
            // Logger.getLogger(StreamTest.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
        }


		// settext bottom label to the submitted text
		label1.setText(textfield.getText());
		
		// settext of textfield object of Jtextfield
		textfield.setText(copystr);
		

		
	}



}
