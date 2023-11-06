<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <hr>
    <h3><a href="/sales" style="text-align: center; text-decoration: none"> Назад </a></h3>
    <hr>
</head>
<body>
<h2>Выбранная продажа</h2>
        <#if sales.sold_feedsModelList?has_content>
            Проданные корма
            <table border="1">
                <tr>
                    <th>Название</th>
                    <th>Количество</th>
                    <th>Дата</th>
                </tr>


            <#list sales.sold_feedsModelList as soldFeed>
                <tr>
                    <th>${soldFeed.id.feed.nameOfFeed}</th>
                    <th>${soldFeed.amount}</th>
                    <th>${soldFeed.id.sale.dateOfSale}</th>
            </tr>
            </#list>

            </table>
            <#else> Проданных кормов нет или корм удален<br>
        </#if>
        <#if sales.sold_accessoriesModelList?has_content>
            Проданные аксессуары
            <table border="1">
                <tr>
                    <th>Название</th>
                    <th>Количество</th>
                    <th>Дата</th>
                </tr>

            <#list sales.sold_accessoriesModelList as soldAccessor>
                <tr>
                    <th>${soldAccessor.id.accessor.nameOfAccessor}</th>
                    <th>${soldAccessor.amount}</th>
                    <th>${soldAccessor.id.sale.dateOfSale}</th>
                </tr>
            </#list>
            </table>
        <#else> Проданных аксессуаров нет или аксессуар удален<br>
        </#if>
<hr>
</body>
</html>