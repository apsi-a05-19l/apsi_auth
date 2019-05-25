# AUTHENTICATION AND AUTHORIZATION BACKEND

## What works?

You can add new user to the database:
```
curl 'http://localhost:8080/addUser?username=john&password=smith&email=john@smith.com'
```
and check if it's really there:
```
curl 'http://localhost:8080/displayUsers'
```

## What doesn't work

After adding user to the database, you would like to log in via web browser typing:
```
http://localhost:8080
```
and you are asked for username and password. Unfortunetaly, username `john` and password `smith` does not work - you are asked to log in again and again and you're not able to go to private endpoint (eg. "/"). It's probably due to security configuration...