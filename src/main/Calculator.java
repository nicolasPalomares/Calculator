package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.lang.Math;

public class Calculator {
	
	private JFrame frame;
	private JPanel p1, p2, p3, p4;
	private JLabel l1, l2, l3;
	private JTextField tfFirst;
	private JTextField tfSecond;
	private JTextField tfResult;
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;
	private ImageIcon img;
	private JDialog about;
	private JDialog howToUse;
	
	public Calculator() {
		frame = new JFrame("Calculator");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		l1 = new JLabel("1st: ");
		l2 = new JLabel("2nd: ");
		l3 = new JLabel("Result: ");
		tfFirst = new JTextField("0.0", 15);
		tfSecond = new JTextField("0.0", 15);
		tfResult = new JTextField("0.0", 15);
		b1 = new JButton("+");
		b2 = new JButton("-");
		b3 = new JButton("*");
		b4 = new JButton("/");
		b5 = new JButton("sq.");
		b6 = new JButton("cb.");
		b7 = new JButton("sqrt.");
		b8 = new JButton("cbrt.");
		b9 = new JButton("pct.");
		b10 = new JButton("%");
		b11 = new JButton("Clear");
		img = new ImageIcon("F:\\Descargas\\Eclipse Workshop\\src\\calc.png");
	}
	
	// Creating the frame:
	
