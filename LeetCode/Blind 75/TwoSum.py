class TwoSum():
    def two_sum(self, nums, target):
        value_idx_map = dict()
        for i, num in enumerate(nums):
            diff = target - num
            if diff in value_idx_map:
                return [value_idx_map[diff], i]
            value_idx_map[num] = i

        return [-1, -1]
