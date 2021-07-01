/**
 * Cube3 class creates and handles the
 * basic output and methods which do not involve
 * changing the cube[][][][] or Cube2 object
 *
 * @author  Akshath Raghav
 * @version 2.0
 * @since   2021-05-20
 * @see <a href="https://github.com/AkshathRaghav/cubot.io">cubot.io</a>
 */
public class Cube3 {
    private final String[][][][] cube;
    private int w = 0, g = 0, r = 0, o = 0, b = 0, y = 0;

    /**
     * Constructs a {@code Cube3} and stories it in the cube[][][][] array
     *
     * @param temp   String[] input from the user containing the colors on each side
     * @throws       IllegalArgumentException on input error
     * @see          IllegalArgumentException
     * {@link #isValid()}
     * {@link #checker(String)}
     */
    public Cube3(String[] temp) throws IllegalArgumentException {
        cube = new String[3][3][3][3];
        String[][] storing = new String[7][9];
        String[] colors = { "R" ,"G", "O" , "B", "W", "Y"} ;
        for (int i = 0; i < 6; i++) {
            if (temp[i].length() != 9) {
                throw new IllegalArgumentException("Input Error");
            }
            try {
                for (int j = 0; j < 9; j++) {
                    storing[i][j] = temp[indexFinder(colors[i], temp)].substring(j, j + 1);
                }
            }
            catch (StringIndexOutOfBoundsException e) { throw new IllegalArgumentException("Input Error"); }
        }
        String[] finalcolors = {storing[5][6], storing[0][2], storing[1][0], storing[5][3], storing[0][1], null, storing[5][0], storing[0][0], storing[3][2], null, storing[0][5], storing[1][3], "Red", null, storing[0][3], storing[3][5], storing[4][0], storing[0][8], storing[1][6], storing[4][3], storing[0][7], null, storing[4][6], storing[0][6], storing[3][8], storing[5][7], null, storing[1][1], "Yellow", storing[5][1], null, storing[3][1],
                "Green", "Blue", storing[4][1], null, storing[1][7], "White", storing[4][7], null, storing[3][7], storing[5][8], storing[2][0], storing[1][2], storing[5][5], storing[2][1], null, storing[5][2], storing[2][2], storing[3][0], null, storing[2][3], storing[1][5], "Orange", null, storing[2][5], storing[3][3], storing[4][2], storing[2][6], storing[1][8], storing[4][5], storing[2][7], null, storing[4][8], storing[2][8], storing[3][6]};
        int count = 0;
        for (int j = 0; j < cube.length; j++) {
            for (int i = 0; i < cube.length; i++) {
                for (int k = 0; k < cube.length; k++) {

                    if ((i == 0 && j == 0 && k != 1) || (i == 0 && j == 2 && k != 1) || (i == 2 && j == 0 && k != 1) || (i == 2 && j == 2 && k != 1)) {
                        cube[i][j][k][0] = finalcolors[count];
                        cube[i][j][k][1] = finalcolors[count + 1];
                        cube[i][j][k][2] = finalcolors[count + 2];
                        count += 3;
                    } else if ((i == 1 && j == 1 && k == 2) || (i == 1 && j == 0 && k == 1) || (i == 1 && j == 2 && k == 1) || (i == 0 && j == 1 && k == 1) || (i == 2 && j == 1 && k == 1) || (i == 1 && j == 1 && k == 0)) {
                        cube[i][j][k][1] = finalcolors[count];
                        count++;
                    } else if (i == 1 && j == 1 && k == 1) {
                        cube[i][j][k][1] = "Joint";
                    } else {
                        cube[i][j][k][0] = finalcolors[count];
                        cube[i][j][k][1] = finalcolors[count + 1];
                        cube[i][j][k][2] = finalcolors[count + 2];
                        count += 3;
                    }
                }
            }
        }
        if (!isValid()) {
            throw new IllegalArgumentException("Input Error");
        }
    }

