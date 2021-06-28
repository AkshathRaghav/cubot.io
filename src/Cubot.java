import java.util.ArrayList;

public class Cubot {
    private Cubot3 cube3;
    private Cubot2 cube2;
    private final String[] end3 = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"};
    private final String[] end2  = {"RRRR", "GGGG", "OOOO", "BBBB", "WWWW", "YYYY"};

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
    public Cubot() {
        cube3 = new Cubot3(end3) ;
    }

    public String solve() {
        if (cube2 == null && cube3 != null) {
            return cube3.solve();
        }
        return cube2.solve();
    }


    public boolean isSolved() {
        if (cube2 == null && cube3 != null) {
            return cube3.isSolved();
        }
        return cube2.isSolved();
    }

    public String toString() {
        if (cube2 == null && cube3 != null) {
            return cube3.toString();
        }
        return cube2.toString();
    }

    public String[][][][] getCubeArr() {
        if (cube3 != null) {
            return cube3.getCubeArr();
        }
        return cube2.getCubeArr();
    }
    public Object getCube() {
        if (cube3 != null) {
            return cube3.getCube();
        }
        return cube2.getCube();
    }

    public String[][][][] getSolvedCube() {
        if (cube2 == null && cube3 != null) {
            return cube3.getSolvedCube();
        }
        return cube2.getSolvedCube();
    }

    public ArrayList<String> compareToSolved() {
        if (cube2 == null && cube3 != null) {
            return cube3.compareToSolved();
        }
        assert cube2 != null;
        return cube2.compareToSolved();
    }

    public String stringalg(String s) {
        if (cube2 == null && cube3 != null) {
            return cube3.stringAlg(s);
        }
        assert cube2 != null;
        return cube2.stringAlg(s);
    }

    public String getScramble(int n, boolean check) {
        if (cube2 == null && cube3 != null) {
            return cube3.getScramble(n, check );

        }
        assert cube2 != null;
        return cube2.getScramble(n, check);
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
        if ( cube3 != null) {
            cube3 = new Cubot3(end3) ;
        }
        cube2 = new Cubot2(end2) ;
    }
    public String[] cubeToArr() {
        if (cube3 != null) {
            return cube3.cubeToArr();
        }
        return cube2.cubeToArr();
    }
    public String cubeType() {
        if (cube3 != null) {
            return "3x3";
        }
        return "2x2";
    }

    public boolean compareTo(Cubot other) {
        if (other == null) {
            return false;
        }
        try {
            if (other.getCube() instanceof Cube3 && this.getCube() instanceof Cube3)
                return ((Cube3) this.getCube()).solved((Cube3) other.getCube());
            else
                return ((Cube2) this.getCube()).solved((Cube2) other.getCube());

        } catch (ClassCastException x) {
            throw new IllegalArgumentException( "Error: Unmatched cubeTypes");
        }
    }
}
