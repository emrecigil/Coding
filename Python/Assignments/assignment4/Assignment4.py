                                                    # Emre Çiğil 2210356033
import sys
file_output = open("Battleship.out", "w", encoding="UTF-8")
try:
    arg1, arg2, arg3, arg4 = sys.argv[1], sys.argv[2], sys.argv[3], sys.argv[4]
except SystemError:
    print("Error: There ara more or less argument than expected."), print("Error: There ara more or less argument than expected.",file=file_output)
try:
    p1_ship = open(arg1, "r", encoding="UTF-8")                           #burada input dosyalarını açıp gemi koordinatlarını listeye atadım.
except IOError:
    print("IOError: input file {} is not reachable.".format("Player1.txt")), print("IOError: input file {} is not reachable.".format("Player1.txt"),file=file_output)
try:
    p2_ship = open(arg2, "r", encoding="UTF-8")
except IOError:
    print("IOError: input file {} is not reachable.".format("Player2.txt")), print("IOError: input file {} is not reachable.".format("Player2.txt"),file=file_output)
chart1, chart2 = [], []
for line in p1_ship:
    line = line.strip("\n")
    line = line.split(";")
    chart1.append(line)                                                 #gemi dosylarını for döngüsüyle satır satır okuyarak matrix hazırladım
for line in p2_ship:
    line = line.strip("\n")
    line = line.split(";")
    chart2.append(line)
p1_ship.close(), p2_ship.close()
martix1, martix2 = [], []
def create_matrix():
    try:
        p1_mat = open(arg1, "r", encoding="UTF-8")
    except IOError:
        print("IOError: input file(s) {} is/are not reachable.".format("Player1.txt")), print("IOError: input file(s) {} is/are not reachable.".format("Player1.txt"),file=file_output)
    try:
        p2_mat = open(arg2, "r", encoding="UTF-8")
    except:
        print("IOError: input file(s) {} is/are not reachable.".format("Player2.txt")), print("IOError: input file(s) {} is/are not reachable.".format("Player2.txt"),file=file_output)
    for i in p1_mat:
        i = i.strip("\n")
        i = i.split(";")
        for k in range(len(i)):
            i[k] = "-"
        martix1.append(i)                                                      #bu fonksiyon ile gemilerin bulunduğu liste uzunluğu kadar matriks listesi
    for i in p2_mat:                                                           #oluşturdum ve output çıkacak tabloyu hazırladım.
        i = i.strip("\n")
        i = i.split(";")
        for k in range(len(i)):
            i[k] = "-"
        martix2.append(i)
    p1_mat.close(), p2_mat.close()
create_matrix()
def mat_1(x):  # bu fonksiyon oluşturulan matriks listesini ve batan gemi tablosunu outputta göstermek için yazıldı.
    if x == 1:
        print("Player1’s Board" + 4*"\t" + "Player2’s Board", file=file_output), print("Player1’s Board" + 4*"\t" + "Player2’s Board")
        for i in range(len(chart1)):
            for k in range(len(chart1[i])):
                if chart1[i][k] != "" and martix1[i][k] != "X":
                    martix1[i][k] = chart1[i][k]                #bu döngüyü final durumunu göstermek için kullandım.
        for i in range(len(chart2)):
            for k in range(len(chart2[i])):
                if chart2[i][k] != "" and martix2[i][k] != "X":
                    martix2[i][k] = chart2[i][k]
    else:
        print("Player1’s Hidden Board" + 2*"\t" + "Player2’s Hidden Board", file=file_output), print("Player1’s Hidden Board" + 2*"\t" + "Player2’s Hidden Board")
    print(" ", " ".join(alphabet[:len(martix1)]) + 2*"\t" + " ", " ".join(alphabet[:len(martix1)]), file=file_output), print(" ", " ".join(alphabet[:len(martix1)]) + 2*"\t" + " ", " ".join(alphabet[:len(martix1)]))
    y = 1
    global list_ship1               #bu for döngüsü raundlar içi kullandım.
    global list_ship2
    for i in range(len(martix1)):
        if y < 10:
            print(str(y), " ".join(martix1[i]) + 2*"\t" + str(y), " ".join(martix2[i]), file=file_output), print(str(y), " ".join(martix1[i]) + 2*"\t" + str(y), " ".join(martix2[i]))
            y += 1
        else:
            print(str(y) + " ".join(martix1[i]) + 2*"\t" + str(y) + " ".join(martix2[i]), file=file_output), print(str(y) + " ".join(martix1[i]) + 2*"\t" + str(y) + " ".join(martix2[i]))
            y += 1
    print("\nCarrier" + 2*"\t" + str(*list_ship1[0]) + 4*"\t" + "Carrier" + 2*"\t" + str(*list_ship2[0]) + "\nBattleship" + "\t" + " ".join(list_ship1[1]) + 4*"\t" + "Battleship"+"\t"+ " ".join(list_ship2[1])+
          "\nDestroyer" + "\t" + str(*list_ship1[2]) + 4*"\t" + "Destroyer" + "\t" + str(*list_ship2[2]) + "\nSubmarine" + "\t" + str(*list_ship1[3]) + 4*"\t" + "Submarine" + "\t" +
          str(*list_ship2[3]) + "\nPatrol Boat", *list_ship1[4], 2*"\t" + "Patrol Boat", *list_ship2[4], file=file_output)
    print("\nCarrier" + 2 * "\t" + str(*list_ship1[0]) + 4 * "\t" + "Carrier" + 2 * "\t" + str(*list_ship2[0]) + "\nBattleship" + "\t" + " ".join(
        list_ship1[1]) + 4 * "\t" + "Battleship" + "\t" + " ".join(list_ship2[1]) +
          "\nDestroyer" + "\t" + str(*list_ship1[2]) + 4 * "\t" + "Destroyer" + "\t" + str(*list_ship2[2]) + "\nSubmarine" + "\t" + str(*list_ship1[3]) + 4 * "\t" + "Submarine" + "\t" +str(*list_ship2[3]) +
          "\nPatrol Boat", *list_ship1[4], 2 * "\t" + "Patrol Boat", *list_ship2[4])
