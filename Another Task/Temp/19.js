function solveNQueens(n) {
    const result = [];
    const board = Array.from({ length: n }, () => Array(n).fill('.'));

    function isSafe(row, col) {
        for (let i = 0; i < row; i++) {
            if (
                board[i][col] === 'Q' ||
                (col - (row - i) >= 0 && board[i][col - (row - i)] === 'Q') ||
                (col + (row - i) < n && board[i][col + (row - i)] === 'Q')
            ) {
                return false;
            }
        }
        return true;
    }

    function placeQueens(row) {
        if (row === n) {
            result.push(board.map(row => row.join('')));
            return;
        }

        for (let col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 'Q';
                placeQueens(row + 1);
                board[row][col] = '.';
            }
        }
    }

    placeQueens(0);
    return result;
}

const n = 4;
const solutions = solveNQueens(n);
console.log(solutions);