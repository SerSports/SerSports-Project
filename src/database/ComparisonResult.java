package database;

import java.util.Comparator;

public class ComparisonResult {
	private MlbPlayer player;
	private float score;
	
	public MlbPlayer getPlayer() {
		return player;
	}

	public float getScore() {
		return score;
	}
	
	public ComparisonResult(MlbPlayer player, float score) {
		this.player = player;
		this.score = score;
	}
	
	public static class ComparisonResultComparator implements Comparator<ComparisonResult>
	{
	    @Override
	    public int compare(ComparisonResult x, ComparisonResult y)
	    {
	        if (x.getScore() < y.getScore())
	        {
	            return 1;
	        }
	        if (x.getScore() > y.getScore())
	        {
	            return -1;
	        }
	        return 0;
	    }
	}
}