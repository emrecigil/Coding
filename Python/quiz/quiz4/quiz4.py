import sys
a,b = sys.argv[1],sys.argv[2]
f_input,f_output,y,check_list =open(a, "r", encoding="UTF-8"),open(b, "w", encoding="UTF-8"),1,[]
for k in f_input:
        k = k.strip("\n").split("\t")
        k[0],k[1] = int(k[0]),int(k[1])
        check_list.append(k)
check_list.sort()
for i in check_list:
        if i[1] == 0:
            print("Message", y, file=f_output)
            y += 1
        else:
            print(*i,file=f_output)
