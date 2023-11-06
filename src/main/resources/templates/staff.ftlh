<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <hr>
       <h3><a href="/" style="text-align: center; text-decoration: none"> Главная </a></h3>
    <hr>
</head>
<body>
<form action="/staff" method="get">
    <div style="display: inline-flex">Поиск по ФИО:<input type="text" name="fullName"><br>
        <input type="submit" value="Поиск"/></div>
</form>
<br>
<#if staffs?has_content>
<table border="1">
    <tr>
        <th> ID работника</th>
        <th> Ф.И.О.</th>
        <th> Номер телефона </th>
    </tr>
    <#list staffs as staff>
    <tr>
        <th>${staff.id_staff}</th>
        <th><a href="/staff/${staff.id_staff}">${staff.fullName}</a></th>
        <th>${staff.telNumber}</th>
    </tr>
    </#list>
</table>
    <#else> Данный работник не найден!
</#if>
<hr>

<form action="/staff/create"  method="get" >
    <input type="submit" value="Добавить работника">
</form>

<#--    <h3>Добавление сотрудника</h3>-->
<#--    <form action="/staff/create" method="post" enctype="multipart/form-data">-->
<#--        <div>ФИО:<input type="text" value="${newStaff.fullName}" required name="fullName" /><br><br>-->
<#--         -->
<#--            Номер паспорта:<input type="text"  required name="num_of_passport"/><br><br>-->
<#--            Номер телефона:<input type="text" required  name="telNumber"/><br><br>-->
<#--            Стаж работы:<input type="number" required  name="experience"/><br><br>-->
<#--            Должность:  <select name="job_title" required>-->
<#--                <option>Выберите</option>-->
<#--                <option value="Продавец-кассир">Продавец-кассир </option>-->
<#--                <option value="Менеджер">Менеджер </option>-->
<#--            </select><br><br>-->
<#--        </div>-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--        <input type="submit" value="Добавить работника"/>-->
<#--    </form>-->
<#--<#if errorMessage??>-->
<#--    <h3 style="color: darkblue">${errorMessage}</h3>-->
<#--</#if>-->

</body>
</html>