	public void runFrame() {
		frame.setLayout(new GridLayout(4, 1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1.add(l1);
		p1.add(tfFirst);
		p2.add(l2);
		p2.add(tfSecond);
		p3.add(l3);
		p3.add(tfResult);
		p4.setLayout(new FlowLayout());
		p4.add(b1);
		p4.add(b2);
		p4.add(b3);
		p4.add(b4);
		p4.add(b5);
		p4.add(b6);
		p4.add(b7);
		p4.add(b8);
		p4.add(b9);
		p4.add(b10);
		p4.add(b11);
		
		b1.setForeground(Color.BLACK);
		b2.setForeground(Color.BLACK);
		b3.setForeground(Color.BLACK);
		b4.setForeground(Color.BLACK);
		b5.setForeground(Color.BLACK);
		b6.setForeground(Color.BLACK);
		b7.setForeground(Color.BLACK);
		b8.setForeground(Color.BLACK);
		b9.setForeground(Color.BLACK);
		b10.setForeground(Color.BLACK);
		b11.setForeground(Color.BLACK);
		b1.setFont(new Font("Arial", Font.PLAIN, 20));
		b2.setFont(new Font("Arial", Font.PLAIN, 20));
		b3.setFont(new Font("Arial", Font.PLAIN, 20));
		b4.setFont(new Font("Arial", Font.PLAIN, 20));
		b5.setFont(new Font("Arial", Font.PLAIN, 20));
		b6.setFont(new Font("Arial", Font.PLAIN, 20));
		b7.setFont(new Font("Arial", Font.PLAIN, 20));
		b8.setFont(new Font("Arial", Font.PLAIN, 20));
		b9.setFont(new Font("Arial", Font.PLAIN, 20));
		b10.setFont(new Font("Arial", Font.PLAIN, 20));
		b11.setFont(new Font("Arial", Font.PLAIN, 20));
		b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		b3.setBackground(Color.white);
		b4.setBackground(Color.white);
		b5.setBackground(Color.white);
		b6.setBackground(Color.white);
		b7.setBackground(Color.white);
		b8.setBackground(Color.white);
		b9.setBackground(Color.white);
		b10.setBackground(Color.white);
		b11.setBackground(Color.white);
		
		b1.setFocusPainted(false);
		b2.setFocusPainted(false);
		b3.setFocusPainted(false);
		b4.setFocusPainted(false);
		b5.setFocusPainted(false);
		b6.setFocusPainted(false);
		b7.setFocusPainted(false);
		b8.setFocusPainted(false);
		b9.setFocusPainted(false);
		b10.setFocusPainted(false);
		b11.setFocusPainted(false);
		
		b1.addActionListener(new OperationHandler());
		b2.addActionListener(new OperationHandler());
		b3.addActionListener(new OperationHandler());
		b4.addActionListener(new OperationHandler());
		b5.addActionListener(new OperationHandler());
		b6.addActionListener(new OperationHandler());
		b7.addActionListener(new OperationHandler());
		b8.addActionListener(new OperationHandler());
		b9.addActionListener(new OperationHandler());
		b10.addActionListener(new OperationHandler());
		b11.addActionListener(new OperationHandler());
		
		JMenuBar mb = new JMenuBar();
		JMenu help = new JMenu("Help");
		JMenuItem i1  = new JMenuItem("How to use");
		JMenuItem i2 = new JMenuItem("About this program");
		i2.addActionListener(new AboutHandler());
		i1.addActionListener(new HowToUseHandler());
		
		mb.add(help);
		help.add(i2);
		help.add(i1);
		
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(p4);
		frame.setJMenuBar(mb);
		frame.setBackground(Color.DARK_GRAY);
		frame.setIconImage(img.getImage());
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	// Creating the listeners and handlers:
	
	private class AboutHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(about == null) {
				about = new AboutDialog(frame, "About this program", true);
			}
			about.setVisible(true);
		}
	}
	
	private class HowToUseHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(howToUse == null) {
				howToUse = new HowToUseDialog(frame, "How to use", true);
			}
			howToUse.setVisible(true);
		}
	}
	
	private class AboutDialog extends JDialog implements ActionListener {
		private static final long serialVersionUID = 1L;

		public AboutDialog(Frame owner, String title, boolean modal) {
			super(owner, title, modal);
			add(new JLabel("<html>Calculator is a Java program for simple operations. Here is the list of what you can do: "
					+ "<br/><br/>.Additions<br/>.Subtractions<br/>.Multiplications<br/>.Divisions<br/>.Square<br/>.Cube<br/>"
					+ ".Square root<br/>.Cube root<br/>.Percentage<br/>.Division remainder<br/><br/>"
					+ "For information about the use of the program, please visit the -How to use- menu.</html>"), BorderLayout.NORTH);
			JButton ok = new JButton("Ok");
			ok.setFocusPainted(false);
			add(ok, BorderLayout.SOUTH);
			ok.addActionListener(this);
			pack();
		}

		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
	
	private class HowToUseDialog extends JDialog implements ActionListener {
		private static final long serialVersionUID = 1L;

		public HowToUseDialog(Frame owner, String title, boolean modal) {
			super(owner, title, modal);
			add(new JLabel("<html>You need to type two numbers. The second number is "
					+ "the second operand (and the divisor).<br/>For the operations with only one operand you only use "
					+ "the first number.<br/>Use CLEAR to reset.<br/>For the pct. "
					+ "operation, the second number is the percentage value.</html>"), BorderLayout.NORTH);
			JButton ok = new JButton("Ok");
			ok.setFocusPainted(false);
			add(ok, BorderLayout.SOUTH);
			ok.addActionListener(this);
			pack();
		}

		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
	
	private class OperationHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			double numFirst, numSecond, numResult = 0.0;
			
			if(tfFirst.getText() != null && tfSecond.getText() != null) {
				numFirst = Double.parseDouble(tfFirst.getText());
				numSecond = Double.parseDouble(tfSecond.getText());
				
				if(source == b1) {
					numResult = numFirst + numSecond;
				}
				else if(source == b2) {
					numResult = numFirst - numSecond;
				}
				else if(source == b3) {
					numResult = numFirst * numSecond;
				}
				else if(source == b4) {
					numResult = numFirst / numSecond;
				}
				else if(source == b5) {
					numResult = numFirst * numFirst;
					tfSecond.setText("0.0");
				}
				else if(source == b6) {
					numResult = (numFirst * numFirst) * numFirst;
					tfSecond.setText("0.0");
				}
				else if(source == b7) {
					numResult = Math.sqrt(numFirst);
					tfSecond.setText("0.0");
				}
				else if(source == b8) {
					numResult = Math.cbrt(numFirst);
					tfSecond.setText("0.0");
				}
				else if(source == b9) {
					numResult = (numFirst * numSecond) / 100;
				}
				else if(source == b10) {
					numResult = numFirst % numSecond;
				}
				else if(source == b11) {
					tfFirst.setText("0.0");
					tfSecond.setText("0.0");
					tfSecond.setEnabled(true);
					tfResult.setText("0.0");
				}
				tfResult.setText("" + numResult);
			}
		}
	}
	
	// Running the frame:

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.runFrame();
	}

}
