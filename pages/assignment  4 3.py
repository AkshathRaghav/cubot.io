days = int(input("enter number of days: "))
L = []
a = []
remain = []
for x in range(0,days):
    temp= float(input("enter temp : "))
    L += [temp]



for i in L : 
    if i < 0  :
        a += [i] 
        # L.remove(i)
        
for i in L : 
    if i not in a : 
        a += [i]
print(a)







# /
# /
# /
# /
# /
# /
# /
# /
# /
# /

# I/O :
# [-2.1, -3.4, -2.3, 5.5, 0, 1.9, 1.6]