# https://adventofcode.com/2020/day/24


inputFile = '/home/gurkburk/git/AdventOfCode2020/src/main/input/input_24.txt'

def jump(d, xy):
    match d:
        case "ne": 
            return (xy[0],xy[1]+1)
        case "e": 
            return (xy[0]+1,xy[1])
        case "se": 
            return (xy[0]+1,xy[1]-1)
        case "sw": 
            return (xy[0],xy[1]-1)
        case "w": 
            return (xy[0]-1,xy[1])
        case "nw": 
            return (xy[0]-1,xy[1]+1)
    
def count_black(d):
    c=0
    for v in d.values():
        if v:
            c+=1;
    return c


hexfloor = {}
with open(inputFile) as input:

    for line in input:
        line=line.strip()
        pos = 0
        tile = (0,0)
        l=len(line)-1
        print(line)
        
        while pos <= l:
            d = line[pos] 
            if d == 'e' or d == 'w':
                pos += 1
            else:
                d+= line[pos+1]
                pos += 2
            tile = jump(d,tile)
        
        if tile in hexfloor:
            hexfloor[tile] = not hexfloor[tile] #(byt färg) black = true
        else:
            hexfloor[tile] = True;
        
    
print("Del 1: Antal svarta:", count_black(hexfloor))


def flippFloor(d):
    d_nextDay = {}
    
    def countBlackNeighbour(xy, d_old):
        count = 0
        ne = [(xy[0],xy[1]+1), (xy[0]+1,xy[1]), (xy[0]+1,xy[1]-1), (xy[0],xy[1]-1), (xy[0]-1,xy[1]), (xy[0]-1,xy[1]+1)]
        
        for n in ne:
            if n in d:
                if d(n): count +=1
            else:
                d_nextDay[n] = False
        return count 

    for tile in d:
        c = countBlackNeighbour(tile,d)
        if (d[tile]):
            #black
            if c==0 or c>2:
                d_nextDay[tile] = False #flipped to white
            else:
                d_nextDay[tile] = True #stay black
        else:
            #white
            if c==2:
                d_nextDay[tile] = True #flipped to black
            else:
                d_nextDay[tile] = True #stay white

    d = d_nextDay        

for i in range(10):
    flippFloor(d)
    print("Day ",i, count_black(d))


# if __name__ == "__main__":
#     day01PartOne()
#     day01PartTwo()

