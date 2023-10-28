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
        ФИО:<input type="text"  value="${staff.fullName}" required name="fullName"/><br><br>
        <#if err??>
            <div style="color: red">
                <@spring.bind "staff.fullName"/>
                <@spring.showErrors "<br>"/>
            </div>
        </#if>
        Номер паспорта:<input type="text"  value="${staff.num_of_passport}" required name="num_of_passport"/><br>
         <#if err??>
             <br><div style="color: red">
                 <@spring.bind "staff.num_of_passport"/>
                 <@spring.showErrors "<br>"/>
             </div>
         </#if>
        Номер телефона:<input type="text" value="${staff.telNumber}" required name="telNumber"/><br>
        <#if err??>
            <br><div style="color: red">
                <@spring.bind "staff.telNumber"/>
                <@spring.showErrors "<br>"/>
            </div>
        </#if>
        Стаж работы:<input type="number" value="${staff.experience}" required name="experience" /><br>
        <#if err??>
            <br><div style="color: red">
               <@spring.bind "staff.experience"/>
               <@spring.showErrors "<br>"/>
           </div>
        </#if>
        Должность:
        <select name="job_title" required>
            <option disabled SELECTED>Выберите</option>
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