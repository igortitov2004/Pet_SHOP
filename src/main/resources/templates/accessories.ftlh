<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/accessories.css">

    <h3><a href="/" style="text-align: center; text-decoration: none"> Главная </a></h3>

</head>
<body>
<form action="/accessories" method="get">
    <div style="display: inline-flex">Поиск по названию аксессуара:<input type="text" name="nameOfAccessor"><br>
        <input type="submit" value="Поиск"/></div>
</form>
<br>
<#if accessories?has_content>
    <table border="1">
    <tr>
        <th> ID аксессуара </th>
        <th> Название </th>
        <th> Животное </th>
        <th> Стоимость </th>
        <th> Производитель </th>
        <th> Количество </th>
        <th> Изменение стоимости </th>
        <#if user.isManager() || user.isCashier()>
        <th> Удаление </th>
        </#if>
    </tr>
    <#list accessories as accessor>
        <tr>
            <th>${accessor.id_accessories}</th>
            <th>${accessor.nameOfAccessor}</th>
            <#if accessor.animal??>
                <th>${accessor.animal.kindOfAnimal}(${accessor.animal.breed.breed})</th>
                <#else><th style="color: darkblue">Животное удалено</th>
            </#if>

            <th>${accessor.priceOfAccessor}</th>
            <th>${accessor.manufacturerOfAccessor}</th>
            <th>${accessor.amount_of_accessories}</th>
            <th><form action="/accessories/${accessor.id_accessories}/edit"  method="get" >
                    <input type="submit" value="Изменить">
                </form></th>
            <#if user.isManager() || user.isCashier()>
            <th> <form action="/accessories/delete/${accessor.id_accessories}" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit"  value="Удалить"/></form></th></#if>
        </tr>
    </#list>
</table>
<#else> Данный аксессуар не найден!
</#if>
<br>
<#if user.isDirector()>
    <br><br><br><br><br><br><br><br><br>
</#if>
<#if user.isManager() || user.isCashier()>
<form action="/accessories/create" method="get">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить аксессуар"/>
</form>
</#if>
</body>
</html>