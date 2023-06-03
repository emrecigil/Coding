a = []
for i in range(1, 11):
   a.append(int(input("Please enter the {}th number: ".format(i))))
b = len(a)


def minimum(x, y):
   if y == 1:
      return x[0]
   else:
      return min(x[y-1], minimum(x, y-1))


print("Minimum number is", minimum(a,b))


def maximum(x, y):
   if y == 1:
      return x[0]
   else:
      return max(x[y-1], maximum(x,y-1))


print("Maximum number is",maximum(a,b))


def avarage(x, y):
   if y == 1:
      return x[0]
   else:
      return (x[y-1] + avarage(x,y-1))/y


print("Avarage is", avarage(a,b))