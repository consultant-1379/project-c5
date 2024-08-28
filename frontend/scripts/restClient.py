import os

import requests
from flask import jsonify


class RestClient:

    __base_uri_format = "http://%s:9090/api"

    def __init__(self):
        backend = os.getenv("BACKEND_URI")
        if backend is not None:
            self.__url = format(self.__base_uri_format % backend)
        else:
            self.__url = format(self.__base_uri_format % "localhost")

    def getAllUsers(self):
        url = format("%s/user/" % self.__url)
        response = requests.get(url)
        if response.status_code == 200:
            return response.json()
        else:
            return None

    def getUserById(self, id):
        url = format("%s/user/%s" % (self.__url, id))
        response = requests.get(url)
        if response.status_code == 200:
            return response.json()
        else:
            return None

    def getUserByName(self, fName, lName):
        url = format("%s/user/name?firstName=%s&lastName=%s" % (self.__url, fName, lName))
        response = requests.get(url)
        if response.status_code == 200:
            return response.json()
        else:
            return None

    def addNewUser(self, user):
        url = format("%s/user" % self.__url)
        response = requests.post(url=url, json=user)
        if response.status_code == 201:
            return response.json()
        else:
            return None

    def deleteUser(self, id):
        url = format("%s/user/%s" % (self.__url, id))
        requests.delete(url)

    def getAllQuestions(self):
        url = format("%s/question" % self.__url)
        response = requests.get(url)
        if response.status_code == 200:
            return response.json()
        else:
            return None

    def getQuestionByNumber(self, num):
        url = format("%s/question/%s" % (self.__url, num))
        response = requests.get(url)
        if response.status_code == 200:
            return response.json()
        else:
            return None

    def getQuestionByCategory(self, cat):
        url = format("%s/question/category/%s" % (self.__url, cat))
        response = requests.get(url)
        if response.status_code == 200:
            return response.json()
        else:
            return None

    def addNewQuestion(self, question):
        url = format("%s/question" % self.__url)
        response = requests.post(url=url, json=question)
        if response.status_code == 201:
            return response.json()
        else:
            return None

    def deleteQuestion(self, question):
        url = format("%s/question/%s" % (self.__url, question))
        requests.delete(url=url)
