import math


def square(x, a):
    return x ** 2 - a


def derivative(x):
    return 2 * x


def my_sqrt(a):
    x0 = 1
    eplison = 1e-16

    for _ in range(1000):
        last_x0 = x0
        x0 = x0 - square(x0, a) / derivative(x0)
        if abs(last_x0 - x0) < eplison:
            print("循环了 {} 次以后收敛。".format(_))
            break
    return x0


if __name__ == '__main__':
    res = math.sqrt(78)
    print(res)  # 8.831760866327848
    print(my_sqrt(78))
