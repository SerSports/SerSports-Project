package database;

import java.util.ArrayList;

public class ComparePlayers {
	
	
	public static MlbPlayer compareToPlayerList(LocalPlayer lp, ArrayList<MlbPlayer> mlbList) {
		return mlbList.get(0);
	}
	
	public static float compareToPlayer(LocalPlayer lb, MlbPlayer mlbPlayer) {
		return 50.0f;
	}

}
