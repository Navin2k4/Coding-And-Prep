

// ! Problem 278

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// public class Solution extends VersionControl {
//     public int firstBadVersion(int n) {
//         int start = 1;
//         int end = n;
//         while (start <= end) {
//             int version = start + (end - start) / 2;
//             if (isBadVersion(version) == true && isBadVersion(version - 1) == false)
//                 return version;
//             else if (!isBadVersion(version))
//                 start = version + 1;
//             else
//                 end = version;
//         }
//         return -1;
//     }
// }