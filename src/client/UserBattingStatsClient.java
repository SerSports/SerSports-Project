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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
	//private double battingAverage = 0.0;
	private final String submit = "Submit";
	private final String update = "Update";
	private int currentSelectedRowForUpdate;
	
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
/*	public void setBattingAverage(double hit, double atBats)
	{
		if (atBats != 0)
			battingAverage = hit / atBats;
		else
			battingAverage = 0.0;
	}
	*/
	/**
	 * @return Selected player's batting average.
	 */
/*	public double getBattingAverage()
	{
		return battingAverage;
	}*/
	
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
				submitOrUpdateBattingStatistic(submit);
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
			
			currentSelectedRowForUpdate = table.getSelectedRow();
			if (currentSelectedRowForUpdate >= 0)
			{
				
				/*
				 * Displays warning window asking the user if they would like to follow
				 * through with updating the selected statistic.
				 */
				int result = JOptionPane.showConfirmDialog(
								null, "Are you sure you want to update the highlighted game statistic?",
								null, JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION)
				{
					try
					{
						submitOrUpdateBattingStatistic(update);
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
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "StatID", "Won",
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
				//setBattingAverage( (double) m.getBatting_onbase_h(), (double) m.getBatting_ab());
				String won = new String(m.getBatting_game_won() == 1 ? "X" : "");
				Object[] row = { m.getLocalPlayersHittingStatisticsID(), won,
						m.getGame_date(), m.getBatting_ab(), m.getBatting_onbase_h(),
						m.getBatting_rbi(), m.getBatting_onbase_s(), 
						m.getBatting_onbase_d(), m.getBatting_onbase_t(),
						m.getBatting_runs_total(), m.getBatting_steal_stolen(), 
						m.getBatting_onbase_hr(), m.getBatting_outs_ktotal(),
						m.getBattingAverage()};
				newTable.addRow(row);
			}
			
			table.setModel(newTable);
			table.removeColumn(table.getColumnModel().getColumn(0));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			
			table.getSelectionModel().addListSelectionListener(
					new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent e){
							if(table.getSelectedRow() != -1){
								int selectedRow = table.getSelectedRow();
								txtDate.setText(table.getValueAt(selectedRow, 1).toString());
								txtAB.setText(table.getValueAt(selectedRow, 2).toString());
								txtHits.setText(table.getValueAt(selectedRow, 3).toString());
								txtRBI.setText(table.getValueAt(selectedRow, 4).toString());
								txtb_1.setText(table.getValueAt(selectedRow, 5).toString());
								txtb_2.setText(table.getValueAt(selectedRow, 6).toString());
								txtb_3.setText(table.getValueAt(selectedRow, 7).toString());
								txtRuns.setText(table.getValueAt(selectedRow, 8).toString());
								txtSB.setText(table.getValueAt(selectedRow, 9).toString());
								txtHR.setText(table.getValueAt(selectedRow, 10).toString());
								txtSO.setText(table.getValueAt(selectedRow, 11).toString());
							}
						}
					});
		}
	}
	
	/**
	 * Allows user to submit input on all batting statistics and checks to ensure that the
	 * date was entered in the specified format. If it was entered in an invalid format,
	 * it will throw an error message and ask the user to resubmit.
	 */
	public void submitOrUpdateBattingStatistic(String type)
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
		Boolean won = (comboBox.getSelectedItem().toString().equals("Win"));
		
		clearSelected();
		
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
			
			if("Submit".equals(type))
			{
				LocalPlayerBattingStatistics.addOrUpdateLocalPlayerBattingStatistics(date, ab, h,
						rbi, b1, b2, b3, runs, sb, hr, so, won, -1);
			}
			else
			{
				int selectedStatisticID = (int) table.getModel().getValueAt(currentSelectedRowForUpdate, 0);
				LocalPlayerBattingStatistics.addOrUpdateLocalPlayerBattingStatistics(date, ab, h,
						rbi, b1, b2, b3, runs, sb, hr, so, won, selectedStatisticID);
			}
			
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
		
		resetTextFields();
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
	 * Also resets the "dirty" flag to determine if the user is currently adding statistics
	 * to the text fields.
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
		TextFieldDocumentListener.setDirty();
	}
	
	/**
	 * Resets the highlighted row in the JTable. Used when a user is updating a statistic
	 */
	public void clearSelected(){
		table.clearSelection();
		table.getSelectionModel().clearSelection();
	}
}
