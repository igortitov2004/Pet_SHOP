<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
</head>
<body>
<form action="/staff" method="get">
    <input type="submit" value="Назад"/>
</form>
<h3>Добавление работника</h3>
<hr>
<form action="/staff/create" method="post" enctype="multipart/form-data">
        ФИО:<input type="text"  value="${staff.fullName}" required name="fullName"/><br>
        <#if err??>
            <div style="color: red">
                <@spring.bind "staff.fullName"/>
                <@spring.showErrors "<br>"/>
            </div>
        </#if><br>
        Номер паспорта:<input type="text"  value="${staff.numOfPassport}" required name="numOfPassport" minlength="9" maxlength="9"/><br>
         <#if err??>
             <div style="color: red">
                 <@spring.bind "staff.numOfPassport"/>
                 <@spring.showErrors "<br>"/>
             </div>
         </#if><br>
        Номер телефона:<input type="text" value="${staff.telNumber}" required name="telNumber" minlength="13" maxlength="13"/><br>
        <#if err??>
            <div style="color: red">
                <@spring.bind "staff.telNumber"/>
                <@spring.showErrors "<br>"/>
            </div>
        </#if><br>
        Стаж работы:<input type="number" value="${staff.experience}" required name="experience"  min="0" max="50"/><br>
        <#if err??>
            <div style="color: red">
               <@spring.bind "staff.experience"/>
               <@spring.showErrors "<br>"/>
           </div>
        </#if><br>
        Должность:
        <select name="job_title" required>
<#--            <option disabled SELECTED>Выберите</option>-->
            <option value="Менеджер"> Менеджер</option>
            <option value="Продавец-кассир"> Продавец-кассир</option>
        </select><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Применить"/>
</form>
<#if errorMessage??>
    <h3 style="color: darkblue">${errorMessage}</h3>
</#if>
</body>
</html>