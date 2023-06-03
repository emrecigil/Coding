import sys

base_number = int(sys.argv[1])
power_number = int(sys.argv[2])
result = base_number ** power_number

input_data = "Output : {}^{} = {}".format(base_number, power_number, result)


def sum_of_digits(value):
    global input_data
    sum1 = 0
    sum2 = 0
    sum3 = 0
    sum4 = 0
    sum5 = 0
    digit1 = ""
    digit2 = ""
    digit3 = ""
    digit4 = ""
    digit5 = ""
    if value > 9:
        for i in str(value):
            digit1 = " + ".join(str(value))
            sum1 = int(i) + sum1
        data1 = " = {} = {}".format(digit1,sum1)
        input_data = input_data + data1

        if sum1 > 9:
            for j in str(sum1):
                digit2 = " + ".join(str(sum1))
                sum2 = int(j) + sum2
            data2 = " = {} = {}".format(digit2,sum2)
            input_data = input_data + data2

            if sum2 > 9:
                for k in str(sum2):
                    digit3 = " + ".join(str(sum2))
                    sum3 = int(k) + sum3
                data3 = " = {} = {}".format(digit3, sum3)
                input_data = input_data + data3

                if sum3 > 9:
                    for e in str(sum3):
                        digit4 = " + ".join(str(sum3))
                        sum4 = int(e) + sum4
                    data4 = " = {} = {}".format(digit4, sum4)
                    input_data = input_data + data4

                    if sum4 > 9:
                        for e in str(sum3):
                            digit5 = " + ".join(str(sum4))
                            sum5 = int(e) + sum5
                        data5 = " = {} = {}".format(digit5, sum5)
                        input_data = input_data + data5
    else:
        data6 = " = {} + 0 = {}".format(value,value)
        input_data = input_data + data6

    return input_data
print(sum_of_digits(result))
