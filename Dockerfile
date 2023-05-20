FROM python:3.9
WORKDIR /app
COPY requirements.txt requirements.txt
RUN pip install -r requirements.txt

# COPY . /app

ADD data/building_prices.csv data/
ADD model/model.pkl model/
ADD static/style.css static/
ADD templates/index.html templates/
ADD templates/result.html templates/


COPY app.py app.py

EXPOSE 5000

CMD [ "python3", "-m" , "flask", "run", "--host=127.0.0.1"]


