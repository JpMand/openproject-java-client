# OpenProject Java Client

Java HTTP API Client for [OpenProject API v3](https://www.openproject.org/docs/api/).  
Supports HAL+JSON with comprehensive work package operations, project management, and resource access.

## Features
- HAL+JSON core model (`HalResource`, `Link`, `PagedCollection`)
- Pluggable HTTP client architecture (default OkHttp)
- Multiple authentication methods:
  - API Key via HTTP Basic Auth
  - Username/Password via HTTP Basic Auth
  - OAuth2.0 Client Credentials with automatic token refresh
  - OIDC JWT Bearer tokens
- Comprehensive service interfaces:
  - **Work Packages**: Create, read, update, delete, list, filter, form validation
  - **Projects**: Project management and listing
  - **Users**: User retrieval and listing
  - **Types**: Work package type management
  - **Statuses**: Status management
  - **Priorities**: Priority management
  - **Versions**: Version/milestone management (CRUD operations)
  - **Activities**: Activity/comment management
  - **Relations**: Work package relationship management
  - **Time Entries**: Time tracking (CRUD operations)
- QueryBuilder for filters/sorts
- Form validation support for work package creation and updates
- Concurrency control via lockVersion
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

### Working with Work Packages

```java
// Get a work package
OPWorkPackageModel wp = client.getWorkPackage(123);

// Create a new work package
OPWorkPackageModel newWp = new OPWorkPackageModel();
newWp.setSubject("New Task");
// ... set other fields and links
Call<OPWorkPackageModel> createCall = client.workPackages().createWorkPackageInProject(projectId, newWp);
OPWorkPackageModel created = createCall.execute().body();

// Update a work package (requires lockVersion for concurrency control)
wp.setSubject("Updated Subject");
wp.setLockVersion(wp.getLockVersion()); // Must include current lockVersion
Call<OPWorkPackageModel> updateCall = client.workPackages().updateWorkPackage(wp.getId(), wp);
OPWorkPackageModel updated = updateCall.execute().body();

// Delete a work package
Call<Void> deleteCall = client.workPackages().deleteWorkPackage(123L);
deleteCall.execute();

// Validate work package changes before committing
Call<OPForm<OPWorkPackageModel>> formCall = client.workPackages().getWorkPackageForm(123L, wp);
OPForm<OPWorkPackageModel> form = formCall.execute().body();
if (form.getEmbedded().getValidationErrors() != null) {
    // Handle validation errors
}
```

### Working with Users, Types, and Versions

```java
// Get a user
Call<OPUserModel> userCall = client.users().getUser(1L);
OPUserModel user = userCall.execute().body();

// List all types
Call<AbstractOPCollection<OPTypeModel>> typesCall = client.types().listTypes();
AbstractOPCollection<OPTypeModel> types = typesCall.execute().body();

// Create a version
OPVersionModel version = new OPVersionModel();
version.setName("Version 2.0");
// ... set other fields
Call<OPVersionModel> versionCall = client.versions().createVersion(version);
OPVersionModel created = versionCall.execute().body();
```

### Managing Relations and Time Entries

```java
// Create a relation between work packages
OPRelationModel relation = new OPRelationModel();
// ... configure relation
Call<OPRelationModel> relationCall = client.relations().createRelation(relation);

// Log time on a work package
OPTimeEntryModel timeEntry = new OPTimeEntryModel();
// ... set hours, date, work package link
Call<OPTimeEntryModel> timeCall = client.timeEntries().createTimeEntry(timeEntry);
```

## Contributing
Contributions are welcome. Fork the repository, make changes, and open a Pull Request.

## License
[Apache 2.0 License](https://www.apache.org/licenses/LICENSE-2.0)
