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
<form action="/staff/create" method="get">
    <input type="submit" value="Добавить работника">
</form>
</body>
</html>