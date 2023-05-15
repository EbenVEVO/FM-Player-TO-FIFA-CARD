package edu.amonooe.fm;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FMException extends Exception {
	 private JFrame nWindow;
	    private JPanel contentPane;
	    JLabel lblNewLabel = new JLabel("ERROR:");
	    
	    public FMException (String message){

	    }
    public FMException (String message, Exception e){
    	nWindow = new JFrame();
        nWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nWindow.setTitle("Error");
   		nWindow.setBounds(100, 100, 450, 300);
        nWindow.setVisible(true);

   		contentPane = new JPanel();
   		nWindow.setContentPane(contentPane);
   		
   		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		lblNewLabel.setText(lblNewLabel.getText()+ message);
		JLabel pic = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/sign-red-error-icon-1.png")).getImage();
		Image newImg = img.getScaledInstance(85, 94, Image.SCALE_DEFAULT);
		pic.setIcon(new ImageIcon(newImg));
		pic.setBounds(10, 53, 166, 256);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(pic, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addComponent(pic, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);   

    }
}