    /**
     * Private method to check if {@code Cube3} is made without any error
     *
     * @return true, if everything is fine. false, otherwise
     * {@link #checker(String)}
     */
    private boolean isValid() {
        for (int j = 0; j < cube.length; j++) {
            for (int i = 0; i < cube.length; i++) {
                for (int k = 0; k < cube.length; k++) {
                    String a, x, c;
                    if (cube[i][j][k][0] != null || cube[i][j][k][2] != null) {
                        if (cube[i][j][k][0] == null) {
                            checker(cube[i][j][k][1]);
                            checker(cube[i][j][k][2]);

                        } else if (cube[i][j][k][1] == null) {
                            checker(cube[i][j][k][2]);
                            checker(cube[i][j][k][0]);

                        } else if (cube[i][j][k][2] == null) {
                            checker(cube[i][j][k][1]);
                            checker(cube[i][j][k][0]);

                        } else {
                            checker(cube[i][j][k][1]);
                            checker(cube[i][j][k][2]);
                            checker(cube[i][j][k][0]);
                        }
                    }
                }
            }
        }
        return (w == 8) && (g == 8) && (r == 8) && (o == 8) && (b == 8) && (y == 8);
    }

    /**
     * adds 1 to each color variable ( an instance of the object ) depending on the input
     *
     * @param s  One of the 6 colors
     */
    private void checker(String s) {
        switch (s) {
            case "W" -> w++;
            case "G" -> g++;
            case "R" -> r++;
            case "O" -> o++;
            case "B" -> b++;
            case "Y" -> y++;
        }
    }

    /**
     * Used by the constructor to find the String which contains the face needed
     *
     * @param s     the color of the face needed
     * @param temp  the String[] to be searched
     * @return      int, index of cube-face-string in temp
     */
    private int indexFinder(String s, String[] temp) {
        for (int i =0 ; i < temp.length ; i++ ) {
            if (temp[i].substring(4,5).equals(s)) {
                return i;
            }
        }
        return -1 ;
    }

    /**
     * Gives a String[] object which can be used to make other {@code Cube2} or {@code Cubot} objects
     *
     * @return String[], as defined above
     */
    public String[] cubeToArr() {
        String s = "" ;
        String store = toString() ;
        String[] storeArr = store.split("\n"), charStore = new String[6];
        for (int i =0 ; i < storeArr.length; i++ ) {
            if (i > 5 || i < 3 ) {
                String temp = storeArr[i].substring(storeArr[i].indexOf("|") + 1) ;
                int index = 5 ;
                if ( i > 5  ) { index = 4 ;}
                charStore[index] += temp.substring(0, temp.indexOf("|")).replaceAll(" ", "");
            }
            else {
                String[] temp  = storeArr[i].split(" | ");
                int count = -1 ;
                for (String k : temp) {
                    if (k.equals("|")) { count ++ ; }
                    else {
                        charStore[count] += k;
                    }
                }
            }

        }
        for (int i = 0; i < charStore.length; i++ ) {
            charStore[i] = charStore[i].replaceAll("null", " ").substring(1);
        }
        return charStore ;
    }


