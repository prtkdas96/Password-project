import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ActionProgram extends JFrame
{
    
    JTextArea area;
    JLabel instructions;
    JLabel question;
    JLabel ask;
    JButton submitt;
    JScrollPane sp;
    final int INPUTS = 2;  
    int quizCounter = 0;
    String[] quizQuestions;

   
    public ActionProgram() {
        
        setLayout(new FlowLayout());

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        setSize(800,400);

        
        area = new JTextArea(1,20);
        add(area);

        

        
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        
        submitt = new JButton("Submit");
        add(submitt);

        
        instructions = new JLabel("Input Data");
        add(instructions);

        
        quizQuestions = questions();

        question = new JLabel(quizQuestions[quizCounter]);
        add(question);

        
        ask = new JLabel("Please enter Submit when you have finished");
        add(ask);

        

        event action = new event();

        
        submitt.addActionListener(action);

    }


    
    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) 
        {
            
            if (e.getSource() == submitt) {
                String text = area.getText();
                System.out.println(text);
                dispose();

                quizCounter++;

                if (quizCounter < INPUTS ) {
                    quizQuestions = questions();
                    area.setText("");
                    question.setText(quizQuestions[quizCounter]);
                    setVisible(true);
                } else {
                    System.exit(0);
                }
            }       
        }
    }

    public String[] questions() 
	{

        String[] newQuestion = new String[INPUTS];
        switch(quizCounter) 
		{
        case 0:
            newQuestion[0] = "Enter your SAP_ID";
            break;
        case 1:
            newQuestion[1] = "Enter the last 4 digits of mob_no";
            break;
        }
		return (newQuestion);
         
    }


    public static void main(String[] args) {
       
        ActionProgram display = new ActionProgram();

        
        display.setVisible(true);

    }

}
