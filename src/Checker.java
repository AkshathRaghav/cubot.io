import java.util.ArrayList ;

// Handles most of the Cubot work
public class Checker extends Moves {

    public Checker(String[] s) throws IllegalArgumentException {
        super(s) ;
    }

    //shorten - shortens the solution returned
    public String shorten(String s ) { }



    //converts String to alg ( to shorten the work ) - makes use of choose(ch)
    public String stringalg(String str) {  }

    //public method to solve and return solution
    public String solve() {  }

    public boolean isSolved() {
        return cubie.solved(end) ;
    }

    public String[][][][] getSolvedCube() { return end.getCube() ; }

    public ArrayList<String> compareToSolved() { }

}



