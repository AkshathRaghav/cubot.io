import java.util.ArrayList;

/**
 * An implementation of the <strong>Rubiks Cube</strong>, but virtually.
 * <br> Offers a number of methods to <strong> manipulate, visualize and solve</strong> the Cube
 * <br> Can hold 2x2 or 3x3 and provides <i>additional features</i> to utilize Cubot as a library
 * <br> Visit the <a href="https://github.com/AkshathRaghav/cubot.io/wiki">Docs</a> for a clearer understanding of the class and the methods it provides
 *
 * @author  Akshath Raghav
 * @version 2.0
 * @since   2021-05-20
 * @see Cubot2
 * @see Cubot3
 * @see <a href="https://github.com/AkshathRaghav/cubot.io">cubot.io</a>
 */
public class Cubot {
    private Cubot3 cube3;
    private Cubot2 cube2;
    private final String[] end3 = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"};
    private final String[] end2  = {"RRRR", "GGGG", "OOOO", "BBBB", "WWWW", "YYYY"};

    /**
     * Constructs the Cubot object, and makes the appropriate Cube depending on the input
     *
     * @param s    String[] input containing the colors of each face of the cube
     * @throws     IllegalArgumentException on input error
     */
    public Cubot(String[] s) throws IllegalArgumentException {
        boolean check= true ;
        for (String i : s) {
            if (!(i.length() == 9 || i.length() == 4)) {
                check = false;
                break;
            }
        }
        if (!check) { throw new IllegalArgumentException("Input Error") ; }
        if (s[0].length() == 9) { cube3 = new Cubot3(s) ; }
        else { cube2 = new Cubot2(s) ; }
    }

    /**
     * Overloaded constructor for initializing {@code Cubot} with solved cubes
     *
     * @param check  true for solved 3x3, false for solved 2x2
     */
    public Cubot(boolean check) {
        if (check) {
            cube3 = new Cubot3(end3);
        }
        else {
            cube2 = new Cubot2(end2);
        }
    }


    /**
     * Solves the cube held by the {@code Cubot} object
     *
     * @see Checker2
     * @see Checker3
     * @return  String containing the solution
     */
    public String solve() {
        if (cube2 == null && cube3 != null) {
            return cube3.solve();
        }
        return cube2.solve();
    }

    /**
     * Checks whether the cube is solved or not
     *
     * @see Checker2
     * @see Checker3
     * @return  boolean : true if solved, false otherwise
     */
    public boolean isSolved() {
        if ( cube3 != null) {
            return cube3.isSolved();
        }
        return cube2.isSolved();
    }

    /**
     * Prints the Cube2 as if all faces have been opened up while facing upwards, with Green face in the center
     *
     * @see    Cube2
     * @see    Cube3
     * @return String containing the same
     */
    public String toString() {
        if (cube2 == null && cube3 != null) {
            return cube3.toString();
        }
        return cube2.toString();
    }

    /**
     * Gives a String with the indexes as well as the colors on each side of each cube piece
     *
     * @see    Cube2
     * @see    Cube3
     * @return String containing the same
     */
    public String indexString() {
        if (cube3 != null) {
            return cube3.indexString();
        }
        return cube2.indexString();
    }

    /**
     * Returns the base form of the Cube object held by {@code Cubot}
     *
     * @see Cube2
     * @see Cube3
     * @return String[][][][] of the Cube object in base form
     */
    public String[][][][] getCubeArr() {
        if (cube3 != null) {
            return cube3.getCubeArr();
        }
        return cube2.getCubeArr();
    }

    /**
     * Returns the base form of the SOLVED Cube object held by {@code Cubot}
     *
     * @see Cube2
     * @see Cube3
     * @return String[][][][] of the SOLVED Cube object in base form
     */
    public String[][][][] getSolvedCube() {
        if (cube2 == null && cube3 != null) {
            return cube3.getSolvedCube();
        }
        return cube2.getSolvedCube();
    }

    /**
     * Returns the Cube object held by Cubot
     *
     * @see Cube2
     * @see Cube3
     * @return  {@code Cube2} or {@code Cube3}
     */
    public Object getCube() {
        if (cube3 != null) {
            return cube3.getCube();
        }
        return cube2.getCube();
    }

    /**
     * Compares the cube with a solved on and returns the pieces which are not in the solved position
     *
     * @return ArrayList<String> containing {" <index> : <colors< "}
     */
    public ArrayList<String> compareToSolved() {
        if (cube2 == null && cube3 != null) {
            return cube3.compareToSolved();
        }
        assert cube2 != null;
        return cube2.compareToSolved();
    }

    /**
     * Executes the moves given in the input on the Cubot
     *
     * @param s  String input containin the moves
     * @return   String containing moves exectued
     */
    public String stringalg(String s) {
        if (cube2 == null && cube3 != null) {
            return cube3.stringAlg(s);
        }
        assert cube2 != null;
        return cube2.stringAlg(s);
    }

    /**
     * Chooses random moves and returns scramble
     *
     * @param n       Number of moves
     * @param check   true if moves to be executed, false otherwise
     * @return        String containing the scramble
     */
    public String getScramble(int n, boolean check) {
        if (cube2 == null && cube3 != null) {
            return cube3.getScramble(n, check );

        }
        assert cube2 != null;
        return cube2.getScramble(n, check);
    }

    /**
     * Reverses the moves given as input and returns it
     *
     * @param s       String to be reverse
     * @param check   true if the reversed moves are to be executed, false otherwise
     * @return        String containing the reversed algorithm
     */
    public String reversealg(String s, boolean check) {
        if (cube3 != null) {
            return cube3.reverseAlg(s, check);
        }
        return cube2.reverseAlg(s, check);
    }



    /**
     * Converts the cube held by {@code Cubot} to solved state
     */
    public void makeSolved() {
        if ( cube3 != null) {
            cube3 = new Cubot3(end3) ;
        }
        cube2 = new Cubot2(end2) ;
    }

    /**
     * Gives you a String[] which can be given as input to other {@code Cubot} objects
     *
     * @return   String[] in the form of the input
     */
    public String[] cubeToArr() {
        if (cube3 != null) {
            return cube3.cubeToArr();
        }
        return cube2.cubeToArr();
    }

    /**
     * @return   String containing the type of Cube held by the object
     */
    public String cubeType() {
        if (cube3 != null) {
            return "3x3";
        }
        return "2x2";
    }


    /**
     * Compares two Cubots and tells you if they are solved with respect to each other
     *
     * @param other   {@code Cubot}
     * @throws        IllegalArgumentException on Unmatched CubeTypes
     * @return        boolean : true if equivalent, false otherwise
     */
    public boolean compareTo(Cubot other) throws IllegalArgumentException {
        if (other == null) {
            return false;
        }
        try {
            if (other.getCube() instanceof Cube3 && this.getCube() instanceof Cube3)
                return ((Cube3) this.getCube()).solved((Cube3) other.getCube());
            else
                return ((Cube2) this.getCube()).solved((Cube2) other.getCube());

        } catch (ClassCastException x) {
            throw new IllegalArgumentException("Error: Unmatched cubeTypes");
        }
    }
}
