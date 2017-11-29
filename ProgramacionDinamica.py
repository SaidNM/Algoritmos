def fibonacci():
    opc= int (input("Introduce n: "))
    fb = [1,1]
    for i in range (2,opc):
        fb.append(fb[i-1]+fb[i-2])

    for j in fb:
        if(opc==1):
            print(str(j)+" ", end="")
            break
        else:
            print(str(j)+" ", end="")

def pascal():
    nivel = int(input("Introduce el nivel n"))
    tp=[]

    for i in range(0,nivel):
        tp.insert(i,[])
        for j in range(0,i+1):
            if(j==0 or j==i):
                tp[i].insert(j,1);
            else:
                tp[i].append(tp[i-1][j-1]+tp[i-1][j])
    imprimir(tp)

def imprimir(tp):
    for h in tp:
        for i in h:
            print(str(i)+" ",end = "")
        print("")

def main ():
    repetir=True;
    while(repetir):
        opc = int(input("Introduce 0 para Fibonacci | 1 para Triangulo de Pascal: "))

        if(opc==0):
            fibonacci()
        elif(opc==1):
            pascal()
        else:
            continue;
        rep = input("\nRepetir? S/N: ")

        if(rep=='N' or rep=='n'):
            repetir = False

main()