alphabet = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
battleship1, carrier1, destroyer1, submarine1, patrol1 = [], [], [], [], []
battleship2, carrier2, destroyer2, submarine2, patrol2 = [], [], [], [], [] #aşağıdaki fonksiyonda tespit edilen gemileri bu listeye ekliyoruz.
def ships():                                         #bu fonksiyon tablodaki aynı harflerin yanyana olduğunu tespit edip onların gemi olmasını belirliyor. Ve en son o gemileri bir listede topluyor.
    for i in range(len(chart1)):                    #yatay ve dikey olmak üzere iki şekilde harf tarama yapıyor.
        x = 0                                       # uzun ve karışık gibi gözükse de verimli bir şekilde yürütülüyor.
        for j in range(7):                          # Eğer bu commentları okuyorsanız ve dikkate alıyorsanız bir işaret bırakın :)) :))
            try:
                a = []
                if chart1[i][x:x+4] == ["B", "B", "B", "B"]:
                    if chart1[i][x:x+5] == ["B", "B", "B", "B", "B"]:
                        if chart1[i+1][x] == "B":
                            x += 1
                            continue
                        else:
                            a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1]), (str(i + 1) + "," + alphabet[x + 2]),
                                      (str(i + 1) + "," + alphabet[x + 3])])
                            battleship1.append(a)           #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                            x += 4
                    else:
                        a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1]), (str(i + 1) + "," + alphabet[x + 2]),
                                  (str(i + 1) + "," + alphabet[x + 3])])
                        battleship1.append(a)
                        x += 1
                else:
                    x = x+1
            except IndexError:
                continue
    for i in range(len(chart1)):
        x = 0
        for j in range(8):
            try:
                a = []
                if chart1[i][x:x+3] == ["D", "D", "D"]:
                    a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1]), (str(i + 1) + "," + alphabet[x + 2])])
                    destroyer1.append(a)
                    x += 1
                else:
                    x = x+1
            except IndexError:
                continue
    for i in range(len(chart1)):
        x = 0
        for j in range(8):
            try:
                a = []
                if chart1[i][x:x+3] == ["S", "S", "S"]:
                    a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1]), (str(i + 1) + "," + alphabet[x + 2])])
                    submarine1.append(a)
                    x += 1
                else:
                    x = x+1
            except IndexError:
                continue
    for i in range(len(chart1)):
        x = 0
        for j in range(6):
            try:
                a = []
                if chart1[i][x:x+5] == ["C", "C", "C", "C", "C"]:              #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                    a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1]), (str(i + 1) + "," + alphabet[x + 2]),
                              (str(i + 1) + "," + alphabet[x + 3]), (str(i + 1) + "," + alphabet[x + 4])])
                    carrier1.append(a)
                    x += 1
                else:
                    x = x+1
            except IndexError:
                continue
    for i in range(len(chart1)):
        x = 0
        for j in range(9):
            try:
                a = []
                if chart1[i][x:x+2] == ["P", "P"]:
                    if chart1[i][x:x+3] == ["P", "P", "P"]:
                        if chart1[i+1][x] == "P":
                            x += 1
                            continue
                        else:
                            a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1])])
                            patrol1.append(a)             #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                            x += 2
                    else:
                        a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1])])
                        patrol1.append(a)
                        x += 1
                else:
                    x = x+1
            except IndexError:
                continue
    for i in range(len(chart2)):
        x = 0
        for j in range(7):
            try:
                a = []
                if chart2[i][x:x+4] == ["B", "B", "B", "B"]:
                    if chart2[i][x:x+5] == ["B", "B", "B", "B", "B"]:
                        if chart2[i+1][x] == "B":
                            x += 1
                            continue
                        else:
                            a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1]), (str(i + 1) + "," + alphabet[x + 2]),
                                      (str(i + 1) + "," + alphabet[x + 3])])
                            battleship2.append(a)               #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                            x += 4
                    else:
                        a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1]), (str(i + 1) + "," + alphabet[x + 2]),
                                  (str(i + 1) + "," + alphabet[x + 3])])
                        battleship2.append(a)
                        x += 1
                else:
                    x = x+1
            except IndexError:
                continue
    for i in range(len(chart2)):
        x = 0
        for j in range(8):
            try:
                a = []
                if chart2[i][x:x+3] == ["D", "D", "D"]:
                    a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1]), (str(i + 1) + "," + alphabet[x + 2])])
                    destroyer2.append(a)
                    x += 1
                else:
                    x = x+1
            except IndexError:
                continue
    for i in range(len(chart2)):
        x = 0
        for j in range(8):
            try:
                a = []
                if chart2[i][x:x+3] == ["S", "S", "S"]:
                    a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1]), (str(i + 1) + "," + alphabet[x + 2])])
                    submarine2.append(a)
                    x += 1
                else:
                    x = x+1
            except IndexError:
                continue
    for i in range(len(chart2)):
        x = 0
        for j in range(6):
            try:
                a = []
                if chart2[i][x:x+5] == ["C", "C", "C", "C", "C"]:
                    a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1]), (str(i + 1) + "," + alphabet[x + 2]),
                              (str(i + 1) + "," + alphabet[x + 3]), (str(i + 1) + "," + alphabet[x + 4])])
                    carrier2.append(a)
                    x += 1
                else:
                    x = x+1
            except IndexError:
                continue
    for i in range(len(chart2)):
        x = 0
        for j in range(9):
            try:
                a = []
                if chart2[i][x:x+2] == ["P", "P"]:
                    if chart2[i][x:x+3] == ["P", "P", "P"]:
                        if chart2[i+1][x] == "P":
                            x += 1
                            continue
                        else:
                            a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1])])
                            patrol2.append(a)           #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                            x += 2
                    else:
                        a.extend([(str(i + 1) + "," + alphabet[x]), (str(i + 1) + "," + alphabet[x + 1])])
                        patrol2.append(a)
                        x += 1
                else:
                    x = x+1
            except IndexError:
                continue
    for i in range(len(chart1)):
        for j in range(10):
            a = []
            try:
                if chart1[i][j] and chart1[i+1][j] and chart1[i+2][j] and chart1[i+3][j] == "B":
                    try:
                        if (chart1[i][j] and chart1[i+1][j] and chart1[i+2][j] and chart1[i+3][j] and chart1[i+4][j]) \
                                or(chart1[i-1][j] and chart1[i][j] and chart1[i+1][j] and chart1[i+2][j] and chart1[i+3][j]) == "B":
                            if chart1[i][j+1] or chart1[i][j-1] or chart1[i+3][j-1] or chart1[i+3][j+1] == "B":
                                continue
                            else:
                                a.extend([(str(i+1)) + "," + alphabet[j], (str(i +2)) + "," + alphabet[j], (str(i + 3)) + "," + alphabet[j],
                                          (str(i + 4)) + "," + alphabet[j]])
                                battleship1.append(a)               #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                        else:
                            a.extend([(str(i + 1)) + "," + alphabet[j], (str(i + 2)) + "," + alphabet[j], (str(i + 3)) + "," + alphabet[j],
                                      (str(i + 4)) + "," + alphabet[j]])
                            battleship1.append(a)
                    except IndexError:
                        a.extend([(str(i + 1)) + "," + alphabet[j], (str(i + 2)) + "," + alphabet[j], (str(i + 3)) + "," + alphabet[j],
                                  (str(i + 4)) + "," + alphabet[j]])
                        battleship1.append(a)
                else:
                    continue
            except IndexError:
                continue
    for i in range(len(chart1)):
        for j in range(10):
            a = []
            try:
                if chart1[i][j] and chart1[i+1][j] and chart1[i+2][j] and chart1[i+3][j] and chart1[i+4][j] == "C":
                    try:
                        if chart1[i][j] and chart1[i+1][j] and chart1[i+2][j] and chart1[i+3][j] and chart1[i+4][j] and chart1[i+5][j]\
                                or(chart1[i-1][j] and chart1[i][j] and chart1[i+1][j] and chart1[i+2][j] and chart1[i+3][j] and chart1[i+4][j]) == "C":
                            if chart1[i][j+1] or chart1[i][j-1] or chart1[i+4][j-1] or chart1[i+4][j+1] == "C":
                                continue
                            else:
                                a.extend([(str(i+1)) + "," + alphabet[j], (str(i +2)) + "," + alphabet[j], (str(i + 3)) + "," + alphabet[j],
                                          (str(i + 4)) + "," + alphabet[j], (str(i + 5)) + "," + alphabet[j]])
                                carrier1.append(a)               #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                        else:
                            a.extend([(str(i + 1)) + "," + alphabet[j], (str(i + 2)) + "," + alphabet[j], (str(i + 3)) + "," + alphabet[j],
                                      (str(i + 4)) + "," + alphabet[j], (str(i + 5)) + "," + alphabet[j]])
                            carrier1.append(a)
                    except IndexError:
                        a.extend([(str(i + 1)) + "," + alphabet[j], (str(i + 2)) + "," + alphabet[j], (str(i + 3)) + "," + alphabet[j],
                                  (str(i + 4)) + "," + alphabet[j], (str(i + 5)) + "," + alphabet[j]])
                else:
                    continue
            except IndexError:
                continue
    for i in range(len(chart1)):
        for j in range(10):
            a = []
            try:
                if chart1[i][j] and chart1[i+1][j] and chart1[i+2][j] == "S":
                    try:
                        if chart1[i][j] and chart1[i + 1][j] and chart1[i + 2][j] and chart1[i + 3][j] \
                                or (chart1[i-1][j] and chart1[i][j] and chart1[i+1][j] and chart1[i+2][j]) == "S":
                            if chart1[i][j-1] or chart1[i][j+1] or chart1[i + 2][j - 1] or chart1[i + 2][j + 1] == "S":
                                continue
                            else:
                                a.extend([(str(i + 1) + "," + alphabet[j]),(str(i + 2) + "," + alphabet[j])], (str(i + 3) + "," + alphabet[j]))
                                submarine1.append(a)            #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                        else:
                            a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j])], (str(i + 3) + "," + alphabet[j]))
                            submarine1.append(a)
                    except IndexError:
                        a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j])], (str(i + 3) + "," + alphabet[j]))
                        submarine1.append(a)
                else:
                    continue
            except IndexError:
                continue
    for i in range(len(chart1)):
        for j in range(10):
            a = []
            try:
                if chart1[i][j] and chart1[i+1][j] and chart1[i+2][j] == "D":
                    try:
                        if chart1[i][j] and chart1[i + 1][j] and chart1[i + 2][j] and chart1[i + 3][j] \
                                or (chart1[i-1][j] and chart1[i][j] and chart1[i+1][j] and chart1[i+2][j]) == "D":
                            if chart1[i][j-1] or chart1[i][j+1] or chart1[i + 2][j - 1] or chart1[i + 2][j + 1] == "D":
                                continue
                            else:
                                a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j]), (str(i + 3) + "," + alphabet[j])])
                                destroyer1.append(a)      #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                        else:
                            a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j]), (str(i + 3) + "," + alphabet[j])])
                            destroyer1.append(a)
                    except IndexError:
                        a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j]), (str(i + 3) + "," + alphabet[j])])
                        destroyer1.append(a)
                else:
                    continue
            except IndexError:
                continue
    for i in range(len(chart1)):
        for j in range(10):
            a = []
            try:
                if chart1[i][j] and chart1[i+1][j] == "P":
                    try:
                        if chart1[i][j] and chart1[i + 1][j] and chart1[i + 2][j]  \
                                or (chart1[i-1][j] and chart1[i][j] and chart1[i+1][j]) == "P":
                            if chart1[i][j-1] or chart1[i][j+1] or chart1[i + 1][j - 1] or chart1[i + 1][j + 1] == "P":
                                continue
                            else:
                                a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j])])
                                patrol1.append(a)
                        else:
                            a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j])])
                            patrol1.append(a)
                    except IndexError:
                        a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j])])
                        patrol1.append(a)
                else:
                    continue
            except IndexError:
                continue
    for i in range(len(chart2)):
        for j in range(10):
            a = []
            try:
                if chart2[i][j] and chart2[i+1][j] and chart2[i+2][j] and chart2[i+3][j] == "B":
                    try:
                        if (chart2[i][j] and chart2[i+1][j] and chart2[i+2][j] and chart2[i+3][j] and chart2[i+4][j]) \
                                or(chart2[i-1][j] and chart2[i][j] and chart2[i+1][j] and chart2[i+2][j] and chart2[i+3][j]) == "B":
                            if chart2[i][j+1] or chart2[i][j-1] or chart2[i+3][j-1] or chart2[i+3][j+1] == "B":
                                continue
                            else:
                                a.extend([(str(i+1)) + "," + alphabet[j], (str(i +2)) + "," + alphabet[j], (str(i + 3)) + "," + alphabet[j],
                                          (str(i + 4)) + "," + alphabet[j]])
                                battleship2.append(a)       #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                        else:
                            a.extend([(str(i + 1)) + "," + alphabet[j], (str(i + 2)) + "," + alphabet[j], (str(i + 3)) + "," + alphabet[j],
                                      (str(i + 4)) + "," + alphabet[j]])
                            battleship2.append(a)
                    except IndexError:
                        a.extend([(str(i + 1)) + "," + alphabet[j], (str(i + 2)) + "," + alphabet[j], (str(i + 3)) + "," + alphabet[j],
                                  (str(i + 4)) + "," + alphabet[j]])
                        battleship2.append(a)
                else:
                    continue
            except IndexError:
                continue
    for i in range(len(chart2)):
        for j in range(10):
            a = []
            try:
                if chart2[i][j] and chart2[i+1][j] and chart2[i+2][j] and chart2[i+3][j] and chart2[i+4][j]== "C":
                    try:
                        if chart2[i][j] and chart2[i+1][j] and chart2[i+2][j] and chart2[i+3][j] and chart2[i+4][j] and chart2[i+5][j]\
                                or(chart2[i-1][j] and chart2[i][j] and chart2[i+1][j] and chart2[i+2][j] and chart2[i+3][j] and chart2[i+4][j]) == "C":
                            if chart2[i][j+1] or chart2[i][j-1] or chart2[i+4][j-1] or chart2[i+4][j+1] == "C":
                                continue
                            else:
                                a.extend([(str(i+1)) + "," + alphabet[j], (str(i +2)) + "," + alphabet[j], (str(i + 3)) + "," + alphabet[j],
                                          (str(i + 4)) + "," + alphabet[j], (str(i + 5)) + "," + alphabet[j]])
                                carrier2.append(a)                  #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                        else:
                            a.extend([(str(i + 1)) + "," + alphabet[j], (str(i + 2)) + "," + alphabet[j], (str(i + 3)) + "," + alphabet[j],
                                      (str(i + 4)) + "," + alphabet[j], (str(i + 5)) + "," + alphabet[j]])
                            carrier2.append(a)
                    except IndexError:
                        a.extend([(str(i + 1)) + "," + alphabet[j], (str(i + 2)) + "," + alphabet[j], (str(i + 3)) + "," + alphabet[j],
                                  (str(i + 4)) + "," + alphabet[j], (str(i + 5)) + "," + alphabet[j]])
                        carrier2.append(a)
                else:
                    continue
            except IndexError:
                continue
    for i in range(len(chart2)):
        for j in range(10):
            a = []
            try:
                if chart2[i][j] and chart2[i+1][j] and chart2[i+2][j] == "S":
                    try:
                        if chart2[i][j] and chart2[i + 1][j] and chart2[i + 2][j] and chart2[i + 3][j] \
                                or (chart2[i-1][j] and chart2[i][j] and chart2[i+1][j] and chart2[i+2][j]) == "S":
                            if chart2[i][j-1] or chart2[i][j+1] or chart2[i + 2][j - 1] or chart2[i + 2][j + 1] == "S":
                                continue
                            else:
                                a.extend([(str(i + 1) + "," + alphabet[j]),(str(i + 2) + "," + alphabet[j]),(str(i + 3) + "," + alphabet[j])])
                                submarine2.append(a)
                        else:                                    #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                            a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j]), (str(i + 3) + "," + alphabet[j])])
                            submarine2.append(a)
                    except IndexError:
                        a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j]), (str(i + 3) + "," + alphabet[j])])
                        submarine2.append(a)
                else:
                    continue
            except IndexError:
                continue
    for i in range(len(chart2)):
        for j in range(10):
            a = []
            try:
                if chart2[i][j] and chart2[i+1][j] and chart2[i+2][j] == "D":
                    try:
                        if chart2[i][j] and chart2[i + 1][j] and chart2[i + 2][j] and chart2[i + 3][j] \
                                or (chart2[i-1][j] and chart2[i][j] and chart2[i+1][j] and chart2[i+2][j]) == "D":
                            if chart2[i][j-1] or chart2[i][j+1] or chart2[i + 2][j - 1] or chart2[i + 2][j + 1] == "D":
                                continue
                            else:
                                a.extend([(str(i + 1) + "," + alphabet[j]),(str(i + 2) + "," + alphabet[j]), (str(i + 3) + "," + alphabet[j])])
                                destroyer2.append(a)
                        else:                   #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                            a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j]), (str(i + 3) + "," + alphabet[j])])
                            destroyer2.append(a)
                    except IndexError:
                        a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j]), (str(i + 3) + "," + alphabet[j])])
                        destroyer2.append(a)
                else:
                    continue
            except IndexError:
                continue
    for i in range(len(chart2)):
        for j in range(10):
            a = []
            try:
                if chart2[i][j] and chart2[i+1][j] == "P":
                    try:
                        if chart2[i][j] and chart2[i + 1][j] and chart2[i + 2][j]  \
                                or (chart2[i-1][j] and chart2[i][j] and chart2[i+1][j]) == "P":
                            if chart2[i][j-1] or chart2[i][j+1] or chart2[i + 1][j - 1] or chart2[i + 1][j + 1] == "P":
                                continue
                            else:
                                a.extend([(str(i + 1) + "," + alphabet[j]),(str(i + 2) + "," + alphabet[j])])
                                patrol2.append(a)
                        else:                #Bu kodlar normalden fazla çünkü, gemi saysının değişken olabilme ihtimali de göz önünde bulunduruldu.
                            a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j])])
                            patrol2.append(a)
                    except IndexError:
                        a.extend([(str(i + 1) + "," + alphabet[j]), (str(i + 2) + "," + alphabet[j])])
                        patrol2.append(a)
                else:
                    continue
            except IndexError:
                continue
