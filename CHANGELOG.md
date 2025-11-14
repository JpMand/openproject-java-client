# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added
- GitHub Copilot instructions for repository context in `.github/copilot-instructions.md`

## [0.1.0-SNAPSHOT] - 2025-11-13

### Added
- Initial implementation of OpenProject Java Client for API v3
- Core HAL+JSON model classes (`HalResource`, `Link`, `PagedCollection`)
- Pluggable HTTP client architecture with OkHttp as the default
- Multiple authentication methods:
  - API Key authentication via HTTP Basic Auth
  - Bearer Token authentication for OIDC JWT
  - OAuth2 Client Credentials flow with automatic token refresh
- Service interfaces for:
  - Work Packages
  - Users
  - Time Entries
  - Notifications
- Query builder for filters and sorts
- Comprehensive test suite using JUnit 5 and MockWebServer
- Documentation:
  - README.md with quick start guide
  - AUTHENTICATION.md with detailed authentication examples
- GitHub Actions CI/CD workflow with Maven

### Technical Details
- Java 17 as minimum version
- Retrofit 3.0.0 for HTTP client
- OkHttp 5.3.0 for HTTP transport
- Jackson 2.18.3 for JSON processing
- JUnit 5.10.0 for testing

[Unreleased]: https://github.com/JpMand/openproject-java-client/compare/v0.1.0-SNAPSHOT...HEAD
[0.1.0-SNAPSHOT]: https://github.com/JpMand/openproject-java-client/releases/tag/v0.1.0-SNAPSHOT
