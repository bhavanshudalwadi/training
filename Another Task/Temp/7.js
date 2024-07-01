class Blog {
    constructor() {
        this.posts = [];
    }

    addPost(title, content) {
        this.posts.push({ title, content, date: new Date() });
    }

    getPosts() {
        return this.posts;
    }
}

const myBlog = new Blog();

myBlog.addPost("First Post", "This is the content of the first post.");
myBlog.addPost("Second Post", "This is the content of the second post.");

const allPosts = myBlog.getPosts();
console.log(allPosts);