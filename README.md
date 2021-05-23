<h1 align="center">CUBOT</h1>

<p align="center">
  <img width="350" src="https://cdn.discordapp.com/attachments/812010624301269012/846008134396805120/cube.PNG" alt="cubot">
</p>

<br> 

# Description

### A Java library to help you : 
*Solve the Cube by getting the solution, 
*Execute Moves, 
*Obtain the Cube which you can use in your projects

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

1. First make a String[] containing the sides of the cube as explained below 
```java
String[] temp = {"RRRRRRRRR", "GGGGGGGGG", "OOOOOOOOO", "BBBBBBBBB", "WWWWWWWWW", "YYYYYYYYY"}; 
```
2. Now make a Cubot object with the String[] 
```java
Cubot cube = new Cubot(temp) ;
```
3. To solve, use this method which gives you the solution as a String ( you can use this if you want in your projects ). Or if you just want to solve your cube, just print it 
```java
String sol = cube.solve() ;
System.out.println(sol);
```
6. You can access most of the cube moves like R(), R'(), etc. 

```java
Cubot cube = new Cubot 
```

