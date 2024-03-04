@import exercise.dto.posts.PostsPage
@param PostsPage page


@template.layout.page(
page = page,
content = @`


    @if(page.getPosts().isEmpty())
        <p>Пока не добавлено ни одного курса</p>
    @else

        <table class="table table-primary table-striped table-bordered table-sm">

            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Posts</th>

            </tr>
            </thead>

            @for(var post : page.getPosts())
                <tbody>
                <tr>
                    <td>${post.getName()}</td>
                    <td><a href="/posts/${post.getId()}">${post.getName()}</a> </td>
                </tr>
                </tbody>
            @endfor
        </table>

    @endif
`)
