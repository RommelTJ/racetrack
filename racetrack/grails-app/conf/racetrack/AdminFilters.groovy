package racetrack

class AdminFilters {

    def filters = {
        adminOnly(controller:'*', action:"(create|edit|update|delete|save)") {
            before = {
                if(!session?.user?.admin) {
                    flash.message = "Sorry, that action is for admins only."
                    redirect(controller:"race", action:"index")
                    return false
                }
            }
        }
    }
}
