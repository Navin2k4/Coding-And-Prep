def find_max_sum(nums):
    current_sum = 0
    max_sum = float('-inf')

    for num in nums:
        current_sum = max(num, current_sum + num)
        max_sum = max(current_sum, max_sum)

    return max_sum


def find_max_sum_subarray(nums):
    current_sum = 0
    max_sum = float('-inf')
    start = end = temp_start = 0

    for i in range(len(nums)):
        current_sum += nums[i]

        if current_sum > max_sum:
            max_sum = current_sum
            start = temp_start
            end = i

        if current_sum < 0:
            current_sum = 0
            temp_start = i + 1

    return max_sum, nums[start:end + 1], (start, end)

print(find_max_sum([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
print(find_max_sum_subarray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))