(function ($) {

  var chart = new CanvasJS.Chart("heightVsSpeedChart", {
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
  chart.render();

  var i = 0;
  function updateChart(data) {
    chart.data.forEach((d) => {
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
    i++;
    chart.render();
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

      updateChart(data);
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