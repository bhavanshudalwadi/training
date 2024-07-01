var numRows = 10,
    triangle,
    start,
    stop;

function pascalRecursive(n, a) {

    if (n < 2) return a;

    var prevRow = a[a.length - 1];
    var curRow = [1];

    for (var i = 1; i < prevRow.length; i++) {
        curRow[i] = prevRow[i] + prevRow[i - 1];
    }
    curRow.push(1);
    a.push(curRow);

    return pascalRecursive(n - 1, a);
}


var triangle = pascalRecursive(numRows, [[1]]);

for (var i = 0; i < triangle.length; i++)
    console.log(triangle[i] + "\n");