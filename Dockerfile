FROM python:3.9
WORKDIR /app
COPY requirements.txt requirements.txt
RUN pip install -r requirements.txt

COPY . /app

EXPOSE 5000

CMD [ "python3", "-m" , "flask", "run", "--host=127.0.0.1"]
