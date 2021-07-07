/**
 * Moves3 class has-a Cube3 object, and
 * is responsible for all the moves made on it
 * with the help of Checker3 class
 *
 *
 * @author  Akshath Raghav
 * @version 2.0
 * @since   2021-05-20
 * @see Cube3
 * @see Checker3
 * @see <a href="https://github.com/AkshathRaghav/cubot.io">cubot.io</a>
 */
public class Moves3 {
    protected Cube3 cubie  ;
    protected String[][][][] cubearray   ;
    private  final int[] RLdashswaps = {0,0,2,0,2,0,2,2,2,2,0,2,1,0,2,1,2,1,1,2,1,2,0,1} ;
    private  final int[] RdashLswaps = {0,0,0,2,0,2,2,2,2,2,2,0,1,0,0,1,0,1,1,2,1,2,2,1} ;
    private  final int[] UDdashswaps = {0,0,2,0,2,0,2,2,2,2,0,2,0,1,1,0,1,0,2,1,2,1,1,2} ;
    private  final int[] UdashDswaps = {0,0,0,2,0,2,2,2,2,2,2,0,1,0,0,1,0,1,1,2,1,2,2,1} ;
    private  final int[] FBdashswaps = {0,2,0,0,0,0,2,0,2,0,2,2,0,1,1,0,1,0,2,1,2,1,1,2} ;
    private  final int[] FdashBswaps = {2,0,0,0,0,0,0,2,0,2,2,2,1,0,0,1,0,1,1,2,1,2,2,1} ;

    /**
     * Moves3 has-a Cube3
     *
     * @param temp  String[] input from user containing the colors on each side
     * @throws      IllegalArgumentException on input error
     * @see         IllegalArgumentException
     */
    public Moves3(String[] temp) throws IllegalArgumentException {
        cubie = new Cube3(temp) ;
        cubearray  = cubie.getCube();
    }


    /**
     * swaps the necessary cubies in the {@code Cube3} object "cubie"
     * <br>
     * Responsible for :
     *                 {@link #R()}, <br>
     *                 {@link #Rdash()}, <br>
     *                 {@link #L()}, <br>
     *                 {@link #Ldash()}
     *
     * @param colindex  index of the 2nd dimension in the 4d Cubearray {@see Cube2}
     * @param swaps     contains the swap indexes
     * @see Cube2
     * @see <a href="https://eli.thegreenplace.net/2015/memory-layout-of-multi-dimensional-arrays">Dimensional Indexes</a>
     */
    private void colswapper(int colindex, int[] swaps) {
        for (int i = 0 ; i  < swaps.length-2 ; i+=4) {
            String[] temp = cubearray[swaps[i]][colindex][swaps[i+1]], temp2 = cubearray[swaps[i+2]][colindex][swaps[i+3]];
            change(temp2, "col") ;
            cubearray[swaps[i]][colindex][swaps[i+1]] = temp2 ;
            cubearray[swaps[i+2]][colindex][swaps[i+3]] = temp;
        }
    }

    /**
     * swaps the necessary cubies in the {@code Cube3} object "cubie" <br>
     * Responsible for :
     *                 {@link #U()}, <br>
     *                 {@link #Udash()}, <br>
     *                 {@link #D()}, <br>
     *                 {@link #Ddash()}, <br>
     *                 {@link #E()}, <br>
     *                 {@link #Edash()}
     *
     * @param rowindex   index of the 1st dimension in the 4d Cubearray {@see Cube2}
     * @param swaps      contains the swap indexes
     * @see Cube2
     * @see <a href="https://eli.thegreenplace.net/2015/memory-layout-of-multi-dimensional-arrays">Dimensional Indexes</a>
     */
    private void rowswapper(int rowindex, int[] swaps) {
        for (int i = 0 ; i  < swaps.length-2 ; i+=4) {
            String[] temp = cubearray[rowindex][swaps[i]][swaps[i+1]], temp2 = cubearray[rowindex][swaps[i+2]][swaps[i+3]];
            change(temp2, "row") ;
            cubearray[rowindex][swaps[i]][swaps[i+1]] = temp2 ;
            cubearray[rowindex][swaps[i+2]][swaps[i+3]] = temp;
        }
    }

