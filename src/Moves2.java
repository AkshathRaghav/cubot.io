public class Moves2 {
    protected Cube2 cubie  ;
    protected String[][][][] cubearray   ;

    public Moves2(String[] s ) throws IllegalArgumentException {
        cubie = new Cube2(s);
        cubearray  = cubie.getCube();
    }
    private  final int[] RLdashswaps = {0,0,1,0,1,0,1,1,1,1,0,1} ;
    private  final int[] RdashLswaps = {0,0,0,1,0,1,1,1,1,1,1,0} ;
    private  final int[] UDdashswaps = {0,0,1,0,1,0,1,1,1,1,0,1} ;
    private  final int[] UdashDswaps = {0,0,0,1,0,1,1,1,1,1,1,0} ;
    private  final int[] FBdashswaps = {0,1,0,0,0,0,1,0,1,0,1,1} ;
    private  final int[] FdashBswaps = {1,0,0,0,0,0,0,1,0,1,1,1} ;



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
        colswapper(1, RLdashswaps);
        change(cubearray[0][1][1], "col") ;
        return "R" ;
    }
    public String Rdash() {
        colswapper(1, RdashLswaps);
        change(cubearray[1][1][0], "col") ;
        return "R'" ;
    }

    public String L() {
        colswapper(0, RdashLswaps);
        change(cubearray[1][0][0], "col") ;
        return "L" ;
    }
    public String Ldash() {
        colswapper(0, RLdashswaps);
        change(cubearray[0][0][1], "col") ;
        return "L'" ;
    }

    public String U() {
        rowswapper(0, UDdashswaps);
        change(cubearray[0][0][1], "row") ;
        return "U" ;
    }
    public String Udash() {
        rowswapper(0, UdashDswaps);
        change(cubearray[0][1][0], "row") ;
        return "U'" ;
    }

    public String D() {
        rowswapper(1, UdashDswaps);
        change(cubearray[1][1][0], "row") ;
        return "D" ;
    }
    public String Ddash() {
        rowswapper(1, UDdashswaps);
        change(cubearray[1][0][1], "row") ;
        return "D'" ;
    }


    public String B() {
        frontswapper(1, FdashBswaps);
        change(cubearray[1][1][1], "front") ;
        return "B" ;
    }
    public String Bdash() {
        frontswapper(1, FBdashswaps);
        change(cubearray[1][1][1], "front") ;
        return "B'" ;
    }


    public String F() {
        frontswapper(0, FBdashswaps);
        change(cubearray[1][1][0], "front") ;
        return "F" ;
    }
    public String Fdash() {
        frontswapper(0, FdashBswaps);
        change(cubearray[1][1][0], "front") ;
        return "F'" ;
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
    public String D2() {
        D() ;
        D() ;
        return "D2" ;
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



}

