package gui; 

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import client.*;
import java.awt.Font;


public class ApplicationGUI extends JLayeredPane{

	private static final long serialVersionUID = -2185908976323552280L;
	private JPanel panelBodyContainer = new JPanel();
	private JPanel menuPanel = new JPanel();
	private JLabel logo;
	private CardLayout c1 = new CardLayout();
	private HomePageGUIClient home = new HomePageGUIClient();
	private UserStatsContainer enterStats = new UserStatsContainer();
	private MlbStatsGuiClient browseMLB = new MlbStatsGuiClient();
	private BrowseLocalPlayersClient browseLocal = new BrowseLocalPlayersClient();
	private ContactUs contactUs = new ContactUs();
	private Help FAQs = new Help();
	protected JButton btnSignOut = new JButton("SIGN OUT");
	protected Image img = new ImageIcon(this.getClass().getResource("/images/LogoTop.png")).getImage();
	protected Image imgline = new ImageIcon(this.getClass().getResource("/images/mainMenuline.png")).getImage();
	private final JLabel verticalLine3 = new JLabel("");
	
	public ApplicationGUI() {
		setLayout(null);
		
		setPreferredSize(new Dimension(100, 650));
		
		//Menu		
		menuPanel.setBounds(0, 0, 1300, 118);
		menuPanel.setBackground(new Color(244, 229, 192));
		menuPanel.setLayout(null);
		add(menuPanel);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setBounds(157, 64, 117, 29);
		btnHome.setFont(new Font("Chunkfive", Font.BOLD, 22));
		btnHome.setBorder(BorderFactory.createEmptyBorder());
		btnHome.setContentAreaFilled(false);
		btnHome.setForeground(new Color(47, 52, 64));
		menuPanel.add(btnHome);
		
		JButton btnEnterNewStats = new JButton("ENTER NEW STATS");
		btnEnterNewStats.setBounds(291, 64, 230, 29);
		btnEnterNewStats.setFont(new Font("Chunkfive", Font.BOLD, 22));
		btnEnterNewStats.setBorder(BorderFactory.createEmptyBorder());
		btnEnterNewStats.setContentAreaFilled(false);
		btnEnterNewStats.setForeground(new Color(47, 52, 64));
		menuPanel.add(btnEnterNewStats);
		
		JButton btnBrowseLocal = new JButton("BROWSE LOCAL");
		btnBrowseLocal.setBounds(548, 64, 207, 29);
		btnBrowseLocal.setFont(new Font("Chunkfive", Font.BOLD, 22));
		btnBrowseLocal.setBorder(BorderFactory.createEmptyBorder());
		btnBrowseLocal.setContentAreaFilled(false);
		btnBrowseLocal.setForeground(new Color(47, 52, 64));
		menuPanel.add(btnBrowseLocal);
		
		JButton btnBrowseMLB = new JButton("BROWSE MLB");
		btnBrowseMLB.setBounds(787, 64, 163, 29);
		btnBrowseMLB.setFont(new Font("Chunkfive", Font.BOLD, 22));
		btnBrowseMLB.setBorder(BorderFactory.createEmptyBorder());
		btnBrowseMLB.setContentAreaFilled(false);
		btnBrowseMLB.setForeground(new Color(47, 52, 64));
		menuPanel.add(btnBrowseMLB);
		
		logo = new JLabel("");
		logo.setBounds(6, 6, 152, 112);
		menuPanel.add(logo);
		logo.setIcon(new ImageIcon(img));
		
		btnSignOut.setBounds(888, 6, 81, 24);
		btnSignOut.setFont(new Font("Chunkfive", Font.BOLD, 14));
		btnSignOut.setBorder(BorderFactory.createEmptyBorder());
		btnSignOut.setContentAreaFilled(false);
		btnSignOut.setForeground(new Color(47, 52, 64));
		menuPanel.add(btnSignOut);
		
		JButton btncontactUs = new JButton("CONTACT");
		btncontactUs.setBounds(753, 6, 81, 24);
		btncontactUs.setFont(new Font("Chunkfive", Font.BOLD, 14));
		btncontactUs.setBorder(BorderFactory.createEmptyBorder());
		btncontactUs.setContentAreaFilled(false);
		btncontactUs.setForeground(new Color(47, 52, 64));
		menuPanel.add(btncontactUs);
		
		JButton btnFAQs = new JButton("FAQs");
		btnFAQs.setBounds(838, 6, 48, 24);
		btnFAQs.setFont(new Font("Chunkfive", Font.BOLD, 14));
		btnFAQs.setBorder(BorderFactory.createEmptyBorder());
		btnFAQs.setContentAreaFilled(false);
		btnFAQs.setForeground(new Color(47, 52, 64));
		menuPanel.add(btnFAQs);
		
		JLabel verticalLine = new JLabel("");
		verticalLine.setBounds(273, 61, 4, 36);
		menuPanel.add(verticalLine);
		verticalLine.setIcon(new ImageIcon(imgline));
		
		JLabel verticalLine2 = new JLabel("");
		verticalLine2.setBounds(533, 61, 4, 36);
		menuPanel.add(verticalLine2);
		verticalLine2.setIcon(new ImageIcon(imgline));
		
		verticalLine3.setIcon(new ImageIcon(imgline));
		verticalLine3.setBounds(765, 61, 4, 36);	
		menuPanel.add(verticalLine3);
		
		//Body Container
		panelBodyContainer.setBounds(0, 118, 1300, 597);
		add(panelBodyContainer);	
		panelBodyContainer.setLayout(c1);
		panelBodyContainer.add(home, "1");
		panelBodyContainer.add(enterStats,"2");
		panelBodyContainer.add(browseLocal, "3");
		panelBodyContainer.add(browseMLB, "4");
		panelBodyContainer.add(contactUs, "5");
		panelBodyContainer.add(FAQs, "6");
    	c1.show(panelBodyContainer, "1");
    			
    	btnHome.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelBodyContainer, "1");
 
    		}
    	});
    	
    	btnEnterNewStats.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelBodyContainer, "2");
 
    		}
    	});
    	
    	btnBrowseLocal.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelBodyContainer, "3");
 
    		}
    	});
    	
    	btnBrowseMLB.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelBodyContainer, "4");
 
    		}
    	});
    	
    	btncontactUs.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelBodyContainer, "5");
 
    		}
    	});
    	
    	btnFAQs.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelBodyContainer, "6");
 
    		}
    	});
    	
		btnSignOut.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			if(TextFieldDocumentListener.isDirty()){
    				int result = JOptionPane.showConfirmDialog(null, "You have pending statistics to add. Are you sure you want to sign out?", 
    						null, JOptionPane.YES_NO_OPTION);
        			if(result == JOptionPane.YES_OPTION){
        				//reset text
        				MainGUI.setApplicationToClose();
        			}
        		}
    			else
    			{
    				MainGUI.setApplicationToClose();
    			}
    		}
    	});
	}

    public void showHome(){
    	c1.show(panelBodyContainer, "1");
    } 
    
    public void showEnterStats(){
    	c1.show(panelBodyContainer, "2");
    }
    
    public void showBrowseLocal(){
    	c1.show(panelBodyContainer, "3");
    } 
    
    public void showBrowseMLB(){
    	c1.show(panelBodyContainer, "4");
    }
    
    public void showContactUS(){
    	c1.show(panelBodyContainer, "5");
    }
    
    public void showFAQs(){
    	c1.show(panelBodyContainer, "6");
    }
    
    protected JLabel getLabel(String title, String icon) {
	        JLabel label = new JLabel(title);
	        try {
	            label.setIcon(new ImageIcon(ImageIO.read(getClass().getResource(icon))));
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return label;
	    }


	public void loadUserInfoIntoControls() {
		home.loadUserInfoIntoControls();
		enterStats.loadUserInfoIntoControls();
	}
}
