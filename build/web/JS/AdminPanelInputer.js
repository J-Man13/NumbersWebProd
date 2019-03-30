/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function sleep(miliseconds) {
    var currentTime = new Date().getTime();
    while (currentTime + miliseconds >= new Date().getTime()){}
}

function insertUpdatePhoneUserFull(button_id){   
    var contactSequence = button_id.substr(14, button_id.length - 1);    
    
    var contactNumberToAdd = $('spawn#contact-number'+contactSequence).html().trim();
    var contactNameToAdd = $('spawn#contact-name'+contactSequence).html().trim();
    console.log(contactNumberToAdd+contactNameToAdd);
    

    
    var contactNameAzeToAdd = $('input#contact-name-aze'+contactSequence).val().trim();
    var contactDepartmentToAdd = $('input#contact-department'+contactSequence).val().trim();
    var contactSpecialtyToAdd = $('input#contact-specialty'+contactSequence).val().trim();

    var contactStructureToAdd = $('input#contact-structure'+contactSequence).val().trim();       
    var contactEmailToAdd = $('input#contact-email'+contactSequence).val().trim();       
    
    
    $.ajax({
        "url" : "/NumbersWebProd/AdminPanelViewServletController",
        "method" : "post",
        "data" : {
            "contactNumberToAdd" : contactNumberToAdd,
            "contactNameToAdd" : contactNameToAdd,
            "contactNameAzeToAdd" : contactNameAzeToAdd,
            "contactDepartmentToAdd" : contactDepartmentToAdd,
            "contactSpecialtyToAdd" : contactSpecialtyToAdd,
            "contactStructureToAdd" : contactStructureToAdd,
            "contactEmailToAdd" : contactEmailToAdd
        },        
        "success" : function(data){
                        console.log(data);
                        $('button#'+button_id).css({'background-color':'green', 'border-color':'green'});  
                        console.log('suc'); 
                    },
        "error" :   function(data){
                        console.log(data);
                        $('button#'+button_id).css({'background-color':'red', 'border-color':'red'});                        
                        console.log('err'); 
                    },
        "complete" : function(data){
                        console.log(data);
                        setTimeout(function () {
                            $('button#'+button_id).css({'background-color':'rgba(31,74,130)', 'border-color':'rgba(31,74,130)'});
                        },3000);
                        //
                    }            
                    
    });    
}