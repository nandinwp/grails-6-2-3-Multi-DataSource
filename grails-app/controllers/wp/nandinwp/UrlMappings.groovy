package wp.nandinwp

class UrlMappings {
    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "atendimento", action: "index")
        "/create"(controller: "atendimento", action: "create")
        "500"(view:'/error')
        "404"(view:'/notFound')

    }
}
