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

public class Livre extends JFrame implements ActionListener {
	JLabel lb1,lb2,lb3,lb4,lb5,lbtitre;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7,babonne,bpret;
	ResultSet rst;
	Statement st;
	Connec cn=new Connec();
	JTable jt;
	JScrollPane js;
	
	public Livre(){
		ImageIcon icon3 = new ImageIcon("pics/book.png");
		this.setIconImage(icon3.getImage());
		this.setTitle("My Library");
		this.setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(247, 244, 234));
		add(pn);
		//titre
				lbtitre=new JLabel("Books Registration");
				lbtitre.setBounds(200,15,300,45);
				lbtitre.setFont(new Font("Akaya Kanadaka",Font.BOLD,35));
				lbtitre.setForeground(new Color(142, 154, 175));
				pn.add(lbtitre);
		//label
		lb1=new JLabel("ID");
		lb1.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		lb1.setBounds(30,70,150,30);
		lb1.setBackground(new Color(142, 154, 175));
		pn.add(lb1);
		tf1=new JTextField();
		tf1.setBounds(100,70,150,30);
		tf1.setBackground(new Color(247, 244, 234));
		pn.add(tf1);
		//
		lb2=new JLabel("Title");
		lb2.setBounds(30,110,100,30);
		lb2.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));

		pn.add(lb2);
		
		tf2=new JTextField();
		tf2.setBounds(100,110,150,30);
		tf2.setBackground(new Color(247, 244, 234));
		pn.add(tf2);
		//
		pn.add(tf2);
		//button
		Icon icon1 = new ImageIcon("pics/insert.png");
		Image scaledImage1 = ((ImageIcon) icon1).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
		bt1=new JButton(scaledIcon1);
		bt1.setBounds(250,110,50,30);
		bt1.setBackground(new Color(142, 154, 175));
		bt1.addActionListener(this);
		pn.add(bt1);
		
		Icon icon2 = new ImageIcon("pics/delete.png");
		Image scaledImage2 = ((ImageIcon) icon2).getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
		bt2=new JButton("Delete",scaledIcon2);
		bt2.setFont(new Font("Akaya Kanadaka",Font.ITALIC,18));
		bt2.setBounds(50,190,110,30);
		bt2.addActionListener(this);
		bt2.setBackground(new Color(142, 154, 175));
		pn.add(bt2);
		
		Icon icon = new ImageIcon("pics/transparency.png");
		Image scaledImage = ((ImageIcon) icon).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
		bt4=new JButton(scaledIcon);
		bt4.setBounds(250,70,50,30);
		bt4.addActionListener(this);
		bt4.setBackground(new Color(142, 154, 175));
		pn.add(bt4);
		
		bt3=new JButton("Requests");
		bt3.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		bt3.setBounds(50,300,110,30);
		bt3.addActionListener(this);
		bt3.setBackground(new Color(142, 154, 175));
		pn.add(bt3);
		
		Icon icon4 = new ImageIcon("pics/editing.png");
		Image scaledImage4 = ((ImageIcon) icon4).getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
		bt5=new JButton("Edit",scaledIcon4);
		bt5.setFont(new Font("Akaya Kanadaka",Font.ITALIC,18));
		bt5.setBounds(180,190,110,30);
		bt5.addActionListener(this);
		bt5.setBackground(new Color(142, 154, 175));
		pn.add(bt5);
		
		bt6=new JButton("Refresh");
		bt6.setBounds(50,340,110,30);
		bt6.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		bt6.addActionListener(this);
		bt6.setBackground(new Color(142, 154, 175));
		pn.add(bt6);
		
		babonne=new JButton("Subscribers");
		babonne.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		babonne.setBounds(180,340,110,30);
		babonne.addActionListener(this);
		babonne.setBackground(new Color(142, 154, 175));
		pn.add(babonne);
		
		bpret=new JButton("Borrow");
		bpret.setBounds(180,300,110,30);
		bpret.setFont(new Font("Akaya Kanadaka",Font.ITALIC,20));
		bpret.addActionListener(this);
		bpret.setBackground(new Color(142, 154, 175));
		pn.add(bpret);


		Icon icon6 = new ImageIcon("pics/log-out.png");
		Image scaledImage6 = ((ImageIcon) icon6).getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);
		bt7=new JButton("Log out",scaledIcon6);
		bt7.setFont(new Font("Akaya Kanadaka",Font.ITALIC,16));
		bt7.setBounds(575,400,110,30);
		bt7.addActionListener(this);
		bt7.setBackground(new Color(142, 154, 175));
		pn.add(bt7);
		
		DefaultTableModel df=new DefaultTableModel();
		init();
		df.addColumn("ID");
		df.addColumn("TITLE");
		
		jt.setModel(df);
		jt.setBackground(new Color(247, 244, 234));
		pn.add(js);
		
		String qr="select * from livre";
		
		try{
			st=cn.connecion().createStatement();
			rst=st.executeQuery(qr);
			while(rst.next()){
				df.addRow(new Object[]{
						rst.getString("idlivre"),rst.getString("titre")
				});
			}
			
		}
		catch(SQLException ex){
			
		}
		
	}
	public void init(){
		jt=new JTable();
		js=new JScrollPane();
		js.setViewportView(jt);
		js.setBounds(340,70,350,300);
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
    Livre lv=new Livre();
    lv.setVisible(true);
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//ajout
		if(e.getSource()==bt1){
		String a,b;
		a=tf1.getText();b=tf2.getText();
		String qr="insert into livre(idlivre,titre,disponible)"
				+ "values('"+a+"','"+b+"','OUI')";
		try{
			st=cn.connecion().createStatement();
			if(JOptionPane.showConfirmDialog(this,"Would you like to insert?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				st.executeUpdate(qr);
				JOptionPane.showMessageDialog(this,"Successfully inserted!");
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(this,"Error,Cannot insert!",null,JOptionPane.ERROR_MESSAGE);
		}
			
		}
		if(e.getSource()==bt2){
			String a;
			a=tf1.getText();
			String qr="delete from livre where idlivre='"+a+"'";
			try{
				st=cn.connecion().createStatement();
				if(JOptionPane.showConfirmDialog(this,"Would you like to delete?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					st.executeUpdate(qr);
					JOptionPane.showMessageDialog(this,"Successfully deleted!");
				}
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,"Error,cannot delete!",null,JOptionPane.ERROR_MESSAGE);
			}
		}
		 if(e.getSource()==bt4){
	    	  String a;
				a=tf1.getText();
				String qr="select * from livre where idlivre='"+a+"'";
				try{
					st=cn.connecion().createStatement();
					rst=st.executeQuery(qr);
					if(rst.next()){
						tf2.setText(rst.getString("titre"));
					}
					else
						JOptionPane.showMessageDialog(this,"Not Found!",null,JOptionPane.ERROR_MESSAGE);
				}
				catch(SQLException ex){
				
				}
	    	  
	      }
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
		//modification
		if(e.getSource()==bt5){
			String a,b;
			a=tf1.getText();b=tf2.getText();
			String qr="update livre set titre='"+b+"' where idlivre='"+a+"'";
			try{
				st=cn.connecion().createStatement();
				if(JOptionPane.showConfirmDialog(this,"Would you like to edit?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					st.executeUpdate(qr);
					JOptionPane.showMessageDialog(this,"Successfully edited!");
				}
			}
			catch(SQLException ex){
				JOptionPane.showMessageDialog(this,"Error, cannot edit!",null,JOptionPane.ERROR_MESSAGE);
			}
				
			}
		if(e.getSource()==bt6){
			dispose();
			Livre lv=new Livre();
			lv.setVisible(true);
			
		}
	
				if(e.getSource()==babonne){
					
					try{
						dispose();
						Abonne ab=new Abonne();
						ab.setVisible(true);
						
					}
					catch(Exception ex){
						
					}
						
					}
				
				//emprunt
				if(e.getSource()==bpret){
					dispose();
					Emprunt ep=new Emprunt();
					ep.setVisible(true);	
				}
		
	
}
}
