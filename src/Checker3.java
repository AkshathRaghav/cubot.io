import java.util.* ;
/**
 * Checker3 extends Moves3 class
 * <br>
 * It is also responsible for additional changes made to the
 * {@code Cube3} object in Moves3 class
 *
 * @author  Akshath Raghav
 * @version 2.0
 * @since   2021-06-15
 * @see Cube3
 * @see Checker3
 * @see Moves3
 * @see <a href="https://github.com/AkshathRaghav/cubot.io">cubot.io</a>
 */
public class Checker3 extends Moves3 {
    private final String[] temp = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"};
    private final Cube3 end = new Cube3(temp) ;
    private final String[] movesString = {"R", "R'", "L", "L'", "U", "U'", "D", "D'", "F", "F'", "B" , "B'", "U2", "F2", "R2", "L2",  "M2"} ;
    private final int[][] edges = {{2, 0, 1, 2, 1, 0, 2, 2, 1, 2, 1, 2}, {1, 0, 0, 1, 0, 2, 1, 2, 0, 1, 2, 2}, {0, 0, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2}};
    private final int[][] corners = {{2, 0, 0, 2, 0, 2, 2, 2, 0, 2, 2, 2}, {0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 2, 2}};

    /**
     * Moves3 has-a Cube3
     *
     * @param temp  String[] input from user containing the colors on each side
     * @throws      IllegalArgumentException on input error
     * @see         IllegalArgumentException
     * @see         Moves2
     */
    public Checker3(String[] temp) throws IllegalArgumentException {
        super(temp) ;
    }

    /**
     * Checks if the {@code Cube3} object in {@link Moves3} is solved
     *
     * @return boolean : true if solved, false otherwise
     */
    public boolean isSolved() {
        String[][][][] endArr = end.getCube() ;
        int count  =0 ;
        while (!endArr[1][0][0][2].equals(cubearray[1][0][0][2])) { count++;  y(); }
        boolean check = cubie.solved(end) ;
        for (int i  =0 ; i < count ; i++ ) { ydash() ; }
        return check ;
    }

