package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import gui.*;
import database.*;

/**
 * Allows user to manipulate, view, and update statistics pertaining to batting. Includes
 * a method to validate the date entered by the user to confirm formatting.
 * 
 * @author SerSports
 */
public class UserPitchingStatsClient extends UserPitchingStats implements ActionListener
{
	
	private static final boolean debugOn = true;
	private final String submit = "Submit";
	private final String update = "Update";
	private int currentSelectedRowForUpdate;
	
	/**
	 * Adds action listeners to relevant buttons.
	 */
	public UserPitchingStatsClient()
	{
		SubmitPitchingStats.addActionListener(this);
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
	
	/*
	 * (non-Javadoc)
	 * 
	 * Calls methods relevant to the button selected by the user.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("SubmitPitchingStats"))
		{
			try
			{
				submitOrUpdatePitchingStatistic(submit);
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
				int result = JOptionPane
						.showConfirmDialog(
								null,
								"Are you sure you want to update the highlighted game statistic?",
								null, JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION)
				{
					try
					{
						submitOrUpdatePitchingStatistic(update);
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
								null, JOptionPane.YES_NO_CANCEL_OPTION);
				
				if (result == JOptionPane.YES_OPTION)
				{
					deletePitchingStatistic();
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
	 * Populates the default model for the Local Player's Fielding Table, hosting only
	 * those statistics relevant to fielding.
	 */
	public void populateLocalPlayersPitchingTable()
	{
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "StatID",
				"Date", "ERA", "SAVES", "HITS", "HOLDS", "RUNS", "HBP" }, 0);
		
		if (User.getCurrentUser() != null)
		{
			User currentLoggedInUser = User.getCurrentUser();
			Integer id_in = currentLoggedInUser.getLocalPlayerId();
			
			ArrayList<LocalPlayerPitchingStatistics> currentPlayerPitchingStatistics = LocalPlayerPitchingStatistics
					.getStatisticsFromDatabase(id_in);
			
			for (LocalPlayerPitchingStatistics m : currentPlayerPitchingStatistics)
			{
				Object[] row = { m.getLocalPlayersPitchingStatisticsID(),
						m.getGame_date(), m.getPitching_era(),
						m.getPitching_games_save(), m.getPitching_games_hit(),
						m.getPitching_games_hold(), m.getPitching_runs(),
						m.getPitching_hbp(), m.getPitching_game_won() };
				newTable.addRow(row);
			}
			
			table.setModel(newTable);
			table.removeColumn(table.getColumnModel().getColumn(0));
			
			table.getSelectionModel().addListSelectionListener(
					new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent e)
						{
							if (table.getSelectedRow() != -1)
							{
								int selectedRow = table.getSelectedRow();
								txtDate.setText(table.getValueAt(selectedRow, 0)
										.toString());
								txtERA.setText(table.getValueAt(selectedRow, 1)
										.toString());
								txtSaves.setText(table.getValueAt(selectedRow, 2)
										.toString());
								txtHits.setText(table.getValueAt(selectedRow, 3)
										.toString());
								txtHolds.setText(table.getValueAt(selectedRow, 4)
										.toString());
								txtRuns.setText(table.getValueAt(selectedRow, 5)
										.toString());
								txtHBP.setText(table.getValueAt(selectedRow, 6)
										.toString());
							}
						}
					});
		}
	}
	
	/**
	 * Allows user to submit input on all pitching statistics and checks to ensure that
	 * the date was entered in the specified format. If it was entered in an invalid
	 * format, it will throw an error message and ask the user to resubmit.
	 */
	public void submitOrUpdatePitchingStatistic(String type)
	{
		String date = txtDate.getText();
		String era = txtERA.getText();
		String saves = txtSaves.getText();
		String hits = txtHits.getText();
		String holds = txtHolds.getText();
		String runs = txtRuns.getText();
		String hbp = txtHBP.getText();
		Boolean won = (comboBox.getSelectedItem().toString().equals("Win"));
		
		clearSelected();
		
		boolean valid = isValidDate(date); // Date in the form of "YYYY-MM-DD"
		
		if (valid == true)
		{
			era = isValidFloatInput(era);
			saves = isValidInput(saves);
			hits = isValidInput(hits);
			holds = isValidInput(holds);
			runs = isValidInput(runs);
			hbp = isValidInput(hbp);
			
			if ("Submit".equals(type))
			{
				LocalPlayerPitchingStatistics.addOrUpdateLocalPlayerPitchingStatistics(
						date, won, era, saves, hits, holds, runs, hbp, -1);
			}
			else
			{
				int selectedStatisticID = (int) table.getModel().getValueAt(
						currentSelectedRowForUpdate, 0);
				LocalPlayerPitchingStatistics.addOrUpdateLocalPlayerPitchingStatistics(
						date, won, era, saves, hits, holds, runs, hbp,
						selectedStatisticID);
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
	 * selected row and removing it from the table hosting the pitching statistics.
	 */
	public void deletePitchingStatistic()
	{
		int selectedRow = table.getSelectedRow();
		
		int selectedStatisticID = (int) table.getModel().getValueAt(selectedRow, 0);
		LocalPlayerPitchingStatistics
				.deleteLocalPlayerPitchingStatistic(selectedStatisticID);
		
		loadUserInfoIntoControls();
		
		resetTextFields();
	}
	
	/**
	 * Reloads the Local Player's Fielding Statistics Table with the relevant information.
	 */
	public void loadUserInfoIntoControls()
	{
		populateLocalPlayersPitchingTable();
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
	 * Sets the user input to null if the user enters invalid information for integers.
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
	 * Sets the user input to null if the user enters invalid information for floats.
	 * 
	 * @param userInput
	 *            Input provided by the user
	 * @return Null if user entered anything invalid or the original input if user's input
	 *         is valid.
	 */
	public String isValidFloatInput(String userInput)
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
			Float.parseFloat(userInput);
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
	 * Also resets the "dirty" flag to determine if the user is currently adding
	 * statistics to the text fields.
	 */
	public void resetTextFields()
	{
		txtDate.setText(getDateTxt());
		txtERA.setText(getERATxt());
		txtSaves.setText(getSavesTxt());
		txtHits.setText(getHitsTxt());
		txtHolds.setText(getHoldsTxt());
		txtRuns.setText(getRunsTxt());
		txtHBP.setText(getHBPTxt());
		TextFieldDocumentListener.setDirty();
	}
	
	/**
	 * Resets the highlighted row in the JTable. Used when a user is updating a statistic.
	 */
	public void clearSelected()
	{
		table.clearSelection();
		table.getSelectionModel().clearSelection();
	}
}
