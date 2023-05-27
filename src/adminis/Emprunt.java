package adminis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import conn.Connec;
public class Emprunt extends JFrame implements ActionListener {
	java.sql.Statement st;
	ResultSet rst;
	Connec cn=new Connec();
	JComboBox jcb,jcb2;
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
	JTextField tf1,tf5,tf6,tf7;
	JButton jb,jb2,bt3,blivre,babonne,bt7;
	public Emprunt(){
		ImageIcon icon3 = new ImageIcon("pics/book.png");
		this.setIconImage(icon3.getImage());
		this.setTitle("My Library");
		this.setSize(500,650);
		this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(247, 244, 234));
		add(pn);
		
		
		lb3=new JLabel("Borrow a Book");
		lb3.setBounds(140,40,300,45);
		lb3.setForeground(new Color(142, 154, 175));
		lb3.setFont(new Font("Akaya Kanadaka",Font.BOLD,35));
		pn.add(lb3);
				
		
		lb1=new JLabel("Subscriber_ID");
		lb1.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		lb1.setBounds(20,100,130,25);
		lb1.setBackground(new Color(142, 154, 175));
		pn.add(lb1);

		 tf1=new JTextField();
		 tf1.setBounds(150,100,130,25);
		 tf1.setBackground(new Color(247, 244, 234));
		pn.add(tf1);
		
		lb2=new JLabel("Book");
		lb2.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		lb2.setBounds(40,140,130,25);
		pn.add(lb2);
		
		
		jcb=new JComboBox();
		jcb.setBounds(150,140,220,25);
		jcb.setBackground(new Color(247, 244, 234));
		//ajout des titres des livres au combo livres
		String kk4="select titre from livre";
try{
	st=cn.connecion().createStatement();
	rst=st.executeQuery(kk4);
	while(rst.next()){
	jcb.addItem(rst.getString("titre"));

	}
}
catch(SQLException ex){
	
}
		pn.add(jcb);
		/*combonom2 =new JComboBox();
		combonom2.setBounds(150,110,120,25);
		
		pn.add(combonom2);*/
		//button
		jb=new JButton("Submit");
		jb.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		jb.setBounds(160,200,100,25);
		jb.setBackground(new Color(142, 154, 175));
		jb.addActionListener(this);
		pn.add(jb);
		//retour
		//
		lb4=new JLabel("Return a Book");
		lb4.setBounds(140,260,300,45);
		lb4.setForeground(new Color(142, 154, 175));
		lb4.setFont(new Font("Akaya Kanadaka",Font.BOLD,35));
		pn.add(lb4);
		
		lb5=new JLabel("Subscriber_ID");
		lb5.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		lb5.setBounds(20,320,130,25);
		pn.add(lb5);
		 tf5=new JTextField();
		 tf5.setBounds(150,320,130,25);
		 tf5.setBackground(new Color(247, 244, 234));
		pn.add(tf5);
		//livre
		lb6=new JLabel("Book");
		lb6.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		lb6.setBounds(40,360,130,25);
		
		pn.add(lb6);
		//combo
		jcb2=new JComboBox();
		jcb2.setBounds(150,360,220,25);
		jcb2.setBackground(new Color(247, 244, 234));
		
		Icon icon6 = new ImageIcon("pics/log-out.png");
		Image scaledImage6 = ((ImageIcon) icon6).getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);
		bt7=new JButton("Log out",scaledIcon6);
		bt7.setFont(new Font("Akaya Kanadaka",Font.ITALIC,16));
		bt7.setBounds(360,550,110,30);
		bt7.addActionListener(this);
		bt7.setBackground(new Color(142, 154, 175));
		pn.add(bt7);
		
		String kk5="select titre from livre";
try{
	st=cn.connecion().createStatement();
	rst=st.executeQuery(kk5);
	while(rst.next()){
	jcb2.addItem(rst.getString("titre"));

	}
}
catch(SQLException ex){
	
}
		pn.add(jcb2);
		//button
				jb2=new JButton("Submit");
				jb2.setBounds(160,410,100,25);
				jb2.setBackground(new Color(142, 154, 175));
				jb2.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
				jb2.addActionListener(this);
				pn.add(jb2);
		//bouton 
				bt3=new JButton("Requests");
				bt3.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
				bt3.setBounds(50,480,110,30);
				bt3.setBackground(new Color(142, 154, 175));
				bt3.addActionListener(this);
				pn.add(bt3);
		//bouton livre
				blivre=new JButton("Books");
				blivre.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
				blivre.setBounds(175,480,110,30);
				blivre.setBackground(new Color(142, 154, 175));
				blivre.addActionListener(this);
				pn.add(blivre);
	 //bouton 
				babonne=new JButton("Subscribers");
				babonne.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
				babonne.setBounds(300,480,110,30);
				babonne.setBackground(new Color(142, 154, 175));
				babonne.addActionListener(this);
				pn.add(babonne);
				
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emprunt ep=new Emprunt();
		ep.setVisible(true);

	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb){
			String a,b;
			a=tf1.getText();b=jcb.getSelectedItem().toString();
			String qr="update livre set disponible='NON',idabonne='"+a+"' where titre='"+b+"'";
			try{
				st=cn.connecion().createStatement();
				if(JOptionPane.showConfirmDialog(this,"Would you like to submit?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					st.executeUpdate(qr);
					JOptionPane.showMessageDialog(this,"Success!");
				}
				
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,"Error!",null,JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==jb2){
			String a,b;
			a=tf5.getText();
			b=jcb2.getSelectedItem().toString();
			String qr="update livre set disponible='OUI',idabonne=NULL where idabonne='"+a+"' and titre='"+b+"'";
			try{
				st=cn.connecion().createStatement();
				if(JOptionPane.showConfirmDialog(this,"Would you like to submit?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					st.executeUpdate(qr);
					JOptionPane.showMessageDialog(this,"Success!");
				}
				
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,"Error!",null,JOptionPane.ERROR_MESSAGE);
			}
			
		}
		//requetes
		if(e.getSource()==bt3){
			dispose();
			Requete rq=new Requete();
			rq.setVisible(true);
			
		}
		if(e.getSource()==bt7){
			dispose();
			Authentification auth=new Authentification();
			auth.setVisible(true);
			
		}
		//livres
		if(e.getSource()==blivre){
			dispose();
			Livre lv=new Livre();
			lv.setVisible(true);
			
		}
		//abonnes
		if(e.getSource()==babonne){
			dispose();
			Abonne ab=new Abonne();
			ab.setVisible(true);
			
		}
		//
		
	}

}
