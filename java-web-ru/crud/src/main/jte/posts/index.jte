@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page


@template.layout.page(
content = @`


    @if(page.getPosts().isEmpty())

        <p>Пока не добавлено ни одного поста</p>
    @else
        <table class="table table-primary table-striped table-bordered table-sm">

            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Пост</th>

            </tr>
            </thead>

            @for(var post: page.getPosts())
                <tbody>
                <tr>
                    <td>${post.getId()}</td>
                    <td><a href="${NamedRoutes.postsPath()}/${post.getId()}">${post.getName()}</a> </td>


                </tr>
                </tbody>
            @endfor
        </table>


                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage()-1}">Previous</a></li>
                        <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}?page=1">1</a></li>
                        <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}?page=2">2</a></li>
                        <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}?page=3">3</a></li>
                        <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage()+1}">Next</a></li>
                    </ul>
                </nav>


         <footer class="p-3 bg-dark text-white">

       <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

                    <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                        <li><a href="/" class="nav-link px-2 text-white">Главная страница</a></li>
                        <li><a href="/posts" class="nav-link px-2 text-white">Все посты</a></li>

                    </ul>
                </div>
        </footer>


    @endif
`)
