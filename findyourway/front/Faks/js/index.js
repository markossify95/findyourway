


var map = null;

google.maps.event.addDomListener(window,'load', init);
google.maps.event.addDomListener(window,'resize', function(){
  map.setCenter(new google.maps.LatLng(44.802394, 20.466306));
});

function init(){

    var mapOptions = {

      zoom: 16,

      center: new google.maps.LatLng(44.802394, 20.466306),

      disableDefaultUI: true,
      scrollwheel: true,
      draggable: true,

      styles: [{

        "featureType": "water",
        "elementType": "geometry",
        "stylers": [{
          color: "#000000"
        },{
          "lightness": 15
        }]

      },{
          "featureType": "landscape",
          "elementType": "geometry",
          "stylers": [{
              "color": "#000000"
          }, {
              "lightness": 25
          }]
      }, {
          "featureType": "road.highway",
          "elementType": "geometry.fill",
          "stylers": [{
              "color": "#000000"
          }, {
              "lightness": 17
          }]
      }, {
          "featureType": "road.highway",
          "elementType": "geometry.stroke",
          "stylers": [{
              "color": "#000000"
          }, {
              "lightness": 29
          }, {
              "weight": 0.2
          }]
      }, {
          "featureType": "road.arterial",
          "elementType": "geometry",
          "stylers": [{
              "color": "#000000"
          }, {
              "lightness": 18
          }]
      }, {
          "featureType": "road.local",
          "elementType": "geometry",
          "stylers": [{
              "color": "#000000"
          }, {
              "lightness": 16
          }]
      }, {
          "featureType": "poi",
          "elementType": "geometry",
          "stylers": [{
              "color": "#000000"
          }, {
              "lightness": 21
          }]
      }, {
          "elementType": "labels.text.stroke",
          "stylers": [{
              "visibility": "on"
          }, {
              "color": "#000000"
          }, {
              "lightness": 16
          }]
      }, {
          "elementType": "labels.text.fill",
          "stylers": [{
              "saturation": 36
          }, {
              "color": "#000000"
          }, {
              "lightness": 40
          }]
      }, {
          "elementType": "labels.icon",
          "stylers": [{
              "visibility": "off"
          }]
      }, {
          "featureType": "transit",
          "elementType": "geometry",
          "stylers": [{
              "color": "#000000"
          }, {
              "lightness": 19
          }]
      }, {
          "featureType": "administrative",
          "elementType": "geometry.fill",
          "stylers": [{
              "color": "#000000"
          }, {
              "lightness": 20
          }]
      }, {
          "featureType": "administrative",
          "elementType": "geometry.stroke",
          "stylers": [{
              "color": "#000000"
          }, {
              "lightness": 17
          }, {
              "weight": 1.2
          }]
      }]
  };

  var mapElement = document.getElementById('map');

  map = new google.maps.Map(mapElement, mapOptions);

  var image = 'map-marker.png';
  var myLatLng = new google.maps.LatLng(44.802394, 20.466306);
  var marker = new google.maps.Marker({
      position: myLatLng,
      map: map,
      icon: image
  });

}