ships()
list_ship1, list_ship2 = [["-"], ["-", "-"], ["-"], ["-"], ["-", "-", "-", "-"]], [["-"], ["-", "-"], ["-"], ["-"], ["-", "-", "-", "-"]]
player1move, player2move = [], []
def create_move_list():             #bu fonksiyon kullanıcın hangi noktaya saldırı yapacağını tespit etmek için input dosyasını okuyup ona göre işlem yapıyr.
    try:
        move1 = open(arg3, "r", encoding="UTF-8")
    except IOError:
        print("IOError: input file {} is not reachable.".format("Player1.in")), print("IOError: input file {} is not reachable.".format("Player1.in"),file=file_output)
    try:
        move2 = open(arg4, "r", encoding="UTF-8")
    except IOError:
        print("IOError: input file {} is not reachable.".format("Player2.in")), print("IOError: input file {} is not reachable.".format("Player2.in"),file=file_output)
    global player1move
    global player2move
    for i in move1:
        player1move = i.split(";")
        player1move.remove("")
    for j in move2:                                    #burada belli kriterlere göre split edilip listelere ekleniyor.
        player2move = j.split(";")
        player2move.remove("")
    move1.close(), move2.close()
create_move_list()
b1, c1, d1, s1, p1 = [], [], [], [], []         #bu listeler outputtaki gemi sayacının çalışmasını sağlıyor ve batan gemiye karşılık X koyuyor
def attack1(a):           #Bu fonksiyon saldırı noktalarını eklediğimiz listeleri okuyup o noktada gemi olup olmamasını kontrol ediyor ve ona göre çıktı çıkmasını sağlıyor.
    try:
        coor_hor1, coor_ver1, e = (int(player1move[a][0:-2]) - 1), alphabet.index(player1move[a][-1]), player1move[a]
        try:
            assert int(player1move[a][0:-2]) <= 10 and alphabet.index(player1move[a][-1]) <= 9, "AssertionError: Invalid Operation.\n"
            if chart2[coor_hor1][coor_ver1] == "":
                martix2[coor_hor1][coor_ver1] = "O"
            elif chart2[coor_hor1][coor_ver1] == "B":
                martix2[coor_hor1][coor_ver1] = "X"
                for i in range(len(battleship2)):
                    if e in battleship2[i]:
                        b1.append(i)
                        if b1.count(0) == 4 or b1.count(1) == 4:
                            list_ship2[1].pop(), list_ship2[1].insert(0, "X")
                            b1.remove(i)
            elif chart2[coor_hor1][coor_ver1] == "C":
                martix2[coor_hor1][coor_ver1] = "X"                     #bu döngülerle gemilerin olduğu listede harf taraması yapıp saldırı noktasıyla aynı
                for i in range(len(carrier2)):                          # indekstelerse tablodaki - yi X yapar ve gemi sayacı listesine vurulan parçayı ekler
                    if e in carrier2[i]:                                 # bütün parça vurulduysa gemi batar ve sayaç bunu gösterir
                        c1.append(i)
                if c1.count(0) == 5:
                    list_ship2[0].pop(), list_ship2[0].insert(0, "X")
            elif chart2[coor_hor1][coor_ver1] == "D":
                martix2[coor_hor1][coor_ver1] = "X"
                for i in range(len(destroyer2)):                        #DİKKAT burada index error kullanmadım çünkü index error kullansam bile value error gerekli her şeyi 
                    if e in destroyer2[i]:                              # index errordan önce hallediyor. Kısaca value error index errorun görevini de üstleniyor. 
                        d1.append(i)                                    # Aslında buradaki error type ı ikisinin birleşimidir.
                if d1.count(0) == 3:
                    list_ship2[2].pop(), list_ship2[2].insert(0, "X")
            elif chart2[coor_hor1][coor_ver1] == "S":
                martix2[coor_hor1][coor_ver1] = "X"
                for i in range(len(submarine2)):
                    if e in submarine2[i]:
                        s1.append(i)
                if s1.count(0) == 3:
                    list_ship2[3].pop(), list_ship2[3].insert(0, "X")
            elif chart2[coor_hor1][coor_ver1] == "P":
                martix2[coor_hor1][coor_ver1] = "X"
                for i in range(len(patrol2)):
                    if e in patrol2[i]:
                        p1.append(i)
                        if p1.count(0) == 2 or p1.count(1) == 2 or p1.count(2) == 2 or p1.count(3) == 2:
                            list_ship2[4].pop(), list_ship2[4].insert(0, "X"), p1.remove(i)
        except AssertionError as msg:
            print(msg, file=file_output), print(msg)
    except ValueError:
        print("ValueError: Wrong Value is entered!\n"), print("ValueError: Wrong Value is entered!\n", file=file_output)
