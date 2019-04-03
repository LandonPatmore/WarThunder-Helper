(function ($) {

  var heightVsSpeedChart = new CanvasJS.Chart("heightVsSpeedChart", {
    axisY:[{
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
    axisY:[{
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

  var controlsChart = new CanvasJS.Chart("controlSurfacesChart", {
    axisY:[{
      title: "Throttle",
      lineColor: "#7F6084",
      tickColor: "#7F6084",
      labelFontColor: "#7F6084",
      titleFontColor: "#7F6084",
      suffix: "%"
    },
    {
      title: "Elevator",
      lineColor: "#369EAD",
      tickColor: "#369EAD",
      labelFontColor: "#369EAD",
      titleFontColor: "#369EAD",
      suffix: "%"
    },
    {
      title: "Ailerons",
      lineColor: "#C24642",
      tickColor: "#C24642",
      labelFontColor: "#C24642",
      titleFontColor: "#C24642",
      suffix: "%"
    }],
    axisY2: [{
      title: "Rudder",
      lineColor: "#8FAABB",
      tickColor: "#8FAABB",
      labelFontColor: "#8FAABB",
      titleFontColor: "#8FAABB",
      suffix: "%"
    },
    {
      title: "Gear",
      lineColor: "#FAA586",
      tickColor: "#FAA586",
      labelFontColor: "#FAA586",
      titleFontColor: "#FAA586",
      suffix: "%"
    },
    {
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
      name: "Ailerons",
      color: "#C24642",
      showInLegend: true,
      axisYIndex: 0,
      dataPoints: []
    },
    {
      type: "line",
      name: "Elevator",
      color: "#369EAD",
      showInLegend: true,
      axisYIndex: 1,
      dataPoints: []
    },
    {
      type: "line",
      name: "Throttle",
      color: "#7F6084",
      showInLegend: true,
      axisYIndex: 2,
      dataPoints: []
    },
    {
      type: "line",
      name: "Rudder",
      color: "#8FAABB",
      showInLegend: true,
      axisYType: "secondary",
      axisYIndex: 0,
      dataPoints: []
    },
    {
      type: "line",
      name: "Gear",
      color: "#FAA586",
      showInLegend: true,
      axisYType: "secondary",
      axisYIndex: 1,
      dataPoints: []
    },
    {
      type: "line",
      name: "Flaps",
      color: "#4661EE",
      showInLegend: true,
      axisYType: "secondary",
      axisYIndex: 2,
      dataPoints: []
    },
  ]
  });
  controlsChart.render();


  var i = 0;
  function updateHeightVsSpeedChart(data) {
    heightVsSpeedChart.data.forEach((d) => {
      if (i > 200) {
        d.dataPoints.shift()
      }
      if (d.name == "IAS") {
        d.dataPoints.push({x: i, y: data["IAS, km/h"]})
      } else if (d.name == "TAS") {
        d.dataPoints.push({x: i, y:data["TAS, km/h"]})
      } else if (d.name == "Height") {
        d.dataPoints.push({x: i, y:data["H, m"]})
      }
    })
    heightVsSpeedChart.render();
  }

  function updateForceChart(data) {
    forcesVsPitchChart.data.forEach((d) => {
      if (i > 200) {
        d.dataPoints.shift()
      }
      if (d.name == "V. Speed") {
        d.dataPoints.push({x: i, y: data["Vy, m/s"]})
      } else if (d.name == "V. Geforce") {
        d.dataPoints.push({x: i, y:data["Ny"]})
      }
    })
    forcesVsPitchChart.render();
  }

  function updateControlSurfacesChart(data) {
    controlsChart.data.forEach((d) => {
      if (i > 50) {
        d.dataPoints.shift()
      }
      if (d.name == "Throttle") {
        d.dataPoints.push({x: i, y: data["throttle 1, %"]})
      } else if (d.name == "Ailerons") {
        d.dataPoints.push({x: i, y:data["aileron, %"]})
      } else if (d.name == "Elevator") {
        d.dataPoints.push({x: i, y:data["elevator, %"]})
      } else if (d.name == "Rudder") {
        d.dataPoints.push({x: i, y:data["rudder, %"]})
      } else if (d.name == "Flaps") {
        d.dataPoints.push({x: i, y:data["flaps, %"]})
      } else if (d.name == "Gear") {
        d.dataPoints.push({x: i, y:data["gear, %"]})
      }
    })
    controlsChart.render();
  }

  setInterval(requestData, 100);
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
      updateElement($("#ailerons"), data["aileron, %"], $("#aileronsIcon"), "fa fa-rotate-left", "fa fa-rotate-right","fa fa-circle" )
      updateElement($("#rudder"), data["rudder, %"], $("#rudderIcon"), "ti-arrow-left", "ti-arrow-right", "fa fa-circle")
      updateElement($("#gear"), data["gear, %"], $("#gearIcon"), null, "ti-arrow-down", "ti-arrow-up")
      updateElement($("#flaps"), data["flaps, %"], $("#flapsIcon"), null, "ti-arrow-down", "ti-arrow-up")

      updateHeightVsSpeedChart(data);
      updateForceChart(data)
      updateControlSurfacesChart(data)
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
    iconElement.css({'transform' : 'rotate('+ rotation +'deg)'});
  }

  function updateElement(textElement, text, iconElement, negIcon, posIcon, middleIcon) {
    textElement.text(text)
    if (negIcon == null && posIcon == null) {
      return
    }
    if (Math.sign(text) == -1) {
      iconElement.removeClass(posIcon).removeClass(middleIcon).addClass(negIcon)
    } else if (Math.sign(text) == 1){
      iconElement.removeClass(negIcon).removeClass(middleIcon).addClass(posIcon)
    } else if (middleIcon != null){
      iconElement.removeClass(negIcon).removeClass(posIcon).addClass(middleIcon)
    }
  }

  function fixTypeDisplay(name) {
    let newName = name.toUpperCase()
    return newName
  }
})(jQuery)