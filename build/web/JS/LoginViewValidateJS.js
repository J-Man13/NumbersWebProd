/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateSecret(event){
    if(event.keyCode != 13)
        return;    
    $("spawn#container-secret-form-error").hide();    
    $("img#container-secret-form-load-image").show();
    var validate = $("input#container-secret-input-id").val(); 
    $.ajax({
        "url" : "/NumbersWebProd/LoginViewServletController",
        "method" : "post",
        "data" : {
            "adminpass" : validate
        },        
        "success" : function(data){
                    window.location.replace("/NumbersWebProd/View/AdminPanelView.jsp");                    
                    },
        "error" :   function(data){
                        console.log(data);
                        console.log("error");
                        $("spawn#container-secret-form-error").show();
                    },
        "complete" : function(data){
                        $("img#container-secret-form-load-image").hide();
                    }            
                    
    });
}