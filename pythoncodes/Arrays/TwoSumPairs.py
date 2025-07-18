nums = [1, 2, 3, 4, 5]
k = 6

seen = set()
pairs = set()

for num in nums:
    complement = k - num
    if complement in seen:
        pairs.add(tuple(sorted((num, complement))))
    seen.add(num)

print(pairs)
