import matplotlib.pyplot as plt


def imp_data(path):
    with open(path) as data:
        zestaw = {}
        everything = int(data.readline()) + int(data.readline())

        rest = data.readlines()
        help = {}
        listt = [everything]
        for x in rest:
            x = x.strip("\n")
            if not x.isdigit():
                counter = 0
                help.clear()
            else:
                if counter == 1:
                    help["tree"] = int(x)
                if counter == 2:
                    help["fire"] = int(x)
                if counter == 3:
                    help["none"] = int(x)
                    listt.append(help.copy())
            counter += 1
        #print(listt)
    return listt







if __name__ == "__main__":
    data = imp_data("../../resource/Zapis3.txt")
    number = data[0]
    tree = []
    fire = []
    none = []
    ratio = []
    for num, x in enumerate(data):
        if not num == 0:
            tree.append(x["tree"]/number)
            fire.append(x["fire"]/number)
            none.append(x["none"]/number)
            if(x["tree"]+x["fire"] == 0):
                ratio.append(0)
            else:
                ratio.append(x["fire"]/(x["tree"]+x["fire"]))
    plt.figure(figsize=(16, 4))
    plt.subplot(141)
    plt.title("Ile jest % nie palących się drzew")
    plt.plot(tree)
    plt.subplot(142)
    plt.title("Ile jest % palących się drzew")
    plt.plot(fire, "r")
    plt.subplot(143)
    plt.title("Jaki % pól jest pustych")
    plt.plot(none, "k")
    plt.subplot(144)
    plt.title("Ile % drzew jest palących się")
    plt.plot(ratio)
    plt.show()


