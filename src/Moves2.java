/**
 * Moves2 class has-a Cube2 object, and
 * is responsible for all the moves made on it
 * with the help of Checker2 class
 *
 *
 * @author  Akshath Raghav
 * @version 2.0
 * @since   2021-05-20
 * @see Cube2
 * @see Checker2
 * @see <a href="https://github.com/AkshathRaghav/cubot.io">cubot.io</a>
 */
public class Moves2 {
    protected Cube2 cubie  ;
    protected String[][][][] cubearray   ;
    private  final int[] RLdashswaps = {0,0,1,0,1,0,1,1,1,1,0,1} ;
    private  final int[] RdashLswaps = {0,0,0,1,0,1,1,1,1,1,1,0} ;
    private  final int[] UDdashswaps = {0,0,1,0,1,0,1,1,1,1,0,1} ;
    private  final int[] UdashDswaps = {0,0,0,1,0,1,1,1,1,1,1,0} ;
    private  final int[] FBdashswaps = {0,1,0,0,0,0,1,0,1,0,1,1} ;
    private  final int[] FdashBswaps = {1,0,0,0,0,0,0,1,0,1,1,1} ;


    /**
     * Moves2 has-a Cube2
     *
     * @param temp  String[] input from user containing the colors on each side
     * @throws      IllegalArgumentException on input error
     * @see         IllegalArgumentException
     */
    public Moves2(String[] temp) throws IllegalArgumentException {
        cubie = new Cube2(temp);
        cubearray  = cubie.getCube();
    }

    /**
     * swaps the necessary cubies in the {@code Cube2} object "cubie"
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
     * swaps the necessary cubies in the {@code Cube2} object "cubie" <br>
     * Responsible for :
     *                 {@link #U()}, <br>
     *                 {@link #Udash()}, <br>
     *                 {@link #D()}, <br>
     *                 {@link #Ddash()}, <br>
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
     * swaps the necessary cubies in the {@code Cube2} object "cubie" <br>
     * Responsible for :
     *                 {@link #F()}, <br>
     *                 {@link #Fdash()}, <br>
     *                 {@link #B()}, <br>
     *                 {@link #Bdash()}
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
     * Executes R move on {@code Cube2}
     *
     * @return "R"
     */
    public String R() {
        colswapper(1, RLdashswaps);
        change(cubearray[0][1][1], "col") ;
        return "R" ;
    }

    /**
     * Executes R' move on {@code Cube2}
     *
     * @return "R'"
     */
    public String Rdash() {
        colswapper(1, RdashLswaps);
        change(cubearray[1][1][0], "col") ;
        return "R'" ;
    }

    /**
     * Executes L move on {@code Cube2}
     *
     * @return "L"
     */
    public String L() {
        colswapper(0, RdashLswaps);
        change(cubearray[1][0][0], "col") ;
        return "L" ;
    }

    /**
     * Executes L' move on {@code Cube2}
     *
     * @return "L'"
     */
    public String Ldash() {
        colswapper(0, RLdashswaps);
        change(cubearray[0][0][1], "col") ;
        return "L'" ;
    }

    /**
     * Executes U move on {@code Cube2}
     *
     * @return "U"
     */
    public String U() {
        rowswapper(0, UDdashswaps);
        change(cubearray[0][0][1], "row") ;
        return "U" ;
    }

    /**
     * Executes U' move on {@code Cube2}
     *
     * @return "U'"
     */
    public String Udash() {
        rowswapper(0, UdashDswaps);
        change(cubearray[0][1][0], "row") ;
        return "U'" ;
    }

    /**
     * Executes D move on {@code Cube2}
     *
     * @return "D"
     */
    public String D() {
        rowswapper(1, UdashDswaps);
        change(cubearray[1][1][0], "row") ;
        return "D" ;
    }

    /**
     * Executes D' move on {@code Cube2}
     *
     * @return "D'"
     */
    public String Ddash() {
        rowswapper(1, UDdashswaps);
        change(cubearray[1][0][1], "row") ;
        return "D'" ;
    }

    /**
     * Executes B move on {@code Cube2}
     *
     * @return "B"
     */
    public String B() {
        frontswapper(1, FdashBswaps);
        change(cubearray[1][1][1], "front") ;
        return "B" ;
    }

    /**
     * Executes B' move on {@code Cube2}
     *
     * @return "B'"
     */
    public String Bdash() {
        frontswapper(1, FBdashswaps);
        change(cubearray[1][1][1], "front") ;
        return "B'" ;
    }

    /**
     * Executes F move on {@code Cube2}
     *
     * @return "F"
     */
    public String F() {
        frontswapper(0, FBdashswaps);
        change(cubearray[1][1][0], "front") ;
        return "F" ;
    }

    /**
     * Executes F' move on {@code Cube2}
     *
     * @return "F'"
     */
    public String Fdash() {
        frontswapper(0, FdashBswaps);
        change(cubearray[1][1][0], "front") ;
        return "F'" ;
    }

    /**
     * Executes R2 move on {@code Cube2}
     *
     * @return "R2"
     */
    public String R2() {
        R() ; R() ;
        return "R2" ;
    }

    /**
     * Executes L2 move on {@code Cube2}
     *
     * @return "L2"
     */
    public String L2() {
        L() ;
        L() ;
        return "L2" ;
    }

    /**
     * Executes U2 move on {@code Cube2}
     *
     * @return "U2"
     */
    public String U2() {
        U() ; U() ;
        return "U2" ;
    }

    /**
     * Executes F2 move on {@code Cube2}
     *
     * @return "F2"
     */
    public String F2() {
        F();
        F();
        return "F2" ;
    }

    /**
     * Executes B2 move on {@code Cube2}
     *
     * @return "B2"
     */
    public String B2() {
        B() ; B() ;
        return "B2" ;
    }

    /**
     * Executes D2 move on {@code Cube2}
     *
     * @return "D2"
     */
    public String D2() {
        D() ;
        D() ;
        return "D2" ;
    }

    /**
     * Helper method for {@link #colswapper(int, int[])}, <br> {@link #rowswapper(int, int[])}, <br> {@link #frontswapper(int, int[])} to change the colors on the side
     *
     * @param piece  4th Dimension String[] from the cube[][][][] of {@code Cube2} it contains
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

