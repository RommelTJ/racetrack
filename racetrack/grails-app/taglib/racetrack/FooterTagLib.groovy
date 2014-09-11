package racetrack

class FooterTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    def thisYear = {
        out << new Date().format("yyyy")
    }

    def copyright = {attrs, body->
        out << attrs.startYear + " - "
        out << thisYear() + " " + body()
    }
}
