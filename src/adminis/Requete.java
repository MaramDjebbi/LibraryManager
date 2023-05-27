package adminis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import conn.Connec;

import java.sql.*;

public class Requete extends JFrame implements ActionListener {
	JLabel lb1,lb2,lb3,lb4,lb5,lb6;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JButton bt1,bt2,bt3,bt4,bt5,bt7;
	ResultSet rst;
	Statement st;
	JTable tb,tb2,tb3;
	JScrollPane js,js2,js3;
	JComboBox jcb1,jcb2,jcb3;
	
	Connec cn=new Connec();
	
	public Requete(){
		ImageIcon icon3 = new ImageIcon("book.png");
		this.setIconImage(icon3.getImage());
		this.setTitle("My Library");
		
		this.setSize(640,640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(247, 244, 234));
		add(pn);
		//lb
		lb1=new JLabel("Borrowed Books");
		lb1.setBounds(200,10,300,45);
		lb1.setFont(new Font("Akaya Kanadaka",Font.BOLD,35));
		lb1.setForeground(new Color(142, 154, 175));
	
		pn.add(lb1);
		
		jcb1=new JComboBox();
		jcb1.addItem("");
		jcb1.setBounds(20,70,160,25);
		jcb1.setBackground(new Color(247, 244, 234));

		String kk5="select titre from livre";
try{
	st=cn.connecion().createStatement();
	rst=st.executeQuery(kk5);
	while(rst.next()){
	jcb1.addItem(rst.getString("titre"));
	jcb1.setBackground(new Color(247, 244, 234));

	}
}
catch(SQLException ex){
	
}
		pn.add(jcb1);
		jcb2=new JComboBox();
		jcb2.setBackground(new Color(247, 244, 234));
		jcb2.addItem("");
		jcb2.setBounds(200,70,170,25);
	
		String kk6="select nomab from abonne";
try{
	st=cn.connecion().createStatement();
	rst=st.executeQuery(kk6);
	while(rst.next()){
	jcb2.addItem(rst.getString("nomab"));
	jcb2.setBackground(new Color(247, 244, 234));

	}
}
catch(SQLException ex){
	
}
		pn.add(jcb2);
		//button
				Icon icon = new ImageIcon("transparency.png");
				Image scaledImage = ((ImageIcon) icon).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				ImageIcon scaledIcon = new ImageIcon(scaledImage);
				bt1=new JButton(scaledIcon);
				bt1.setBounds(400,70,25,25);
				bt1.setBackground(new Color(142, 154, 175));
				bt1.addActionListener(this);
				pn.add(bt1);
	
				lb2=new JLabel("Available Books");
				lb2.setBounds(200,320,300,45);
				lb2.setFont(new Font("Akaya Kanadaka",Font.BOLD,35));
				lb2.setForeground(new Color(142, 154, 175));
				pn.add(lb2);
		
				jcb3=new JComboBox();
				jcb2.addItem("");
				jcb3.setBackground(new Color(247, 244, 234));
				jcb3.setBounds(20,380,160,25);
				String kk7="select titre from livre";
		try{
			st=cn.connecion().createStatement();
			rst=st.executeQuery(kk7);
			while(rst.next()){
			jcb3.addItem(rst.getString("titre"));

			}
		}
		catch(SQLException ex){
			
		}
				pn.add(jcb3);
		//bt
		bt2=new JButton("Verify");
		bt2.setBounds(210,380,100,25);
		bt2.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		bt2.addActionListener(this);
		bt2.setBackground(new Color(142, 154, 175));
		pn.add(bt2);
		//bt
		bt3=new JButton("Subscriber");
		bt3.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		bt3.setBounds(50,550,100,25);
		bt3.addActionListener(this);
		bt3.setBackground(new Color(142, 154, 175));
		pn.add(bt3);
		
		bt4=new JButton("Borrow");
		bt4.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		bt4.setBounds(180,550,100,25);
		bt4.addActionListener(this);
		bt4.setBackground(new Color(142, 154, 175));
		pn.add(bt4);
	
		bt5=new JButton("Books");
		bt5.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		bt5.setBounds(300,550,100,25);
		bt5.addActionListener(this);
		bt5.setBackground(new Color(142, 154, 175));
		pn.add(bt5);
				
				Icon icon6 = new ImageIcon("log-out.png");
				Image scaledImage6 = ((ImageIcon) icon6).getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
				ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);
				bt7=new JButton("Log out",scaledIcon6);
				bt7.setFont(new Font("Akaya Kanadaka",Font.ITALIC,18));
				bt7.setBounds(500,550,110,30);
				bt7.addActionListener(this);
				bt7.setBackground(new Color(142, 154, 175));
				pn.add(bt7);


