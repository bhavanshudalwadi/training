class TreeNode {
    constructor(name, isFile = false) {
        this.name = name;
        this.isFile = isFile;
        this.children = {};
    }
}

class FileSystem {
    constructor() {
        this.root = new TreeNode("root");
    }

    // Create a new file or directory
    create(path, isFile = false) {
        const parts = path.split('/');
        let current = this.root;

        for (const part of parts) {
            if (!current.children[part]) {
                current.children[part] = new TreeNode(part, isFile);
            }

            current = current.children[part];
        }

        console.log(`${isFile ? 'File' : 'Directory'} created: ${path}`);
    }

    // List the contents of a directory
    list(path) {
        const parts = path.split('/');
        let current = this.root;

        for (const part of parts) {
            if (!current.children[part]) {
                console.log(`Path not found: ${path}`);
                return;
            }

            current = current.children[part];
        }

        if (current.isFile) {
            console.log(`${path} is a file.`);
        } else {
            console.log(`Contents of ${path}:`);
            for (const child in current.children) {
                console.log(child);
            }
        }
    }
}

// Example usage:

const fileSystem = new FileSystem();

fileSystem.create("root/documents", false);
fileSystem.create("root/pictures", false);
fileSystem.create("root/documents/report.txt", true);

fileSystem.list("root");
fileSystem.list("root/documents");
fileSystem.list("root/documents/report.txt");
fileSystem.list("root/videos"); // Nonexistent path
