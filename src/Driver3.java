public class Driver3 {
    public static void main(String[] args) {
        String[] temp = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"};
        Cubot cube = new Cubot(temp) ;
        cube.stringalg("R") ;
        System.out.println(cube);
        cube.solve() ;
        System.out.println(cube.isSolved());
        String[] temp2 = {"RRRR", "GGGG", "OOOO", "BBBB", "WWWW", "YYYY"};
        cube = new Cubot(temp2) ;
        cube.stringalg("R") ;
        cube.stringalg("R'") ;
        System.out.println(cube);
        System.out.println(cube.isSolved());
        System.out.println(cube.compareToSolved());
        String[][][][] cubearr = cube.getCube() ;

    }
}
