package database;

/**
 * Creates Filter Criteria to better manage data in the MlbPlayer Class
 * 
 * @author SerSports
 */
public class MlbPlayerFilter
{
	
	/*
	 * Filter Values
	 */
	private String idValue = null;
	private String firstNameValue = null;
	private String lastNameValue = null;
	private String teamNameValue = null;
	
	/**
	 * Ensures the Id has a value and is not empty
	 * 
	 * @param idValue
	 *            Identifier assigned to all players
	 */
	public void setIdValue(String idValue)
	{
		if (idValue != null && idValue.length() > 0)
		{
			this.idValue = idValue;
		}
	}
	
	/**
	 * Ensures the first name has a value and is not empty
	 * 
	 * @param firstNameValue
	 *            Player's first name
	 */
	public void setFirstNameValue(String firstNameValue)
	{
		if (firstNameValue != null && firstNameValue.length() > 0
				&& !firstNameValue.equals("First Name"))
		{
			this.firstNameValue = firstNameValue;
		}
	}
	
	/**
	 * Ensures the last name has a value and is not empty
	 * 
	 * @param lastNameValue
	 *            Player's last name
	 */
	public void setLastNameValue(String lastNameValue)
	{
		if (lastNameValue != null && lastNameValue.length() > 0
				&& !lastNameValue.equals("Last Name"))
		{
			this.lastNameValue = lastNameValue;
		}
	}
	
	/**
	 * Ensures the team name has a value and is not empty
	 * 
	 * @param teamNameValue
	 *            Name of the Player's team
	 */
	public void setTeamNameValue(String teamNameValue)
	{
		if (teamNameValue != null && teamNameValue.length() > 0
				&& !teamNameValue.equals("Team"))
		{
			this.teamNameValue = teamNameValue;
		}
	}
	
	/**
	 * Checks to see if any values were passed in and adds the necessary fields to a
	 * string builder
	 * 
	 * @return String built from the fields that passed through
	 */
	public String getWhereClause()
	{
		StringBuilder whereClause = new StringBuilder();
		String result = new String("");
		
		if (idValue != null || firstNameValue != null || lastNameValue != null
				|| teamNameValue != null)
		{
			whereClause = addCriteriaToStringBuilder(whereClause, "mlbPlayerId", idValue);
			whereClause = addCriteriaToStringBuilder(whereClause, "firstName", firstNameValue);
			whereClause = addCriteriaToStringBuilder(whereClause, "lastName", lastNameValue);
			whereClause = addCriteriaToStringBuilder(whereClause, "team_name", teamNameValue);
			
			result = "WHERE " + whereClause.toString();
		}
		
		return result;
	}
	
	/**
	 * Concatenates criteria with an "AND" if there are multiple filters induced
	 * 
	 * @param builder
	 *            StringBuilder being appended to
	 * @param fieldName
	 *            Name of the filter being applied
	 * @param value
	 *            Value that qualifies for the filter
	 * @return
	 */
	private StringBuilder addCriteriaToStringBuilder(StringBuilder builder,
			String fieldName, String value)
	{
		
		if (value != null)
		{
			if (builder.length() > 0)
			{
				builder.append(" AND ");
			}
			
			builder.append(fieldName + " = \"" + value + "\"");
		}
		
		return builder;
	}
}