    /**
     * swaps the necessary cubies in the {@code Cube3} object "cubie" <br>
     * Responsible for :
     *                 {@link #F()}, <br>
     *                 {@link #Fdash()}, <br>
     *                 {@link #B()}, <br>
     *                 {@link #Bdash()}, <br>
     *                 {@link #S()}, <br>
     *                 {@link #Sdash()}
     * @param frontindex  index of the 3rd dimension in the 4d Cubearray {@see Cube2}
     * @param swaps       contains the swap indexes
     * @see Cube2
     * @see <a href="https://eli.thegreenplace.net/2015/memory-layout-of-multi-dimensional-arrays">Dimensional Indexes</a>
     */
    private void frontswapper(int frontindex, int[] swaps) {
        for (int i = 0 ; i  < swaps.length-2 ; i+=4) {
            String[] temp = cubearray[swaps[i]][swaps[i+1]][frontindex], temp2 = cubearray[swaps[i+2]][swaps[i+3]][frontindex];
            change(temp2, "front") ;
            cubearray[swaps[i]][swaps[i+1]][frontindex] = temp2 ;
            cubearray[swaps[i+2]][swaps[i+3]][frontindex] = temp;
        }
    }

    /**
     * Executes R move on {@code Cube3}
     *
     * @return "R"
     */
    public String R() {
        colswapper(2, RLdashswaps);
        change(cubearray[0][2][2], "col") ;
        change(cubearray[0][2][1], "col") ;

        return "R" ;
    }

    /**
     * Executes R' move on {@code Cube3}
     *
     * @return "R'"
     */
    public String Rdash() {
        colswapper(2, RdashLswaps);
        change(cubearray[2][2][0], "col") ;
        change(cubearray[2][2][1], "col") ;
        return "R'" ;
    }

    /**
     * Executes L move on {@code Cube3}
     *
     * @return "L"
     */
    public String L() {
        colswapper(0, RdashLswaps);
        change(cubearray[2][0][0], "col") ;
        change(cubearray[2][0][1], "col") ;
        return "L" ;
    }

    /**
     * Executes L' move on {@code Cube3}
     *
     * @return "L'"
     */
    public String Ldash() {
        colswapper(0, RLdashswaps);
        change(cubearray[0][0][2], "col") ;
        change(cubearray[0][0][1], "col") ;
        return "L'" ;
    }

    /**
     * Executes U move on {@code Cube3}
     *
     * @return "U"
     */
    public String U() {
        rowswapper(0, UDdashswaps);
        change(cubearray[0][1][2], "row") ;
        change(cubearray[0][0][2], "row") ;
        return "U" ;
    }

    /**
     * Executes U' move on {@code Cube3}
     *
     * @return "U'"
     */
    public String Udash() {
        rowswapper(0, UdashDswaps);
        change(cubearray[0][2][0], "row") ;
        change(cubearray[0][2][1], "row") ;
        return "U'" ;
    }

    /**
     * Executes D move on {@code Cube3}
     *
     * @return "D"
     */
    public String D() {
        rowswapper(2, UdashDswaps);
        change(cubearray[2][2][0], "row") ;
        change(cubearray[2][2][1], "row") ;
        return "D" ;
    }

    /**
     * Executes D' move on {@code Cube3}
     *
     * @return "D'"
     */
    public String Ddash() {
        rowswapper(2, UDdashswaps);
        change(cubearray[2][1][2], "row") ;
        change(cubearray[2][0][2], "row") ;
        return "D'" ;
    }

    /**
     * Executes B move on {@code Cube3}
     *
     * @return "B"
     */
    public String B() {
        frontswapper(2, FdashBswaps);
        change(cubearray[2][1][2], "front") ;
        change(cubearray[2][2][2], "front") ;
        return "B" ;
    }

    /**
     * Executes B' move on {@code Cube3}
     *
     * @return "B'"
     */
    public String Bdash() {
        frontswapper(2, FBdashswaps);
        change(cubearray[1][2][2], "front") ;
        change(cubearray[2][2][2], "front") ;
        return "B'" ;
    }

    /**
     * Executes F move on {@code Cube3}
     *
     * @return "F"
     */
    public String F() {
        frontswapper(0, FBdashswaps);
        change(cubearray[1][2][0], "front") ;
        change(cubearray[2][2][0], "front") ;
        return "F" ;
    }

    /**
     * Executes F' move on {@code Cube3}
     *
     * @return "F'"
     */
    public String Fdash() {
        frontswapper(0, FdashBswaps);
        change(cubearray[2][1][0], "front") ;
        change(cubearray[2][2][0], "front") ;
        return "F'" ;
    }

    /**
     * Executes S move on {@code Cube3}
     *
     * @return "S"
     */
    public String S() {
        frontswapper(1, FBdashswaps);
        change(cubearray[2][2][1], "front") ;
        change(cubearray[1][0][1], "front");
        change(cubearray[0][1][1], "front");
        change(cubearray[2][1][1], "front");
        return "S" ;
    }

    /**
     * Executes S' move on {@code Cube3}
     *
     * @return "S'"
     */
    public String Sdash() {
        frontswapper(1, FdashBswaps);
        change(cubearray[2][2][1], "front") ;
        change(cubearray[1][2][1], "front");
        change(cubearray[0][1][1], "front");
        change(cubearray[1][0][1], "front");
        return "S'" ;
    }

