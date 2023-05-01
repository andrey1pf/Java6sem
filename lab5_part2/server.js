const express = require('express');
const app = express();
const path = require('path');

app.use(express.static('public', {
  setHeaders: (res, path, stat) => {
    if (path.endsWith('.js')) {
      res.setHeader('Content-Type', 'text/javascript');
    }
  }
}));

// serve index.html
app.get('/', function(req, res) {
  res.sendFile(path.join(__dirname, 'index.html'));
});

// download json file
app.get('/download', function(req, res) {
  res.download(path.join(__dirname, 'data', 'data.json'));
});

app.listen(3000, function() {
  console.log('Server started on port 3000');
});

//sudo npm run-script start
