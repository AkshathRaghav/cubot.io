
<h1 align="center">CUBOT</h1>

<p align="center">
  <img width="250" src="https://cdn.discordapp.com/attachments/812010624301269012/846043080104607744/output-onlinepngtools.png" alt="cubot">
</p>


<hr> 

# Table of Contents  
* [Cubot](#Cubot3)
* [Whats Cubot3 and Cubot2?](#Cubot3/Cubot2) 
* [Whats Cube3 and Cube2](#Cube3/Cube2)
* [Heirarchy of the Classes](#Hierarchy)
* [Accessing the Cubearray](#Indexing)

<hr> 

# Cubot3

*For Initialization guide, click [here](https://github.com/AkshathRaghav/cubot/blob/main/initialization.md)*

#### Example Object 
```java
String[] temp3 = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"}; // 3x3
Cubot cube = new Cubot(temp3) ; // 3x3  
// OR
String[] temp2 = {"RRRR", "GGGG", "OOOO", "BBBB", "WWWW", "YYYY"}; // 2x2
Cubot cube = new Cubot(temp2) ; // 2x2
// OR 
Cubot cube = new Cubot([]) ; // Makes a default solved 3x3 
```
<br> 

* isSolved() --> Tells you if your cube is solved or not 
```java
System.out.println("Cube state == Solved ? --> " + cube1.isSolved());
```
 <p align="center">
  <img width="250" src="https://user-images.githubusercontent.com/75845563/119397066-4bd11300-bcf3-11eb-8a7b-feee3a81b287.png" alt="example">
</p>

* solve() --> Solves the cube and returns the solution. ( 2x2 not supported yet ) 
Returns a warning along with the solution as well on how to fix the issue if the cube 
1. has been incorrectly entered, 
2. has an edge flipped,
3. has a corner flipped 

```java
System.out.println("Cube state == Solved ? --> " + cube1.isSolved());
System.out.println("------------------------------------------");
String solution = cube1.solve() ;
System.out.println(solution);
System.out.println("------------------------------------------");
```
 <p align="center">
  <img width="250" src="https://user-images.githubusercontent.com/75845563/119396729-e0874100-bcf2-11eb-8ac0-e6a943983f11.png" alt="example">
</p>

* toString()/System.out.println(cube) --> Prints out the cube in an easy to understand manner ( along with [indexes](https://eli.thegreenplace.net/images/2015/row-major-3D.png) ) 

```java
System.out.println(cube1) ; 
```
<p align="center">
  <img width="350" src="https://user-images.githubusercontent.com/75845563/120409500-a9f29b80-c36e-11eb-9f03-8e99a294bb62.png" alt="example">
</p>
<p align="center">
  <img width="350" src="https://user-images.githubusercontent.com/75845563/121994723-6dd62680-cdc3-11eb-95d6-ea590a8751c5.png" alt="example">
</p>
* indexedString() --> Prints out the cube with indexes and colors on each face of the cube pieces 
 
```java
System.out.println(cube1.indexedString()) ; 
```

<p align="center">
  <img width="350" src="https://user-images.githubusercontent.com/75845563/119397820-4e803800-bcf4-11eb-9eb1-c156694a7613.png" alt="example">
</p>
<p align="center">
  <img width="350" src="https://user-images.githubusercontent.com/75845563/121994801-8a725e80-cdc3-11eb-9e9f-884e7f3994ba.png" alt="example">
</p>
* stringalg(String s) --> Executes the moves given as a String on the cubot 

```java

System.out.println("Cube state == Solved ? --> " + cube1.isSolved());
System.out.println("------------------------------------------");
System.out.println("Moves Carried Out by stringalg() : " + cube1.stringalg("R U R' U'") );
System.out.println("------------------------------------------");
System.out.println("Cube state == Solved ? --> " + cube1.isSolved());
```

<p align="center">
  <img width="250" src="https://user-images.githubusercontent.com/75845563/119398424-26dd9f80-bcf5-11eb-9f67-003c5815635b.png" alt="example">
</p
  
* reverseAlg(String s, boolean check) --> reverses all the moves done ( s represents the moves executed ) if check is true, returns reversed String otherwise

```java
String s = "R U R' U'" ; 
System.out.println(cube.reversealg(s), false) ; // just reverses it 
System.out.println(cube.isSolved()); // --> true ( as nothing was done to the cube ) 
```

* getCube() --> Returns a String[][][][] object containing all the cube pieces. Be Careful! Any changes to the array will reflect on the cube. 

```java
String[][][][] cubearray = cube1.getCube() ; 
```

* getSolvedCube() --> Returns a String[][][][] object containing all the cube pieces OF THE SOLVED CUBE. 

```java
String[][][][] cubearray = cube1.getSolvedCube() ; 
```


* compareToSolved --> Returns an ArrayList containing the positions and colors on the pieces which are not solved ( i.e not in the solved positions ). Generally, this is used to check the exact positions which aren't solved during any solve or move. 

```java
ArrayList<String> positionsNotDone = cube1.compareToSolved() ; 
```

* getScramble(int n, boolean check if tru) --> gives you a scramble of input n ( and executes it on the cube if check is true, just gives a scramble if check is false ) 

```java
String s = cube.getScramble(5, true); // makes scramble and changes cube
System.out.println(s);
System.out.println(cube.reversealg(s), true) ; // undoes s
System.out.println(cube.isSolved()); // --> true 
```
* cubeState() --> returns if its holding 3x3 or 2x2 
```java 
System.out.println(cube.cubeState()) ; 
// --> "3x3" if 3x3, "2x2" if 2x2
```
<hr> 

# Cubot3/Cubot2
* Cubot has-a Cubot2 and Cubot3. Depending on your input, Cubot will hold Cubot3 or Cubot3 at a point
* Cubot3 is the Cubot object for only 3x3, and the same goes for Cubot2x2
* The main difference between them is that Cubot3/Cubot2 can directly use R(), Rdash(), etc. while Cubot needs stringalg()
```java 
String[] temp = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"}; // for 3x3 
Cubot3 cube3 = new Cubot(temp) ; 
cube3.R() ; 
```

<hr> 

# Cube3/Cube2
* The Cubot(2/3) and Cube(2/3) classes have a composition relationship - Cubot(2/3) has-a Cube(2/3) <br> 
* With an object of Cube3 class, you can only make, compare with another Cube3, and get the cubearray (String[][][][]) <br> 
* With an object of Cubot3 class, you can do much more + what Cube3 can do 

### Below is the Cube class 

```java 
  private String[][][][] cube ; 
  public Cube(2/3)(String  [] temp) ; // Makes the Cube with String[]    
  public boolean solved(Cube(2/3) other) ; // tells you if its solved, with respect to another cube ( play around with it ;) )
  public String toString() ; // returns a String representing the cube
  public String[][][][] getCube() ; // returns the 4-D cube array
```


* solved(Cube other) --> Returns true if Cube object matches another Cube object 

```java
String[] temp = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"}; // for 3x3 
Cube3 cube1 = new Cube3(temp) ;
String[] temp2 = {"WGBOROGGY", "YOYWGBOYB", "RBBOORRBY", "OBGWBYRYR", "GRWRGYWGB", "OWWWYROGG"}; // for 3x3 
Cube3 cube2 = new Cube3(temp2) ; 
System.out.println(cube1.solved(cube2)) ; --> Returns false
```

* toString/System.out.println --> Prints out the cube wtih indexes 
* indexedString() --> Prints out the indexed Cube
* getCube() --> Returns String[][][][] object containing the cubearray 


<hr> 

# Hierarchy 
* Cubot has-a Cubot3 and Cubot2
* Cubot(2/3) has-a Cube(2/3)
* Cubot(2/3) extends Checker(2/3) extends Moves(2/3)
* Cube(2/3) has-a cubearray (String[][][][]) 

<hr>

# Indexing 
* cubearray[0][0][0][0] --> Color on top 
* cubearray[0][0][0][1] --> Color on side 
* cubearray[0][0][0][2] --> Color in front
#### ( Additional 3x3 indexes ) 
* Only for Centers --> cubearray[0][0][0][1].substring(0,1) --> Gives you the color of the center piece
* cubearray[1][1][1] --> Joint Piece

