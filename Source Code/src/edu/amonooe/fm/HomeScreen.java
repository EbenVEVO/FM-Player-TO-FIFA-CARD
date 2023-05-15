package edu.amonooe.fm;


import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class HomeScreen extends JFrame {

	private JPanel contentPane;
	private JTextField filepath;
	private JButton searchButton = new JButton("SEARCH");	
	private JButton chooseFile = new JButton("CHOOSE FILE");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					HomeScreen frame = new HomeScreen();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeScreen() {
		setResizable(false);
		setTitle("FM TO FIFA CARD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("FM to FIFA CARD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 38));
		
		filepath = new JTextField();
		filepath.setColumns(10);
		

		
		JLabel lblNewLabel_1 = new JLabel("Enter filepath for attribute.txt file");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(filepath, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 398, Short.MAX_VALUE)
							.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chooseFile, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(307, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 666, GroupLayout.PREFERRED_SIZE)
					.addGap(203))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 626, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(filepath, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(chooseFile, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setUpButtonListeners();
	    
	}
	public void setUpButtonListeners() {
        ActionListener buttonListener = new ActionListener(){
            @Override
                public void actionPerformed (ActionEvent ae){
                
                    Object o = ae.getSource();
                    
                    int responce;
                    if (o == searchButton) {
                    	if(filepath.getText().length()==0)
                    		System.out.println("No text in field");
                        File SelectedFile = new File(filepath.getText());
                        
                        reader read = new reader();
                        try {
                        	System.out.println(SelectedFile);
                            read.readAttributes(SelectedFile);
                        } catch (FMException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        
                    }
                    if (o == chooseFile){
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setCurrentDirectory(new File("."));
                        responce = fileChooser.showOpenDialog(null);
                        filepath.setText(fileChooser.getSelectedFile().getAbsolutePath());
                        if (responce == JFileChooser.APPROVE_OPTION){
                            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                            System.out.println(file);
                            reader read = new reader();
                        
                                try {
                                    read.readAttributes(file);
                                } catch (FMException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            
                        }
                        
                        
                    }
                  
        }

    };
        chooseFile.addActionListener(buttonListener);
        searchButton.addActionListener(buttonListener);
}
}
