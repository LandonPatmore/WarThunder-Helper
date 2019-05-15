var heightVsSpeedChart = new CanvasJS.Chart("heightVsSpeedChart", {
  axisY: [{
    title: "IAS",
    lineColor: "#C24642",
    tickColor: "#C24642",
    labelFontColor: "#C24642",
    titleFontColor: "#C24642",
    suffix: "km/h"
  },
  {
    title: "TAS",
    lineColor: "#369EAD",
    tickColor: "#369EAD",
    labelFontColor: "#369EAD",
    titleFontColor: "#369EAD",
    suffix: "km/h"
  }],
  axisY2: {
    title: "Height",
    lineColor: "#7F6084",
    tickColor: "#7F6084",
    labelFontColor: "#7F6084",
    titleFontColor: "#7F6084",
    suffix: "m"
  },
  toolTip: {
    shared: true
  },
  legend: {
    cursor: "pointer"
  },
  data: [{
    type: "line",
    name: "IAS",
    color: "#369EAD",
    showInLegend: true,
    axisYIndex: 1,
    dataPoints: []
  },
  {
    type: "line",
    name: "TAS",
    color: "#C24642",
    axisYIndex: 0,
    showInLegend: true,
    dataPoints: []
  },
  {
    type: "line",
    name: "Height",
    color: "#7F6084",
    axisYType: "secondary",
    showInLegend: true,
    dataPoints: []
  }]
});
heightVsSpeedChart.render();

var forcesVsPitchChart = new CanvasJS.Chart("forcesVsPitchChart", {
  axisY: [{
    title: "V. Speed",
    lineColor: "#C24642",
    tickColor: "#C24642",
    labelFontColor: "#C24642",
    titleFontColor: "#C24642",
    suffix: "m/s"
  }],
  axisY2: {
    title: "V. Geforce",
    lineColor: "#369EAD",
    tickColor: "#369EAD",
    labelFontColor: "#369EAD",
    titleFontColor: "#369EAD",
    suffix: "G"
  },
  toolTip: {
    shared: true
  },
  legend: {
    cursor: "pointer"
  },
  data: [{
    type: "line",
    name: "V. Speed",
    color: "#369EAD",
    showInLegend: true,
    axisYIndex: 1,
    dataPoints: []
  },
  {
    type: "line",
    name: "V. Geforce",
    color: "#C24642",
    axisYType: "secondary",
    showInLegend: true,
    dataPoints: []
  }]
});
forcesVsPitchChart.render();

var throttleChart = new CanvasJS.Chart("throttleChart", {
  axisY: [{
    title: "Throttle",
    lineColor: "#7F6084",
    tickColor: "#7F6084",
    labelFontColor: "#7F6084",
    titleFontColor: "#7F6084",
    suffix: "%"
  }],
  toolTip: {
    shared: true
  },
  legend: {
    cursor: "pointer"
  },
  data: [{
    type: "line",
    name: "Throttle",
    color: "#7F6084",
    dataPoints: []
  }]
});
throttleChart.render();

var aileronsChart = new CanvasJS.Chart("aileronsChart", {
  axisY: [{
    title: "Ailerons",
    lineColor: "#C24642",
    tickColor: "#C24642",
    labelFontColor: "#C24642",
    titleFontColor: "#C24642",
    suffix: "%"
  }],
  toolTip: {
    shared: true
  },
  legend: {
    cursor: "pointer"
  },
  data: [{
    type: "line",
    name: "Ailerons",
    color: "#C24642",
    dataPoints: []
  }]
});
aileronsChart.render();

var elevatorChart = new CanvasJS.Chart("elevatorChart", {
  axisY: [{
    title: "Elevator",
    lineColor: "#369EAD",
    tickColor: "#369EAD",
    labelFontColor: "#369EAD",
    titleFontColor: "#369EAD",
    suffix: "%"
  }],
  toolTip: {
    shared: true
  },
  legend: {
    cursor: "pointer"
  },
  data: [{
    type: "line",
    name: "Elevator",
    color: "#369EAD",
    dataPoints: []
  }]
});
elevatorChart.render();

