import sys
try:
    check1 = sys.argv[1]
    check2 = sys.argv[2]
    try:
        operand = open(check1, "r", encoding="UTF-8")
        try:
            comparison = open(check2, "r", encoding="UTF-8")
            for i in operand:
                line1 = i
                line1 = line1.rstrip("\n")
                line1 = line1.split(" ")
                line2 = comparison.readline()
                line2 = line2.rstrip("\n")
                line2 = line2.split(" ")
                try:
                    for r in range(len(line1)):
                        if '.' in line1[r]:
                            if float(line1[r]) % 1 >= 0.5:
                                line1[r] = int(float(line1[r])) + 1
                            else:
                                line1[r] = int(float(line1[r]))
                        else:
                            line1[r] = int(float(line1[r]))
                    number1 = line1[0]
                    number2 = line1[1]
                    number3 = line1[2]
                    number4 = line1[3]
                    check_list = []
                    try:
                        for k in range(number3, number4+1):
                            if k % number1 == 0 and k % number2 != 0:
                                check_list.append(str(k))
                        try:
                            assert check_list == line2
                            print(12*"-")
                            print("My result:           ", *check_list)
                            print("Results to compare:  ", *line2)
                            print("Gool!!!")
                        except AssertionError:
                            print(12 * "-")
                            print("My result:           ", *check_list,'\n'+"Results to compare:  ", *line2,'\n'+"AssertionError: results don’t match.")
                    except ZeroDivisionError:
                        print(12 * "-",'\n', "ZeroDivisionError: You can’t divide by 0.", sep="")
                        print("Given input:", *line1)
                except IndexError:
                    print(12 * "-", '\n', "IndexError: number of operands less than expected.", sep="")
                    print("Given input:",*line1)
                except ValueError:
                    print(12 * "-", '\n', "ValueError: only numeric input is accepted.", sep="")
                    print("Given input:",*line1)
            operand.close()
            comparison.close()
        except IOError:
            print("IOError: cannot open {}.".format(check2))
    except IOError:
        print("IOError: cannot open {}.".format(check1))
except IndexError:
    print("IndexError: number of input files less than expected.")
finally:
    print('\n'+"˜ Game Over ˜")
