
console.log("ready");

    var head = document.getElementsByTagName('head')[0];
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = "http://code.jquery.com/jquery-2.2.1.min.js";
    script.onreadystatechange = handler;
    script.onload = handler;
    head.appendChild(script);
    
//TODO ADD X-Requested-By header to prevent CSRF!



    function handler(){
       console.log('jquery added :)');
       //XMLHttpRequest.setRequestHeader("X-Requested-By", "192.168.30.29");
        $("form").submit(function(event) {

   var recaptcha = grecaptcha.getResponse();
   if (recaptcha === "") {
      event.preventDefault();
      alert("Please check the recaptcha");
   }
});
    }