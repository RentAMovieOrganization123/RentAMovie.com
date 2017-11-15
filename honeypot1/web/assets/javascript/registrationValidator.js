//binds to onchange event of your input field
$(document).ready(function () {$('#input_profile_picture').on('change', check);});
$(document).ready(function () {$('#submit').on('click',validate);});

    function check(){
      var imgpath=document.getElementById('input_profile_picture');
      
      if (!imgpath.value==""){
        var img=imgpath.files[0].size;
        var imgsize=img/1024; 
        
      }
      
    }
    
    function validate(){
        
        //cleanup, remove old validator values when trying again
        cleanupValidators();
           
        //Basic validation uname
        validUser = validateUser();
        
        //Basic validation country
        validCountry = validateCountry();
        
        //Basic validation bdate
        validbdate = validateBdate();
        
        //Basic validation pass
        validPass = validatePassword();
        
        //Basic validation vpass
        validVPass = validateVPassword()
        
        //INVALID FORM
        if(validUser === false || validCountry === false || validbdate === false || validPass === false || validVPass === false)
        {
            console.log("invalid validation");    
        } 
        
        
    }
    function cleanupValidators() {
        //get validator labels
        var label_uname = document.getElementById('valusername');
        var label_country = document.getElementById('valcountry');
        var label_bdate = document.getElementById('valbrith_date');
        var label_pass = document.getElementById('valpassword');
        var label_vpass = document.getElementById('valverifypassword');
        
        //CLEANUP OLD VALIDATOR VALUES
        label_uname.innerHTML = "";
        label_country.innerHTML = "";
        label_bdate.innerHTML = "";
        label_pass.innerHTML = "";
        label_vpass.innerHTML = "";
        
    }
    
    function validateUser() {
        
        var uname = document.getElementById('input_username').value;
        var label_uname = document.getElementById('valusername');
        var valid = true;
        if(uname === "") 
        {
            valid = false;
            label_uname.innerHTML ="Username field required.";
        }
        if(uname.length < 6)
        {
            valid = false;
            label_uname.innerHTML = "Username length has to be greater than 6.";
        }
        
        if(uname.length > 20)
        {
            valid = false;
            label_uname.innerHTML ="Username length has to be less than 20.";
        }
        
        //checkup for other special characters
        //reference: https://stackoverflow.com/questions/13840143/jquery-check-if-special-characters-exists-in-string
        if(/^[a-zA-Z0-9) ]*$/.test(uname) === false) {
            valid = false;
            label_uname.innerHTML ="Username contains illegal characters.";
        }
        
        if(uname.indexOf("<script>") !== -1)
        {
            valid = false;
            label_uname.innerHTML ="Script detected, not allowed.";
        }
        
        
        
        return valid;
    }
    function validateCountry() {
        
        var label_country = document.getElementById('valcountry');
        var country = document.getElementById('input_country').value;
        var valid = true;
        
        
        //checkup for other special characters
        //reference: https://stackoverflow.com/questions/13840143/jquery-check-if-special-characters-exists-in-string
        if(/^[a-zA-Z0-9) ]*$/.test(country) === false) {
            valid = false;
            label_country.innerHTML ="Country contains illegal characters.";
        }
        
        if(country.indexOf("<script>") !== -1)
        {
            valid = false;
            label_country.innerHTML ="Script detected, not allowed.";
        }
        
        if(country === "")
        {
            valid =false;
            label_country.innerHTML ="Country field required.";     
        }
        
        return valid;
        
    }
    function validateBdate() {
        
        var label_bdate = document.getElementById('valbrith_date');
        var bdate = document.getElementById('input_birth_date').value;
        var valid = true;
        
        //just to be safe
        if(bdate.indexOf("<script>") !== -1)
        {
            valid = false;
            label_bdate.innerHTML ="Script detected, not allowed.";
        }
        
        if(bdate === "") 
        {
            valid =false;
            label_bdate.innerHTML ="Birth date field required.";
        }
        
        return valid;
    }
    function validatePassword() {
        
        var pass = document.getElementById('input_password').value;
        var label_pass = document.getElementById('valpassword');
        var valid = true;
        
        if(pass.length < 6)
        {
            valid = false;
            label_pass.innerHTML = "Password length has to be greater than 6.";
        }
        
        if(pass === "") 
        {
            valid = false;
            label_pass.innerHTML ="Password field required.";
        }
        
        if(pass.indexOf("<script>") !== -1)
        {
            valid = false;
            label_pass.innerHTML ="Script detected, not allowed.";
        }
        
        return valid;
    }
    function validateVPassword() {
        
        var label_vpass = document.getElementById('valverifypassword');
        var vpass = document.getElementById('input_verifypassword').value;
        var pass = document.getElementById('input_password').value;
        
        var valid = true;
        
        if(vpass.length < 6)
        {
            valid = false;
            label_vpass.innerHTML = "Verify Password length has to be greater than 6.";
        }
        
        if(vpass !== pass)
        {
            valid =false;
            label_vpass.innerHTML = "Passwords do not match.";
            
        }
        
        if(vpass === "") 
        {
            valid = false;
            label_vpass.innerHTML ="Verify Password field required.";
        }
        
        if(vpass.indexOf("<script>") !== -1)
        {
            valid = false;
            label_vpass.innerHTML ="Script detected, not allowed.";
        }
        
        return valid
    }