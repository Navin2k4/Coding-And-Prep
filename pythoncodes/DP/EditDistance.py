def min_distance_rec(w1, w2, i, j):
    if i == 0:
        return j
    if j == 0:
        return i
    if w1[i - 1] == w2[j - 1]:
        return min_distance_rec(w1, w2, i - 1, j - 1)

    insert = 1 + min_distance_rec(w1, w2, i, j - 1)
    delete = 1 + min_distance_rec(w1, w2, i - 1, j)
    replace = 1 + min_distance_rec(w1, w2, i - 1, j - 1)
    return min(insert, delete, replace)


word1 = "horse"
word2 = "ros"
print(min_distance_rec(word1, word2, len(word1), len(word2)))
