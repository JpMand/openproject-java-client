# OpenProject Java Client

Java HTTP API Client for [OpenProject API v3](https://www.openproject.org/docs/api/).  
Supports HAL+JSON with list/filter/sort of work packages, update operations, notifications, and time logging.

## Features
- HAL+JSON core model (`HalResource`, `Link`, `PagedCollection`)
- Pluggable HTTP client architecture (default OkHttp)
- Multiple authentication methods:
  - API Key via HTTP Basic Auth
  - Username/Password via HTTP Basic Auth
  - OAuth2.0 Client Credentials with automatic token refresh
  - OIDC JWT Bearer tokens
- Service interfaces for Work Packages, Users, Time Entries, Notifications
- QueryBuilder for filters/sorts
- Unit and integration test support with MockWebServer

## Quick Start

### API Key Authentication
```java
import com.github.jpmand.openproject.client.api.OpenProjectClient;
import com.github.jpmand.openproject.client.auth.ApiKeyAuth;

OpenProjectClient client = new OpenProjectClient(
    "https://your-openproject.com",
    new ApiKeyAuth("your-api-key")
);
```

### Other Authentication Methods
See [AUTHENTICATION.md](AUTHENTICATION.md) for detailed examples of:
- Basic authentication (username/password)
- Bearer token authentication (OIDC JWT)
- OAuth2 client credentials flow
- Custom HTTP client factories

## Build

```bash
mvn clean install
```

## Usage

```xml
<dependency>
  <groupId>com.jpmand.openproject</groupId>
  <artifactId>openproject-java-client</artifactId>
  <version>0.1.0-SNAPSHOT</version>
</dependency>
```

## Contributing
Contributions are welcome. Fork the repository, make changes, and open a Pull Request.

## License
[Apache 2.0 License](https://www.apache.org/licenses/LICENSE-2.0)
