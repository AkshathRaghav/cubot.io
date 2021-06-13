import java.util.ArrayList;

public class Cubot2d extends Checker2d{
    public Cubot2d(String[] s) throws IllegalArgumentException { super(s) ;}
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
    public String indexString() { return cubie.indexedString();}

}

