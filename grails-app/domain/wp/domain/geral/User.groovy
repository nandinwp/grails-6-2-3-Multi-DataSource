package wp.domain.geral

class User {
    String nome
    String email
    String senha

    static constraints = {
        nome blank: false, maxSize: 100
        email blank: false, email: true, unique: true
        senha blank: false, password: true, maxSize: 50
    }
    static mapping = {
        table 'usuario'
    }

    static withDatasource(String region, Closure closure) {
        println "Setting datasource for region: $region"

        closure.call()
    }
}
