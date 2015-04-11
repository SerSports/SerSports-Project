/*
File: Help.java
Author:	
Date:	

Description: GUI for the help page

 */
package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class: Help
 * 
 * Description: GUI for the help page
 */
public class Help extends JPanel
{
	CardLayout c1 = new CardLayout();
	JPanel faqContainer = new JPanel();
	
	protected JButton ageRequirementQ = new JButton(
			"Is there an age requirement to create an account?");
	protected JButton abbreviationsQ = new JButton(
			"List of common baseball abbreviations");
	protected JButton similarityQ = new JButton(
			"How is the similarity between players determined?");
	protected JButton statisticViewQ = new JButton(
			"Will other people be able to see my statistics?");
	protected JButton deletedStatisticsQ = new JButton(
			"Can I retrieve deleted statistics?");
	
	AbbreviationsQ abbreviations = new AbbreviationsQ();
	AgeRequirementQ ageRequirement = new AgeRequirementQ();
	DeletedStatisticsQ deletedStats = new DeletedStatisticsQ();
	SimilarityQ similarity = new SimilarityQ();
	StatisticViewQ viewStats = new StatisticViewQ();
	
	/**
	 * Method: Constructor Inputs: None Returns:
	 * 
	 * Description: Creates the panel
	 */
	public Help()
	{
		add(faqContainer);
		faqContainer.setPreferredSize(new Dimension(345, 424));
		faqContainer.setBackground(Color.WHITE);
		faqContainer.setBounds(614, 87, 345, 424);
		setPreferredSize(new Dimension(1000, 600));
		setLayout(null);
		setBackground(new Color(47, 52, 64));
		faqContainer.setLayout(c1);
		faqContainer.add(ageRequirement, "1");
		faqContainer.add(similarity, "2");
		faqContainer.add(viewStats, "3");
		faqContainer.add(deletedStats, "4");
		
		JLabel lblYouAre = new JLabel("FAQ & Help");
		lblYouAre.setBounds(466, 20, 80, 16);
		add(lblYouAre);
		
		JLabel logo = new JLabel("");
		logo.setBounds(6, 0, 141, 42);
		add(logo);
		Image img = new ImageIcon(this.getClass().getResource("/images/LogoBottom.png"))
				.getImage();
		logo.setIcon(new ImageIcon(img));
		
		ageRequirementQ.setBounds(115, 184, 412, 29);
		add(ageRequirementQ);
		
		abbreviationsQ.setBounds(115, 225, 412, 29);
		add(abbreviationsQ);
		
		similarityQ.setBounds(115, 266, 412, 29);
		add(similarityQ);
		
		statisticViewQ.setBounds(115, 307, 412, 29);
		add(statisticViewQ);
		
		deletedStatisticsQ.setBounds(115, 348, 412, 29);
		add(deletedStatisticsQ);
		
		ageRequirementQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				c1.show(faqContainer, "1");
			}
		});
		
		similarityQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				c1.show(faqContainer, "2");
			}
		});
		
		statisticViewQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				c1.show(faqContainer, "3");
			}
		});
		
		deletedStatisticsQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				c1.show(faqContainer, "4");
			}
		});
		
	}
}
