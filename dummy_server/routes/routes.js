var fs = require('fs');

var contents = JSON.parse(fs.readFileSync('/Users/landon/Desktop/Warthunder-Helper/mock\ data/p-36a_data.json', 'utf8'));

var currentStateData = 0
var currentIndicatorsData = 0
var maxData = contents.length - 1
var stateData = []
var indicatorsData = []

contents.forEach(element => {
  stateData.push(element.state)
  indicatorsData.push(element.indicators)
});

function getStateData() {
  var data = stateData[currentStateData];
  if (currentStateData == maxData) {
    currentStateData = 0;
  }
  currentStateData++;

  return data
}

function getIndicatorsData() {
  var data = indicatorsData[currentIndicatorsData];
  if (currentIndicatorsData == maxData) {
    currentIndicatorsData = 0;
  }
  currentIndicatorsData++;

  return data
}

var appRouter = function (app) {
  app.get("/state", function(req, res) {
    res.json(getStateData())
  });

  app.get("/indicators", function(req, res) {
    res.json(getIndicatorsData())
  });
}

module.exports = appRouter;