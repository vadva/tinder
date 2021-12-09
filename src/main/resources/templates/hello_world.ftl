<html>
<body>
<div class="container">
    <p>
        Hello <#if users??>${users.name}</#if>
    </p>

    <div>
        <img style="height: 200px" src="${users.urlPhoto}"/>
    </div>

    <form action="/users" method="post">
        <input type="submit" name="Yes" value="Yes" class="form-control">
        <input type="submit" name="No" value="No" class="form-control">
    </form>
</div>

</body>
</html>