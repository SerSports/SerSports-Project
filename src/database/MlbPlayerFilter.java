package database;

/**
Class:	MlbPlayerFilter

Description: This class is used to create the Filter Criteria that the MlbPlayer Class uses.
*/
public class MlbPlayerFilter {

	// Values to Filter By
	private String idValue = null;
	private String firstNameValue = null;
	private String lastNameValue = null;
	private String teamNameValue = null;

	// Setters
	public void setIdValue(String idValue) {
		if (idValue != null && idValue.length() > 0) {
			this.idValue = idValue;
		}
	}
	public void setFirstNameValue(String firstNameValue) {
		if (firstNameValue != null && firstNameValue.length() > 0 && !firstNameValue.equals("First Name")) {
			this.firstNameValue = firstNameValue;
		}
	}
	public void setLastNameValue(String lastNameValue) {
		if (lastNameValue != null && lastNameValue.length() > 0 && !lastNameValue.equals("Last Name")) {
			this.lastNameValue = lastNameValue;
		}
	}
	public void setTeamNameValue(String teamNameValue) {
		if (teamNameValue != null && teamNameValue.length() > 0 && !teamNameValue.equals("Team")) {
			this.teamNameValue = teamNameValue;
		}
	}

	// Methods
	public String getWhereClause() {
		StringBuilder whereClause = new StringBuilder();
		String result = new String("");
		
		// See if anything was passed in
		if (idValue != null || firstNameValue != null || lastNameValue != null || teamNameValue != null) {
					
			// Add the fields we need
			whereClause = addCriteriaToStringBuilder(whereClause, "mlbPlayerId", idValue);
			whereClause = addCriteriaToStringBuilder(whereClause, "firstName", firstNameValue);
			whereClause = addCriteriaToStringBuilder(whereClause, "lastName", lastNameValue);
			whereClause = addCriteriaToStringBuilder(whereClause, "team_name", teamNameValue);
			
			result = "WHERE " + whereClause.toString();
		}
		return result;
	}
	
	private StringBuilder addCriteriaToStringBuilder(StringBuilder builder, String fieldName, String value) {
	
		if (value != null) {
			
			// If there is already criteria, add an "AND" 
			if (builder.length() > 0) {
				builder.append(" AND ");
			}
			
			// Add the criteria
			builder.append(fieldName + " = \"" + value + "\"");
			
		}
		
		return builder;
	}
}
