<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <link rel="stylesheet" type="text/css" href="/style/moreInfoButton.css">
    <link rel="stylesheet" type="text/css" href="/style/searchByDateButton.css">
    <link rel="stylesheet" type="text/css" href="/style/table.css">
    <hr>
    <h3><div class="ref"><a href="/" style="text-align: center; text-decoration: none"> Главная </a></div></h3>
    <hr>
</head>
<body>
<form action="/sales" method="get">
    <div style="display:inline-flex; margin-left: 10px">Поиск по дате продажи: <input type="date" name="dateOfSale">
        <div class="search"><input type="submit" value="Поиск"/></div> </div>
</form>
<hr>
<#if sales?has_content>
    <section style="margin-left: 10px; width: 1000px" >
        <div class="tbl-header">
            <table cellpadding="0" cellspacing="0" border="0">
                <thead>
                <tr>
                <tr>
                    <th> ID продажи </th>
                    <th> Работник </th>
                    <th> Дата продажи </th>
                    <th> Подробная инормация </th>
                </tr>
                </tr>
                </thead>
            </table>
        </div>
        <div class="tbl-content">
            <table cellpadding="0" cellspacing="0" border="0">
                <tbody>
                <#list sales as sale>

                    <tr>
                        <td style="text-align: center">${sale.id_sales}</td>
                        <#if sale.staff_id_for_sale??>
                            <td>${sale.staff_id_for_sale.fullName}</td>
                        <#else> <td> Работник уволен </td>
                        </#if>
                        <td style="text-align: center">${sale.dateOfSale}</td>
                        <td style="text-align: center"><div class="more" > <a href="/sold_things/${sale.id_sales}" >Подробнее...</a></div></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </section>
<#else> <h4 style="color: red">В данный день продажи не производились!</h4><br>
</#if>
<br>
<#if user.isCashier() || user.isManager()>
    <form action="/sales/startCreation" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
   <div class="action"><input type="submit" value="Добавить продажу"/></div>
    </form>

</#if>

</body>
</html>