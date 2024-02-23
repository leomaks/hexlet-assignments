@import exercise.dto.posts.PostPage
@param PostPage page


@template.layout.page(
content = @`

    <h1>${page.getPost().getName()}</h1>
    <p>${page.getPost().getBody()}</p>

    <footer class="p-3 bg-dark text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="/" class="nav-link px-2 text-white">Главная страница</a></li>
                    <li><a href="/posts" class="nav-link px-2 text-white">Все посты</a></li>

                </ul>
            </div>
        </div>
    </footer>
`
)