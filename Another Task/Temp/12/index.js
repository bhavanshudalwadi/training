const WebSocket = require('ws');
const http = require('http');
const express = require('express');

const app = express();
const server = http.createServer(app);
const wss = new WebSocket.Server({ server });

const players = new Map();

wss.on('connection', (ws) => {
  const playerId = Math.random().toString(36).substring(7);
  players.set(playerId, ws);

  wss.clients.forEach((client) => {
    client.send(`Player ${playerId} has joined the game.`);
  });

  ws.on('message', (message) => {
    wss.clients.forEach((client) => {
      client.send(`Player ${playerId}: ${message}`);
    });
  });

  ws.on('close', () => {
    players.delete(playerId);
    wss.clients.forEach((client) => {
      client.send(`Player ${playerId} has left the game.`);
    });
  });
});
const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