    /**
     * @return String[][][][] - {@code Cube3} in base form
     */
    public String[][][][] getSolvedCube() { return end.getCube() ; }

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
                    String a, x, c;
                    if (cubearray[i][j][k][0] != null || cubearray[i][j][k][2] != null) {
                        if (cubearray[i][j][k][0] == null) {
                            if ( !( cubearray[i][j][k][1].equals(endarray[i][j][k][1]) && cubearray[i][j][k][2].equals(endarray[i][j][k][2]) )) { change.add("( " +i + " " + j + " " + k + " : Side - " + endarray[i][j][k][1] + " , F/B - " + endarray[i][j][k][2] + " ) "  ) ; }
                        } else if (cubearray[i][j][k][1] == null) {
                            if ( !( cubearray[i][j][k][0].equals(endarray[i][j][k][0]) && cubearray[i][j][k][2].equals(endarray[i][j][k][2]) )) { change.add("( " +i + " " + j + " " + k + " : T/b - " + endarray[i][j][k][0] + " , F/B - " + endarray[i][j][k][2] + " ) " ) ; }
                        } else if (cubearray[i][j][k][2] == null) {
                            if ( !( cubearray[i][j][k][1].equals(endarray[i][j][k][1]) && cubearray[i][j][k][0].equals(endarray[i][j][k][0]) )) { change.add("( " + i + " " + j + " " + k + " : T/b - " + endarray[i][j][k][0] + " , Side - " + endarray[i][j][k][1] + " ) " )  ; }
                        } else {
                            if ( !( cubearray[i][j][k][1].equals(endarray[i][j][k][1]) && cubearray[i][j][k][2].equals(endarray[i][j][k][2]) || cubearray[i][j][k][0].equals(endarray[i][j][k][0]) )) { change.add("( " +i + " " + j + " " + k + " : T/b - " + endarray[i][j][k][0] + " . Side - " + endarray[i][j][k][1]  + " . F/B - " + endarray[i][j][k][2] + " ) " ) ; }
                        }
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
            return stringalg(s.toString());
        }
        else { return s.toString() ; }
    }

    /**
     * Executes the moves contained in the String input. <br>
     * String must have the move names, separated by a space
     * <br>
     * Correct : "R U" ;
     * Incorrect : "RU"
     * <br>
     * In case spaces aren't given, both moves on either side will be ignored
     *
     * @param str    String containing moves to be carried out
     * @return       String containing the executed moves
     */
    public String stringalg(String str) {
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
     * If check is true, then the output will be executed on the {@code Cube3}
     *
     * @param str    String containing moves to be carried out
     * @param check  true, if moves to be executed, false if not
     * @return       String containing the executed moves
     */
    public String reversealg(String str, boolean check) {
        String s = "" ;
        str =str.replaceAll("\n" , " ");
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


    /**
     * Helper method for {@link #centers()}
     *
     * @param color       4th Dimensional Index of White color
     * @param colorside   4th Dimensional Index of the other color
     * @return
     */
    private String throwcoloredgers(String color, String colorside ) {
        String s = "" ;
        int i = 5 , j = 5 , k = 5 ;
        for (int count = 0 ; count < 10 ; count += 3 ) {
            if ( (cubearray[1][edges[1][count+1]][edges[1][count+2]][1].equals(color) && cubearray[1][edges[1][count+1]][edges[1][count+2]][2].equals(colorside)) || (cubearray[1][edges[1][count+1]][edges[1][count+2]][2].equals(color) && cubearray[1][edges[1][count+1]][edges[1][count+2]][1].equals(colorside)) )   {
                i = 1 ;
                j = edges[1][count+1] ;
                k = edges[1][count+2] ;
            }
            else if (cubearray[0][edges[2][count+1]][edges[2][count+2]][1] == null ) {
                if ((cubearray[0][edges[2][count+1]][edges[2][count+2]][0].equals(color) && cubearray[0][edges[2][count+1]][edges[2][count+2]][2].equals(colorside))  || (cubearray[0][edges[2][count+1]][edges[2][count+2]][2].equals(color) && cubearray[0][edges[2][count+1]][edges[2][count+2]][0].equals(colorside)) ) {
                    i = 0;
                    j = edges[0][count + 1];
                    k = edges[0][count + 2];
                }
            }
            else if (cubearray[0][edges[2][count+1]][edges[2][count+2]][2] == null ) {
                if ((cubearray[0][edges[2][count+1]][edges[2][count+2]][0].equals(color) && cubearray[0][edges[2][count+1]][edges[2][count+2]][1].equals(colorside))  || (cubearray[0][edges[2][count+1]][edges[2][count+2]][1].equals(color) && cubearray[0][edges[2][count+1]][edges[2][count+2]][0].equals(colorside)) ) {
                    i = 0;
                    j = edges[0][count + 1];
                    k = edges[0][count + 2];
                }
            }
        }
        if ( i == 1   ) {
            if (j == 0) {
                if (k == 0) {
                    s += " " + Ldash() ;
                    s += " " +Udash() ;
                    s += " " +L() ;
                } else {
                    s += " " + L() ;
                    s += " " +Udash() ;
                    s += " " +Ldash() ;
                }
                s += " " +U() ;
                return cubearray[0][0][1][0] + s  ;
            }
            else {
                if (k == 0) {
                    s += " " +R() ;
                    s += " " +Udash() ;
                    s += " " +Rdash() ;
                    s += " " +U() ;
                    s += " " +U() ;
                } else {
                    s += " " +Rdash() ;
                    s += " " +U() ;
                    s += " " +R() ;
                }
                return cubearray[0][1][0][0] + s;
            }
        }
        String checknotfive = "";
        try  {
            return cubearray[i][j][k][0] + s;
        }
        catch (ArrayIndexOutOfBoundsException we) {
            throw new Error("CubeError : Unable to finish solve");
        }
    }


    /**
     * Helper method for {@link #centers()}
     *
     * @param i      1st Dimensional Index
     * @param j      2nd Dimensional Index
     * @param k      3rd Dimensional Index
     * @param index  4th Dimensional Index of White color
     * @param color  4th Dimensional Index of the other color
     * @return
     */
    private String centerslotter(int i, int j, int k, int index, int color) {
        StringBuilder s = new StringBuilder();
        if (i == 1) {
            if ( color == 3 ) {
                if (j == 0) {
                    if (k == 0) {
                        if ( index == 1) { s.append(L()+ " "); }
                        else {
                            s.append(Fdash()); }
                    } else {
                        if ( index == 1 ) { s.append(Ldash() + " " );}
                        else { s.append(B() + " ");}
                    }
                } else {
                    if (k == 0) {
                        if ( index == 1 ) { s.append(Rdash()+ " "); }
                        else {  s.append(F()+ " ");}
                    } else {
                        if ( index == 1 ) { s.append(R()+ " "); }
                        else {  s.append(Bdash()+ " ");}
                    }
                }
                return s.toString();
            }
            int count = 0 ;
            if (color == 1) {
                // index = 0
                while ((cubearray[index][0][1][0].equals("W") || cubearray[index][0][1][1].equals("W")) && count < 4 ) {
                    s.append(U()); count++ ;
                }
                if (k == 0) {
                    if (j == 0) {
                        s.append(stringalg("F U' F' ")) ;

                    } else {
                        s.append(stringalg("F' U' F ")) ;

                    }
                } else {
                    if (j == 0) {
                        s.append(stringalg("B' U B ")) ;

                    } else {
                        s.append(stringalg("B U B' ")) ;

                    }
                }
            } else {
                while ((cubearray[index][1][0][0].equals("W") || (cubearray[index][1][0][2].equals("W")) && count< 4)) {
                    s.append(U()); count++ ;
                }
                if (k == 0) {
                    if (j == 0) {
                        s.append(stringalg("L' U L ")) ;
                    } else {
                        s.append(stringalg("R U' R' ")) ;
                    }
                } else {
                    if (j == 0) {
                        s.append(stringalg("L U L' ")) ;
                    } else {
                        s.append(stringalg("R' U' R ") );
                    }
                }

            }
        }
        else {
            int  count = 0 ;
            while ((cubearray[index][j][k][0].equals("W") || ( (cubearray[index][j][k][2] != null && cubearray[index][j][k][2].equals("W"))) || (cubearray[index][j][k][1] != null && cubearray[index][j][k][1].equals("W")))  && count < 4) {
                s.append(Udash()); count++;
            }
            if (j == 1) {
                if (k == 0) {
                    s.append(stringalg("F F ")) ;
                } else {
                    s.append(stringalg("B B ")) ;
                }
            } else if (j == 0) {
                s.append(stringalg("L L ")) ;
            } else {
                s.append(stringalg("R R ")) ;
            }
        }
        return s.toString();
    }


    /**
     * Orients all the white center pieces to form the star, on the bottom layer
     *
     * @return  String containing solution for this phase of {@link #solve()}
     */
    private String centers() {
        int total = 0 ;
        StringBuilder s = new StringBuilder("\n");
        int[] layer = {1, 0, 0, 1, 0, 2, 1, 2, 2, 1, 2, 0};
        String[] colors = {"G", "R", "B", "R" , "B", "O", "G" , "O"} ;
        for (int checker = 3 ; checker > 0 ; checker-- ) {
            int count =0 ;
            for (int i = 0; i < 10; i += 3) {
                if (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][1].equals("W") && cubearray[layer[i]][layer[i + 1]][layer[i + 2]][2].equals(colors[count])) {
                    s.append(" ").append(centerslotter(layer[i], layer[i + 1], layer[i + 2], 2, 3)).append("  ");
                    total++;
                }
                else if (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][2].equals("W") && (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][1].equals(colors[count+ 1]))) {
                    s.append(" ").append(centerslotter(layer[i], layer[i + 1], layer[i + 2], 1, 3)).append("  ");
                    total++;
                }
                count+=2;
            }
        }
        layer = edges[2] ;
        for (int i = 0; i < 10; i += 3) {

            if (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][0].equals("W")) {
                if ( ( layer[i+1] == 1 && cubearray[1][layer[i + 1]][layer[i + 2]][1].substring(0, 1).equals(cubearray[layer[i]][layer[i + 1]][layer[i + 2]][2])) || ( layer[i+1] != 1 && cubearray[1][layer[i + 1]][layer[i + 2]][1].substring(0, 1).equals(cubearray[layer[i]][layer[i + 1]][layer[i + 2]][1])) )
                {
                    s.append(" ").append(centerslotter(layer[i], layer[i + 1], layer[i + 2], 0, 0)).append("  ");
                    total++;
                }
            }
        }
        layer = edges[0] ;
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 10; i += 3) {

                if (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][0].equals("W") || (layer[i + 1] == 1 && cubearray[layer[i]][layer[i + 1]][layer[i + 2]][2].equals("W")) || (layer[i + 1] != 1 && cubearray[layer[i]][layer[i + 1]][layer[i + 2]][1].equals("W"))) {
                    if ((layer[i + 1] == 1 && !cubearray[layer[i]][layer[i + 1]][layer[i + 2]][2].equals(cubearray[1][layer[i + 1]][layer[i + 2]][1].substring(0, 1))) || (layer[i + 1] != 1 && !cubearray[layer[i]][layer[i + 1]][layer[i + 2]][1].equals(cubearray[1][layer[i + 1]][layer[i + 2]][1].substring(0, 1)))) {
                        s.append(" ").append(centerslotter(layer[i], layer[i + 1], layer[i + 2], 0, 0)).append("  ");

                    }

                }
            }
        }
        s.append("\n");

        layer = edges[1];
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 10; i += 3) {
                if (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][1].equals("W")) {
                    s.append(" ").append(centerslotter(layer[i], layer[i + 1], layer[i + 2], 0, 1)).append("  ");
                    total++;


                } else if (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][2].equals("W")) {
                    s.append(" ").append(centerslotter(layer[i], layer[i + 1], layer[i + 2], 0, 2)).append("  ");
                    total++;


                }
            }
        }
        s.append("\n");
        int count = 0 ;
        for (int k = 0; k < 4; k++) {
            if ( !cubearray[2][1][0][0].equals("W")) {
                while (!((cubearray[0][1][0][0].equals("W") && cubearray[0][1][0][2].equals(cubearray[1][1][0][1].substring(0, 1))) || (cubearray[0][1][0][2].equals("W") && cubearray[0][1][0][0].equals(cubearray[1][1][0][1].substring(0, 1))) ) && count < 4 ) {
                    s.append(" ").append(Udash()); count++ ;

                }
                count =0 ;
                if (cubearray[0][1][0][2].equals("W") && cubearray[0][1][0][0].equals(cubearray[1][1][0][1].substring(0, 1))) {
                    s.append(" ").append(U());
                    s.append(" ").append(r());
                    s.append(" ").append(Udash());
                    s.append(" ").append(rdash()).append(" ");

                } else  {

                    while (!(cubearray[0][1][0][2].equals(cubearray[1][1][0][1].substring(0, 1))) && count < 4) {
                        s.append(" ").append(Udash()); count++ ;
                    }
                    s.append(" ").append(F());
                    s.append(" ").append(F()).append(" ");

                }
                total--;
            }
            s.append(y()).append("\n");

        }
        return s.toString();
    }


    /**
     * Assists {@link #f2l()} to slot the corners into place
     *
     * @param i      1st Dimensional Index
     * @param j      2nd Dimensional Index
     * @param k      3rd Dimensional Index
     * @param temp1  4th Dimensional Color Index
     * @param temp2  4th Dimensional Color Index
     * @return
     */
    private String cornerslotter(int i , int j , int k ,String temp1 ,String temp2) {
        String colorinfront,  coloronside, colorontop;
        StringBuilder s = new StringBuilder();
        if ( i == 2 ) {
            if (j == 0) {
                if (k == 0) {
                    s.append(" ").append(stringalg("L' U' L"));
                    colorontop = cubearray[0][2][0][0] ;
                    coloronside = cubearray[0][2][0][1] ;
                    colorinfront = cubearray[0][2][0][2] ;

                } else {
                    s.append(" ").append(stringalg("L U' L'"));
                    colorontop = cubearray[0][0][2][0] ;
                    coloronside = cubearray[0][0][2][1] ;
                    colorinfront = cubearray[0][0][2][2] ;
                }
            } else {
                if (k == 0) {
                    s.append(" ").append(stringalg("R U R'"));
                    colorontop = cubearray[0][0][0][0] ;
                    coloronside = cubearray[0][0][0][1] ;
                    colorinfront = cubearray[0][0][0][2] ;
                } else {
                    s.append(" ").append(stringalg("R' U R"));
                    colorontop = cubearray[0][2][2][0] ;
                    coloronside = cubearray[0][2][2][1] ;
                    colorinfront = cubearray[0][2][2][2] ;
                }
            }
        }
        else {
            colorontop = cubearray[i][j][k][0] ;
            coloronside = cubearray[i][j][k][1] ;
            colorinfront = cubearray[i][j][k][2] ;
        }
        int count =0 ;
        while ( !( ( cubearray[0][2][0][0].equals(colorontop) ) && ((cubearray[0][2][0][1].equals(coloronside) && cubearray[0][2][0][2].equals(colorinfront) ) || ( cubearray[0][2][0][1].equals(colorinfront) && cubearray[0][2][0][2].equals(coloronside)  ))  ) && count < 4){ s.append(" ").append(U()); count++ ; }
        count = 0;

        String topcolor = throwcoloredgers(temp1, temp2);
        s.append(topcolor.substring(1));
        topcolor = topcolor.substring(0,1) ;
        if ( cubearray[0][2][0][0].equals("W")) {
            s.append(" ").append(R());
            s.append(" ").append(Udash());
            if (!(cubearray[0][1][0][0].equals(topcolor) && ( cubearray[0][1][0][2].equals(temp1) || cubearray[0][1][0][2].equals(temp2)) )) {
                s.append(" ").append(Udash());
                s.append(" ").append(Rdash());
            }
            else {
                s.append(" ").append(Rdash());
                s.append(" ").append(Udash());
            }
            s.append(" ").append(Udash());

        }
        if ( cubearray[0][2][0][1].equals("W") ) {
            if (cubearray[0][1][0][0].equals(cubearray[0][2][0][0]) &&  cubearray[0][1][0][2].equals(cubearray[0][2][0][2])) {
                s.append(" ").append(stringalg("F R' F' R"));
            } else if (cubearray[0][2][0][0].equals(cubearray[0][2][1][1]) && cubearray[0][2][0][2].equals(cubearray[0][2][1][0])) {
                s.append(" ").append(stringalg("R U' R' U R U U R' U R' F R F'"));
            }else if (cubearray[0][2][0][0].equals(cubearray[0][2][1][0]) && cubearray[0][2][0][2].equals(cubearray[0][2][1][1])) {
                s.append(" ").append(stringalg("R U' R' U U F' U' F"));
            } else {
                s.append(" ").append(stringalg("U F'"));
                if ( cubearray[2][0][0][1].equals(topcolor)) {
                    while ( !( cubearray[0][0][1][0].equals(topcolor) && cubearray[0][0][1][1].equals(cubearray[2][0][0][0])  ) && count < 4) { s.append(" ").append(U()); count++ ; }
                    s.append(" ").append(stringalg("F U' F R' F' R"));
                }
                else {
                    while ( !( cubearray[0][2][1][0].equals(topcolor) && cubearray[0][2][1][1].equals(cubearray[2][0][0][1])  ) && count < 4 ) { s.append(" ").append(U());  count++ ; }
                    s.append(" ").append(stringalg("F U' R U R'"));
                }
                count = 0 ;
            }

        }
        else {
            if (cubearray[0][2][1][0].equals(cubearray[0][2][0][0]) && cubearray[0][2][1][1].equals(cubearray[0][2][0][1]) ) {
                s.append(" ").append(stringalg("R' F R F'"));
            } else if (cubearray[0][2][0][0].equals(cubearray[0][1][0][0]) && cubearray[0][2][0][1].equals(cubearray[0][1][0][2])) {
                s.append(" ").append(stringalg("F' U F U' U' R U R' U'"));
            } else if (cubearray[0][2][0][0].equals(cubearray[0][1][0][2]) && cubearray[0][2][0][1].equals(cubearray[0][1][0][0])) {
                s.append(" ").append(stringalg("U R U' R' U R U' R' F R' F' R"));
            } else {
                s.append(" ").append(stringalg("U' R"));
                if ( cubearray[2][2][2][2].equals(topcolor)) {
                    while ( !( cubearray[0][1][2][0].equals(topcolor) && cubearray[0][1][2][2].equals(cubearray[2][2][2][0])  ) && count < 4 ) { s.append(" ").append(U()); count++ ; }
                    s.append(" ").append(stringalg("R' U R' F R F'"));
                }
                else {
                    while ( !( cubearray[0][1][0][0].equals(topcolor) && cubearray[0][1][0][2].equals(cubearray[2][2][2][2])  ) && count < 4 ) { s.append(" ").append(U());  count++ ;}
                    s.append(" ").append(stringalg("R' U F' U' F"));
                }
            }


        }

        return s.toString();
    }

    /**
     * Orients all the corner pieces with white facing downwards on the bottom layer
     *
     * @return   String containing solution for this phase of {@link #solve()}
     */
    private String f2l() {
        StringBuilder s = new StringBuilder("\n");
        for (int count = 0; count < 4; count++) {
            String color = cubearray[1][1][0][1].substring(0,1), colorside = cubearray[1][2][1][1].substring(0,1);
            for (int x = 0; x < 2; x++) {

                if (! ( (cubearray[2][2][0][0].equals("W") && cubearray[2][2][0][2].equals(color)) && ( cubearray[1][2][0][1].equals(colorside) && cubearray[1][2][0][2].equals(color) ) ) ) {
                    for (int y = 0; y < 10; y += 3) {
                        int corn2 = 5, corn3 = 5 ;
                        boolean check = false;
                        if (cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][0].equals("W")) {
                            corn2 = 1;
                            corn3 = 2;
                            check = true ;
                        } else if (cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][1].equals("W")) {
                            corn2 = 0;
                            corn3 = 2;
                            check = true ;

                        } else if ( cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][2].equals("W") ) {
                            corn2 = 0;
                            corn3 = 1;
                            check = true ;

                        }
                        if ( check ) {
                            if (( cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][corn2].equals(color)  &&  cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][corn3].equals(colorside) ) || ( cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][corn3].equals(color)  && cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][corn2].equals(colorside) )) {
                                if (!( cubearray[2][2][0][0].equals("W") && cubearray[2][2][0][2].equals(color) && cubearray[2][2][0][1].equals(colorside)  && cubearray[1][2][0][2].equals(color) && cubearray[1][2][0][1].equals(colorside) )) {
                                    s.append(cornerslotter(corners[x][y], corners[x][y + 1], corners[x][y + 2], color, colorside)).append(" ");
                                }
                                x = 10 ;
                                y = 15 ;
                            }

                        }

                    }
                }
            }
            s.append(y()).append("\n");
        }

        return s.toString();

    }

    /**
     * Orients all the pieces with Yellow on top, in the top layer
     *
     * @return   String containing solution for this phase of {@link #solve()}
     */
    private String oll() {
        StringBuilder s = new StringBuilder();
        int count = 0 ;
        int[] temp = edges[2] ;
        for (int i = 0; i < 10; i += 3) {
            if (  cubearray[temp[i]][temp[i+1]][temp[i+2]][0].equals("Y") ) { count++ ; }

        }
        if ( count == 0 ) {
            s.append(" ").append(stringalg("F R U R' U' F'"));
            count = 2;
        }
        int ok =0 ;
        if ( count ==2 ) {
            if ((cubearray[0][0][1][0].equals("Y") && cubearray[0][2][1][0].equals("Y")) || (cubearray[0][1][0][0].equals("Y") && cubearray[0][1][2][0].equals("Y")) ) {
                while (!(cubearray[0][0][1][0].equals("Y") && cubearray[0][2][1][0].equals("Y"))  && ok < 4) {
                    s.append(U()).append(" "); ok++;
                }
                s.append(" ").append(stringalg("F R U R' U'"));

            } else {
                while (!(cubearray[0][0][1][0].equals("Y") && cubearray[0][1][2][0].equals("Y")) && ok < 4 ) {
                    s.append("").append(U()).append(" "); ok++ ;
                }
                s.append(" ").append(stringalg("F U R U' R'"));
            }
            s.append(" ").append(Fdash());
        }
        else if ( count !=  4){
            s.append("\n Either you have entered the cube wrongly, or an edge piece is flipped") ;
            return s.toString();
        }

        s.append("\n");
        ok =0 ;
        temp = corners[1] ;
        int sidecount = 0 , frontcount =0 , topcount =0  ;
        for (int i = 0; i < 10; i += 3) {
            if (  cubearray[temp[i]][temp[i+1]][temp[i+2]][0].equals("Y") ) { topcount++ ; }
            else if (  cubearray[temp[i]][temp[i+1]][temp[i+2]][2].equals("Y")  ) { frontcount++ ; }
            else { sidecount++ ; }
        }
        if ( topcount == 4 ) { return s.toString(); }
        else if ( sidecount + frontcount == 3 ) {
            while (!cubearray[0][0][0][0].equals("Y") && ok < 4 ) {
                s.append(" ").append(Udash()); ok++ ;
            }
            if (cubearray[0][0][2][2].equals("Y")) {
                s.append(" ").append(stringalg("R U R' U R U2"));
            } else {
                s.append(" ").append(stringalg("U' U' R U U R' U' R U'"));
            }
            s.append(" ").append(Rdash());
        }
        else if ( frontcount == 4  || sidecount == 4 ) {
            while ( !cubearray[0][2][0][2].equals("Y")  && ok < 4 ) {  s.append(" ").append(U()); ok++ ;  }
            s.append(" ").append(stringalg("R U U R' U' R U R' U' R U' R'"));
        }
        else if ( frontcount == 2 && sidecount == 2 ) {
            while ( !cubearray[0][0][0][1].equals("Y") && ok < 4 ) {  s.append(" ").append(U()); ok++;   }
            s.append(" ").append(stringalg("R U2 R2 U' R2 U' R2 U2 R")).append(oll()) ;
        }
        else if ( frontcount == 2 || sidecount ==2   ) {
            while (!cubearray[0][0][2][2].equals("Y")&& ok < 4 ) {
                s.append(" ").append(Udash()); ok++;
            }
            if ( cubearray[0][2][2][2].equals("Y")) {
                s.append(" ").append(stringalg("R2 D' R U2 R' D R U2 R"));
            }
            else {
                s.append(" ").append(stringalg("r U R' U' r' F R F'"));
            }
        }
        else if ( sidecount ==1 && frontcount == sidecount ) {
            while (!cubearray[0][0][2][1].equals("Y") && ok < 4 ) {
                s.append(" ").append(Udash()); ok++;
            }
            s.append(" ").append(stringalg("F' r U R' U' r' F R"));
        }
        count =0 ;
        for (int i = 0; i < 10; i += 3) {
            if (  cubearray[temp[i]][temp[i+1]][temp[i+2]][0].equals("Y") ) { count++ ; }
        }
        if ( count != 4 ) {
            s.append(" Either you have entered the cube wrongly, or a corner piece is flipped") ;
        }
        return s.toString();
    }

    /**
     * Returns the number of corners with yellow forming a headlight
     *
     * @return int, as per the description
     */
    private int pllco() {
        int count = 0 ;
        int[] temp = {0, 0, 0, 0, 0, 2, 0, 2, 2, 0, 2, 0,0,0,0} ;
        boolean check = true ;
        for (int i = 0; i < 10; i += 3) {
            if ( check ) {
                if (cubearray[temp[i]][temp[i + 1]][temp[i + 2]][1].equals(cubearray[temp[i + 3]][temp[i + 4]][temp[i + 5]][1])) {
                    count++;
                }
            }
            else {
                if (cubearray[temp[i]][temp[i + 1]][temp[i + 2]][2].equals(cubearray[temp[i + 3]][temp[i + 4]][temp[i + 5]][2])) {
                    count++;
                }
            }
            check = !check ;
        }

        return count ;
    }

    /**
     * Returns the number of corners with yellows adjacent to one another
     *
     * @return int, as per the description
     */
    private int pllad() {
        int count =0, fin = 0  ;
        int[] temp = {0, 0, 1,0,0,0,0,0,2, 0, 2, 1,0,2,0,  0,2,2} ;
        for (int i = 0; i < temp.length- 6; i += 9) {
            boolean check1 = false , check2 = false ;
            if (cubearray[temp[i]][temp[i + 1]][temp[i + 2]][1].equals(cubearray[temp[i + 3]][temp[i + 4]][temp[i + 5]][1])) {
                check1 = true ;
                count+=2;
            }

            if (cubearray[temp[i]][temp[i + 1]][temp[i + 2]][1].equals(cubearray[temp[i + 6]][temp[i + 7]][temp[i + 8]][1])) {
                check2 = true ;
                count+=2;
            }
            if ( check1 && check2 ) { count -= 1 ; }
        }
        fin += count ;
        count =0 ;
        int[] temp2 =  { 0, 1, 0,0,0,0,0,2,0, 0, 1, 2,0,2,2,0,0,2 } ;
        for (int i = 0; i < temp2.length - 6; i += 9) {
            boolean check1 = false , check2 = false ;
            if (cubearray[temp2[i]][temp2[i + 1]][temp2[i + 2]][2].equals(cubearray[temp2[i + 3]][temp2[i + 4]][temp2[i + 5]][2])) {
                check1 = true ;
                count+=2;
            }
            if (cubearray[temp2[i]][temp2[i + 1]][temp2[i + 2]][2].equals(cubearray[temp2[i + 6]][temp2[i + 7]][temp2[i + 8]][2])) {
                check2 = true ;
                count+=2;
            }
            if ( check1 && check2 ) { count -= 1 ; }
        }
        fin += count ;
        return fin ;
    }

    /**
     * Manipulates the {@code Cube3} till a bar can be found in the front face of the cube
     *
     * @return String, containing the moves required to obtain the above
     */
    private String fillfront() {
        StringBuilder s = new StringBuilder();
        int count = 0 ;
        while ( !cubearray[0][0][0][2].equals(cubearray[0][1][0][2]) && cubearray[0][0][0][2].equals(cubearray[0][2][0][2]) && count < 4 ) { s.append(" ").append(Udash()); count++; }
        return " " + s ;
    }

    /**
     * Manipulates the {@code Cube3} till adjacent pieces can be found in the front face of the cube
     *
     * @return String, containing the moves required to obtain the above
     */
    private String cofront() {
        StringBuilder s = new StringBuilder();
        int count = 0 ;
        while ( !cubearray[0][0][0][2].equals(cubearray[0][2][0][2]) && count < 4  ) { s.append(" ").append(Udash());  count++; }
        return " " + s ;
    }

    /**
     * Represents the last phase of the {@link #solve()}
     *
     * @return   String containing solution for this phase of {@link #solve()}
     */
    private String pll() {
        StringBuilder s = new StringBuilder();
        int co = pllco() , ad = pllad() ;
        int ok = 0 ;
        if ( ad == 0 ) {
            if (co == 4) {
                if ( cubearray[0][0][0][1].equals(cubearray[0][2][1][1])){
                    s.append(" ").append(stringalg("M2 U M2 U2 M2 U M2"));
                }
                else {
                    while ( !cubearray[0][0][0][2].equals(cubearray[0][2][1][1]) && ok < 4) { s.append(" ").append(U()); ok++ ;  }
                    s.append(" ").append(stringalg("M2 U2 M U' M2 U' M2 U' M"));
                }
            } else {
                s.append(" ").append(stringalg("R' U L' D2 L U' R L' U R' D2 R U' L"));
            }
        }
        else if ( ad == 3 ) {
            s.append(fillfront());
            if ( co == 4 ) {
                if ( cubearray[0][0][0][1].equals(cubearray[0][1][2][2])) {
                    s.append(" ").append(stringalg("M2 U M' U2 M U M2"));
                }
                else {
                    s.append(" ").append(stringalg("M2 U' M' U2 M U' M2"));
                }
            }
            else {
                s.append(" ").append(stringalg("L U' L' U L2 F U F' U' L' F' L F L2 U"));
            }
        }
        else if ( ad == 4 ) {
            if (co == 0) {
                while ( !( cubearray[0][0][0][2].equals(cubearray[0][1][0][2])) && ok < 4) { s.append(" ").append(U()); ok++ ; }
                if ( cubearray[0][0][0][1].equals(cubearray[0][0][1][1])) {
                    s.append(" ").append(stringalg("R' U R' U' B' R' B2 U' B' U B' R B R"));
                }
                else {
                    s.append(" ").append(stringalg("F R' F R2 U' R' U' R U R' F' R U R' U' F'"));
                }
            } else {
                s.append(cofront());
                if ( cubearray[0][0][0][1].equals(cubearray[0][0][1][1])) {
                    s.append(" ").append(stringalg("U F R U' R' U R U R2 F' R U R U' R'"));
                }
                else if ( cubearray[0][0][1][1].equals(cubearray[0][0][2][1]) ){
                    s.append(" ").append(stringalg("R B' R F2 R' B R F2 R2"));
                }
                else {
                    s.append(" ").append(stringalg("U r U r' U' r' F r r U' r' U' r U r' F'"));
                }
            }
        }
        else if ( ad == 2 ) {
            s.append(cofront());
            if ( cubearray[0][0][0][1].equals(cubearray[0][0][1][1])) {
                s.append(" ").append(stringalg("R' U2 R U2 R' F R U R' U' R' F' R2"));
            }
            else if ( cubearray[0][0][1][1].equals(cubearray[0][0][2][1])) {
                s.append(" ").append(stringalg("U2 F2 D' L U' L U L' D F2 R U' R'"));
            }
            else if ( cubearray[0][2][0][1].equals(cubearray[0][2][1][1])) {
                s.append(" ").append(stringalg("U2 R U2 R' U2 R B' R' U' R U R B R2 U"));
            }
            else if ( cubearray[0][2][1][1].equals(cubearray[0][2][2][1])) {
                s.append(" ").append(stringalg("R U2' R' U' F' R U R2 U' R' F R U R2 U2' R'"));
            }
            else if ( cubearray[0][0][2][2].equals(cubearray[0][1][2][2])) {
                s.append(" ").append(stringalg("U R2 D L2 D F2 L D R' D2 L D' R' U2"));
            }
            else if ( cubearray[0][1][2][2].equals(cubearray[0][2][2][2])) {
                s.append(" ").append(stringalg("U2 R' F' R F' U' L' U F R' F' L F2 R"));
            }
        }
        else if ( ad == 9 ) {
            s.append(" ").append(fillfront());
            if (cubearray[0][0][0][1].equals(cubearray[0][0][1][1])) {
                s.append(" ").append(stringalg("U' R' U L U' R U2 L' U L U2 L'"));
            }
            else  {
                s.append(" ").append(stringalg("U' R' L' U2 L U L' U2 R U' L U"));

            }
        }
        else if ( ad == 8 ) {
            if ( cubearray[0][1][0][2].equals(cubearray[0][2][0][2])) {
                s.append("(R U' L U2 R' U L')2 --> ()2, means repeat twice");
                stringalg("R U' L U2 R' U L' R U' L U2 R' U L'") ;

            }
            else {
                s.append("(R' U L' U2 R U' L)2 U --> ()2, means repeat twice");
                stringalg("R' U L' U2 R U' L R' U L' U2 R U' L U") ;

            }
        }
        else if ( ad != 12 ){
            return "You have either entered the cube wrongly, or one of your pieces is still flipped" ; }
        int count =0 ;
        while ( count < 4 && !(cubearray[0][1][0][2].equals(cubearray[1][1][0][1].substring(0,1)) && cubearray[0][0][0][2].equals(cubearray[1][1][0][1].substring(0,1)) && cubearray[0][2][0][2].equals(cubearray[1][1][0][1].substring(0,1)) ))  { s.append(" ").append(U()); count++ ;}
        if ( !cubie.solved(end)) {   s.append(" ").append(pll()) ; }
        return s.toString();
    }

    /**
     * Solves the {@code Cube3} using the Ortega Method and orients it with Green side facing forward
     *
     * @throws Error     If Cubot is unable to solve the cube, then
     *                   an CubeError will be raised
     *                   <br>
     *                   Common causes are :
     *                   <br>
     *                   Input Error
     *                   <br>
     *                   Cube piece is twisted
     * @return String containing the solution
     */
    public String solve() throws Error {
        String s = "" ;
        int count =0 ;
        for (int i = 0 ; i < 2 ; i++ ) {
            count =0 ;
            while (!cubearray[1][1][0][1].equals("Green") && count < 3) {
                s += y() + " ";
                count++;
            }
            s += " " + z() ;
        }
        count =0 ;
        while ( ( !cubearray[2][1][1][1].equals("White") && count < 3 )) { s += " " +  z() ; }
        s += centers() ;
        s += f2l()  ;
        s += oll() ;
        if ( !s.contains("Either") ) {
            s += pll() ;
            if ( s.contains("Either") ) {

                throw new Error("CubeError : Unable to finish solve") ;
            }
        }
        else {
            throw new Error("CubeError : Unable to finish solve") ;}
        s = (shorten(s));
        return  s.replaceAll("\n", " ").trim() ;
    }


    /**
     * Shortens the String given to it as an input
     *
     * @param s     String input to be shortened
     * @return      String containing the shortened String input by a few moves
     */
    public String shorten(String s ) {
        s= s.replaceAll("F' F ", "") ;
        s= s.replaceAll("F F'", "") ;
        s= s.replaceAll("U U' ", "") ;
        s= s.replaceAll("U' U ", "") ;
        s = s.replaceAll("U' U' U' U' ", "") ;
        s = s.replaceAll("U U U U", "") ;
        s = s.replaceAll("U U U ", "Udash ") ;
        s = s.replaceAll("U' U' U' ", "U ") ;
        s = s.replaceAll("U U ", "U2 ") ;
        s = s.replaceAll("U' U' ", "U2' ") ;
        s = s.replaceAll("U' U2", "U ") ;
        s = s.replaceAll("U U2'", "U' ") ;
        s= s.replaceAll("y y y y", "" ) ;
        s= s.replaceAll("y y y", "y'" ) ;
        s= s.replaceAll("x x x", "x'" ) ;
        s= s.replaceAll("z z z", "z'" ) ;
        s= s.replaceAll("z' z", "" ) ;
        s= s.replaceAll("y' y", "" ) ;
        s= s.replaceAll("x' x", "" ) ;
        s= s.replaceAll("y\ny\ny\ny", "\n" ) ;
        s = s.replaceAll("\n\n\n\n", "" );
        s = s.replaceAll("\n\n\n", "" );

        return s ;
    }

    /**
     * Helper method for {@link #stringalg(String)}
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
            case "M" -> M();
            case "M'" -> Mdash();
            case "R2" -> R2();
            case "L2" -> L2();
            case "r" -> r();
            case "r'" -> rdash();
            case "U2", "U2'" -> U2();
            case "F2" -> F2();
            case "B2" -> B2();
            case "M2" -> M2();
            case "D2" -> D2();
            case "y" -> y();
            case "y'" -> ydash() ;
            case "z" -> z();
            case "x" -> x();
            case "E" -> E();
            case "E'" -> Edash();
            case "S" -> S();
            case "S'" -> Sdash();
        }
    }

    /**
     * Helper method for {@link #reversealg(String, boolean)}
     *
     * @param s  Move to be executed
     * @return   String, of move executed
     */
    private String reversedo(String s) {
        String monthString ="" ;
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
            case "U'","Udash":  monthString = "U";
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
            case "M":  monthString = "M'";
                break;
            case "M'": monthString = "M";
                break;
            case "r": monthString = "r'";
                break;
            case "r'": monthString = "r";
                break;
            case "x" : monthString = "x'" ;
                break ;
            case "y" : monthString = "y'" ;
                break ;
            case "z" : monthString = "z'" ;
                break;
            case "E" : monthString = "E'" ;
                break ;
            case "E'" : monthString = "E" ;
                break ;
            case "S" : monthString = "S'" ;
                break;
            default: monthString = s ;
        }
        return monthString ;


    }
}



