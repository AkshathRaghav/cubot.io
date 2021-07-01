import java.util.ArrayList;

public class Cubot2 extends Checker2 {
    public Cubot2(String[] s) throws IllegalArgumentException { super(s) ;}
    public boolean isSolved() { return super.isSolved() ;}
    public String toString() {
        return cubie.toString() ;
    }
    public String[][][][] getCubeArr() {
        return cubie.getCube();
    }
    public String[][][][] getSolvedCube() { return super.getSolvedCube() ; }
    public ArrayList<String> compareToSolved()  { return super.compareToSolved() ; }
    public String stringAlg(String str) { return super.stringAlg(str) ; }
    public String getScramble(int n, boolean check) { return super.getScramble(n, check) ; }
    public String reverseAlg(String str, boolean check ) { return  super.reverseAlg(str, check ) ; }
    public String indexString() { return cubie.indexString();}
    public String solve() { return "Coming soon" ; }
    public String[] cubeToArr() { return cubie.cubeToArr() ; }
    public Cube2 getCube() { return cubie ; }

}

