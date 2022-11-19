import string
from typing import List, Optional


class Trie:
    end_of_word: bool
    children: List[Optional['Trie']]

    def __init__(self) -> None:
        self.end_of_word = False
        self.children = [None] * 26

    def insert(self, word: str):
        """Adds a new word to the trie"""
        current: 'Trie' = self

        for (char) in word:
            index = string.ascii_lowercase.index(char)
            if current.children[index] is None:
                current.children[index] = Trie()

            current = current.children[index]

        current.end_of_word = True

    def search(self, word: str) -> bool:
        "Returns true if the trie contains the word"
        current: 'Trie' = self

        for (char) in word:
            index = string.ascii_lowercase.index(char)
            if current.children[index] is None:
                return False
            current = current.children[index]

        return current.end_of_word

    def starts_with(self, prefix: str) -> bool:
        """Returns all the words in the trie that start with the prefix"""
        current: 'Trie' = self

        for (char) in (prefix):
            index = string.ascii_lowercase.index(char)
            if current.children[index] is None:
                return False
            current = current.children[index]

        return True

# Tests


trie = Trie()

trie.insert("anthem")
trie.insert("drain")
trie.insert("trip")
trie.insert("tribute")
assert trie.starts_with('tr') is True
assert trie.search('drain') is True
assert trie.search('train') is False
