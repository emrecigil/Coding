import sys
file_name = sys.argv[1]
categories = {}
def create():
    if category_name not in categories:
        categories[category_name] = seats
        print("The category " + str(input_list[1]) + ' having {} seats has been created.'.format(c), file=file_output)
        print("The category " + str(input_list[1]) + ' having {} seats has been created.'.format(c))
        showcategory_list.append(input_list[1::])  #bu liste show fonksiyonu için oluşruldu
    else:
        print("Cannot create the category for the second time. The stadium has already "+ str(input_list[1]) + ".", file=file_output)
        print("Cannot create the category for the second time. The stadium has already " + str(input_list[1]) + ".")

def sell():
    if input_list[3] in categories:
        for t in input_list[4::]:
            aralık_list = []
            if "-" in t:
                c = input_list.index(t)
                a = str(t[0])
                t = t[1::]
                b = int(t.index("-"))
                kucuk = int(t[0:b])
                buyuk = int(t[b+1::])
                for k in range(kucuk, buyuk+1):
                    aralık_list.append(a + str(k))
                x = 0
                o = 0
                for i in aralık_list:
                    if i in categories[input_list[3]]:
                        o += 1
                        if o == len(aralık_list):
                            for k in aralık_list:
                                y = 0
                                if categories[input_list[3]][k] != "":
                                    y += 1
                                    if y == 1:
                                        print("Warning: The seats", input_list2[c], "cannot be sold to", input_list[1],
                                              "due some of them have already been sold", file=file_output)
                                        print("Warning: The seats", input_list2[c], "cannot be sold to", input_list[1],
                                              "due some of them have already been sold")
                                        break
                                elif categories[input_list[3]][k] == "":
                                    categories[input_list[3]][k] = str(input_list[1]), str(input_list[2])
                                    x += 1
                                    if x == (buyuk-kucuk)+1:
                                        print("Success:", input_list[1], "has bought", input_list2[c], "at", input_list[3], file=file_output)
                                        print("Success:", input_list[1], "has bought", input_list2[c], "at", input_list[3])
                                        break
                    else:
                        print("Error: The category", "'"+input_list[3]+"'", "has less column than the specified index", input_list2[c]+"!",
                              file=file_output)
                        print("Error: The category", "'" + input_list[3] + "'", "has less column than the specified index", input_list2[c] + "!")
                        break
            else:
                if categories[input_list[3]][t] == "":
                    categories[input_list[3]][t] = str(input_list[1]), str(input_list[2])
                    print("Success:", input_list[1], "has bought", t, "at", input_list[3], file=file_output)
                    print("Success:", input_list[1], "has bought", t, "at", input_list[3])
                elif categories[input_list[3]][t] != "":
                    print("Error: The seat", t, "cannot be sold to", input_list[1], "since it was already sold!", file=file_output)
                    print("Error: The seat", t, "cannot be sold to", input_list[1], "since it was already sold!")
                    aralık_list.clear()
    else:
        print("There is no such category!", file=file_output)
        print("There is no such category!")

def cancel():
    if input_list[1] in categories:
        if input_list[2] in categories[input_list[1]]:
            if categories[input_list[1]][input_list[2]] != "":
                categories[input_list[1]][input_list[2]] = ""
                print("Success: The seat", input_list[2], "at", "'"+input_list[1]+"'", "has been canceled and now ready to sell again",
                      file=file_output)
                print("Success: The seat", input_list[2], "at", "'" + input_list[1] + "'", "has been canceled and now ready to sell again")
            else:
                print("Error: The seat", input_list[2], "at", "'" + input_list[1] + "'", "has already been free! Nothing to cancel", file=file_output)
                print("Error: The seat", input_list[2], "at", "'" + input_list[1] + "'", "has already been free! Nothing to cancel")
        else:
            print("Error: The category", "'"+input_list[1]+"'", "has less column than the specified index ", input_list[2]+"!", file=file_output)
            print("Error: The category", "'" + input_list[1] + "'", "has less column than the specified index ", input_list[2] + "!")
    else:
        print("There is no such category!", input_list[1], file=file_output)
        print("There is no such category!", input_list[1])

