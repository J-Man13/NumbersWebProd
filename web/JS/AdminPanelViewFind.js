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
    
    for(var i = 0 ; i < phonesNum ;i++){
        var contactNumber = $('spawn#contact-number'+i).html();
        var contactName = $('spawn#contact-name'+i).html();
        var contactNameAze = $('input#contact-name-aze'+i).val();
        var contactDepartment = $('input#contact-department'+i).val();
        var contactSpecialty = $('input#contact-specialty'+i).val();
        var contactStructure = $('input#contact-structure'+i).val();
        var contactEmail = $('input#contact-email'+i).val();
        
        var totalString = (contactNumber+contactName+contactNameAze+contactDepartment+contactSpecialty+contactStructure+contactEmail).toLowerCase();
        
        if(!totalString.includes(searchName))
          $("#contact"+i).hide(); 
        
    }
}