@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    @if(page.getName() != null)
        ${page.getName().toString()}

        <form action="${NamedRoutes.logoutPath()}" method="delete">
            <input type="submit" class="btn btn-outline-primary" value="Выйти" />
        </form>
    @else
        <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
    @endif
`)