import java.util.ArrayList ;

public class Cubot extends Checker{
    public Cubot(String[] s) throws IllegalArgumentException { super(s) ;}
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

}