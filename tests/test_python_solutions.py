"""Independent offline checks; no platform submission or judge verdict implied."""
import importlib.util
import itertools
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]

def solution(slug):
    spec = importlib.util.spec_from_file_location(slug.replace("-", "_"), ROOT / slug / (slug + ".py"))
    module = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(module)
    return module.Solution()

class PythonSolutionsTests(unittest.TestCase):
    def test_parentheses_against_pair_reduction(self):
        solver = solution("0020-valid-parentheses")
        for size in range(6):
            for characters in itertools.product("()[]{}", repeat=size):
                text = "".join(characters)
                reduced = text
                while True:
                    updated = reduced.replace("()", "").replace("[]", "").replace("{}", "")
                    if updated == reduced:
                        break
                    reduced = updated
                self.assertEqual(solver.isValid(text), reduced == "", text)

    def test_duplicates_against_pairwise_comparison(self):
        solver = solution("0217-contains-duplicate")
        for size in range(6):
            for values in itertools.product((-1, 0, 1), repeat=size):
                expected = any(values[i] == values[j] for i in range(size) for j in range(i + 1, size))
                self.assertEqual(solver.containsDuplicate(list(values)), expected, values)

    def test_anagrams_against_sorted_characters(self):
        solver = solution("0242-valid-anagram")
        words = ["".join(chars) for size in range(5) for chars in itertools.product("ab", repeat=size)]
        words += ["aab", "aba", "aaa", "rat", "car"]
        for first, second in itertools.product(words, repeat=2):
            self.assertEqual(solver.isAnagram(first, second), sorted(first) == sorted(second), (first, second))
