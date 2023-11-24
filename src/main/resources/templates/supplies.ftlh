<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/searchByDateButton.css">
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <link rel="stylesheet" type="text/css" href="/style/moreInfoButton.css">
    <link rel="stylesheet" type="text/css" href="/style/table.css">
    <hr>
    <h3><div class="ref"><a href="/" style="text-align: center; text-decoration: none"> Главная </a></div> </h3>
    <hr>
</head>
<body>
<form action="/supplies" method="get">
    <div style="display: inline-flex;margin-left: 10px">Поиск по дате оформления поставки поставки:<input type="date" name="dateOfSuppl">
       <div class="search"><input type="submit" value="Поиск"/></div> </div>
</form>
<hr>
<#if supplies?has_content>
    <section style="margin-left: 10px; width: 1000px" >
        <div class="tbl-header">
            <table cellpadding="0" cellspacing="0" border="0">
                <thead>
                <tr>
                    <th> ID поставки </th>
                    <th> Работник </th>
                    <th> Дата поставки </th>
                    <th> Подробная инормация </th>
                </tr>
                </thead>
            </table>
        </div>
        <div class="tbl-content">
            <table cellpadding="0" cellspacing="0" border="0">
                <tbody>
                <#list supplies as supply>
                    <tr>
                        <td style="text-align: center">${supply.id_supplies}</td>
                        <#if supply.staff_id_for_suppl??>
                            <td>${supply.staff_id_for_suppl.fullName}</td>
                        <#else> <td> Работник уволен </td>
                        </#if>
                        <td style="text-align: center">${supply.dateOfSuppl}</td>
                        <td style="text-align: center"><div class="more"><a href="/supplied_things/${supply.id_supplies}">Подробнее...</a></div></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </section>
    <#else> В данный день поставки не оформлялись!
</#if>
<br>
<#if user.isDirector() || user.isManager()>
    <form action="/supplies/startCreation" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div class="action"><input type="submit" value="Добавить поставку"/></div>
</form>
</#if>
</body>
</html>