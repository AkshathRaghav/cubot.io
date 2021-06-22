import java.util.ArrayList;

public class Cubot2 extends Checker2 {
    public Cubot2(String[] s) throws IllegalArgumentException { super(s) ;}
    public boolean isSolved() { return super.isSolved() ;}
    public String toString() {
        return cubie.toString() ;
    }
    public String[][][][] getCube() {
        return cubie.getCube();
    }
    public String[][][][] getSolvedCube() { return super.getSolvedCube() ; }
    public ArrayList<String> compareToSolved()  { return super.compareToSolved() ; }
    public String stringAlg(String s) { return super.stringalg(s) ; }
    public String getScramble(int n, boolean check) { return super.getScramble(n, check) ; }
    public String reverseAlg(String s, boolean check ) { return  super.reversealg(s, check ) ; }
    public String indexedString() { return cubie.indexedString();}
    public String solve() { return "Coming soon" ; }
    public String cubeToString() { return super.cubeToString() ; }


}