		DefaultTableModel df=new DefaultTableModel();
		init();
		df.addColumn("Book_ID");
		df.addColumn("Book_Title");
		df.addColumn("Borrower_Name");
		df.addColumn("Borrower_ID");
		tb.setModel(df);
		tb.setBackground(new Color(247, 244, 234));
		pn.add(js);
		String qr="select * from abonne inner join livre on abonne.idab=livre.idabonne";
		try{
			st=cn.connecion().createStatement();
			rst=st.executeQuery(qr);
			while(rst.next()){
			df.addRow(new Object[]{
					rst.getString("idlivre"),rst.getString("titre"),rst.getString("nomab"),rst.getString("idab")
			});	
			}
		}
		catch(SQLException ex){
			
		}
		
		DefaultTableModel df2=new DefaultTableModel();
		init2();
		df2.addColumn("Book_ID");
		df2.addColumn("Book_Title");
		df2.addColumn("Borrower");
		tb2.setModel(df2);
		tb2.setBackground(new Color(247, 244, 234));
		
		pn.add(js2);
		
		DefaultTableModel df3=new DefaultTableModel();
		init3();
		df3.addColumn("Book_ID");
		df3.addColumn("Book_Title");
		tb3.setModel(df3);
		tb3.setBackground(new Color(247, 244, 234));
		pn.add(js3);
		String qr3="select idlivre,titre from livre where disponible='OUI'";
		try{
			st=cn.connecion().createStatement();
			rst=st.executeQuery(qr3);
			while(rst.next()){
			df3.addRow(new Object[]{
					rst.getString("idlivre"),rst.getString("titre")
			});	
			}
		}
		catch(SQLException ex){
			
		}
	}
	
	public void init(){
		tb=new JTable();
		js=new JScrollPane();
		js.setBounds(10,215,600,100);
		js.setViewportView(tb);
	}
	//init2
	public void init2(){
		tb2=new JTable();
		js2=new JScrollPane();
		js2.setBounds(10,115,600,80);
		js2.setViewportView(tb2);
	}
	//init3
		public void init3(){
			tb3=new JTable();
			js3=new JScrollPane();
			js3.setBounds(10,420,600,100);
			js3.setViewportView(tb3);
		}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
    Requete rq=new Requete();
    rq.setVisible(true);
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1){
		String b,c;
		b=jcb1.getSelectedItem().toString();
		c=jcb2.getSelectedItem().toString();
		String qr="select * from pret where titre='"+b+"' or nomab='"+c+"'";
		
				DefaultTableModel df2=new DefaultTableModel();
				df2.addColumn("Book_ID");
				df2.addColumn("Book_Title");
				df2.addColumn("Borrower");
				tb2.setModel(df2);
		try{
			st=cn.connecion().createStatement();
			rst=st.executeQuery(qr);
			while(rst.next()){
			df2.addRow(new Object[]{
					rst.getString("idlivre"),rst.getString("titre"),rst.getString("nomab")
			});	
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(this,"Error, cannot insert!",null,JOptionPane.ERROR_MESSAGE);
		}
			
		}
		if(e.getSource()==bt2){
			String a=jcb3.getSelectedItem().toString();
		  Verification vf=new Verification();
			if(vf.verifier(a)==true){
				JOptionPane.showMessageDialog(this,"AVAILABLE");
			}
			else
				JOptionPane.showMessageDialog(this,"NOT AVAILABLE",null,JOptionPane.ERROR_MESSAGE);
			
		}
		if(e.getSource()==bt7){
			dispose();
			Authentification auth=new Authentification();
			auth.setVisible(true);
			
		}
		//abonne
		if(e.getSource()==bt3){
			dispose();
			Abonne ab=new Abonne();
			ab.setVisible(true);
			
		}
		//emprunt
		if(e.getSource()==bt4){
			dispose();
			Emprunt ep=new Emprunt();
			ep.setVisible(true);
			
		}
		//livre
		if(e.getSource()==bt5){
			dispose();
			Livre lv=new Livre();
			lv.setVisible(true);
	}
	}
	}
