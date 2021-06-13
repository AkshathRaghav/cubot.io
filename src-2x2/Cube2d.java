public class Cube2d {
    private String[][][][] cube;
    private int w = 0, g = 0, r = 0, o = 0, b = 0, y = 0;
    String[][] storing ;

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

    public Cube2d(String[] temp) throws IllegalArgumentException {
        cube = new String[2][2][2][3];
        String[][] storing = new String[6][4];
        for (int i = 0; i < 6; i++) {
            if (temp[i].length() != 4) {
                throw new IllegalArgumentException("Cube not entered correctly! ( You have missed something )");
            }
            try {
                for (int j = 0; j < 4; j++) {
                    storing[i][j] = temp[i].substring(j, j + 1);
                }
            }
            catch (StringIndexOutOfBoundsException e) { throw new IllegalArgumentException("Cube not entered correctly"); }
        }

        String[] finalcolors = {storing[5][2], storing[0][1], storing[1][0], storing[5][0], storing[0][0], storing[3][1], storing[4][0], storing[0][3], storing[1][2],
        storing[4][2], storing[0][2], storing[3][3], storing[5][3], storing[2][0], storing[1][1], storing[5][1], storing[2][1], storing[3][0], storing[4][1], storing[2][2], storing[1][3],
        storing[4][3], storing[2][3], storing[3][2]} ;
        int count = 0;
        for (int j = 0; j < cube.length; j++) {
            for (int i = 0; i < cube.length; i++) {
                for (int k = 0; k < cube.length; k++) {
                    cube[i][j][k][0] = finalcolors[count];
                    cube[i][j][k][1] = finalcolors[count + 1];
                    cube[i][j][k][2] = finalcolors[count + 2];
                    count += 3;
                }

            }
        }
        if (!isValid()) {
            throw new IllegalArgumentException("Cube not entered correctly! ( You entered something wrong )");
        }
    } // Makes the Cube with String[]

    private boolean isValid() {
        for (int j = 0; j < cube.length; j++) {
            for (int i = 0; i < cube.length; i++) {
                for (int k = 0; k < cube.length; k++) {
                    String a, x, c;
                    checker(cube[i][j][k][1]);
                    checker(cube[i][j][k][2]);
                    checker(cube[i][j][k][0]);
                }
            }
        }
        if ((w == 4) && (g == 4) && (r == 4) && (o == 4) && (b == 4) && (y == 4)) {
            return true;
        }
        return false;
    }

    public boolean solved(Cube2d other) {
        for (int j = 0; j < cube.length; j++) {
            for (int i = 0; i < cube.length; i++) {
                for (int k = 0; k < cube.length; k++) {

                    if (!(cube[i][j][k][1].equals(other.cube[i][j][k][1]) && cube[i][j][k][2].equals(other.cube[i][j][k][2]) && cube[i][j][k][0].equals(other.cube[i][j][k][0]))) {
                        return false;
                    }

                }
            }
        }
        return true;
    } // tells you if its solved, with respect to another cube ( play around with it ;) )
    public String indexedString() {
        String s = "" ;
        String[] lis = {"Left",  "Right"};
        for (int j = 0; j < cube.length; j++) {
            s += lis[j] + " : From top row to bottom row - " + "\n --------------------------------------";

            for (int i = 0; i < cube.length; i++) {
                s += "\n";
                for (int k = 0; k < cube.length; k++) {
                    s += i + " " + j + "  " + k + ":" + "\t\t|\t\t";

                    s += "T/b: " + cube[i][j][k][0] + " F/b: " + cube[i][j][k][2] + " Side: " + cube[i][j][k][1] + "\t\t|\t\t";

                }
                s += "\n";
            }
            s += " -------------------------------------- \n\n\n";
        }
        return s ;
    } // returns the colors on each side of the cube pieces with index

    public String toString() {
        String s = "" ;
        for (int j = 0; j < 2; j++) {
            s += "\t  | " ;
            for (int k = 0; k < 2; k++) {
                s += cube[0][k][1 - j][0].charAt(0) + " " ;
            }
            s += "|\n" ;
        }
        for (int i =0 ; i < 2 ; i++ ) {
            s += "| " ;
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    if (j == 0) {
                        s += cube[i][0][1 - k][1].charAt(0) + " ";
                    } else if (j == 1) {
                        s += cube[i][k][0][2].charAt(0) + " ";
                    } else if (j == 2) {
                        s += cube[i][1][k][1].charAt(0) + " ";
                    } else {
                        s += cube[i][1 - k][1][2].charAt(0) + " ";
                    }

                }
                s += "| " ;
            }
            s += "\n" ;
        }
        for (int j = 0; j < 2; j++) {
            s += "\t  | " ;
            for (int k = 0; k < 2; k++) {
                s += cube[1][k][j][0].charAt(0) + " " ;
            }
            s += "|\n" ;
        }
        return s;
    } // returns a Cube on the terminal

    public String[][][][] getCube() {
        return cube;
    } // returns the 4-D cube array
}


