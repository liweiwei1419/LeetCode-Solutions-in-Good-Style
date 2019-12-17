class Solution:
    def simplifyPath(self, path: str) -> str:
        paths = path.split('/')
        stack = []
        for p in paths:
            if p not in ['', '.', '..']:
                # 表示目录字符串
                stack.append(p)
            if stack and '..' == p:
                stack.pop()
        if not stack:
            # 如果栈为空，直接返回 '/'
            return '/'
        return '/' + '/'.join(stack)


if __name__ == '__main__':
    path = "/home//foo/"
    solution = Solution()
    res = solution.simplifyPath(path)
    print(res)
