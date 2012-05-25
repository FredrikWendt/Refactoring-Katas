package factored1;

import static factored1.TennisScoreName.getScoreName;

public class TennisGame {

	private int player2Score;
	private int player1Score;

	private String player1Name;
	private String player2Name;

	public TennisGame(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public String getScore() {
		if (isEndGame()) {
			return endGameScore();
		} else if (pointsAreEven()) {
			return getScoreName(player1Score) + "-All";
		} else {
			return getScoreName(player1Score) + "-" + getScoreName(player2Score);
		}
	}

	public void wonPoint(String playerName) {
		if (player1Name.equals(playerName)) {
			this.player1Score += 1;
		} else {
			this.player2Score += 1;
		}
	}

	private String endGameScore() {
		if (onePlayerLeadsWithAtLeastTwoPoints()) {
			return "Win for " + leadingPlayerName();
		}
		if (pointsAreEven()) {
			return "Deuce";
		} else {
			return "Advantage " + leadingPlayerName();
		}
	}

	private boolean onePlayerLeadsWithAtLeastTwoPoints() {
		return player1Score - player2Score >= 2 || player2Score - player1Score >= 2;
	}

	private boolean pointsAreEven() {
		return player1Score == player2Score;
	}

	private boolean isEndGame() {
		return player1Score > 3 || player2Score > 3;
	}

	private String leadingPlayerName() {
		if (player1Score > player2Score) {
			return player1Name;
		} else {
			return player2Name;
		}
	}

}
