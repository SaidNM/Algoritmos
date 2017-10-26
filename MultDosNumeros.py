def mult1(u, v):
    n = maximo(tam(u), tam(v))
    if n < 2:
        return u * v
    else:
        s = int(n / 2)
        w = int(u / (10 ** s))
        x = int(u % (10 ** s))
        y = int(v / (10 ** s))
        z = int(v % (10 ** s))
    return (mult1(w, y) * (10 ** (2 * s))) + ((mult1(w, z) + mult1(x, y)) * (10 ** s)) + mult1(x, z)


def mult2(u, v):
    n = maximo(tam(u), tam(v))
    if n < 2:
        return u * v
    else:
        s = int(n / 2)
        w = int(u / (10 ** s))
        x = int(u % (10 ** s))
        y = int(v / (10 ** s))
        z = int(v % (10 ** s))
        r = mult2(w + x, y + z)
        p = mult2(w, y)
        q = mult2(x, z)
    return (p * (10 ** (2 * s))) + ((r - p - q) * (10 ** s)) + q


def mult3(x, y, tamx, tamy):
    if (tamx < 3 or tamy < 3):
        return x * y
    else:
        IX = Divide(x, 0)
        CX = Divide(x, 1)
        DX = Divide(x, 2)
        IY = Divide(y, 0)
        CY = Divide(y, 1)
        DY = Divide(y, 2)

        pot1 = 10 ** (tamx - int(tamx / 3) + tamy - int(tamy / 3))
        pot2 = 10 ** (tamx + tamy - int(tamx / 3) - 2 * int(tamy / 3))
        pot3 = 10 ** (tamx - int(tamx / 3))
        pot4 = 10 ** (tamx + tamy - int(tamy / 3) - 2 * int(tamx / 3))
        pot5 = 10 ** (tamx + tamy - 2 * int(tamx / 3 + int(tamy / 3)))
        pot6 = 10 ** (tamx - 2 * int(tamx / 3))
        pot7 = 10 ** (tamy - int(tamy / 3))
        pot8 = 10 ** (tamy - 2 * int(tamy / 3))


        mul1 = mult3(IX, IY, len(str(IX)), len(str(IY)))
        mul2 = mult3(IX, CY, len(str(IX)), len(str(CY)))
        mul3 = mult3(IX, DY, len(str(IX)), len(str(DY)))
        mul4 = mult3(CX, IY, len(str(CX)), len(str(IY)))
        mul5 = mult3(CX, CY, len(str(CX)), len(str(CY)))
        mul6 = mult3(CX, DY, len(str(CX)), len(str(DY)))
        mul7 = mult3(DX, IY, len(str(DX)), len(str(IY)))
        mul8 = mult3(DX, CY, len(str(DX)), len(str(CY)))
        mul9 = mult3(DX, DY, len(str(DX)), len(str(DY)))



    return pot1 * mul1 + pot2 * mul2 + pot3 * mul3 + pot4 * mul4 + pot5 * mul5 + pot6 * mul6 + pot7 * mul7 + pot8 * mul8 + mul9


def Divide(n, pos):
    num = str(n)
    lnum = len(num)
    i = int(lnum/3)
    j = 2 * i
    if (pos == 0):
        num_aux = num[:i]
    elif (pos == 1):
        num_aux = num[i:j]
    else:
        num_aux = num[j:]

    return int(num_aux)


def maximo(t1, t2):
    if t1 >= t2:
        return t1
    else:
        return t2


def tam(n):
    tama = 0
    while n > 0:
        n = int(n / 10)
        tama += 1
    return tama


repetir=True;
while(repetir):
    n1 = int(input("Introduce el primer número a multiplicar: "))
    n2 = int(input("Introduce el segundo número a multiplicar: "))

    opc = int(input("Introduce 0 para mult DyV | 1 para mult Gauss| 2 para mult DyV en tercios: "))

    if(opc==0):
        print("Resultado: " + str(mult1(n1,n2)))
    elif(opc==1):
        print("Resultado: " + str(mult2(n1,n2)))
    elif(opc==2):
        print("Resultado: "+ str(mult3(n1,n2,len(str(n1)), len(str(n2)))))
    rep = input("Repetir? S/N: ")

    if(rep=='N' or rep=='n'):
        repetir = False


#meter primero el numero mas pequeño 