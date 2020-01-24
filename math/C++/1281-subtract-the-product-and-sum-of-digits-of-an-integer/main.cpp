#include <iostream>

using namespace std;

class Solution {
public:
    int subtractProductAndSum(int n) {
        if (n == 0) {
            return 0;
        }
        int mul = 1;
        int sum = 0;
        while (n) {
            mul *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return mul - sum;
    }
};

int main() {
    Solution solution = Solution();
    int n = 234;
    int res = solution.subtractProductAndSum(n);
    cout << res << endl;
    return 0;
}

