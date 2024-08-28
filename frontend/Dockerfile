FROM python:3.9-alpine3.14
EXPOSE 8080

WORKDIR /app

COPY requirements.txt .
COPY app.py .
COPY main.py .
COPY templates/ templates/
COPY scripts/ scripts/
COPY static/ static/

RUN ["python", "-m", "venv", "frontend"]
RUN ["pip", "install", "-r", "requirements.txt"]
ENTRYPOINT ["flask", "run", "--port=8080", "--host=0.0.0.0"]