const encrypt = (msg) => {
    var key = {
        'A': 'Q', 'B': 'W', 'C': 'E', 'D': 'R', 'E': 'T', 'F': 'Y',
        'G': 'U', 'H': 'I', 'I': 'O', 'J': 'P', 'K': 'A', 'L': 'S',
        'M': 'D', 'N': 'F', 'O': 'G', 'P': 'H', 'Q': 'J', 'R': 'K',
        'S': 'L', 'T': 'Z', 'U': 'X', 'V': 'C', 'W': 'V', 'X': 'B',
        'Y': 'N', 'Z': 'M'
    };

    var encryptedMessage = '';
    message = message.toUpperCase();

    for (var i = 0; i < message.length; i++) {
        if (/\s/.test(message[i])) {
            encryptedMessage += ' ';
        } else {
            encryptedMessage += key[message[i]] || message[i];
        }
    }

    return encryptedMessage;
}

function decrypt(encryptedMessage) {
    var key = {
        'Q': 'A', 'W': 'B', 'E': 'C', 'R': 'D', 'T': 'E', 'Y': 'F',
        'U': 'G', 'I': 'H', 'O': 'I', 'P': 'J', 'A': 'K', 'S': 'L',
        'D': 'M', 'F': 'N', 'G': 'O', 'H': 'P', 'J': 'Q', 'K': 'R',
        'L': 'S', 'Z': 'T', 'X': 'U', 'C': 'V', 'V': 'W', 'B': 'X',
        'N': 'Y', 'M': 'Z'
    };

    var decryptedMessage = '';
    encryptedMessage = encryptedMessage.toUpperCase();

    for (var i = 0; i < encryptedMessage.length; i++) {
        if (/\s/.test(encryptedMessage[i]))
            decryptedMessage += ' ';
        else decryptedMessage += key[encryptedMessage[i]] || encryptedMessage[i];
    }

    return decryptedMessage;
}

var message = 'HELLO WORLD!';
var encryptedMessage = encrypt(message);
var decryptedMessage = decrypt(encryptedMessage);

console.log('Original message:', message);
console.log('Encrypted message:', encryptedMessage);
console.log('Decrypted message:', decryptedMessage);

// /s used to check the widespaces