b2, c2, d2, s2, p2 = [], [], [], [], []
def attack2(a):  # bu fonksiyon yukarıdaki fonksiyonla aynı işlevi görüyor sadece bu player 2 için işlem yapar.
    try:
        coor_hor2, coor_ver2, e = (int(player2move[a][0:-2]) - 1), alphabet.index(player2move[a][-1]), player2move[a]
        try:
            assert int(player2move[a][0:-2]) <= 10 and player2move[a][-1] in alphabet, "AssertionError: Invalid Operation."
            if chart1[coor_hor2][coor_ver2] == "":
                martix1[coor_hor2][coor_ver2] = "O"
            elif chart1[coor_hor2][coor_ver2] == "B":
                martix1[coor_hor2][coor_ver2] = "X"
                for i in range(len(battleship1)):                               #DİKKAT burada index error kullanmadım çünkü index error kullansam bile value error gerekli her şeyi 
                    if e in battleship1[i]:                                     # index errordan önce hallediyor. Kısaca value error index errorun görevini de üstleniyor. 
                        b2.append(i)                                            #Aslında buradaki error type ı ikisinin birleşimidir.
                        if b2.count(0) == 4 or b2.count(1) == 4:                
                            list_ship1[1].pop(), list_ship1[1].insert(0, "X")
                            b2.remove(i)
            elif chart1[coor_hor2][coor_ver2] == "C":
                martix1[coor_hor2][coor_ver2] = "X"
                for i in range(len(carrier1)):
                    if e in carrier1[i]:
                        c2.append(i)
                if c2.count(0) == 5:
                    list_ship1[0].pop(), list_ship1[0].insert(0, "X")
            elif chart1[coor_hor2][coor_ver2] == "D":
                martix1[coor_hor2][coor_ver2] = "X"
                for i in range(len(destroyer1)):
                    if e in destroyer1[i]:
                        d2.append(i)
                if d2.count(0) == 3:
                    list_ship1[2].pop(), list_ship1[2].insert(0, "X")
            elif chart1[coor_hor2][coor_ver2] == "S":
                martix1[coor_hor2][coor_ver2] = "X"
                for i in range(len(submarine1)):
                    if e in submarine1[i]:
                        s2.append(i)
                if s2.count(0) == 3:
                    list_ship1[3].pop(), list_ship1[3].insert(0, "X")
            elif chart1[coor_hor2][coor_ver2] == "P":
                martix1[coor_hor2][coor_ver2] = "X"
                for i in range(len(patrol1)):
                    if e in patrol1[i]:
                        p2.append(i)
                        if p2.count(0) == 2 or p2.count(1) == 2 or p2.count(2) == 2 or p2.count(3) == 2:
                            list_ship1[4].pop(), list_ship1[4].insert(0, "X"), p2.remove(i)
        except AssertionError as msg:
            print(msg, file=file_output), print(msg)  # try exceptlerle olası hataların önüne geçilir, geçemediysem sağlık oolsunnnnnnn :(((
    except ValueError:
        print("ValueError: Wrong Value is entered!"), print("ValueError: Wrong Value is entered!", file=file_output)
