document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("creditCardForm").addEventListener("submit", function(event) {
      event.preventDefault(); 
      var name = document.getElementById("name").value;
      var surname = document.getElementById("surname").value;
      var oib = document.getElementById("oib").value;
      console.log("Name: " + name);
      console.log("Surname: " + surname);
      console.log("OIB: " + oib);
    });
  });