package trees

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func NewTreeNode(i int) *TreeNode {
	return &TreeNode{Val: i, Left: nil, Right: nil}
}

// ========== Tree Implementation ===============

type BinarySearchTree struct {
	Head *TreeNode
}

func (t *BinarySearchTree) Insert(i int) {
	t.Head = insert(i, t.Head)
}

func (t *BinarySearchTree) Find(i int) *TreeNode {
	return find(i, t.Head)
}

func (t *BinarySearchTree) Min(i int) *TreeNode {
	node := t.Head
	for node.Left != nil {
		node = node.Left
	}
	return node
}

func (t *BinarySearchTree) Max(i int) *TreeNode {
	node := t.Head
	for node.Right != nil {
		node = node.Right
	}
	return node
}

func (t *BinarySearchTree) MaxHeight(i int) int {
	return maxHeight(t.Head)
}

func (t *BinarySearchTree) MinHeight(i int) int {
	return minHeight(t.Head)
}

func (t *BinarySearchTree) Remove(i int) {
	t.Head = deleteNode(i, t.Head)
}

func (t *BinarySearchTree) PreOrder() []int {
	result := make([]int, 0)
	preOrder(t.Head, &result)
	return result
}

func (t *BinarySearchTree) InOrder() []int {
	result := make([]int, 0)
	inOrder(t.Head, &result)
	return result
}

func (t *BinarySearchTree) PostOrder() []int {
	result := make([]int, 0)
	postOrder(t.Head, &result)
	return result
}

func (t *BinarySearchTree) LevelOrder() []int {
	result := make([]int, 0)
	node := t.Head
	stack := []*TreeNode{node}
	for len(stack) > 0 {
		node = stack[0]
		stack = stack[1:]
		result = append(result, node.Val)
		if node.Left != nil {
			stack = append(stack, node.Left)
		}
		if node.Right != nil {
			stack = append(stack, node.Right)
		}
	}
	return result
}

// ========= Utility functions

func insert(i int, node *TreeNode) *TreeNode {
	if node == nil {
		return NewTreeNode(i)
	} else if node.Val > i {
		node.Left = insert(i, node.Left)
		return node
	} else {
		node.Right = insert(i, node.Right)
		return node
	}
}

func find(i int, node *TreeNode) *TreeNode {
	if node == nil {
		return nil
	} else if node.Val == i {
		return node
	} else if node.Val > i {
		return find(i, node.Left)
	} else {
		return find(i, node.Right)
	}
}

func maxHeight(node *TreeNode) int {
	if node == nil {
		return 0
	}
	left := 1 + maxHeight(node.Left)
	right := 1 + maxHeight(node.Right)
	if left > right {
		return left
	}
	return right
}

func minHeight(node *TreeNode) int {
	if node == nil {
		return 0
	}
	left := 1 + maxHeight(node.Left)
	right := 1 + maxHeight(node.Right)
	if left < right {
		return left
	}
	return right
}

func deleteNode(i int, node *TreeNode) *TreeNode {
	if node == nil {
		return nil
	}
	if node.Val > i {
		node.Right = deleteNode(i, node.Right)
		return node
	} else if node.Val < i {
		node.Left = deleteNode(i, node.Left)
		return node
	} else if node.Val == i {
		if node.Left != nil && node.Right != nil {
			// Get min at right
			minNode := node.Right
			for minNode.Left != nil {
				minNode = minNode.Left
			}
			// delete it
			node.Right = deleteNode(minNode.Val, node.Right)
			// replace current node with min node
			node.Val = minNode.Val
			return node
		} else if node.Right != nil {
			return node.Right
		} else if node.Left != nil {
			return node.Left
		}
	}
	return nil
}

func preOrder(node *TreeNode, result *[]int) {
	if node == nil {
		return
	}
	*result = append(*result, node.Val)
	preOrder(node.Left, result)
	preOrder(node.Right, result)
}

func inOrder(node *TreeNode, result *[]int) {
	if node == nil {
		return
	}
	inOrder(node.Left, result)
	*result = append(*result, node.Val)
	inOrder(node.Right, result)
}

func postOrder(node *TreeNode, result *[]int) {
	if node == nil {
		return
	}
	postOrder(node.Left, result)
	postOrder(node.Right, result)
	*result = append(*result, node.Val)
}
