import java.util.ArrayList;

public class Checker2 extends Moves2 {
    private final String[] temp =  {"RRRR", "GGGG", "OOOO", "BBBB", "WWWW", "YYYY"};
    private final Cube2 end = new Cube2(temp) ;
    private final String[] movesString = {"R", "R'", "L", "L'", "U", "U'", "D", "D'", "F", "F'", "B" , "B'", "U2", "F2", "R2", "L2",  "M2"} ;
    public Checker2(String[] s) throws IllegalArgumentException {
        super(s);
    }
    public boolean isSolved() {
        return cubie.solved(end) ;
    }
    public String[][][][] getSolvedCube() {
        return end.getCube() ;
    }
    public ArrayList<String> compareToSolved() {
        String[][][][] endarray = end.getCube() ;
        ArrayList<String> change = new ArrayList<String>() ;
        for (int j = 0; j < cubearray.length; j++) {
            for (int i = 0; i < cubearray.length; i++) {
                for (int k = 0; k < cubearray.length; k++) {
                     if ( !( cubearray[i][j][k][1].equals(endarray[i][j][k][1]) && cubearray[i][j][k][2].equals(endarray[i][j][k][2]) || cubearray[i][j][k][0].equals(endarray[i][j][k][0]) )) { change.add("( " +i + " " + j + " " + k + " : T/b - " + endarray[i][j][k][0] + " . Side - " + endarray[i][j][k][1]  + " . F/B - " + endarray[i][j][k][2] + " ) " ) ;
                    }
                }
            }
        }
        return change ;
    }
    public String getScramble(int n, boolean check) {
        StringBuilder s = new StringBuilder(" ");
        for (int i = 0; i < n; i++) {
            int x = (int) (Math.random() * movesString.length);
            s.append(movesString[x]).append(" ");
        }
        if (check) {
            return stringalg(s.toString());
        }
        else { return s.toString() ; }
    }

    // If you add non-executable moves, Cubot will ignore
    public String stringalg(String str) {
        String s = str.trim();
        while (str.contains(" ")) {
            choose(str.substring(0, str.indexOf(" ")));
            str = str.substring(str.indexOf(" ") +1 ) ;
        }
        choose(str);
        return s ;

    }
    public String reversealg(String str, boolean check) {
        String s = "" ;
        while (str.contains(" ")) {
            s = reversedo(str.substring(0, str.indexOf(" "))) + " " + s ;
            str = str.substring(str.indexOf(" ") +1 ) ;
        }
        s = reversedo(str) + " " + s ;
        if (check) {
            stringalg(s);
        }
        return s;

    }
//    public String slotter(int x, int y, int z) {
//
//    }
//    public String bottom(String base) {
//        for
//
//
//
//    }
//
//    public String solve() {
//        String base = cubearray[1][0][0][0] ;
//        for (int i =0 ; i <2 ; i++) {
//            for(int j = 0 ; j < 2 ; j++ ) {
//
//        return bottom(base) ;
//    }














    private void choose(String ch) {
        switch (ch) {
            case "R" -> R();
            case "R'" -> Rdash();
            case "L'" -> Ldash();
            case "L" -> L();
            case "U" -> U();
            case "U'" -> Udash();
            case "F" -> F();
            case "F'" -> Fdash();
            case "B" -> B();
            case "B'" -> Bdash();
            case "D" -> D();
            case "D'" -> Ddash();
            case "R2" -> R2();
            case "L2" -> L2();
            case "U2", "U2'" -> U2();
            case "F2" -> F2();
            case "B2" -> B2();
            case "D2" -> D2();

        }
    }
    private String reversedo(String s) {
        String monthString ="" ; // random thing i copied, just rename later
        switch (s) {
            case "R":  monthString = "R'";
                break;
            case "R'":  monthString = "R";
                break;
            case "L":  monthString = "L'";
                break;
            case "L'":  monthString = "L";
                break;
            case "U":  monthString = "U'";
                break;
            case "U'":  monthString = "U";
                break;
            case "D":  monthString = "D'";
                break;
            case "D'":  monthString = "D";
                break;
            case "F":  monthString = "F'";
                break;
            case "F'": monthString = "F";
                break;
            case "B": monthString = "B'";
                break;
            case "B'": monthString = "B";
                break;

            default: monthString = s ;
        }
        return monthString ;

    }



}
