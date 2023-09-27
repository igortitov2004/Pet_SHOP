<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
<link rel="stylesheet" type="text/css" href="/style/mainPage.css">

</head>
<body>
<h1>ЗООМАГАЗИН</h1>
    <#if user.isDirector()>
        <h2><a href="/staff" > Работники </a></h2>
    </#if>
   <h2><a href="/sales" > Продажи </a></h2>
    <h2><a href="/supplies" > Поставки </a></h2>
    <h2><a href="/accessories" > Аксессуары </a></h2>
    <h2><a href="/feeds" > Корма </a></h2>
    <h2><a href="/animals" > Животные </a></h2>
    <h2><a href="/login" >Выйти из аккаунта</a></h2>
</body>
</html>