def balance():
    if input_list[1] in categories:
        print("Category report of", "’"+input_list[1]+"’", file=file_output)
        print("Category report of", "’" + input_list[1] + "’")
        print(31*"-", file=file_output)
        print(31 * "-")
        student = 0
        full = 0
        season = 0
        for i in categories[input_list[1]]:
            if "student" in categories[input_list[1]][i]:
                student += 1
            elif "full" in categories[input_list[1]][i]:
                full += 1
            elif "season" in categories[input_list[1]][i]:
                season += 1
            else:
                pass
                revenues = (student*10) + (full*20) + (season*250)
        print("Sum of students =", student, "Sum of full pay =", full, "Sum of season ticket =", season, "and Revenues = ", revenues, "Dollars",
              file=file_output)
        print("Sum of students =", student, "Sum of full pay =", full, "Sum of season ticket =", season, "and Revenues = ", revenues, "Dollars")
    else:
        print("There is no", input_list[1], file=file_output)
        print("There is no", input_list[1])

def show():
        koltuk_durumu = list(categories[input_list[1]].values())
        for durum in range((len(koltuk_durumu))):
            if koltuk_durumu[durum] == "":
                koltuk_durumu[durum] = "X"
            elif "student" in koltuk_durumu[durum][1]:
                koltuk_durumu[durum] = "S"
            elif "full" in koltuk_durumu[durum][1]:
                koltuk_durumu[durum] = "F"
            elif "season" in koltuk_durumu[durum][1]:
                koltuk_durumu[durum] = "T"
        koltuk_adı = list(categories[input_list[1]].keys())
        listeshow = []
        for i in koltuk_adı:
            listeshow.append(i[0])
        sutun_sayisi = listeshow.count("A")
        satir_sayisi = int(len(listeshow) / sutun_sayisi)
        print("printing category layout of category-{} ".format(input_list[1][9] + input_list[1][10]), file=file_output)
        print("printing category layout of category-{} ".format(input_list[1][9] + input_list[1][10]))
        t = satir_sayisi - 1
        u = len(koltuk_durumu)
        x = u - satir_sayisi
        for e in range(satir_sayisi+1):
            print("\n", end="", file=file_output)
            print("\n", end="")
            print(alphabet[t], end=" ", file=file_output)
            print(alphabet[t], end=" ")
            for m in range(x, u):
                print(koltuk_durumu[m], end="  ", file=file_output)
                print(koltuk_durumu[m], end="  ")
            u = u - satir_sayisi
            x = x - satir_sayisi
            sutun_sayisi = sutun_sayisi + satir_sayisi
            t -= 1
            print(end="",file=file_output)
            print(end="")
            if t < 0:
                break
            elif m < 0:
                break
        print("\n", end="", file=file_output)
        print("\n", end="")
        for k in range(int(satir_sayisi)):
            if k == 9 or k > 9:
                print(k, end=" ", file=file_output)
                print(k, end=" ")
            elif k == 0 :
                print(" ", k, end="  ", file=file_output)
                print(" ", k, end="  ")
            else:
                print(k, end="  ", file=file_output)
                print(k, end="  ")
        print('', file=file_output)
        print('')

file_input = open(file_name, "r", encoding="UTF-8")
file_output = open("output.txt", "w", encoding="UTF-8")
showcategory_list = []                #bu liste show fonksiyonu için oluşturuldu
for line in file_input:
    line = line.strip("\n")
    input_list = line.split(" ")
    input_list2 = line.split(" ")

    if input_list[0] == "CREATECATEGORY":
        category_name = {}
        category_name = input_list[1]
        seats = {}
        alphabet = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
        index_x = input_list[2]
        d = index_x.index('x')
        a = int(input_list[2][0:d])
        b = int(input_list[2][d+1::])
        c = a * b
        for i in range(int(input_list[2][0:2])):
            for l in range(int(input_list[2][-2:])):
                seats[alphabet[i] + str(l)] = ""
        create()
    elif input_list[0] == "SELLTICKET":
        sell()
    elif input_list[0] == "CANCELTICKET":
        cancel()
    elif input_list[0] == "BALANCE":
        balance()
    elif input_list[0] == "SHOWCATEGORY":
        show()
    else:
        print("your command is wrong!!!", file=file_output)
        print("your command is wrong!!!")
file_input.close()
file_output.close()
