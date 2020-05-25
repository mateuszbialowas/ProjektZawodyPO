package def;

public class Match {
	protected int typeOfMatch; //v = 0, d = 1, t = 2
	protected Referee referee;
	protected String finalScore;
	protected Team teamOne;
	protected Team teamTwo;
	protected Team winner;
	
	
	
	public Match(Team teamOne, Team teamTwo, Referee ref, int typeOfMatch) {
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		referee = ref;
		this.typeOfMatch = typeOfMatch;
		setResult();
	}
	
	protected void showFinalScore() {
		
	}
	
	public void setResult() {
		int setsOfLoser=0;
		boolean check=true;
		System.out.println("Kto wygral? Wcisnij \'1\', jezeli "+teamOne+", a \'2\', jezeli "+teamTwo);
		Scanner in = new Scanner("System.in");
		int result;
		do {
			result=in.nextInt();
			if(result>=1 && result<=2)
				check=false;
		}while(check);
		if(result==1)
			winner = teamOne;
		else
			winner = teamTwo;
		//wygrany dostaje punkty, wygrana do statystyk oraz wygrane sety
		winner.WonAMatch();
		check=true;
		System.out.println("Ile setow druga druzyna wygrala? Wybierz miedzy wartoscia 0, 1 oraz 2");
		do {
			setsOfLoser = in.nextInt;
			if(setsOfLoser>=0 && setsOfLoser<=2)
				check=false;
		}while(check);
		//ustalanie przegranego oraz dawanie mu setow, ktore wygral
		if(winner.equals(teamOne))
			teamTwo.LostAMatch(setsOfLoser);
		else
			teamOne.LostAMatch(setsOfLoser);
	}
	
	public String getFinalScore() {
		return finalScore;
	}
	
	public String toString() {
		String typeOfMatchInString;
		switch (typeOfMatch)
		{
			case 0:
				typeOfMatchInString="Siatkowka";
				break;
			case 1:
				typeOfMatchInString="Dwa ognie";
				break;
			case 2:
				typeOfMatchInString="Przeciaganie liny";
				break;
		}
		return "Konkurencja"+typeOfMatchInString+". "+teamOne+" i "+ teamTwo+". Zwyciezca:"+winner+". Wynik "+finalScore;
	}
	
}
