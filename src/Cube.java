public class Cube {
    private String[][][][] cube;
    private int w = 0, g = 0, r = 0, o = 0, b = 0, y = 0;

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

    public Cube(String[] temp) throws IllegalArgumentException {
        cube = new String[3][3][3][3];
        String[][] storing = new String[7][9];
        for (int i = 0; i < 6; i++) {
            if (temp[i].length() != 9) {
                throw new IllegalArgumentException("Cube not entered correctly! ( You have missed something )");
            }
            for (int j = 0; j < 9; j++) {
                storing[i][j] = temp[i].substring(j, j + 1);
            }
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
            throw new IllegalArgumentException("Cube not entered correctly! ( You entered something wrong )");
        }
    } // Makes the Cube with String[]

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
        if ((w == 8) && (g == 8) && (r == 8) && (o == 8) && (b == 8) && (y == 8)) {
            return true;
        }
        return false;
    }

    public boolean solved(Cube other) {
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
    } // tells you if its solved, with respect to another cube ( play around with it ;) )

    public String toString() {
        String s = "";
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
        return s;
    } // returns a String representing the cube

    public String[][][][] getCube() {
        return cube;
    } // returns the 4-D cube array
}