def game():
    # Bu fonkiyon bu işlemlerin hepsini oyuna döker ve oyunu çalıştırır
    y, x = 0, 1
    print("Battle of Ships Game\n", file=file_output), print("Battle of Ships Game\n")
    for i in range(max(len(player1move), len(player2move))+1):              #for döngüsüyle oyunun uzunluğu ve hamle sırası kontrol altına alınır.
        if "-" not in (''.join(map(''.join, list_ship1))):
            print("Player2 Wins!" + "\n", file=file_output), print("Final Information" + "\n", file=file_output), print("Player2 Wins!" + "\n"), print("Final Information" + "\n")
            mat_1(1)                                                        # Gerekli fonksiyonlar burada çağırılır
            break
        elif "-" not in (''.join(map(''.join, list_ship2))):
            print("Player1 Wins!" + "\n", file=file_output), print("Final Information" + "\n", file=file_output), print("Player1 Wins!" + "\n"), print("Final Information" + "\n")
            mat_1(1)
            break
        elif i == max(len(player1move), len(player2move)):
            print("It is a Draw!" + "\n", file=file_output), print("Final Information" + "\n", file=file_output), print("It is a Draw!" + "\n"), print("Final Information" + "\n")
            mat_1(1)
            break
        print("Player1’s Move\n", file=file_output), print("Round :", str(x) + 5*"\t" + "Grid Size:", str(len(martix1))+"x"+str(len(martix1))+ "\n", file=file_output)
        print("Player1’s Move\n"), print("Round :", str(x) + 5 * "\t" + "Grid Size:",str(len(martix1)) + "x" + str(len(martix1)) + "\n")
        mat_1(0)
        print("\nEnter your move:", str(player1move[y]) + "\n", file=file_output), print("\nEnter your move:", str(player1move[y]) + "\n"), attack1(y)
        print("Player2’s Move\n", file=file_output), print("Round :", str(x) + 5*"\t" + "Grid Size:", str(len(martix1))+"x"+str(len(martix1))+ "\n", file=file_output)
        print("Player2’s Move\n"), print("Round :", str(x) + 5 * "\t" + "Grid Size:",str(len(martix1)) + "x" + str(len(martix1)) + "\n")
        mat_1(0)
        print("\nEnter your move:", str(player2move[y]) + "\n", file=file_output), print("\nEnter your move:", str(player2move[y]) + "\n"), attack2(y)
        x += 1
        y += 1
game()
file_output.close()
