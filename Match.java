


package def;

import java.util.Scanner;

public class Match {
    protected int typeOfMatch; //v = 0, d = 1, t = 2
    protected Referee referee;
    protected String finalScore;
    protected Team teamOne;
    protected Team teamTwo;
    protected Team winner;
    //isScoreSet odpowiada za to, czy wczesniej zostal ustalony wynik.
    // To glownie decyduje o wyswietlaniu sie prawidlowego komunikatu przy probie wyswietlenia meczu.
    protected boolean isScoreSet = false;
    protected int setsOfLoser = 0;


    public Match(Team teamOne, Team teamTwo, Referee ref, int typeOfMatch) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        referee = ref;
        this.typeOfMatch = typeOfMatch;
        referee.documentMatch();
    }

    protected void setFinalScoreString(int setsOfLoserUsedInMethod) {
        if (winner.equals(teamOne)) {
            finalScore += "3:";
            finalScore += setsOfLoserUsedInMethod;
        } else {
            finalScore += setsOfLoserUsedInMethod;
            finalScore += ":3";
        }
    }

    //ustawianie wyniku
    public void setResult() {
        finalScore = "";
        boolean check = true;
        System.out.println("\nKto wygral? Wcisnij \'1\', jezeli " + teamOne + ", a \'2\', jezeli " + teamTwo + "\nTwoj wybor:");
        Scanner in = new Scanner(System.in);
        int result;
        do {
            result = in.nextInt();
            if (result >= 1 && result <= 2)
                check = false;
        } while (check);
        if (result == 1)
            winner = teamOne;
        else
            winner = teamTwo;
        check = true;
        System.out.println("\nIle setow druga druzyna wygrala? Wybierz miedzy wartoscia 0, 1 oraz 2\nTwoj wybor:");
        do {
            setsOfLoser = in.nextInt();
            if (setsOfLoser >= 0 && setsOfLoser <= 2)
                check = false;
        } while (check);
        isScoreSet = true;
        setFinalScoreString(setsOfLoser);
    }

    //przypisywanie wyniku, setow, wygranych/przegranych dla danej druzyny
    public void assignPointsAndSets() {
        //wygrany dostaje punkty, wygrana do statystyk oraz wygrane sety
        winner.WonAMatch();
        //ustalanie przegranego oraz dawanie mu setow, ktore wygral
        if (winner.equals(teamOne))
            teamTwo.LostAMatch(setsOfLoser);
        else
            teamOne.LostAMatch(setsOfLoser);
    }

    public Team getWinner() {
        return winner;
    }

    public Team getLoser() {
        if (winner.equals(teamOne))
            return teamTwo;
        else
            return teamOne;
    }

    public String toString() {
        if (isScoreSet)
            return "Zespoly: " + teamOne + " i " + teamTwo + " Sędzia:" + referee + ". Zwyciezca:" + winner + ". Wynik: " + finalScore + "\n";
        else
            return "Zespoly: " + teamOne + " i " + teamTwo + " Sędzia:" + referee + ". Zwyciezca: nieustalony. Wynik: nieustalony\n";

    }
}

