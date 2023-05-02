# app.py
from flask import Flask, render_template, request
import joblib
import numpy as np

app = Flask(__name__)

# Load the pre-trained model
model = joblib.load('model/model.pkl')

# Home page with form
@app.route('/')
def home():
    return render_template('index.html')

# Predict function
@app.route('/predict', methods=['POST'])
def predict():
    # Get the input values from the form
    features = [float(x) for x in request.form.values()]
    price = model.predict([features])[0]
    return render_template('result.html', price=price)
if __name__ == '__main__':
    app.run(debug=True, port=10000)
