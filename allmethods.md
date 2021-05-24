
<h1 align="center">CUBOT</h1>

<p align="center">
  <img width="250" src="https://cdn.discordapp.com/attachments/812010624301269012/846043080104607744/output-onlinepngtools.png" alt="cubot">
</p>


<hr> 

## All Methods 


```java
String[] temp = {"WGBOROGGY", "YOYWGBOYB", "RBBOORRBY", "OBGWBYRYR", "GRWRGYWGB", "OWWWYROGG"};
Cubot cube1 = new Cubot(temp) ; 
```
1. isSolved() - Tells you if your cube is solved or not 

```java
System.out.println("Cube state == Solved ? --> " + cube1.isSolved());
```
 <p align="center">
  <img width="250" src="https://user-images.githubusercontent.com/75845563/119397066-4bd11300-bcf3-11eb-8a7b-feee3a81b287.png" alt="example">
</p>

2. solve() 

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

