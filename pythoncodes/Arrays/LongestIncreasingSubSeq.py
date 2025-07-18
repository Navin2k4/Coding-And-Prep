def lower_bound(arr, target):
    left, right = 0, len(arr)
    while left < right:
        mid = (left + right) // 2
        if arr[mid] < target:
            left = mid + 1
        else:
            right = mid  
    return left  

def length_of_lis(nums):
    sub = []
    for num in nums:
        i = lower_bound(sub, num)
        if i == len(sub):
            sub.append(num)
        else:
            sub[i] = num
    return len(sub)


nums = [10, 9, 2, 5, 3, 7, 101, 18]
print(length_of_lis(nums))