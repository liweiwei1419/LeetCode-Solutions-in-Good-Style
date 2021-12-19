class Solution:
    def minimumMoves(self, arr: List[int]) -> int:
        if not arr:
            return 0
        n = len(arr)
        dp = [[0 for i in range(n)] for j in range(n)]
        for j in range(0,n):
            for i in range(j,-1,-1):
                if i==j:
                    dp[i][j] = 1
                elif i+1==j and arr[i]==arr[j]:
                    dp[i][j] = 1
                elif i+1==j and arr[i]!=arr[j]:
                    dp[i][j] = 2
                else:
                    if arr[i]==arr[j]:
                        dp[i][j] = dp[i+1][j-1]
                    else:
                        for k in range(i,j):
                            dp[i][j] = min(dp[i][j],dp[i][k]+dp[k+1][j])
        return dp[0][-1]