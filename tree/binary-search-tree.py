class Node:
    left: 'Node' = None
    right: 'Node' = None
    def __init__(self, value: int) -> None:
        self.value = value

class BinarySeachTree:
    def __init__(self, head: Node) -> None:
        self.head = head

    def __str__(self):
        def printTree(node: Node, level=0) -> list[str]:
            result = []
            if node != None:
                result.extend(printTree(node.right, level + 1))
                result.append(' ' * 4 * level + '-> ' + str(node.value))
                result.extend(printTree(node.left, level + 1))
            return result
        return '\n'.join(printTree(self.head))

    def insert(self, val: int):
        if not self.head:
            self.head = Node(val)
            return
        current = self.head
        while current:
            if current.value < val:
                if not current.right:
                    current.right = Node(val)
                    return
                current = current.right
            elif current.value > val:
                if not current.left:
                    current.left = Node(val)
                    return
                current = current.left
        
    def find(self, value: int) -> Node:
        if not self.head:
            return None
        current = self.head
        while current:
            if value > current.value:
                current = current.right
            elif value < current.value:
                current = current.left
            else:
                return current
        return None

    def min(self, node=None):
        if not node:
            node = self.head
        while node.left != None:
            node = node.left
        return node

    def max(self, node=None):
        if not node:
            node = self.head
        while node.right != None:
            node = node.right
        return node
    
    def delete(self, value):
        if not self.head:
            return
        # Find node
        # Remove
            #   - if node has no child, just remove
            #   - if node has one child, replace it with child
            #   - if node has two children. either:
            #     - replace with the minimum on the right
            #     - replace with the maximum on the left

        def deleteFromNode(value: int, node: Node):
            if value > node.value:
                node.right = deleteFromNode(value, node.right)
                return node
            elif value < node.value:
                node.left = deleteFromNode(value, node.left)
                return node
            else:
                if not node.left and not node.right:
                    return None
                elif node.left != None and not node.right:
                    return node.left
                elif node.right != None and not node.left:
                    return node.right
                else:
                    # Find min on right
                    # Delete
                    # replace
                    minRight = node.right
                    while minRight.left:
                        minRight = minRight.left
                    node.right = deleteFromNode(minRight.value, node.right)
                    node.value = minRight.value
                return node

        deleteFromNode(value, self.head)

    def maxHeight(self) -> int:
        current = self.head
        def height(node: Node) -> int:
            if not node:
                return -1
            maxVal = max(height(node.right), height(node.left))
            return maxVal + 1
        return height(current)

    def minHeight(self) -> int:
        def nodeHeight(node):
            if not node:
                return 0
            left = 1 + nodeHeight(node.left)
            right = 1 + nodeHeight(node.right)
            return min(left, right)
        return nodeHeight(self.head)

    def preOrder(self):
        def traverse(node: Node):
            result: list[int] = []
            if not node:
                return result
            result.append(node.value)
            result.extend(traverse(node.left))
            result.extend(traverse(node.right))
            return result

        return traverse(self.head)

    def inOrder(self):
        def traverse(node: Node):
            result: list[int] = []
            if not node:
                return result
            result.extend(traverse(node.left))
            result.append(node.value)
            result.extend(traverse(node.right))
            return result

        return traverse(self.head)

    def postOrder(self):
        def traverse(node: Node):
            result: list[int] = []
            if not node:
                return result
            result.extend(traverse(node.left))
            result.extend(traverse(node.right))
            result.append(node.value)
            return result

        return traverse(self.head)

    def levelOrder(self):
        queue = []
        result = []
        node = self.head
        while node:
            result.append(node.value)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
            node = None
            if len(queue) > 0:
                node = queue.pop(0)

        return result
