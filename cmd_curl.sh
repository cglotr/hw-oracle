curl -X POST http://localhost:8080/surveys \
    -H "Content-Type: application/json" \
    -d '{}' | jq

curl -X POST http://localhost:8080/surveys \
    -H "Content-Type: application/json" \
    -d '{
        "age": -1,
        "gender": "m",
        "region": "Singapore",
        "surveyID": "sid-0",
        "score": 0
}' | jq

curl -X POST http://localhost:8080/surveys \
    -H "Content-Type: application/json" \
    -d '{
        "age": 42,
        "gender": "male",
        "region": "Singapore",
        "surveyID": "sid-0",
        "score": 5
}' | jq

curl http://localhost:8080/surveys \
    -H "Content-Type: application/json" | jq -r '(.[0] | keys) as $keys | $keys, map([.[ $keys[] ]])[] | @csv'
