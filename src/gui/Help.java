package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * GUI containing all components of the FAQ page including the panels for all questions
 * and the panels that are displayed for each answer respective to the questions
 * 
 * @author SerSports
 */
public class Help extends JPanel
{
	private static final long serialVersionUID = -2930809141431853923L;
	CardLayout c1 = new CardLayout();
	JPanel faqContainer = new JPanel();
	
	/*
	 * List of frequently asked questions
	 */
	protected ModifiedJButtonStyle1 ageRequirementQ = new ModifiedJButtonStyle1(
			"Is there an age requirement to create an account?");
	protected ModifiedJButtonStyle1 abbreviationsQ = new ModifiedJButtonStyle1(
			"List of common baseball abbreviations");
	protected ModifiedJButtonStyle1 similarityQ = new ModifiedJButtonStyle1(
			"How is the similarity between players determined?");
	protected ModifiedJButtonStyle1 statisticViewQ = new ModifiedJButtonStyle1(
			"Will other people be able to see my statistics?");
	protected ModifiedJButtonStyle1 deletedStatisticsQ = new ModifiedJButtonStyle1(
			"Can I retrieve deleted statistics?");
	
	AgeRequirementQ ageRequirement = new AgeRequirementQ();
	AbbreviationsQ abbreviations = new AbbreviationsQ();
	DeletedStatisticsQ deletedStats = new DeletedStatisticsQ();
	SimilarityQ similarity = new SimilarityQ();
	StatisticViewQ viewStats = new StatisticViewQ();
	
	/**
	 * Creates the panel for all of the frequently asked questions
	 */
	public Help()
	{
		add(faqContainer);
		faqContainer.setPreferredSize(new Dimension(345, 424));
		faqContainer.setBackground(Color.WHITE);
		faqContainer.setBounds(510, 87, 345, 424);
		setPreferredSize(new Dimension(1000, 600));
		setLayout(null);
		setBackground(new Color(47, 52, 64));
		faqContainer.setLayout(c1);
		faqContainer.add(ageRequirement, "1");
		faqContainer.add(abbreviations, "2");
		faqContainer.add(similarity, "3");
		faqContainer.add(viewStats, "4");
		faqContainer.add(deletedStats, "5");
		
		JLabel lblEnter = new JLabel("FAQ");
		lblEnter.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 20));
		lblEnter.setBounds(477, 37, 46, 29);
		lblEnter.setForeground(new Color(244, 229, 192));
		add(lblEnter);
		
		JLabel logo = new JLabel("");
		logo.setBounds(6, 0, 152, 55);
		add(logo);
		Image img = new ImageIcon(this.getClass().getResource("/images/LogoBottom.png"))
				.getImage();
		logo.setIcon(new ImageIcon(img));
		
		ageRequirementQ.setBounds(79, 180, 412, 29);
		add(ageRequirementQ);
		
		abbreviationsQ.setBounds(79, 221, 412, 29);
		add(abbreviationsQ);
		
		similarityQ.setBounds(79, 262, 412, 29);
		add(similarityQ);
		
		statisticViewQ.setBounds(79, 303, 412, 29);
		add(statisticViewQ);
		
		deletedStatisticsQ.setBounds(79, 344, 412, 29);
		add(deletedStatisticsQ);
		
		/*
		 * Displays all answers for the questions when they are selected
		 */
		ageRequirementQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				c1.show(faqContainer, "1");
			}
		});
		
		abbreviationsQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				c1.show(faqContainer, "2");
			}
		});
		
		similarityQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				c1.show(faqContainer, "3");
			}
		});
		
		statisticViewQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				c1.show(faqContainer, "4");
			}
		});
		
		deletedStatisticsQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				c1.show(faqContainer, "5");
			}
		});
		
	}
}
