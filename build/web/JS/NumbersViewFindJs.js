/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function find(event){
    var searchName = ""          
    if(event.key.length > 1)
        if(event.key == "Backspace")
            searchName = event.target.value.substring(0,event.target.value.length-1);
        else
            searchName = event.target.value;       
    else
        searchName = event.target.value + "" + event.key;    
    
    searchName = searchName.toLowerCase();
    
    $(".contacts-container-phone-user").show();
    
    var phonesNum = $(".contacts-container-phone-user").length;
    for(var i = 0 ; i < phonesNum ; i++){
        var contactNumber = $('spawn#contact-number'+i).html();
        var contactName = $('spawn#contact-name'+i).html();
        var contactNameAsteriskHidden = $('spawn#contact-name-asterisk-hiden'+i).html();
        var contactDepartment = $('spawn#contact-department'+i).html();
        var contactSpecialty = $('spawn#contact-specialty'+i).html();
        var contactStructure = $('spawn#contact-structure'+i).html();
        var contactEmail = $('spawn#contact-email'+i).html();
        
        var totalString = (contactNumber+contactName+contactNameAsteriskHidden+contactDepartment+contactSpecialty+contactStructure+contactEmail).toLowerCase();
         
        if(!totalString.includes(searchName))
          $("#contact"+i).hide();
    }
}

