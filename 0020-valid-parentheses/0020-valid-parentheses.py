# AI-assisted archived practice solution
class Solution:
    def isValid(self, s):
        stack = []
        pairs = {')':'(', ']':'[', '}':'{'}
        for c in s:
            if c in pairs:
                if not stack or stack.pop() != pairs[c]:
                    return False
            else:
                stack.append(c)
        return not stack
