package database;

import java.util.ArrayList;

public class ComparePlayers {
	
	private static float[] localScores;
	private static float[] mlbScores;
	private static float[] differenceNums;
	
	public static ArrayList<MlbPlayer> compareToPlayerList(LocalPlayer lp, ArrayList<MlbPlayer> mlbList) {
		return mlbList;
	}
	
	public static float compareToPlayer(LocalPlayer lb, MlbPlayer mlbPlayer) {
		loadScores(lb, mlbPlayer);
		int startScore = 1000;
		for(int i = 0; i < differenceNums.length; i++) {
			startScore -= returnDifference(localScores[i], mlbScores[i]);
		}
		return 50.0f;
	}
	
	private static int returnDifference(float firstNum, float secNum) {
		
		return 1;
	}
	
	private static void loadScores(LocalPlayer lb, MlbPlayer mlbPlayer) {
		System.out.println("Not implemented");
	}

}
