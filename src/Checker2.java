import java.util.ArrayList;

/**
 * Checker2 extends Moves2 class
 * <br>
 * It is also responsible for additional changes made to the
 * {@code Cube2} object in Moves2 class
 *
 * @author  Akshath Raghav
 * @version 2.0
 * @since   2021-06-15
 * @see Cube2
 * @see Checker2
 * @see Moves2
 * @see <a href="https://github.com/AkshathRaghav/cubot.io">cubot.io</a>
 */
public class Checker2 extends Moves2 {
    private final String[] temp =  {"RRRR", "GGGG", "OOOO", "BBBB", "WWWW", "YYYY"};
    private final Cube2 end = new Cube2(temp) ;
    private final String[] movesString = {"R", "R'", "L", "L'", "U", "U'", "D", "D'", "F", "F'", "B" , "B'", "U2", "F2", "R2", "L2",  "M2"} ;

    /**
     * Moves2 has-a Cube2
     * @param temp  String[] input from user containing the colors on each side
     * @throws      IllegalArgumentException on input error
     * @see         IllegalArgumentException
     * @see         Moves2
     */
    public Checker2(String[] temp) throws IllegalArgumentException {
        super(temp);
    }

    /**
     * Checks if the cube2 object held but the {@code Cube2} object in {@link Moves2} is solved
     *
     * @return boolean : true if solved, false otherwise
     */
    public boolean isSolved() {
        return cubie.solved(end) ;
    }

    /**
     * @return String[][][][] - {@code Cube2} in base form
     */
    public String[][][][] getSolvedCube() {
        return end.getCube() ;
    }

    /**
     * Returns all the positions which are not solved/in its right place + the index of those cubies
     *
     * @return ArrayList<String> - String : {"indexes : colors"}
     */
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

    /**
     * Returns a scramble of your desired length
     * Executes the scramble depending on the parameter
     *
     * @param n       number of moves
     * @param check   true, if moves to be executed, false if not
     * @return        String, containing the scramble
     */
    public String getScramble(int n, boolean check) {
        StringBuilder s = new StringBuilder(" ");
        for (int i = 0; i < n; i++) {
            int x = (int) (Math.random() * movesString.length);
            s.append(movesString[x]).append(" ");
        }
        if (check) {
            return stringAlg(s.toString());
        }
        else { return s.toString() ; }
    }

    /**
     * Executes the moves contained in the String input. <br>
     * String must have the move names, seperated by a space
     * <br>
     * Correct : "R U" ;
     * Incorrect : "RU"
     * <br>
     * In case spaces aren't given, both moves on either side will be ignored
     *
     * @param str    String containing moves to be carried out
     * @return       String containing the executed moves
     */
    public String stringAlg(String str) {
        String s = str.trim();
        while (str.contains(" ")) {
            choose(str.substring(0, str.indexOf(" ")));
            str = str.substring(str.indexOf(" ") +1 ) ;
        }
        choose(str);
        return s ;

    }

    /**
     * Reverses the moves contained in the String input. <br>
     * If String is "R U",
     * <br>
     * output will be "U' R'"
     * <br>
     * If check is true, then the output will be executed on the {@code Cube2}
     *
     * @param str    String containing moves to be carried out
     * @param check  true, if moves to be executed, false if not
     * @return       String containing the executed moves
     */
    public String reverseAlg(String str, boolean check) {
        String s = "" ;
        while (str.contains(" ")) {
            s = reversedo(str.substring(0, str.indexOf(" "))) + " " + s ;
            str = str.substring(str.indexOf(" ") +1 ) ;
        }
        s = reversedo(str) + " " + s ;
        if (check) {
            stringAlg(s);
        }
        return s;

    }

    /**
     * Helper method for {@link #stringAlg(String)}
     *
     * @param ch   Move to be executed
     */
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

    /**
     * Helper method for {@link #reverseAlg(String, boolean)}
     *
     * @param s  Move to be executed
     * @return   String, of move executed
     */
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
