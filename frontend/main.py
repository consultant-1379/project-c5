import functools
import sys

from flask import (
    Blueprint, flash, g, redirect, render_template, request, session, url_for
)

from scripts.restClient import RestClient

bp = Blueprint('main', __name__, url_prefix='/')
restClient = RestClient()


@bp.route("/")
def home():
    return render_template('index.html')


@bp.route("/index")
def index():
    return render_template('index.html')


@bp.route("/quiz")
def quiz():
    data = restClient.getAllQuestions()
    return render_template('quiz.html', data=data)


@bp.route("/results/<user_id>", methods=['GET'])
def results(user_id):
    user = restClient.getUserById(user_id)
    return render_template('results.html', user=user)


@bp.route("/admin", methods=['GET', 'POST'])
def admin():
    data = {
        'questions': restClient.getAllQuestions(),
        'users': restClient.getAllUsers()
    }
    if request.method == 'GET':
        return render_template('admin.html', data=data)


@bp.route("/admin/<object_id>", methods=['GET'])
def adminDeleteQuestion(object_id):
    restClient.deleteQuestion(object_id)
    data = {
        'questions': restClient.getAllQuestions(),
        'users': restClient.getAllUsers()
    }
    return render_template('admin.html', path="/admin", data=data)


@bp.route("/admin/user/<object_id>", methods=['GET'])
def adminDeleteUser(object_id):
    restClient.deleteUser(object_id)
    data = {
        'questions': restClient.getAllQuestions(),
        'users': restClient.getAllUsers()
    }
    return render_template('admin.html', path="/admin", data=data)
