const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const PORT = process.env.PORT || 3000;

app.use(bodyParser.json());

const users = [];
const posts = [];

app.post('/users', (req, res) => {
    const { username, email } = req.body;
    const user = { id: users.length + 1, username, email };
    users.push(user);
    res.json(user);
});

app.get('/users', (req, res) => {
    res.json(users);
});

app.post('/posts', (req, res) => {
    const { userId, content } = req.body;
    const user = users.find(u => u.id === userId);
    if (!user) {
        return res.status(404).json({ error: 'User not found' });
    }
    const post = { id: posts.length + 1, userId, content, timestamp: new Date() };
    posts.push(post);
    res.json(post);
});

app.get('/posts', (req, res) => {
    res.json(posts);
});

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
