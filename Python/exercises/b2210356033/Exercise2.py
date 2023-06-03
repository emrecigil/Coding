#!/usr/bin/env python
# coding: utf-8

# In[11]:


x = int(input("Enter a number from 1 to 7 that you want to find nth largest number:"))
def largest(x):
    My_list = [1000, 298, 3579, 100, 200, -45, 900] 
    My_list.sort()
    print("My sorted list=", My_list)
    My_list = My_list[-x:]
    print(My_list[0:1])
    print(My_list[0])
largest(x)


# In[ ]:




