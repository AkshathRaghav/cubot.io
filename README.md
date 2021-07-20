
<p align="center">
  <img width="1100" src="https://cdn.discordapp.com/attachments/797420478574362634/855449686982787082/cubot.io.png" alt="cubot">
</p>


# 📑 Table of contents
1. [Overview](#Overview)
2. [What is Cubot?](#What-is-Cubot?)
3. [Why would you want it?](#Why-would-you-want-it?)
4. [Documentation](https://github.com/AkshathRaghav/cubot.io/wiki)
5. [Installation](#Installation)
4. [Updates](#Updates)


# 📔 Overview

### A Java library to help you : 
* Virtually construct a Cube ( 2x2/3x3 ), 
* Quickly execute moves and perform algorithms seamlessly, 
* Manipulate the Cube using simple java, 
* Get the solution for the cube
* Use a cube in your own projects 
--- 

<a><img src="https://cdn.discordapp.com/attachments/812010624301269012/846043080104607744/output-onlinepngtools.png" align="left" height = "40" vspace="5"></a>
# What is Cubot? 
There are many Rubik's Cube-related graphic projects and solvers which implement various algorithms for solving the cube. <br> 
**But** programmers might not want something just for visualizing the cube, they might want a data-structure kind of solution for them to use in their own projects without having to make their own classes. Perhaps they want to only execute moves and compare cubes with the help of a library. Boom, *Cubot enters the chat*


# 🤔 Why would you want it?
#### With Cubot, you can 
* **Virtually** construct a Cube ( 2x2/3x3 ), 
* _Quickly_ execute moves and perform algorithms seamlessly, 
* Manipulate the Cube using simple java, 
* Get the solution for the cube
* Use a cube in your own projects 
* and so much more, with the help of the methods it provides 

Now speed is relative, as we all know. But Cubot can scramble the Cube, print, solve the Cube, print, bring the cube back into the scrambled state and print again, in less than a second on average.

```java
long startTime = System.nanoTime();

Cubot cube = new Cubot();
// "U2 F2 D2 U R' D2 B2 U L2 B' D' U2 F L F U' B' R' F' U F' U B L' D2 B R' B F2 R'" --> Offical WCA Scramble

cube.stringAlg("U2 F2 D2 U R' D2 B2 U L2 B' D' U2 F L F U' B' R' F' U F' U B L' D2 B R' B F2 R'") ;
// scrambles


Cubot cube2 = new Cubot(cube.cubeToArr()) ;
System.out.println(cube);
// prints output

String s  = cube.solve() ;
// solves

System.out.println(cube);
// prints ouput

System.out.println();

cube.reverseAlg(s, true) ;
// rescrambles with the solve again

System.out.println(cube);
// prints output

System.out.println("Re-scrambled ? = " + ((Cube3) cube.getCube()).solved((Cube3) cube2.getCube())) ;
// checks if the rescrambled cube is the same as the first scramble

long endTime = System.nanoTime();
long time = (endTime - startTime) ;
System.out.println("-----------------------------");
System.out.println("Execution time in milliseconds: " + time / 1000000);

```

![Example](https://cdn.discordapp.com/attachments/850164310612377640/860192610832613387/unknown.png)
![Example](https://cdn.discordapp.com/attachments/850164310612377640/860192636558901248/unknown.png)

### Head over to the [Docs](https://github.com/AkshathRaghav/cubot.io/wiki) for more on Cubot and how to use it

<hr> 

# ⚙️ Installation

1. Download the Cubot.jar (v2.0)
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

# 🎉 Updates

1. getScramble(int n) added; reverseAlg(String s) added; minor tweaks in Checker - 30.5.2021
2. E(), S() added, updated Moves in moves - 31.5.2021 
3. Edash(), Sdash(), x(), y(), y'() + Optimized the big slice moves; solve(), stringalg(), reversealg() updated - 1.6.2021
4. toString() improved to make it much easier to understand the cube-state ( check out the new output in Documentation ) - 2.6.2021 
5. Cube constructor updated ( Enter cube faces randomly now ) - 3.6.2021
6. toString() bug fixed, pll() bug fixed- 11.6.2021
7. 2x2 files added, 3x3 files made sep - 14.6.2021
8. Merged src added, use single Cubot for both Cubes, Documentation and README updated - 15.6.2021
9. cubeToString added for 2x2 - 22.6.2021
10. cubeToString added to Cubot for both 2x2 and 3x3 - 25.6.2021
11. wiki added for the repo, files updated, cubeToArr, toString, etc fixed - 28.6.2021
12. documentation for 2x2 files done - 1.7.2021
13. 2x2 solver added and documented - 2.7.2021
14. 3x3 classes documented - 7.7.2021
15. v2.0 published - 11.7.2021


## Sites used 
* [Eli Bedernsky's Website](https://eli.thegreenplace.net/2015/memory-layout-of-multi-dimensional-arrays)
