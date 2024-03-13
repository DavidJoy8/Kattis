single, double = set(), dict()
for _ in range(int(input())):
    instr = input()
    if " " in instr:
        double[instr.split(" ")[0]] = instr.split(" ")[1]
    else:
        single.add(instr)
for _ in range(int(input())):
    instr = input()
    if instr in single:
        print("Jebb")
    elif instr in double:
        print(f"Neibb en {instr} {double[instr]} er heima")
    else:
        print("Neibb")
