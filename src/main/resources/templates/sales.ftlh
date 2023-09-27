<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <hr>
    <h3><a href="/" style="text-align: center; text-decoration: none"> Главная </a></h3>
    <hr>
</head>
<body>
<form action="/sales" method="get">
    <div style="display:inline-flex">Поиск по дате продажи:<input type="date" name="dateOfSale">
        <input type="submit" value="Поиск"/></div>
</form>
<br>
<#if sales?has_content>
    <table border="1">
    <tr>
        <th> ID продажи </th>
        <th> Работник </th>
        <th> Дата продажи </th>
        <th> Подробная инормация </th>
    </tr>
    <#list sales as sale>
         <#if sale.staff_id_for_sale??>
        <tr>
            <th>${sale.id_sales}</th>
            <th>${sale.staff_id_for_sale.fullName}</th>
            <th>${sale.dateOfSale}</th>
            <th><a href="/sold_things/${sale.id_sales}">Подробнее...</a></th>
        </tr>
        <#else>
        <tr>
            <th>${sale.id_sales}</th>
            <th> Работник уволен </th>
            <th>${sale.dateOfSale}</th>
            <th><a href="/sold_things/${sale.id_sales}">Подробнее...</a></th>
        </tr>
         </#if>
    </#list>
</table>
    <#else> В данный день продажи не производились!
</#if>
<hr>
<#if user.isCashier() || user.isManager()>


    <form action="/sales/startCreation" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить продажу"/>
    </form>

</#if>

</body>
</html>