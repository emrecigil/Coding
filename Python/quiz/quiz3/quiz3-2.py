import sys
data_input = (sys.argv[1])
data_list = data_input.split(",")
list1 = []

for i in data_list:
    if i not in list1:
        list1.append(i)

def luckyNumbers(list1):
    reckon = 1
    testing = int(list1[reckon])
    while int(testing) < len(list1):

        del list1[testing-1::testing]

        if str(testing) in list1:
            reckon += 1
            testing = int(list1[reckon])
        else:
            testing = int(list1[reckon])

    list1 = [int(i) for i in list1]
    return list1

print(luckyNumbers(list1))
