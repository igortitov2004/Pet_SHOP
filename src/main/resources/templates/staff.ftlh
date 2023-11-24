<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <link rel="stylesheet" type="text/css" href="/style/moreInfoButton.css">
    <link rel="stylesheet" type="text/css" href="/style/searchButton.css">
    <hr>
       <h3><div class="ref"><a href="/" style="text-align: center; text-decoration: none"> Главная </a></div> </h3>
    <hr>
</head>
<body>
<form action="/staff" method="get">
    <input type="text" name="fullName" placeholder="Поиск по ФИО"><br><br>
       <div class="search"><input type="submit" value="Поиск"/></div>
</form>
<hr>
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
        <th><div class="more"><a href="/staff/${staff.id_staff}">${staff.fullName}</a></div> </th>
        <th>${staff.telNumber}</th>
    </tr>
    </#list>
</table>
<#else> <h4 style="color:red;">Данный работник не найден!</h4><br>
</#if>
<hr>
<form action="/staff/create" method="get">
   <div class="action"><input type="submit" value="Добавить работника"></div>
</form>
</body>
</html>