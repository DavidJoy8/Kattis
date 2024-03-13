from heapq import heappop, heappush

SHAMAN, TITAN = 10**12, 10**15

villages, paths, start, end = map(int, input().split(" "))
villages += 1 #they use 1 based indexing
distances = [[-1]*villages for _ in range(villages)]
#read in paths:
for _ in range(paths):
    a, b, dist, enemy = map(int, input().split(" "))
    if enemy==1:
        dist += SHAMAN
    if enemy==2:
        dist += TITAN
    distances[a][b] = dist
    distances[b][a] = dist

heap = [(0, start)]
visited = set()
while heap:
    cost, city = heappop(heap)
    if city is end:
        titans = cost//TITAN
        cost %= TITAN
        shamans = cost//SHAMAN
        cost %= SHAMAN
        print(cost, shamans, titans)
        exit()
    if city in visited:
        continue
    visited.add(city)
    for neighbor, dist in enumerate(distances[city]):
        if dist!=-1 and neighbor not in visited:
            heappush(heap, (cost+dist, neighbor))
print("IMPOSSIBLE")
