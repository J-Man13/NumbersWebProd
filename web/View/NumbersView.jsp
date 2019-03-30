<%-- 
    Document   : NumbersView
    Created on : Sep 13, 2018, 11:03:33 AM
    Author     : jafar.j
--%>

<%@page import="Models.PhoneUserFull"%>
<%@page import="Services.GetPhoneUsersFullSqliteDbService"%>
<%@page import="Services.GetPhoneUsersFullSynchronized"%>
<%@page import="Services.GetAsteriskUsersWebJsonService"%>
<%@page import="Controllers.NumbersViewController"%>
<%@page import="Models.PhoneUser"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%@include  file="header.html" %>
    <link href="../CSS/NumbersView.css" rel="stylesheet">
    <script src="../JS/jquery-3.3.1.js"></script>
    <script src="../JS/NumbersViewFindJs.js"></script>
    

            
        <div class="searchers">
            <div class="searchers-name">
                <spawn class="searchers-name-inscription">Search</spawn>
                <input id = "search-by-name-id1" type="text" class="searchbox-name" onkeydown="find(event)">
            </div>
        </div>
        

        <div class="contacts">   
            <div class="contacts-namings">
                <spawn id="contacts-namings-number">№</spawn>
                <spawn id="contacts-namings-name">Full name</spawn>
                <spawn id="contacts-namings-department">Department</spawn>
                <spawn id="contacts-namings-specialty">Specialty</spawn>
                <spawn id="contacts-namings-structure">Structure</spawn>
                <spawn id="contacts-namings-email">Email</spawn>
            </div>
            <div class="contacts-container">                   
            <% 
                try{    
                    NumbersViewController numbersViewController = new NumbersViewController(new GetPhoneUsersFullSynchronized(new GetPhoneUsersFullSqliteDbService(), new GetAsteriskUsersWebJsonService()));
                    Iterable<PhoneUserFull> iterables = numbersViewController.getAllPhoneUsers();
                    int i = 0;
                    for(PhoneUserFull phoneUserFull : iterables){
            %>                      
                        <div id="contact<%=i%>" class="contacts-container-phone-user">       
                            <div class="contacts-container-phone-user-number">                               
                                <spawn id="contact-number<%=i%>" class="contacts-container-phone-user-number-spawn"> <%=phoneUserFull.getPhoneUserNumber()%></spawn>
                            </div>
                            <div class="contacts-container-phone-user-name">
                                <%
                                    String phoneUserNameToDisplay = "";
                                    if(phoneUserFull.getPhoneUserNameAZE().trim().equals("boş"))
                                        phoneUserNameToDisplay = phoneUserFull.getPhoneUserName();
                                    else
                                        phoneUserNameToDisplay = phoneUserFull.getPhoneUserNameAZE();
                                %>                                                              
                                <spawn id="contact-name<%=i%>" class="contacts-container-phone-user-name-spawn"><%=phoneUserNameToDisplay%></spawn>
                                <spawn id="contact-name-asterisk-hiden<%=i%>" class="contacts-container-phone-user-name-spawn-asterisk-hiden" style="display: none"><%=phoneUserFull.getPhoneUserName()%></spawn>
                            </div>
                            
                            <div class="contacts-container-phone-user-department">
                                <spawn id="contact-department<%=i%>" class="contacts-container-phone-user-department-spawn"><%=phoneUserFull.getPhoneUserDepartment()%></spawn>
                            </div>
                            <div class="contacts-container-phone-user-specialty">
                                <spawn id="contact-specialty<%=i%>" class="contacts-container-phone-user-specialty-spawn"><%=phoneUserFull.getPhoneUserSpecialty()%></spawn>
                            </div>
                           <div class="contacts-container-phone-user-structure">
                                <spawn id="contact-structure<%=i%>" class="contacts-container-phone-user-structure-spawn"><%=phoneUserFull.getPhoneUserStructure()%></spawn>
                            </div>
                            <div class="contacts-container-phone-user-email">
                                <spawn id="contact-email<%=i%>" class="contacts-container-phone-user-email-spawn"><%=phoneUserFull.getPhoneUserEmail()%></spawn>
                            </div>
                        </div>
                    <%i++;}%>
                <%}catch(Exception e){%>
                    <h1><%= e.toString() %></h1>
                <%}%>                               
            </div>           
        </div>       
    <%@include  file="footer.html"%>