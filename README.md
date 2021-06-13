<h1 align="center">CUBOT</h1>

<p align="center">
  <img width="250" src="https://cdn.discordapp.com/attachments/812010624301269012/846043080104607744/output-onlinepngtools.png" alt="cubot">
</p>


<hr> 

# Table of Contents  
* [Description](#Description)  
* [Updates](#Updates)
* [Installation](#Installation) 
* [Usage](#Usage)

<hr> 


# Description

### A Java library to help you : 
* Virtually construct a Cube, 
* Quickly execute moves and perform algorithms seamlessly, 
* Manipulate the Cube using simple java, 
* Get the solution for the cube
* Use a cube in your own projects 

---

# Updates

1. getScramble(int n) added; reverseAlg(String s) added; minor tweaks in Checker - 30.5.2021
2. E(), S() added, updated Moves in moves - 31.5.2021 
3. Edash(), Sdash(), x(), y(), y'() + Optimized the big slice moves; solve(), stringalg(), reversealg() updated - 1.6.2021
4. toString() improved to make it much easier to understand the cube-state ( check out the new output in Documentation ) - 2.6.2021 
5. Cube constructor updated ( Enter cube faces randomly now ) - 3.6.2021
6. toString() bug fixed, pll() bug fixed- 11.6.2021

<hr>

# Installation

1. Download the Cubot.jar file above ( Version 1.0; v2.0 coming at the end of the month ) 
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
5. You will get 3 options. Choose Java and then select Cubot.jar from the download location 
<br> 
<br>
 <p align="center">
  <img width="250" src="https://cdn.discordapp.com/attachments/812010624301269012/846011334029344828/unknown.png" alt="example">
</p>

<hr> 

# Usage

1. First make a String[] containing the sides of the cube as explained in the [Initialization](https://github.com/AkshathRaghav/cubot/blob/main/initialization.md). 

```java
String[] temp3 = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"}; // 3x3
String[] temp2 = {"RRRR", "GGGG", "OOOO", "BBBB", "WWWW", "YYYY"}; // 2x2
```
<br> 

2. Now make a Cubot object with the String[] 

```java
Cubot3 cube = new Cubot3(temp3) ; // 3x3 
// OR 
Cubot2 cube = new Cubot2(temp2) ; // 2x2
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

5. You can access most of the cube moves like R(), R'(), etc. For more moves, see [All Moves](https://github.com/AkshathRaghav/cubot/blob/main/moves.md) 

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

7. You can print the entire cube on your terminal ( indexedString() does it differently ) <br> Refer to [Documentation](https://github.com/AkshathRaghav/cubot/blob/main/documentation.md) 

```java
System.out.println(cube) ; // prints out the cube --> piece location, colors and centers 
```
<br> 

8. Using getCube(), you can access each piece of the cube however you want to. If you change something here, the original cube will change as well.

```java
String[][][][] cubearray = cube.getCube() ; // Any change will reflect on the cube
```


#### For the other methods, and a detailed explanation, go to 
* [Documentation for Cubot3](https://github.com/AkshathRaghav/cubot.io/blob/main/documentation3x3.md)
* [Documentation for Cubot2](https://github.com/AkshathRaghav/cubot.io/blob/main/documentation2x2.md)
<hr> 
 

## Note :  Cubot(2/3) objects makes use of a Cube(2/3) object to work. If you wish to just have a Cube object ( of Cube type ) , you can. <br> As of now, the source files for both are seperate. 
### Below is the Cube class 

```java 
  private String[][][][] cube ; 
  public Cube(2/3)(String  [] temp) ; // Makes the Cube with String[]    
  public boolean solved(Cube(2/3) other) ; // tells you if its solved, with respect to another cube ( play around with it ;) )
  public String toString() ; // returns a String representing the cube
  public String[][][][] getCube() ; // returns the 4-D cube array
```
In case of any confusion between Cubot and Cube classes, read more in the Documentation files.  
<hr> 




## Sites used 
* [Eli Bedernsky's Website](https://eli.thegreenplace.net/2015/memory-layout-of-multi-dimensional-arrays)
