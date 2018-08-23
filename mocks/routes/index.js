var express = require('express');
var router = express.Router();

let categorias = []

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/categoria', function(req, res) {
  res.send(categorias)
})

router.post('/categoria', function(req, res, next) {
  let body = req.body
  body.id = Math.ceil(Math.random() * 1000)
  categorias.push(body)
  res.send(body)
})

module.exports = router;
