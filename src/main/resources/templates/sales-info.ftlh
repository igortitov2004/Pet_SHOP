<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/table-info.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <hr>
    <h3><div class="ref"><a href="/sales" style="text-align: center; text-decoration: none"> Назад </a></div> </h3>
    <hr>
</head>
<body>
<h2 style="margin-left: 10px">Выбранная продажа</h2>
        <#if sales.sold_feedsModelList?has_content>
            <b style="margin-left: 10px">Проданные корма</b>
            <table >
                <tr>
                    <th>Название</th>
                    <th>Количество</th>
                    <th>Дата</th>
                </tr>
            <#list sales.sold_feedsModelList as soldFeed>
                <tr>
                    <th><a style="text-decoration: none" href="/feeds/${soldFeed.id.feed.id_feeds}">${soldFeed.id.feed.nameOfFeed}</a></th>
                    <th>${soldFeed.amount}</th>
                    <th>${soldFeed.id.sale.dateOfSale}</th>
            </tr>
            </#list>
            </table><br><br>
            <#else><b style="margin-left: 10px">Проданных кормов нет или корм удален</b> <br><br>
        </#if>
        <#if sales.sold_accessoriesModelList?has_content>
            <b style="margin-left: 10px">Проданные аксессуары</b>

            <table >
                <tr>
                    <th>Название</th>
                    <th>Количество</th>
                    <th>Дата</th>
                </tr>

            <#list sales.sold_accessoriesModelList as soldAccessor>
                <tr>
                    <th><a style="text-decoration: none" href="/accessories/${soldAccessor.id.accessor.id_accessories}">${soldAccessor.id.accessor.nameOfAccessor}</a> </th>
                    <th>${soldAccessor.amount}</th>
                    <th>${soldAccessor.id.sale.dateOfSale}</th>
                </tr>
            </#list>
            </table>
        <#else> <b style="margin-left: 10px">Проданных аксессуаров нет или аксессуар удален</b>
        </#if>
<hr>
</body>
</html>