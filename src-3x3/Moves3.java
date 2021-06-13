public class Moves3 {
    protected Cube3 cubie  ;
    protected String[][][][] cubearray   ;

    public Moves3(String[] s ) throws IllegalArgumentException {
        cubie = new Cube3(s) ;
        cubearray  = cubie.getCube();
    }
    private  final int[] RLdashswaps = {0,0,2,0,2,0,2,2,2,2,0,2,1,0,2,1,2,1,1,2,1,2,0,1} ;
    private  final int[] RdashLswaps = {0,0,0,2,0,2,2,2,2,2,2,0,1,0,0,1,0,1,1,2,1,2,2,1} ;
    private  final int[] UDdashswaps = {0,0,2,0,2,0,2,2,2,2,0,2,0,1,1,0,1,0,2,1,2,1,1,2} ;
    private  final int[] UdashDswaps = {0,0,0,2,0,2,2,2,2,2,2,0,1,0,0,1,0,1,1,2,1,2,2,1} ;
    private  final int[] FBdashswaps = {0,2,0,0,0,0,2,0,2,0,2,2,0,1,1,0,1,0,2,1,2,1,1,2} ;
    private  final int[] FdashBswaps = {2,0,0,0,0,0,0,2,0,2,2,2,1,0,0,1,0,1,1,2,1,2,2,1} ;



    private void colswapper(int colindex, int[] swaps) {
        for (int i = 0 ; i  < swaps.length-2 ; i+=4) {
            String[] temp = cubearray[swaps[i]][colindex][swaps[i+1]], temp2 = cubearray[swaps[i+2]][colindex][swaps[i+3]];
            change(temp2, "col") ;
            cubearray[swaps[i]][colindex][swaps[i+1]] = temp2 ;
            cubearray[swaps[i+2]][colindex][swaps[i+3]] = temp;
        }
    }
    private void rowswapper(int rowindex, int[] swaps) {
        for (int i = 0 ; i  < swaps.length-2 ; i+=4) {
            String[] temp = cubearray[rowindex][swaps[i]][swaps[i+1]], temp2 = cubearray[rowindex][swaps[i+2]][swaps[i+3]];
            change(temp2, "row") ;
            cubearray[rowindex][swaps[i]][swaps[i+1]] = temp2 ;
            cubearray[rowindex][swaps[i+2]][swaps[i+3]] = temp;
        }
    }
    private void frontswapper(int rowindex, int[] swaps) {
        for (int i = 0 ; i  < swaps.length-2 ; i+=4) {
            String[] temp = cubearray[swaps[i]][swaps[i+1]][rowindex], temp2 = cubearray[swaps[i+2]][swaps[i+3]][rowindex];
            change(temp2, "front") ;
            cubearray[swaps[i]][swaps[i+1]][rowindex] = temp2 ;
            cubearray[swaps[i+2]][swaps[i+3]][rowindex] = temp;
        }
    }

    public String R() {
        colswapper(2, RLdashswaps);
        change(cubearray[0][2][2], "col") ;
        change(cubearray[0][2][1], "col") ;

        return "R" ;
    }
    public String Rdash() {
        colswapper(2, RdashLswaps);
        change(cubearray[2][2][0], "col") ;
        change(cubearray[2][2][1], "col") ;
        return "R'" ;
    }

    public String L() {
        colswapper(0, RdashLswaps);
        change(cubearray[2][0][0], "col") ;
        change(cubearray[2][0][1], "col") ;
        return "L" ;
    }
    public String Ldash() {
        colswapper(0, RLdashswaps);
        change(cubearray[0][0][2], "col") ;
        change(cubearray[0][0][1], "col") ;
        return "L'" ;
    }

    public String U() {
        rowswapper(0, UDdashswaps);
        change(cubearray[0][1][2], "row") ;
        change(cubearray[0][0][2], "row") ;
        return "U" ;
    }
    public String Udash() {
        rowswapper(0, UdashDswaps);
        change(cubearray[0][2][0], "row") ;
        change(cubearray[0][2][1], "row") ;
        return "U'" ;
    }

    public String D() {
        rowswapper(2, UdashDswaps);
        change(cubearray[2][2][0], "row") ;
        change(cubearray[2][2][1], "row") ;
        return "D" ;
    }
    public String Ddash() {
        rowswapper(2, UDdashswaps);
        change(cubearray[2][1][2], "row") ;
        change(cubearray[2][0][2], "row") ;
        return "D'" ;
    }


    public String B() {
        frontswapper(2, FdashBswaps);
        change(cubearray[2][1][2], "front") ;
        change(cubearray[2][2][2], "front") ;
        return "B" ;
    }
    public String Bdash() {
        frontswapper(2, FBdashswaps);
        change(cubearray[1][2][2], "front") ;
        change(cubearray[2][2][2], "front") ;
        return "B'" ;
    }

    public String S() {
        frontswapper(1, FBdashswaps);
        change(cubearray[2][2][1], "front") ;
        change(cubearray[1][0][1], "front");
        change(cubearray[0][1][1], "front");
        change(cubearray[2][1][1], "front");
        return "S" ;
    }
    public String Sdash() {
        frontswapper(1, FdashBswaps);
        change(cubearray[2][2][1], "front") ;
        change(cubearray[1][2][1], "front");
        change(cubearray[0][1][1], "front");
        change(cubearray[1][0][1], "front");
        return "S'" ;
    }

    public String F() {
        frontswapper(0, FBdashswaps);
        change(cubearray[1][2][0], "front") ;
        change(cubearray[2][2][0], "front") ;
        return "F" ;
    }
    public String Fdash() {
        frontswapper(0, FdashBswaps);
        change(cubearray[2][1][0], "front") ;
        change(cubearray[2][2][0], "front") ;
        return "F'" ;
    }


    public String M() {
        colswapper(1, RdashLswaps);
        change(cubearray[2][1][0], "col") ;
        return "M" ;
    }
    public String Mdash() {
        colswapper(1, RLdashswaps);
        change(cubearray[0][1][2], "col") ;
        return "M'" ;
    }

    public String E()  {
        rowswapper(1, UdashDswaps);
        change(cubearray[1][2][0], "row") ;
        change(cubearray[1][1][0], "row") ;
        change(cubearray[1][1][2], "row") ;
        change(cubearray[1][0][1], "row") ;
        return "E" ;
    }
    public String Edash() {
        rowswapper(1, UDdashswaps);
        change(cubearray[1][1][0], "row") ;
        change(cubearray[1][0][2], "row") ;
        change(cubearray[1][0][1], "row") ;
        change(cubearray[1][2][1], "row") ;
        return "E'" ;
    }


    public String r() {
        R() ;
        Mdash() ;
        return "r" ;
    }
    public String rdash() {
        Rdash() ;
        M() ;
        return "r'" ;
    }
    public String R2() {
        R() ; R() ;
        return "R2" ;
    }
    public String L2() {
        L() ;
        L() ;
        return "L2" ;
    }
    public String U2() {
        U() ; U() ;
        return "U2" ;
    }
    public String F2() {
        F();
        F();
        return "F2" ;
    }
    public String B2() {
        B() ; B() ;
        return "B2" ;
    }
    public String M2() {
        M() ;
        M() ;
        return "M2" ;
    }
    public String D2() {
        D() ;
        D() ;
        return "D2" ;
    }
    public String M2dash() {
        Mdash() ;
        Mdash() ;
        return "M2dash" ;
    }

    public String y() {
        U();
        Edash() ;
        Ddash();
        return "y" ;
    }

    public String z() {
        F() ;
        S() ;
        Bdash() ;
        return "z" ;
    }
    public String x() {
        R() ;
        Ldash()  ;
        Mdash() ;
        return "x" ;
    }
    public String Rotaterightlower() {
        Edash() ;
        Ddash();
        return "RotateRightLower" ;
    }

    private static void change(String[] piece, String check) {
        if (check.equals("col")) {
            String temp = piece[0] ;
            piece[0] = piece[2] ;
            piece[2] = temp ;
        }
        else if (check.equals("row")) {
            String temp = piece[1] ;
            piece[1] = piece[2] ;
            piece[2] = temp ;
        }
        else if ( check.equals("front")){
            String temp = piece[0] ;
            piece[0] = piece[1] ;
            piece[1] = temp ;
        }
    }
    public String indexString() { return cubie.indexedString();}
}
