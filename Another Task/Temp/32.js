function hungarianAlgorithm(costMatrix) {
    const rows = costMatrix.length;
    const cols = costMatrix[0].length;

    const labelByWorker = new Array(rows).fill(0);
    const labelByJob = new Array(cols).fill(0);
    const minSlackWorker = new Array(cols).fill(0);
    const minSlackValue = new Array(cols).fill(Infinity);
    const parentWorkerByCommittedJob = new Array(cols).fill(-1);

    const committedWorkers = new Array(rows).fill(false);
    const coveredJobs = new Array(cols).fill(false);

    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            if (costMatrix[i][j] < minSlackValue[j]) {
                minSlackValue[j] = costMatrix[i][j];
                minSlackWorker[j] = i;
            }
        }
    }

    for (let j = 0; j < cols; j++) {
        labelByJob[j] = minSlackValue[j];
    }

    let maxMatched = 0;

    for (let w = 0; w < rows; w++) {
        committedWorkers.fill(false);
        coveredJobs.fill(false);
        let j = -1;
        let i = w;

        while (true) {
            j = -1;

            for (let j1 = 0; j1 < cols; j1++) {
                if (!committedWorkers[j1] && (j === -1 || minSlackValue[j1] < minSlackValue[j])) {
                    j = j1;
                }
            }

            committedWorkers[i] = true;

            for (let i1 = 0; i1 < rows; i1++) {
                if (!coveredJobs[i1] && costMatrix[i1][j] - labelByWorker[i1] - labelByJob[j] < minSlackValue[j]) {
                    minSlackValue[j] = costMatrix[i1][j] - labelByWorker[i1] - labelByJob[j];
                    minSlackWorker[j] = i1;
                }
            }

            i = parentWorkerByCommittedJob[j];

            if (i === -1) {
                break;
            }
            committedWorkers[i] = true;

            for (let j1 = 0; j1 < cols; j1++) {
                if (!coveredJobs[j1] && costMatrix[i][j1] - labelByWorker[i] - labelByJob[j1] < minSlackValue[j1]) {
                    minSlackValue[j1] = costMatrix[i][j1] - labelByWorker[i] - labelByJob[j1];
                    minSlackWorker[j1] = i;
                }
            }
        }

        while (true) {
            if (j === -1) {
                break;
            }

            const i1 = minSlackWorker[j];
            const j1 = j;

            j = parentWorkerByCommittedJob[j1];
            parentWorkerByCommittedJob[j1] = i1;

            const i = j;

            for (let j1 = 0; j1 < cols; j1++) {
                labelByJob[j1] += minSlackValue[j1];
            }

            labelByWorker[i] += minSlackValue[j];

            committedWorkers[i] = true;
            coveredJobs[j1] = true;
        }

        maxMatched++;
    }

    return maxMatched;
}

const costMatrix = [
    [5, 3, 7],
    [5, 8, 6],
    [6, 2, 8]
];

console.log(hungarianAlgorithm(costMatrix));
