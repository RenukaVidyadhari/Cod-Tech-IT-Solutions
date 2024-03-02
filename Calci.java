import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calci implements ActionListener{
	
	JFrame frame;
	JTextField textfield;
	JButton[] numbtn = new JButton[10];
	JButton[] fnbtn = new JButton[9];
	JButton addBtn,subBtn,mulBtn,divBtn;
	JButton decBtn, equBtn, delBtn, clrBtn, negBtn;
	JPanel panel;
	
	Font myFont = new Font(" Free",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calci(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.BLACK);
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		addBtn = new JButton("+");
		subBtn = new JButton("-");
		mulBtn = new JButton("*");
		divBtn = new JButton("/");
		decBtn = new JButton(".");
		equBtn = new JButton("=");
		delBtn = new JButton("Del");
		clrBtn = new JButton("Clr");
		negBtn = new JButton("(-)");
		fnbtn[0] = addBtn;
		fnbtn[1] = subBtn;
		fnbtn[2] = mulBtn;
		fnbtn[3] = divBtn;
		fnbtn[4] = decBtn;
		fnbtn[5] = equBtn;
		fnbtn[6] = delBtn;
		fnbtn[7] = clrBtn;
		fnbtn[8] = negBtn;
		
		for(int i =0;i<9;i++) {
			fnbtn[i].addActionListener(this);
			fnbtn[i].setFont(myFont);
			fnbtn[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			numbtn[i] = new JButton(String.valueOf(i));
			numbtn[i].addActionListener(this);
			numbtn[i].setBackground(Color.decode("#696969"));
			numbtn[i].setFont(myFont);
			numbtn[i].setFocusable(false);
		}
		
		negBtn.setBounds(50,430,100,50);
		delBtn.setBounds(150,430,100,50);
		clrBtn.setBounds(250,430,100,50);
		
		addBtn.setBackground(Color.decode("#696969"));
		subBtn.setBackground(Color.decode("#696969"));
		mulBtn.setBackground(Color.decode("#696969"));
		divBtn.setBackground(Color.decode("#696969"));
		delBtn.setBackground(Color.decode("#FF6347"));
		clrBtn.setBackground(Color.decode("#FF6347"));
		negBtn.setBackground(Color.decode("#FF6347"));
		decBtn.setBackground(Color.decode("#696969"));
		equBtn.setBackground(Color.decode("#696969"));
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.black);
		panel.add(numbtn[1]);
		panel.add(numbtn[2]);
		panel.add(numbtn[3]);
		panel.add(addBtn);
		panel.add(numbtn[4]);
		panel.add(numbtn[5]);
		panel.add(numbtn[6]);
		panel.add(subBtn);
		panel.add(numbtn[7]);
		panel.add(numbtn[8]);
		panel.add(numbtn[9]);
		panel.add(mulBtn);
		panel.add(decBtn);
		panel.add(numbtn[0]);
		panel.add(equBtn);
		panel.add(divBtn);		
		
		frame.add(panel);
		frame.add(negBtn);
		frame.add(delBtn);
		frame.add(clrBtn);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numbtn[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decBtn) {
			textfield.setText(textfield.getText().concat("."));
		}
		else if(e.getSource()==addBtn) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		else if(e.getSource()==subBtn) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		else if(e.getSource()==mulBtn) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		else if(e.getSource()==divBtn) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		else if(e.getSource()==equBtn) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		else if(e.getSource()==clrBtn) {
			textfield.setText("");
		}
		else if(e.getSource()==delBtn) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		else if(e.getSource()==negBtn) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}

	public static void main(String[] args) {
		Calci cal=new Calci();
		
	}

}