//binds to onchange event of your input field
$(document).ready(function () {$('#myFile').on('change', check);

});
    function check(){
      var imgpath=document.getElementById('myFile');
      console.log("test");
      if (!imgpath.value==""){
        var img=imgpath.files[0].size;
        var imgsize=img/1024; 
        alert(imgsize);
      }
      console.log("test2");
    }