#!/usr/bin/env python
# coding: utf-8

# In[12]:


def hanoi(n,right,middle,left):
    if n == 1:
        print("Move disk 1 from {} to destination {}.".format(right,left))
        return
    hanoi(n-1,right,left,middle)
    print("Move disk {} from {} to destination {}".format(n,right,left))
    hanoi(n-1,middle,right,left)

hanoi(4,'A','B','C')


# In[ ]:




