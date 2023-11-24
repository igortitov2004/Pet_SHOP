<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/feed.css">
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <link rel="stylesheet" type="text/css" href="/style/removeButton.css">
    <link rel="stylesheet" type="text/css" href="/style/searchButton.css">
    <link rel="stylesheet" type="text/css" href="/style/editButtonInTable.css">
    <link rel="stylesheet" type="text/css" href="/style/table.css">
    <hr>
    <h3><div class="ref"><a href="/" style="text-align: center; text-decoration: none"> Главная </a></div> </h3>
    <hr>
</head>
<body>
<form action="/feeds" method="get">
    <input type="text" style="margin-left: 10px" name="nameOfFeed" placeholder="Поиск по названию"><br><br>
    <div class="search"><input type="submit" value="Поиск"/></div>
</form>
<hr>
<#if feeds?has_content>
    <section style="margin-left: 10px; width: 1450px" >
        <div class="tbl-header">
            <table cellpadding="0" cellspacing="0" border="0">
                <thead>
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
                </thead>
            </table>
        </div>
        <div class="tbl-content">
            <table cellpadding="0" cellspacing="0" border="0">
                <tbody>
                <#list feeds as feed>
                <tr>
                    <td style="text-align: center">${feed.id_feeds}</td>
                    <td>${feed.nameOfFeed}</td>
                    <#if feed.animal??>
                        <td>${feed.animal.kindOfAnimal}<br>(${feed.animal.breed.breed})</td>
                    <#else> <td style="color: darkblue">Животное удалено</td>
                    </#if>
                    <td style="text-align: center">${feed.priceOfFeed}</td>
                    <td style="text-align: center">${feed.weightOfFeed}</td>
                    <td>${feed.manufacturerOfFeed}</td>
                    <td style="text-align: center">${feed.amountOfFeeds}</td>
                    <td style="text-align: center"><form action="/feeds/${feed.id_feeds}/edit"  method="get" >
                            <div class="edit"><input type="submit" value="Изменить"></div>
                        </form></td>
                    <#if user.isManager() || user.isCashier()>
                    <td style="text-align: center"><form action="/feeds/delete/${feed.id_feeds}" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <div class="remove"> <input type="submit"  value="Удалить"/></div></form></td></#if>
                 </tr>
                 </#list>
                </tbody>
            </table>
        </div>
    </section>
<#else> <h4 style="color:red;">Данный корм не найден!</h4><br>
</#if>
<br>
<#if user.isManager()>
    <form action="/feeds/create" method="get">
        <div class="action"><input type="submit" value="Добавить корм"></div>
    </form>
</#if>
</body>
</html>