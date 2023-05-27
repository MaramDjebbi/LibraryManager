package adminis;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import conn.Connec;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Authentification extends JFrame implements ActionListener {
	java.sql.Statement st;
	ResultSet rst;
	Connec cn=new Connec();
	JLabel lb1,lb2,lb3;
	JTextField tf1,tf2;
	JButton jb;
	
	public Authentification(){
		ImageIcon icon3 = new ImageIcon("book.png");
		this.setIconImage(icon3.getImage());
		this.setTitle("My Library");
		this.setSize(400,500);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(247, 244, 234));
		add(pn);
		
		//label
		lb3=new JLabel("Welcome To Our Library");
		lb3.setBounds(50,35,350,35);
		lb3.setFont(new Font("Akaya Kanadaka",Font.BOLD, 30));
		lb3.setForeground(new Color(142, 154, 175));
		pn.add(lb3);
				
		
		lb1=new JLabel("Login");
		lb1.setBounds(80,130,130,25);
		lb1.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		pn.add(lb1);
		tf1=new JTextField();
		tf1.setBounds(170,130,130,25);
		tf1.setBackground(new Color(247, 244, 234));
		pn.add(tf1);
		

		lb2=new JLabel("Password");
		lb2.setBounds(80,180,130,25);
		lb2.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		
		pn.add(lb2);
		tf2=new JPasswordField();
		tf2.setBounds(170,180,130,25);
		tf2.setBackground(new Color(247, 244, 234));
		
		pn.add(tf2);
		
	
		//button
		Icon icon6 = new ImageIcon("log-in.png");
		Image scaledImage6 = ((ImageIcon) icon6).getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);
		jb=new JButton("Log in",scaledIcon6);
		jb.setBounds(140,250,110,30);
		jb.setFont(new Font("Akaya Kanadaka",Font.ITALIC,18));
		jb.addActionListener(this);
		jb.setBackground(new Color(142, 154, 175));
		pn.add(jb);
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Authentification au=new Authentification();
		au.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String username = tf1.getText();
        String passwordChars = tf2.getText();
		if(e.getSource()==jb){
			if(username.equals("maram") && passwordChars.equals("0000")) {
			Livre lv=new Livre();
			lv.setVisible(true);
			}
			else {
                JOptionPane.showMessageDialog(Authentification.this,
                        "Authentication failed!");
            }
		}
		}

}