    /**
     * Executes M move on {@code Cube3}
     *
     * @return "M"
     */
    public String M() {
        colswapper(1, RdashLswaps);
        change(cubearray[2][1][0], "col") ;
        return "M" ;
    }

    /**
     * Executes M' move on {@code Cube3}
     *
     * @return "M'"
     */
    public String Mdash() {
        colswapper(1, RLdashswaps);
        change(cubearray[0][1][2], "col") ;
        return "M'" ;
    }

    /**
     * Executes E move on {@code Cube3}
     *
     * @return "E"
     */
    public String E()  {
        rowswapper(1, UdashDswaps);
        change(cubearray[1][2][0], "row") ;
        change(cubearray[1][1][0], "row") ;
        change(cubearray[1][1][2], "row") ;
        change(cubearray[1][0][1], "row") ;
        return "E" ;
    }

    /**
     * Executes E' move on {@code Cube3}
     *
     * @return "E'"
     */
    public String Edash() {
        rowswapper(1, UDdashswaps);
        change(cubearray[1][1][0], "row") ;
        change(cubearray[1][0][2], "row") ;
        change(cubearray[1][0][1], "row") ;
        change(cubearray[1][2][1], "row") ;
        return "E'" ;
    }

    /**
     * Executes r move on {@code Cube3}
     *
     * @return "r"
     */
    public String r() {
        R() ;
        Mdash() ;
        return "r" ;
    }

    /**
     * Executes r' move on {@code Cube3}
     *
     * @return "r'"
     */
    public String rdash() {
        Rdash() ;
        M() ;
        return "r'" ;
    }

    /**
     * Executes R2 move on {@code Cube3}
     *
     * @return "R2"
     */
    public String R2() {
        R() ; R() ;
        return "R2" ;
    }

    /**
     * Executes L2 move on {@code Cube3}
     *
     * @return "L2"
     */
    public String L2() {
        L() ;
        L() ;
        return "L2" ;
    }

    /**
     * Executes U2 move on {@code Cube3}
     *
     * @return "U2"
     */
    public String U2() {
        U() ; U() ;
        return "U2" ;
    }

    /**
     * Executes F2 move on {@code Cube3}
     *
     * @return "F2"
     */
    public String F2() {
        F();
        F();
        return "F2" ;
    }

    /**
     * Executes B2 move on {@code Cube3}
     *
     * @return "B2"
     */
    public String B2() {
        B() ; B() ;
        return "B2" ;
    }

    /**
     * Executes M2 move on {@code Cube3}
     *
     * @return "M2"
     */
    public String M2() {
        M() ;
        M() ;
        return "M2" ;
    }

    /**
     * Executes D2 move on {@code Cube3}
     *
     * @return "D2"
     */
    public String D2() {
        D() ;
        D() ;
        return "D2" ;
    }

    /**
     * Executes y move on {@code Cube3}
     *
     * @return "y"
     */
    public String y() {
        U();
        Edash() ;
        Ddash();
        return "y" ;
    }

    /**
     * Executes y' move on {@code Cube3}
     *
     * @return "y'"
     */
    public String ydash() {
        Udash();
        E() ;
        D();
        return "y'" ;
    }

    /**
     * Executes y move on {@code Cube3}
     *
     * @return "y"
     */
    public String z() {
        F() ;
        S() ;
        Bdash() ;
        return "z" ;
    }

    /**
     * Executes y move on {@code Cube3}
     *
     * @return "y"
     */
    public String x() {
        R() ;
        Ldash()  ;
        Mdash() ;
        return "x" ;
    }

    /**
     * Rotates only the lower slice on {@code Cube3}
     *
     * @return "RotateRightLower"
     */
    public String Rotaterightlower() {
        Edash() ;
        Ddash();
        return "RotateRightLower" ;
    }

    /**
     * Helper method for {@link #colswapper(int, int[])}, <br> {@link #rowswapper(int, int[])}, <br> {@link #frontswapper(int, int[])} to change the colors on the side
     *
     * @param piece  4th Dimension String[] from the cube[][][][] of {@code Cube3} it contains
     * @param check  Changes the colors depending on input given
     */
    private static void change(String[] piece, String check) {
        if (check.equals("col")) {
            String temp = piece[0] ;
            piece[0] = piece[2] ;
            piece[2] = temp ;
        }
        else if (check.equals("row")) {
            String temp = piece[1] ;
            piece[1] = piece[2] ;
            piece[2] = temp ;
        }
        else if ( check.equals("front")){
            String temp = piece[0] ;
            piece[0] = piece[1] ;
            piece[1] = temp ;
        }
    }


}
