#include <iostream>
#include <vector>


using namespace std;


class Solution {
public:
    vector<int> transformArray(vector<int> &arr) {
        size_t size = arr.size();
        bool change = true;

        vector<int> tmp;

        while (change) {
            change = false;
            tmp = arr;

            for (int i = 1; i < size - 1; ++i) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    tmp[i]--;
                    change = true;
                }

                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    tmp[i]++;
                    change = true;
                }

            }

            arr = tmp;

        }
        return arr;
    }
};

