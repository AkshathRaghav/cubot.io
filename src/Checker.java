    import java.util.ArrayList ;
    public class Checker extends Moves {
        private final String[] temp = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"};
        private final Cube end = new Cube(temp) ;

        public Checker(String[] s) throws IllegalArgumentException {
            super(s) ;
        }
        private final int[][] edges = {{2, 0, 1, 2, 1, 0, 2, 2, 1, 2, 1, 2}, {1, 0, 0, 1, 0, 2, 1, 2, 0, 1, 2, 2}, {0, 0, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2}};
        private final int[][] corners = {{2, 0, 0, 2, 0, 2, 2, 2, 0, 2, 2, 2}, {0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 2, 2}};
        //shorten - shortens the solution returned
        public String shorten(String s ) {
            s= s.replaceAll("F' F ", "") ;
            s= s.replaceAll("F F'", "") ;
            s= s.replaceAll("U U' ", "") ;
            s= s.replaceAll("U' U ", "") ;
            s = s.replaceAll("U' U' U' U' ", "") ;
            s = s.replaceAll("U U U U", "") ;
            s = s.replaceAll("U U U ", "Udash ") ;
            s = s.replaceAll("U' U' U' ", "U ") ;
            s = s.replaceAll("U U ", "U2 ") ;
            s = s.replaceAll("U' U' ", "U2' ") ;
            s = s.replaceAll("U' U2", "U ") ;
            s = s.replaceAll("U U2'", "U' ") ;
            s= s.replaceAll("y\ny\ny\ny", "\n" ) ;
            s = s.replaceAll("\n\n\n\n", "" );
            s = s.replaceAll("\n\n\n", "" );
            s = s.replaceAll("Either", "\n Either" );

            return s ;
        }

        //chooses which move to execute based on input
        private void choose(String ch) {
            switch (ch) {
                case "R" -> R();
                case "R'" -> Rdash();
                case "L'" -> Ldash();
                case "L" -> L();
                case "U" -> U();
                case "U'" -> Udash();
                case "F" -> F();
                case "F'" -> Fdash();
                case "B" -> B();
                case "B'" -> Bdash();
                case "D" -> D();
                case "D'" -> Ddash();
                case "M" -> M();
                case "M'" -> Mdash();
                case "R2" -> R2();
                case "L2" -> L2();
                case "r" -> r();
                case "r'" -> rdash();
                case "U2", "U2'" -> U2();
                case "F2" -> F2();
                case "B2" -> B2();
                case "M2" -> M2();
                case "D2" -> D2();
            }
        }

        //converts String to alg ( to shorten the work ) - makes use of choose(ch)
        public String stringalg(String str) {
            String s = str.trim();
            while (str.contains(" ")) {
                choose(str.substring(0, str.indexOf(" ")));
                str = str.substring(str.indexOf(" ") +1 ) ;
            }
            choose(str);
            return s ;

        }

        // slots the edges
        private String throwcoloredgers(String color, String colorside ) {
            String s = "" ;
            int i = 5 , j = 5 , k = 5 ;
            for (int count = 0 ; count < 10 ; count += 3 ) {
                if ( (cubearray[1][edges[1][count+1]][edges[1][count+2]][1].equals(color) && cubearray[1][edges[1][count+1]][edges[1][count+2]][2].equals(colorside))  || (cubearray[1][edges[1][count+1]][edges[1][count+2]][2].equals(color) && cubearray[1][edges[1][count+1]][edges[1][count+2]][1].equals(colorside)) )   {
                    i = 1 ;
                    j = edges[1][count+1] ;
                    k = edges[1][count+2] ;
                }
                else if (cubearray[0][edges[2][count+1]][edges[2][count+2]][1] == null ) {
                    if ((cubearray[0][edges[2][count+1]][edges[2][count+2]][0].equals(color) && cubearray[0][edges[2][count+1]][edges[2][count+2]][2].equals(colorside))  || (cubearray[0][edges[2][count+1]][edges[2][count+2]][2].equals(color) && cubearray[0][edges[2][count+1]][edges[2][count+2]][0].equals(colorside)) ) {
                        i = 0;
                        j = edges[0][count + 1];
                        k = edges[0][count + 2];
                    }
                }
    //            if (cubearray[2][edges[1][count+1]][edges[1][count+2]][1] == null )
                else if (cubearray[0][edges[2][count+1]][edges[2][count+2]][2] == null ) {
                    if ((cubearray[0][edges[2][count+1]][edges[2][count+2]][0].equals(color) && cubearray[0][edges[2][count+1]][edges[2][count+2]][1].equals(colorside))  || (cubearray[0][edges[2][count+1]][edges[2][count+2]][1].equals(color) && cubearray[0][edges[2][count+1]][edges[2][count+2]][0].equals(colorside)) ) {
                        i = 0;
                        j = edges[0][count + 1];
                        k = edges[0][count + 2];
                    }
                }
            }
            if ( i == 1   ) {
                if (j == 0) {
                    if (k == 0) {
                        s += " " + Ldash() +Udash() + L() ;
                    } else {
                        s += " " + L() +Udash() +Ldash() ;
                    }
                    s += " " +U() ;


                    return cubearray[0][0][1][0] + s  ;

                }
                else {
                    if (k == 0) {
                        s += " " +R() +Udash()  +Rdash()  +U()  +U() ;

                    } else {
                        s += " " +Rdash() +U() +R() ;

                    }
                    return cubearray[0][1][0][0] + s;
                }

            }
            return cubearray[i][j][k][0]  + s ;
        }

        //pll helper methods
        private int pllco() {
            int count = 0 ;
            int[] temp = {0, 0, 0, 0, 0, 2, 0, 2, 2, 0, 2, 0,0,0,0} ;
            boolean check = true ;
            for (int i = 0; i < 10; i += 3) {
                if ( check ) {
                    if (cubearray[temp[i]][temp[i + 1]][temp[i + 2]][1].equals(cubearray[temp[i + 3]][temp[i + 4]][temp[i + 5]][1])) {
                        count++;
                    }
                }
                else {
                    if (cubearray[temp[i]][temp[i + 1]][temp[i + 2]][2].equals(cubearray[temp[i + 3]][temp[i + 4]][temp[i + 5]][2])) {
                        count++;
                    }
                }
                check = !check ;
            }

            return count ;
        }
        private int pllad() {
            int count =0, fin = 0  ;
            int[] temp = {0, 0, 1,0,0,0,0,0,2, 0, 2, 1,0,2,0,  0,2,2} ;
            for (int i = 0; i < temp.length- 6; i += 9) {
                boolean check1 = false , check2 = false ;
                    if (cubearray[temp[i]][temp[i + 1]][temp[i + 2]][1].equals(cubearray[temp[i + 3]][temp[i + 4]][temp[i + 5]][1])) {
                        check1 = true ;
                        count+=2;
                    }

                    if (cubearray[temp[i]][temp[i + 1]][temp[i + 2]][1].equals(cubearray[temp[i + 6]][temp[i + 7]][temp[i + 8]][1])) {
                        check2 = true ;
                        count+=2;
                    }
                    if ( check1 && check2 ) { count -= 1 ; }
            }
    //        if (count == 4) { count = 3 ; }
            fin += count ;
            count =0 ;
            int[] temp2 =  { 0, 1, 0,0,0,0,0,2,0, 0, 1, 2,0,2,2,0,0,2 } ;
            for (int i = 0; i < temp2.length - 6; i += 9) {
                boolean check1 = false , check2 = false ;

                if (cubearray[temp2[i]][temp2[i + 1]][temp2[i + 2]][2].equals(cubearray[temp2[i + 3]][temp2[i + 4]][temp2[i + 5]][2])) {

                    check1 = true ;
                    count+=2;
                }

                if (cubearray[temp2[i]][temp2[i + 1]][temp2[i + 2]][2].equals(cubearray[temp2[i + 6]][temp2[i + 7]][temp2[i + 8]][2])) {
                    check2 = true ;
                    count+=2;

                }
                if ( check1 && check2 ) { count -= 1 ; }

            }
    //        if (count == 4) { count = 3 ; }
            fin += count ;
            return fin ;
        }
        private String fillfront() {
            StringBuilder s = new StringBuilder();
            int count = 0 ;
            while ( !cubearray[0][0][0][2].equals(cubearray[0][1][0][2]) && cubearray[0][0][0][2].equals(cubearray[0][2][0][2]) && count < 4 ) { s.append(" ").append(Udash()); count++; }
            return " " + s ;
        }
        private String cofront() {
            StringBuilder s = new StringBuilder();
            int count = 0 ;
            while ( !cubearray[0][0][0][2].equals(cubearray[0][2][0][2]) && count < 4  ) { s.append(" ").append(Udash());  count++; }
            return " " + s ;
        }

        //helper methods for slotting/optimizing corners and centers - Try to make it better
        private String centerslotter(int i, int j, int k, int index, int color) {
            StringBuilder s = new StringBuilder();
            if (i == 1) {
                // 3 is the case when the edge is connected ( but in various position - this is to speed up the solution )
                if ( color == 3 ) {
                    if (j == 0) {
                        if (k == 0) {
                            if ( index == 1) { s.append(L()); }
                            else {
                                s.append(Fdash()); }
                        } else {
                            if ( index == 1 ) { s.append(Ldash());}
                            else { s.append(B());}
                        }
                    } else {
                        if (k == 0) {
                            if ( index == 1 ) { s.append(Rdash()); }
                            else {  s.append(F());}
                        } else {
                            if ( index == 1 ) { s.append(R()); }
                            else {  s.append(Bdash());}
                        }
                    }
                    return s.toString();
                }
                int count = 0 ;
                if (color == 1) {
                    while (cubearray[index][0][1][0].equals("W") && count < 4 ) {
                        s.append(U()); count++ ;
                    }
                    if (k == 0) {
                        if (j == 0) {
                            s.append(F()).append(Udash()).append(Fdash());
                        } else {
                            s.append(Fdash())append(Udash()).append(F());
                        }
                    } else {
                        if (j == 0) {
                            s.append(Bdash()).append(U()).append(B());
                        } else {
                            s.append(B()).append(U()).append(Bdash());
                        }
                    }
                } else {

                    while (cubearray[index][1][0][0].equals("W")&& count< 4) {
                        s.append(U()); count++ ;
                    }
                    if (k == 0) {
                        if (j == 0) {
                            s.append(Ldash()).append(U()).append(L());
                        } else {
                            s.append(R());append(Udash()).append(Rdash());
                        }
                    } else {
                        if (j == 0) {
                            s.append(L()).append(U()).append(Ldash());
                        } else {
                            s.append(Rdash()).append(Udash()).append(R());
                        }
                    }
                }
            }
            else {
                if ( i == 1 ) {
                    int  count = 0 ;
                    while (cubearray[index][j][k][color].equals("W") && count < 4) {
                        s.append(Udash()); count++;
                    }
                }
                    if (j == 1) {
                        if (k == 0) {
                            s.append(F());
                            s.append(F());
                        } else {
                            s.append(B());
                            s.append(B());
                        }
                    } else if (j == 0) {
                        s.append(L());
                        s.append(L());
                    } else {
                        s.append(R());
                        s.append(R());
                    }

            }
            return s.toString();
        }
        private String cornerslotter(int i , int j , int k ,String temp1 ,String temp2) {
            String colorinfront;
            String coloronside;
            String colorontop;
            StringBuilder s = new StringBuilder();

            if ( i == 2 ) {
                if (j == 0) {
                    if (k == 0) {
                        s.append(" ").append(stringalg("L' U' L"));
                         colorontop = cubearray[0][2][0][0] ;
                         coloronside = cubearray[0][2][0][1] ;
                         colorinfront = cubearray[0][2][0][2] ;

                    } else {
                        s.append(" ").append(stringalg("L U' L''"));
                        colorontop = cubearray[0][0][2][0] ;
                        coloronside = cubearray[0][0][2][1] ;
                        colorinfront = cubearray[0][0][2][2] ;
                    }
                } else {
                    if (k == 0) {
                        s.append(" ").append(stringalg("R U R'"));
                        colorontop = cubearray[0][0][0][0] ;
                        coloronside = cubearray[0][0][0][1] ;
                        colorinfront = cubearray[0][0][0][2] ;
                    } else {
                        s.append(" ").append(stringalg("R' U R"));
                        colorontop = cubearray[0][2][2][0] ;
                        coloronside = cubearray[0][2][2][1] ;
                        colorinfront = cubearray[0][2][2][2] ;
                    }
                }
            }
            else {
                colorontop = cubearray[i][j][k][0] ;
                coloronside = cubearray[i][j][k][1] ;
                colorinfront = cubearray[i][j][k][2] ;
            }
            int count =0 ;
            while ( !( ( cubearray[0][2][0][0].equals(colorontop) ) && ((cubearray[0][2][0][1].equals(coloronside) && cubearray[0][2][0][2].equals(colorinfront) ) || ( cubearray[0][2][0][1].equals(colorinfront) && cubearray[0][2][0][2].equals(coloronside)  ))  ) && count < 4){ s.append(" ").append(U()); count++ ; }
            count = 0;
            String topcolor = throwcoloredgers(temp1, temp2);

            s.append(topcolor.substring(1));

            topcolor = topcolor.substring(0,1) ;

            if ( cubearray[0][2][0][0].equals("W")) {
                s.append(" ").append(R());
                s.append(" ").append(Udash());
                if (!(cubearray[0][1][0][0].equals(topcolor) && ( cubearray[0][1][0][2].equals(temp1) || cubearray[0][1][0][2].equals(temp2)) )) {
                    s.append(" ").append(Udash());
                    s.append(" ").append(Rdash());
                }
                else {

                    s.append(" ").append(Rdash());
                    s.append(" ").append(Udash());

                }
                s.append(" ").append(Udash());

            }


            if ( cubearray[0][2][0][1].equals("W") ) {
                if (cubearray[0][1][0][0].equals(cubearray[0][2][0][0]) &&  cubearray[0][1][0][2].equals(cubearray[0][2][0][2])) {
                    s.append(" ").append(stringalg("F R' F' R"));
                } else if (cubearray[0][2][0][0].equals(cubearray[0][2][1][1]) && cubearray[0][2][0][2].equals(cubearray[0][2][1][0])) {
                    s.append(" ").append(stringalg("R U' R' U R U U R' U R' F R F'"));
                }else if (cubearray[0][2][0][0].equals(cubearray[0][2][1][0]) && cubearray[0][2][0][2].equals(cubearray[0][2][1][1])) {
                    s.append(" ").append(stringalg("R U' R' U U F' U' F"));
                } else {
                    s.append(" ").append(stringalg("U F'"));
                    if ( cubearray[2][0][0][1].equals(topcolor)) {
                        while ( !( cubearray[0][0][1][0].equals(topcolor) && cubearray[0][0][1][1].equals(cubearray[2][0][0][0])  ) && count < 4) { s.append(" ").append(U()); count++ ; }
                        s.append(" ").append(stringalg("F U' F R' F' R"));
                    }
                    else {
                        while ( !( cubearray[0][2][1][0].equals(topcolor) && cubearray[0][2][1][1].equals(cubearray[2][0][0][1])  ) && count < 4 ) { s.append(" ").append(U());  count++ ; }
                        s.append(" ").append(stringalg("F U' R U R'"));
                    }
                    count = 0 ;
                }

            }
            else {
                if (cubearray[0][2][1][0].equals(cubearray[0][2][0][0]) && cubearray[0][2][1][1].equals(cubearray[0][2][0][1]) ) {
                    s.append(" ").append(stringalg("R' F R F'"));
                } else if (cubearray[0][2][0][0].equals(cubearray[0][1][0][0]) && cubearray[0][2][0][1].equals(cubearray[0][1][0][2])) {
                    s.append(" ").append(stringalg("F' U F U' U' R U R' U'"));
                } else if (cubearray[0][2][0][0].equals(cubearray[0][1][0][2]) && cubearray[0][2][0][1].equals(cubearray[0][1][0][0])) {
                    s.append(" ").append(stringalg("U R U' R' U R U' R' F R' F' R"));
                } else {
                    s.append(" ").append(stringalg("U' R"));
                    if ( cubearray[2][2][2][2].equals(topcolor)) {
                        while ( !( cubearray[0][1][2][0].equals(topcolor) && cubearray[0][1][2][2].equals(cubearray[2][2][2][0])  ) && count < 4 ) { s.append(" ").append(U()); count++ ; }
                        s.append(" ").append(stringalg("R' U R' F R F'"));
                    }
                    else {
                        while ( !( cubearray[0][1][0][0].equals(topcolor) && cubearray[0][1][0][2].equals(cubearray[2][2][2][2])  ) && count < 4 ) { s.append(" ").append(U());  count++ ;}
                        s.append(" ").append(stringalg("R' U F' U' F"));
                    }
                }


            }

            return s.toString();
        }

        //actual methods to solve
        private String centers() {
            int total = 0 ;
            StringBuilder s = new StringBuilder("\n");
            int[] layer = {1, 0, 0, 1, 0, 2, 1, 2, 2, 1, 2, 0};
            String[] colors = {"G", "R", "B", "R" , "B", "O", "G" , "O"} ;
            for (int checker = 3 ; checker > 0 ; checker-- ) {
                int count =0 ;
                for (int i = 0; i < 10; i += 3) {
                    if (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][1].equals("W") && (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][2].equals(colors[count]))) {
                        s.append(" ").append(centerslotter(layer[i], layer[i + 1], layer[i + 2], 2, 3)).append("  ");
                        total++;
                    }
                    else if (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][2].equals("W") && (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][1].equals(colors[count+ 1]))) {
                        s.append(" ").append(centerslotter(layer[i], layer[i + 1], layer[i + 2], 1, 3)).append("  ");
                        total++;
                    }
                    count+=2;
                }
            }
            layer = edges[2] ;
            for (int i = 0; i < 10; i += 3) {
                if (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][0].equals("W") && ( ( layer[i+1] == 1 && cubearray[1][layer[i + 1]][layer[i + 2]][1].equals(cubearray[layer[i]][layer[i + 1]][layer[i + 2]][2])) && ( layer[i+1] == 2 && cubearray[1][layer[i + 1]][layer[i + 2]][1].equals(cubearray[layer[i]][layer[i + 1]][layer[i + 2]][1])) ) )  {
                    s.append(" ").append(centerslotter(layer[i], layer[i + 1], layer[i + 2], 0, 0)).append("  ");
                    total++;


                }
            }
            layer = edges[0] ;
            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < 10; i += 3) {
                    if (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][0].equals("W") || (layer[i + 1] == 1 && cubearray[layer[i]][layer[i + 1]][layer[i + 2]][2].equals("W")) || (layer[i + 1] != 1 && cubearray[layer[i]][layer[i + 1]][layer[i + 2]][1].equals("W"))) {

                        if ((layer[i + 1] == 1 && !cubearray[layer[i]][layer[i + 1]][layer[i + 2]][2].equals(cubearray[1][layer[i + 1]][layer[i + 2]][1].substring(0, 1))) || (layer[i + 1] != 1 && !cubearray[layer[i]][layer[i + 1]][layer[i + 2]][1].equals(cubearray[1][layer[i + 1]][layer[i + 2]][1].substring(0, 1)))) {
                            s.append(" ").append(centerslotter(layer[i], layer[i + 1], layer[i + 2], 0, 0)).append("  ");

                        }

                    }
                }
            }
            s.append("\n");

            layer = edges[1];
            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < 10; i += 3) {
                    if (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][1].equals("W")) {
                        s.append(" ").append(centerslotter(layer[i], layer[i + 1], layer[i + 2], 0, 1)).append("  ");
                        total++;


                    } else if (cubearray[layer[i]][layer[i + 1]][layer[i + 2]][2].equals("W")) {
                        s.append(" ").append(centerslotter(layer[i], layer[i + 1], layer[i + 2], 0, 2)).append("  ");
                        total++;


                    }
                }
            }
            s.append("\n");
            int count = 0 ;
            for (int k = 0; k < 4; k++) {
                if ( !cubearray[2][1][0][0].equals("W")) {
                    while (!((cubearray[0][1][0][0].equals("W") && cubearray[0][1][0][2].equals(cubearray[1][1][0][1].substring(0, 1))) || (cubearray[0][1][0][2].equals("W") && cubearray[0][1][0][0].equals(cubearray[1][1][0][1].substring(0, 1))) ) && count < 4 ) {
                        s.append(" ").append(Udash()); count++ ;

                    }
                    count =0 ;
                    if (cubearray[0][1][0][2].equals("W") && cubearray[0][1][0][0].equals(cubearray[1][1][0][1].substring(0, 1))) {
                        s.append(" (").append(U());
                        s.append("  ").append(r());
                        s.append("  ").append(Udash());
                        s.append("  ").append(rdash()).append(")").append(" ");

                    } else  {

                        while (!(cubearray[0][1][0][2].equals(cubearray[1][1][0][1].substring(0, 1))) && count < 4) {
                            s.append(" ").append(Udash()); count++ ;
                        }
                        s.append(" ").append(F());
                        s.append(" ").append(F()).append(" ");

                    }
                    total--;
                }
                s.append(y()).append("\n");

            }
            return s.toString();
        }

        private String f2l() {
            StringBuilder s = new StringBuilder("\n");
            for (int count = 0; count < 4; count++) {
                String color = cubearray[1][1][0][1].substring(0,1), colorside = cubearray[1][2][1][1].substring(0,1);
                for (int x = 0; x < 2; x++) {

                    if (! ( (cubearray[2][2][0][0].equals("W") && cubearray[2][2][0][2].equals(color)) && ( cubearray[1][2][0][1].equals(colorside) && cubearray[1][2][0][2].equals(color) ) ) ) {
                        for (int y = 0; y < 10; y += 3) {
                            int corn2 = 5, corn3 = 5 ;
                            boolean check = false;
                            if (cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][0].equals("W")) {
                                corn2 = 1;
                                corn3 = 2;
                                check = true ;
                            } else if (cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][1].equals("W")) {
                                corn2 = 0;
                                corn3 = 2;
                                check = true ;

                            } else if ( cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][2].equals("W") ) {
                                corn2 = 0;
                                corn3 = 1;
                                check = true ;

                            }
                            if ( check ) {
                                if (( cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][corn2].equals(color)  &&  cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][corn3].equals(colorside) ) || ( cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][corn3].equals(color)  && cubearray[corners[x][y]][corners[x][y + 1]][corners[x][y + 2]][corn2].equals(colorside) )) {
                                    if (!( cubearray[2][2][0][0].equals("W") && cubearray[1][2][0][2].equals(color) && cubearray[1][2][0][1].equals(colorside) )) {
                                        s.append(cornerslotter(corners[x][y], corners[x][y + 1], corners[x][y + 2], color, colorside)).append(" ");
                                    }

                                    x = 10 ;
                                    y = 15 ;
                                }

                            }

                        }
                    }
                }
                s.append(y()).append("\n");
            }
            return s.toString();
        }

        private String oll() {
            StringBuilder s = new StringBuilder();
            int count = 0 ;
            int[] temp = edges[2] ;
            for (int i = 0; i < 10; i += 3) {
                if (  cubearray[temp[i]][temp[i+1]][temp[i+2]][0].equals("Y") ) { count++ ; }

            }
            if ( count == 0 ) {
                s.append(" ").append(stringalg("F R U R' U' F'"));
                count = 2;
            }
            int ok =0 ;
             if ( count ==2 ) {
                if ((cubearray[0][0][1][0].equals("Y") && cubearray[0][2][1][0].equals("Y")) || (cubearray[0][1][0][0].equals("Y") && cubearray[0][1][2][0].equals("Y")) ) {
                    while (!(cubearray[0][0][1][0].equals("Y") && cubearray[0][2][1][0].equals("Y"))  && ok < 4) {
                        s.append(U()).append(" "); ok++;
                    }
                    s.append(" ").append(stringalg("F R U R' U'"));

                } else {
                    while (!(cubearray[0][0][1][0].equals("Y") && cubearray[0][1][2][0].equals("Y")) && ok < 4 ) {
                        s.append("").append(U()).append(" "); ok++ ;
                    }
                    s.append(" ").append(stringalg("F U R U' R'"));
                }
                 s.append(" ").append(Fdash());
             }
            else if ( count !=  4){
                 s.append("\n Either you have entered the cube wrongly, or an edge piece is flipped") ;
                 return s.toString();
            }

            s.append("\n");
            ok =0 ;
            temp = corners[1] ;
            int sidecount = 0 , frontcount =0 , topcount =0  ;
            for (int i = 0; i < 10; i += 3) {
                if (  cubearray[temp[i]][temp[i+1]][temp[i+2]][0].equals("Y") ) { topcount++ ; }
                else if (  cubearray[temp[i]][temp[i+1]][temp[i+2]][2].equals("Y")  ) { frontcount++ ; }
                else { sidecount++ ; }
            }
            if ( topcount == 4 ) { return s.toString(); }
            else if ( sidecount + frontcount == 3 ) {
                while (!cubearray[0][0][0][0].equals("Y") && ok < 4 ) {
                    s.append(" ").append(Udash()); ok++ ;
                }
                if (cubearray[0][0][2][2].equals("Y")) {
                    s.append(" ").append(stringalg("R U R' U R U2"));
                } else {
                    s.append(" ").append(stringalg("U' U' R U U R' U' R U'"));
                }
                s.append(" ").append(Rdash());
            }
            else if ( frontcount == 4  || sidecount == 4 ) {
                while ( !cubearray[0][2][0][2].equals("Y")  && ok < 4 ) {  s.append(" ").append(U()); ok++ ;  }
                s.append(" ").append(stringalg("R U U R' U' R U R' U' R U' R'"));
            }
            else if ( frontcount == 2 && sidecount == 2 ) {
                while ( !cubearray[0][0][0][1].equals("Y") && ok < 4 ) {  s.append(" ").append(U()); ok++;   }
                s.append(" ").append(stringalg("R U2 R2 U' R2 U' R2 U2 R"));
            }
            else if ( frontcount == 2 || sidecount ==2   ) {
                while (!cubearray[0][0][2][2].equals("Y")&& ok < 4 ) {
                    s.append(" ").append(Udash()); ok++;
                }
                if ( cubearray[0][2][2][2].equals("Y")) {
                    s.append(" ").append(stringalg("R2 D' R U2 R' D R U2 R"));
                }
                else {
                    s.append(" ").append(stringalg("r U R' U' r' F R F'"));
                }
            }
            else if ( sidecount ==1 && frontcount == sidecount ) {
                while (!cubearray[0][0][2][1].equals("Y") && ok < 4 ) {
                    s.append(" ").append(Udash()); ok++;
                }
                s.append(" ").append(stringalg("F' r U R' U' r' F R"));
            }
            count =0 ;
            for (int i = 0; i < 10; i += 3) {
                if (  cubearray[temp[i]][temp[i+1]][temp[i+2]][0].equals("Y") ) { count++ ; }
            }
            if ( count != 4 ) {
                s.append(" Either you have entered the cube wrongly, or a corner piece is flipped") ;
            }
            return s.toString();
        }

        private String pll() {
            StringBuilder s = new StringBuilder();
            int co = pllco() , ad = pllad() ;
            int ok = 0 ;
            if ( ad == 0 ) {
                if (co == 4) {
                    if ( cubearray[0][0][0][1].equals(cubearray[0][2][1][1])){
                        s.append(" ").append(stringalg("M2 U M2 U2 M2 U M2"));
                    }
                    else {
                        while ( !cubearray[0][0][0][2].equals(cubearray[0][2][1][1]) && ok < 4) { s.append(" ").append(U()); ok++ ;  }
                        s.append(" ").append(stringalg("M2 U2 M U' M2 U' M2 U' M"));
                    }
                } else {
                    s.append(" ").append(stringalg("R' U L' D2 L U' R L' U R' D2 R U' L"));
                    s.append(" ").append(pll());
                }
            }
            else if ( ad == 3 ) {
                s.append(fillfront());
                if ( co == 4 ) {
                    if ( cubearray[0][0][0][1].equals(cubearray[0][1][2][2])) {
                        s.append(" ").append(stringalg("M2 U M' U2 M U M2"));
                    }
                    else {
                        s.append(" ").append(stringalg("M2 U' M' U2 M U' M2"));
                    }
                }
                else {
                    s.append(" ").append(stringalg("L U' L' U L2 F U F' U' L' F' L F L2 U"));
                }
            }
            else if ( ad == 4 ) {
                if (co == 0) {
                    while ( !( cubearray[0][0][0][2].equals(cubearray[0][1][0][2])) && ok < 4) { s.append(" ").append(U()); ok++ ; }
                    if ( cubearray[0][0][0][1].equals(cubearray[0][0][1][1])) {
                        s.append(" ").append(stringalg("R' U R' U' B' R' B2 U' B' U B' R B R"));
                    }
                    else {
                        s.append(" ").append(stringalg("F R' F R2 U' R' U' R U R' F' R U R' U' F'"));
                    }
                } else {
                    s.append(cofront());
                    if ( cubearray[0][0][0][1].equals(cubearray[0][0][1][1])) {
                        s.append(" ").append(stringalg("U F R U' R' U R U R2 F' R U R U' R'"));
                    }
                    else if ( cubearray[0][0][1][1].equals(cubearray[0][0][2][1]) ){
                        s.append(" ").append(stringalg("R B' R F2 R' B R F2 R2"));
                    }
                    else {
                        s.append(" ").append(stringalg("U r U r' U' r' F r r U' r' U' r U r' F'"));
                    }
                }
            }
            else if ( ad == 2 ) {
                s.append(cofront());
                if ( cubearray[0][0][0][1].equals(cubearray[0][0][1][1])) {
                    s.append(" ").append(stringalg("R' U2 R U2 R' F R U R' U' R' F' R2"));
                }
                else if ( cubearray[0][0][1][1].equals(cubearray[0][0][2][1])) {
                    s.append(" ").append(stringalg("U2 F2 D' L U' L U L' D F2 R U' R'"));
                }
                else if ( cubearray[0][2][0][1].equals(cubearray[0][2][1][1])) {
                    s.append(" ").append(stringalg("U2 R U2 R' U2 R B' R' U' R U R B R2 U"));
                }
                else if ( cubearray[0][2][1][1].equals(cubearray[0][2][2][1])) {
                    s.append(" ").append(stringalg("R U2' R' U' F' R U R2 U' R' F R U R2 U2' R'"));
                }
                else if ( cubearray[0][0][2][2].equals(cubearray[0][1][2][2])) {
                    s.append(" ").append(stringalg("U R2 D L2 D F2 L D R' D2 L D' R' U2"));
                }
                else if ( cubearray[0][1][2][2].equals(cubearray[0][2][2][2])) {
                    s.append(" ").append(stringalg("U2 R' F' R F' U' L' U F R' F' L F2 R"));
                }
            }
            else if ( ad == 9 ) {
                s.append(" ").append(fillfront());
                if (cubearray[0][0][0][1].equals(cubearray[0][0][1][1])) {
                    s.append(" ").append(stringalg("U' R' U L U' R U2 L' U L U2 L'"));
                }
                else  {
                    s.append(" ").append(stringalg("U' R' L' U2 L U L' U2 R U' L U"));
                }
            }
            else if ( ad == 8 ) {
                if ( cubearray[0][1][0][2].equals(cubearray[0][2][0][2])) {
                    s.append("(R U' L U2 R' U L')2 --> ()2, means repeat twice");
                    stringalg("R U' L U2 R' U L' R U' L U2 R' U L'") ;

                }
                else {
                    s.append("(R' U L' U2 R U' L)2 U --> ()2, means repeat twice");
                    stringalg("R' U L' U2 R U' L R' U L' U2 R U' L U") ;
                }
            }
            else if ( ad != 12 ){ return "You have either entered the cube wrongly, or one of your pieces is still flipped" ; }
            int count =0 ;
            while ( count < 4 && !(cubearray[0][1][0][2].equals(cubearray[1][1][0][1].substring(0,1)) && cubearray[0][0][0][2].equals(cubearray[1][1][0][1].substring(0,1)) && cubearray[0][2][0][2].equals(cubearray[1][1][0][1].substring(0,1)) ))  { s.append(" ").append(U()); count++ ;}
            return s.toString();
        }

        //public method to solve and return solution
        public String solve() {
            String s = "\n" ;
            int count =0 ;
            while ( !cubearray[1][1][0][1].equals("Green") && count < 4) { s += y() + " "; count++ ; }
            s +=  centers()  ;
            s+=  f2l();
            s+=  oll() ;
            if ( !s.contains("Either") ) {
                s += pll();
                if ( !isSolved() ){ s += "The cube remains unsolved --> Recheck initilization or Report Bug " ; }
            }
            s = (shorten(s));

            return "Solution : " + s ;
        }

        public boolean isSolved() {
            return cubie.solved(end) ;
        }

        public String[][][][] getSolvedCube() { return end.getCube() ; }

        public ArrayList<String> compareToSolved() {
            String[][][][] endarray = end.getCube() ;
            ArrayList<String> change = new ArrayList<String>() ;
            for (int j = 0; j < cubearray.length; j++) {
                for (int i = 0; i < cubearray.length; i++) {
                    for (int k = 0; k < cubearray.length; k++) {
                        String a, x, c;
                        if (cubearray[i][j][k][0] != null || cubearray[i][j][k][2] != null) {
                            if (cubearray[i][j][k][0] == null) {
                                if ( !( cubearray[i][j][k][1].equals(endarray[i][j][k][1]) && cubearray[i][j][k][2].equals(endarray[i][j][k][2]) )) { change.add("( " +i + " " + j + " " + k + " : Side - " + endarray[i][j][k][1] + " , F/B - " + endarray[i][j][k][2] + " ) "  ) ; }
                            } else if (cubearray[i][j][k][1] == null) {
                                if ( !( cubearray[i][j][k][0].equals(endarray[i][j][k][0]) && cubearray[i][j][k][2].equals(endarray[i][j][k][2]) )) { change.add("( " +i + " " + j + " " + k + " : T/b - " + endarray[i][j][k][0] + " , F/B - " + endarray[i][j][k][2] + " ) " ) ; }
                            } else if (cubearray[i][j][k][2] == null) {
                                if ( !( cubearray[i][j][k][1].equals(endarray[i][j][k][1]) && cubearray[i][j][k][0].equals(endarray[i][j][k][0]) )) { change.add("( " + i + " " + j + " " + k + " : T/b - " + endarray[i][j][k][0] + " , Side - " + endarray[i][j][k][1] + " ) " )  ; }
                            } else {
                                if ( !( cubearray[i][j][k][1].equals(endarray[i][j][k][1]) && cubearray[i][j][k][2].equals(endarray[i][j][k][2]) || cubearray[i][j][k][0].equals(endarray[i][j][k][0]) )) { change.add("( " +i + " " + j + " " + k + " : T/b - " + endarray[i][j][k][0] + " . Side - " + endarray[i][j][k][1]  + " . F/B - " + endarray[i][j][k][2] + " ) " ) ; }
                            }
                        }
                    }
                }
            }
            return change ;
        }

    }



