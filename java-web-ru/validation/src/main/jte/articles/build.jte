@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post">
        <div>
            <label>
                Название статьи
                <input type="text"  class="form-control rounded" placeholder="Введите название"  aria-describedby="search-addon" name="title" value="${page.getTitle()}"/>

            </label>
        </div>
        <div>
            <label>
                Текст статьи
                <textarea class="form-control rounded" placeholder="Введите текст" name="content" value ="${page.getContent()}" > </textarea>
            </label>
        </div>

        <input type="submit" class="btn btn-outline-primary" value="Добавить статью" />
    </form>

`)