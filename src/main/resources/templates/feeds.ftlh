<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/feed.css">
    <hr>
    <h3><a href="/" style="text-align: center; text-decoration: none"> Главная </a></h3>
    <hr>
</head>
<body>
<form action="/feeds" method="get">
    <div style="display: inline-flex">Поиск по названию корма:<input type="text" name="nameOfFeed"><br>
        <input type="submit" value="Поиск"/></div>
</form>
<br>
<#if feeds?has_content>
    <table border="1">
    <tr>
        <th> ID корма </th>
        <th> Название </th>
        <th> Животное </th>
        <th> Стоимость </th>
        <th> Вес(кг) </th>
        <th> Производитель </th>
        <th> Количество </th>
        <th> Изменение стоимости </th>
        <#if user.isManager() || user.isCashier()>
        <th> Удаление </th>
        </#if>
    </tr>
    <#list feeds as feed>
        <tr>
            <th>${feed.id_feeds}</th>
            <th>${feed.nameOfFeed}</th>
            <#if feed.animal_id_for_feed??>
                <th>${feed.animal_id_for_feed.kindOfAnimal}(${feed.animal_id_for_feed.breed_id.breed})</th>
            <#else> <th style="color: darkblue">Животное удалено</th>
            </#if>

            <th>${feed.price_of_feed}</th>
            <th>${feed.weight_of_feed}</th>
            <th>${feed.manufacturer_of_feed}</th>
            <th>${feed.amount_of_feeds}</th>
            <th><form action="/feeds/${feed.id_feeds}/edit"  method="get" >
                    <input type="submit" value="Изменить">
                </form></th>
            <#if user.isManager() || user.isCashier()>
            <th><form action="/feeds/delete/${feed.id_feeds}" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit"  value="Удалить"/></form></th></#if>
        </tr>
    </#list>
</table>
<#else> Данный корм не найден!
</#if>
<br>
<#if user.isManager() || user.isCashier()>
    <form action="/feeds/create" method="get">
        <input type="submit" value="Добавить корм">
    </form>
</#if>
</body>
</html>