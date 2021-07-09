import java.util.ArrayList ;

/**
 * Cubot3 extends Checker3 class
 *
 * @author  Akshath Raghav
 * @version 2.0
 * @since   2021-05-20
 * @see Cube3
 * @see Moves3
 * @see Checker3
 * @see <a href="https://github.com/AkshathRaghav/cubot.io">cubot.io</a>
 */
public class Cubot3 extends Checker3 {

    /**
     * Creates a {@code Cubot3} object
     *
     * @param temp   String[] input containing side colors
     * @throws       IllegalArgumentException
     */
    public Cubot3(String[] temp) throws IllegalArgumentException { super(temp) ;}

    /**
     * Solves the {@code Cube3} and returns the solution
     * <br> Common reasons for CubeError :
     *                <br> - Flipped Piece
     *                <br> - Input Error
     *
     * @return    String containing the solution
     * @throws    Error if cube is not able to solve
     */
    public String solve() throws Error {
        return super.solve() ;
    }

    /**
     * Checks if cube is in solved state
     * @return  boolean : true if solved, false otherwise
     */
    public boolean isSolved() { return super.isSolved() ;}

    /**
     * Returns visual representation of the cube
     *
     * @return  String containing the same
     */
    public String toString() {
        return cubie.toString() ;
    }

    /**
     * Returns a cube with the indexes and the colors on each piece
     *
     * @return   String containing the same
     */
    public String indexString() { return cubie.indexedString();}

    /**
     * Gives the String[][][][] in the base form of the {@code Cube3} object
     *
     * @return  String[][][][] as defined above
     */
    public String[][][][] getCubeArr() {
        return cubie.getCube();
    }

    /**
     * Gives the String[][][][] in the solved base form of the {@code Cube3} object
     *
     * @return  String[][][][] as defined above
     */
    public String[][][][] getSolvedCube() { return super.getSolvedCube() ; }

    /**
     * Gives {@code ArrayList} containing " <index> : <colors> "
     *
     * @return   ArrayList<String> as defined above
     */
    public ArrayList<String> compareToSolved()  { return super.compareToSolved() ; }

    /**
     * Executes moves onto the cube
     *
     * @param s    String containing moves to be executed
     * @return     String containing moves exectued
     */
    public String stringAlg(String s) { return super.stringalg(s) ; }

    /**
     * Returns a scramble of desired length <br> Scramble can be exectued
     *
     * @param n       Number of moves
     * @param check   boolean : true if moves to be executed, false otherwise
     * @return
     */
    public String getScramble(int n, boolean check) { return super.getScramble(n, check) ; }

    /**
     * Reverses and executes moves onto the cube
     *
     * @param s       String containing moves to be executed
     * @param check   boolean : true if moves to be executed, false otherwise
     * @return        String containing the reversed moves
     */
    public String reverseAlg(String s, boolean check ) { return  super.reversealg(s, check ) ; }

    /**
     * @return   {@code Cube3} object held by {@code Cubot3}
     */
    public Cube3 getCube() { return cubie ; }

    /**
     * @return    String[] in the form of input
     */
    public String[] cubeToArr() { return cubie.cubeToArr() ; }

}
