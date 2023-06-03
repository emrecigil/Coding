                            #Emre Çiğil 2210356033
def create():
    if input_list[1::] in total_patients:
        print("Patient " + input_list[1] + " cannot be recorded due to duplication.", file=file_output)
    else:
        input_list[2] = str(str("{:.2%}".format(float(input_list[2]))))
        input_list[6] = str(str(int(100 * float(input_list[6]))) + "%")
        total_patients.append(input_list[1::])                                    # ı check the patients,then if patient in not in
        print("Patient " + input_list[1] + " is recorded.", file=file_output)     # total_patient ı added him/her.


def remove():
    x = 0
    for i in range(len(total_patients)):
        x += 1
        if input_list[1] == total_patients[i][0]:                   # ı check the patient name for removing by input_list and total_patient list.
            total_patients.remove(total_patients[i])                # ı used x for loop don't come back when searching is finish.
            print("Patient " + input_list[1]+" is removed.", file=file_output)
            break
        elif x == len(total_patients):
            print("Patient " + input_list[1]+"  cannot be removed due to absence.", file=file_output)


def show_list():
    print("Patient Diagnosis   Disease         Disease     Treatment       Treatment", file=file_output)
    print("Name    Accuracy    Name            Incidence   Name            Risk", file=file_output)
    for i in range(72):
        print("-", end="", file=file_output)
        if i == 71:                                     # ı created code to design of list in output file, such as length of "-"
            print("-", sep="\n", file=file_output)
    for i in range(len(total_patients)):
        for a in total_patients[i]:
            if a == total_patients[i][0]:
                space = 8 - len(a)                     # ı set distance between elements when ı used list command.
            elif a == total_patients[i][1]:             # it can seem confused but this code sequence is very useful
                space = 12 - len(a)
            elif a == total_patients[i][2]:
                space = 16 - len(a)
            elif a == total_patients[i][3]:
                space = 12 - len(a)
            elif a == total_patients[i][4]:
                space = 16 - len(a)
            elif a == total_patients[i][5]:
                space = 8 - len(a)
            print(a, end=space*" ", file=file_output)
        print(sep="\n", file=file_output)


def recommendation():
    x = 0
    for i in range(len(total_patients)):
        x += 1
        if input_list[1] == total_patients[i][0]:
            a = float((total_patients[i][3][0:2])) / float((total_patients[i][3][3::]))
            d = float(total_patients[i][1][0:4])/100
            b = 100000 * a                                         # ı get information about patients from total_patients list
            c = 100000 - b                                          # ı calculated fp and ı give a name. its name final_value
            final_value = (100*(b / (c * (1 - d) + b)))             # ı printed result according to final_value and treatment risk and i gave suggest.
            if final_value > float(total_patients[i][5][0:-1]):
                print("System suggests " + input_list[1]+" to have the treatment.", file=file_output)
            else:
                print("System suggests " + input_list[1]+" NOT to have the treatment.", file=file_output)
            break
        elif x == len(total_patients):
            print("Recommendation for " + input_list[1] + " cannot be calculated due to absence.", file=file_output)


def probability():
    x = 0
    for i in range(len(total_patients)):
        x += 1
        if input_list[1] == total_patients[i][0]:
            a = float((total_patients[i][3][0:2]))/float((total_patients[i][3][3::]))
            d = float(total_patients[i][1][0:-1])/100                           # ı get information about patients from total_patients list
            b = 100000*a                                                    # again ı calculated fp and ı give a name. its name final_value
            c = 100000-b                                                 # ı printed that disease exist or not according to final_value
            final_value = str((100*(b/(c*(1-d)+b))))
            if final_value[3] and final_value[4] == "0":
                final_value = final_value[0:2]
            else:
                final_value = final_value[0:5]
            print("Patient " + input_list[1] + " has a probability of " + final_value +
                  "% of having "+total_patients[i][2].lower()+".", file=file_output)
            break
        elif x == len(total_patients):
            print("Probability for " + input_list[1] + " cannot be calculated due to absence.", file=file_output)


file_input = open("doctors_aid_inputs.txt", "r", encoding="UTF-8")          # ı created input func named file_input.
file_output = open("doctors_aid_outputs.txt", "w", encoding="UTF-8")        # ı created output func named file_output.
total_patients = []                                     # ı created permanent list named total_patient to keep patient's information
for line in file_input:           # list1 was created to assemble element of cancer and cancer type.
    line = line.rstrip("\n")
    input_list = line.split(", ")
    input_list[0:1] = input_list[0].split(" ")  # ı created temporary list named input_list to keep patient's information in order
    if input_list[0] == "create":               # ı used 7 function:create,remove,list,probability,recommendation,input,output
        create()                                # ı used output function in a different type, it seems "file=file_output" in end of the print command
    elif input_list[0] == "remove":
        remove()                                        # I created functions and commands according to the first
    elif input_list[0] == "list":                       # of the received inputs.
        show_list()
    elif input_list[0] == "probability":
        probability()
    elif input_list[0] == "recommendation":
        recommendation()
file_input.close()
file_output.close()
