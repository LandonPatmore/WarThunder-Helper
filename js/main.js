$(function() {
  var attitude = $.flightIndicator('#attitude', 'attitude');
  var heading = $.flightIndicator('#heading', 'heading');
  var airSpeed = $.flightIndicator('#airspeed', 'airspeed');
    setInterval(requestData, 50);
    function requestData() {
      $.getJSON("http://129.3.168.156:8111/state", function (data) {
        var speed = data["IAS, km/h"]
        console.log(speed / 1.852)
        airSpeed.setAirSpeed(speed / 1.852)
      })
      // $.getJSON("http://192.168.1.126:8111/indicators", function (data) {
      //   var degree = Math.floor(data["compass1"])
      //   $("#needle").css('-webkit-transform', 'rotate(' + degree + 'deg)');
      //   $("#needle2").css('-webkit-transform', 'rotate(' + (degree - 180) + 'deg)');
      //   $("#heading").text(degree + String.fromCharCode(176))
      // })
      $.getJSON("http://129.3.168.156:8111/indicators", function (data) {
        attitude.setRoll(data["aviahorizon_roll"])
        var pitch = data["aviahorizon_pitch"]
        attitude.setPitch(pitch * -1)
        heading.setHeading(data["compass1"])
      //   $("#throttle").text("Throttle: " + Math.floor(data["throttle 1, %"]) + " %")
      //   $("#rpm").text("RPM: " + Math.floor(data["RPM 1"]))
      })
    }
})