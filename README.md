

<p align="center">
  <img width="1100" src="https://cdn.discordapp.com/attachments/797420478574362634/855449686982787082/cubot.io.png" alt="cubot">
</p>


<hr> 

# 🔠 Table of Contents  
* [Description](#Description)  
* [Updates](#Updates)
* [Installation](#Installation) 
* [Usage](#Usage)

<hr> 


# 📔 Description

### A Java library to help you : 
* Virtually construct a Cube ( 2x2/3x3 ), 
* Quickly execute moves and perform algorithms seamlessly, 
* Manipulate the Cube using simple java, 
* Get the solution for the cube
* Use a cube in your own projects 

---

# 🎉 Updates

1. getScramble(int n) added; reverseAlg(String s) added; minor tweaks in Checker - 30.5.2021
2. E(), S() added, updated Moves in moves - 31.5.2021 
3. Edash(), Sdash(), x(), y(), y'() + Optimized the big slice moves; solve(), stringalg(), reversealg() updated - 1.6.2021
4. toString() improved to make it much easier to understand the cube-state ( check out the new output in Documentation ) - 2.6.2021 
5. Cube constructor updated ( Enter cube faces randomly now ) - 3.6.2021
6. toString() bug fixed, pll() bug fixed- 11.6.2021
7. 2x2 files added, 3x3 files made sep - 14.6.2021
8. Merged src added, use single Cubot for both Cubes, Documentation and README updated - 15.6.2021

<hr>

# ⚙️ Installation

1. Download the Cubot.jar (v1.0) file above ( <-- Old version. v2.0 coming at the end of the month ) 
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

# 🗎 Usage

1. First make a String[] containing the sides of the cube as explained in the [Initialization](https://github.com/AkshathRaghav/cubot/blob/main/initialization.md). 

```java
String[] temp3 = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"}; // 3x3
String[] temp2 = {"RRRR", "GGGG", "OOOO", "BBBB", "WWWW", "YYYY"}; // 2x2
```
<br> 

2. Now make a Cubot object with the String[] 

```java
Cubot cube = new Cubot(temp3) ; // 3x3 
// OR 
Cubot cube = new Cubot(temp2) ; // 2x2
// OR
Cubot cube = new Cubot([]) ; // Solved State 3x3
```
<br> 

3. toString()/System.out.println(cube) --> Prints out the cube in an easy to understand manner ( along with [indexes](https://eli.thegreenplace.net/images/2015/row-major-3D.png) ) 

```java
System.out.println(cube1) ; 
```

<p float="left" align = "center">
  <img src="https://user-images.githubusercontent.com/75845563/120409500-a9f29b80-c36e-11eb-9f03-8e99a294bb62.png" width="300" />
  <img src="https://user-images.githubusercontent.com/75845563/121994723-6dd62680-cdc3-11eb-95d6-ea590a8751c5.png" width="300" /> 
</p>
<!-- <p align="center">
  <img width="350" src="https://user-images.githubusercontent.com/75845563/120409500-a9f29b80-c36e-11eb-9f03-8e99a294bb62.png" alt="example">
</p>
<p align="center">
  <img width="350" src="https://user-images.githubusercontent.com/75845563/121994723-6dd62680-cdc3-11eb-95d6-ea590a8751c5.png" alt="example">
-->

4. indexedString() --> Prints out the cube with indexes and colors on each face of the cube pieces 
 
```java
System.out.println(cube1.indexedString()) ; 
```

<p align="center">
  <img width="350" src="https://user-images.githubusercontent.com/75845563/119397820-4e803800-bcf4-11eb-9eb1-c156694a7613.png" alt="example">
</p>
<p align="center">
  <img width="350" src="https://user-images.githubusercontent.com/75845563/121994801-8a725e80-cdc3-11eb-9e9f-884e7f3994ba.png" alt="example">
</p>

5. To solve, use solve() which gives you the solution as a String ( you can use this if you want in your projects ). Or if you just want to solve your cube, print the solution returned. <br> 

**Note : In case the String[] used while making the object is wrong or faulty you will have to re-enter the Strings. If they are all of same length, then Cubot will let you know if an edge is flipped or a corner is flipped. In either of the two cases, Cubot will stop solving, give you the output till there, and then let you know that something is wrong.** 


```java
String sol = cube.solve() ; // gets you the solution 
System.out.println(sol); // prints it out on the terminal 
```
<br> 

6. With isSolved(), you can get the status of your cube ( solved or not ) --> For example, if you want to execute a move and check if the cube is solved or not, use this method. 

```java
boolean solved = cube.isSolved() ; // returns true if solved, false if not
```
<br> 

7. Use makeSolved() to change your cube to the solved state

```java
cube.makeSolved() ; // brings it to Solved state 
```
<br> 

8. Do you have an algorithm/move you want to try out? Use stringalg(String given) to use all the moves in (given) on your cube. 

```java
cube.stringalg("R U R' U'") ; // executes the algorithm and returns String ( if you want ) 
```
<br> 


9. Using getCube(), you can access each piece of the cube however you want to. If you change something here, the original cube will change as well.

```java
String[][][][] cubearray = cube.getCube() ; // Any change will reflect on the cube
```

#### For the other methods, and a detailed explanation of all three Cubots, go to [Documentation](https://github.com/AkshathRaghav/cubot.io/blob/main/documentation.md)

<hr> 



## Sites used 
* [Eli Bedernsky's Website](https://eli.thegreenplace.net/2015/memory-layout-of-multi-dimensional-arrays)
