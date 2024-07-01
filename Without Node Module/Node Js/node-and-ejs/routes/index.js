var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  // res.render('index', { title: 'Node js with Express and Ejs' });
  res.json({success: true, message: "Success Message"})
});

module.exports = router;