    /**
     * Checks if the cube is solved with respect to another cube ( of the same type )
     *
     * @param other     The {@code Cube3} object to be compared to
     * @return          true, if solved. false, otherwise
     */
    public boolean solved(Cube3 other) {
        for (int j = 0; j < cube.length; j++) {
            for (int i = 0; i < cube.length; i++) {
                for (int k = 0; k < cube.length; k++) {
                    if (cube[i][j][k][0] == null && cube[i][j][k][2] == null) {
                        if (!cube[i][j][k][1].equals(other.cube[i][j][k][1])) {
                            return false;
                        }
                    } else if (cube[i][j][k][0] == null) {
                        if (!(cube[i][j][k][1].equals(other.cube[i][j][k][1]) && cube[i][j][k][2].equals(other.cube[i][j][k][2]))) {
                            return false;
                        }
                    } else if (cube[i][j][k][1] == null) {
                        if (!(cube[i][j][k][0].equals(other.cube[i][j][k][0]) && cube[i][j][k][2].equals(other.cube[i][j][k][2]))) {
                            return false;
                        }
                    } else if (cube[i][j][k][2] == null) {
                        if (!(cube[i][j][k][1].equals(other.cube[i][j][k][1]) && cube[i][j][k][0].equals(other.cube[i][j][k][0]))) {
                            return false;
                        }
                    } else {
                        if (!(cube[i][j][k][1].equals(other.cube[i][j][k][1]) && cube[i][j][k][2].equals(other.cube[i][j][k][2]) && cube[i][j][k][0].equals(other.cube[i][j][k][0]))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Gives a String with the indexes as well as the colors on each side of each cube piece, or cubie for short
     *
     * @return String
     */
    public String indexedString() {
        String s = "" ;
        String[] lis = {"Left", "Middle", "Right"};
        for (int j = 0; j < cube.length; j++) {
            s += lis[j] + " : From top row to bottom row - " + "\n --------------------------------------";

            for (int i = 0; i < cube.length; i++) {
                s += "\n";
                for (int k = 0; k < cube.length; k++) {
                    s += i + " " + j + "  " + k + ":" + "\t\t|\t\t";

                    if (cube[i][j][k][0] == null && cube[i][j][k][2] == null) {
                        s += "Center: " + cube[i][j][k][1] + "\t\t|\t\t";
                    } else if (cube[i][j][k][0] == null) {
                        s += "F/b: " + cube[i][j][k][2] + " Side: " + cube[i][j][k][1] + "\t\t|\t\t";
                    } else if (cube[i][j][k][1] == null) {
                        s += "T/b: " + cube[i][j][k][0] + " F/b: " + cube[i][j][k][2] + "\t\t|\t\t";
                    } else if (cube[i][j][k][2] == null) {
                        s += "T/b: " + cube[i][j][k][0] + " Side: " + cube[i][j][k][1] + "\t\t|\t\t";
                    } else {
                        s += "T/b: " + cube[i][j][k][0] + " F/b: " + cube[i][j][k][2] + " Side: " + cube[i][j][k][1] + "\t\t|\t\t";
                    }
                }
                s += "\n";
            }
            s += " -------------------------------------- \n\n\n";
        }
        return s ;
    }

    /**
     * prints the Cube2 as if all faces have been opened up while facing upwards, with Green face in the center
     *
     * @return String
     */
    public String toString() {
        String s = "";
        for (int j = 0; j < 3; j++) {
            s += "\t\t| " ;
            for (int k = 0; k < 3; k++) {
                if ( j ==1 && k == 1 ) {  s += cube[0][k][2-j][1].charAt(0) + " " ; }
                else { s += cube[0][k][2-j][0].charAt(0) + " " ; }
            }
            s += "|\n" ;
        }
        for (int i =0 ; i < 3 ; i++ ) {
            s += "| " ;
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    if ( j ==  0 ) {
                        s += cube[i][0][2 - k][1].charAt(0) + " ";
                    }
                    else if ( j ==1 ) {
                        if (i == 1 &&  k == 1 ) { s += cube[i][k][0][1].charAt(0) + " ";}
                        else {
                            s += cube[i][k][0][2].charAt(0) + " ";
                        }
                    }
                    else if ( j == 2) {
                        s += cube[i][2][k][1].charAt(0) + " ";
                    }
                    else {
                        if (i == 1 && k == 1) {
                            s += cube[i][2 - k][2][1].charAt(0) + " ";
                        } else {
                            s += cube[i][2 - k][2][2].charAt(0) + " ";
                        }
                    }
                }
                s += "| " ;
            }
            s += "\n" ;
        }
        for (int j = 0; j < 3; j++) {
            s += "\t\t| " ;
            for (int k = 0; k < 3; k++) {
                if ( j ==1 && k == 1 ) {  s += cube[2][k][2-j][1].charAt(0) + " " ; }
                else { s += cube[2][k][j][0].charAt(0) + " " ; }
            }
            s += "|\n" ;
        }
        return s;
    }

    /**
     * Used to get a String[][][][] which contains the {@code Cube2} in its base form
     *
     * @return String[][][][]
     */
    public String[][][][] getCube() {
        return cube;
    }
}


