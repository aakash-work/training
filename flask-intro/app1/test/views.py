import json

from flask import Blueprint
from flask import jsonify, request

test = Blueprint('test', __name__)


@test.route('/t1')

def index():

    return "Test 1 passed. You just created a simple API"


@test.route('/t1/<name>', methods=['GET'])
def hello_name(name):
    """

    :param name:
    :return:
    """
    return "Hello {}!".format(name)


@test.route('/input', methods=['POST'])
def receive_json():
    """

    :return:
    """
    content = request.json
    return jsonify(content)

