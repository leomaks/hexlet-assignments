@import exercise.util.NamedRoutes

@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
content = @`

    @if(page.getError()!= null)
        ${page.getError().toString()}
    @endif

    <form action="${NamedRoutes.loginPath()}" method="post">
    <input type="text" placeholder="Name" name="name" />
    <input type="password" placeholder="Password" name="password" />
    <input type="submit" />
</form>
`)