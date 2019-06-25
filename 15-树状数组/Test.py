if __name__ == '__main__':
    arr = [10, 15, 17, 19, 20, 14, 12]

    arr = [1, 2, 3, 4, 5, 6, 7]
    cumsum = [0] * len(arr)
    cumsum[0] = arr[0]
    for i in range(1, len(arr)):
        cumsum[i] = cumsum[i - 1] + arr[i]
    print(cumsum)