var rudderChart = new CanvasJS.Chart("rudderChart", {
  axisY: [{
    title: "Rudder",
    lineColor: "#8FAABB",
    tickColor: "#8FAABB",
    labelFontColor: "#8FAABB",
    titleFontColor: "#8FAABB",
    suffix: "%"
  }],
  toolTip: {
    shared: true
  },
  legend: {
    cursor: "pointer"
  },
  data: [{
    type: "line",
    name: "Rudder",
    color: "#8FAABB",
    dataPoints: []
  }]
});
rudderChart.render();

var gearChart = new CanvasJS.Chart("gearChart", {
  axisY: [{
    title: "Gear",
    lineColor: "#FAA586",
    tickColor: "#FAA586",
    labelFontColor: "#FAA586",
    titleFontColor: "#FAA586",
    suffix: "%"
  }],
  toolTip: {
    shared: true
  },
  legend: {
    cursor: "pointer"
  },
  data: [{
    type: "line",
    name: "Gear",
    color: "#FAA586",
    dataPoints: []
  }]
});
gearChart.render();

var flapsChart = new CanvasJS.Chart("flapsChart", {
  axisY: [{
    title: "Flaps",
    lineColor: "#4661EE",
    tickColor: "#4661EE",
    labelFontColor: "#4661EE",
    titleFontColor: "#4661EE",
    suffix: "%"
  }],
  toolTip: {
    shared: true
  },
  legend: {
    cursor: "pointer"
  },
  data: [{
    type: "line",
    name: "Flaps",
    color: "#4661EE",
    dataPoints: []
  }]
});
flapsChart.render();


var i = 0;
function updateHeightVsSpeedChart(data) {
  heightVsSpeedChart.data.forEach((d) => {
    if (i > 50) {
      d.dataPoints.shift()
    }
    if (d.name == "IAS") {
      d.dataPoints.push({ x: i, y: data["IAS, km/h"] })
    } else if (d.name == "TAS") {
      d.dataPoints.push({ x: i, y: data["TAS, km/h"] })
    } else if (d.name == "Height") {
      d.dataPoints.push({ x: i, y: data["H, m"] })
    }
  })
  heightVsSpeedChart.render();
}

function updateForceChart(data) {
  forcesVsPitchChart.data.forEach((d) => {
    if (i > 50) {
      d.dataPoints.shift()
    }
    if (d.name == "V. Speed") {
      d.dataPoints.push({ x: i, y: data["Vy, m/s"] })
    } else if (d.name == "V. Geforce") {
      d.dataPoints.push({ x: i, y: data["Ny"] })
    }
  })
  forcesVsPitchChart.render();
}

function updateControlSurfacesCharts(data) {
  throttleChart.data[0].dataPoints.push({ x: i, y: data["throttle 1, %"] })
  aileronsChart.data[0].dataPoints.push({ x: i, y: data["aileron, %"] })
  elevatorChart.data[0].dataPoints.push({ x: i, y: data["elevator, %"] })
  rudderChart.data[0].dataPoints.push({ x: i, y: data["rudder, %"] })
  gearChart.data[0].dataPoints.push({ x: i, y: data["gear, %"] })
  flapsChart.data[0].dataPoints.push({ x: i, y: data["flaps, %"] })

  if (i > 50) {
    throttleChart.data[0].dataPoints.shift();
    aileronsChart.data[0].dataPoints.shift();
    elevatorChart.data[0].dataPoints.shift();
    rudderChart.data[0].dataPoints.shift();
    gearChart.data[0].dataPoints.shift();
    flapsChart.data[0].dataPoints.shift();
  }

  throttleChart.render();
  aileronsChart.render();
  elevatorChart.render();
  rudderChart.render();
  gearChart.render();
  flapsChart.render();
}

