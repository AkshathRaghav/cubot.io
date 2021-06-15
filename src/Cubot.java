import java.util.ArrayList;

public class Cubot {
    private Cubot3 cube3;
    private Cubot2 cube2;
    private final String[] end3 = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"};
    private final String[] end2  = {"RRRR", "GGGG", "OOOO", "BBBB", "WWWW", "YYYY"};

    public Cubot(String[] s) throws IllegalArgumentException {
        if (s.length == 1 && s[0].isEmpty()) { cube3 = new Cubot3(end3) ; } 

        for (int i = 0; i < 6; i++) {
            if (!(s[i].length() == 9 || s[i].length() == 4)) {
                throw new IllegalArgumentException("Cube not entered correctly!");
            }
        }
        if (s[0].length() == 9) {
            try {
                cube3 = new Cubot3(s);
            }
            catch (IllegalArgumentException e) { cube3 = null ; throw e;   }
        }
        else {
            try {
                cube2 = new Cubot2(s) ;
            }
            catch (IllegalArgumentException e) { cube2 = null ; throw e;   }
        }
    }

    public String solve() {
        if (cube3 != null) {
            return cube3.solve();
        }
        return cube2.solve();
    }


    public boolean isSolved() {
        if (cube3 != null) {
            return cube3.isSolved();
        }
        return cube2.isSolved();
    }

    public String toString() {
        if (cube3 != null) {
            return cube3.toString();
        }
        return cube2.toString();
    }

    public String[][][][] getCube() {
        if (cube3 != null) {
            return cube3.getCube();
        }
        assert cube2 != null;
        return cube2.getCube();
    }

    public String[][][][] getSolvedCube() {
        if (cube3 != null) {
            return cube3.getSolvedCube();
        }
        return cube2.getSolvedCube();
    }

    public ArrayList<String> compareToSolved() {
        if (cube3 != null) {
            return cube3.compareToSolved();
        }
        return cube2.compareToSolved();
    }

    public String stringalg(String s) {
        if (cube3 != null) {
            return cube3.stringAlg(s);
        }

        return cube2.stringAlg(s);
    }

    public String getScramble(int n, boolean check) {
        return cube3.getScramble(n, check );
    }

    public String reversealg(String s, boolean check) {
        if (cube3 != null) {
            return cube3.reverseAlg(s, check);
        }
        return cube2.reverseAlg(s, check);
    }

    public String indexString() {
        if (cube3 != null) {
            return cube3.indexString();
        }
        return cube2.indexString();
    }
    public void makeSolved() {
        if (cube3 != null) {
            cube3 = new Cubot3(end3) ;
        }
        cube2 = new Cubot2(end2) ;
    }
    public String cubeState() { 
        if (cube3 != null) { 
            return "Cube3" ; 
        } 
        else { return "Cube2" ; }
    }
        
}
