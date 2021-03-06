def removeEmpty(L):
    while "" in L:
        L.remove("")
    while [] in L:
        L.remove([])
    while [""] in L:
        L.remove([""])
    return L

f = open("CatchingPokemonIN.txt", "r").read().split("\n")[:-1]

#print f

group = []
processedList = []

for i in f:
    currentEl1 = i.split(" ")
    if (len(currentEl1) == 1):
        #print "group: " + str(group)
        processedList.append(group);
        group = []
    #print "currentEL1: " + str(currentEl1)
    group.append(currentEl1)

processedList.append(group)

processedList = removeEmpty(processedList[1:])

def processCase(f):
    numPokemon = int(f[0][0])

    f = removeEmpty(f[1:])
    #print f

    probTable = []

    for i in f:
        result = []
        for el in i:
            result.append(float(el))
        probTable.append(result)

    prob = 1.0

    for i in range(0, numPokemon):
        currentMax = 0.0
        maxRow = []
        for j in probTable:
            if j[i] > currentMax:
                currentMax = j[i]
                maxRow = j
        prob = prob * currentMax
        probTable.remove(maxRow)
    print str("%.3f" % prob)

for i in processedList:
    processCase(i)
