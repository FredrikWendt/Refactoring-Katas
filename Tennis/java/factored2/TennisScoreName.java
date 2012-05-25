package factored1;

public class TennisScoreName {

	public static final String[] POINTS = new String[] { "Love", "Fifteen", "Thirty", "Forty" };

	public static String getScoreName(int score) {
		return POINTS[score];
	}

}
