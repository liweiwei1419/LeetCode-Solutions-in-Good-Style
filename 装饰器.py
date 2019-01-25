def new_tips(argv):
    def tips(func):
        def nei(a, b):
            print('start {} {}'.format(argv, func.__name__))
            func(a, b)
            print('stop')

        return nei

    return tips


@new_tips('add123')
def add(a, b):
    print(a + b)


@new_tips('sub123')
def sub(a, b):
    print(a - b)


add(4, 5)
sub(8, 5)
