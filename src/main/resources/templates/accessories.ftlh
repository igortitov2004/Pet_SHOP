<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/accessories.css">
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <link rel="stylesheet" type="text/css" href="/style/removeButton.css">
    <link rel="stylesheet" type="text/css" href="/style/searchButton.css">
    <link rel="stylesheet" type="text/css" href="/style/editButtonInTable.css">
    <link rel="stylesheet" type="text/css" href="/style/table.css">
    <hr>
    <h3><div class="ref"><a href="/" style="text-align: center; text-decoration: none"> Главная </a></div></h3>
    <hr>
</head>
<body>
<form action="/accessories" method="get">
    <input type="text" style="margin-left: 10px" name="nameOfAccessor" placeholder="Поиск по названию"><br><br>
    <div class="search">  <input type="submit" value="Поиск"/></div>
</form>
<hr>
<#if accessories?has_content>
    <section style="margin-left: 10px; width: 1450px" >
        <div class="tbl-header">
            <table cellpadding="0" cellspacing="0" border="0">
                <thead>
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
                </thead>
            </table>
        </div>
        <div class="tbl-content">
            <table cellpadding="0" cellspacing="0" border="0">
                <tbody>
                <#list accessories as accessor>
                <tr>
                    <td style="text-align: center">${accessor.id_accessories}</td>
                    <td>${accessor.nameOfAccessor}</td>
                    <#if accessor.animal??>
                        <td>${accessor.animal.kindOfAnimal}<br>(${accessor.animal.breed.breed})</td>
                    <#else><td style="color: darkblue">Животное удалено</td>
                    </#if>

                    <td style="text-align: center">${accessor.priceOfAccessor}</td>
                    <td>${accessor.manufacturerOfAccessor}</td>
                    <td style="text-align: center">${accessor.amount_of_accessories}</td>
                    <td style="text-align: center"><form action="/accessories/${accessor.id_accessories}/edit"  method="get" >
                            <div class="edit"> <input type="submit" value="Изменить"></div>
                        </form></td>
                    <#if user.isManager() || user.isCashier()>
                    <td style="text-align: center"> <form action="/accessories/delete/${accessor.id_accessories}" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <div class="remove"> <input type="submit"  value="Удалить"/></div></form></td></#if>
        </tr>
        </#list>
                </tbody>
            </table>
        </div>
    </section>
<#else> <h4 style="color: red">Данный аксессуар не найден!</h4><br>
</#if>
<br>
<#if user.isDirector()>
    <br><br><br><br><br><br><br><br><br>
</#if>
<#if user.isManager()>
<form action="/accessories/create" method="get">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
   <div class="action"><input type="submit" value="Добавить аксессуар"/></div>
</form>
</#if>
</body>
</html>