function requestData() {
  $.getJSON("http://localhost:7000/state", function (data) {
    updateElement($("#height"), data["H, m"], null, null, null)
    updateElement($("#vspeed"), data["Vy, m/s"], $("#vspeedIcon"), "ti-arrow-down", "ti-arrow-up")
    updateElement($("#ias"), data["IAS, km/h"], null, null, null)
    updateElement($("#tas"), data["TAS, km/h"], null, null, null)
    updateElement($("#rpm"), data["RPM 1"], null, null, null)
    updateElement($("#geforce"), data["Ny"], null, null, null)

    updateElement($("#throttle"), data["throttle 1, %"], null, null, null)
    updateElement($("#elevator"), data["elevator, %"], $("#elevatorIcon"), "ti-arrow-down", "ti-arrow-up")
    updateElement($("#ailerons"), data["aileron, %"], $("#aileronsIcon"), "fa fa-rotate-left", "fa fa-rotate-right")
    updateElement($("#rudder"), data["rudder, %"], $("#rudderIcon"), "ti-arrow-left", "ti-arrow-right")
    updateElement($("#gear"), data["gear, %"], $("#gearIcon"), null, "ti-arrow-down", "ti-arrow-up")
    updateElement($("#flaps"), data["flaps, %"], $("#flapsIcon"), null, "ti-arrow-down", "ti-arrow-up")

    updateHeightVsSpeedChart(data);
    updateForceChart(data)
    updateControlSurfacesCharts(data)
    i++;
  })

  $.getJSON("http://localhost:7000/indicators", function (data) {
    updateElement($("#pitch"), Math.floor(data["aviahorizon_pitch"]), $("#pitchIcon"), "ti-arrow-up", "ti-arrow-down")
    updateElement($("#roll"), Math.floor(data["aviahorizon_roll"]), $("#rollIcon"), "fa fa-rotate-left", "fa fa-rotate-right", "fa fa-circle")
    rotateElement($("#compass"), $("#compassIcon"), Math.floor(data["compass1"]))

    $("#currentAircraft").text("Current Aircraft: " + fixTypeDisplay(data["type"]))
  })
}

function rotateElement(textElement, iconElement, rotation) {
  textElement.text(rotation)
  iconElement.css({ 'transform': 'rotate(' + rotation + 'deg)' });
}

function updateElement(textElement, text, iconElement, negIcon, posIcon) {
  textElement.text(text)
  if (negIcon == null && posIcon == null) {
    return
  }

  if (text == 0) {
    iconElement.removeClass(negIcon).removeClass(posIcon).addClass("ti-split-v")
    iconElement.removeClass("border-danger").removeClass("text-danger")
    iconElement.addClass("border-warning").addClass("text-warning")
    return
  }

  if (Math.sign(text) == -1) {
    iconElement.removeClass(posIcon).removeClass("ti-split-v").addClass(negIcon)
    iconElement.addClass("border-danger").addClass("text-danger")
    iconElement.removeClass("border-warning").removeClass("text-warning")
  } else if (Math.sign(text) == 1) {
    iconElement.removeClass(negIcon).removeClass("ti-split-v").addClass(posIcon)
    iconElement.removeClass("border-danger").removeClass("text-danger")
    iconElement.removeClass("border-warning").removeClass("text-warning")
  }
}

function fixTypeDisplay(name) {
  let newName = name.toUpperCase()
  return newName
}

$("#serverConnectButton").click(() => {
  let connection = $("#serverConnectionInfoText").val()
  $.ajax({
    url: "http://" + connection + ":8111/status",
    type: "GET",
    success: () => {
      $("#connectedText").text("Connected!")
      $("#connectedText").removeClass("text-danger").addClass("text-success")
      $("#serverConnectionInfoText").prop("disabled", true);
      $("#serverConnectButton").prop("disabled", true);
    },
    error:  () => {
      alert(connection + " is not a valid server address")
      $("#connectedText").text("Invalid server address")
    },
    timeout: 1000 //in milliseconds
  });
})

  // setInterval(requestData, 100);