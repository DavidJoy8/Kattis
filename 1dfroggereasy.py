n, s, m = map(int, input().split())
board = list(map(int, input().split()))
visited = [False]*len(board)
hops = 0
cur = s-1
while True:
	if cur<0:
		print(f'left\n{hops}')
		exit()
	if cur>=len(board):
		print(f'right\n{hops}')
		exit()
	if board[cur]==m:
		print(f'magic\n{hops}')
		exit()
	if visited[cur]:
		print(f'cycle\n{hops}')
		exit()
	visited[cur]=True
	cur += board[cur]
	hops += 1
