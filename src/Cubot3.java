import java.util.ArrayList ;

public class Cubot3 extends Checker3 {
    public Cubot3(String[] s) throws IllegalArgumentException { super(s) ;}
    public String solve() {
        String s = super.solve() ;
        return s ;
    }
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
    public String cubeToString() { return super.cubeToString() ; }

}
