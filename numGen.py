import random

numAGenerar = 250000
minNum = 1
# Ambos inclusive
maxNum = 250000
with open("TooManyNumbers.txt", "wt") as f:
    numeros_aleatorios = [random.randint(minNum, maxNum) for _ in range(numAGenerar)]

    numeros_como_cadena = ' '.join(map(str, numeros_aleatorios))

    f.write(numeros_como_cadena)