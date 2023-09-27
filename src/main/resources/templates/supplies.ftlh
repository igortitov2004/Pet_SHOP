<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>SHOP</title>
    <hr>
    <h3><a href="/" style="text-align: center; text-decoration: none"> Главная </a></h3>
    <hr>
</head>
<body>
<form action="/supplies" method="get">
    <div style="display: inline-flex">Поиск по дате оформления поставки поставки:<input type="date" name="dateOfSuppl">
        <input type="submit" value="Поиск"/></div>
</form>
<br>
<#if supplies?has_content>
    <table border="1">
    <tr>
        <th> ID поставки </th>
        <th> Работник </th>
        <th> Дата поставки </th>
        <th> Подробная инормация </th>
    </tr>
    <#list supplies as supply>
    <#if supply.staff_id_for_suppl??>
    <tr>
        <th>${supply.id_supplies}</th>
        <th>${supply.staff_id_for_suppl.fullName}</th>
        <th>${supply.dateOfSuppl}</th>
        <th><a href="/supplied_things/${supply.id_supplies}">Подробнее...</a></th>
    </tr>
        <#else>
        <tr>
            <th>${supply.id_supplies}</th>
            <th> Работник уволен </th>
            <th>${supply.dateOfSuppl}</th>
            <th><a href="/supplied_things/${supply.id_supplies}">Подробнее...</a></th>
        </tr>
         </#if>
    </#list>
</table>
    <#else> В данный день поставки не оформлялись!
</#if>
<hr>
<#if user.isDirector() || user.isManager()>
    <form action="/supplies/startCreation" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить поставку"/>
</form>
</#if>
</body>
</html>