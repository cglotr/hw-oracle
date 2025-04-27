# Homework: ORACLE

## Project Overview

The solution consists of two main components:
1. A Java-based API service built with Dropwizard
2. A Python-based load generator for testing

## Project Structure

```
.
├── src/                 # Java source code
├── script/              # Python load generator
│   ├── load_gen.py      # Load generation script
│   └── requirements.txt # Python dependencies
├── example.yml          # Application configuration
└── pom.xml              # Maven project configuration
```

## Development

1. Make sure you have Maven & Java installed:
```bash
./cmd_prereq.sh
```

1. Run the service:
```bash
./cmd_run.sh
```

The API service will be available at `http://localhost:8080/surveys`

### Load Generator Setup

1. Make sure you have Python3 installed:
```bash
python3 --version
```

1. Run the load generator:
```bash
./cmd_load_gen.sh
```

## Docker

1. Make sure you have Docker installed:
```bash
docker --version
```

1. Build the JAR file:
```bash
mvn package
```

1. Run Docker Compose:
```bash
./cmd_docker_compose.sh
```

## API Endpoints

- `POST /surveys` - Create a new survey
- `GET  /surveys` - Retrieve summary
