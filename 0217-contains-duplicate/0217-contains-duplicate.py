# AI-assisted archived practice solution
class Solution:
    def containsDuplicate(self, nums):
        seen = set()
        for value in nums:
            if value in seen:
                return True
            seen.add(value)
        return False
