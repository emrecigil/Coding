import sys
f = open("Students.txt","r",encoding="UTF-8")
dict1 = {}
for line in f:
    line = line.strip("\n")
    line = line.split(":")
    dict1[line[0]] = line[1]
a = sys.argv[2]
a =a.split(",")
for i in a:
    try:
        b = dict1.get(i)
        print("Name: ", i +",", "University: ", dict1[i],end=" ")
    except:
        print("No record of", "'"+i+"'", "was found!")
f.close()
