import requests
import random
import time
import uuid

URL = "http://localhost:8080/surveys"
HEADERS = {"Content-Type": "application/json"}

genders = ["male", "female", "other"]
regions = ["Singapore", "Malaysia", "Indonesia", "Thailand", "Vietnam"]
scores = list(range(1, 6))

while True:
    payload = {
        "age": random.randint(18, 81),
        "gender": random.choice(genders),
        "region": random.choice(regions),
        "surveyID": f"sid-{uuid.uuid4().hex[:8]}",
        "score": random.choice(scores)
    }

    try:
        response = requests.post(URL, json=payload, headers=HEADERS)
        if response.status_code == 200:
            print(f"OK | {response.status_code} | {response.json()}")
        else:
            print(f"ERROR | {response.status_code} | {response.json()["message"]}")
    except Exception as e:
        print(f"EXCEPTION | {e}")

    time.sleep(0.1)
