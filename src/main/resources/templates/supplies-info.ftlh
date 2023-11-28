<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/table-info.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <hr>
    <div class="ref"><a href="/supplies" style="text-align: center; text-decoration: none"> Назад </a></div>
    <hr>
</head>
<body>
<h2 style="margin-left: 10px">Выбранная поставка</h2><hr>
        <#if supplies.supplied_feedsModelList?has_content>
            <b style="margin-left: 10px">Оформленные корма</b><br>
            <br>
            <table >
                <tr>
                    <th>Название</th>
                    <th>Количество</th>
                    <th>Дата</th>
                </tr>
                <#list supplies.supplied_feedsModelList as suppliedFeed>
                    <tr>
                        <th><a style="text-decoration: none" href="/feeds/${suppliedFeed.id.feed.id_feeds}"></a>${suppliedFeed.id.feed.nameOfFeed}</th>
                        <th>${suppliedFeed.amount}</th>
                        <th>${suppliedFeed.id.supply.dateOfSuppl}</th>
                    </tr>
                </#list>
            </table><br><br>
        <#else><b style="margin-left: 10px">Оформленных кормов нет или корма удалены</b> <br><br>
        </#if>
        <#if supplies.supplied_accessoriesModelList?has_content>
            <b style="margin-left: 10px">Оформленные аксессуары</b><br>

            <br>
            <table>
                <tr>
                    <th>Название</th>
                    <th>Количество</th>
                    <th>Дата</th>
                </tr>
            <#list supplies.supplied_accessoriesModelList as suppliedAccessor>
                <tr>
                    <th><a style="text-decoration: none" href="/accessories/${suppliedAccessor.id.accessor.id_accessories}"></a>${suppliedAccessor.id.accessor.nameOfAccessor}</th>
                    <th>${suppliedAccessor.amount}</th>
                    <th>${suppliedAccessor.id.supply.dateOfSuppl}</th>
                </tr>
            </#list>
            </table>
        <#else>  <b style="margin-left: 10px">Оформленных аксессуаров нет или аксессуары удалены</b><br>
        </#if>
<hr>
</body>
</html>
