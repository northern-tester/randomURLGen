*Generate URLs with Random IDs appended*

This project was inspired by the legendary Danny Dainton, and his testability month and data generator blog post. He reminded my I should put all the crazy little test tools out for the world to see, no matter how context dependent they are. The main thing is to share.

Anyway, this repo contains a Intellij project and associated jar file. The jar file takes the following arguments:

* Number of URLs (space delimited - multiples need to be in quotes)
    * "http://139.59.203.179:9999/ http://139.59.203.179:9999/todos/ http://139.59.203.179:9999/todos//" 
* Filename
    * URLS.txt
* Number of URLs
    * 100
* Max Random Id to Append
    *  5000

To run navigate to wherever the randomURLGen.jar file is (there is an example in the root of this project) in your terminal and enter:

java -jar randomURLs.jar "http://139.59.203.179:9999/ http://139.59.203.179:9999/todos/ http://139.59.203.179:9999/todos//" URLS.txt 100 5000

There is no error handling, pass what you like watch it blow up.

And finally, this README.md was created using http://dillinger.io/ - it rules.