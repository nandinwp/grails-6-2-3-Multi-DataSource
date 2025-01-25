package wp.nandinwp

import grails.gorm.transactions.Transactional
import wp.domain.geral.User

@Transactional
class UserService {

    void criarUsuarioPadrao() {
        if (User.count() == 0) {
            new User(nome: "Admin", email: "admin@seuapp.com", senha: "admin123").save(flush: true)
        }
    }

    void criarUsuariosPorRegiao() {
        ["rj", "mt", "mg", "es"].each { ds ->
            User.withDatasource(ds) {
                if (User.count() == 0) {
                    new User(nome: "Usuario-${ds.toUpperCase()}", email: "usuario-${ds}@seuapp.com", senha: "senha123").save(flush: true)
                }
            }
        }
    }

    void printarTodosUsuarios() {
        ["DEFAULT", "rj", "mt", "mg", "es"].each { ds ->
            println "Usuarios no datasource ${ds}:"
            User.withDatasource(ds) {
                User.list().each { user ->
                    println "- ${user.nome} (${user.email})"
                }
            }
        }
    }
    List getUsuariosPorRegiao() {
        def usuarios = []
        ["DEFAULT", "rj", "mt", "mg", "es"].each { ds ->
            User.withDatasource(ds) {
                User.list().each { user ->
                    usuarios << [user: user, datasource: ds]
                }
            }
        }
        return usuarios
    }
}
