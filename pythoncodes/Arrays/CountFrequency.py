from collections import Counter
nums = [1,2,2,3,4,5,6,7,7,7,8,8,8,9,9,10]
count = dict(Counter(nums))
print(count)