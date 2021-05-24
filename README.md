<h1 align="center">CUBOT</h1>

<p align="center">
  <img width="250" src="https://cdn.discordapp.com/attachments/812010624301269012/846043080104607744/output-onlinepngtools.png" alt="cubot">
</p>


<hr> 


# Description

### A Java library to help you : 
* Virtually construct a Cube, 
* Execute Moves and Perform algorithms easily, 
* Manipulate the Cube using simple java, 
* Get the solution for the cube
* Use a cube in your own projects 

---

## Installation

1. Download the Cubot.jar file above 
2. Go to your project on Intellij or Eclipse 
3. Click on Files on the top left corner, and then click on Project Structure
<br> 
<p align="center">
  <img width="250" src="https://cdn.discordapp.com/attachments/812010624301269012/846011040529645588/unknown.png" alt="example">
</p>
4. Now click on the Libraries option, and then choose the "+" button as shown in the image 
<br> 
<br> 
 <p align="center">
  <img width="250" src="https://cdn.discordapp.com/attachments/812010624301269012/846011272054571038/unknown.png" alt="example">
</p>
5. You will get 3 options. Choose java and then select Cubot.jar from the download location 
<br> 
<br>
 <p align="center">
  <img width="250" src="https://cdn.discordapp.com/attachments/812010624301269012/846011334029344828/unknown.png" alt="example">
</p>

<hr> 

## Usage

#### For all methods, and a detailed explanation, go to [Documentation](https://github.com/AkshathRaghav/cubot/blob/main/documentation.md)
1. First make a String[] containing the sides of the cube as explained in the [Initialization](https://github.com/AkshathRaghav/cubot/blob/main/initialization.md) file

```java
String[] temp = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"}; // This represents a solved cube
```
<br> 

2. Now make a Cubot object with the String[] 

```java
Cubot cube = new Cubot(temp) ; // makes your cube with the given input 
```
<br> 

3. To solve, use solve() which gives you the solution as a String ( you can use this if you want in your projects ). Or if you just want to solve your cube, just print the solution returned. <br> 

**Note : In case the String[] used while making the object is wrong or faulty you will have to re-enter the Strings. If they are all of same length, then Cubot will let you know if an edge is flipped or a corner is flipped. In either of the two cases, Cubot will stop solving, give you the output till there, and then let you know that something is wrong.** 


```java
String sol = cube.solve() ; // gets you the solution 
System.out.println(sol); // prints it out on the terminal 
```
<br> 

4. With isSolved(), you can get the status of your cube ( solved or not ) --> For example, if you want to execute a move and check if the cube is solved or not, use this method. 

```java
boolean solved = cube.isSolved() ; // returns true if solved, false if not
```
<br> 

5. You can access most of the cube moves like R(), R'(), etc. For more moves, see [All Moves](https://github.com/AkshathRaghav/cubot/blob/main/initialization.md) 

```java
cube.R() ; 
cube.Rdash() ; 
cube.L() ; 
```
<br> 

6. Do you have an algorithm you want to try out? Use stringalg(String given) to use all the moves in (given) on your cube. 

```java
cube.stringalg("R U R' U'") ; // executes the algorithm and returns String ( if you want ) 
```
<br> 

7. You can print the entire cube on your terminal. ( Refer to [indexes](https://eli.thegreenplace.net/images/2015/row-major-3D.png) ) 

```java
System.out.println(cube) ; // prints out the cube --> piece location, colors and centers 
```
<br> 

8. Using getCube(), you can access each piece of the cube however you want to. If you change something, this will lead to a change in the original cube so be careful.

```java
String[][][][] cubearray = cube.getCube() ; // Any change will reflect on the cube
```
<hr> 
 

## Note :  Cubot makes use of a Cube object to work. If you wish to just have a Cube object, you can. 
### Below is the Cube class 

```java 
  private String[][][][] cube ; 
  public Cube(String  [] temp) ; // Makes the Cube with String[]    
  public boolean solved(Cube other) ; // tells you if its solved, with respect to another cube ( play around with it ;) )
  public String toString() ; // returns a String representing the cube
  public String[][][][] getCube() ; // returns the 4-D cube array
```
<hr> 


## Sites used 
* [Eli Bedernsky's Website](https://eli.thegreenplace.net/2015/memory-layout-of-multi-dimensional-arrays)
