<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <a href="/supplies" style="text-align: center; text-decoration: none"> Назад </a><hr>
</head>
<body>
<h2>Выбранная поставка</h2><hr>
        <#if supplies.supplied_feedsModelList?has_content>
            Оформленные корма
            <br>
            <table border="1">
                <tr>
                    <th>Название</th>
                    <th>Количество</th>
                    <th>Дата</th>
                </tr>
                <#list supplies.supplied_feedsModelList as suppliedFeed>
                    <tr>
                        <th>${suppliedFeed.id.feed.nameOfFeed}</th>
                        <th>${suppliedFeed.amount}</th>
                        <th>${suppliedFeed.id.supply.dateOfSuppl}</th>
                    </tr>
                </#list>
            </table>
        <#else> Оформленных кормов нет или корм удален<br>
        </#if>
        <#if supplies.supplied_accessoriesModelList?has_content>
            Оформленные аксессуары
            <br>
            <table border="1">
                <tr>
                    <th>Название</th>
                    <th>Количество</th>
                    <th>Дата</th>
                </tr>
            <#list supplies.supplied_accessoriesModelList as suppliedAccessor>
                <tr>
                    <th>${suppliedAccessor.id.accessor.nameOfAccessor}</th>
                    <th>${suppliedAccessor.amount}</th>
                    <th>${suppliedAccessor.id.supply.dateOfSuppl}</th>
                </tr>
            </#list>
            </table>
        <#else> Оформленных аксессуаров нет или аксессуар удален<br>
        </#if>
<hr>
</body>
</html>
