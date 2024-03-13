n = int(input())
if n<99:
	print(99)
elif n%100 < 49:
	print(n - n%100 - 1)
else:
	print(n + 99 - (n%100))