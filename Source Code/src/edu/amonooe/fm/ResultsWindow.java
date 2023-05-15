package edu.amonooe.fm;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JProgressBar;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;



public class ResultsWindow extends JFrame {
	
	Image img = new ImageIcon(this.getClass().getResource("/field.jpg")).getImage();
	Image newImg = img.getScaledInstance(220, 400, Image.SCALE_DEFAULT);
	Image img1 = new ImageIcon(this.getClass().getResource("/1_gold.png")).getImage();
	Image newImg1 = img1.getScaledInstance(225, 250, Image.SCALE_DEFAULT);
	private JPanel contentPane;
	private Graphics2D g2;
	private JTextField searchStat;
	private JPanel pacePanel;
	/**
	 * Launch the application.
	 */

		public void run(Map<String, Double> FIFAattributes,Map<String, Integer> FIFAstats,Map<String, Integer> Overalls,String name) {
				
			ResultsWindow frame = new ResultsWindow(FIFAattributes,FIFAstats, Overalls,name);
			frame.setVisible(true);	
		}


	/**
	 * Create the frame.
	 */
	public ResultsWindow( Map<String, Double> FIFAattributes,Map<String, Integer> FIFAstats,Map<String, Integer> Overalls,String name) {
		System.out.println(FIFAattributes);
		System.out.println(FIFAstats);
		System.out.println(Overalls);

		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(125, 100, 970, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "name_1555269005038200");
		
		JPanel fieldpanel = new JPanel() {
			public void paintComponent(Graphics g){
					super.paintComponent(g);
					Graphics2D field = (Graphics2D)g.create();
					Graphics2D st = (Graphics2D)g.create();Graphics2D cam = (Graphics2D)g;Graphics2D lw = (Graphics2D)g;Graphics2D rw = (Graphics2D)g;
					Graphics2D lm = (Graphics2D)g;Graphics2D rm = (Graphics2D)g;Graphics2D cm = (Graphics2D)g;Graphics2D cdm = (Graphics2D)g;Graphics2D rwb = (Graphics2D)g;
					Graphics2D lwb = (Graphics2D)g;Graphics2D rb = (Graphics2D)g;Graphics2D lb = (Graphics2D)g;Graphics2D cb = (Graphics2D)g;
					
					field.drawImage(newImg,0, 0,this);
					
					
				
					if (Overalls.get("ST") > 80)
						st.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("ST")>70)
						st.setColor(Color.GREEN);
					else if (Overalls.get("ST")>50)
						st.setColor(Color.ORANGE);
					else
						st.setColor(Color.RED.darker());
					st.fillOval(95,20,30,30);
					
					if (Overalls.get("LW") > 80)
						lw.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("LW")>70)
						lw.setColor(Color.GREEN);
					else if (Overalls.get("LW")>50)
						lw.setColor(Color.ORANGE);
					else
						lw.setColor(Color.RED.darker());
					lw.fillOval(10,40,30,30);
					
					if (Overalls.get("RW") > 80)
						rw.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("RW")>70)
						rw.setColor(Color.GREEN);
					else if (Overalls.get("RW")>50)
						rw.setColor(Color.ORANGE);
					else
						rw.setColor(Color.RED.darker());
					rw.fillOval(180,40,30,30);
					
