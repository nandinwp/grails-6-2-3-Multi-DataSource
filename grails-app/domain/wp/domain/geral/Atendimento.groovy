package wp.domain.geral

class Atendimento {
    User usuario
    String descricao
    Date dataAtendimento

    static constraints = {
        usuario nullable: false
        descricao blank: false, maxSize: 500
        dataAtendimento nullable: false
    }
}
