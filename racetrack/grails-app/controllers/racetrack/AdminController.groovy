package racetrack

class AdminController {
    def beforeInterceptor = [action:this.&auth]

    def auth() {
        if(!session.user) {
            redirect(controller:"user", action:"login")
            return false
        }
        if(!session.user.admin){
            flash.message = "Tsk tsk—admins only"
            redirect(controller:"race", action:"index")
            return false
        }
    }

    def index = {}
}
