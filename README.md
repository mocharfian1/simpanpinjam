#CURL DOCUMENTATION

### 1. Get List All User
```
curl --location --request GET 'http://localhost:8080/v1/user/' \
--header 'Content-Type: application/json' \
--data '{
    "username": "mocharfian1",
    "password": "arfian"
}'
```
#### Response:****
```
{
    "errorCode": 200,
    "errorMessage": "Success",
    "data": [
        {
            "id": "226ee95f-0f09-48ae-9261-cb45cd8b21b8",
            "name": "Moch Arfian",
            "username": "mocharfian1",
            "password": "arfian"
        },
        {
            "id": "149fef5a-8cb3-4dd1-8f67-b54a9c680f16",
            "name": null,
            "username": "mocharfian",
            "password": null
        }
    ]
}
```
### 2. Get By Id
```
curl --location 'http://localhost:8080/v1/user/id/149fef5a-8cb3-4dd1-8f67-b54a9c680f16'
```

#### Response:
```
{
    "errorCode": 200,
    "errorMessage": "Success",
    "data": {
        "id": "226ee95f-0f09-48ae-9261-cb45cd8b21b8",
        "name": "Moch Arfian",
        "username": "mocharfian1",
        "password": "arfian"
    }
}
```

### 3. Register new User
```
curl --location 'http://localhost:8080/v1/user/register' \
--header 'Content-Type: application/json' \
--data '{
    "username": "mocharfian1",
    "name": "Moch Arfian",
    "password": "arfian"
}'
```
#### Response:
```
{
    "errorCode": 200,
    "errorMessage": "Success",
    "data": {
        "id": "226ee95f-0f09-48ae-9261-cb45cd8b21b8",
        "name": "Moch Arfian",
        "username": "mocharfian1",
        "password": "arfian"
    }
}
```

### 4. Login
```
curl --location 'http://localhost:8080/v1/user/login' \
--header 'Content-Type: application/json' \
--data '{
    "username": "mocharfian1",
    "password": "arfian"
}'
```
#### Response:
```
{
    "errorCode": 200,
    "errorMessage": "Success",
    "data": {
        "id": "226ee95f-0f09-48ae-9261-cb45cd8b21b8",
        "name": "Moch Arfian",
        "username": "mocharfian1",
        "password": "arfian"
    }
}
```