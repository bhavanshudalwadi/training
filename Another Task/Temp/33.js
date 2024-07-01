class BloomFilter {
    constructor(size, numHashFunctions) {
        this.size = size;
        this.numHashFunctions = numHashFunctions;
        this.bitArray = new Array(size).fill(false);
    }

    add(element) {
        for (let i = 0; i < this.numHashFunctions; i++) {
            const hash = this.getHash(element, i);
            this.bitArray[hash] = true;
        }
    }

    contains(element) {
        for (let i = 0; i < this.numHashFunctions; i++) {
            const hash = this.getHash(element, i);
            if (!this.bitArray[hash]) {
                return false;
            }
        }
        return true;
    }

    getHash(element, index) {
        const hash = (element + index).toString();
        let result = 0;
        for (let i = 0; i < hash.length; i++) {
            result = (result << 5) + hash.charCodeAt(i);
        }
        return Math.abs(result) % this.size;
    }
}

const bloomFilter = new BloomFilter(100, 3);

bloomFilter.add("apple");
bloomFilter.add("banana");
bloomFilter.add("orange");

console.log(bloomFilter.contains("apple"));
console.log(bloomFilter.contains("grape"));