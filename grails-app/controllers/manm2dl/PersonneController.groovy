package manm2dl

class PersonneController {

    PersonneService personneService   // Spring injection

    def create() {
        def personne = personneService.createPersonne(params.firstName, params.lastName, params.address)
        if (personne.hasErrors()) {
            render(view: "create", model: [personne:personne])
        } else {
            redirect(action: 'index')
        }
    }

    def index() {
        render(view:'list', model:[personnes:Personne.list()])
    }
}
