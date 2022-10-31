// 766. Toeplitz Matrix
// https://leetcode.com/problems/toeplitz-matrix/

func isToeplitzMatrix(matrix [][]int) bool {
	row := len(matrix)
	col := len(matrix[0])

	for i := 0; i < row-1; i++ {
		for j := 0; j < col-1; j++ {
			if matrix[i][j] != matrix[i+1][j+1] {
				return false
			}
		}
	}

	return true
}