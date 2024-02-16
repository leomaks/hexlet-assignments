@import exercise.dto.users.UsersPage
@param UsersPage page



@template.layout.page(
content = @`
    <table class="table table-primary table-striped table-bordered table-sm">

        <thead>
        <tr>

            <th scope="col">Id</th>
            <th scope="col">Name</th>



        </tr>
        </thead>

        @for(var user : page.getUsers())
            <tbody>
            <tr>
                <td>${user.getId()} </td>
                <td>  <a href="/users/${user.getId()}">${user.getFirstName() +" "+ user.getLastName()}</a> </td>

            </tr>
            </tbody>
        @endfor
    </table>
`
)