					if (Overalls.get("CAM") > 80)
						cam.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("CAM")>70)
						cam.setColor(Color.GREEN);
					else if (Overalls.get("CAM")>50)
						cam.setColor(Color.ORANGE);
					else
						cam.setColor(Color.RED.darker());
					cam.fillOval(95,90,30,30);
					
					if (Overalls.get("CM") > 80)
						cm.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("CM")>70)
						cm.setColor(Color.GREEN);
					else if (Overalls.get("CM")>50)
						cm.setColor(Color.ORANGE);
					else
						cm.setColor(Color.RED.darker());
					cm.fillOval(95,150,30,30);
					
					if (Overalls.get("LM") > 80)
						lm.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("LM")>70)
						lm.setColor(Color.GREEN);
					else if (Overalls.get("LM")>50)
						lm.setColor(Color.ORANGE);
					else
						lm.setColor(Color.RED.darker());
					lm.fillOval(10,140,30,30);
					
					if (Overalls.get("RM") > 80)
						rm.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("RM")>70)
						rm.setColor(Color.GREEN);
					else if (Overalls.get("RM")>50)
						rm.setColor(Color.ORANGE);
					else
						rm.setColor(Color.RED.darker());
					rm.fillOval(180,140,30,30);
					
					if (Overalls.get("CDM") > 80)
						cdm.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("CDM")>70)
						cdm.setColor(Color.GREEN);
					else if (Overalls.get("CDM")>50)
						cdm.setColor(Color.ORANGE);
					else
						cdm.setColor(Color.RED.darker());
					cdm.fillOval(95,210,30,30);
					
					if (Overalls.get("LWB") > 80)
						lwb.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("LWB")>70)
						lwb.setColor(Color.GREEN);
					else if (Overalls.get("LWB")>50)
						lwb.setColor(Color.ORANGE);
					else
						lwb.setColor(Color.RED.darker());
					lwb.fillOval(10,210,30,30);
					
					if (Overalls.get("RWB") > 80)
						rwb.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("RWB")>70)
						rwb.setColor(Color.GREEN);
					else if (Overalls.get("RWB")>50)
						rwb.setColor(Color.ORANGE);
					else
						rwb.setColor(Color.RED.darker());
					rwb.fillOval(180,210,30,30);
					
					if (Overalls.get("LB") > 80)
						lb.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("LB")>70)
						lb.setColor(Color.GREEN);
					else if (Overalls.get("LB")>50)
						lb.setColor(Color.ORANGE);
					else
						lb.setColor(Color.RED.darker());
					lb.fillOval(10,280,30,30);
					
					if (Overalls.get("RB") > 80)
						rb.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("RB")>70)
						rb.setColor(Color.GREEN);
					else if (Overalls.get("RB")>50)
						rb.setColor(Color.ORANGE);
					else
						rb.setColor(Color.RED.darker());
					rb.fillOval(180,280,30,30);
					

					if (Overalls.get("CB") > 80)
						cb.setColor(Color.GREEN.darker().darker());
					else if(Overalls.get("CB")>70)
						cb.setColor(Color.GREEN);
					else if (Overalls.get("CB")>50)
						cb.setColor(Color.ORANGE);
					else
						cb.setColor(Color.RED.darker());
					cb.fillOval(95,280,30,30);
					
				}
		};
		fieldpanel.setBounds(723, 260, 223, 323);
		JLabel ST = new JLabel(Overalls.get("ST").toString());ST.setFont(new Font("Segoe UI Black", Font.BOLD, 16));ST.setForeground(new Color(255, 255, 255));ST.setBounds(100, 22, 25, 25);fieldpanel.add(ST);
		
		JLabel LW = new JLabel(Overalls.get("LW").toString());LW.setFont(new Font("Segoe UI Black", Font.BOLD, 16));LW.setForeground(new Color(255, 255, 255));LW.setBounds(15, 42, 25, 25);fieldpanel.add(LW);
		JLabel RW = new JLabel(Overalls.get("RW").toString());RW.setFont(new Font("Segoe UI Black", Font.BOLD, 16));RW.setForeground(new Color(255, 255, 255));RW.setBounds(185, 42, 25, 25);fieldpanel.add(RW);
		JLabel CAM = new JLabel(Overalls.get("CAM").toString());CAM.setFont(new Font("Segoe UI Black", Font.BOLD, 16));CAM.setForeground(new Color(255, 255, 255));CAM.setBounds(100, 92, 25, 25);fieldpanel.add(CAM);
		JLabel LM = new JLabel(Overalls.get("LM").toString());LM.setFont(new Font("Segoe UI Black", Font.BOLD, 16));LM.setForeground(new Color(255, 255, 255));LM.setBounds(15, 142, 25, 25);fieldpanel.add(LM);
		JLabel RM = new JLabel(Overalls.get("RM").toString());RM.setFont(new Font("Segoe UI Black", Font.BOLD, 16));RM.setForeground(new Color(255, 255, 255));RM.setBounds(185, 142, 25, 25);fieldpanel.add(RM);
		JLabel CM = new JLabel(Overalls.get("CM").toString());CM.setFont(new Font("Segoe UI Black", Font.BOLD, 16));CM.setForeground(new Color(255, 255, 255));CM.setBounds(100, 152, 25, 25);fieldpanel.add(CM);
		JLabel CDM = new JLabel(Overalls.get("CDM").toString());CDM.setFont(new Font("Segoe UI Black", Font.BOLD, 16));CDM.setForeground(new Color(255, 255, 255));CDM.setBounds(100, 212, 25, 25);fieldpanel.add(CDM);
		JLabel RWB = new JLabel(Overalls.get("RWB").toString());RWB.setFont(new Font("Segoe UI Black", Font.BOLD, 16));RWB.setForeground(new Color(255, 255, 255));RWB.setBounds(185, 212, 25, 25);fieldpanel.add(RWB);
		JLabel LWB = new JLabel(Overalls.get("LWB").toString());LWB.setFont(new Font("Segoe UI Black", Font.BOLD, 16));LWB.setForeground(new Color(255, 255, 255));LWB.setBounds(15, 212, 25, 25);fieldpanel.add(LWB);
		JLabel LB = new JLabel(Overalls.get("LB").toString());LB.setFont(new Font("Segoe UI Black", Font.BOLD, 16));LB.setForeground(new Color(255, 255, 255));LB.setBounds(15, 282, 25, 25);fieldpanel.add(LB);
		JLabel RB = new JLabel(Overalls.get("RB").toString());RB.setFont(new Font("Segoe UI Black", Font.BOLD, 16));RB.setForeground(new Color(255, 255, 255));RB.setBounds(185, 282, 25, 25);fieldpanel.add(RB);
		JLabel CB = new JLabel(Overalls.get("CB").toString());CB.setFont(new Font("Segoe UI Black", Font.BOLD, 16));CB.setForeground(new Color(255, 255, 255));CB.setBounds(100, 282, 25, 25);fieldpanel.add(CB);
		
		layeredPane.add(fieldpanel);
		
		GroupLayout gl_fieldpanel = new GroupLayout(fieldpanel);
		gl_fieldpanel.setHorizontalGroup(
			gl_fieldpanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 223, Short.MAX_VALUE)
		);
		gl_fieldpanel.setVerticalGroup(
			gl_fieldpanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 323, Short.MAX_VALUE)
		);
		fieldpanel.setLayout(gl_fieldpanel);
		
		JPanel statspanel = new JPanel() {
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				Graphics2D pace = (Graphics2D)g;Graphics2D dribbling = (Graphics2D)g;Graphics2D shooting = (Graphics2D)g;
				Graphics2D passing = (Graphics2D)g;Graphics2D defending = (Graphics2D)g;Graphics2D PHYSICALITY = (Graphics2D)g;
				
				if (FIFAstats.get("Pace") > 80)
					pace.setColor(Color.GREEN.darker().darker());
				else if(FIFAstats.get("Pace")>70)
					pace.setColor(Color.GREEN);
				else if (FIFAstats.get("Pace")>50)
					pace.setColor(Color.ORANGE);
				else
					pace.setColor(Color.RED.darker());
				pace.fillRoundRect(25, 71,(int)(FIFAstats.get("Passing")*1.9191), 4,10,10);
				
				if (FIFAstats.get("Shooting") > 80)
					shooting.setColor(Color.GREEN.darker().darker());
				else if(FIFAstats.get("Shooting")>70)
					shooting.setColor(Color.GREEN);
				else if (FIFAstats.get("Shooting")>50)
					shooting.setColor(Color.ORANGE);
				else
					shooting.setColor(Color.RED.darker());
				shooting.fillRoundRect(250,71,(int)(FIFAstats.get("Shooting")*2.1212),4,10,10);
				if (FIFAstats.get("Passing") > 80)
					passing.setColor(Color.GREEN.darker().darker());
				else if(FIFAstats.get("Passing")>70)
					passing.setColor(Color.GREEN);
				else if (FIFAstats.get("Passing")>50)
					passing.setColor(Color.ORANGE);
				else
					passing.setColor(Color.RED.darker());
				passing.fillRoundRect(500,71,(int)(FIFAstats.get("Passing")*2.0202),4,10,10);
				
				if (FIFAstats.get("Dribbling") > 80)
					dribbling.setColor(Color.GREEN.darker().darker());
				else if(FIFAstats.get("Dribbling")>70)
					dribbling.setColor(Color.GREEN);
				else if (FIFAstats.get("Dribbling")>50)
					dribbling.setColor(Color.ORANGE);
				else
					dribbling.setColor(Color.RED.darker());
				dribbling.fillRoundRect(25,210,(int)(FIFAstats.get("Dribbling")*1.9191),4,10,10);
				
				if (FIFAstats.get("Defending") > 80)
					defending.setColor(Color.GREEN.darker().darker());
				else if(FIFAstats.get("Defending")>70)
					defending.setColor(Color.GREEN);
				else if (FIFAstats.get("Defending")>50)
					defending.setColor(Color.ORANGE);
				else
					defending.setColor(Color.RED.darker());
				defending.fillRoundRect(250,210,(int)(FIFAstats.get("Defending")*2.222),4,10,10); 
				
				if (FIFAstats.get("Physical") > 80)
					PHYSICALITY.setColor(Color.GREEN.darker().darker());
				else if(FIFAstats.get("Physical")>70)
					PHYSICALITY.setColor(Color.GREEN);
				else if (FIFAstats.get("Physical")>50)
					PHYSICALITY.setColor(Color.ORANGE);
				else
					PHYSICALITY.setColor(Color.RED.darker());
				PHYSICALITY.fillRoundRect(500,210,(int)(FIFAstats.get("Physical")*2.0202),4,10,10);
			}
		};
		statspanel.setBackground(new Color(255, 255, 255));
		statspanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		statspanel.setBounds(0, 258, 721, 325);
		layeredPane.add(statspanel);
		
		JLabel paLabel = new JLabel("PACE");
		paLabel.setBounds(25, 39, 137, 28);
		paLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		
		JLabel shootingLabel = new JLabel(" SHOOTING");
		shootingLabel.setBounds(249, 39, 128, 28);
		shootingLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		JLabel passingLabel = new JLabel("PASSING");
		passingLabel.setBounds(502, 37, 76, 32);
		passingLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		JLabel defendingLabel = new JLabel("DEFENDING");
		defendingLabel.setBounds(249, 185, 119, 25);
		defendingLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		JLabel dribbLabel = new JLabel("DRIBBLING");
		dribbLabel.setBounds(25, 185, 137, 25);
		dribbLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		JLabel physicalLabel = new JLabel("PHYSICALITY");
		physicalLabel.setBounds(503, 185, 118, 28);
		physicalLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		
		searchStat = new JTextField();
		searchStat.setBounds(25, 11, 539, 19);
		searchStat.setText("SEARCH STAT...");
		searchStat.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		searchStat.setColumns(20);
		
		JLabel pace = new JLabel(FIFAstats.get("Pace").toString());
		pace.setBounds(194, 36, 45, 31);
		pace.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		if (FIFAstats.get("Pace") > 80)
			pace.setForeground(Color.GREEN.darker().darker());
		else if(FIFAstats.get("Pace")>70)
			pace.setForeground(Color.GREEN);
		else if (FIFAstats.get("Pace")>50)
			pace.setForeground(Color.ORANGE);
		else
			pace.setForeground(Color.RED.darker());
		
		JLabel dribbling = new JLabel(FIFAstats.get("Dribbling").toString());
		dribbling.setBounds(193, 178, 46, 35);
		dribbling.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		if (FIFAstats.get("Dribbling") > 80)
			dribbling.setForeground(Color.GREEN.darker().darker());
		else if(FIFAstats.get("Dribbling")>70)
			dribbling.setForeground(Color.GREEN);
		else if (FIFAstats.get("Dribbling")>50)
			dribbling.setForeground(Color.ORANGE);
		else
			dribbling.setForeground(Color.RED.darker());
		
		JLabel defending = new JLabel(FIFAstats.get("Defending").toString());
		defending.setBounds(440, 180, 45, 31);
		defending.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		if (FIFAstats.get("Defending") > 80)
			defending.setForeground(Color.GREEN.darker().darker());
		else if(FIFAstats.get("Defending")>70)
			defending.setForeground(Color.GREEN);
		else if (FIFAstats.get("Defending")>50)
			defending.setForeground(Color.ORANGE);
		else
			defending.setForeground(Color.RED.darker());
		
		JLabel shooting = new JLabel(FIFAstats.get("Shooting").toString());
		shooting.setBounds(440, 40, 45, 31);
		shooting.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		if (FIFAstats.get("Shooting") > 80)
			shooting.setForeground(Color.GREEN.darker().darker());
		else if(FIFAstats.get("Shooting")>70)
			shooting.setForeground(Color.GREEN);
		else if (FIFAstats.get("Shooting")>50)
			shooting.setForeground(Color.ORANGE);
		else
			shooting.setForeground(Color.RED.darker());
		
		JLabel passing = new JLabel(FIFAstats.get("Passing").toString());
		passing.setBounds(676, 36, 45, 31);
		passing.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		if (FIFAstats.get("Passing") > 80)
			passing.setForeground(Color.GREEN.darker().darker());
		else if(FIFAstats.get("Passing")>70)
			passing.setForeground(Color.GREEN);
		else if (FIFAstats.get("Passing")>50)
			passing.setForeground(Color.ORANGE);
		else
			passing.setForeground(Color.RED.darker());
		
		JLabel PHYSICALITY = new JLabel(FIFAstats.get("Physical").toString());
		PHYSICALITY.setBounds(676, 185, 45, 31);
		PHYSICALITY.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		if (FIFAstats.get("Physical") > 80)
			PHYSICALITY.setForeground(Color.GREEN.darker().darker());
		else if(FIFAstats.get("Physical")>70)
			PHYSICALITY.setForeground(Color.GREEN);
		else if (FIFAstats.get("Physical")>50)
			PHYSICALITY.setForeground(Color.ORANGE);
		else
			PHYSICALITY.setForeground(Color.RED.darker());
		statspanel.setLayout(null);
		statspanel.add(searchStat);
		statspanel.add(paLabel);
		statspanel.add(dribbLabel);
		statspanel.add(pace);
		statspanel.add(dribbling);
		statspanel.add(shootingLabel);
		statspanel.add(shooting);
		statspanel.add(passingLabel);
		statspanel.add(defending);
		statspanel.add(physicalLabel);
		statspanel.add(passing);
		statspanel.add(PHYSICALITY);
		statspanel.add(defendingLabel);
		
		pacePanel = new JPanel();
		pacePanel.setBackground(new Color(255, 255, 255));
		pacePanel.setBounds(181, 77, 58, 116);
		statspanel.add(pacePanel);
		pacePanel.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel sprint_speed = new JLabel(String.format("%.0f", FIFAattributes.get("Sprint Speed"))+"  ");
		sprint_speed.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		sprint_speed.setHorizontalAlignment(SwingConstants.RIGHT);
		if (FIFAattributes.get("Sprint Speed") > 80)
			sprint_speed.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Sprint Speed")>70)
			sprint_speed.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Sprint Speed")>50)
			sprint_speed.setForeground(Color.ORANGE);
		else
			sprint_speed.setForeground(Color.RED.darker());
		pacePanel.add(sprint_speed);
		
		JLabel acceleration = new JLabel(String.format("%.0f", FIFAattributes.get("Acceleration"))+"  ");
		acceleration.setHorizontalAlignment(SwingConstants.RIGHT);
		acceleration.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Acceleration") > 80)
			acceleration.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Acceleration")>70)
			acceleration.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Acceleration")>50)
			acceleration.setForeground(Color.ORANGE);
		else
			acceleration.setForeground(Color.RED.darker());
		pacePanel.add(acceleration);
		
		JPanel shootingPanel = new JPanel();
		shootingPanel.setBackground(new Color(255, 255, 255));
		shootingPanel.setBounds(420, 77, 58, 116);
		statspanel.add(shootingPanel);
		shootingPanel.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel positioning = new JLabel(String.format("%.0f", FIFAattributes.get("Attacking Positioning"))+"  ");
		positioning.setHorizontalAlignment(SwingConstants.RIGHT);
		positioning.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Attacking Positioning") > 80)
			positioning.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Attacking Positioning")>70)
			positioning.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Attacking Positioning")>50)
			positioning.setForeground(Color.ORANGE);
		else
			positioning.setForeground(Color.RED.darker());
		shootingPanel.add(positioning);
		
		JLabel Finishing = new JLabel(String.format("%.0f", FIFAattributes.get("Finishing"))+"  ");
		Finishing.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		Finishing.setHorizontalAlignment(SwingConstants.RIGHT);
		if (FIFAattributes.get("Finishing") > 80)
			Finishing.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Finishing")>70)
			Finishing.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Finishing")>50)
			Finishing.setForeground(Color.ORANGE);
		else
			Finishing.setForeground(Color.RED.darker());
		shootingPanel.add(Finishing);
		
		JLabel shotpowe = new JLabel(String.format("%.0f", FIFAattributes.get("Shot Power"))+"  ");
		shotpowe.setHorizontalAlignment(SwingConstants.RIGHT);
		shotpowe.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Shot Power") > 80)
			shotpowe.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Shot Power")>70)
			shotpowe.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Shot Power")>50)
			shotpowe.setForeground(Color.ORANGE);
		else
			shotpowe.setForeground(Color.RED.darker());
		shootingPanel.add(shotpowe);
		
		JLabel longshts = new JLabel(String.format("%.0f", FIFAattributes.get("Long Shots"))+"  ");
		longshts.setHorizontalAlignment(SwingConstants.RIGHT);
		longshts.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Long Shots") > 80)
			longshts.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Long Shots")>70)
			longshts.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Long Shots")>50)
			longshts.setForeground(Color.ORANGE);
		else
			longshts.setForeground(Color.RED.darker());
		shootingPanel.add(longshts);
		
		JLabel volleys = new JLabel(String.format("%.0f", FIFAattributes.get("Volleys"))+"  ");
		volleys.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		volleys.setHorizontalAlignment(SwingConstants.RIGHT);
		if (FIFAattributes.get("Volleys") > 80)
			volleys.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Volleys")>70)
			volleys.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Volleys")>50)
			volleys.setForeground(Color.ORANGE);
		else
			volleys.setForeground(Color.RED.darker());
		shootingPanel.add(volleys);
		
		JLabel penalty = new JLabel(String.format("%.0f", FIFAattributes.get("Penalties"))+"  ");
		penalty.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		penalty.setHorizontalAlignment(SwingConstants.RIGHT);
		if (FIFAattributes.get("Penalties") > 80)
			penalty.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Penalties")>70)
			penalty.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Penalties")>50)
			penalty.setForeground(Color.ORANGE);
		else
			penalty.setForeground(Color.RED.darker());
		shootingPanel.add(penalty);
		
		JPanel passingPanel = new JPanel();
		passingPanel.setBackground(new Color(255, 255, 255));
		passingPanel.setBounds(655, 77, 56, 116);
		statspanel.add(passingPanel);
		passingPanel.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel vision = new JLabel(String.format("%.0f", FIFAattributes.get("Vision"))+"  ");
		vision.setHorizontalAlignment(SwingConstants.RIGHT);
		vision.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Vision") > 80)
			vision.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Vision")>70)
			vision.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Vision")>50)
			vision.setForeground(Color.ORANGE);
		else
			vision.setForeground(Color.RED.darker());
		passingPanel.add(vision);
		
		JLabel crossing = new JLabel(String.format("%.0f", FIFAattributes.get("Crossing"))+"  ");
		crossing.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		crossing.setHorizontalAlignment(SwingConstants.RIGHT);
		if (FIFAattributes.get("Crossing") > 80)
			crossing.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Crossing")>70)
			crossing.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Crossing")>50)
			crossing.setForeground(Color.ORANGE);
		else
			crossing.setForeground(Color.RED.darker());
		passingPanel.add(crossing);
		
		JLabel fka = new JLabel(String.format("%.0f", FIFAattributes.get("Free Kick Accuracy"))+"  ");
		fka.setHorizontalAlignment(SwingConstants.RIGHT);
		fka.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Free Kick Accuracy") > 80)
			fka.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Free Kick Accuracy")>70)
			fka.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Free Kick Accuracy")>50)
			fka.setForeground(Color.ORANGE);
		else
			fka.setForeground(Color.RED.darker());
		passingPanel.add(fka);
		
		JLabel shortpass = new JLabel(String.format("%.0f", FIFAattributes.get("Short Passing"))+"  ");
		shortpass.setHorizontalAlignment(SwingConstants.RIGHT);
		shortpass.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Short Passing") > 80)
			shortpass.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Short Passing")>70)
			shortpass.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Short Passing")>50)
			shortpass.setForeground(Color.ORANGE);
		else
			shortpass.setForeground(Color.RED.darker());
		passingPanel.add(shortpass);
		
		JLabel longpass = new JLabel(String.format("%.0f", FIFAattributes.get("Long Passing"))+"  ");
		longpass.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		longpass.setHorizontalAlignment(SwingConstants.RIGHT);
		if (FIFAattributes.get("Long Passing") > 80)
			longpass.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Long Passing")>70)
			longpass.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Long Passing")>50)
			longpass.setForeground(Color.ORANGE);
		else
			longpass.setForeground(Color.RED.darker());
		passingPanel.add(longpass);
		
		JLabel curve = new JLabel(String.format("%.0f", FIFAattributes.get("Curve"))+"  ");
		curve.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		curve.setHorizontalAlignment(SwingConstants.RIGHT);
		if (FIFAattributes.get("Curve") > 80)
			curve.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Curve")>70)
			curve.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Curve")>50)
			curve.setForeground(Color.ORANGE);
		else
			curve.setForeground(Color.RED.darker());
		passingPanel.add(curve);
		
		JPanel dribblingPanel = new JPanel();
		dribblingPanel.setBackground(new Color(255, 255, 255));
		dribblingPanel.setBounds(181, 218, 58, 105);
		statspanel.add(dribblingPanel);
		dribblingPanel.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel agilitynum = new JLabel(String.format("%.0f", FIFAattributes.get("Agility"))+"  ");
		agilitynum.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		agilitynum.setHorizontalAlignment(SwingConstants.RIGHT);
		if (FIFAattributes.get("Agility") > 80)
			agilitynum.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Agility")>70)
			agilitynum.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Agility")>50)
			agilitynum.setForeground(Color.ORANGE);
		else
			agilitynum.setForeground(Color.RED.darker());
		dribblingPanel.add(agilitynum);
		
		JLabel balancenum = new JLabel(String.format("%.0f", FIFAattributes.get("Balance"))+"  ");
		balancenum.setHorizontalAlignment(SwingConstants.RIGHT);
		balancenum.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Balance") > 80)
			balancenum.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Balance")>70)
			balancenum.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Balance")>50)
			balancenum.setForeground(Color.ORANGE);
		else
			balancenum.setForeground(Color.RED.darker());
		dribblingPanel.add(balancenum);
		
		JLabel reactionsnum = new JLabel(String.format("%.0f", FIFAattributes.get("Reactions"))+"  ");
		reactionsnum.setHorizontalAlignment(SwingConstants.RIGHT);
		reactionsnum.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Reactions") > 80)
			reactionsnum.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Reactions")>70)
			reactionsnum.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Reactions")>50)
			reactionsnum.setForeground(Color.ORANGE);
		else
			reactionsnum.setForeground(Color.RED.darker());
		dribblingPanel.add(reactionsnum);
		
		JLabel control = new JLabel(String.format("%.0f", FIFAattributes.get("Ball Control"))+"  ");
		control.setHorizontalAlignment(SwingConstants.RIGHT);
		control.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Ball Control") > 80)
			control.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Ball Control")>70)
			control.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Ball Control")>50)
			control.setForeground(Color.ORANGE);
		else
			control.setForeground(Color.RED.darker());
		dribblingPanel.add(control);
		
		JLabel dribble = new JLabel(String.format("%.0f", FIFAattributes.get("Dribbling"))+"  ");
		dribble.setHorizontalAlignment(SwingConstants.RIGHT);
		dribble.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Dribbling") > 80)
			dribble.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Dribbling")>70)
			dribble.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Dribbling")>50)
			dribble.setForeground(Color.ORANGE);
		else
			dribble.setForeground(Color.RED.darker());
		dribblingPanel.add(dribble);
		
		JLabel compse = new JLabel(String.format("%.0f", FIFAattributes.get("Composure"))+"  ");
		compse.setHorizontalAlignment(SwingConstants.RIGHT);
		compse.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Composure") > 80)
			compse.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Composure")>70)
			compse.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Composure")>50)
			compse.setForeground(Color.ORANGE);
		else
			compse.setForeground(Color.RED.darker());
		dribblingPanel.add(compse);

		JPanel defensePanel = new JPanel();
		defensePanel.setBackground(new Color(255, 255, 255));
		defensePanel.setBounds(420, 218, 58, 105);
		statspanel.add(defensePanel);
		defensePanel.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel ception = new JLabel(String.format("%.0f", FIFAattributes.get("Interceptions"))+"  ");
		ception.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		ception.setHorizontalAlignment(SwingConstants.RIGHT);
		if (FIFAattributes.get("Interceptions") > 80)
			ception.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Interceptions")>70)
			ception.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Interceptions")>50)
			ception.setForeground(Color.ORANGE);
		else
			ception.setForeground(Color.RED.darker());
		defensePanel.add(ception);
		
		JLabel headinga = new JLabel(String.format("%.0f", FIFAattributes.get("Heading Accuracy"))+"  ");
		headinga.setHorizontalAlignment(SwingConstants.RIGHT);
		headinga.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Heading Accuracy") > 80)
			headinga.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Heading Accuracy")>70)
			headinga.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Heading Accuracy")>50)
			headinga.setForeground(Color.ORANGE);
		else
			headinga.setForeground(Color.RED.darker());
		defensePanel.add(headinga);
		
		JLabel defaware = new JLabel(String.format("%.0f", FIFAattributes.get("Defensive Awareness"))+"  ");
		defaware.setHorizontalAlignment(SwingConstants.RIGHT);
		defaware.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Defensive Awareness") > 80)
			defaware.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Defensive Awareness")>70)
			defaware.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Defensive Awareness")>50)
			defaware.setForeground(Color.ORANGE);
		else
			defaware.setForeground(Color.RED.darker());
		defensePanel.add(defaware);
		
		JLabel sttackle = new JLabel(String.format("%.0f", FIFAattributes.get("Stand Tackle"))+"  ");
		sttackle.setHorizontalAlignment(SwingConstants.RIGHT);
		sttackle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Stand Tackle") > 80)
			sttackle.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Stand Tackle")>70)
			sttackle.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Stand Tackle")>50)
			sttackle.setForeground(Color.ORANGE);
		else
			sttackle.setForeground(Color.RED.darker());
		defensePanel.add(sttackle);
		
		JLabel sltackle = new JLabel(String.format("%.0f", FIFAattributes.get("Slide Tackle"))+"  ");
		sltackle.setHorizontalAlignment(SwingConstants.RIGHT);
		sltackle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Slide Tackle") > 80)
			sltackle.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Slide Tackle")>70)
			sltackle.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Slide Tackle")>50)
			sltackle.setForeground(Color.ORANGE);
		else
			sltackle.setForeground(Color.RED.darker());
		defensePanel.add(sltackle);
		
		JPanel physicalPanel = new JPanel();
		physicalPanel.setBackground(new Color(255, 255, 255));
		physicalPanel.setBounds(655, 218, 58, 105);
		statspanel.add(physicalPanel);
		physicalPanel.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel jump = new JLabel(String.format("%.0f", FIFAattributes.get("Jumping"))+"  ");
		jump.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		jump.setHorizontalAlignment(SwingConstants.RIGHT);
		if (FIFAattributes.get("Jumping") > 80)
			jump.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Jumping")>70)
			jump.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Jumping")>50)
			jump.setForeground(Color.ORANGE);
		else
			jump.setForeground(Color.RED.darker());
		physicalPanel.add(jump);
		
		JLabel stamna = new JLabel(String.format("%.0f", FIFAattributes.get("Stamina"))+"  ");
		stamna.setHorizontalAlignment(SwingConstants.RIGHT);
		stamna.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Stamina") > 80)
			stamna.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Stamina")>70)
			stamna.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Stamina")>50)
			stamna.setForeground(Color.ORANGE);
		else
			stamna.setForeground(Color.RED.darker());
		physicalPanel.add(stamna);
		
		JLabel stren = new JLabel(String.format("%.0f", FIFAattributes.get("Strength"))+"  ");
		stren.setHorizontalAlignment(SwingConstants.RIGHT);
		stren.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Strength") > 80)
			stren.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Strength")>70)
			stren.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Strength")>50)
			stren.setForeground(Color.ORANGE);
		else
			stren.setForeground(Color.RED.darker());
		physicalPanel.add(stren);
		
		JLabel aggres = new JLabel(String.format("%.0f", FIFAattributes.get("Aggression"))+"  ");
		aggres.setHorizontalAlignment(SwingConstants.RIGHT);
		aggres.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		if (FIFAattributes.get("Aggression") > 80)
			aggres.setForeground(Color.GREEN.darker().darker());
		else if(FIFAattributes.get("Aggression")>70)
			aggres.setForeground(Color.GREEN);
		else if (FIFAattributes.get("Aggression")>50)
			aggres.setForeground(Color.ORANGE);
		else
			aggres.setForeground(Color.RED.darker());
		physicalPanel.add(aggres);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(25, 77, 686, 116);
		statspanel.add(panel);
		panel.setLayout(new GridLayout(6, 3, 5, 0));
		
		JLabel lblNewLabel = new JLabel("Sprint Speed");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(lblNewLabel);
		
		JLabel Positioning = new JLabel("Positioning");
		Positioning.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(Positioning);
		
		JLabel vision1 = new JLabel("      Vision");
		vision1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		vision.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(vision1);
		
		JLabel Acceleration = new JLabel("Acceleration");
		Acceleration.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(Acceleration);
		
		JLabel finishing = new JLabel("Finishing");
		finishing.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(finishing);
		
		JLabel crossing1 = new JLabel("      Crossing");
		crossing1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		crossing.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(crossing1);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel shotpower = new JLabel("Shot Power");
		shotpower.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(shotpower);
		
		JLabel fka1 = new JLabel("      FK. Accuracy");
		fka1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		fka.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(fka1);
		
		JLabel label_2 = new JLabel("");
		panel.add(label_2);
		
		JLabel longshots = new JLabel("Long Shots");
		longshots.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(longshots);
		
		JLabel shortpass1 = new JLabel("      Short Passing");
		shortpass1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		shortpass.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(shortpass1);
		
		JLabel label3 = new JLabel("");
		label3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(label3);
		
		JLabel lblNewLabel_2 = new JLabel("Volleys");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(lblNewLabel_2);
		
		JLabel longpass1 = new JLabel("      Long Passing");
		longpass1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		longpass.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(longpass1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);
		
		JLabel penalties = new JLabel("Penalties");
		penalties.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(penalties);
		
		JLabel curve1 = new JLabel("      Curve");
		curve1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		curve.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel.add(curve1);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 255, 255));
		panel2.setBounds(25, 218, 686, 105);
		statspanel.add(panel2);
		panel2.setLayout(new GridLayout(6, 3, 5, 0));
		
		JLabel agility = new JLabel("Agility");
		agility.setHorizontalAlignment(SwingConstants.LEFT);
		agility.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(agility);
		
		JLabel intercep = new JLabel("Interceptions");
		intercep.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(intercep);
		
		JLabel jumpin = new JLabel("      Jumping");
		jumpin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(jumpin);
		
		JLabel balance = new JLabel("Balance");
		balance.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(balance);
		
		JLabel lblNewLabel_6 = new JLabel("Heading Accuracy");
		lblNewLabel_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(lblNewLabel_6);
		
		JLabel stamina = new JLabel("      Stamina");
		stamina.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(stamina);
		
		JLabel reactions = new JLabel("Reactions");
		reactions.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(reactions);
		
		JLabel aware = new JLabel("Def. Awareness");
		aware.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(aware);
		
		JLabel strength = new JLabel("      Strength");
		strength.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(strength);
		
		JLabel ballcontrol = new JLabel("Ball Control");
		ballcontrol.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(ballcontrol);
		
		JLabel standtackle = new JLabel("Standing Tackle");
		standtackle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(standtackle);
		
		JLabel aggression = new JLabel("      Aggression");
		aggression.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(aggression);
		
		JLabel dribbling1 = new JLabel("Dribbling");
		dribbling1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(dribbling1);
		
		JLabel slidetackle = new JLabel("Sliding Tackle");
		slidetackle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(slidetackle);
		
		JLabel blnk = new JLabel("");
		panel2.add(blnk);
		
		JLabel composure = new JLabel("Composure");
		composure.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 10));
		panel2.add(composure);
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(0, 0, 946, 261);
		layeredPane.add(cardPanel);
		
		JLabel playerName = new JLabel(name);
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		playerName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 26));
		
			JLabel Card = new JLabel();
		Card.setIcon(new ImageIcon(newImg1));
		JLabel overall = new JLabel();
		overall.setHorizontalAlignment(SwingConstants.CENTER);
		overall.setFont(new Font("Eras Bold ITC", Font.BOLD, 35));
		overall.setBounds(39, 55, 55, 55);
		Card.add(overall);
		
		
		JLabel position = new JLabel();
		position.setHorizontalAlignment(SwingConstants.CENTER);
		position.setFont(new Font("Eras Bold ITC", Font.BOLD, 20));
		position.setBounds(36, 90, 65, 45);
		Card.add(position);
		
		int lastPos = name.lastIndexOf(' ');
		JLabel pName = new JLabel(name.substring(lastPos + 1));
		pName.setHorizontalAlignment(SwingConstants.CENTER);
		pName.setFont(new Font("Eras Bold ITC", Font.BOLD, 18));
		pName.setBounds(58, 168, 115, 45);
		Card.add(pName);
		
		JList list = new JList();
		list.setVisibleRowCount(6);
		
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		Card.add(scrollPane);
		
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"ST", "LW", "RW", "CAM", "CM", "RM", "LM", "CDM", "LWB", "RWB", "LB", "RB", "CB"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int cardOverall = Overalls.get(list.getSelectedValue());
				overall.setText(Integer.toString(cardOverall));
				String pos = (String) list.getSelectedValue();
				position.setText(pos);
			}
			
			
			
		});
		
	

		GroupLayout gl_cardPanel = new GroupLayout(cardPanel);
		gl_cardPanel.setHorizontalGroup(
			gl_cardPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cardPanel.createSequentialGroup()
					.addGap(36)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Card)
					.addGap(18)
					.addComponent(playerName, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(246, Short.MAX_VALUE))
		);
		gl_cardPanel.setVerticalGroup(
			gl_cardPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_cardPanel.createSequentialGroup()
					.addGroup(gl_cardPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_cardPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(Card)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_cardPanel.createSequentialGroup()
							.addComponent(playerName, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(19)))
					.addContainerGap(1, Short.MAX_VALUE))
				.addGroup(gl_cardPanel.createSequentialGroup()
					.addContainerGap(64, Short.MAX_VALUE)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
		);
		cardPanel.setLayout(gl_cardPanel);

	
	}
}
