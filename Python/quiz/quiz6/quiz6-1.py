import sys

def ilk_kısım(n):
    diamond(0, 2*n-1, n-1, 1)


def diamond(bas, bit, orta, a):
    if bas < bit:
        if bas < orta:
            print(' ' * (orta - bas) + '*' * a)
            diamond(bas + 1, bit, orta, a + 2)
        else:
            print(' ' * (bas - orta) + '*' * a)
            diamond(bas + 1, bit, orta, a - 2)


ilk_kısım(int(sys.argv[1]))
