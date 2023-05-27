package adminis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class Abonne extends JFrame implements ActionListener {
	JLabel lb1,lb2,lb3,lb4,lb5,lbtitre;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7,blivre,bpret;
	ResultSet rst;
	Statement st;
	Connec cn=new Connec();
	JTable jt;
	JScrollPane js;
	
	public Abonne(){
		ImageIcon icon3 = new ImageIcon("book.png");
		this.setIconImage(icon3.getImage());
		this.setTitle("My Library");
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		pn.setBackground(new Color(247, 244, 234));
		add(pn);
		
		
		//titre
		lbtitre=new JLabel("Subscribers Registration");
		lbtitre.setBounds(155,15,420,45);
		lbtitre.setFont(new Font("Akaya Kanadaka",Font.BOLD,35));
		lbtitre.setForeground(new Color(142, 154, 175));
		pn.add(lbtitre);
		
		//label
		lb1=new JLabel("ID");
		lb1.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		lb1.setBounds(400,70,150,30);
		pn.add(lb1);
		tf1=new JTextField();
		tf1.setBounds(470,70,150,30);
		tf1.setBackground(new Color(247, 244, 234));
		pn.add(tf1);
		//
		lb2=new JLabel("Name");
		lb2.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		lb2.setBounds(400,110,100,30);
		lb2.setBackground(new Color(247, 244, 234));
		pn.add(lb2);
		
		tf2=new JTextField();
		tf2.setBounds(470,110,150,30);
		tf2.setBackground(new Color(247, 244, 234));
		pn.add(tf2);
		//
		
		
		
		pn.add(tf2);
		//button
		Icon icon1 = new ImageIcon("insert.png");
		Image scaledImage1 = ((ImageIcon) icon1).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
		bt1=new JButton(scaledIcon1);
		bt1.setBounds(620,110,50,30);
		bt1.addActionListener(this);
		bt1.setBackground(new Color(142, 154, 175));
		bt1.setForeground(new Color(255, 255, 255));
		pn.add(bt1);
		
		Icon icon2 = new ImageIcon("delete.png");
		Image scaledImage2 = ((ImageIcon) icon2).getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
		bt2=new JButton("Delete",scaledIcon2);
		bt2.setFont(new Font("Akaya Kanadaka",Font.ITALIC,18));
		bt2.setBounds(420,190,110,30);
		bt2.setBackground(new Color(142, 154, 175));
		bt2.addActionListener(this);
		pn.add(bt2);
		
		Icon icon = new ImageIcon("transparency.png");
		Image scaledImage = ((ImageIcon) icon).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
		bt4=new JButton(scaledIcon);
		bt4.setBounds(620,70,50,30);
		bt4.addActionListener(this);
		bt4.setBackground(new Color(142, 154, 175));
		pn.add(bt4);
		
		bt3=new JButton("Requests");
		bt3.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		bt3.setBounds(550,300,110,30);
		bt3.addActionListener(this);
		bt3.setBackground(new Color(142, 154, 175));
		pn.add(bt3);
		
		bt5=new JButton("Refresh");
		bt5.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		bt5.setBounds(550,340,110,30);
		bt5.addActionListener(this);
		bt5.setBackground(new Color(142, 154, 175));
		pn.add(bt5);
		
		
		
        
		Icon icon4 = new ImageIcon("editing.png");
		Image scaledImage4 = ((ImageIcon) icon4).getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
		bt6=new JButton("Edit",scaledIcon4);
		bt6.setFont(new Font("Akaya Kanadaka",Font.ITALIC,18));
		bt6.setBounds(550,190,110,30);
		bt6.addActionListener(this);
		bt6.setBackground(new Color(142, 154, 175));
		pn.add(bt6);

		Icon icon6 = new ImageIcon("log-out.png");
		Image scaledImage6 = ((ImageIcon) icon6).getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);
		bt7=new JButton("Log out",scaledIcon6);
		bt7.setFont(new Font("Akaya Kanadaka",Font.ITALIC,16));
		bt7.setBounds(25,400,110,30);
		bt7.addActionListener(this);
		bt7.setBackground(new Color(142, 154, 175));
		pn.add(bt7);
		
		blivre=new JButton("All Books");
		blivre.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		blivre.setBounds(420,340,110,30);
		blivre.addActionListener(this);
		blivre.setBackground(new Color(142, 154, 175));
		pn.add(blivre);
		
		bpret=new JButton("Borrow");
		bpret.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		bpret.setBounds(420,300,110,30);
		bpret.addActionListener(this);
		bpret.setBackground(new Color(142, 154, 175));
		pn.add(bpret);
		
		
		DefaultTableModel df=new DefaultTableModel();
		init();
		df.addColumn("ID");
		df.addColumn("FIRST & LAST NAME");
		jt.setModel(df);
		jt.setBackground(new Color(247, 244, 234));
		pn.add(js);
		
		String rq="select * from abonne";
		try{
			st=cn.connecion().createStatement();
			rst=st.executeQuery(rq);
			while(rst.next()){
				df.addRow(new Object[]{
						rst.getString("idab"),rst.getString("nomab")
				});
				
			}
		}
		catch(SQLException ex){
			
		}
	}
	public void init(){
		jt=new JTable();
		js=new JScrollPane();
		jt.setOpaque(false);
		jt.setBackground(new Color(247, 244, 234));
		js.setViewportView(jt);
		js.setBounds(25,70,350,300);
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
    Abonne ab=new Abonne();
    ab.setVisible(true);
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//ajout
		if(e.getSource()==bt1){
		String a,b;
		a=tf1.getText();b=tf2.getText();
		String qr="insert into abonne values('"+a+"','"+b+"')";
		try{
			st=cn.connecion().createStatement();
			if(JOptionPane.showConfirmDialog(this,"Would you like to insert?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				st.executeUpdate(qr);
				JOptionPane.showMessageDialog(this,"Successfully inserted!");
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(this,"Error,cannot insert!",null,JOptionPane.ERROR_MESSAGE);
		}
			
		}
		if(e.getSource()==bt2){
			String a;
			a=tf1.getText();
			String qr="delete from abonne where idab='"+a+"'";
			try{
				st=cn.connecion().createStatement();
				if(JOptionPane.showConfirmDialog(this,"Would you like to delete ?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					st.executeUpdate(qr);
					JOptionPane.showMessageDialog(this,"Successfully deleted!");
				}
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,"Error,cannot delete!",null,JOptionPane.ERROR_MESSAGE);
			}
		}
		//rech
      if(e.getSource()==bt4){
    	  String a;
			a=tf1.getText();
			String qr="select * from abonne where idab='"+a+"'";
			try{
				st=cn.connecion().createStatement();
				rst=st.executeQuery(qr);
				if(rst.next()){
					tf2.setText(rst.getString("nomab"));
				}
				else
					JOptionPane.showMessageDialog(this,"Not found!",null,JOptionPane.ERROR_MESSAGE);
			}
			catch(SQLException ex){
			
			}
    	  
      }
		if(e.getSource()==bt3){
			dispose();
			Requete rq=new Requete();
			rq.setVisible(true);
			
		}
		if(e.getSource()==bt5){
			dispose();
			Abonne ab=new Abonne();
			ab.setVisible(true);
			
			
		}
		//modification
		if(e.getSource()==bt6){
			String a,b;
			a=tf1.getText();b=tf2.getText();
			String qr="update abonne set nomab='"+b+"' where idab='"+a+"'";
			try{
				st=cn.connecion().createStatement();
				if(JOptionPane.showConfirmDialog(this,"Would you like to edit?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					st.executeUpdate(qr);
					JOptionPane.showMessageDialog(this,"successfully edited!");
				}
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,"Error,cannot edit!",null,JOptionPane.ERROR_MESSAGE);
			}
				
			}
			if(e.getSource()==bt7){
				dispose();
				Authentification auth=new Authentification();
				auth.setVisible(true);
				
			}
		if(e.getSource()==blivre){
				dispose();
				Livre lv=new Livre();
				lv.setVisible(true);	
			}
		//emprunt
		if(e.getSource()==bpret){
			dispose();
			Emprunt ep=new Emprunt();
			ep.setVisible(true);	
		}
	}

}
