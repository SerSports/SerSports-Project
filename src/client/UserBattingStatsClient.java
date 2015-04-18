package client;

import gui.*;
import database.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Allows user to manipulate, view, and update statistics pertaining to batting. Includes
 * the calculation of batting average as well as a method to validate the date entered by
 * the user to confirm formatting.
 * 
 * @author SerSports
 */
public class UserBattingStatsClient extends UserBattingStats implements ActionListener
{
	
	private static final boolean debugOn = true;
	private double battingAverage = 0.0;
	
	
	/**
	 * Adds action listeners to relevant buttons.
	 */
	public UserBattingStatsClient()
	{
		submitBattingStats.addActionListener(this);
		btnUpdateStatistic.addActionListener(this);
		btnDeleteStatistic.addActionListener(this);
	}
	
	/**
	 * Debugs when boolean results to true.
	 * 
	 * @param message
	 */
	public void debug(String message)
	{
		if (debugOn)
		{
			System.out.println("debug: " + message);
		}
	}
	
	/**
	 * Calculates batting average by dividing the player's number of hits by their amount
	 * of times up to bat.
	 * 
	 * @param hit
	 *            Total number of hits accrued from selected player.
	 * @param atBats
	 *            Total number of plate appearances accrued from selected player.
	 */
	public void setBattingAverage(double hit, double atBats)
	{
		if (atBats != 0)
			battingAverage = hit / atBats;
		else
			battingAverage = 0.0;
	}
	
