
<h1 align="center">CUBOT</h1>

<p align="center">
  <img width="250" src="https://cdn.discordapp.com/attachments/812010624301269012/846043080104607744/output-onlinepngtools.png" alt="cubot">
</p>


<hr> 

# Table of Contents  
* [Cubot2](#Cubot2)
* [Cube2](#Cube2) 
* [The Difference Between Cube and Cubot](#Difference) 
* [Accessing the Cubearray](#Indexing)

<hr> 

# Cubot3

*For Initialization guide, click [here](https://github.com/AkshathRaghav/cubot/blob/main/initialization.md)*

#### Example Object 
```java
String[] temp2 = {"RRRR", "GWGW", "OOOO", "YBYB", "WBWB", "YGYG"}; // 2x2
Cubot2 cube1 = new Cubot2(temp2) ; // 2x2 Cubot Object
```
<br> 

* isSolved() --> Tells you if your cube is solved or not 

```java
System.out.println("Cube state == Solved ? --> " + cube1.isSolved());
```
 <p align="center">
  <img width="250" src="https://user-images.githubusercontent.com/75845563/121793743-ea300480-cc1f-11eb-95ca-c509eb6b2f49.png" alt="example">
</p>

* toString()/System.out.println(cube) --> Prints out the cube in an easy to understand manner ( along with [indexes](https://eli.thegreenplace.net/images/2015/row-major-3D.png) ) 

```java
System.out.println(cube1) ; 
```



<p align="center">
  <img width="350" src="https://user-images.githubusercontent.com/75845563/121793748-f7e58a00-cc1f-11eb-9b41-fdba8f4ba198.png" alt="example">
</p>

* indexedString() --> Prints out the cube with indexes and colors on each face of the cube pieces 
 
```java
System.out.println(cube1.indexedString()) ; 
```

<p align="center">
  <img width="350" src="https://user-images.githubusercontent.com/75845563/121793757-0469e280-cc20-11eb-8e46-eba06e8ab82e.png" alt="example">
</p>

* R(),Rdash(), etc. --> Executes move on your cubot with R(), Rdash(), and other moves. Find the supported moves [here](https://github.com/AkshathRaghav/cubot/blob/main/moves.md)

```java
System.out.println("Cube state == Solved ? --> " + cube1.isSolved());
System.out.println("------------------------------------------");
System.out.println("Moves can also be carried out induvidually. Example move : " + cube1.R());
System.out.println("------------------------------------------");
System.out.println("Cube state == Solved ? --> " + cube1.isSolved());
```


<p align="center">
  <img width="300" src="https://user-images.githubusercontent.com/75845563/121793809-498e1480-cc20-11eb-8e2c-9b49ed3a06b8.png" alt="example">
</p

* stringalg(String s) --> Executes the moves given as a String on the cubot 

```java
System.out.println("Cube state == Solved ? --> " + cube1.isSolved());
System.out.println("------------------------------------------");
System.out.println("Moves Carried Out by stringalg() : " + cube1.stringalg("R U R' U'") );
System.out.println("------------------------------------------");
System.out.println("Cube state == Solved ? --> " + cube1.isSolved());
```
 <p align="center">
  <img width="250" src="https://user-images.githubusercontent.com/75845563/121793794-35e2ae00-cc20-11eb-92a6-930d25b96308.png" alt="example">
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

* shorten(String s) --> Returns the shortened version of the input algorithm ( Rdash -> R' ) 

```java 
String s = shorten("U U U F' F R' U' U") // Returns "U' R'" 
```


<hr> 


# Cube2

### Below is the Cube class 

```java 
  private String[][][][] cube2 ; 
  public Cube2(String  [] temp) ; // Makes the Cube with String[]    
  public boolean solved(Cube2 other) ; // tells you if its solved, with respect to another cube ( play around with it ;) )
  public String toString() ; // returns a String representing the cube
  public String[][][][] getCube() ; // returns the 4-D cube array
```

<br> 

* solved(Cube other) --> Returns true if Cube object matches another Cube object 

```java
String[] temp =  {"RRRR", "GGGG", "OOOO", "BBBB", "WWWW", "YYYY"};
Cube2 cube1 = new Cube2(temp) ;
String[] temp2 = {"RRRR", "GWGW", "OOOO", "YBYB", "WBWB", "YGYG"};
Cube2 cube2 = new Cube2(temp2) ; 
System.out.println(cube1.solved(cube2)) ; --> Returns false
```
<br> 

* toString/System.out.println --> Prints out the cube wtih indexes 

* getCube() --> Returns String[][][][] object containing the cubearray 


<hr> 


# Difference Between the two classes 
#### The Cubot2 and Cube2 classes have a composition relationship - Cubot2 has-a Cube2 <br> 
#### With an object of Cube2 class, you can only make, compare with another Cube2, and get the cubearray (String[][][][]) <br> 
#### With an object of Cubot2 class, you can do much more + what Cube2 can do 

<hr> 

# Indexing 
#### cubearray[0][0][0][0] --> Color on top 
#### cubearray[0][0][0][1] --> Color on side 
#### cubearray[0][0][0][2] --> Color in front


