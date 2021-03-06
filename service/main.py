# core modules
from flask import Flask
from flask_restful import Api, Resource
from flask_mysqldb import MySQL
from flask_cors import CORS
from config import api_config
from database.database import mysql

# initializing app
app = Flask(__name__)

app.config['MYSQL_HOST'] = api_config['DB_HOST']
app.config['MYSQL_USER'] = api_config['DB_USER']
app.config['MYSQL_PASSWORD'] = api_config['DB_PASSWORD']
app.config['MYSQL_DB'] = api_config['DB_DB']
app.config['MYSQL_CURSORCLASS'] = 'DictCursor'

api = Api(app)
mysql.init_app(app)
CORS(app)

from datamodels.usermodel import UserModel

# api modules
from routes.user import User
from routes.login import Login
from routes.register import Register

from routes.service import Service
from routes.services import Services
from routes.categories import Categories
from routes.image import Image
from routes.categories import Categories
from routes.category import Category
from routes.providers import Providers
from routes.order import Order
from routes.orders import Orders
from routes.rating import Rating
from routes.messages import Messages
from routes.message import Message

# Route for testing all things in the real scope
from routes.testroute import TestRoute

# default route index
class Index(Resource):
    def get(self):
        return {"message": "Jobster API 0.1 beta" }

api.add_resource(Index, "/")
api.add_resource(User, "/user/<id>")
api.add_resource(Login, "/login")
api.add_resource(Register, "/register")
api.add_resource(Services, "/services")
api.add_resource(Service, "/service/<id>")
api.add_resource(Categories, "/categories")
api.add_resource(Category, "/category/<id>")
api.add_resource(Image, "/image/<id>")
api.add_resource(Providers, "/providers")
api.add_resource(TestRoute, "/test")

api.add_resource(Orders, "/orders")
api.add_resource(Order, "/order/<id>")
api.add_resource(Rating, "/rating/<id>")

api.add_resource(Messages, "/messages")
api.add_resource(Message, "/message/<id>")


def main():
    app.run(host="0.0.0.0", port=5000, debug=True)

if __name__ == '__main__':
    main()