	/**
	 * @return Selected player's batting average.
	 */
	public double getBattingAverage()
	{
		return battingAverage;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * A series of actions to be performed when the relevant buttons are selected. Buttons
	 * include pop-up messages if necessary, warning the user to to double check their
	 * changes before submitting.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("SubmitBattingStats"))
		{
			try
			{
				submitBattingStatistic();
			}
			catch (RuntimeException ex)
			{
				throw ex;
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		if (e.getActionCommand().equals("UpdateStatistic"))
		{
			
			int selectedRow = table.getSelectedRow();
			if (selectedRow >= 0)
			{
				
				/*
				 * Displays warning window asking the user if they would like to follow
				 * through with updating the selected statistic.
				 */
				int result = JOptionPane
						.showConfirmDialog(
								null,
								"Are you sure you want to update the highlighted game statistic?",
								null, JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION)
				{
					updateBattingStatistic();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,
						"Please select a row in which you would like to update",
						"InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		if (e.getActionCommand().equals("DeleteStatistic"))
		{
			int selectedRow = table.getSelectedRow();
			if (selectedRow >= 0)
			{
				
				/*
				 * Displays warning window asking the user if they would like to follow
				 * through with deleting the selected statistic.
				 */
				int result = JOptionPane
						.showConfirmDialog(
								null,
								"WARNING: Are you sure you want to delete the highlighted game statistic?",
								null, JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION)
				{
					deleteBattingStatistic();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,
						"Please select a row in which you would like to delete",
						"InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	/**
	 * Populates the default model for the Local Player's Batting Table, hosting only
	 * those statistics relevant to batting.
	 */
	public void populateLocalPlayersBattingTable()
	{
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "StatID",
				"Date", "AB", "H", "RBI", "1B", "2B", "3B", "Runs", "SB", "HR", "SO",
				"BA" }, 0);
		
		if (User.getCurrentUser() != null)
		{
			User currentLoggedInUser = User.getCurrentUser();
			Integer id_in = currentLoggedInUser.getLocalPlayerId();
			
			ArrayList<LocalPlayerBattingStatistics> currentPlayerBattingStatistics = LocalPlayerBattingStatistics
					.getStatisticsFromDatabase(id_in);
			
			for (LocalPlayerBattingStatistics m : currentPlayerBattingStatistics)
			{
				setBattingAverage((double) m.getHitting_onbase_h(),
						(double) m.getHitting_ab());
				Object[] row = { m.getLocalPlayersHittingStatisticsID(),
						m.getGame_date(), m.getHitting_ab(), m.getHitting_onbase_h(),
						m.getHitting_rbi(), m.getHitting_onbase_s(),
						m.getHitting_onbase_d(), m.getHitting_onbase_t(),
						m.getHitting_runs_total(), m.getHitting_steal_stolen(),
						m.getHitting_onbase_hr(), m.getHitting_outs_ktotal(),
						getBattingAverage() };
				newTable.addRow(row);
			}
			
			table.setModel(newTable);
			table.removeColumn(table.getColumnModel().getColumn(0));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		}
	}
	
	/**
	 * Allows user to submit input on all batting statistics and checks to ensure that the
	 * date was entered in the specified format. If it was entered in an invalid format,
	 * it will throw an error message and ask the user to resubmit.
	 */
	public void submitBattingStatistic()
	{
		
		String date = txtDate.getText();
		String ab = txtAB.getText();
		String h = txtHits.getText();
		String rbi = txtRBI.getText();
		String b1 = txtb_1.getText();
		String b2 = txtb_2.getText();
		String b3 = txtb_3.getText();
		String runs = txtRuns.getText();
		String sb = txtSB.getText();
		String hr = txtHR.getText();
		String so = txtSO.getText();
		
		boolean valid = isValidDate(date); // Date in the form of "YYYY-MM-DD"
		
		if (valid == true)
		{
			isValidInput(ab);
			isValidInput(h);
			isValidInput(rbi);
			isValidInput(b1);
			isValidInput(b2);
			isValidInput(b3);
			isValidInput(runs);
			isValidInput(sb);
			isValidInput(hr);
			isValidInput(so);
			
			LocalPlayerBattingStatistics.addLocalPlayerBattingStatistics(date, ab, h,
					rbi, b1, b2, b3, runs, sb, hr, so);
			
			loadUserInfoIntoControls();
			
			resetTextFields();
		}
		else
		{
			JOptionPane.showMessageDialog(null,
					"Please add correct date in YYYY-MM-DD format",
					"InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Allows user to delete a statistic at their discretion by obtaining the value of the
	 * selected row and removing it from the table hosting the batting statistics.
	 */
	public void deleteBattingStatistic()
	{
		
		int selectedRow = table.getSelectedRow();
		
		int selectedStatisticID = (int) table.getModel().getValueAt(selectedRow, 0);
		LocalPlayerBattingStatistics
				.deleteLocalPlayerBattingStatistic(selectedStatisticID);
		
		loadUserInfoIntoControls();
	}
	
	/**
	 * Deletes the selected statistic and then replaces it with the updated one.
	 */
	public void updateBattingStatistic()
	{
		String date = txtDate.getText();
		boolean valid = isValidDate(date); // Date in the form of "YYYY-MM-DD"
		if (valid)
		{
			deleteBattingStatistic();
			submitBattingStatistic();
		}
	}
	
	/**
	 * Reloads the Local Player's Batting Statistics Table with the relevant information.
	 */
	public void loadUserInfoIntoControls()
	{
		populateLocalPlayersBattingTable();
	}
	
	/**
	 * Checks that the date entered by the user is in the format "YYYY-MM-DD".
	 * 
	 * @param gameDate
	 *            Date entered by the user.
	 * @return Boolean that returns true if date is formatted correctly and false if the
	 *         contrary.
	 */
	public boolean isValidDate(String gameDate)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		boolean result = true;
		
		try
		{
			dateFormat.parse(gameDate);
		}
		catch (ParseException e)
		{
			result = false;
		}
		
		return result;
	}
	
	/**
	 * Sets the user input to null if the user enters invalid information.
	 * 
	 * @param userInput
	 *            Input provided by the user
	 * @return Null if user entered anything invalid or the original input if user's input
	 *         is valid.
	 */
	public String isValidInput(String userInput)
	{
		String result;
		
		if (userInput.equals("") || userInput.length() == 0)
		{
			result = null;
		}
		else
		{
			result = userInput;
		}
		
		try
		{
			Integer.parseInt(userInput);
		}
		catch (Exception e)
		{
			result = null;
		}
		
		return result;
	}
	
	/**
	 * Resets the text fields back to their default values containing just the name of
	 * that particular statistic. This is applied when the user alters statistics and then
	 * submits or if they delete the default values and then click on a different field.
	 */
	public void resetTextFields()
	{
		txtDate.setText(getDateTxt());
		txtAB.setText(getABTxt());
		txtHits.setText(getHitsTxt());
		txtRBI.setText(getRBITxt());
		txtb_1.setText(getB1Txt());
		txtb_2.setText(getB2Txt());
		txtb_3.setText(getB3Txt());
		txtRuns.setText(getRunsTxt());
		txtSB.setText(getSBTxt());
		txtHR.setText(getHRTxt());
		txtSO.setText(getSOTxt());
	}
}
