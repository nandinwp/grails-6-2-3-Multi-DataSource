package wp.nandinwp

import wp.domain.geral.User

class AtendimentoController {
    UserService userService

    def index() {
        def usuarios = userService.getUsuariosPorRegiao()

        render(view: "index", model: [usuarios: usuarios])
    }
    def create() {
        // Criação do objeto User
        User user = new User()
        user.nome = "joseDeSouza"
        user.email = "Jose@jose.com"
        user.senha = "1234"

        // Usando o 'withDatasource' para salvar no banco correto
        User.withDatasource("es") {
            // Garantindo que a transação seja gerida corretamente
            User.withTransaction { status ->
                user.save(flush: true)
            }
        }

        // Passando o usuário para a GSP
        render(view: "create", model: [user: user])
    }

}
