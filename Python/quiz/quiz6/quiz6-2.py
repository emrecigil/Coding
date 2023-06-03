import sys
def diamond_comp(y):
    x = [(abs(y + int(i/2) - i)*" ")+i*"*" for i in range(1, 2*y, 2)]
    print(*x, sep="\n") 
    print(*x[-2::-1],sep="\n")
    
diamond_comp(int(sys.argv[1]))
