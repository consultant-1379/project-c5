from flask import Flask
import main

from scripts.restClient import RestClient


app = Flask(__name__)
app.register_blueprint(main.bp)

if __name__ == "__main__":
    app.run(ssl_context="adhoc")