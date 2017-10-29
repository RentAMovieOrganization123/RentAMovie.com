//binds to onchange event of your input field
$('#myFile').bind('change', function() {

  //this.files[0].size gets the size of your file.
  alert(this.files[0].size);

});