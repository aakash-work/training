from flask import Flask
from app1.test.views import test

flaskDemo = Flask(__name__)

flaskDemo.register_blueprint(test, url_prefix='/test')


