## Development

### Build
```
mvn package
```

### Running
```
java -jar target/dropwizard-example-4.0.14-SNAPSHOT.jar server example.yml
```

## Python load gen

### One time setup
```
python3 -m venv .venv
pip install -r script/requirements.txt
```

### Start load gen
```
source .venv/bin/activate
python script/load_gen.py
```
