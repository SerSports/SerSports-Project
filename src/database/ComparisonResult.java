package database;

import java.util.Comparator;

/**
 * Used to access both the player object and its score at the same time.
 * 
 * @author SerSports
 */
public class ComparisonResult
{
	private MlbPlayer player;
	private float score;
	
	/**
	 * @return Player object
	 */
	public MlbPlayer getPlayer()
	{
		return player;
	}
	
	/**
	 * @return Player's score
	 */
	public float getScore()
	{
		return score;
	}
	
	public ComparisonResult(MlbPlayer player, float score)
	{
		this.player = player;
		this.score = score;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * Ensures no scores that are derived are negative.
	 */
	public static class ComparisonResultComparator implements
			Comparator<ComparisonResult>
	{
		@Override
		public int compare(ComparisonResult x, ComparisonResult y)
		{
			if (Float.compare(x.getScore(), y.getScore()) < 0)
			{
				return 1;
			}
			if (Float.compare(x.getScore(), y.getScore()) > 0)
			{
				return -1;
			}
			return 0;
		}
	}
}
