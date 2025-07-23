def next_greater_element(arr):
    n = len(arr)
    nge = [-1]*n
    stack = []
    for i in range (n-1, -1 , -1):
        num = arr[i]
        while stack and stack[-1] <= num:
            stack.pop()
        if stack:
            nge[i] = stack[-1]
        stack.append(num)
    return nge

arr = [4, 12, 1, 3, 5, 2, 3]
result = next_greater_element(arr)
print(result)