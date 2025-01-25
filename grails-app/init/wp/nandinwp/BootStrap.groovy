package wp.nandinwp

class BootStrap {
    UserService userService

    def init = { servletContext ->
        userService.criarUsuarioPadrao()
        userService.criarUsuariosPorRegiao()
        userService.printarTodosUsuarios()
    }
    def destroy = {
    }
}