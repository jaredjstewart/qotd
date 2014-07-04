package qotd

class QuoteController {
    def scaffold = true

    def home = {
        render "<h1>Real Programmers do not eat Quiche</h1>"
    }
    def random = {
        def allQuotes = Quote.list()
        def randomQuote
        if (allQuotes.size() > 0) {
            def randomIdx = new Random().nextInt(allQuotes.size())
            randomQuote = allQuotes[randomIdx]
        } else {
            randomQuote = new Quote(author: "Anonymous",
                    content: "Real Programmers Don't eat Quiche")
        }
        [ quote : randomQuote]
    }
}
