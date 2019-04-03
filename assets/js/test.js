(function ($) {

  var chart = new CanvasJS.Chart("heightVsSpeedChart", {
    axisY:[{
      title: "Order",
      lineColor: "#C24642",
      tickColor: "#C24642",
      labelFontColor: "#C24642",
      titleFontColor: "#C24642",
      suffix: "k"
    },
    {
      title: "Footfall",
      lineColor: "#369EAD",
      tickColor: "#369EAD",
      labelFontColor: "#369EAD",
      titleFontColor: "#369EAD",
      suffix: "k"
    }],
    axisY2: {
      title: "Revenue",
      lineColor: "#7F6084",
      tickColor: "#7F6084",
      labelFontColor: "#7F6084",
      titleFontColor: "#7F6084",
      prefix: "$",
      suffix: "k"
    },
    toolTip: {
      shared: true
    },
    legend: {
      cursor: "pointer"
    },
    data: [{
      type: "line",
      name: "Footfall",
      color: "#369EAD",
      showInLegend: true,
      axisYIndex: 1,
      dataPoints: [
        { x: new Date(2017, 00, 7), y: 85.4 }, 
        { x: new Date(2017, 00, 14), y: 92.7 },
        { x: new Date(2017, 00, 21), y: 64.9 },
        { x: new Date(2017, 00, 28), y: 58.0 },
        { x: new Date(2017, 01, 4), y: 63.4 },
        { x: new Date(2017, 01, 11), y: 69.9 },
        { x: new Date(2017, 01, 18), y: 88.9 },
        { x: new Date(2017, 01, 25), y: 66.3 },
        { x: new Date(2017, 02, 4), y: 82.7 },
        { x: new Date(2017, 02, 11), y: 60.2 },
        { x: new Date(2017, 02, 18), y: 87.3 },
        { x: new Date(2017, 02, 25), y: 98.5 }
      ]
    },
    {
      type: "line",
      name: "Order",
      color: "#C24642",
      axisYIndex: 0,
      showInLegend: true,
      dataPoints: [
        { x: new Date(2017, 00, 7), y: 32.3 }, 
        { x: new Date(2017, 00, 14), y: 33.9 },
        { x: new Date(2017, 00, 21), y: 26.0 },
        { x: new Date(2017, 00, 28), y: 15.8 },
        { x: new Date(2017, 01, 4), y: 18.6 },
        { x: new Date(2017, 01, 11), y: 34.6 },
        { x: new Date(2017, 01, 18), y: 37.7 },
        { x: new Date(2017, 01, 25), y: 24.7 },
        { x: new Date(2017, 02, 4), y: 35.9 },
        { x: new Date(2017, 02, 11), y: 12.8 },
        { x: new Date(2017, 02, 18), y: 38.1 },
        { x: new Date(2017, 02, 25), y: 42.4 }
      ]
    },
    {
      type: "line",
      name: "Revenue",
      color: "#7F6084",
      axisYType: "secondary",
      showInLegend: true,
      dataPoints: [
        { x: new Date(2017, 00, 7), y: 42.5 }, 
        { x: new Date(2017, 00, 14), y: 44.3 },
        { x: new Date(2017, 00, 21), y: 28.7 },
        { x: new Date(2017, 00, 28), y: 22.5 },
        { x: new Date(2017, 01, 4), y: 25.6 },
        { x: new Date(2017, 01, 11), y: 45.7 },
        { x: new Date(2017, 01, 18), y: 54.6 },
        { x: new Date(2017, 01, 25), y: 32.0 },
        { x: new Date(2017, 02, 4), y: 43.9 },
        { x: new Date(2017, 02, 11), y: 26.4 },
        { x: new Date(2017, 02, 18), y: 40.3 },
        { x: new Date(2017, 02, 25), y: 54.2 }
      ]
    }]
  });
  chart.render();

  setInterval(requestData, 100);
  function requestData() {
    $.getJSON("http://localhost:7000/state", function (data) {
      updateElement($("#height"), data["H, m"], null, null, null)
      updateElement($("#vspeed"), data["Vy, m/s"], $("#vspeedIcon"), "ti-arrow-down", "ti-arrow-up")
      updateElement($("#ias"), data["IAS, km/h"], null, null, null)
      updateElement($("#tas"), data["TAS, km/h"], null, null, null)
      updateElement($("#rpm"), data["RPM 1"], null, null, null)
      updateElement($("#geforce"), data["Ny"], null, null, null)
    })

    $.getJSON("http://localhost:7000/indicators", function (data) {
      updateElement($("#pitch"), Math.floor(data["aviahorizon_pitch"]), $("#pitchIcon"), "ti-arrow-up", "ti-arrow-down")
      updateElement($("#roll"), Math.floor(data["aviahorizon_roll"]), $("#rollIcon"), "fa fa-rotate-left", "fa fa-rotate-right", "fa fa-circle")
      $("#currentAircraft").text("Current Aircraft: " + fixTypeDisplay(data["type"]))
    })
  }

  function updateElement(textElement, text, iconElement, negIcon, posIcon, middleIcon) {
    textElement.text(text)
    if (negIcon == null || posIcon == null) {
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